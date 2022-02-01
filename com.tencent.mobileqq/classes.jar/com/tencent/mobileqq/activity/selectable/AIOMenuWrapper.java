package com.tencent.mobileqq.activity.selectable;

import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class AIOMenuWrapper
  extends CommonMenuWrapper
{
  protected final BaseChatPie a;
  private int[] a;
  
  public AIOMenuWrapper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  void a(QQCustomMenu paramQQCustomMenu, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramQQCustomMenu != null) && (paramQQCustomMenu.a() > 0))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null)
      {
        if (((BaseChatPie)localObject).d() < 8)
        {
          if ((this.jdField_a_of_type_ArrayOfInt == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
          {
            this.jdField_a_of_type_ArrayOfInt = new int[2];
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          }
          localObject = this.jdField_a_of_type_ArrayOfInt;
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = Integer.valueOf(localObject[1]);
          }
          a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, (Integer)localObject);
        }
      }
      else {
        a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOMenuWrapper
 * JD-Core Version:    0.7.0.1
 */