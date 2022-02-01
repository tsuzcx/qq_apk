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
import beyq;
import bhnn;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
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
  
  protected boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = this.mPhotoCommonData;
    Object localObject2 = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.mPhotoListData.isSupportVideoCheckbox) && (localObject2 != null) && (!"image".equals(localObject2[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (((PhotoCommonBaseData)localObject1).selectedPhotoList.size() < ((PhotoCommonBaseData)localObject1).maxSelectNum)) {
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
    if (paramBoolean)
    {
      if ((this.mPhotoListData.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.mPhotoListData;
        ((PhotoListBaseData)localObject2).videoSelectedCnt += 1;
        if (this.mPhotoListData.videoSelectedCnt == 1) {
          this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.mPhotoListData;
        ((PhotoListBaseData)localObject2).gifSelectedCount += 1;
      }
      ((PhotoCommonBaseData)localObject1).selectedPhotoList.add(str);
      ((PhotoCommonBaseData)localObject1).selectedIndex.add(paramLocalMediaInfo.position);
      if (((PhotoCommonBaseData)localObject1).needMediaInfo) {
        ((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
      }
      localObject1 = this.mActivity.getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      localObject1 = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      paramLocalMediaInfo = (LocalMediaInfo)localObject1;
      if (localObject1 == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        QAlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(str, Integer.valueOf(this.mActivity.gridLayoutManager.findFirstVisibleItemPosition()));
      paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      paramLocalMediaInfo = this.mActivity;
      if (paramBoolean) {
        break label693;
      }
    }
    label693:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramLocalMediaInfo.selectLimitRemind(paramBoolean);
      return true;
      if ((this.mPhotoListData.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.mPhotoListData;
        ((PhotoListBaseData)localObject2).videoSelectedCnt -= 1;
        if (this.mPhotoListData.videoSelectedCnt == 1) {
          this.mPhotoListData.selectedVideoInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.mPhotoListData;
        ((PhotoListBaseData)localObject2).gifSelectedCount -= 1;
      }
      ((PhotoCommonBaseData)localObject1).selectedPhotoList.remove(paramLocalMediaInfo.path);
      ((PhotoCommonBaseData)localObject1).selectedIndex.remove(paramLocalMediaInfo.position);
      if (((PhotoCommonBaseData)localObject1).needMediaInfo) {
        ((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap.remove(str);
      }
      paramLocalMediaInfo.selectStatus = 2;
      paramLocalMediaInfo = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(str);
      }
      paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        break;
      }
      paramLocalMediaInfo.remove(str);
      break;
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
  
  protected void doOnDestroy()
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
  
  protected void doOnResume()
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
    return this.mActivity.getResources().getString(2131694317, new Object[] { Integer.valueOf(i) });
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
    int i;
    if (localLocalMediaInfo != null)
    {
      paramHolder.mImageViewPanoramaIcon.setVisibility(4);
      if ((!this.mPhotoListData.showGifTypeIcon) || (!this.mActivity.isGif(localLocalMediaInfo))) {
        break label517;
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
      i = AlbumThumbDownloader.THUMB_WIDHT;
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
        localObject2 = beyq.a((URL)localObject2, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
        ((URLDrawable)localObject2).setTag(localLocalMediaInfo);
        localImageView.setImageDrawable((Drawable)localObject2);
        ((URLImageView)localImageView).setURLDrawableDownListener(this.mActivity.photoListAdapter);
        paramHolder.mDrawable = ((URLDrawable)localObject2);
      }
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label536;
      }
      paramHolder.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1);
      if (((View)localObject1).getBackground() != null) {
        ((View)localObject1).setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, localLocalMediaInfo, paramInt, paramHolder.mCheckBox.isChecked());
        paramHolder.mCheckBox.setContentDescription((CharSequence)localObject1);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      processViewCaseImage(paramHolder, localLocalMediaInfo);
      if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
        break label577;
      }
      paramHolder.mImageView.setAlpha(0.3F);
      return paramHolder;
      label517:
      if (paramHolder.mImageType == null) {
        break;
      }
      paramHolder.mImageType.setVisibility(8);
      break;
      label536:
      if (i == 3)
      {
        paramHolder.mCheckBox.setChecked(false);
      }
      else
      {
        paramHolder.mCheckBox.setChecked(false);
        if (((View)localObject1).getBackground() != null) {
          ((View)localObject1).setBackgroundDrawable(null);
        }
      }
    }
    label577:
    paramHolder.mImageView.setAlpha(1.0F);
    return paramHolder;
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseVideo(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    View localView = paramHolder.itemView;
    paramHolder.checkBoxListener.setPosition(paramInt);
    paramHolder.checkBoxListener.setCheckBox(paramHolder.mCheckBox);
    ImageView localImageView = paramHolder.mImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = this.mActivity.photoListAdapter.getItem(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramHolder.mImageView.setContentDescription((CharSequence)localObject);
    int i;
    if (localLocalMediaInfo.isSystemMeidaStore)
    {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = paramHolder.mDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + ((URL)localObject).toString());
        }
        localObject = beyq.a((URL)localObject, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
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
        break label411;
      }
      ((TextView)localObject).setVisibility(8);
      localObject = MediaScanner.getInstance(BaseApplication.getContext());
      if (localObject != null) {
        ((MediaScanner)localObject).queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
      label288:
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label433;
      }
      paramHolder.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1);
      if (localView.getBackground() != null) {
        localView.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
        break label474;
      }
      paramHolder.mImageView.setAlpha(0.3F);
      return paramHolder;
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break;
      label411:
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
      break label288;
      label433:
      if (i == 3)
      {
        paramHolder.mCheckBox.setChecked(false);
      }
      else
      {
        paramHolder.mCheckBox.setChecked(false);
        if (localView.getBackground() != null) {
          localView.setBackgroundDrawable(null);
        }
      }
    }
    label474:
    paramHolder.mImageView.setAlpha(1.0F);
    return paramHolder;
  }
  
  protected void handlePicCapture(Intent paramIntent) {}
  
  protected void handleVideoCapture(Intent paramIntent) {}
  
  public void handleVideoEncodeSucceed(Message paramMessage) {}
  
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
    label188:
    String str;
    if (j == 1)
    {
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label547;
      }
      bool1 = true;
      str = localLocalMediaInfo.path;
      if (!bool1) {
        break label553;
      }
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.mPhotoListData.isSupportVideoCheckbox) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.mPhotoListData;
        paramCheckBox.videoSelectedCnt += 1;
        if (this.mPhotoListData.videoSelectedCnt == 1) {
          this.mPhotoListData.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        paramCheckBox = this.mPhotoListData;
        paramCheckBox.gifSelectedCount += 1;
      }
      paramView.add(str);
      this.mPhotoCommonData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
      paramView = this.mActivity.getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramCheckBox = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        QAlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(this.mActivity.gridLayoutManager.findFirstVisibleItemPosition()));
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      label490:
      if (this.mSelectionListener != null) {
        this.mSelectionListener.onSelectionChange(bool1, localLocalMediaInfo);
      }
      this.mActivity.updateCheckbox(paramInt, bool1);
      paramView = this.mActivity;
      if (bool1) {
        break label758;
      }
    }
    label547:
    label553:
    label758:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.selectLimitRemind(bool1);
      return;
      i = 1;
      break;
      bool1 = false;
      break label188;
      paramCheckBox = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.mPhotoListData.isSupportVideoCheckbox) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.mPhotoListData;
        paramCheckBox.videoSelectedCnt -= 1;
        if (this.mPhotoListData.videoSelectedCnt == 1) {
          this.mPhotoListData.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        paramCheckBox = this.mPhotoListData;
        paramCheckBox.gifSelectedCount -= 1;
      }
      paramView.remove(str);
      this.mPhotoCommonData.selectedIndex.remove(localLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
      }
      paramView = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        break label490;
      }
      paramView.remove(str);
      break label490;
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
    int i = 0;
    Object localObject2 = this.mPhotoCommonData;
    if (((PhotoCommonBaseData)localObject2).selectedPhotoList == null) {
      ((PhotoCommonBaseData)localObject2).selectedPhotoList = new ArrayList();
    }
    Object localObject1 = ((PhotoCommonBaseData)localObject2).selectedPhotoList;
    if (((PhotoCommonBaseData)localObject2).selectedMediaInfoHashMap == null) {
      ((PhotoCommonBaseData)localObject2).selectedMediaInfoHashMap = new HashMap();
    }
    localObject1 = ((PhotoCommonBaseData)localObject2).selectedMediaInfoHashMap;
    bhnn.a();
    this.mPhotoListData.videoSelectedCnt = 0;
    this.mPhotoListData.gifSelectedCount = 0;
    if (this.mPhotoCommonData.allMediaInfoHashMap == null)
    {
      this.mPhotoCommonData.allMediaInfoHashMap = new HashMap();
      if (this.mPhotoCommonData.mediaPathsList == null) {
        break label323;
      }
      this.mPhotoCommonData.mediaPathsList.clear();
    }
    label123:
    Object localObject3;
    for (;;)
    {
      if ((this.mPhotoListData.isShowCamera) && (((PhotoCommonBaseData)localObject2).albumId.equals("$RecentAlbumId")))
      {
        localObject3 = paramList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject4).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
              continue;
              localObject3 = this.mPhotoCommonData.selectedPhotoList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                if ((this.mPhotoCommonData.allMediaInfoHashMap.containsKey(localObject4)) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localObject4))) {
                  this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject4, this.mPhotoCommonData.allMediaInfoHashMap.get(localObject4));
                }
              }
              ((PhotoCommonBaseData)localObject2).allMediaInfoHashMap.clear();
              break;
              label323:
              this.mPhotoCommonData.mediaPathsList = new ArrayList();
              break label123;
            }
          }
        }
        paramList.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
      }
    }
    if ((this.mPhotoListData.showCameraInVideo) && (((PhotoCommonBaseData)localObject2).albumId.equals("$VideoAlbumId")))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LocalMediaInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject3).path)))
        {
          PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject3).path);
          ((HashMap)localObject1).remove(((LocalMediaInfo)localObject3).path);
        }
      }
      localObject1 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
        if ((localObject2 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject2).mMimeType))) {
          break label523;
        }
        paramList.add(i, localObject2);
        i += 1;
      }
    }
    label523:
    for (;;)
    {
      break;
      return;
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
        break label318;
      }
    }
    label318:
    for (this.mPhotoCommonData.recentCount = this.mPhotoCommonData.recentCountLimit;; this.mPhotoCommonData.recentCount = this.mPhotoCommonData.mMediaQueryHelper.cursorsCount)
    {
      this.mPhotoCommonData.videoCount = this.mPhotoCommonData.mMediaQueryHelper.cursorsVideoCount;
      paramVarArgs = this.mPhotoCommonData.mMediaQueryHelper.mediaList;
      onQueryMediaListBack(paramVarArgs);
      updateAddData(paramVarArgs, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
      }
      if (((this.mPhotoListData.isShowCamera) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.mPhotoListData.showCameraInVideo) && (this.mPhotoCommonData.albumId.equals("$VideoAlbumId")) && ((paramVarArgs.isEmpty()) || (((LocalMediaInfo)paramVarArgs.get(0)).mMediaType != 2))))
      {
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.mMimeType = "mobileqq/camera";
        localLocalMediaInfo.mMediaType = 2;
        paramVarArgs.add(0, localLocalMediaInfo);
      }
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
    if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(this.mPhotoCommonData.albumId)) {}
    for (int i = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(this.mPhotoCommonData.albumId)).intValue();; i = 0)
    {
      int k = paramList.size();
      int j = paramInt;
      Object localObject;
      if (j < paramList.size())
      {
        localObject = (LocalMediaInfo)paramList.get(j);
        if (((LocalMediaInfo)localObject).path == null) {}
        for (;;)
        {
          j += 1;
          break;
          if ((this.mPhotoCommonData.firstVideoInfo == null) && (((LocalMediaInfo)localObject).mMediaType == 1)) {
            this.mPhotoCommonData.firstVideoInfo = ((LocalMediaInfo)localObject);
          }
          int m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject);
          ((LocalMediaInfo)localObject).position = Integer.valueOf(this.mPhotoCommonData.mediaPathsList.size());
          this.mPhotoCommonData.mediaPathsList.add(((LocalMediaInfo)localObject).path);
          if (this.mPhotoCommonData.selectedPhotoList.contains(((LocalMediaInfo)localObject).path))
          {
            ((LocalMediaInfo)localObject).selectStatus = 1;
            if (!this.mPhotoCommonData.selectedIndex.contains(((LocalMediaInfo)localObject).position)) {
              this.mPhotoCommonData.selectedIndex.add(((LocalMediaInfo)localObject).position);
            }
            if ((this.mPhotoListData.isSupportVideoCheckbox) && (m == 1))
            {
              PhotoListBaseData localPhotoListBaseData = this.mPhotoListData;
              localPhotoListBaseData.videoSelectedCnt += 1;
              if (this.mPhotoListData.videoSelectedCnt == 1) {
                this.mPhotoListData.selectedVideoInfo = ((LocalMediaInfo)localObject);
              }
            }
            if ((this.mPhotoListData.isShowCamera) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
              this.mPhotoCommonData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject).path, localObject);
            }
            if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject).mMimeType)))
            {
              localObject = this.mPhotoListData;
              ((PhotoListBaseData)localObject).gifSelectedCount += 1;
            }
          }
          else if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) && (((LocalMediaInfo)localObject).path.equals(this.mPhotoListData.currentPhotoPath)))
          {
            ((LocalMediaInfo)localObject).selectStatus = 1;
            this.mPhotoCommonData.selectedPhotoList.add(((LocalMediaInfo)localObject).path);
            this.mPhotoCommonData.selectedIndex.add(((LocalMediaInfo)localObject).position);
            if (this.mPhotoCommonData.needMediaInfo) {
              this.mPhotoCommonData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject).path, localObject);
            }
          }
          else if ((this.mPhotoListData.isRecodeLastAlbumPath) && (l1 - l2 <= 60000L) && (i == paramList.size()) && (((LocalMediaInfo)localObject).path.equals(QAlbumUtil.sLastAlbumPath)))
          {
            ((LocalMediaInfo)localObject).selectStatus = 3;
          }
          else
          {
            ((LocalMediaInfo)localObject).selectStatus = 2;
          }
        }
      }
      if (needVedio()) {
        if (paramInt < k)
        {
          localObject = (LocalMediaInfo)paramList.get(paramInt);
          if (((LocalMediaInfo)localObject).path == null) {}
          for (;;)
          {
            paramInt += 1;
            break;
            this.mPhotoCommonData.allMediaInfoHashMap.put(((LocalMediaInfo)localObject).path, localObject);
          }
        }
      }
      return;
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
      str1 = this.mActivity.getString(2131694302);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase
 * JD-Core Version:    0.7.0.1
 */