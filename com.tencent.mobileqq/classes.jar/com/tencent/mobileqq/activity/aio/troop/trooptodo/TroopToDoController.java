package com.tencent.mobileqq.activity.aio.troop.trooptodo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.qphone.base.util.QLog;

public class TroopToDoController
  implements TroopToDoTipAbility
{
  private View a;
  private View b;
  private ViewGroup c;
  private AIOContext d;
  private ViewStub e;
  private View f;
  
  public TroopToDoController(AIOContext paramAIOContext)
  {
    QLog.i("TroopToDoController-TodoInfo", 4, "TroopToDoController new");
    this.d = paramAIOContext;
    this.e = ((ViewStub)paramAIOContext.d(2131448110));
  }
  
  private void f()
  {
    if (this.f == null) {
      this.f = this.e.inflate();
    }
    this.a = this.f.findViewById(2131448108);
    this.b = this.f.findViewById(2131448109);
    this.c = ((ViewGroup)this.f.findViewById(2131447656));
  }
  
  public void a()
  {
    QLog.i("TroopToDoController-TodoInfo", 4, "TroopToDoController dismissTroopToDoBanner");
    f();
    if (this.d.z().d().d().a()) {
      this.a.setVisibility(8);
    }
    QLog.i("TroopToDoController-TodoInfo", 4, "TroopToDoController View.GONE");
    this.c.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("TroopToDoController-TodoInfo", 4, "TroopToDoController showTroopToDoBanner");
    f();
    if (this.d.z().d().d().a()) {
      this.a.setVisibility(0);
    }
    QLog.i("TroopToDoController-TodoInfo", 4, "TroopToDoController View.VISIBLE");
    this.c.setVisibility(0);
    if (!paramBoolean)
    {
      this.a.setBackgroundResource(2131168399);
      this.b.setBackgroundResource(2131168399);
    }
    else
    {
      this.a.setBackgroundResource(2131168400);
      this.b.setBackgroundResource(2131168400);
    }
    this.b.setVisibility(0);
  }
  
  public View b()
  {
    f();
    return this.c;
  }
  
  public boolean c()
  {
    return this.c.getVisibility() == 0;
  }
  
  public void d()
  {
    f();
    if (this.c.getVisibility() == 0) {
      this.a.setVisibility(0);
    }
  }
  
  public void e()
  {
    f();
    if (this.c.getVisibility() == 0) {
      this.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoController
 * JD-Core Version:    0.7.0.1
 */