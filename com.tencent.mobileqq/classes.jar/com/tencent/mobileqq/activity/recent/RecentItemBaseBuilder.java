package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.ThemeImageWrapper;
import java.util.List;

public abstract class RecentItemBaseBuilder
{
  public static final int[] a;
  public static final int[] b = { 2130839507, 2130839506, 2130839506, 2130839506, 2130839508, 2130839508, 2130839506, 2130839506, 2130839506, 2130839508 };
  public static final int[] c = { 2131370801, 2131370819, 2131370797, 2131370812, 2131370809, 2131370810, 2131370822, 2131370818, 2131370817, 2131370796 };
  protected RecentAdapter a;
  protected SwipRightMenuBuilder a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691479, 2131691277, 2131691260, 2131691263, 2131691261, 2131691262, 2131694335, 2131693069, 2131693067, 2131691259 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    RecentAdapter localRecentAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if ((localRecentAdapter != null) && (localRecentAdapter.a()))
    {
      if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder == null) {
        this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
      }
      return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramRecentItemBaseHolder, -1);
    }
    paramRecentItemBaseHolder.leftView = localView;
    paramRecentItemBaseHolder.rightMenuItems = null;
    return localView;
  }
  
  public SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new RecentItemBaseBuilder.1(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramRecentItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = paramView.getScrollX();
    if (paramInt >= 0)
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if ((paramContext != null) && (paramContext.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        break label81;
      }
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
    label81:
    if ((j != 0) && (QLog.isDevelopLevel()))
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = Integer.valueOf(paramContext.a);
      }
      NearbyUtils.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new ThemeImageWrapper();
      }
      paramView.a.setSupportMaskView(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */