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
  public static final int[] b = { 2130839649, 2130839648, 2130839648, 2130839648, 2130839650, 2130839650, 2130839648, 2130839648, 2130839648, 2130839650 };
  public static final int[] c = { 2131371177, 2131371194, 2131371173, 2131371187, 2131371184, 2131371185, 2131371197, 2131371193, 2131371192, 2131371172 };
  protected RecentAdapter a;
  protected SwipRightMenuBuilder a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691558, 2131691356, 2131691339, 2131691342, 2131691340, 2131691341, 2131694370, 2131693109, 2131693107, 2131691338 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a()))
    {
      if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder == null) {
        this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
      }
      return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramRecentItemBaseHolder, -1);
    }
    paramRecentItemBaseHolder.g = localView;
    paramRecentItemBaseHolder.a = null;
    return localView;
  }
  
  public SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298882);
    int j = paramContext.getResources().getDimensionPixelSize(2131298883);
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
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramRecentItemBaseHolder, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a))
      {
        NearbyUtils.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
        return;
        if (j == 0) {
          break;
        }
        paramView.scrollTo(0, 0);
        break;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */