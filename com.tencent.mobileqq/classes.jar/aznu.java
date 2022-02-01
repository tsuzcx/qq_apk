import QQService.PrivilegeInfo;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aznu
  implements View.OnClickListener
{
  aznu(aznt paramaznt) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof azde))
    {
      localObject1 = (azde)localObject1;
      switch (((azde)localObject1).jdField_a_of_type_Int)
      {
      }
    }
    Object localObject2;
    label288:
    label326:
    int i;
    PrivilegeInfo localPrivilegeInfo;
    label572:
    label619:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = ((azfe)aznt.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (((azfe)aznt.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label288;
          }
        }
        for (localObject1 = "https://mc.vip.qq.com/privilegelist/index";; localObject1 = "https://mc.vip.qq.com/privilegelist/other?friend=" + ((azfe)aznt.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
        {
          localObject2 = new Intent(aznt.a(this.a), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_operation_bar", true);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          aznt.b(this.a).startActivity((Intent)localObject2);
          bcst.b(aznt.a(this.a), "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
          if (((azfe)aznt.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label326;
          }
          bcst.b(aznt.b(this.a), "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          bcst.b(aznt.c(this.a), "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
          break;
        }
        bcst.b(aznt.d(this.a), "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
        i = anyj.a(aznt.e(this.a), aznt.f(this.a).c(), false);
        bcst.b(aznt.g(this.a), "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(i), "", "", "");
        continue;
        if ((((azde)localObject1).jdField_a_of_type_JavaLangObject instanceof PrivilegeInfo)) {
          break;
        }
        QLog.e("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + ((azde)localObject1).jdField_a_of_type_JavaLangObject);
      }
      localPrivilegeInfo = (PrivilegeInfo)((azde)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = localPrivilegeInfo.strJumpUrl;
      localObject2 = new Intent(aznt.c(this.a), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      aznt.d(this.a).startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND click");
      }
      if (((azfe)aznt.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      i = 1;
      switch (localPrivilegeInfo.iType)
      {
      default: 
        if (i == 0) {
          break label774;
        }
        localObject1 = "0X800A137";
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    if (localPrivilegeInfo.iIsBig == 1) {
      if (localPrivilegeInfo.isOpen) {
        i = 1;
      }
    }
    for (;;)
    {
      localObject2 = "";
      if (localPrivilegeInfo.iType == 1) {
        localObject2 = String.valueOf(anyj.a(aznt.h(this.a), aznt.i(this.a).c(), false));
      }
      bcst.b(aznt.j(this.a), "dc00898", "", "", "qvip", (String)localObject1, i, 0, (String)localObject2, "", "", "");
      break;
      i = 0;
      break label572;
      if (i != 0) {}
      for (localObject1 = "0X800A133";; localObject1 = "0X800A12B") {
        break;
      }
      if (i != 0) {}
      for (localObject1 = "0X800A135";; localObject1 = "0X800A12D") {
        break;
      }
      if (i != 0) {}
      for (localObject1 = "0X800A131";; localObject1 = "0X800A129") {
        break;
      }
      label774:
      localObject1 = "0X800A12F";
      break label619;
      i = 2;
      continue;
      if (localPrivilegeInfo.isOpen) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznu
 * JD-Core Version:    0.7.0.1
 */