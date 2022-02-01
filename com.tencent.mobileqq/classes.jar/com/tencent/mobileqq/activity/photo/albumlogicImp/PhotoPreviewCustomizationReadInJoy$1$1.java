package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;

class PhotoPreviewCustomizationReadInJoy$1$1
  implements DialogInterface.OnClickListener
{
  PhotoPreviewCustomizationReadInJoy$1$1(PhotoPreviewCustomizationReadInJoy.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", this.a.a.s().m());
    PhotoPreviewCustomizationReadInJoy.f(this.a.a).setResult(-1, paramDialogInterface);
    PhotoPreviewCustomizationReadInJoy.g(this.a.a).finish();
    PhotoPreviewCustomizationReadInJoy.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy.1.1
 * JD-Core Version:    0.7.0.1
 */