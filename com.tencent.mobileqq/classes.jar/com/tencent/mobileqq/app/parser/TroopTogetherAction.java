package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class TroopTogetherAction
  extends JumpActionBase
{
  public TroopTogetherAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a()
  {
    Object localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject1 != null) && (((ChatFragment)localObject1).a() != null))
    {
      localObject1 = ((ChatFragment)localObject1).a();
      if ((localObject1 != null) && ((localObject1 instanceof TroopChatPie)))
      {
        localObject1 = (TroopChatPie)localObject1;
        Object localObject2 = (TogetherControlHelper)((TroopChatPie)localObject1).a(43);
        if (localObject2 != null) {
          ((TogetherControlHelper)localObject2).a(2);
        }
        localObject2 = new HashMap();
        if ((((TroopChatPie)localObject1).a != null) && (!TextUtils.isEmpty(((TroopChatPie)localObject1).a.a))) {
          ((HashMap)localObject2).put("qq_group_num", ((TroopChatPie)localObject1).a.a);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          ((HashMap)localObject2).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ClockReportUtil.a("click#aio_graybar", (HashMap)localObject2);
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      a();
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("TroopOneWayAction", 1, "doAction error: " + localException.getMessage());
      a("TroopOneWayAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopTogetherAction
 * JD-Core Version:    0.7.0.1
 */