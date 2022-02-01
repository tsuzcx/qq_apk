package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

public class DelMenuBuilder
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691558 };
  private static final int[] b = { 2130839649 };
  private static final int[] c = { 2131371177 };
  Context jdField_a_of_type_AndroidContentContext;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  
  public DelMenuBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public View a(Context paramContext, int paramInt, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramSwipItemBaseHolder, -1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298882);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298883);
    int[] arrayOfInt1 = c;
    int[] arrayOfInt2 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt3 = b;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = new DelMenuBuilder.1(this, 1, 2, new int[] { i, j }, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }
  
  public void a(Context paramContext, View paramView, int paramInt1, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt1, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      if (paramInt2 != -1)
      {
        if (paramInt1 != paramInt2) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DelMenuBuilder
 * JD-Core Version:    0.7.0.1
 */