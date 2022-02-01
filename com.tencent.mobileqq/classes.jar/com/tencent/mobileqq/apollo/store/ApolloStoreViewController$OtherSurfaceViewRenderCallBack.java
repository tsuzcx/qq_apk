package com.tencent.mobileqq.apollo.store;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

class ApolloStoreViewController$OtherSurfaceViewRenderCallBack
  implements IRenderCallback
{
  private WeakReference<ApolloStoreViewController> a;
  
  public ApolloStoreViewController$OtherSurfaceViewRenderCallBack(ApolloStoreViewController paramApolloStoreViewController)
  {
    this.a = new WeakReference(paramApolloStoreViewController);
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
    localObject = (ApolloStoreViewController)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = ApolloStoreViewController.a((ApolloStoreViewController)localObject);
    if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)))
    {
      if (ApolloStoreViewController.n((ApolloStoreViewController)localObject) == null) {
        return;
      }
      ApolloStoreViewController.d((ApolloStoreViewController)localObject);
      ApolloStoreViewController.e((ApolloStoreViewController)localObject).removeMessages(24);
      ApolloStoreViewController.n((ApolloStoreViewController)localObject).stopLoopDelayed(1000L);
      if (TextUtils.isEmpty(ApolloStoreViewController.g((ApolloStoreViewController)localObject))) {
        return;
      }
      if (ApolloStoreViewController.h((ApolloStoreViewController)localObject))
      {
        if ((ApolloStoreViewController.i((ApolloStoreViewController)localObject) == 1) && (ApolloStoreViewController.j((ApolloStoreViewController)localObject) != null)) {
          ApolloStoreViewController.j((ApolloStoreViewController)localObject).b();
        }
      }
      else if (ApolloStoreViewController.i((ApolloStoreViewController)localObject) == 1)
      {
        if (ApolloStoreViewController.j((ApolloStoreViewController)localObject) != null) {
          ApolloStoreViewController.j((ApolloStoreViewController)localObject).a(true);
        }
      }
      else {
        ApolloStoreViewController.n((ApolloStoreViewController)localObject).getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
      }
    }
  }
  
  public void b_(int paramInt, String paramString)
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
    localObject = (ApolloStoreViewController)((WeakReference)localObject).get();
    if (localObject != null)
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = ApolloStoreViewController.a((ApolloStoreViewController)localObject);
      if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId))) {
        ApolloStoreViewController.b((ApolloStoreViewController)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreViewController.OtherSurfaceViewRenderCallBack
 * JD-Core Version:    0.7.0.1
 */