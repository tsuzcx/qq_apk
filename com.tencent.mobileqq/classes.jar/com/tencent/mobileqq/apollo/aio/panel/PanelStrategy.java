package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;

public abstract class PanelStrategy
{
  protected QQAppInterface a;
  protected Context b;
  protected SessionInfo c;
  protected int d = -1;
  private Runnable e;
  
  public PanelStrategy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramSessionInfo;
  }
  
  protected int a(List<ApolloViewBinder> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt < paramList.size()))
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramInt; j = k)
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)paramList.get(i);
        k = j;
        if (localApolloViewBinder != null) {
          k = j + localApolloViewBinder.c();
        }
        i += 1;
      }
      return j;
    }
    paramList = new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    for (;;)
    {
      throw paramList;
    }
  }
  
  abstract ApolloViewBinder a(int paramInt1, int paramInt2);
  
  public void a()
  {
    if (this.e == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(this.e);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.e = paramRunnable;
  }
  
  abstract void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2);
  
  abstract boolean a(int paramInt);
  
  abstract void b(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.PanelStrategy
 * JD-Core Version:    0.7.0.1
 */