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
  private int jdField_a_of_type_Int = 2;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopObserversHelper.7(this);
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new TroopObserversHelper.3(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopObserversHelper.5(this);
  TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new TroopObserversHelper.6(this);
  HomeworkObserver jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver = new TroopObserversHelper.12(this);
  TroopAioNotifyObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAioNotifyObserver = new TroopObserversHelper.11(this);
  private TroopAnonymousObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAnonymousObserver = new TroopObserversHelper.14(this);
  TroopRedDotObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver = new TroopObserversHelper.9(this);
  TroopSurveyObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopSurveyObserver = new TroopObserversHelper.13(this);
  TroopOnlineMemberObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver = new TroopObserversHelper.4(this);
  TroopOnlinePushObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver = new TroopObserversHelper.10(this);
  TroopAppObserver jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopObserversHelper.8(this);
  TroopGagObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver = new TroopObserversHelper.2(this);
  TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new TroopObserversHelper.1(this);
  
  TroopObserversHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  private TroopClassControllerManager a()
  {
    return ((HWTroopClassInfoTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(73)).a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    e();
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.getTroopDisplayName();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.d)
      {
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText().toString();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setContentDescription(paramTroopInfo);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText());
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
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
    if (!TextUtils.isEmpty(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString)) {
      if (paramObject == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramObject = (Object[])paramObject;
        paramBoolean = false;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l) {
          return;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (i <= j)
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i);
          if (!(localObject2 instanceof MessageForQQWalletTips)) {
            break label621;
          }
          localObject2 = (MessageForQQWalletTips)localObject2;
          if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER) == null)) {
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
          Object localObject3 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handGetTroopMemberCard ref itemView=");
            localStringBuilder.append(localObject3);
            localStringBuilder.append(",index=");
            localStringBuilder.append(i);
            QLog.d("TroopObserversHelper", 2, localStringBuilder.toString());
          }
          if (localObject3 == null) {
            break label621;
          }
          localObject3 = (TextView)((View)localObject3).findViewById(2131367798);
          ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, (TextView)localObject3);
          break label621;
        }
        if ((localObject1 != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopObserversHelper", 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
          }
          localObject1 = a();
          if ((localObject1 != null) && ((((TroopClassControllerManager)localObject1).a instanceof HomeworkTroopController)))
          {
            localObject1 = (HomeworkTroopController)((TroopClassControllerManager)localObject1).a;
            if (!((Boolean)paramObject[3]).booleanValue()) {
              paramBoolean = true;
            }
            ((HomeworkTroopController)localObject1).a(paramBoolean, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
          }
          f();
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
      i += 1;
    }
  }
  
  private void b()
  {
    d();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopSurveyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAioNotifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAnonymousObserver);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiTroopGagObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopSurveyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAioNotifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopAnonymousObserver);
  }
  
  private void f()
  {
    ((HWTroopClassInfoTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(73)).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper
 * JD-Core Version:    0.7.0.1
 */