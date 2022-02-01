package com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

class ShortVideoPreviewActivity$9
  implements DialogInterface.OnClickListener
{
  ShortVideoPreviewActivity$9(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PhotoUtils.sendPhoto(this.c, this.a, this.b, 2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */