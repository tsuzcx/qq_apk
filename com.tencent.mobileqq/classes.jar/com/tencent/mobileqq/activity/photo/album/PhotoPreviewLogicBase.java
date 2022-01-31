package com.tencent.mobileqq.activity.photo.album;

import aiqf;
import aiqn;
import aiqo;
import aiqy;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bayu;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhotoPreviewLogicBase<K extends AbstractPhotoPreviewActivity>
  extends PhotoPreviewLogic<K>
  implements PhotoPreviewLogic.IimageAdapterCallback, PhotoPreviewLogic.IonCheckedChangedCallback
{
  protected PhotoPreviewLogicBase(K paramK)
  {
    super(paramK);
    this.mImageAdapterCallback = this;
    this.mOnCheckedChangedCallback = this;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (localObject != null)
        {
          localObject = new File((String)localObject);
          URLDrawable.removeMemoryCacheByUrl(((File)localObject).toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(((File)localObject).toURL().toString() + "#NOSAMPLE");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
      if (this.mActivity.mVideoPlayController != null) {
        this.mActivity.mVideoPlayController.k();
      }
      this.mActivity.mVideoPlayController = null;
      close();
    }
  }
  
  protected void doOnResume()
  {
    if ((this.mPhotoPreviewData.showBar) && (this.mActivity.topBar != null)) {
      this.mActivity.topBar.setVisibility(0);
    }
    if (this.mActivity.mVideoPlayController != null) {
      this.mActivity.mVideoPlayController.j();
    }
  }
  
  public void flashPicCheckedChanged(boolean paramBoolean) {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (paramView != null) {
      return paramView;
    }
    Object localObject3 = this.mActivity.adapter.getItem(paramInt);
    int i;
    label38:
    View localView;
    Object localObject1;
    if (this.mActivity.getMediaType((String)localObject3) == 1)
    {
      i = 1;
      URLDrawable localURLDrawable = (URLDrawable)this.mPhotoPreviewData.activeDrawable.get(paramInt);
      if (i == 0) {
        break label181;
      }
      localView = this.mActivity.getLayoutInflater().inflate(2131561155, null);
      localView.setTag(2131296400, Boolean.valueOf(true));
      localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localObject1 = (ImageView)localView.findViewById(2131372258);
      label111:
      Object localObject4 = new File((String)localObject3);
      localObject4 = this.mActivity.getFileUrl((File)localObject4);
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1) || (!localURLDrawable.getURL().equals(localObject4))) {
        break label200;
      }
      ((ImageView)localObject1).setImageDrawable(localURLDrawable);
    }
    for (;;)
    {
      if (i == 0) {
        break label477;
      }
      return localView;
      i = 0;
      break label38;
      label181:
      localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      localView = null;
      break label111;
      label200:
      if (localObject3 == null) {
        break;
      }
      paramView = new File((String)localObject3);
      if (paramView.exists())
      {
        if (i != 0)
        {
          paramView = this.mActivity.getMediaInfo((String)localObject3);
          int k = paramViewGroup.getWidth();
          int j = paramViewGroup.getHeight();
          if (paramView.mediaWidth > paramView.mediaHeight)
          {
            k = paramViewGroup.getHeight();
            j = paramViewGroup.getWidth();
          }
          paramViewGroup = QAlbumUtil.generateAlbumThumbURL(paramView, "FLOW_THUMB");
          if (paramViewGroup != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.mActivity.getCoverDrawable(paramViewGroup.toString(), k, j, paramView));
            paramView = localObject2;
          }
        }
        for (;;)
        {
          if (paramView == null) {
            break label463;
          }
          ((ImageView)localObject1).setImageDrawable(paramView);
          this.mPhotoPreviewData.activeDrawable.put(paramInt, paramView);
          break;
          QLog.d("PhotoPreviewActivity", 2, "url  is null ");
          paramView = localObject2;
          continue;
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramViewGroup.getWidth();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramViewGroup.getHeight();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bayu.a;
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          paramViewGroup = this.mActivity.getFileUrl(paramView);
          paramView = localObject2;
          if (paramViewGroup != null)
          {
            paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject3);
            paramView = paramViewGroup;
            if (paramViewGroup != null)
            {
              paramView = paramViewGroup;
              switch (paramViewGroup.getStatus())
              {
              }
              paramViewGroup.setTag(Integer.valueOf(1));
              paramViewGroup.startDownload();
              paramView = paramViewGroup;
            }
          }
        }
      }
      else
      {
        label463:
        getViewNotLocalFile((String)localObject3, (ImageView)localObject1, paramViewGroup);
      }
    }
    label477:
    return localObject1;
  }
  
  protected void getViewNotLocalFile(String paramString, ImageView paramImageView, ViewGroup paramViewGroup) {}
  
  protected void initData(Intent paramIntent)
  {
    com.tencent.mobileqq.activity.photo.FlowThumbDecoder.sFlowItemHeight = this.mActivity.getResources().getDimension(2131296978);
    this.mActivity.mVideoPlayController = new aiqn();
    this.mPhotoPreviewData.from = paramIntent.getStringExtra("FROM_WHERE");
    paramIntent.removeExtra("FROM_WHERE");
    this.mPhotoPreviewData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
      this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localObject != null) {
      this.mPhotoCommonData.allMediaInfoHashMap = ((HashMap)localObject);
    }
    this.mPhotoCommonData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.mPhotoPreviewData.showAlbum = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.mPhotoPreviewData.backBtnText = paramIntent.getStringExtra("back_btn_text");
    if (this.mPhotoPreviewData.showAlbum)
    {
      this.mPhotoPreviewData.paths = new ArrayList();
      this.mPhotoPreviewData.paths.addAll(this.mPhotoCommonData.mediaPathsList);
      if (this.mPhotoPreviewData.paths.isEmpty()) {
        this.mPhotoPreviewData.paths = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      }
      if (this.mPhotoPreviewData.paths == null) {
        this.mPhotoPreviewData.paths = new ArrayList();
      }
      this.mPhotoCommonData.selectedPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.mPhotoCommonData.selectedIndex = ((ArrayList)localObject);
      }
      if ((this.mPhotoCommonData.selectedIndex == null) || (this.mPhotoPreviewData.paths == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
        }
        this.mActivity.finish();
      }
      this.mPhotoPreviewData.totalPicCount = this.mPhotoPreviewData.paths.size();
      this.mPhotoPreviewData.firstSelectedPostion = this.mActivity.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
      if (this.mPhotoPreviewData.firstSelectedPostion >= this.mPhotoPreviewData.totalPicCount) {
        this.mPhotoPreviewData.firstSelectedPostion = -1;
      }
      paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
      this.mPhotoPreviewData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
    }
    this.mPhotoPreviewData.paths = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.mPhotoPreviewData.paths == null)
    {
      this.mPhotoPreviewData.paths = new ArrayList();
      this.mPhotoPreviewData.paths.addAll(this.mPhotoCommonData.selectedPhotoList);
    }
    localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      this.mPhotoPreviewData.paths.clear();
      this.mPhotoPreviewData.paths.add(localObject);
    }
    localObject = this.mPhotoPreviewData.paths.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!this.mPhotoPreviewData.canUseURL) || (!QAlbumUtil.isNetUrl(str))) {
        if (str != null)
        {
          if (!new File(str).exists()) {
            ((Iterator)localObject).remove();
          }
        }
        else {
          ((Iterator)localObject).remove();
        }
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList == null) {
      this.mPhotoCommonData.selectedPhotoList = new ArrayList();
    }
    for (;;)
    {
      this.mPhotoCommonData.selectedPhotoList.addAll(this.mPhotoPreviewData.paths);
      this.mPhotoCommonData.selectedIndex.clear();
      if (this.mPhotoPreviewData.isSingleMode) {
        break;
      }
      int i = 0;
      while (i < this.mPhotoPreviewData.paths.size())
      {
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      break;
      this.mPhotoCommonData.selectedPhotoList.clear();
    }
  }
  
  protected void initUI()
  {
    if (this.mPhotoPreviewData.showBar)
    {
      this.mActivity.topBar.setVisibility(0);
      this.mActivity.bottomBar.setVisibility(0);
    }
    for (;;)
    {
      if (this.mPhotoPreviewData.showAlbum) {
        this.mActivity.titleView.setVisibility(8);
      }
      this.mActivity.selectLayout.setOnClickListener(new PhotoPreviewLogicBase.1(this));
      this.mActivity.backToPhotoListBtn.setOnClickListener(new PhotoPreviewLogicBase.2(this));
      this.mActivity.gallery.setSupportMatchParent(true);
      this.mActivity.gallery.setAdapter(this.mActivity.adapter);
      this.mActivity.gallery.setOnNoBlankListener(this.mActivity.adapter);
      this.mActivity.gallery.setOnItemSelectedListener(new PhotoPreviewLogicBase.3(this));
      this.mActivity.gallery.setSpacing(this.mActivity.getResources().getDimensionPixelSize(2131297026));
      if (this.mPhotoPreviewData.firstSelectedPostion != -1) {
        this.mActivity.gallery.setSelection(this.mPhotoPreviewData.firstSelectedPostion);
      }
      this.mActivity.gallery.setOnItemClickListener(new PhotoPreviewLogicBase.4(this));
      updateButton();
      if (this.mPhotoPreviewData.isSingleMode)
      {
        this.mActivity.selectedBox.setVisibility(8);
        this.mActivity.selectLayout.setVisibility(8);
        this.mActivity.cancelTv.setVisibility(0);
      }
      this.mActivity.cancelTv.setOnClickListener(new PhotoPreviewLogicBase.5(this));
      if (!TextUtils.isEmpty(this.mPhotoPreviewData.backBtnText)) {
        this.mActivity.backToPhotoListBtn.setText(this.mPhotoPreviewData.backBtnText);
      }
      return;
      this.mActivity.topBar.setVisibility(4);
      this.mActivity.bottomBar.setVisibility(4);
    }
  }
  
  protected boolean needShowMultiPhoto()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void onBackPressed(boolean paramBoolean)
  {
    Intent localIntent = this.mActivity.getIntent();
    if ("FROM_PHOTO_LIST".equals(this.mPhotoPreviewData.from))
    {
      localIntent.setClass(this.mActivity, this.mActivity.getBackActivity());
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (!this.mPhotoPreviewData.isSingleMode) {
        break label176;
      }
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    }
    for (;;)
    {
      this.mActivity.startActivity(localIntent);
      if (localIntent.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent = new Intent();
        localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
        localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        localIntent.putExtra("PhotoConst.editPathMap", this.mPhotoPreviewData.editPathMap);
        this.mActivity.setResult(-1, localIntent);
      }
      this.mActivity.finish();
      return;
      label176:
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      localIntent.putExtra("PhotoConst.editPathMap", this.mPhotoPreviewData.editPathMap);
    }
  }
  
  protected void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = this.mActivity.adapter.getItem(paramInt);
    if (this.mActivity.getMediaType(str) == 1)
    {
      if (this.mActivity.mVideoPlayController != null)
      {
        aiqo localaiqo = new aiqo();
        localaiqo.jdField_a_of_type_Boolean = false;
        localaiqo.jdField_a_of_type_JavaLangString = str;
        this.mActivity.mVideoPlayController.a(paramAdapterView, localaiqo);
      }
      if (paramView != null)
      {
        this.mActivity.mCenterVideoPlayBtn = ((ImageView)paramView.findViewById(2131372257));
        this.mActivity.mCenterVideoPlayBtn.setVisibility(0);
      }
      if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(paramInt))) {
        break label277;
      }
      if (str == null) {
        break label263;
      }
      this.mActivity.setCheckedNumber(str);
      label134:
      updateButton();
      if (!this.mPhotoPreviewData.showAlbum)
      {
        if (this.mPhotoPreviewData.paths.size() <= 1) {
          break label291;
        }
        this.mActivity.titleView.setText(paramInt + 1 + " / " + this.mPhotoPreviewData.paths.size());
      }
    }
    for (;;)
    {
      if ((this.mActivity.getMediaType(str) == 1) && (!this.mPhotoPreviewData.showBar)) {
        this.mActivity.showMenuBar();
      }
      return;
      if (this.mActivity.mVideoPlayController == null) {
        break;
      }
      this.mActivity.mVideoPlayController.a(null, null);
      break;
      label263:
      this.mActivity.selectedBox.setChecked(false);
      break label134;
      label277:
      this.mActivity.selectedBox.setChecked(false);
      break label134;
      label291:
      this.mActivity.titleView.setText(this.mActivity.getResources().getString(2131695497));
    }
  }
  
  protected void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent) {}
  
  protected void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected void onSelectClick(View paramView)
  {
    this.mActivity.getResources();
    int i = this.mActivity.getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
    {
      this.mActivity.selectedBox.setChecked(false);
      int j = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i));
      if (j >= 0)
      {
        this.mPhotoCommonData.selectedIndex.remove(j);
        if (i != -1) {
          this.mPhotoCommonData.selectedPhotoList.remove(this.mPhotoPreviewData.paths.get(i));
        }
      }
    }
    for (;;)
    {
      updateButton();
      return;
      if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
      {
        long l = System.currentTimeMillis();
        if (l - this.mPhotoPreviewData.lastTimeShowToast >= 700L)
        {
          QQToast.a(this.mActivity, this.mActivity.getExceedMaxSelectNumStr(), 1000).b(this.mPhotoPreviewData.titleBarHeight);
          this.mPhotoPreviewData.lastTimeShowToast = l;
        }
        this.mActivity.selectedBox.setChecked(false);
        return;
      }
      if (i != -1)
      {
        paramView = (String)this.mPhotoPreviewData.paths.get(i);
        this.mPhotoCommonData.selectedPhotoList.add(paramView);
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(i));
        this.mActivity.setCheckedNumber(paramView);
      }
    }
  }
  
  protected void updateButton()
  {
    Object localObject = this.mActivity.getResources();
    int i;
    if (this.mPhotoPreviewData.customSendBtnText != null)
    {
      localObject = this.mPhotoPreviewData.customSendBtnText;
      if ((this.mPhotoCommonData.selectedPhotoList == null) || (this.mPhotoCommonData.selectedPhotoList.size() <= 0)) {
        break label153;
      }
      i = 1;
      label51:
      if (i == 0) {
        break label210;
      }
      this.mActivity.sendBtn.setEnabled(true);
      if (!this.mPhotoPreviewData.isSingleMode) {
        break label158;
      }
      this.mActivity.sendBtn.setText((CharSequence)localObject);
    }
    for (;;)
    {
      if ((this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(this.mActivity.getCurrentSelectedPostion()))) || (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum)) {
        break label224;
      }
      this.mActivity.selectedBox.setActivated(true);
      return;
      localObject = ((Resources)localObject).getString(2131695245);
      break;
      label153:
      i = 0;
      break label51;
      label158:
      this.mActivity.sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
      continue;
      label210:
      this.mActivity.sendBtn.setText((CharSequence)localObject);
    }
    label224:
    this.mActivity.selectedBox.setActivated(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase
 * JD-Core Version:    0.7.0.1
 */