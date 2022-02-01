package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import java.util.HashMap;
import java.util.Map;

public abstract class BuddyListItem
{
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, ColorStateList> c = new HashMap(5);
  protected SwipRightMenuBuilder a;
  protected int b;
  public QQAppInterface d;
  public Context e;
  public Entity f;
  protected BuddyListAdapter g;
  protected BuddyListItem.BuddyListCallback h;
  protected Drawable i = null;
  protected boolean j;
  
  protected BuddyListItem(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    this.d = paramQQAppInterface;
    this.e = paramContext;
    this.f = paramEntity;
  }
  
  protected static ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)c.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = paramContext.getResources().getColorStateList(paramInt);
      c.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  protected int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int k = ViewUtils.dip2px(152.0F);
    int m = a();
    int n = b();
    paramContext = c();
    int[] arrayOfInt1 = d();
    int[] arrayOfInt2 = e();
    return new BuddyListItem.1(this, m, n, new int[] { k }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem) {}
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.a;
    int k;
    if (localSwipRightMenuBuilder != null) {
      k = localSwipRightMenuBuilder.updateRightMenuView(this.e, paramView, paramInt, this.f, paramViewTag, paramOnClickListener);
    } else {
      k = 0;
    }
    paramViewTag = this.g;
    if ((paramViewTag != null) && (paramViewTag.b != -1))
    {
      if (paramInt != this.g.b)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(k, 0);
    }
  }
  
  public void a(BuddyListItem.BuddyListCallback paramBuddyListCallback)
  {
    this.h = paramBuddyListCallback;
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected int[] c()
  {
    return null;
  }
  
  protected int[] d()
  {
    return null;
  }
  
  protected int[] e()
  {
    return null;
  }
  
  public int f()
  {
    return this.b;
  }
  
  protected Drawable g()
  {
    boolean bool = SimpleUIUtil.e();
    if ((this.i != null) && (this.j != bool)) {
      this.i = null;
    }
    if (this.i == null) {}
    try
    {
      this.i = this.e.getResources().getDrawable(2130846389);
      this.j = bool;
      label52:
      return this.i;
    }
    catch (Exception|OutOfMemoryError localException)
    {
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.BuddyListItem
 * JD-Core Version:    0.7.0.1
 */