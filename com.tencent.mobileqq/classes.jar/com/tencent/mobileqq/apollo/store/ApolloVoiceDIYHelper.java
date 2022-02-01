package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloVoiceDIYHelper
{
  private WeakReference<ApolloTextureView> a;
  private int b;
  private int c;
  private int d;
  private double e = 2147483647.0D;
  private int f = -1;
  
  private void b(double paramDouble)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.a.get();
    if (localApolloTextureView == null) {
      return;
    }
    localApolloTextureView.getRender().mIsFrameMode = true;
    localApolloTextureView.getRender().mDuration = paramDouble;
    localApolloTextureView.getRenderImpl().a(0L);
    String[] arrayOfString2 = ApolloActionHelperImpl.getActionRscPath(13, this.b, this.c, true);
    String[] arrayOfString1 = null;
    if (this.d == 1) {
      arrayOfString1 = ApolloActionHelperImpl.getActionRscPath(13, this.b, this.c, false);
    }
    localApolloTextureView.getRenderImpl().a(this.b, 0, arrayOfString2, arrayOfString1);
  }
  
  public void a()
  {
    this.e = 2147483647.0D;
  }
  
  public void a(double paramDouble)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[renderFrame], curSec:");
      ((StringBuilder)localObject).append(paramDouble);
      ((StringBuilder)localObject).append(",lastDur:");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("[cmshow]ApolloVoiceDIYHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ApolloTextureView)this.a.get();
    if (localObject == null) {
      return;
    }
    double d1 = this.e;
    if (paramDouble <= d1) {
      b(paramDouble);
    } else {
      ((ApolloTextureView)localObject).queueEvent(new ApolloVoiceDIYHelper.1(this, (ApolloTextureView)localObject, paramDouble - d1));
    }
    this.e = paramDouble;
  }
  
  public void a(ApolloTextureView paramApolloTextureView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new WeakReference(paramApolloTextureView);
    if (paramInt1 != this.f) {
      a();
    }
    this.b = paramInt1;
    this.f = this.b;
    this.c = paramInt2;
    this.d = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper
 * JD-Core Version:    0.7.0.1
 */