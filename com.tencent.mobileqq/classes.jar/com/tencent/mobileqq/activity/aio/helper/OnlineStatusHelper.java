package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public abstract class OnlineStatusHelper
  implements ILifeCycleHelper
{
  protected final AIOContext a;
  protected final QQAppInterface b;
  protected BaseSessionInfo c;
  protected boolean d = false;
  private final FriendListObserver e = new OnlineStatusHelper.1(this);
  
  public OnlineStatusHelper(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
    this.c = paramAIOContext.O();
  }
  
  private TextView c()
  {
    return this.a.K().getSubTitleText2();
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, int paramInt)
  {
    f().setTextColor(paramContext.getResources().getColor(paramInt));
    c().setTextColor(paramContext.getResources().getColor(paramInt));
  }
  
  protected void a(String paramString)
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)this.a.a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  public abstract void b();
  
  protected void b(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  protected void d() {}
  
  protected boolean e()
  {
    return this.c.a == 1008;
  }
  
  protected TextView f()
  {
    return this.a.K().getSubTitleText();
  }
  
  protected View g()
  {
    return this.a.K().getSubTitleLayout();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 4, 1, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 15) {
            return;
          }
          this.b.removeObserver(this.e);
          return;
        }
        this.d = false;
        return;
      }
      this.b.addObserver(this.e);
      d();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OnlineStatusHelper
 * JD-Core Version:    0.7.0.1
 */