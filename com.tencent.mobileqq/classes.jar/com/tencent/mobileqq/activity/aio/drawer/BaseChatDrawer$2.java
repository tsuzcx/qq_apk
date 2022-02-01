package com.tencent.mobileqq.activity.aio.drawer;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.qphone.base.util.QLog;

class BaseChatDrawer$2
  implements View.OnLayoutChangeListener
{
  BaseChatDrawer$2(BaseChatDrawer paramBaseChatDrawer, View paramView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
      return;
    }
    paramView = new int[2];
    View localView = this.a;
    if (localView != null)
    {
      localView.getLocationInWindow(paramView);
      paramInt1 = paramView[1] + this.a.getHeight();
    }
    else
    {
      paramInt1 = 0;
    }
    if (BaseChatDrawer.a(this.b) != null) {
      paramInt2 = BaseChatDrawer.a(this.b).getRight();
    } else {
      paramInt2 = 0;
    }
    if (BaseChatDrawer.a(this.b) != null) {
      paramInt3 = BaseChatDrawer.a(this.b).getHeight();
    } else {
      paramInt3 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, String.format("setTouchableBound, drawerWidth: %s, drawerHeight: %s, titleBarBottom: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 > 0) && (paramInt3 > 0) && (paramInt1 > 0)) {
      BaseChatDrawer.a(this.b).setTouchableBound(0, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer.2
 * JD-Core Version:    0.7.0.1
 */