package com.tencent.mobileqq.apollo.store;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;

class ApolloStoreViewController$1
  implements IRenderCallback
{
  ApolloStoreViewController$1(ApolloStoreViewController paramApolloStoreViewController) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[onCompleteRender] taskId=", Integer.valueOf(paramInt1), ", roleName=", paramString, ", errCode=", Integer.valueOf(paramInt2) });
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[onCompleteRender] roleName null");
      return;
    }
    if (!ApolloStoreViewController.c(this.a).containsKey(paramString))
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[onCompleteRender] roleName not showing");
      return;
    }
    if ((ApolloStoreViewController.a(this.a) != null) && (!TextUtils.isEmpty(ApolloStoreViewController.a(this.a).apolloId)) && (ApolloStoreViewController.a(this.a).apolloId.equals(paramString)))
    {
      ApolloStoreViewController.d(this.a);
      if (this.a.b != 5) {
        ApolloStoreViewController.a(this.a, 1);
      }
      paramString = ApolloStoreViewController.e(this.a).obtainMessage(18, 1, 0);
      ApolloStoreViewController.e(this.a).sendMessage(paramString);
      ApolloStoreViewController.f(this.a).stopLoopDelayed(15000L);
      if (!TextUtils.isEmpty(ApolloStoreViewController.g(this.a))) {
        if (ApolloStoreViewController.h(this.a))
        {
          if ((ApolloStoreViewController.i(this.a) == 1) && (ApolloStoreViewController.j(this.a) != null)) {
            ApolloStoreViewController.j(this.a).b();
          }
        }
        else if (ApolloStoreViewController.i(this.a) == 1)
        {
          if (ApolloStoreViewController.j(this.a) != null) {
            ApolloStoreViewController.j(this.a).a(true);
          }
        }
        else {
          ApolloStoreViewController.f(this.a).getRenderImpl().a(1, ApolloStoreViewController.a(this.a).apolloId, "Bubble");
        }
      }
    }
    else
    {
      synchronized (ApolloStoreViewController.c(this.a))
      {
        if (ApolloStoreViewController.c(this.a).containsKey(paramString))
        {
          Message localMessage = ApolloStoreViewController.e(this.a).obtainMessage(28);
          localMessage.obj = paramString;
          ApolloStoreViewController.e(this.a).sendMessage(localMessage);
          ApolloStoreViewController.f(this.a).stopLoopDelayed(15000L);
        }
        return;
      }
    }
  }
  
  public void b_(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[onStartRender] taskId=", Integer.valueOf(paramInt), ", roleName=", paramString });
    }
    if ((ApolloStoreViewController.a(this.a) != null) && (!TextUtils.isEmpty(ApolloStoreViewController.a(this.a).apolloId)) && (ApolloStoreViewController.a(this.a).apolloId.equals(paramString))) {
      ApolloStoreViewController.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreViewController.1
 * JD-Core Version:    0.7.0.1
 */