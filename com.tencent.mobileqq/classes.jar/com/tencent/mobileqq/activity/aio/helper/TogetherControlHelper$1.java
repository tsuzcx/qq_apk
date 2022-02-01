package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;

class TogetherControlHelper$1
  extends TogetherObserver
{
  TogetherControlHelper$1(TogetherControlHelper paramTogetherControlHelper) {}
  
  public void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    int i = 1;
    if (!TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramTogetherSession.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, paramTogetherSession, paramInt, paramString);
    }
    label180:
    label250:
    label255:
    do
    {
      return;
      if (paramBoolean)
      {
        TogetherControlHelper.a(this.a).setTogetherSession(paramTogetherSession);
        if (paramTogetherSession.h == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramTogetherSession.jdField_e_of_type_Int), " session.userState=", Integer.valueOf(paramTogetherSession.i), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!TogetherUtils.a(TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTogetherSession)) || (TogetherWatchFloatingUtil.a(paramTogetherSession.jdField_e_of_type_Int, paramTogetherSession.jdField_e_of_type_JavaLangString, paramTogetherSession.f)) || (this.a.e())) {
              break label250;
            }
            paramInt = i;
            if (paramInt != 0) {
              break label255;
            }
            this.a.b();
          }
        }
        for (;;)
        {
          TogetherControlHelper.a(this.a);
          TogetherControlHelper.a(this.a, paramTogetherSession);
          return;
          switch (paramTogetherSession.i)
          {
          default: 
            paramBoolean = false;
            break;
          case 1: 
          case 2: 
          case 3: 
            paramBoolean = true;
            break;
            paramInt = 0;
            break label180;
            TogetherControlHelper.a(this.a);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState false, ", Integer.valueOf(paramInt), " ", paramString });
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2)
    {
      if (((paramObject instanceof TroopUnreadMsgInfo)) && (TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((TroopUnreadMsgInfo)paramObject).a)) && ((TogetherControlHelper.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)TogetherControlHelper.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.1
 * JD-Core Version:    0.7.0.1
 */