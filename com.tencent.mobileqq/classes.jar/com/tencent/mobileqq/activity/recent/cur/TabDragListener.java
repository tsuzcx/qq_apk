package com.tencent.mobileqq.activity.recent.cur;

import android.view.View;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class TabDragListener
  implements DragFrameLayout.OnDragListener
{
  public View a;
  public TabDragAnimationView a;
  private boolean a;
  
  public TabDragListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = paramTabDragAnimationView;
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        if (!localView.equals(paramView)) {
          return;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("drag detect x=");
          paramView.append(paramFloat1);
          paramView.append(",y=");
          paramView.append(paramFloat2);
          paramView.append(",dragType=");
          paramView.append(paramInt);
          QLog.d("TabDragListener", 2, paramView.toString());
        }
        if ((paramInt != 1) && (paramInt != 2))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.b();
          }
        }
        else
        {
          if (!this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c();
          }
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a(paramFloat1, paramFloat2, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.TabDragListener
 * JD-Core Version:    0.7.0.1
 */