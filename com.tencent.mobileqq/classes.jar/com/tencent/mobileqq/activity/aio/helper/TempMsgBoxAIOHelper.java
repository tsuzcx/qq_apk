package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import java.util.List;

public class TempMsgBoxAIOHelper
  implements ILifeCycleHelper
{
  public static String a = "TempMsgBoxAIOHelper";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public TempMsgBoxAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (((Intent)localObject).getBooleanExtra("enter_from_temp_msg_box", false))
      {
        localObject = ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
        IConversationFacade localIConversationFacade = (IConversationFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IConversationFacade.class, "");
        i = paramInt;
        if (localIConversationFacade != null) {
          i = RecentItemTempMsgBoxData.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, localIConversationFacade);
        }
      }
    }
    return i;
  }
  
  @NonNull
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TempMsgBoxAIOHelper
 * JD-Core Version:    0.7.0.1
 */