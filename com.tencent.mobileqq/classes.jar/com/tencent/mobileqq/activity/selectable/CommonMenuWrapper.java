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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate != null) {
      return;
    }
    throw new IllegalStateException("Delegate has not bound.");
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public CommonMenuWrapper.MenuPlaceInfo a(View paramView, BaseChatPie paramBaseChatPie)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int k = 1;
    int n = arrayOfInt[1];
    int i1 = arrayOfInt[1];
    int i2 = paramView.getHeight();
    paramView = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      paramView = paramBaseChatPie;
      if ((this instanceof AIOMenuWrapper)) {
        paramView = ((AIOMenuWrapper)this).a;
      }
    }
    int i;
    if ((paramView != null) && (paramView.a != null) && (paramView.a.getVisibility() == 0))
    {
      paramView.a.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[1];
    }
    else
    {
      i = ViewUtils.b();
    }
    int m = n + 0;
    int i3 = e;
    int i4 = ImmersiveUtils.statusHeight;
    int j = 0;
    if (m < i3 + i4)
    {
      m = i1 + i2 + 0;
      if (m < e + ImmersiveUtils.statusHeight)
      {
        k = this.jdField_a_of_type_Int;
        if ((k != 0) && (k - 0 > e + ImmersiveUtils.statusHeight))
        {
          i = this.jdField_a_of_type_Int - 0;
        }
        else
        {
          k = this.jdField_a_of_type_Int;
          if ((k != 0) && (f + k - 0 < i))
          {
            i = k + 0;
            j = 1;
          }
          else
          {
            i = e + ImmersiveUtils.statusHeight;
          }
        }
      }
      else
      {
        j = m;
        if (f + m > i)
        {
          j = this.jdField_a_of_type_Int;
          if ((j != 0) && (j - 0 > e + ImmersiveUtils.statusHeight))
          {
            i = this.jdField_a_of_type_Int + 0;
          }
          else
          {
            j = this.jdField_a_of_type_Int;
            if ((j != 0) && (f + j - 0 < i))
            {
              j += 0;
              break label328;
            }
            i = e + ImmersiveUtils.statusHeight + f + 0;
          }
          j = 0;
          break label335;
        }
        label328:
        i = j;
        j = k;
      }
    }
    else
    {
      label335:
      if (n <= i) {
        i = m;
      }
    }
    return new CommonMenuWrapper.MenuPlaceInfo(i, j);
  }
  
  @Nullable
  public SelectableDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  }
  
  public void a()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a() == i - j)
      {
        localQQCustomMenu = this.b;
      }
      else
      {
        localQQCustomMenu = this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
        if (localQQCustomMenu == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
            this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131365311, HardCodeUtil.a(2131702424), 2130838903);
            this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131377136, HardCodeUtil.a(2131702422), 2130838923);
            this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131367180, HardCodeUtil.a(2131702426), 2130838912);
            this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(2131366494, HardCodeUtil.a(2131702423), 2130838911);
          }
          localQQCustomMenu = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
        }
      }
    }
    else
    {
      localQQCustomMenu = this.b;
    }
    a(localQQCustomMenu, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, int paramInt3, boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, Integer paramInteger)
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    paramQQCustomMenu = BubbleContextMenu.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramQQCustomMenu.setIgnoreTouchLocation(paramBoolean2);
    paramQQCustomMenu.setContainerBottom(paramInteger);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setContentView(paramQQCustomMenu);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOutsideTouchable(paramBoolean1);
    paramBoolean2 = true;
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setFocusable(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setSoftInputMode(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setInputMethodMode(2);
    paramQQCustomMenu = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == 1) {
      paramBoolean1 = paramBoolean2;
    } else {
      paramBoolean1 = false;
    }
    paramQQCustomMenu.setKeepAbove(paramBoolean1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOnDismissListener(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener);
    paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
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
    if ((paramBoolean) && (paramQQCustomMenu != null))
    {
      Object localObject = paramQQCustomMenu.a();
      if ((localObject != null) && (localObject.length > 0))
      {
        paramQQCustomMenu = new ArrayList(Arrays.asList((Object[])localObject));
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= localObject.length) {
            break;
          }
          if (localObject[i].a() == 2131365311)
          {
            j = i;
            break;
          }
          i += 1;
        }
        localObject = new QQCustomMenuItem(2131377136, HardCodeUtil.a(2131702425));
        ((QQCustomMenuItem)localObject).a(2130838923);
        paramQQCustomMenu.add(j + 1, localObject);
        this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
        paramQQCustomMenu = paramQQCustomMenu.iterator();
        while (paramQQCustomMenu.hasNext())
        {
          localObject = (QQCustomMenuItem)paramQQCustomMenu.next();
          this.jdField_c_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a((QQCustomMenuItem)localObject);
        }
      }
    }
  }
  
  public void a(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener = paramOnDismissListener;
  }
  
  public boolean a()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    return (localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper
 * JD-Core Version:    0.7.0.1
 */