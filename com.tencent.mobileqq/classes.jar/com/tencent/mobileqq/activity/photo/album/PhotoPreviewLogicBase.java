package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PhotoPreviewLogicBase<K extends AbstractPhotoPreviewActivity, O extends OtherCommonData>
  extends PhotoPreviewLogic<K, O>
  implements PhotoPreviewLogic.IonCheckedChangedCallback
{
  protected PhotoPreviewLogicBase(K paramK)
  {
    super(paramK);
    this.mOnCheckedChangedCallback = this;
  }
  
  private void filterPreviewDataPath()
  {
    Iterator localIterator = this.mPhotoPreviewData.paths.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!this.mPhotoPreviewData.canUseURL) || (!QAlbumUtil.isNetUrl(str))) {
        if (str != null)
        {
          if (!new File(str).exists()) {
            localIterator.remove();
          }
        }
        else {
          localIterator.remove();
        }
      }
    }
  }
  
  private void handleShowAlbum(Intent paramIntent)
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
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    if ((paramIntent != null) && (!paramIntent.isEmpty())) {
      this.mPhotoCommonData.selectedIndex = paramIntent;
    }
    if ((this.mPhotoCommonData.selectedIndex == null) || (this.mPhotoPreviewData.paths == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
      }
      this.mActivity.finish();
    }
  }
  
  private void handleUnShowAlbum(Intent paramIntent)
  {
    this.mPhotoPreviewData.paths = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.mPhotoPreviewData.paths == null)
    {
      this.mPhotoPreviewData.paths = new ArrayList();
      this.mPhotoPreviewData.paths.addAll(this.mPhotoCommonData.selectedPhotoList);
    }
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if ((paramIntent != null) && (!paramIntent.equals("")))
    {
      this.mPhotoPreviewData.paths.clear();
      this.mPhotoPreviewData.paths.add(paramIntent);
    }
    filterPreviewDataPath();
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
      this.mPhotoCommonData.selectedPhotoList.clear();
    }
  }
  
  void doOnDestroy()
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
      close();
    }
  }
  
  void doOnResume()
  {
    if ((this.mPhotoPreviewData.showBar) && (this.mActivity.topBar != null)) {
      this.mActivity.topBar.setVisibility(0);
    }
  }
  
  public void flashPicCheckedChanged(boolean paramBoolean) {}
  
  protected BasePreviewAdapter getPreviewAdapter()
  {
    return new BasePreviewAdapter(this);
  }
  
  protected void initData(Intent paramIntent)
  {
    com.tencent.mobileqq.activity.photo.FlowThumbDecoder.sFlowItemHeight = this.mActivity.getResources().getDimension(2131297120);
    this.mPhotoPreviewData.from = paramIntent.getStringExtra("FROM_WHERE");
    paramIntent.removeExtra("FROM_WHERE");
    this.mPhotoPreviewData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
      this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localHashMap != null) && (!localHashMap.isEmpty())) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.putAll(localHashMap);
    }
    localHashMap = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localHashMap != null) {
      this.mPhotoCommonData.allMediaInfoHashMap = localHashMap;
    }
    this.mPhotoCommonData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.mPhotoPreviewData.showAlbum = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.mPhotoPreviewData.backBtnText = paramIntent.getStringExtra("back_btn_text");
    if (this.mPhotoPreviewData.showAlbum) {
      handleShowAlbum(paramIntent);
    }
    for (;;)
    {
      this.mPhotoPreviewData.totalPicCount = this.mPhotoPreviewData.paths.size();
      this.mPhotoPreviewData.firstSelectedPostion = this.mActivity.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
      if (this.mPhotoPreviewData.firstSelectedPostion >= this.mPhotoPreviewData.totalPicCount) {
        this.mPhotoPreviewData.firstSelectedPostion = -1;
      }
      paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
      this.mPhotoPreviewData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
      handleUnShowAlbum(paramIntent);
    }
  }
  
  protected void initUI()
  {
    this.mActivity.gallery.setSelection(this.mPhotoPreviewData.firstSelectedPostion);
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
      updateButton();
      if (this.mPhotoPreviewData.isSingleMode)
      {
        this.mActivity.selectedBox.setVisibility(8);
        this.mActivity.selectLayout.setVisibility(8);
        this.mActivity.cancelTv.setVisibility(0);
      }
      this.mActivity.cancelTv.setOnClickListener(new PhotoPreviewLogicBase.3(this));
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
        break label173;
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
      label173:
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      localIntent.putExtra("PhotoConst.editPathMap", this.mPhotoPreviewData.editPathMap);
    }
  }
  
  public void onGalleryItemClicked(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (this.mPhotoPreviewData.showBar) {
        this.mActivity.hideMenuBar();
      }
    }
    else {
      return;
    }
    this.mActivity.showMenuBar();
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.mActivity.adapter.getItem(paramInt);
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(paramInt))) {
      if (paramAdapterView != null)
      {
        this.mActivity.setCheckedNumber(paramAdapterView);
        updateButton();
        if (!this.mPhotoPreviewData.showAlbum)
        {
          if (this.mPhotoPreviewData.paths.size() <= 1) {
            break label172;
          }
          this.mActivity.titleView.setText(paramInt + 1 + " / " + this.mPhotoPreviewData.paths.size());
        }
      }
    }
    for (;;)
    {
      if ((this.mActivity.getMediaType(paramAdapterView) == 1) && (!this.mPhotoPreviewData.showBar)) {
        this.mActivity.showMenuBar();
      }
      return;
      this.mActivity.selectedBox.setChecked(false);
      break;
      this.mActivity.selectedBox.setChecked(false);
      break;
      label172:
      this.mActivity.titleView.setText(this.mActivity.getResources().getString(2131695004));
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
      localObject = ((Resources)localObject).getString(2131694852);
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