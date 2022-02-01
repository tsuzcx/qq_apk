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
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.findViewById(2131376809);
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public ForwardBaseOption a()
  {
    return TroopActivity.a(this.a);
  }
  
  public MqqWeakReferenceHandler a()
  {
    return this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  }
  
  public void a(String paramString)
  {
    if (this.a.isResume()) {
      QQToast.a(a(), paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public boolean a()
  {
    return TroopActivity.a(this.a);
  }
  
  public View b()
  {
    return this.a.findViewById(2131376752);
  }
  
  public boolean b()
  {
    return TroopActivity.b(this.a);
  }
  
  public View c()
  {
    return this.a.findViewById(2131376745);
  }
  
  public View d()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.2
 * JD-Core Version:    0.7.0.1
 */