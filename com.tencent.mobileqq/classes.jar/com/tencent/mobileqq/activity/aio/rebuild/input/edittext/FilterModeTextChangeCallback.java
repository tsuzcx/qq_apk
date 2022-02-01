package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FilterModeTextChangeCallback
  implements IEditTextChangeCallback
{
  private void a(AIOContext paramAIOContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramAIOContext.a().jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_from", 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    if (paramAIOContext.a() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
    RouteUtils.a(paramAIOContext.a(), localIntent, "/troop/memberlist/TroopMemberList", 6001);
  }
  
  private void a(AIOContext paramAIOContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterModeTextChangeCallback", 2, "inputing @ in TroopChatPie.");
    }
    Object localObject1 = ((TroopManager)paramAIOContext.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(paramAIOContext.a().jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", ((TroopInfo)localObject1).troopuin);
      localIntent.putExtra("param_from", 3);
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.setFlags(603979776);
      boolean bool2 = AnonymousChatHelper.a().a(paramAIOContext.a().jdField_a_of_type_JavaLangString);
      boolean bool1 = false;
      if (bool2) {
        localIntent.putExtra("param_chat_mode", 1);
      } else {
        localIntent.putExtra("param_chat_mode", 0);
      }
      Object localObject2 = (AIOShortcutBarHelper)paramAIOContext.a(52);
      if (localObject2 != null)
      {
        AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(24);
        ((AIOShortcutBarHelper)localObject2).a(localAIOShortcutBarEvent);
        bool1 = localAIOShortcutBarEvent.a().getBoolean("result");
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("open TroopMemberListActivity, needfilterrobot:");
        ((StringBuilder)localObject2).append(bool1);
        QLog.d("FilterModeTextChangeCallback", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool1) {
        localIntent.putExtra("param_filter_robot", true);
      }
      if (paramAIOContext.a() == 21) {
        localIntent.putExtra("param_troop_send_apollo_msg", true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FilterModeTextChangeCallback", 2, "open TroopMemberListActivity to choose @ user target.");
      }
      RouteUtils.a(paramAIOContext.a(), localIntent, "/troop/memberlist/TroopMemberList", 6001);
      if (paramInt == 1) {
        return;
      }
      a(paramAIOContext, (TroopInfo)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onTextChanged(). troopInfo is null. while inputing @.  troopUin is ");
      ((StringBuilder)localObject1).append(paramAIOContext.a().jdField_a_of_type_JavaLangString);
      QLog.d("FilterModeTextChangeCallback", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void a(AIOContext paramAIOContext, TroopInfo paramTroopInfo)
  {
    String str2 = "2";
    try
    {
      String str3 = paramAIOContext.a().getCurrentAccountUin();
      String str1;
      if ((paramTroopInfo.troopowneruin != null) && (paramTroopInfo.troopowneruin.equals(str3)))
      {
        str1 = "0";
      }
      else
      {
        str1 = str2;
        if (paramTroopInfo.Administrator != null)
        {
          str1 = str2;
          if (paramTroopInfo.Administrator.contains(str3)) {
            str1 = "1";
          }
        }
      }
      ReportController.b(paramAIOContext.a(), "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, paramTroopInfo.troopuin, "2", str1, "");
      return;
    }
    catch (Exception paramAIOContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterModeTextChangeCallback", 2, "onTextChanged() has an exception.", paramAIOContext);
      }
    }
  }
  
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAIOContext.a().jdField_a_of_type_Int == 3000)
    {
      if (BaseChatpieHelper.a(paramAIOContext, paramCharSequence, paramAIOContext.a().jdField_a_of_type_Int))
      {
        paramAIOContext.a().l = true;
        a(paramAIOContext);
      }
    }
    else if ((paramAIOContext.a().jdField_a_of_type_Int == 1) && (BaseChatpieHelper.a(paramAIOContext, paramCharSequence, paramAIOContext.a().jdField_a_of_type_Int)))
    {
      paramAIOContext.a().l = true;
      a(paramAIOContext, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.FilterModeTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */