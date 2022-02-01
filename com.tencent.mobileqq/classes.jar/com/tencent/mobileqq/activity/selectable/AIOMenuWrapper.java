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
    Integer localInteger = null;
    if ((paramQQCustomMenu != null) && (paramQQCustomMenu.a() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        break label107;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h() < 8)
      {
        if ((this.jdField_a_of_type_ArrayOfInt == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
        {
          this.jdField_a_of_type_ArrayOfInt = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
        }
        if (this.jdField_a_of_type_ArrayOfInt != null) {
          break label93;
        }
      }
    }
    for (;;)
    {
      a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, localInteger);
      return;
      label93:
      localInteger = Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]);
    }
    label107:
    a(paramView, paramInt1, paramInt2, paramQQCustomMenu, paramInt3, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOMenuWrapper
 * JD-Core Version:    0.7.0.1
 */