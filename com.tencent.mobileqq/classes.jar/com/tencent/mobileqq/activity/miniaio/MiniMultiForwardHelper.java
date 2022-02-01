package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MiniMultiForwardHelper
  implements ILifeCycleHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private MiniPie jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  
  public MiniMultiForwardHelper(MiniPie paramMiniPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramMiniPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie = paramMiniPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramMiniPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public String getTag()
  {
    return "MiniMultiForwardHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RESUME onMoveToState：=");
    localStringBuilder.append(paramInt);
    QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
    if (paramInt != 7)
    {
      if (paramInt != 11) {
        return;
      }
      BaseChatItemLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESUME mPreCheckBoxVisibleStat：=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("  BaseChatItemLayout.CheckBoxVisible :");
      localStringBuilder.append(BaseChatItemLayout.jdField_a_of_type_Boolean);
      QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Boolean = BaseChatItemLayout.jdField_a_of_type_Boolean;
    BaseChatItemLayout.jdField_a_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("RESUME mPreCheckBoxVisibleStat：=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("  BaseChatItemLayout.CheckBoxVisible :");
    localStringBuilder.append(BaseChatItemLayout.jdField_a_of_type_Boolean);
    QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */