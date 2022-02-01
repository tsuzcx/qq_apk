package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import java.util.HashMap;

public class TroopManagerAction
  extends JumpAction
{
  private QQAppInterface a;
  
  public TroopManagerAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean c()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    if ((str != null) && (!"".equals(str)))
    {
      if (str.length() < 5) {
        return false;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(str);
          if ((localObject1 != null) && (((TroopInfo)localObject1).isAdmin()))
          {
            i = 1;
            break label88;
          }
        }
        int i = 0;
        label88:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("gotoGroupManager not admin ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("TroopManagerAction", 2, ((StringBuilder)localObject1).toString());
          }
          return false;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("troop_uin", str);
        ((Intent)localObject1).putExtra("key_is_update_before_805", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
        ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
        ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
        Object localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (localPluginCommunicationHandler != null) {
          localPluginCommunicationHandler.register((RemoteCommand)localObject2);
        }
        localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("gotoGroupManager ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("TroopManagerAction", 2, ((StringBuilder)localObject1).toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopManagerAction", 2, "gotoGroupManager context not activity");
      }
    }
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("TroopManagerAction", 1, localStringBuilder.toString());
      b_("TroopManagerAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopManagerAction
 * JD-Core Version:    0.7.0.1
 */