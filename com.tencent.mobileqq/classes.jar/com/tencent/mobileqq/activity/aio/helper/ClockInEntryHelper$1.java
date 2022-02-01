package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.Ret;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusBase;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusDoneInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteRsp;

class ClockInEntryHelper$1
  extends TroopClockInObserver
{
  ClockInEntryHelper$1(ClockInEntryHelper paramClockInEntryHelper) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof oidb_0xeb7.StSignInWriteRsp)))
    {
      paramObject = (oidb_0xeb7.StSignInWriteRsp)paramObject;
      if (paramObject.ret.code.get() != 0)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("onSetClockInStatus error code: ");
          paramString2.append(paramObject.ret.code.get());
          paramString2.append(" ");
          if (paramObject.ret.msg.has()) {
            paramString1 = paramObject.ret.msg.get();
          } else {
            paramString1 = "";
          }
          paramString2.append(paramString1);
          QLog.d("ClockInEntryHelper.helper", 2, paramString2.toString());
        }
        return;
      }
      paramBoolean = paramObject.doneInfo.has();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onSetClockInStatus isDoneClockin: ");
        paramString2.append(paramBoolean);
        QLog.d("ClockInEntryHelper.helper", 2, paramString2.toString());
      }
      if (paramBoolean)
      {
        if ((paramString1.equals(ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (ClockInEntryHelper.a(this.a)))
        {
          ClockInEntryHelper.a(this.a, false, false, false);
          paramString1 = ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
          int i;
          if (AnonymousChatHelper.a().a(ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
            i = 2130850788;
          } else {
            i = 2130850789;
          }
          paramString1.setRight2Icon(i);
        }
        long l = NetConnInfoCenter.getServerTime();
        paramString1 = this.a;
        ClockInEntryHelper.b(paramString1, ClockInEntryHelper.a(paramString1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onSetClockInStatus failed");
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof oidb_0xeb7.StSignInStatusRsp)))
    {
      paramObject = (oidb_0xeb7.StSignInStatusRsp)paramObject;
      if (paramObject.ret.code.get() != 0)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("onGetClockInStatus error code: ");
          paramString2.append(paramObject.ret.code.get());
          paramString2.append(" ");
          if (paramObject.ret.msg.has()) {
            paramString1 = paramObject.ret.msg.get();
          } else {
            paramString1 = "";
          }
          paramString2.append(paramString1);
          QLog.d("ClockInEntryHelper.helper", 2, paramString2.toString());
        }
        return;
      }
      paramInt = ((oidb_0xeb7.SignInStatusBase)paramObject.base.get()).status.get();
      paramBoolean = true;
      if (paramInt != 1) {
        paramBoolean = false;
      }
      long l = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onGetClockInStatus hasSignedIn: ");
        paramString2.append(paramBoolean);
        QLog.d("ClockInEntryHelper.helper", 2, paramString2.toString());
      }
      if (ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getVisibility() == 0)
      {
        if (!ClockInEntryHelper.a(this.a))
        {
          if (ClockInEntryHelper.a(this.a) != null) {
            ClockInEntryHelper.a(this.a).setVisibility(8);
          }
        }
        else if (paramString1.equals(ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          paramString1 = this.a;
          ClockInEntryHelper.a(paramString1, paramBoolean ^ true, ClockInEntryHelper.b(paramString1), false);
          if (paramBoolean)
          {
            paramString1 = ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
            if (AnonymousChatHelper.a().a(ClockInEntryHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
              paramInt = 2130850788;
            } else {
              paramInt = 2130850789;
            }
            paramString1.setRight2Icon(paramInt);
          }
        }
        paramString1 = this.a;
        ClockInEntryHelper.a(paramString1, ClockInEntryHelper.a(paramString1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
      }
      if (paramBoolean)
      {
        paramString1 = this.a;
        ClockInEntryHelper.b(paramString1, ClockInEntryHelper.a(paramString1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onGetClockInStatus failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper.1
 * JD-Core Version:    0.7.0.1
 */