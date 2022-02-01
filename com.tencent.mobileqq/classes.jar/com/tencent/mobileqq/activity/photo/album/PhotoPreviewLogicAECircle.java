package com.tencent.mobileqq.activity.photo.album;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.aeeditor.util.AEEditorJumpUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewLogicAECircle
  extends PhotoPreviewLogicBase
{
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private String jdField_a_of_type_JavaLangString = null;
  private int b;
  private int c = 0;
  
  public PhotoPreviewLogicAECircle(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void a()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (a(this.mActivity.getMediaInfo(this.jdField_a_of_type_JavaLangString)))
      {
        QQToast.a(this.mActivity, HardCodeUtil.a(2131689796), 0).b(this.mActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      this.mPhotoCommonData.selectedPhotoList.add(this.jdField_a_of_type_JavaLangString);
    }
    AEEditorJumpUtil.a(this.c, this.mActivity, this.mPhotoCommonData, false);
    this.mActivity.finish();
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label78;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755842);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label78:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("choosed_num", 0);
    this.b = paramIntent.getIntExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", 0);
  }
  
  void initUI()
  {
    super.initUI();
    this.mActivity.selectLayout.setVisibility(8);
    this.mActivity.sendBtn.setOnClickListener(new PhotoPreviewLogicAECircle.1(this));
  }
  
  public void onGalleryItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    String str = this.mActivity.adapter.getItem(paramInt);
    this.jdField_a_of_type_JavaLangString = str;
    if (this.mActivity.getMediaType(str) == 1)
    {
      if (i == 0) {
        break label68;
      }
      this.mActivity.selectLayout.setVisibility(8);
    }
    for (;;)
    {
      super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 0;
      break;
      label68:
      this.mActivity.selectLayout.setVisibility(0);
    }
  }
  
  protected void onSelectClick(View paramView)
  {
    int i = this.mActivity.getCurrentSelectedPostion();
    String str = "";
    if (i != -1) {
      str = (String)this.mPhotoPreviewData.paths.get(i);
    }
    LocalMediaInfo localLocalMediaInfo = this.mActivity.getMediaInfo(str);
    int j = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
    {
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
      if (this.jdField_a_of_type_Int + this.b == 9)
      {
        paramView = BaseApplicationImpl.sApplication.getResources().getString(2131689797, new Object[] { Integer.valueOf(9 - this.b) });
        QQToast.a(this.mActivity, paramView, 0).b(this.mActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      if (a(localLocalMediaInfo))
      {
        QQToast.a(this.mActivity, HardCodeUtil.a(2131689796), 0).b(this.mActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      if ((j == 1) && (this.jdField_a_of_type_Int + this.b != 0))
      {
        QQToast.a(this.mActivity, HardCodeUtil.a(2131689798), 0).b(this.mActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      if (j != 1) {}
    }
    for (;;)
    {
      super.onSelectClick(paramView);
      this.jdField_a_of_type_Int = this.mPhotoCommonData.selectedPhotoList.size();
      return;
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(str);
      }
    }
  }
  
  void updateButton()
  {
    this.mActivity.sendBtn.setClickable(true);
    this.mActivity.sendBtn.setBackgroundResource(2130838064);
    super.updateButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicAECircle
 * JD-Core Version:    0.7.0.1
 */