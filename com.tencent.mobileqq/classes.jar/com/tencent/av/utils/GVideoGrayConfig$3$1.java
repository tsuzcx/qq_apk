package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;

class GVideoGrayConfig$3$1
  implements DialogInterface.OnClickListener
{
  GVideoGrayConfig$3$1(GVideoGrayConfig.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((IGroupVideoManager)this.a.a.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(this.a.b, this.a.a.getCurrentAccountUin(), this.a.d, "4", "openRoom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig.3.1
 * JD-Core Version:    0.7.0.1
 */