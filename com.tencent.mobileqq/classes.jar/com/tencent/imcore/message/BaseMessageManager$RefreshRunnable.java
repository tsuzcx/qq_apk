package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.lang.ref.WeakReference;

class BaseMessageManager$RefreshRunnable
  implements Runnable
{
  private final String a;
  private final int b;
  private final int c;
  private final RefreshMessageContext d;
  private final String e;
  private final WeakReference<BaseMessageManager> f;
  
  BaseMessageManager$RefreshRunnable(String paramString1, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, String paramString2, BaseMessageManager paramBaseMessageManager)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramRefreshMessageContext;
    this.e = paramString2;
    this.f = new WeakReference(paramBaseMessageManager);
  }
  
  public void run()
  {
    BaseMessageManager localBaseMessageManager = (BaseMessageManager)this.f.get();
    if (localBaseMessageManager == null) {
      return;
    }
    IMessageFacade localIMessageFacade = localBaseMessageManager.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshMessageListHead uin = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", type = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", count = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", context = ");
    ((StringBuilder)localObject).append(this.d);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", timestamp = ");
    localStringBuilder.append(System.currentTimeMillis());
    localIMessageFacade.qLogColor((String)localObject, localStringBuilder.toString());
    localBaseMessageManager.b(this.a, this.b, this.c, this.d);
    localBaseMessageManager.a(this.d);
    localBaseMessageManager.b.getFacadeHandler().post(new BaseMessageManager.RefreshRunnable.RemoveRefreshKeyRunnable(this, localBaseMessageManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.RefreshRunnable
 * JD-Core Version:    0.7.0.1
 */