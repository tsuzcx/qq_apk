package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommonMenuWrapper
  implements SelectablePopupMenu
{
  private static final int e = ViewUtils.b(72.0F);
  private static final int f = ViewUtils.b(63.0F);
  public int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SelectableDelegate jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private QQCustomMenu b;
  private int jdField_c_of_type_Int;
  private QQCustomMenu jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private int d;
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate == null) {
      throw new IllegalStateException("Delegate has not bound.");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public CommonMenuWrapper.MenuPlaceInfo a(View paramView, BaseChatPie paramBaseChatPie)
  {
    int m = 0;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int n = arrayOfInt[1];
    int i = arrayOfInt[1];
    i = paramView.getHeight() + i;
    paramView = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      paramView = paramBaseChatPie;
      if ((this instanceof AIOMenuWrapper)) {
        paramView = ((AIOMenuWrapper)this).a;
      }
    }
    int j;
    int k;
    if ((paramView != null) && (paramView.a != null) && (paramView.a.getVisibility() == 0))
    {
      paramView.a.getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      if (n + 0 >= e + ImmersiveUtils.statusHeight) {
        break label344;
      }
      if (i + 0 >= e + ImmersiveUtils.statusHeight) {
        break label221;
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int + 0 <= e + ImmersiveUtils.statusHeight)) {
        break label171;
      }
      i = this.jdField_a_of_type_Int + 0;
      k = m;
    }
    for (;;)
    {
      return new CommonMenuWrapper.MenuPlaceInfo(i, k);
      j = ViewUtils.b();
      break;
      label171:
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + f + 0 < j))
      {
        i = this.jdField_a_of_type_Int + 0;
        k = 1;
      }
      else
      {
        i = e + ImmersiveUtils.statusHeight;
        k = m;
        continue;
        label221:
        i += 0;
        if (f + i > j) {
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + 0 > e + ImmersiveUtils.statusHeight))
          {
            j = this.jdField_a_of_type_Int + 0;
            i = 0;
          }
        }
        for (;;)
        {
          k = i;
          i = j;
          break;
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int + f + 0 < j))
          {
            j = this.jdField_a_of_type_Int + 0;
            i = 1;
          }
          else
          {
            j = e + ImmersiveUtils.statusHeight + f + 0;
            i = 0;
            continue;
            k = 1;
            j = i;
            i = k;
          }
        }
        label344:
        i = j;
        k = m;
        if (n <= j)
        {
          i = n + 0;
          k = m;
        }
      }
    }
  }
  
  @Nullable
  public SelectableDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    c();
    QQCustomMenu localQQCustomMenu;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a() == i - j) {
        localQQCustomMenu = this.b;
      }
    }
    for (;;)
    {
      a(localQQCustomMenu, paramView, paramInt1, paramInt2, paramInt3);
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu != null)
      {
        localQQCustomMenu = this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
          this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131365448, HardCodeUtil.a(2131702292), 2130839050);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131377708, HardCodeUtil.a(2131702290), 2130839070);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131367398, HardCodeUtil.a(2131702294), 2130839059);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131366625, HardCodeUtil.a(2131702291), 2130839058);
        }
        localQQCustomMenu = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
        continue;
        localQQCustomMenu = this.b;
      }
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, int paramInt3, boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, Integer paramInteger)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    paramQQCustomMenu = BubbleContextMenu.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramQQCustomMenu.setIgnoreTouchLocation(paramBoolean2);
    paramQQCustomMenu.setContainerBottom(paramInteger);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramQQCustomMenu);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean1);
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    paramQQCustomMenu = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      paramQQCustomMenu.d(paramBoolean1);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener);
      paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      return;
    }
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.b = paramQQCustomMenu;
    this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = null;
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, paramActivity, false, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, boolean paramBoolean, int paramInt3, Integer paramInteger)
  {
    this.b = paramQQCustomMenu;
    this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = null;
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate = paramSelectableDelegate;
  }
  
  void a(QQCustomMenu paramQQCustomMenu, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, null);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, boolean paramBoolean)
  {
    this.b = paramQQCustomMenu;
    this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = null;
    Object localObject;
    int i;
    if ((paramBoolean) && (paramQQCustomMenu != null))
    {
      localObject = paramQQCustomMenu.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        paramQQCustomMenu = new ArrayList(Arrays.asList((Object[])localObject));
        i = 0;
        if (i >= localObject.length) {
          break label161;
        }
        if (localObject[i].a() != 2131365448) {}
      }
    }
    for (;;)
    {
      localObject = new QQCustomMenuItem(2131377708, HardCodeUtil.a(2131702293));
      ((QQCustomMenuItem)localObject).a(2130839070);
      paramQQCustomMenu.add(i + 1, localObject);
      this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
      paramQQCustomMenu = paramQQCustomMenu.iterator();
      for (;;)
      {
        if (paramQQCustomMenu.hasNext())
        {
          localObject = (QQCustomMenuItem)paramQQCustomMenu.next();
          this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a((QQCustomMenuItem)localObject);
          continue;
          i += 1;
          break;
        }
      }
      return;
      label161:
      i = 0;
    }
  }
  
  public void a(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener = paramOnDismissListener;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b());
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper
 * JD-Core Version:    0.7.0.1
 */