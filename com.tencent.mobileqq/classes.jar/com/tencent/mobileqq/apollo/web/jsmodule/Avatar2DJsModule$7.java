package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class Avatar2DJsModule$7
  implements Avatar2DJsModule.OnCheckApolloResListener
{
  Avatar2DJsModule$7(Avatar2DJsModule paramAvatar2DJsModule) {}
  
  public void a(Activity paramActivity, ApolloWebAvatarParam paramApolloWebAvatarParam, ArrayList<ApolloWebAvatarParam> paramArrayList, String paramString)
  {
    if (!Avatar2DJsModule.a(this.a).contains(paramApolloWebAvatarParam.apolloId))
    {
      QLog.e("Avatar2DJsModule", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", paramApolloWebAvatarParam.apolloId });
      return;
    }
    if ((paramActivity instanceof IApolloActivityJsCallBack)) {
      paramActivity = ((IApolloActivityJsCallBack)paramActivity).a(this.a.d().mApolloStatus, paramApolloWebAvatarParam);
    } else {
      paramActivity = "{\"result\":1, \"msg\": \"非商城页面\" }";
    }
    paramApolloWebAvatarParam = this.a;
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramString);
    paramArrayList.append("&&");
    paramArrayList.append(paramString);
    paramArrayList.append("(");
    paramArrayList.append(paramActivity);
    paramArrayList.append(");");
    paramApolloWebAvatarParam.d(paramArrayList.toString());
  }
  
  public void a(String paramString, Activity paramActivity, ApolloWebAvatarParam paramApolloWebAvatarParam, ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (!Avatar2DJsModule.a(this.a).contains(paramApolloWebAvatarParam.apolloId))
    {
      QLog.e("Avatar2DJsModule", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] initAvatar abort, apolloId is destroyed, id=", paramApolloWebAvatarParam.apolloId });
      return;
    }
    if ((paramActivity instanceof IApolloActivityJsCallBack)) {
      paramActivity = ((IApolloActivityJsCallBack)paramActivity).a(this.a.d().mApolloStatus, paramApolloWebAvatarParam);
    } else {
      paramActivity = "{\"result\":1, \"msg\": \"非商城页面\" }";
    }
    paramApolloWebAvatarParam = this.a;
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramString);
    paramArrayList.append("&&");
    paramArrayList.append(paramString);
    paramArrayList.append("(");
    paramArrayList.append(paramActivity);
    paramArrayList.append(");");
    paramApolloWebAvatarParam.d(paramArrayList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.7
 * JD-Core Version:    0.7.0.1
 */