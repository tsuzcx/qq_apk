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
  private static final int l = ViewUtils.dpToPx(72.0F);
  private static final int m = ViewUtils.dpToPx(63.0F);
  private SelectableDelegate a;
  QQCustomMenu b;
  public int c;
  public int d;
  private BubblePopupWindow e;
  private View.OnClickListener f;
  private BubblePopupWindow.OnDismissListener g;
  private QQCustomMenu h;
  private QQCustomMenu i;
  private int j;
  private int k;
  
  private void h()
  {
    if (this.a != null) {
      return;
    }
    throw new IllegalStateException("Delegate has not bound.");
  }
  
  public CommonMenuWrapper.MenuPlaceInfo a(View paramView, BaseChatPie paramBaseChatPie)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i2 = 1;
    int i4 = arrayOfInt[1];
    int i5 = arrayOfInt[1];
    int i6 = paramView.getHeight();
    paramView = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      paramView = paramBaseChatPie;
      if ((this instanceof AIOMenuWrapper)) {
        paramView = ((AIOMenuWrapper)this).a;
      }
    }
    int n;
    if ((paramView != null) && (paramView.X != null) && (paramView.X.getVisibility() == 0))
    {
      paramView.X.getLocationInWindow(arrayOfInt);
      n = arrayOfInt[1];
    }
    else
    {
      n = ViewUtils.getScreenHeight();
    }
    int i3 = i4 + 0;
    int i7 = l;
    int i8 = ImmersiveUtils.statusHeight;
    int i1 = 0;
    if (i3 < i7 + i8)
    {
      i3 = i5 + i6 + 0;
      if (i3 < l + ImmersiveUtils.statusHeight)
      {
        i2 = this.c;
        if ((i2 != 0) && (i2 - 0 > l + ImmersiveUtils.statusHeight))
        {
          n = this.c - 0;
        }
        else
        {
          i2 = this.c;
          if ((i2 != 0) && (m + i2 - 0 < n))
          {
            n = i2 + 0;
            i1 = 1;
          }
          else
          {
            n = l + ImmersiveUtils.statusHeight;
          }
        }
      }
      else
      {
        i1 = i3;
        if (m + i3 > n)
        {
          i1 = this.c;
          if ((i1 != 0) && (i1 - 0 > l + ImmersiveUtils.statusHeight))
          {
            n = this.c + 0;
          }
          else
          {
            i1 = this.c;
            if ((i1 != 0) && (m + i1 - 0 < n))
            {
              i1 += 0;
              break label328;
            }
            n = l + ImmersiveUtils.statusHeight + m + 0;
          }
          i1 = 0;
          break label335;
        }
        label328:
        n = i1;
        i1 = i2;
      }
    }
    else
    {
      label335:
      if (i4 <= n) {
        n = i3;
      }
    }
    return new CommonMenuWrapper.MenuPlaceInfo(n, i1);
  }
  
  public void a()
  {
    QQCustomMenu localQQCustomMenu = this.b;
    if (localQQCustomMenu != null)
    {
      localQQCustomMenu.a(2131431492, HardCodeUtil.a(2131900427), 2130839057);
      this.b.a(2131445511, HardCodeUtil.a(2131900425), 2130839077);
      this.b.a(2131433636, HardCodeUtil.a(2131900429), 2130839066);
      this.b.a(2131432813, HardCodeUtil.a(2131900426), 2130839065);
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    h();
    QQCustomMenu localQQCustomMenu;
    if (this.a.l())
    {
      int n = this.a.f();
      int i1 = this.a.e();
      if (this.a.c() == n - i1)
      {
        localQQCustomMenu = this.h;
      }
      else
      {
        localQQCustomMenu = this.i;
        if (localQQCustomMenu == null)
        {
          if (this.b == null)
          {
            this.b = new QQCustomMenu();
            a();
          }
          localQQCustomMenu = this.b;
        }
      }
    }
    else
    {
      localQQCustomMenu = this.h;
    }
    a(localQQCustomMenu, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, int paramInt3, boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, Integer paramInteger)
  {
    BubblePopupWindow localBubblePopupWindow = this.e;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing()))
    {
      this.e.dismiss();
      this.e = null;
    }
    this.e = new BubblePopupWindow(-2, -2);
    paramQQCustomMenu = BubbleContextMenu.a(this.e, paramView.getContext(), paramQQCustomMenu, this.f);
    paramQQCustomMenu.setIgnoreTouchLocation(paramBoolean2);
    paramQQCustomMenu.setContainerBottom(paramInteger);
    this.e.setContentView(paramQQCustomMenu);
    this.e.setBackgroundDrawable(new ColorDrawable(0));
    this.e.setOutsideTouchable(paramBoolean1);
    paramBoolean2 = true;
    if (paramBoolean1) {
      this.e.setFocusable(true);
    }
    this.e.setSoftInputMode(1);
    this.e.setInputMethodMode(2);
    paramQQCustomMenu = this.e;
    if (paramInt3 == 1) {
      paramBoolean1 = paramBoolean2;
    } else {
      paramBoolean1 = false;
    }
    paramQQCustomMenu.setKeepAbove(paramBoolean1);
    this.e.setOnDismissListener(this.g);
    paramView.post(new CommonMenuWrapper.1(this, paramActivity, paramView, paramInt1, paramInt2));
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, boolean paramBoolean, int paramInt3, Activity paramActivity)
  {
    this.h = paramQQCustomMenu;
    this.i = null;
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, paramActivity, false, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, boolean paramBoolean, int paramInt3, Integer paramInteger)
  {
    this.h = paramQQCustomMenu;
    this.i = null;
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, paramBoolean, null, true, paramInteger);
  }
  
  public void a(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.a = paramSelectableDelegate;
  }
  
  void a(QQCustomMenu paramQQCustomMenu, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, null);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, boolean paramBoolean)
  {
    this.h = paramQQCustomMenu;
    this.i = null;
    if ((paramBoolean) && (paramQQCustomMenu != null))
    {
      Object localObject = paramQQCustomMenu.d();
      if ((localObject != null) && (localObject.length > 0))
      {
        paramQQCustomMenu = new ArrayList(Arrays.asList((Object[])localObject));
        int i2 = 0;
        int n = 0;
        int i1;
        for (;;)
        {
          i1 = i2;
          if (n >= localObject.length) {
            break;
          }
          if (localObject[n].b() == 2131431492)
          {
            i1 = n;
            break;
          }
          n += 1;
        }
        localObject = new QQCustomMenuItem(2131445511, HardCodeUtil.a(2131900428));
        ((QQCustomMenuItem)localObject).a(2130839077);
        paramQQCustomMenu.add(i1 + 1, localObject);
        this.i = new QQCustomMenu();
        paramQQCustomMenu = paramQQCustomMenu.iterator();
        while (paramQQCustomMenu.hasNext())
        {
          localObject = (QQCustomMenuItem)paramQQCustomMenu.next();
          this.i.a((QQCustomMenuItem)localObject);
        }
      }
    }
  }
  
  public void a(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.g = paramOnDismissListener;
  }
  
  @Nullable
  public SelectableDelegate b()
  {
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public boolean e()
  {
    BubblePopupWindow localBubblePopupWindow = this.e;
    return (localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing());
  }
  
  public void f()
  {
    BubblePopupWindow localBubblePopupWindow = this.e;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.e.dismiss();
    }
  }
  
  public void g()
  {
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper
 * JD-Core Version:    0.7.0.1
 */