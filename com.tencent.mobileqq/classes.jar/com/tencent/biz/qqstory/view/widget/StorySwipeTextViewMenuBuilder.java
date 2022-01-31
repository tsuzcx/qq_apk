package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.Stack;

public abstract class StorySwipeTextViewMenuBuilder
  extends SwipTextViewMenuBuilder
{
  public StorySwipeTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (paramSwipItemBaseHolder == null) || (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem == null) || (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem.length == 0) || (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem);
    int j = 0;
    int n = 0;
    if (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_Int)) {
        a(paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n]);
      }
      paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_Int;
      paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].b = this.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].b;
      paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].c = 0;
      paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].d = -1;
      int k = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_Int;
      Object localObject1 = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_AndroidViewView;
      int m;
      if ((k < 0) || (k >= this.jdField_a_of_type_ArrayOfJavaUtilStack.length))
      {
        m = j;
        k = i;
        if (localObject1 == null) {
          break label532;
        }
        ((View)localObject1).setVisibility(8);
        k = j + 1;
        j = i;
        i = k;
      }
      for (;;)
      {
        n += 1;
        k = j;
        j = i;
        i = k;
        break;
        int i1;
        if (localObject1 == null)
        {
          synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
          {
            if (!this.jdField_a_of_type_ArrayOfJavaUtilStack[k].isEmpty()) {
              localObject1 = (View)this.jdField_a_of_type_ArrayOfJavaUtilStack[k].pop();
            }
            ??? = localObject1;
            if (localObject1 == null) {
              ??? = a(paramContext, k);
            }
            if (??? == null) {
              throw new NullPointerException("updateRightMenuView menuView is null");
            }
          }
          paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n], paramOnClickListener);
          if (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].c);
          i1 = 0;
        }
        i += paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n].c;
        j += 1;
        ((View)localObject1).setVisibility(0);
        m = j;
        k = i;
        if (i1 != 0)
        {
          a(localLinearLayout, (View)localObject1, paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentWidgetSwipRightMenuBuilder$SwipRightMenuItem[n], j);
          k = i;
          m = j;
        }
        label532:
        i = m;
        j = k;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramSwipRightMenuItem = new LinearLayout.LayoutParams(paramSwipRightMenuItem.c, paramSwipRightMenuItem.d);
      paramView.setLayoutParams(paramSwipRightMenuItem);
    }
    for (;;)
    {
      paramSwipRightMenuItem.gravity = 16;
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramSwipRightMenuItem.c;
      localLayoutParams.height = paramSwipRightMenuItem.d;
      paramSwipRightMenuItem = localLayoutParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StorySwipeTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */