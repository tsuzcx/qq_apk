package com.tencent.mobileqq.activity.aio.rebuild.input.inputbarlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputBarLayoutChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.qphone.base.util.QLog;

public class InputBarLayoutChangeCallback
  implements IInputBarLayoutChangeCallback
{
  private final String a = "InputBarLayoutChangeCallback";
  
  private void a(AIOContext paramAIOContext, int paramInt)
  {
    ListUI localListUI = paramAIOContext.e().b();
    paramAIOContext = paramAIOContext.p().d().e();
    if ((localListUI != null) && (paramAIOContext != null) && (paramAIOContext.e() == 0) && (localListUI.n() != paramInt))
    {
      if (QLog.isColorLevel())
      {
        paramAIOContext = new StringBuilder();
        paramAIOContext.append("onLayoutChange() update list.paddingBottom from ");
        paramAIOContext.append(localListUI.n());
        paramAIOContext.append(" to ");
        paramAIOContext.append(paramInt);
        QLog.d("InputBarLayoutChangeCallback", 2, paramAIOContext.toString());
      }
      localListUI.a(localListUI.q(), localListUI.o(), localListUI.p(), paramInt);
    }
  }
  
  private void a(AIOContext paramAIOContext, int paramInt1, int paramInt2)
  {
    paramAIOContext = paramAIOContext.e().b();
    if (paramAIOContext != null)
    {
      paramAIOContext.a(null);
      paramAIOContext.a(paramInt1, paramInt2);
    }
  }
  
  private boolean a(AIOContext paramAIOContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramAIOContext.a(52);
    int i = paramAIOContext.k();
    boolean bool = true;
    if ((i != 1) || (paramInt2 - paramInt1 == paramInt4 - paramInt3))
    {
      if ((localAIOShortcutBarHelper != null) && (localAIOShortcutBarHelper.z())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void a(AIOContext paramAIOContext, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = paramAIOContext.e().b();
    if (paramView == null) {
      return;
    }
    paramInt3 = paramView.m() - paramAIOContext.p().d().e().d();
    Object localObject = (AIOShortcutBarHelper)paramAIOContext.a(52);
    paramInt1 = paramInt3;
    if (localObject != null) {
      paramInt1 = ((AIOShortcutBarHelper)localObject).e(paramInt3);
    }
    if ((paramInt6 - paramInt2 != 0) && (localObject != null)) {
      ((AIOShortcutBarHelper)localObject).d(8);
    }
    a(paramAIOContext, paramInt1);
    if (!a(paramAIOContext, paramInt2, paramInt4, paramInt6, paramInt8)) {
      return;
    }
    if (paramView.k() <= 0) {
      return;
    }
    if ((localObject != null) && (((AIOShortcutBarHelper)localObject).v() == 0)) {
      paramInt1 = ((AIOShortcutBarHelper)localObject).u();
    } else {
      paramInt1 = 0;
    }
    paramInt3 = paramInt2 - paramInt1;
    paramInt2 = paramView.k() - 1;
    while (paramInt2 >= 0)
    {
      localObject = paramView.a(paramInt2);
      if ((paramInt3 > ((View)localObject).getTop()) && (paramInt3 <= ((View)localObject).getBottom()))
      {
        paramInt2 = paramView.u() + paramInt2;
        paramInt3 -= ((View)localObject).getBottom();
        break label219;
      }
      paramInt2 -= 1;
    }
    paramInt2 = -1;
    paramInt3 = 0;
    label219:
    if (paramInt2 == -1) {
      return;
    }
    paramView.a(new InputBarLayoutChangeCallback.1(this, paramAIOContext, paramInt2, paramInt3 + paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputbarlayout.InputBarLayoutChangeCallback
 * JD-Core Version:    0.7.0.1
 */