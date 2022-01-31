import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.1;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.2;
import com.tencent.mobileqq.forward.ForwardBaseOption.2.3;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class aryz
  implements DialogInterface.OnClickListener
{
  aryz(aryv paramaryv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("needShareCallBack");
    paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareFrom");
    boolean bool2 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false);
    if (bool2)
    {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_suc", null, null);
      switch (paramInt)
      {
      }
    }
    String str1;
    for (;;)
    {
      str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareAppid");
      paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareAppType");
      i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareScene");
      int j = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareType");
      int k = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
      MiniAppReportShareUtil.getInstance().reportShare(str1, paramInt, i, j, k, paramDialogInterface);
      if (!bool2) {
        break label267;
      }
      return;
      if (!bool1) {
        break;
      }
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      break;
      aryv.a(this.a, "user_click", "more_about", "share", "success");
      continue;
      aryv.a(this.a, "user_click", "custom_button", "share_QQ", "success");
      continue;
      aryv.a(this.a, "user_click", "more_button", "share_QQ", "success");
    }
    label267:
    if (this.a.f())
    {
      if ((aryv.a(this.a) != null) && (!aryv.a(this.a).isEmpty()))
      {
        paramDialogInterface = aryv.a(this.a).iterator();
        while (paramDialogInterface.hasNext())
        {
          localObject1 = (ResultRecord)paramDialogInterface.next();
          if (((ResultRecord)localObject1).b == 6000) {
            this.a.b(aryl.f.intValue());
          } else if (((ResultRecord)localObject1).b == 6003) {
            this.a.b(aryl.k.intValue());
          }
        }
        if ((aryv.b(this.a) == null) || (aryv.b(this.a).isEmpty()))
        {
          this.a.jdField_a_of_type_AndroidContentIntent.putExtra("NOCANCEL4DATALIN", true);
          this.a.jdField_a_of_type_AndroidAppActivity.setResult(0, this.a.jdField_a_of_type_AndroidContentIntent);
          this.a.jdField_a_of_type_AndroidAppActivity.finish();
        }
        this.a.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("forward_multi_target", aryv.b(this.a));
        this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("forward_multi_target", aryv.b(this.a));
      }
      this.a.d();
      if (this.a.c) {}
      for (;;)
      {
        if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
          azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
        }
        aryv.b(this.a);
        if (!"caller_aecamera".equals(this.a.f)) {
          break;
        }
        aryv.c(this.a);
        return;
        if (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("system_share", false))
        {
          ForwardUtils.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle);
        }
        else if ((this.a.g) && (!this.a.h))
        {
          ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.1(this), 500L);
        }
        else
        {
          this.a.jdField_a_of_type_AndroidAppActivity.finish();
          if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) {
            ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.2(this), 500L);
          }
        }
      }
    }
    localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    if (((bcnu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a((String)localObject2, true).a)
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697834, 0).b(this.a.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    bool1 = false;
    if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
      bool1 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_card", false);
    }
    if (bool1)
    {
      localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 == null) {
        paramDialogInterface = "";
      }
      nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    }
    if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false))
    {
      i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
      paramDialogInterface = "";
      if (i == 21)
      {
        paramDialogInterface = "0X800780B";
        label948:
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramDialogInterface, paramDialogInterface, 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false)) {}
      i = this.a.a().getInt("key_forward_ability_type");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->getConfirmListener--onClick--type = " + i);
      }
    }
    for (;;)
    {
      try
      {
        if ((i != aryl.f.intValue()) && (i != aryl.k.intValue())) {
          continue;
        }
        this.a.b(i);
      }
      catch (Throwable paramDialogInterface)
      {
        Object localObject3;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramDialogInterface);
        continue;
        if (i != aryl.j.intValue()) {
          continue;
        }
        this.a.y();
        continue;
        if (i != aryl.m.intValue()) {
          continue;
        }
        this.a.z();
        continue;
        if (i != aryl.e.intValue()) {
          continue;
        }
        paramDialogInterface = null;
        if (!(this.a.jdField_a_of_type_Bdjz instanceof bdku)) {
          continue;
        }
        paramDialogInterface = ((bdku)this.a.jdField_a_of_type_Bdjz).a();
        this.a.b(paramDialogInterface);
        continue;
        this.a.d();
        continue;
        paramInt = 1001;
        continue;
        nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, (String)localObject1, (String)localObject2, paramDialogInterface, (String)localObject3, false);
        continue;
      }
      if ((this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) && (this.a.a(paramInt, (String)localObject2, i))) {
        ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.2.3(this), 300L);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_report_confirm")))
      {
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_action_name");
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_reverse2");
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject1 == null) {
          paramDialogInterface = "";
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramDialogInterface, paramDialogInterface, 0, 0, (String)localObject1, "", "", "");
      }
      bool1 = false;
      if (this.a.jdField_a_of_type_AndroidOsBundle != null)
      {
        bool1 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_web", false);
        if (!bool1) {
          continue;
        }
        paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_uin");
        localObject1 = paramDialogInterface;
        if (paramDialogInterface == null) {
          localObject1 = "";
        }
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_url");
        paramDialogInterface = (DialogInterface)localObject2;
        if (localObject2 == null) {
          paramDialogInterface = "";
        }
        localObject3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("strurt_msgid");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = AccountDetailActivity.a(paramDialogInterface);
        if (i != aryl.e.intValue()) {
          continue;
        }
        paramInt = 1002;
        str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if ((str2 == null) || ("".equals(str2))) {
          continue;
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
        if ((localObject1 == null) || (paramInt == 1002)) {
          localObject1 = "";
        }
        nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B07", "0X8005B07", paramInt, 0, str2, (String)localObject2, paramDialogInterface, (String)localObject3, false);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (!bool1))
      {
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if (localObject2 != null)
        {
          paramDialogInterface = this.a.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
          if (paramDialogInterface != null)
          {
            localObject3 = azvd.a(paramDialogInterface);
            if (localObject3 != null)
            {
              localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
              paramDialogInterface = (DialogInterface)localObject1;
              if (localObject1 == null) {
                paramDialogInterface = "";
              }
              nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005B06", "0X8005B06", 0, 0, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "", false);
              nrt.a("0X8005B06", paramDialogInterface, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "");
            }
          }
        }
      }
      if (this.a.c) {
        bfhz.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(str1), "1000", "50", "0", false);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getInt("extra_key_from_apollo") > 0)) {
        VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_OCR", false))) {
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle == null) || (!this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_TRANSLATE", false))) {
        break;
      }
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
      break;
      if (i != 1) {
        break label948;
      }
      paramDialogInterface = "0X8007811";
      break label948;
      if (i != aryl.g.intValue()) {
        continue;
      }
      this.a.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aryz
 * JD-Core Version:    0.7.0.1
 */