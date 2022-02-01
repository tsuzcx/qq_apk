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
    if ((!BaseChatDrawer.b(this.a)) && (paramInt == 1)) {
      this.a.a();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (BaseChatDrawer.b(this.a)) {
      this.a.a(paramInt, paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    if (BaseChatDrawer.b(this.a)) {
      this.a.b(paramInt);
    }
  }
  
  public void i()
  {
    if (this.a.e != null) {
      this.a.e.as();
    }
    if (BaseChatDrawer.b(this.a)) {
      this.a.i();
    }
    if ((((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.a.a) ^ true)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.a, "intimate", true);
    }
  }
  
  public void j()
  {
    if (BaseChatDrawer.b(this.a)) {
      this.a.j();
    }
  }
  
  public void k()
  {
    if (BaseChatDrawer.b(this.a)) {
      this.a.k();
    }
  }
  
  public void l()
  {
    if (BaseChatDrawer.b(this.a)) {
      this.a.l();
    }
    if (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.a.a)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.a.a, "intimate", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer.3
 * JD-Core Version:    0.7.0.1
 */