package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.MqqWeakReferenceHandler;

class TroopActivity$2
  implements BaseTroopView.ITroopContext
{
  TroopActivity$2(TroopActivity paramTroopActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a(String paramString)
  {
    if (this.a.isResume()) {
      QQToast.makeText(b(), paramString, 0).show(this.a.getTitleBarHeight());
    }
  }
  
  public Activity b()
  {
    return this.a;
  }
  
  public ForwardBaseOption c()
  {
    return TroopActivity.a(this.a);
  }
  
  public View d()
  {
    return this.a.findViewById(2131445137);
  }
  
  public View e()
  {
    return this.a.findViewById(2131445043);
  }
  
  public View f()
  {
    return this.a.findViewById(2131445033);
  }
  
  public View g()
  {
    return this.a.k;
  }
  
  public MqqWeakReferenceHandler h()
  {
    return this.a.o;
  }
  
  public boolean i()
  {
    return TroopActivity.b(this.a);
  }
  
  public boolean j()
  {
    return TroopActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.2
 * JD-Core Version:    0.7.0.1
 */