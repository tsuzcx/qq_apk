package com.tencent.mobileqq.activity.pendant;

import QC.CommonRsp;
import QC.FaceRsp;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$3
  extends SVIPObserver
{
  AvatarPendantActivity$3(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onSetFace(boolean paramBoolean, FaceRsp paramFaceRsp)
  {
    if (paramFaceRsp != null)
    {
      int i = paramFaceRsp.authRet;
      localObject = "null";
      if (paramFaceRsp.stRet != null) {
        localObject = "ret:" + paramFaceRsp.stRet.ret + " auth:" + paramFaceRsp.authRet + " url:" + paramFaceRsp.url;
      }
      QLog.d("AvatarPendantActivity", 2, "onSetFace: " + paramBoolean + "," + (String)localObject);
      if (i == 0) {
        this.a.r = 0;
      }
    }
    else
    {
      return;
    }
    this.a.r = 1;
    Object localObject = new Intent(this.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramFaceRsp.url);
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.3
 * JD-Core Version:    0.7.0.1
 */