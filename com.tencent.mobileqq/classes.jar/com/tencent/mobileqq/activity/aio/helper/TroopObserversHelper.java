package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.observer.TroopAioNotifyObserver;
import com.tencent.mobileqq.troop.observer.TroopAnonymousObserver;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.observer.TroopSurveyObserver;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopObserversHelper
  implements ILifeCycleHelper
{
  public static boolean n = false;
  TroopSettingObserver a = new TroopObserversHelper.1(this);
  TroopGagObserver b = new TroopObserversHelper.2(this);
  TroopModifyObserver c = new TroopObserversHelper.3(this);
  TroopOnlineMemberObserver d = new TroopObserversHelper.4(this);
  TroopObserver e = new TroopObserversHelper.5(this);
  TroopPushObserver f = new TroopObserversHelper.6(this);
  TroopMngObserver g = new TroopObserversHelper.7(this);
  TroopAppObserver h = new TroopObserversHelper.8(this);
  TroopRedDotObserver i = new TroopObserversHelper.9(this);
  TroopOnlinePushObserver j = new TroopObserversHelper.10(this);
  TroopAioNotifyObserver k = new TroopObserversHelper.11(this);
  HomeworkObserver l = new TroopObserversHelper.12(this);
  TroopSurveyObserver m = new TroopObserversHelper.13(this);
  private TroopChatPie o;
  private SessionInfo p;
  private QQAppInterface q;
  private QBaseActivity r;
  private int s = 2;
  private TroopAnonymousObserver t = new TroopObserversHelper.14(this);
  
  TroopObserversHelper(TroopChatPie paramTroopChatPie)
  {
    this.o = paramTroopChatPie;
    this.q = paramTroopChatPie.d;
    this.p = paramTroopChatPie.ah;
    this.r = paramTroopChatPie.f;
  }
  
  private void a()
  {
    this.s = 0;
    e();
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (this.p.a == 1) && (this.p.b.equals(paramTroopInfo.troopuin)))
    {
      this.p.e = paramTroopInfo.getTroopDisplayName();
      this.o.C.setText(this.p.e);
      if (AppSetting.e)
      {
        paramTroopInfo = this.o.C.getText().toString();
        this.o.C.setContentDescription(paramTroopInfo);
        this.r.setTitle(this.o.C.getText());
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearBAFGrayTipSP troopUin=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("TroopObserversHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.q.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    ((SharedPreferences)localObject).edit().putLong(paramString1, 0L).apply();
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    ThreadManager.post(new TroopObserversHelper.15(this, paramList), 8, null, true);
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject1 = this.o.aE();
    if (!TextUtils.isEmpty(((SessionInfo)localObject1).b)) {
      if (paramObject == null) {
        return;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        paramObject = (Object[])paramObject;
        paramBoolean = false;
        long l1 = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).b) != l1) {
          return;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        i1 = this.o.U.getFirstVisiblePosition();
        int i2 = this.o.U.getLastVisiblePosition();
        if (i1 <= i2)
        {
          Object localObject2 = this.o.U.getAdapter().getItem(i1);
          if (!(localObject2 instanceof MessageForQQWalletTips)) {
            break label621;
          }
          localObject2 = (MessageForQQWalletTips)localObject2;
          if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l1))) || ((TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER) == null)) {
            break label621;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handGetTroopMemberCard troopUin=");
            ((StringBuilder)localObject3).append(((MessageForQQWalletTips)localObject2).frienduin);
            ((StringBuilder)localObject3).append(", memberUin=");
            ((StringBuilder)localObject3).append(((MessageForQQWalletTips)localObject2).memberUin);
            ((StringBuilder)localObject3).append(",card=");
            ((StringBuilder)localObject3).append(((TroopMemberCard)localObject1).card);
            ((StringBuilder)localObject3).append(",remark=");
            ((StringBuilder)localObject3).append(((TroopMemberCard)localObject1).remark);
            ((StringBuilder)localObject3).append(",nick=");
            ((StringBuilder)localObject3).append(((TroopMemberCard)localObject1).nick);
            ((StringBuilder)localObject3).append(",saveTroopMemberEx succ=");
            ((StringBuilder)localObject3).append(true);
            QLog.d("TroopObserversHelper", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = AIOUtils.a(this.o.U, i1);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handGetTroopMemberCard ref itemView=");
            localStringBuilder.append(localObject3);
            localStringBuilder.append(",index=");
            localStringBuilder.append(i1);
            QLog.d("TroopObserversHelper", 2, localStringBuilder.toString());
          }
          if (localObject3 == null) {
            break label621;
          }
          localObject3 = (TextView)((View)localObject3).findViewById(2131434371);
          ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.q, this.o.e, (TextView)localObject3);
          break label621;
        }
        if ((localObject1 != null) && (TextUtils.equals(this.q.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopObserversHelper", 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.q.getCurrentAccountUin() });
          }
          localObject1 = f();
          if ((localObject1 != null) && ((((TroopClassControllerManager)localObject1).a instanceof HomeworkTroopController)))
          {
            localObject1 = (HomeworkTroopController)((TroopClassControllerManager)localObject1).a;
            if (!((Boolean)paramObject[3]).booleanValue()) {
              paramBoolean = true;
            }
            ((HomeworkTroopController)localObject1).a(paramBoolean, null, this.o);
          }
          g();
          return;
        }
      }
      catch (Throwable paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handGetTroopMemberCard e=");
          ((StringBuilder)localObject1).append(paramObject);
          QLog.w("TroopObserversHelper", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label621:
      i1 += 1;
    }
  }
  
  private void b()
  {
    d();
  }
  
  private void c()
  {
    this.s = 2;
  }
  
  private void d()
  {
    this.q.addObserver(this.g);
    this.q.addObserver(this.f);
    this.q.addObserver(this.c);
    this.q.addObserver(this.e);
    this.q.addObserver(this.d);
    this.q.addObserver(this.b);
    this.q.addObserver(this.a);
    this.q.addObserver(this.h);
    this.q.addObserver(this.i);
    this.q.addObserver(this.l);
    this.q.addObserver(this.m);
    this.q.addObserver(this.j);
    this.q.addObserver(this.k);
    this.q.addObserver(this.t);
  }
  
  private void e()
  {
    this.q.removeObserver(this.g);
    this.q.removeObserver(this.f);
    this.q.removeObserver(this.c);
    this.q.removeObserver(this.e);
    this.q.removeObserver(this.d);
    this.q.removeObserver(this.b);
    this.q.removeObserver(this.a);
    this.q.removeObserver(this.h);
    this.q.removeObserver(this.i);
    this.q.removeObserver(this.l);
    this.q.removeObserver(this.m);
    this.q.removeObserver(this.j);
    this.q.removeObserver(this.k);
    this.q.removeObserver(this.t);
  }
  
  private TroopClassControllerManager f()
  {
    return ((HWTroopClassInfoTipsHelper)this.o.q(73)).a();
  }
  
  private void g()
  {
    ((HWTroopClassInfoTipsHelper)this.o.q(73)).d();
  }
  
  public String getTag()
  {
    return "TroopObserversHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 1, 3 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper
 * JD-Core Version:    0.7.0.1
 */