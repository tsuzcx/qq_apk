package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.IWSJumpFactory;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByPriorityFactory;
import com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByTypeFactory;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

public class WSStSchemaJumpManager
  implements IWSStSchemaJumpFactor
{
  private Context a;
  private stSchema b;
  private WSDownloadParams c;
  private IJumpListener d;
  private MiniAppLaunchListener e;
  private OuterInterceptManager.OnInterceptDialogClickListener f;
  private IWSJumpFactory g;
  private IWSJumpFactory h;
  private Object i;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  
  public WSStSchemaJumpManager(Context paramContext)
  {
    this.a = paramContext;
    this.g = new WSJumpStrategyByPriorityFactory();
    this.h = new WSJumpStrategyByTypeFactory();
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public WSStSchemaJumpManager a(stSchema paramstSchema)
  {
    this.b = paramstSchema;
    return this;
  }
  
  public WSStSchemaJumpManager a(WSDownloadParams paramWSDownloadParams)
  {
    this.c = paramWSDownloadParams;
    return this;
  }
  
  public WSStSchemaJumpManager a(IJumpListener paramIJumpListener)
  {
    this.d = paramIJumpListener;
    return this;
  }
  
  public WSStSchemaJumpManager a(OuterInterceptManager.OnInterceptDialogClickListener paramOnInterceptDialogClickListener)
  {
    this.f = paramOnInterceptDialogClickListener;
    return this;
  }
  
  public WSStSchemaJumpManager a(Object paramObject)
  {
    this.i = paramObject;
    return this;
  }
  
  public WSStSchemaJumpManager a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public stSchema b()
  {
    return this.b;
  }
  
  public WSStSchemaJumpManager b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public WSDownloadParams c()
  {
    return this.c;
  }
  
  public WSStSchemaJumpManager c(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return this.l;
  }
  
  public MiniAppLaunchListener f()
  {
    return this.e;
  }
  
  public OuterInterceptManager.OnInterceptDialogClickListener g()
  {
    return this.f;
  }
  
  public IJumpListener h()
  {
    return this.d;
  }
  
  public Object i()
  {
    return this.i;
  }
  
  public boolean j()
  {
    if ((this.a != null) && (this.b != null))
    {
      if (this.k) {
        localObject = this.g;
      } else {
        localObject = this.h;
      }
      localObject = ((IWSJumpFactory)localObject).a(this);
      if (localObject != null) {
        return ((AbsWSJump)localObject).a();
      }
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", mStSchema");
    ((StringBuilder)localObject).append(this.b);
    WSLog.d("WSStSchemaJumpManager", ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager
 * JD-Core Version:    0.7.0.1
 */