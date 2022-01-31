package com.tencent.mobileqq.activity.photo.album;

import aimj;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baul;
import bddw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhotoListLogicBase<K extends AbstractPhotoListActivity>
  extends PhotoListLogic<K>
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
      if ((i != 2) || (!paramBoolean) || (((aimj)localObject1).selectedPhotoList.size() < ((aimj)localObject1).maxSelectNum)) {
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
      ((aimj)localObject1).selectedPhotoList.add(str);
      ((aimj)localObject1).selectedIndex.add(paramLocalMediaInfo.position);
      if (((aimj)localObject1).needMediaInfo) {
        ((aimj)localObject1).selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
      }
      if (this.mPhotoListData.cancelPresendPathSet.contains(str)) {
        this.mPhotoListData.cancelPresendPathSet.remove(str);
      }
      this.mPhotoListData.presendPathSet.add(str);
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
      paramLocalMediaInfo.put(str, Integer.valueOf(this.mActivity.mGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = QAlbumUtil.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      paramLocalMediaInfo = this.mActivity;
      if (paramBoolean) {
        break label784;
      }
    }
    label784:
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
      ((aimj)localObject1).selectedPhotoList.remove(paramLocalMediaInfo.path);
      ((aimj)localObject1).selectedIndex.remove(paramLocalMediaInfo.position);
      if (((aimj)localObject1).needMediaInfo) {
        ((aimj)localObject1).selectedMediaInfoHashMap.remove(str);
      }
      if (this.mPhotoListData.presendPathSet.contains(paramLocalMediaInfo.path)) {
        this.mPhotoListData.presendPathSet.remove(paramLocalMediaInfo.path);
      }
      for (;;)
      {
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
        this.mPhotoListData.cancelPresendPathSet.add(paramLocalMediaInfo.path);
      }
    }
  }
  
  public void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.mActivity.photoListAdapter.getItem(paramInt);
    paramView = this.mActivity.getIntent();
    paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    if (QAlbumUtil.getMediaType(paramAdapterView) == 0) {
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramAdapterView.position);
    }
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = this.mActivity.mGridView.getFirstVisiblePosition();
    if (this.mPhotoCommonData.needMediaInfo)
    {
      if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(paramAdapterView.path)) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramAdapterView.path, paramAdapterView);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    paramView.setClass(this.mActivity, this.mActivity.getJumpActivity());
    paramView.addFlags(603979776);
    return paramView;
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.mActivity.photoListAdapter.getItem(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      this.mActivity.getIntent();
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(paramAdapterView.path))
      {
        localObject = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramView.put(paramAdapterView.path, localObject);
      }
      this.mActivity.recordLastPos(paramAdapterView.path);
    } while (this.mPhotoListData.isSingleMode);
    paramAdapterView = this.mActivity.getIntent();
    paramAdapterView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    paramAdapterView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    paramView = this.mActivity.photoListAdapter.getItem(paramInt);
    paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    paramAdapterView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramAdapterView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = this.mActivity.mGridView.getFirstVisiblePosition();
    Object localObject = this.mPhotoCommonData.selectedMediaInfoHashMap;
    if (!((HashMap)localObject).containsKey(paramView.path)) {
      ((HashMap)localObject).put(paramView.path, paramView);
    }
    paramAdapterView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject);
    paramAdapterView.setClass(this.mActivity, this.mActivity.getJumpActivity());
    paramAdapterView.addFlags(603979776);
    this.mActivity.startActivity(paramAdapterView);
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
      int i = this.mActivity.photoListAdapter.getCount();
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
      PhotoListBaseData.sPhotoListFirstPos = this.mActivity.mGridView.getFirstVisiblePosition();
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
    return this.mActivity.getResources().getString(2131695258, new Object[] { Integer.valueOf(i) });
  }
  
  protected List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.mPhotoListData.filter, this.mPhotoListData.filterVideoDurationLimit);
    bddw.a("PEAK", "getAlbumMedias");
    List localList1 = localList2;
    if (localList2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localList1 = null;
    }
    return localList1;
  }
  
  public View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ImageView(this.mActivity);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.mActivity.mImageWidth, this.mActivity.mImageHeight));
    }
    for (;;)
    {
      paramViewGroup = (ImageView)paramView;
      paramView.setBackgroundColor(-16777216);
      paramViewGroup.setImageResource(2130841169);
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER);
      return paramView;
    }
  }
  
  public View getViewCaseImage(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    if (paramView == null)
    {
      paramViewGroup = this.mActivity.photoListAdapter.mInflater.inflate(2131561138, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.mActivity.mImageWidth, this.mActivity.mImageHeight));
      paramHolder.mImageView = ((ImageView)paramViewGroup.findViewById(2131371876));
      paramHolder.mImageViewPanoramaIcon = ((ImageView)paramViewGroup.findViewById(2131371837));
      paramHolder.mMaskView = ((ImageView)paramViewGroup.findViewById(2131368523));
      paramHolder.mSelectedIconView = ((ImageView)paramViewGroup.findViewById(2131371881));
      paramHolder.mSelectedBtn = paramViewGroup.findViewById(2131371878);
      paramHolder.mCheckBox = ((NumberCheckBox)paramViewGroup.findViewById(2131371879));
      paramHolder.mPhotoFlagView = ((ImageView)paramViewGroup.findViewById(2131371807));
      paramHolder.mPhotoFlagView.setVisibility(8);
      if (this.mPhotoCommonData.maxSelectNum > 100) {
        paramHolder.mCheckBox.setTextSize(10.0F);
      }
      paramHolder.checkBoxListener = paramCheckBoxClickedListener;
      if (paramHolder.mSelectedBtn != null) {
        paramHolder.mSelectedBtn.setOnClickListener(paramHolder.checkBoxListener);
      }
      paramViewGroup.setTag(paramHolder);
      paramView = paramViewGroup;
      if (!this.mPhotoListData.isSingleMode)
      {
        paramHolder.mSelectedBtn.setVisibility(0);
        paramView = paramViewGroup;
      }
    }
    for (;;)
    {
      paramHolder.checkBoxListener.setPosition(paramInt);
      paramHolder.checkBoxListener.setCheckBox(paramHolder.mCheckBox);
      paramCheckBoxClickedListener = paramHolder.mImageView;
      paramCheckBoxClickedListener.setAdjustViewBounds(false);
      paramViewGroup = this.mActivity.photoListAdapter.getItem(paramInt);
      paramView.setContentDescription(QAlbumUtil.createContentDescription(0, paramViewGroup, paramInt));
      int i;
      if (paramViewGroup != null)
      {
        paramHolder.mImageViewPanoramaIcon.setVisibility(4);
        if ((!this.mPhotoListData.showGifTypeIcon) || (!this.mActivity.isGif(paramViewGroup))) {
          break label746;
        }
        if (paramHolder.mImageType == null)
        {
          paramHolder.mImageType = this.mActivity.photoListAdapter.newImageTypeView();
          paramHolder.mImageType.setText("GIF");
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout)paramView).addView(paramHolder.mImageType, (ViewGroup.LayoutParams)localObject);
        }
        paramHolder.mImageType.setVisibility(0);
        i = AlbumThumbDownloader.THUMB_WIDHT;
        paramViewGroup.thumbHeight = i;
        paramViewGroup.thumbWidth = i;
        Object localObject = paramHolder.mDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramViewGroup.path);
        if ((localObject == null) || (!((URLDrawable)localObject).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject = QAlbumUtil.generateAlbumThumbURL(paramViewGroup);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),image url :" + ((URL)localObject).toString());
          }
          localObject = baul.a((URL)localObject, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
          ((URLDrawable)localObject).setTag(paramViewGroup);
          paramCheckBoxClickedListener.setImageDrawable((Drawable)localObject);
          ((URLImageView)paramCheckBoxClickedListener).setURLDrawableDownListener(this.mActivity.photoListAdapter);
          paramHolder.mDrawable = ((URLDrawable)localObject);
        }
        i = paramViewGroup.selectStatus;
        if (i != 1) {
          break label767;
        }
        paramHolder.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(paramViewGroup.path) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
      for (;;)
      {
        if (AppSetting.c)
        {
          paramCheckBoxClickedListener = QAlbumUtil.createContentDescriptionWithCheckBox(0, paramViewGroup, paramInt, paramHolder.mCheckBox.isChecked());
          paramHolder.mCheckBox.setContentDescription(paramCheckBoxClickedListener);
        }
        paramViewGroup.visableTime = SystemClock.uptimeMillis();
        paramViewGroup.listViewPosition = paramInt;
        processViewCaseImage(paramHolder, paramViewGroup);
        if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
          break label809;
        }
        paramHolder.mImageView.setAlpha(0.3F);
        return paramView;
        label746:
        if (paramHolder.mImageType == null) {
          break;
        }
        paramHolder.mImageType.setVisibility(8);
        break;
        label767:
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
      label809:
      paramHolder.mImageView.setAlpha(1.0F);
      return paramView;
    }
  }
  
  public View getViewCaseVideo(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = this.mActivity.photoListAdapter.mInflater.inflate(2131561375, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.mActivity.mImageWidth, this.mActivity.mImageHeight));
      paramHolder.mImageView = ((ImageView)paramView.findViewById(2131371876));
      paramHolder.mTextView = ((TextView)paramView.findViewById(2131371882));
      paramHolder.mMaskView = ((ImageView)paramView.findViewById(2131368523));
      paramHolder.mSelectedIconView = ((ImageView)paramView.findViewById(2131371881));
      paramHolder.mSelectedBtn = paramView.findViewById(2131371878);
      paramHolder.mCheckBox = ((NumberCheckBox)paramView.findViewById(2131371879));
      if (this.mPhotoCommonData.maxSelectNum > 100) {
        paramHolder.mCheckBox.setTextSize(10.0F);
      }
      paramHolder.checkBoxListener = paramCheckBoxClickedListener;
      if (paramHolder.mSelectedBtn != null) {
        paramHolder.mSelectedBtn.setOnClickListener(paramHolder.checkBoxListener);
      }
      paramView.setTag(paramHolder);
      paramViewGroup = paramView;
      if (!this.mPhotoListData.isSingleMode)
      {
        paramViewGroup = paramView;
        if (this.mPhotoListData.isSupportVideoCheckbox)
        {
          paramHolder.mSelectedBtn.setVisibility(0);
          paramViewGroup = paramView;
        }
      }
    }
    paramHolder.checkBoxListener.setPosition(paramInt);
    paramHolder.checkBoxListener.setCheckBox(paramHolder.mCheckBox);
    ImageView localImageView = paramHolder.mImageView;
    localImageView.setAdjustViewBounds(false);
    paramCheckBoxClickedListener = this.mActivity.photoListAdapter.getItem(paramInt);
    paramViewGroup.setContentDescription(QAlbumUtil.createContentDescription(1, paramCheckBoxClickedListener, paramInt));
    int i;
    if (paramCheckBoxClickedListener.isSystemMeidaStore)
    {
      paramView = QAlbumUtil.generateAlbumThumbURL(paramCheckBoxClickedListener, "VIDEO");
      i = AlbumThumbDownloader.THUMB_WIDHT;
      paramCheckBoxClickedListener.thumbHeight = i;
      paramCheckBoxClickedListener.thumbWidth = i;
      URLDrawable localURLDrawable = paramHolder.mDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramView)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + paramView.toString());
        }
        paramView = baul.a(paramView, this.mActivity.photoListAdapter.colorDrawable, this.mActivity.photoListAdapter.mDefaultPhotoDrawable);
        paramView.setTag(paramCheckBoxClickedListener);
        localImageView.setImageDrawable(paramView);
        ((URLImageView)localImageView).setURLDrawableDownListener(this.mActivity.photoListAdapter);
        paramHolder.mDrawable = paramView;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      paramView = paramHolder.mTextView;
      if ((paramCheckBoxClickedListener.isSystemMeidaStore) || (paramCheckBoxClickedListener.mDuration > 0L)) {
        break label625;
      }
      paramView.setVisibility(8);
      paramView = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (paramView != null) {
        paramView.queryMediaInfoDuration(this, paramCheckBoxClickedListener, paramInt);
      }
      label500:
      i = paramCheckBoxClickedListener.selectStatus;
      if (i != 1) {
        break label645;
      }
      paramHolder.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(paramCheckBoxClickedListener.path) + 1);
      if (paramViewGroup.getBackground() != null) {
        paramViewGroup.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      paramCheckBoxClickedListener.visableTime = SystemClock.uptimeMillis();
      paramCheckBoxClickedListener.listViewPosition = paramInt;
      if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
        break label687;
      }
      paramHolder.mImageView.setAlpha(0.3F);
      return paramViewGroup;
      paramView = QAlbumUtil.generateAlbumThumbURL(paramCheckBoxClickedListener, "APP_VIDEO");
      break;
      label625:
      paramView.setVisibility(0);
      paramView.setText(AbstractPhotoListActivity.formatTimeToString(paramCheckBoxClickedListener.mDuration));
      break label500;
      label645:
      if (i == 3)
      {
        paramHolder.mCheckBox.setChecked(false);
      }
      else
      {
        paramHolder.mCheckBox.setChecked(false);
        if (paramViewGroup.getBackground() != null) {
          paramViewGroup.setBackgroundDrawable(null);
        }
      }
    }
    label687:
    paramHolder.mImageView.setAlpha(1.0F);
    return paramViewGroup;
  }
  
  protected void handlePicCapture(Intent paramIntent) {}
  
  protected void handleVideoCapture(Intent paramIntent) {}
  
  public void handleVideoEncodeSucceed(Message paramMessage) {}
  
  protected void initData(Intent paramIntent)
  {
    this.mPhotoListData.isRecodeLastAlbumPath = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
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
      this.mPhotoListData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.mPhotoListData.filter = MediaFileFilter.getFilter(this.mPhotoListData.showMediaType);
      this.mPhotoListData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.mPhotoListData.filterVideoGif)
      {
        this.mPhotoListData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.mPhotoListData.showMediaType = 1;
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
      paramView.put(str, Integer.valueOf(this.mActivity.mGridView.getFirstVisiblePosition()));
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
  
  protected boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    if (this.mActivity == null) {
      return false;
    }
    Object localObject;
    if (paramList == null)
    {
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
    if (((this.mPhotoListData.isShowCamera) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.mPhotoListData.showCameraInVideo) && (this.mPhotoCommonData.albumId.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
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
  
  protected void processQueryResult(List<LocalMediaInfo> paramList) {}
  
  protected void processViewCaseImage(AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected List<LocalMediaInfo> queryPhotoList()
  {
    aimj localaimj = this.mPhotoCommonData;
    if (localaimj.selectedPhotoList == null) {
      localaimj.selectedPhotoList = new ArrayList();
    }
    Object localObject3 = localaimj.selectedPhotoList;
    if (localaimj.selectedMediaInfoHashMap == null) {
      localaimj.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject2 = localaimj.selectedMediaInfoHashMap;
    bddw.a();
    Object localObject1 = getLocalMediaInfos();
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      this.mPhotoListData.videoSelectedCnt = 0;
      this.mPhotoListData.gifSelectedCount = 0;
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localaimj.albumId)) {}
      for (int j = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localaimj.albumId)).intValue();; j = 0)
      {
        Object localObject4;
        Object localObject5;
        if ((this.mPhotoListData.isShowCamera) && (localaimj.albumId.equals("$RecentAlbumId")))
        {
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (LocalMediaInfo)((Iterator)localObject4).next();
            if ((localObject5 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject5).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject5).path);
              ((HashMap)localObject2).remove(((LocalMediaInfo)localObject5).path);
            }
          }
          ((List)localObject1).addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
        }
        int i;
        if ((this.mPhotoListData.showCameraInVideo) && (localaimj.albumId.equals("$VideoAlbumId")))
        {
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (LocalMediaInfo)((Iterator)localObject4).next();
            if ((localObject5 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject5).path)))
            {
              PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject5).path);
              ((HashMap)localObject2).remove(((LocalMediaInfo)localObject5).path);
            }
          }
          localObject4 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
          i = 0;
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (LocalMediaInfo)((Iterator)localObject4).next();
            if ((localObject5 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject5).mMimeType))) {
              break label1037;
            }
            ((List)localObject1).add(i, localObject5);
            i += 1;
          }
        }
        label1027:
        label1037:
        for (;;)
        {
          break;
          processQueryResult((List)localObject1);
          int k = ((List)localObject1).size();
          localObject4 = new ArrayList(k);
          i = 0;
          if (i < ((List)localObject1).size())
          {
            localObject5 = (LocalMediaInfo)((List)localObject1).get(i);
            if (((LocalMediaInfo)localObject5).path == null) {}
            for (;;)
            {
              i += 1;
              break;
              int m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject5);
              ((LocalMediaInfo)localObject5).position = Integer.valueOf(((ArrayList)localObject4).size());
              ((ArrayList)localObject4).add(((LocalMediaInfo)localObject5).path);
              if (((ArrayList)localObject3).contains(((LocalMediaInfo)localObject5).path))
              {
                ((LocalMediaInfo)localObject5).selectStatus = 1;
                if (!localaimj.selectedIndex.contains(((LocalMediaInfo)localObject5).position)) {
                  localaimj.selectedIndex.add(((LocalMediaInfo)localObject5).position);
                }
                if ((this.mPhotoListData.isSupportVideoCheckbox) && (m == 1))
                {
                  PhotoListBaseData localPhotoListBaseData = this.mPhotoListData;
                  localPhotoListBaseData.videoSelectedCnt += 1;
                  if (this.mPhotoListData.videoSelectedCnt == 1) {
                    this.mPhotoListData.selectedVideoInfo = ((LocalMediaInfo)localObject5);
                  }
                }
                if ((this.mPhotoListData.isShowCamera) && (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject5).path))) {
                  ((HashMap)localObject2).put(((LocalMediaInfo)localObject5).path, localObject5);
                }
                if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject5).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject5).mMimeType)))
                {
                  localObject5 = this.mPhotoListData;
                  ((PhotoListBaseData)localObject5).gifSelectedCount += 1;
                }
              }
              else if ((((ArrayList)localObject3).size() < localaimj.maxSelectNum) && (((LocalMediaInfo)localObject5).path.equals(this.mPhotoListData.currentPhotoPath)))
              {
                ((LocalMediaInfo)localObject5).selectStatus = 1;
                ((ArrayList)localObject3).add(((LocalMediaInfo)localObject5).path);
                localaimj.selectedIndex.add(((LocalMediaInfo)localObject5).position);
                if (localaimj.needMediaInfo) {
                  ((HashMap)localObject2).put(((LocalMediaInfo)localObject5).path, localObject5);
                }
              }
              else if ((this.mPhotoListData.isRecodeLastAlbumPath) && (l1 - l2 <= 60000L) && (j == ((List)localObject1).size()) && (((LocalMediaInfo)localObject5).path.equals(QAlbumUtil.sLastAlbumPath)))
              {
                ((LocalMediaInfo)localObject5).selectStatus = 3;
              }
              else
              {
                ((LocalMediaInfo)localObject5).selectStatus = 2;
              }
            }
          }
          if (needVedio())
          {
            if (localaimj.allMediaInfoHashMap == null)
            {
              localaimj.allMediaInfoHashMap = new HashMap();
              i = 0;
              label891:
              if (i >= k) {
                break label1027;
              }
              localObject2 = (LocalMediaInfo)((List)localObject1).get(i);
              if (((LocalMediaInfo)localObject2).path != null) {
                break label1008;
              }
            }
            for (;;)
            {
              i += 1;
              break label891;
              localObject3 = ((ArrayList)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject5 = (String)((Iterator)localObject3).next();
                if ((localaimj.allMediaInfoHashMap.containsKey(localObject5)) && (!((HashMap)localObject2).containsKey(localObject5))) {
                  ((HashMap)localObject2).put(localObject5, localaimj.allMediaInfoHashMap.get(localObject5));
                }
              }
              localaimj.allMediaInfoHashMap.clear();
              break;
              label1008:
              localaimj.allMediaInfoHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
            }
          }
          localaimj.mediaPathsList = ((ArrayList)localObject4);
          return localObject1;
        }
      }
    }
  }
  
  protected void startPhotoPreviewActivity(Intent paramIntent)
  {
    this.mActivity.startActivity(paramIntent);
    this.mActivity.finish();
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
      str1 = this.mActivity.getString(2131695243);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase
 * JD-Core Version:    0.7.0.1
 */