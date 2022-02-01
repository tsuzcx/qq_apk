package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;

public class TempMsgBoxAIOHelper
  implements ILifeCycleHelper
{
  public static String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TempMsgBoxAIOHelper";
  }
  
  public TempMsgBoxAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
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
        localObject = ((TempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
        i = paramInt;
        if (localConversationFacade != null) {
          i = RecentItemTempMsgBoxData.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, localConversationFacade);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TempMsgBoxAIOHelper
 * JD-Core Version:    0.7.0.1
 */