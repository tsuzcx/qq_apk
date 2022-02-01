package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class Avatar2DJsModule$8$1
  implements Runnable
{
  Avatar2DJsModule$8$1(Avatar2DJsModule.8 param8, ApolloWebAvatarParam paramApolloWebAvatarParam, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!Avatar2DJsModule.a(this.c.b).contains(this.a.apolloId))
    {
      QLog.e("Avatar2DJsModule", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", this.a.apolloId });
      return;
    }
    Activity localActivity = this.c.b.e();
    if ((localActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)localActivity).a(this.b);
      return;
    }
    if (this.c.b.c() != null) {
      this.c.b.c().a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.8.1
 * JD-Core Version:    0.7.0.1
 */