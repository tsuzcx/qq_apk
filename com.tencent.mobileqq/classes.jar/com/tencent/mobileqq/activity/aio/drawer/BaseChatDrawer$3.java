package com.tencent.mobileqq.activity.aio.drawer;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.DrawerFrame.IDrawerCallbacks;

class BaseChatDrawer$3
  implements DrawerFrame.IDrawerCallbacks
{
  BaseChatDrawer$3(BaseChatDrawer paramBaseChatDrawer) {}
  
  public void a(int paramInt)
  {
    if ((!BaseChatDrawer.a(this.a)) && (paramInt == 1)) {
      this.a.a();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (BaseChatDrawer.a(this.a)) {
      this.a.a(paramInt, paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    BaseChatDrawer.a(this.a);
    if (BaseChatDrawer.a(this.a)) {
      this.a.b(paramInt);
    }
  }
  
  public void f()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.N();
    }
    if (BaseChatDrawer.a(this.a)) {
      this.a.f();
    }
    if ((((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) ^ true)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "intimate", true);
    }
  }
  
  public void g()
  {
    if (BaseChatDrawer.a(this.a)) {
      this.a.g();
    }
  }
  
  public void h()
  {
    if (BaseChatDrawer.a(this.a)) {
      this.a.h();
    }
  }
  
  public void i()
  {
    BaseChatDrawer.b(this.a);
    if (BaseChatDrawer.a(this.a)) {
      this.a.i();
    }
    if (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "intimate", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer.3
 * JD-Core Version:    0.7.0.1
 */