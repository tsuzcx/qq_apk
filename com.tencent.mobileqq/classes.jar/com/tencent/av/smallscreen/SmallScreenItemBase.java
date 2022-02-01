package com.tencent.av.smallscreen;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenItemBase
{
  protected String l;
  protected SmallScreenRelativeLayout m = null;
  protected SmallScreenToast n = null;
  protected int o;
  protected int p;
  protected int q;
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.m = ((SmallScreenRelativeLayout)paramLayoutInflater.inflate(this.o, null));
    this.m.b();
    this.m.setFloatListener(paramFloatListener);
    this.n = new SmallScreenToast(paramContext, this.m);
    this.m.setIsRotateSize(true);
    this.m.setSize(this.p, this.q);
    a(this.n.f());
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    int i;
    if (SmallScreenUtils.b()) {
      i = 2005;
    } else {
      i = 2002;
    }
    paramLayoutParams.type = i;
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    this.m.setSize(this.p, this.q);
    this.m.f();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = a();
    String str;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (!this.n.e()) {
        this.n.b();
      }
      if (!bool)
      {
        this.m.setCurPosition(paramInt);
        this.m.d();
        if (QLog.isDevelopLevel())
        {
          str = this.l;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOrHide, show toast view , tag[");
          localStringBuilder.append(this.l);
          localStringBuilder.append("]");
          QLog.w(str, 4, localStringBuilder.toString());
        }
      }
    }
    else if (bool)
    {
      this.m.e();
      if (QLog.isDevelopLevel())
      {
        str = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showOrHide, hide toast view , tag[");
        localStringBuilder.append(this.l);
        localStringBuilder.append("]");
        QLog.w(str, 4, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a()
  {
    return (this.m.getVisibility() == 0) && (this.m.getIsShow());
  }
  
  public void b()
  {
    this.n.c();
    this.m.c();
    this.n = null;
    this.m = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenItemBase
 * JD-Core Version:    0.7.0.1
 */