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

class ApolloViewController$1
  implements IRenderCallback
{
  ApolloViewController$1(ApolloViewController paramApolloViewController) {}
  
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
    if (!ApolloViewController.a(this.a).containsKey(paramString))
    {
      QLog.e("[cmshow]ApolloViewController", 1, "[onCompleteRender] roleName not showing");
      return;
    }
    if ((ApolloViewController.a(this.a) != null) && (!TextUtils.isEmpty(ApolloViewController.a(this.a).apolloId)) && (ApolloViewController.a(this.a).apolloId.equals(paramString)))
    {
      ApolloViewController.b(this.a);
      if (this.a.a != 5) {
        ApolloViewController.a(this.a, 1);
      }
      paramString = ApolloViewController.a(this.a).obtainMessage(18, 1, 0);
      ApolloViewController.a(this.a).sendMessage(paramString);
      ApolloViewController.a(this.a).stopLoopDelayed(15000L);
      if (!TextUtils.isEmpty(ApolloViewController.a(this.a))) {
        if (ApolloViewController.a(this.a))
        {
          if ((ApolloViewController.a(this.a) == 1) && (ApolloViewController.a(this.a) != null)) {
            ApolloViewController.a(this.a).b();
          }
        }
        else if (ApolloViewController.a(this.a) == 1)
        {
          if (ApolloViewController.a(this.a) != null) {
            ApolloViewController.a(this.a).a(true);
          }
        }
        else {
          ApolloViewController.a(this.a).getRenderImpl().a(1, ApolloViewController.a(this.a).apolloId, "Bubble");
        }
      }
    }
    else
    {
      synchronized (ApolloViewController.a(this.a))
      {
        if (ApolloViewController.a(this.a).containsKey(paramString))
        {
          Message localMessage = ApolloViewController.a(this.a).obtainMessage(28);
          localMessage.obj = paramString;
          ApolloViewController.a(this.a).sendMessage(localMessage);
          ApolloViewController.a(this.a).stopLoopDelayed(15000L);
        }
        return;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "[onStartRender] taskId=", Integer.valueOf(paramInt), ", roleName=", paramString });
    }
    if ((ApolloViewController.a(this.a) != null) && (!TextUtils.isEmpty(ApolloViewController.a(this.a).apolloId)) && (ApolloViewController.a(this.a).apolloId.equals(paramString))) {
      ApolloViewController.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.1
 * JD-Core Version:    0.7.0.1
 */