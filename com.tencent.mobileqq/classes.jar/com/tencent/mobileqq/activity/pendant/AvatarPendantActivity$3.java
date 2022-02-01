package com.tencent.mobileqq.activity.pendant;

import QC.CommonRsp;
import QC.FaceRsp;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
      if (paramFaceRsp.stRet != null)
      {
        localObject = AIOUtils.a();
        ((StringBuilder)localObject).append("ret:");
        ((StringBuilder)localObject).append(paramFaceRsp.stRet.ret);
        ((StringBuilder)localObject).append(" auth:");
        ((StringBuilder)localObject).append(paramFaceRsp.authRet);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(paramFaceRsp.url);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetFace: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject);
      QLog.d("AvatarPendantActivity", 2, localStringBuilder.toString());
      if (i == 0)
      {
        this.a.r = 0;
        return;
      }
      Object localObject = this.a;
      ((AvatarPendantActivity)localObject).r = 1;
      localObject = new Intent((Context)localObject, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramFaceRsp.url);
      this.a.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.3
 * JD-Core Version:    0.7.0.1
 */