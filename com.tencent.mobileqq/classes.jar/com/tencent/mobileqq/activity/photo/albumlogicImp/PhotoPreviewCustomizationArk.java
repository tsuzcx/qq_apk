package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;

public class PhotoPreviewCustomizationArk
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk";
  private boolean a;
  private String b;
  private String c;
  
  public PhotoPreviewCustomizationArk(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    a().a.setOnClickListener(new PhotoPreviewCustomizationArk.1(this));
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.c = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void g()
  {
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d))
    {
      Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", this.b);
      localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.c);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk
 * JD-Core Version:    0.7.0.1
 */