package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;

class TogetherControlHelper$1
  extends TogetherObserver
{
  TogetherControlHelper$1(TogetherControlHelper paramTogetherControlHelper) {}
  
  protected void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    if (!TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramTogetherSession.jdField_e_of_type_JavaLangString))
    {
      super.a(paramBoolean, paramTogetherSession, paramInt, paramString);
      return;
    }
    int i = 0;
    if (paramBoolean)
    {
      TogetherControlHelper.a(this.a).setTogetherSession(paramTogetherSession);
      if (paramTogetherSession.h == 3)
      {
        this.a.b();
      }
      else
      {
        paramInt = paramTogetherSession.i;
        if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
          break label95;
        }
      }
      paramBoolean = false;
      break label97;
      label95:
      paramBoolean = true;
      label97:
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramTogetherSession.jdField_e_of_type_Int), " session.userState=", Integer.valueOf(paramTogetherSession.i), " needPanel=", Boolean.valueOf(paramBoolean) });
      }
      if (paramBoolean)
      {
        paramInt = i;
        if (TogetherUtils.a(TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTogetherSession))
        {
          paramInt = i;
          if (!TogetherWatchFloatingUtil.a(paramTogetherSession.jdField_e_of_type_Int, paramTogetherSession.jdField_e_of_type_JavaLangString, paramTogetherSession.f))
          {
            paramInt = i;
            if (!this.a.e()) {
              paramInt = 1;
            }
          }
        }
        if (paramInt == 0) {
          this.a.b();
        } else {
          TogetherControlHelper.a(this.a);
        }
      }
      TogetherControlHelper.a(this.a);
      TogetherControlHelper.a(this.a, paramTogetherSession);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState false, ", Integer.valueOf(paramInt), " ", paramString });
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2)
    {
      if (((paramObject instanceof TroopUnreadMsgInfo)) && (TogetherControlHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((TroopUnreadMsgInfo)paramObject).a)) && (TogetherControlHelper.a(this.a) != null)) {
        TogetherControlHelper.a(this.a).a(1000, new Object[0]);
      }
    }
    else {
      super.onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.1
 * JD-Core Version:    0.7.0.1
 */