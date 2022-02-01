package com.tencent.mobileqq.activity.pendant;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AvatarPendantActivity$19
  implements IApolloExtensionObserver
{
  AvatarPendantActivity$19(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void a(List<CmAvatarFaceInfo> paramList, String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).runOnCrossEngineForMemePlayer();
    boolean bool2 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowAvatar3DSwitch();
    int j = 1;
    int i;
    if ((bool1) && (bool2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramList != null)
    {
      AvatarPendantActivity.a(this.a, new ArrayList());
      if (i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isCrossEngine:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(";enable3DAvatar:");
        ((StringBuilder)localObject).append(bool2);
        QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CmAvatarFaceInfo)paramList.next();
          if (((CmAvatarFaceInfo)localObject).getActionId() < ApolloConstant.f) {
            AvatarPendantActivity.c(this.a).add(localObject);
          }
        }
      }
      AvatarPendantActivity.c(this.a).addAll(paramList);
      if (AvatarPendantActivity.c(this.a).size() > 0)
      {
        paramList = new StringBuilder();
        localObject = AvatarPendantActivity.c(this.a).iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramList.append(((CmAvatarFaceInfo)((Iterator)localObject).next()).getActionId());
          paramList.append(";");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onGetAvatarCmshowFaceList] actionId: ");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
        ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.19.1(this));
      }
      else
      {
        QLog.e("AvatarPendantActivity", 1, "[onGetAvatarCmshowFaceList] avatarCmshowFaceInfoList is empty.");
      }
      if (AvatarPendantActivity.f(this.a) != 0) {
        j = AvatarPendantActivity.f(this.a);
      }
      paramList = this.a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("&_type=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("&_needShow3D=");
      ((StringBuilder)localObject).append(i);
      AvatarPendantActivity.b(paramList, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramString2)) {
        AvatarPendantActivity.c(this.a, ApolloConstant.w);
      } else {
        AvatarPendantActivity.c(this.a, paramString2.replace("[client]", "androidQQ").replace("[version]", "8.8.17.5770").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE));
      }
      AvatarPendantActivity.a(this.a, paramInt);
      return;
    }
    QLog.e("AvatarPendantActivity", 1, "cmAvatarFaceInfoList is null");
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 39) && (paramObject != null)) {
      try
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length > 1)
        {
          a((List)paramObject[0], (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.e("AvatarPendantActivity", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.19
 * JD-Core Version:    0.7.0.1
 */