package com.tencent.mobileqq.apollo.store;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

class ApolloViewController$OtherSurfaceViewRenderCallBack
  implements IRenderCallback
{
  private WeakReference<ApolloViewController> a;
  
  public ApolloViewController$OtherSurfaceViewRenderCallBack(ApolloViewController paramApolloViewController)
  {
    this.a = new WeakReference(paramApolloViewController);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "mOtherSurfaceView onCompleteRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (ApolloViewController)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = ApolloViewController.a((ApolloViewController)localObject);
    if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)))
    {
      if (ApolloViewController.b((ApolloViewController)localObject) == null) {
        return;
      }
      ApolloViewController.b((ApolloViewController)localObject);
      ApolloViewController.a((ApolloViewController)localObject).removeMessages(24);
      ApolloViewController.b((ApolloViewController)localObject).stopLoopDelayed(1000L);
      if (TextUtils.isEmpty(ApolloViewController.a((ApolloViewController)localObject))) {
        return;
      }
      if (ApolloViewController.a((ApolloViewController)localObject))
      {
        if ((ApolloViewController.a((ApolloViewController)localObject) == 1) && (ApolloViewController.a((ApolloViewController)localObject) != null)) {
          ApolloViewController.a((ApolloViewController)localObject).b();
        }
      }
      else if (ApolloViewController.a((ApolloViewController)localObject) == 1)
      {
        if (ApolloViewController.a((ApolloViewController)localObject) != null) {
          ApolloViewController.a((ApolloViewController)localObject).a(true);
        }
      }
      else {
        ApolloViewController.b((ApolloViewController)localObject).getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewController", 2, new Object[] { "mOtherSurfaceView onStartRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (ApolloViewController)((WeakReference)localObject).get();
    if (localObject != null)
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = ApolloViewController.a((ApolloViewController)localObject);
      if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId))) {
        ApolloViewController.a((ApolloViewController)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.OtherSurfaceViewRenderCallBack
 * JD-Core Version:    0.7.0.1
 */