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
    if (TextUtils.equals(paramString1, TroopObserversHelper.d(this.a).aE().b))
    {
      paramString2 = (ITroopOnlineMemberService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopOnlineMemberService.class, "");
      TroopObserversHelper.d(this.a).a(paramString1, true);
      if ((paramBoolean) && (TroopObserversHelper.g(this.a) != null) && (TroopObserversHelper.g(this.a).isResume()))
      {
        long l = (paramString2.getAIOTipsNextReqTime(TroopObserversHelper.d(this.a).aE().b) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("mGetOnlineMemberTipsRunnable, delay = ");
          paramString1.append(l);
          QLog.i("TroopObserversHelper", 2, paramString1.toString());
        }
        paramString1 = TroopObserversHelper.d(this.a).ce();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramString1);
        ThreadManager.getUIHandler().post(new TroopObserversHelper.4.1(this, paramString1, l));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopObserversHelper.d(this.a).bV();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    paramString2 = TroopObserversHelper.d(this.a).cb();
    if (!TroopObserversHelper.d(this.a).aY)
    {
      if (paramString2 == null) {
        return;
      }
      if ((TextUtils.equals(paramString1, TroopObserversHelper.d(this.a).aE().b)) && (!TroopObserversHelper.d(this.a).bG()) && (!ChatPieTipsBarHelper.a(TroopObserversHelper.d(this.a))))
      {
        if (!paramBoolean)
        {
          paramString2.a(2);
          return;
        }
        String str = ((ITroopOnlineMemberService)TroopObserversHelper.a(this.a).getRuntimeService(ITroopOnlineMemberService.class, "")).getOnlineTip(paramString1);
        if (!TextUtils.isEmpty(str))
        {
          TroopObserversHelper.d(this.a).b(true);
          TroopObserversHelper.d(this.a).I.setText(str);
        }
        if (paramString2 != null)
        {
          paramString2.a(paramString1);
          if (paramString2.d())
          {
            paramString2.c();
            TroopObserversHelper.d(this.a).p(true);
            return;
          }
          paramString2.a(0);
          TroopObserversHelper.d(this.a).p(false);
          return;
        }
        TroopObserversHelper.d(this.a).p(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopObserversHelper.d(this.a).bV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.4
 * JD-Core Version:    0.7.0.1
 */