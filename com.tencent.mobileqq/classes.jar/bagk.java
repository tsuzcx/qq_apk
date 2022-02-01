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

class bagk
  implements View.OnClickListener
{
  bagk(bagj parambagj) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof azvr))
    {
      localObject1 = (azvr)localObject1;
      switch (((azvr)localObject1).jdField_a_of_type_Int)
      {
      }
    }
    Object localObject2;
    label295:
    label334:
    int i;
    PrivilegeInfo localPrivilegeInfo;
    label585:
    label632:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = ((azxr)bagj.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (((azxr)bagj.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label295;
          }
        }
        for (localObject1 = "https://mc.vip.qq.com/privilegelist/index";; localObject1 = "https://mc.vip.qq.com/privilegelist/other?friend=" + ((azxr)bagj.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
        {
          localObject2 = new Intent(bagj.a(this.a), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_operation_bar", true);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          bagj.b(this.a).startActivity((Intent)localObject2);
          bdll.b(bagj.a(this.a), "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
          if (((azxr)bagj.d(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label334;
          }
          bdll.b(bagj.b(this.a), "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          bdll.b(bagj.c(this.a), "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
          break;
        }
        bdll.b(bagj.d(this.a), "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
        i = aokv.a(bagj.e(this.a), bagj.f(this.a).c(), false);
        bdll.b(bagj.g(this.a), "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(i), "", "", "");
        continue;
        if ((((azvr)localObject1).jdField_a_of_type_JavaLangObject instanceof PrivilegeInfo)) {
          break;
        }
        QLog.e("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + ((azvr)localObject1).jdField_a_of_type_JavaLangObject);
      }
      localPrivilegeInfo = (PrivilegeInfo)((azvr)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = localPrivilegeInfo.strJumpUrl;
      localObject2 = new Intent(bagj.c(this.a), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      bagj.d(this.a).startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND click");
      }
      if (((azxr)bagj.e(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      i = 1;
      switch (localPrivilegeInfo.iType)
      {
      default: 
        if (i == 0) {
          break label840;
        }
        localObject1 = "0X800A137";
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    label659:
    int j;
    String str;
    if (localPrivilegeInfo.iIsBig == 1) {
      if (localPrivilegeInfo.isOpen)
      {
        i = 1;
        localObject2 = "";
        if (localPrivilegeInfo.iType == 1)
        {
          j = aokv.a(bagj.h(this.a), bagj.i(this.a).c(), false);
          str = String.valueOf(j);
          if ((!bagf.a) || (!bagj.a(this.a, localPrivilegeInfo.iRemindTime, localPrivilegeInfo.iType))) {
            break label870;
          }
          bagj.a(this.a, "0X800B27E", j);
          localObject2 = str;
        }
      }
    }
    for (;;)
    {
      bdll.b(bagj.j(this.a), "dc00898", "", "", "qvip", (String)localObject1, i, 0, (String)localObject2, "", "", "");
      break;
      i = 0;
      break label585;
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
      label840:
      localObject1 = "0X800A12F";
      break label632;
      i = 2;
      break label659;
      if (localPrivilegeInfo.isOpen)
      {
        i = 3;
        break label659;
      }
      i = 4;
      break label659;
      label870:
      localObject2 = str;
      if (bagf.a)
      {
        bagj.a(this.a, "0X800B27C", j);
        localObject2 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagk
 * JD-Core Version:    0.7.0.1
 */