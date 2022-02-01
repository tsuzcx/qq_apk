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
  public static Map<Integer, ColorStateList> a;
  protected int a;
  public Context a;
  protected Drawable a;
  protected BuddyListItem.BuddyListCallback a;
  protected BuddyListAdapter a;
  public QQAppInterface a;
  public Entity a;
  protected SwipRightMenuBuilder a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
  }
  
  protected BuddyListItem(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
  }
  
  protected static ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = paramContext.getResources().getColorStateList(paramInt);
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected Drawable a()
  {
    boolean bool = SimpleUIUtil.a();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean != bool)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    try
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!bool) {
        break label72;
      }
      i = 2130844954;
    }
    catch (Exception|OutOfMemoryError localException)
    {
      for (;;)
      {
        Resources localResources;
        continue;
        int i = 2130844953;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(i);
    this.jdField_a_of_type_Boolean = bool;
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public abstract View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = ViewUtils.a(152.0F);
    int j = a();
    int k = b();
    paramContext = a();
    int[] arrayOfInt1 = b();
    int[] arrayOfInt2 = c();
    return new BuddyListItem.1(this, j, k, new int[] { i }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem) {}
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity, paramViewTag, paramOnClickListener);
    } else {
      i = 0;
    }
    paramViewTag = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter;
    if ((paramViewTag != null) && (paramViewTag.jdField_a_of_type_Int != -1))
    {
      if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.jdField_a_of_type_Int)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  public void a(BuddyListItem.BuddyListCallback paramBuddyListCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseBuddyListItem$BuddyListCallback = paramBuddyListCallback;
  }
  
  protected int[] a()
  {
    return null;
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected int[] b()
  {
    return null;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.BuddyListItem
 * JD-Core Version:    0.7.0.1
 */