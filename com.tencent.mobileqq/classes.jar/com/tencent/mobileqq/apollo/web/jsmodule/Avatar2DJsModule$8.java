package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

class Avatar2DJsModule$8
  implements Avatar2DJsModule.OnCheckApolloResListener
{
  final AtomicInteger a = new AtomicInteger(0);
  
  Avatar2DJsModule$8(Avatar2DJsModule paramAvatar2DJsModule) {}
  
  public void a(Activity paramActivity, ApolloWebAvatarParam paramApolloWebAvatarParam, ArrayList<ApolloWebAvatarParam> paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramApolloWebAvatarParam);
    paramActivity.runOnUiThread(new Avatar2DJsModule.8.1(this, paramApolloWebAvatarParam, localArrayList));
    this.a.getAndIncrement();
    if (this.a.get() == paramArrayList.size()) {
      this.b.b(paramString);
    }
  }
  
  public void a(String paramString, Activity paramActivity, ApolloWebAvatarParam paramApolloWebAvatarParam, ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramApolloWebAvatarParam);
    if (Avatar2DJsModule.a(this.b).contains(paramApolloWebAvatarParam.apolloId)) {
      if ((paramActivity instanceof IApolloActivityJsCallBack)) {
        ((IApolloActivityJsCallBack)paramActivity).a(localArrayList);
      } else if (this.b.c() != null) {
        this.b.c().a(localArrayList);
      }
    }
    this.a.getAndIncrement();
    if (this.a.get() == paramArrayList.size()) {
      this.b.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.8
 * JD-Core Version:    0.7.0.1
 */