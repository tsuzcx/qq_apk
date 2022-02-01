package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhotoListLogicBase<K extends AbstractPhotoListActivity, O extends OtherCommonData>
  extends PhotoListLogic<K, O>
  implements PhotoListLogic.IadapterCallback, PhotoListLogic.IcheckBoxCallback, PhotoListLogic.IitemClickCallback
{
  protected PhotoListLogicBase(K paramK)
  {
    super(paramK);
  }
  
  private void addCustomCameraMediaInfo(List<LocalMediaInfo> paramList)
  {
    if (((this.mPhotoListData.isShowCamera) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.mPhotoListData.showCameraInVideo) && (this.mPhotoCommonData.albumId.equals("$VideoAlbumId")) && ((paramList.isEmpty()) || (((LocalMediaInfo)paramList.get(0)).mMediaType != 2))))
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.mMimeType = "mobileqq/camera";
      localLocalMediaInfo.mMediaType = 2;
      paramList.add(0, localLocalMediaInfo);
    }
  }
  
  private void addNewPhotoData(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.mPhotoListData.isShowCamera) && (paramPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.newCaptureMediaInfo.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramList.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
    }
  }
  
  private void addNewVideoData(List<LocalMediaInfo> paramList, PhotoCommonBaseData<O> paramPhotoCommonBaseData, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((this.mPhotoListData.showCameraInVideo) && (paramPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
    {
      paramPhotoCommonBaseData = paramList.iterator();
      while (paramPhotoCommonBaseData.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
        {
          PhotoListBaseData.newCaptureMediaInfo.remove(localLocalMediaInfo.path);
          paramHashMap.remove(localLocalMediaInfo.path);
        }
      }
      paramPhotoCommonBaseData = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
      int i = 0;
      if (paramPhotoCommonBaseData.hasNext())
      {
        paramHashMap = (LocalMediaInfo)paramPhotoCommonBaseData.next();
        if ((paramHashMap == null) || (!"video/mp4".equals(paramHashMap.mMimeType))) {
          break label163;
        }
        paramList.add(i, paramHashMap);
        i += 1;
      }
    }
    label163:
    for (;;)
    {
      break;
      return;
    }
  }
  
  private void handleSelected(LocalMediaInfo paramLocalMediaInfo, PhotoCommonBaseData paramPhotoCommonBaseData, String[] paramArrayOfString, String paramString)
  {
    handleVideoAndGifSelect(paramLocalMediaInfo, paramArrayOfString);
    paramPhotoCommonBaseData.selectedPhotoList.add(paramString);
    paramPhotoCommonBaseData.selectedIndex.add(paramLocalMediaInfo.position);
    if (paramPhotoCommonBaseData.needMediaInfo) {
      paramPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, paramLocalMediaInfo);
    }
    paramPhotoCommonBaseData = this.mActivity.getIntent();
    if (!paramPhotoCommonBaseData.hasExtra("param_initTime")) {
      paramPhotoCommonBaseData.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo.selectStatus = 1;
    paramPhotoCommonBaseData = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    paramLocalMediaInfo = paramPhotoCommonBaseData;
    if (paramPhotoCommonBaseData == null)
    {
      paramLocalMediaInfo = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramLocalMediaInfo);
    }
    paramLocalMediaInfo.put(paramString, Integer.valueOf(this.mActivity.gridLayoutManager.findFirstVisibleItemPosition()));
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (!paramLocalMediaInfo.containsKey(paramString)) {
      paramLocalMediaInfo.put(paramString, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
    }
  }
  
  private void handleSelected(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    handleVideoAndGifSelect(paramLocalMediaInfo, MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType));
    paramArrayList.add(paramString);
    this.mPhotoCommonData.selectedIndex.add(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramString, paramLocalMediaInfo);
    }
    paramArrayList = this.mActivity.getIntent();
    if (!paramArrayList.hasExtra("param_initTime")) {
      paramArrayList.putExtra("param_initTime", System.currentTimeMillis());
    }
    paramLocalMediaInfo = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    paramArrayList = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null)
    {
      paramArrayList = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramArrayList);
    }
    paramArrayList.put(paramString, Integer.valueOf(this.mActivity.gridLayoutManager.findFirstVisibleItemPosition()));
    paramArrayList = QAlbumUtil.sSelectItemAlbum;
    if (!paramArrayList.containsKey(paramString)) {
      paramArrayList.put(paramString, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
    }
  }
  
  private void handleUnSelected(LocalMediaInfo paramLocalMediaInfo, PhotoCommonBaseData paramPhotoCommonBaseData, String[] paramArrayOfString, String paramString)
  {
    if ((this.mPhotoListData.isSupportVideoCheckbox) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.mPhotoListData;
      paramArrayOfString.videoSelectedCnt -= 1;
      if (this.mPhotoListData.videoSelectedCnt == 1) {
        this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramArrayOfString = this.mPhotoListData;
      paramArrayOfString.gifSelectedCount -= 1;
    }
    paramPhotoCommonBaseData.selectedPhotoList.remove(paramLocalMediaInfo.path);
    paramPhotoCommonBaseData.selectedIndex.remove(paramLocalMediaInfo.position);
    if (paramPhotoCommonBaseData.needMediaInfo) {
      paramPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramString);
    }
    paramLocalMediaInfo.selectStatus = 2;
    paramLocalMediaInfo = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo.remove(paramString);
    }
    paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
    if (paramLocalMediaInfo.containsKey(paramString)) {
      paramLocalMediaInfo.remove(paramString);
    }
  }
  
  private void handleUnSelected(ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    Object localObject = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((this.mPhotoListData.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
    {
      localObject = this.mPhotoListData;
      ((PhotoListBaseData)localObject).videoSelectedCnt -= 1;
      if (this.mPhotoListData.videoSelectedCnt == 1) {
        this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      localObject = this.mPhotoListData;
      ((PhotoListBaseData)localObject).gifSelectedCount -= 1;
    }
    paramArrayList.remove(paramString);
    this.mPhotoCommonData.selectedIndex.remove(paramLocalMediaInfo.position);
    if (this.mPhotoCommonData.needMediaInfo) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramString);
    }
    paramArrayList = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
    if (paramArrayList != null) {
      paramArrayList.remove(paramString);
    }
    paramArrayList = QAlbumUtil.sSelectItemAlbum;
    if (paramArrayList.containsKey(paramString)) {
      paramArrayList.remove(paramString);
    }
  }
  
  private void handleVideoAndGifSelect(LocalMediaInfo paramLocalMediaInfo, String[] paramArrayOfString)
  {
    if ((this.mPhotoListData.isSupportVideoCheckbox) && (paramArrayOfString != null) && ("video".equals(paramArrayOfString[0])))
    {
      paramArrayOfString = this.mPhotoListData;
      paramArrayOfString.videoSelectedCnt += 1;
      if (this.mPhotoListData.videoSelectedCnt == 1) {
        this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.mPhotoListData;
      paramLocalMediaInfo.gifSelectedCount += 1;
    }
  }
  
  private boolean isStatusNotChanged(boolean paramBoolean, int paramInt)
  {
    return ((paramInt == 1) && (paramBoolean)) || ((paramInt == 2) && (!paramBoolean));
  }
  
  private void updateMediaList(List<LocalMediaInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt1 < paramList.size())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(paramInt1);
      if (localLocalMediaInfo.path == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((this.mPhotoCommonData.firstVideoInfo == null) && (localLocalMediaInfo.mMediaType == 1)) {
          this.mPhotoCommonData.firstVideoInfo = localLocalMediaInfo;
        }
        int i = QAlbumUtil.getMediaType(localLocalMediaInfo);
        localLocalMediaInfo.position = Integer.valueOf(this.mPhotoCommonData.mediaPathsList.size());
        this.mPhotoCommonData.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.mPhotoCommonData.selectedPhotoList.contains(localLocalMediaInfo.path))
        {
          updateSelectedPhotoList(localLocalMediaInfo, i);
        }
        else if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) && (localLocalMediaInfo.path.equals(this.mPhotoListData.currentPhotoPath)))
        {
          localLocalMediaInfo.selectStatus = 1;
          this.mPhotoCommonData.selectedPhotoList.add(localLocalMediaInfo.path);
          this.mPhotoCommonData.selectedIndex.add(localLocalMediaInfo.position);
          if (this.mPhotoCommonData.needMediaInfo) {
            this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
        else
        {
          updateUnSelectedPhotoList(paramList, paramLong, paramInt2, localLocalMediaInfo);
        }
      }
    }
  }
  
  private void updateSelectStatus(@NonNull AbstractPhotoListActivity.Holder paramHolder, View paramView, LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.selectStatus;
    if (i == 1)
    {
      paramHolder.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(paramLocalMediaInfo.path) + 1);
      if (paramView.getBackground() != null) {
        paramView.setBackgroundDrawable(null);
      }
    }
    while ((this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum) && (i != 1) && (!this.mPhotoListData.isSingleMode))
    {
      paramHolder.mImageView.setAlpha(0.3F);
      return;
      if (i == 3)
      {
        paramHolder.mCheckBox.setChecked(false);
      }
      else
      {
        paramHolder.mCheckBox.setChecked(false);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
    }
    paramHolder.mImageView.setAlpha(1.0F);
  }
  
  private void updateSelectedPhotoList(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramLocalMediaInfo.selectStatus = 1;
    if (!this.mPhotoCommonData.selectedIndex.contains(paramLocalMediaInfo.position)) {
      this.mPhotoCommonData.selectedIndex.add(paramLocalMediaInfo.position);
    }
    if ((this.mPhotoListData.isSupportVideoCheckbox) && (paramInt == 1))
    {
      PhotoListBaseData localPhotoListBaseData = this.mPhotoListData;
      localPhotoListBaseData.videoSelectedCnt += 1;
      if (this.mPhotoListData.videoSelectedCnt == 1) {
        this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
      }
    }
    if ((this.mPhotoListData.isShowCamera) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(paramLocalMediaInfo.path))) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramLocalMediaInfo.path, paramLocalMediaInfo);
    }
    if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
    {
      paramLocalMediaInfo = this.mPhotoListData;
      paramLocalMediaInfo.gifSelectedCount += 1;
    }
  }
  
  private void updateUnSelectedPhotoList(List<LocalMediaInfo> paramList, long paramLong, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((this.mPhotoListData.isRecodeLastAlbumPath) && (paramLong <= 60000L) && (paramInt == paramList.size()) && (paramLocalMediaInfo.path.equals(QAlbumUtil.sLastAlbumPath)))
    {
      paramLocalMediaInfo.selectStatus = 3;
      return;
    }
    paramLocalMediaInfo.selectStatus = 2;
  }
  
  protected boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = false;
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.mPhotoListData.isSupportVideoCheckbox) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (isStatusNotChanged(paramBoolean, i));
      if ((i != 2) || (!paramBoolean) || (localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.mPhotoListData.lastTimeShowToast < 700L);
    QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 1000).b(this.mActivity.mTitleBarHeight);
    this.mPhotoListData.lastTimeShowToast = l;
    this.mPhotoListData.hasShownMaxSelectToast = true;
    return false;
    this.mPhotoListData.hasShownMaxSelectToast = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean) {
      handleSelected(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    }
    for (;;)
    {
      paramLocalMediaInfo = this.mActivity;
      if (!paramBoolean) {
        bool = true;
      }
      paramLocalMediaInfo.selectLimitRemind(bool);
      return true;
      handleUnSelected(paramLocalMediaInfo, localPhotoCommonBaseData, arrayOfString, str);
    }
  }
  
  public void caseCamera(View paramView, int paramInt) {}
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = this.mActivity.photoListAdapter.getItem(paramInt);
    Intent localIntent = this.mActivity.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = this.mActivity.gridLayoutManager.findFirstVisibleItemPosition();
    if (this.mPhotoCommonData.needMediaInfo)
    {
      if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(paramView.path)) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramView.path, paramView);
      }
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    localIntent.setClass(this.mActivity, this.mActivity.getJumpActivity());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public void caseSingleModeImage(View paramView, int paramInt) {}
  
  public void caseVideo(View paramView, int paramInt)
  {
    paramView = this.mActivity.photoListAdapter.getItem(paramInt);
    if (paramView == null) {}
    do
    {
      return;
      this.mActivity.getIntent();
      localObject1 = QAlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(paramView.path))
      {
        localObject2 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        ((HashMap)localObject1).put(paramView.path, localObject2);
      }
      this.mActivity.recordLastPos(paramView.path);
    } while (this.mPhotoListData.isSingleMode);
    paramView = this.mActivity.getIntent();
    paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    Object localObject1 = this.mActivity.photoListAdapter.getItem(paramInt);
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = this.mActivity.gridLayoutManager.findFirstVisibleItemPosition();
    Object localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
    }
    paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
    paramView.setClass(this.mActivity, this.mActivity.getJumpActivity());
    paramView.addFlags(603979776);
    this.mActivity.startActivity(paramView);
    this.mActivity.finish();
    QAlbumUtil.anim(this.mActivity, true, true);
  }
  
  void doOnDestroy()
  {
    if (!this.mPhotoListData.backPressed) {
      AlbumThumbManager.getInstance(this.mActivity).clear();
    }
    if (this.mActivity.photoListAdapter != null)
    {
      int i = this.mActivity.photoListAdapter.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.mPhotoCommonData.albumId, Integer.valueOf(i));
    }
    if (this.mActivity.queryPhotoTask != null) {
      this.mActivity.queryPhotoTask.cancel(true);
    }
    close();
  }
  
  void doOnResume()
  {
    if (this.mPhotoListData.needQueryTask)
    {
      this.mActivity.runOnUiThread(new PhotoListLogicBase.1(this));
      return;
    }
    this.mPhotoListData.needQueryTask = true;
  }
  
  protected void enterAlbumListFragment(Intent paramIntent)
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList;
    HashMap localHashMap1 = this.mPhotoCommonData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.mPhotoCommonData.needMediaInfo)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.mPhotoCommonData.allMediaInfoHashMap != null) {
          localObject = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
        }
        if (localObject != null)
        {
          localHashMap2.put(str, localObject);
        }
        else
        {
          localObject = (LocalMediaInfo)localHashMap1.get(str);
          if (localObject != null) {
            localHashMap2.put(str, localObject);
          }
        }
      }
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    }
  }
  
  protected void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    }
    for (;;)
    {
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      PhotoListBaseData.sPhotoListFirstPos = this.mActivity.gridLayoutManager.findFirstVisibleItemPosition();
      paramIntent.setClass(this.mActivity, this.mActivity.getJumpActivity());
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      QAlbumUtil.anim(this.mActivity, true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.mPhotoListData.currentPhotoPath);
    }
  }
  
  protected String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    return this.mActivity.getResources().getString(2131694869, new Object[] { Integer.valueOf(i) });
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseCamera(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    return paramHolder;
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseImage(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    Object localObject1 = paramHolder.itemView;
    paramHolder.checkBoxListener.setPosition(paramInt);
    paramHolder.checkBoxListener.setCheckBox(paramHolder.mCheckBox);
    ImageView localImageView = paramHolder.mImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.mActivity.photoListAdapter.getItem(paramInt);
    Object localObject2 = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramHolder.mImageView.setContentDescription((CharSequence)localObject2);
    if (localLocalMediaInfo != null)
    {
      paramHolder.mImageViewPanoramaIcon.setVisibility(4);
      if ((!this.mPhotoListData.showGifTypeIcon) || (!this.mActivity.isGif(localLocalMediaInfo))) {
        break label432;
      }
      if (paramHolder.mImageType == null)
      {
        paramHolder.mImageType = this.mActivity.photoListAdapter.newImageTypeView();
        paramHolder.mImageType.setText("GIF");
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)paramHolder.itemView).addView(paramHolder.mImageType, (ViewGroup.LayoutParams)localObject2);
      }
      paramHolder.mImageType.setVisibility(0);
    }
    for (;;)
    {
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      localObject2 = paramHolder.mDrawable;
      StringBuilder localStringBuilder = new StringBuilder("albumthumb");
      localStringBuilder.append("://");
      localStringBuilder.append(localLocalMediaInfo.path);
      if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
      {
        localObject2 = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),image url :" + ((URL)localObject2).toString());
        }
        localObject2 = URLDrawableHelper.getDrawable((URL)localObject2, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
        ((URLDrawable)localObject2).setTag(localLocalMediaInfo);
        localImageView.setImageDrawable((Drawable)localObject2);
        ((URLImageView)localImageView).setURLDrawableDownListener(this.mActivity.photoListAdapter);
        paramHolder.mDrawable = ((URLDrawable)localObject2);
      }
      updateSelectStatus(paramHolder, (View)localObject1, localLocalMediaInfo);
      if (AppSetting.d)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, localLocalMediaInfo, paramInt, paramHolder.mCheckBox.isChecked());
        paramHolder.mCheckBox.setContentDescription((CharSequence)localObject1);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      processViewCaseImage(paramHolder, localLocalMediaInfo);
      return paramHolder;
      label432:
      if (paramHolder.mImageType != null) {
        paramHolder.mImageType.setVisibility(8);
      }
    }
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseVideo(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    paramHolder.checkBoxListener.setPosition(paramInt);
    paramHolder.checkBoxListener.setCheckBox(paramHolder.mCheckBox);
    ImageView localImageView = paramHolder.mImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.mActivity.photoListAdapter.getItem(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramHolder.mImageView.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo.isSystemMeidaStore)
    {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = paramHolder.mDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + ((URL)localObject).toString());
        }
        localObject = URLDrawableHelper.getDrawable((URL)localObject, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
        ((URLDrawable)localObject).setTag(localLocalMediaInfo);
        localImageView.setImageDrawable((Drawable)localObject);
        ((URLImageView)localImageView).setURLDrawableDownListener(this.mActivity.photoListAdapter);
        paramHolder.mDrawable = ((URLDrawable)localObject);
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      localObject = paramHolder.mTextView;
      if ((localLocalMediaInfo.isSystemMeidaStore) || (localLocalMediaInfo.mDuration > 0L)) {
        break label322;
      }
      ((TextView)localObject).setVisibility(8);
      localObject = MediaScanner.getInstance(BaseApplication.getContext());
      if (localObject != null) {
        ((MediaScanner)localObject).queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
    }
    for (;;)
    {
      updateSelectStatus(paramHolder, paramHolder.itemView, localLocalMediaInfo);
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      return paramHolder;
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break;
      label322:
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
    }
  }
  
  protected void handlePicCapture(Intent paramIntent) {}
  
  protected void handleVideoCapture(Intent paramIntent) {}
  
  protected void handleVideoEncodeSucceed(Message paramMessage) {}
  
  protected void initData(Intent paramIntent)
  {
    this.mPhotoListData.isRecodeLastAlbumPath = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.mPhotoListData.olderAlbumId = this.mPhotoCommonData.albumId;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.mPhotoListData.isRecodeLastAlbumPath) && (l1 - l2 < 60000L)) {
        this.mPhotoCommonData.albumName = QAlbumUtil.sLastAlbumName;
      }
    }
    for (this.mPhotoCommonData.albumId = QAlbumUtil.sLastAlbumId;; this.mPhotoCommonData.albumId = paramIntent.getStringExtra("ALBUM_ID"))
    {
      if (this.mPhotoCommonData.albumId == null)
      {
        this.mPhotoCommonData.albumId = "$RecentAlbumId";
        this.mPhotoCommonData.albumName = null;
      }
      this.mPhotoListData.isSupportVideoCheckbox = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.mPhotoListData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.mPhotoCommonData.selectedPhotoList = ((ArrayList)localObject);
      }
      if (this.mPhotoCommonData.selectedPhotoList == null) {
        this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      }
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.mPhotoCommonData.selectedPhotoList.size() == ((HashMap)localObject).size()))
      {
        this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
        this.mPhotoCommonData.selectedMediaInfoHashMap.putAll((Map)localObject);
      }
      this.mPhotoCommonData.selectedIndex = new ArrayList();
      this.mPhotoCommonData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.mPhotoListData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.mPhotoListData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      if (this.mPhotoCommonData.maxSelectNum > 1) {
        this.mPhotoListData.isSingleMode = false;
      }
      this.mPhotoCommonData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.mPhotoCommonData.filter = MediaFileFilter.getFilter(this.mPhotoCommonData.showMediaType);
      this.mPhotoCommonData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.mPhotoCommonData.filterVideoGif)
      {
        this.mPhotoCommonData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.mPhotoCommonData.showMediaType = 1;
      }
      this.mPhotoListData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.mPhotoListData.isShowCamera = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.mPhotoListData.isShowCamera) {
        this.mPhotoListData.showCameraInVideo = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.mPhotoListData.photoListStartPos = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.needMediaInfo = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.mPhotoListData.filterVideoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      return;
      this.mPhotoCommonData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    }
  }
  
  protected boolean needVedio()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mPhotoListData.requestCode = paramInt1;
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    enterPhotoPreviewActivity(true, this.mActivity.getIntent());
  }
  
  protected void onBackPressed()
  {
    this.mPhotoListData.backPressed = true;
    onTitleBtnCancelClick(null);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    int i = 2;
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.mPhotoListData.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int j;
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      localLocalMediaInfo = this.mActivity.photoListAdapter.getItem(paramInt);
      j = localLocalMediaInfo.selectStatus;
      if ((j == 1) || (paramView.size() < this.mPhotoCommonData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.mPhotoListData.lastTimeShowToast < 1000L);
    QQToast.a(this.mActivity, getExceedMaxSelectNumStr(localLocalMediaInfo), 0).b(this.mActivity.mTitleBarHeight);
    paramCheckBox.setChecked(false);
    this.mPhotoListData.lastTimeShowToast = l;
    return;
    if (j == 1)
    {
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label264;
      }
      bool1 = true;
      label188:
      paramCheckBox = localLocalMediaInfo.path;
      if (!bool1) {
        break label270;
      }
      handleSelected(paramView, localLocalMediaInfo, paramCheckBox);
      label207:
      if (this.mSelectionListener != null) {
        this.mSelectionListener.onSelectionChange(bool1, localLocalMediaInfo);
      }
      this.mActivity.updateCheckbox(paramInt, bool1);
      paramView = this.mActivity;
      if (bool1) {
        break label281;
      }
    }
    label264:
    label270:
    label281:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.selectLimitRemind(bool1);
      return;
      i = 1;
      break;
      bool1 = false;
      break label188;
      handleUnSelected(paramView, localLocalMediaInfo, paramCheckBox);
      break label207;
    }
  }
  
  protected void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void onPreviewBtnClick(View paramView)
  {
    enterPhotoPreviewActivity(false, this.mActivity.getIntent());
  }
  
  protected void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void onQueryMediaListBack(List<LocalMediaInfo> paramList)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.mPhotoCommonData;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    Object localObject = localPhotoCommonBaseData.selectedPhotoList;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    this.mPhotoListData.videoSelectedCnt = 0;
    this.mPhotoListData.gifSelectedCount = 0;
    if (this.mPhotoCommonData.allMediaInfoHashMap == null)
    {
      this.mPhotoCommonData.allMediaInfoHashMap = new HashMap();
      if (this.mPhotoCommonData.mediaPathsList == null) {
        break label231;
      }
      this.mPhotoCommonData.mediaPathsList.clear();
    }
    for (;;)
    {
      addNewPhotoData(paramList, localPhotoCommonBaseData, (HashMap)localObject);
      addNewVideoData(paramList, localPhotoCommonBaseData, (HashMap)localObject);
      return;
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((this.mPhotoCommonData.allMediaInfoHashMap.containsKey(str)) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str))) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, this.mPhotoCommonData.allMediaInfoHashMap.get(str));
        }
      }
      localPhotoCommonBaseData.allMediaInfoHashMap.clear();
      break;
      label231:
      this.mPhotoCommonData.mediaPathsList = new ArrayList();
    }
  }
  
  protected boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    if (this.mActivity == null) {
      return false;
    }
    if (paramList == null)
    {
      Object localObject;
      if ((!this.mPhotoListData.isShowCamera) || (!this.mPhotoCommonData.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.mPhotoListData.showCameraInVideo)
        {
          localObject = paramList;
          if (!this.mPhotoCommonData.albumId.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.mActivity.photoListAdapter.setPhotoList((List)localObject);
      this.mActivity.photoListAdapter.notifyDataSetChanged();
      updateButton();
      QQToast.a(this.mActivity, "暂无媒体文件", 1000).a();
      return false;
    }
    this.mActivity.photoListAdapter.setPhotoList(paramList);
    if (paramList.isEmpty()) {
      QQToast.a(this.mActivity, "暂无媒体文件", 1000).a();
    }
    this.mActivity.photoListAdapter.notifyDataSetChanged();
    updateButton();
    return true;
  }
  
  protected void onSendBtnClick(View paramView) {}
  
  protected void onTitleBtnCancelClick(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    this.mActivity.finish();
    QAlbumUtil.anim(this.mActivity, false, false);
  }
  
  protected void postInitUI()
  {
    View localView = this.mActivity.bottomBar;
    if (this.mPhotoListData.isSingleMode) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      this.mActivity.sendBtn.setOnClickListener(this.mActivity);
      return;
    }
  }
  
  protected void processViewCaseImage(AbstractPhotoListActivity.Holder paramHolder, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected List<LocalMediaInfo> queryDoInBackground(Object... paramVarArgs)
  {
    if ((this.mPhotoCommonData.mMediaQueryHelper == null) || (!this.mPhotoCommonData.albumId.equals(this.mPhotoListData.olderAlbumId))) {
      this.mPhotoCommonData.createMediaQueryHelper(this.mActivity);
    }
    this.mPhotoCommonData.mMediaQueryHelper.queryNext();
    if (this.mPhotoCommonData.firstRecentInfo == null)
    {
      this.mPhotoCommonData.firstRecentInfo = this.mPhotoCommonData.mMediaQueryHelper.getFirstInfo();
      this.mPhotoCommonData.mMediaQueryHelper.upDateCount();
      if ((this.mPhotoCommonData.recentCountLimit <= 0) || (this.mPhotoCommonData.recentCountLimit >= this.mPhotoCommonData.mMediaQueryHelper.cursorsCount)) {
        break label217;
      }
    }
    label217:
    for (this.mPhotoCommonData.recentCount = this.mPhotoCommonData.recentCountLimit;; this.mPhotoCommonData.recentCount = this.mPhotoCommonData.mMediaQueryHelper.cursorsCount)
    {
      this.mPhotoCommonData.videoCount = this.mPhotoCommonData.mMediaQueryHelper.cursorsVideoCount;
      paramVarArgs = this.mPhotoCommonData.mMediaQueryHelper.mediaList;
      onQueryMediaListBack(paramVarArgs);
      updateAddData(paramVarArgs, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
      }
      addCustomCameraMediaInfo(paramVarArgs);
      return paramVarArgs;
    }
  }
  
  protected void startPhotoPreviewActivity(Intent paramIntent)
  {
    this.mActivity.startActivity(paramIntent);
    this.mActivity.finish();
  }
  
  protected void updateAddData(List<LocalMediaInfo> paramList, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = QAlbumUtil.sLastAlbumRecordTime;
    int i = 0;
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(this.mPhotoCommonData.albumId)) {
      i = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(this.mPhotoCommonData.albumId)).intValue();
    }
    int j = paramList.size();
    updateMediaList(paramList, paramInt, l1 - l2, i);
    if (needVedio()) {
      if (paramInt < j)
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(paramInt);
        if (localLocalMediaInfo.path == null) {}
        for (;;)
        {
          paramInt += 1;
          break;
          this.mPhotoCommonData.allMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        }
      }
    }
  }
  
  protected void updateButton()
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    String str1;
    if (this.mPhotoListData.customSendBtnText != null)
    {
      str1 = this.mPhotoListData.customSendBtnText;
      if (localArrayList.size() <= 0) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      String str2 = str1;
      if (bool) {
        str2 = str1 + "(" + localArrayList.size() + ")";
      }
      this.mActivity.sendBtn.setText(str2);
      this.mActivity.sendBtn.setEnabled(bool);
      this.mActivity.previewBtn.setEnabled(bool);
      return;
      str1 = this.mActivity.getString(2131694852);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase
 * JD-Core Version:    0.7.0.1
 */