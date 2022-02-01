package com.tencent.mobileqq.activity.aio.helper;

import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
        if ((paramString1.equals(ClockInEntryHelper.a(this.a).ah.b)) && (ClockInEntryHelper.b(this.a)))
        {
          ClockInEntryHelper.a(this.a, false, false);
          paramString1 = ClockInEntryHelper.a(this.a).p;
          int i;
          if (AnonymousChatHelper.a().a(ClockInEntryHelper.a(this.a).ah.b)) {
            i = 2130852610;
          } else {
            i = 2130852611;
          }
          paramString1.setRight2Icon(i);
        }
        long l = NetConnInfoCenter.getServerTime();
        paramString1 = this.a;
        ClockInEntryHelper.b(paramString1, ClockInEntryHelper.a(paramString1).ah.b, l);
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
      if (ClockInEntryHelper.a(this.a).p.getVisibility() == 0)
      {
        if (!ClockInEntryHelper.b(this.a))
        {
          if (ClockInEntryHelper.c(this.a) != null) {
            ClockInEntryHelper.c(this.a).setVisibility(8);
          }
        }
        else if (paramString1.equals(ClockInEntryHelper.a(this.a).ah.b))
        {
          ClockInEntryHelper.a(this.a, paramBoolean ^ true, false);
          if (paramBoolean)
          {
            paramString1 = ClockInEntryHelper.a(this.a).p;
            if (AnonymousChatHelper.a().a(ClockInEntryHelper.a(this.a).ah.b)) {
              paramInt = 2130852610;
            } else {
              paramInt = 2130852611;
            }
            paramString1.setRight2Icon(paramInt);
          }
        }
        paramString1 = this.a;
        ClockInEntryHelper.a(paramString1, ClockInEntryHelper.a(paramString1).ah.b, l);
      }
      if (paramBoolean)
      {
        paramString1 = this.a;
        ClockInEntryHelper.b(paramString1, ClockInEntryHelper.a(paramString1).ah.b, l);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onGetClockInStatus failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper.1
 * JD-Core Version:    0.7.0.1
 */