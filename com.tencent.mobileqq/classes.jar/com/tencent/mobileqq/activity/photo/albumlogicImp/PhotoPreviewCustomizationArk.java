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
  private String b;
  private boolean j;
  private String k;
  
  public PhotoPreviewCustomizationArk(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    s().l.setOnClickListener(new PhotoPreviewCustomizationArk.1(this));
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getStringExtra("key_ark_app_res_path");
    this.j = paramIntent.getBooleanExtra("key_should_compress", false);
    this.k = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void i()
  {
    if ("FROM_PHOTO_LIST".equals(this.d.A))
    {
      Intent localIntent = this.c.getIntent();
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", this.b);
      localIntent.putExtra("key_should_compress", this.j);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.k);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk
 * JD-Core Version:    0.7.0.1
 */