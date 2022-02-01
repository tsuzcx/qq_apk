package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

public class PhotoPreviewCustomizationFileAssistant
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant";
  
  public PhotoPreviewCustomizationFileAssistant(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (a().getItem(paramInt).baseData.getType() == 101)
    {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      a().c.setVisibility(8);
      a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.c) {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
    a().c.setVisibility(8);
    a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null)
    {
      paramBundle.putBoolean("key_multi_edit_pic", true);
      paramBundle.putBoolean("key_enable_edit_title_bar", true);
    }
    super.a(paramView, 10000, paramBundle, paramInt2, paramIntent);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty());
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "sendPicAndVideoToFileAssistant...");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.isFinishing()) {
        return;
      }
      Intent localIntent;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {
        localIntent = (Intent)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
      } else {
        localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
      }
      localIntent.setExtrasClassLoader(PeakConstants.class.getClassLoader());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", a().a());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant
 * JD-Core Version:    0.7.0.1
 */