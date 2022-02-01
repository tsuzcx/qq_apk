package com.tencent.mobileqq.activity.pendant;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AvatarPendantActivity$30
  extends ApolloExtensionObserverImpl
{
  AvatarPendantActivity$30(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(List<CmAvatarFaceInfo> paramList, String paramString1, String paramString2, int paramInt)
  {
    QLog.d("AvatarPendantActivity", 1, "[onGetAvatarCmshowFaceList] " + paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.30.1(this, paramList));
      AvatarPendantActivity.a(this.a, paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        break label103;
      }
      AvatarPendantActivity.b(this.a, ApolloConstant.j);
    }
    for (;;)
    {
      AvatarPendantActivity.a(this.a, paramInt);
      return;
      QLog.d("AvatarPendantActivity", 1, "[onGetAvatarCmshowFaceList] avatarCmshowFaceInfoList is empty.");
      break;
      label103:
      AvatarPendantActivity.b(this.a, paramString2.replace("[client]", "androidQQ").replace("[version]", "8.5.5.5105").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.30
 * JD-Core Version:    0.7.0.1
 */