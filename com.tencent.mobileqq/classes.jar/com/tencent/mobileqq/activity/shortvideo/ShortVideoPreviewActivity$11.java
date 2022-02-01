package com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShortVideoPreviewActivity$11
  implements DialogInterface.OnClickListener
{
  ShortVideoPreviewActivity$11(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = ShortVideoPreviewActivity.access$001(this.a);
    paramDialogInterface = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    Intent localIntent = new Intent();
    localIntent.setClassName((String)localObject, paramDialogInterface);
    localIntent.addFlags(603979776);
    localIntent.putExtra("file_send_path", this.a.mVideoPath);
    localIntent.putExtra("file_send_size", this.a.mVideoSize);
    localIntent.putExtra("file_send_duration", this.a.mDuration);
    localIntent.putExtra("file_source", this.a.mFileSource);
    this.a.startActivity(localIntent);
    ShortVideoPreviewActivity.access$101(this.a);
    localObject = new Intent("key_video_select_confirm_ok_click");
    ((Intent)localObject).putExtra("className", paramDialogInterface);
    this.a.sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */