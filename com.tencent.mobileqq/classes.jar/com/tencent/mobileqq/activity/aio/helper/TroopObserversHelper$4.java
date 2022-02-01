package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopObserversHelper$4
  extends TroopOnlineMemberObserver
{
  TroopObserversHelper$4(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, TroopObserversHelper.a(this.a).a().a))
    {
      paramString2 = (ITroopOnlineMemberService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopOnlineMemberService.class, "");
      TroopObserversHelper.a(this.a).a(paramString1, true);
      if ((paramBoolean) && (TroopObserversHelper.a(this.a) != null) && (TroopObserversHelper.a(this.a).isResume()))
      {
        long l = (paramString2.getAIOTipsNextReqTime(TroopObserversHelper.a(this.a).a().a) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("mGetOnlineMemberTipsRunnable, delay = ");
          paramString1.append(l);
          QLog.i("TroopObserversHelper", 2, paramString1.toString());
        }
        paramString1 = TroopObserversHelper.a(this.a).a();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramString1);
        ThreadManager.getUIHandler().post(new TroopObserversHelper.4.1(this, paramString1, l));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopObserversHelper.a(this.a).aD();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    paramString2 = TroopObserversHelper.a(this.a).a();
    if (!TroopObserversHelper.a(this.a).B)
    {
      if (paramString2 == null) {
        return;
      }
      if ((TextUtils.equals(paramString1, TroopObserversHelper.a(this.a).a().a)) && (!TroopObserversHelper.a(this.a).v()) && (!ChatPieTipsBarHelper.a(TroopObserversHelper.a(this.a))))
      {
        if (!paramBoolean)
        {
          paramString2.a(2);
          return;
        }
        String str = ((ITroopOnlineMemberService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopOnlineMemberService.class, "")).getOnlineTip(paramString1);
        if (!TextUtils.isEmpty(str))
        {
          TroopObserversHelper.a(this.a).a(true);
          TroopObserversHelper.a(this.a).f.setText(str);
        }
        if (paramString2 != null)
        {
          paramString2.a(paramString1);
          if (paramString2.a())
          {
            paramString2.d();
            TroopObserversHelper.a(this.a).m(true);
            return;
          }
          paramString2.a(0);
          TroopObserversHelper.a(this.a).m(false);
          return;
        }
        TroopObserversHelper.a(this.a).m(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopObserversHelper.a(this.a).aD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.4
 * JD-Core Version:    0.7.0.1
 */