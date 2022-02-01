import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bcaa
  implements bkzq
{
  bcaa(bbzz parambbzz, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, bceh[] paramArrayOfbceh1, bceh[] paramArrayOfbceh2, bceh[] paramArrayOfbceh3, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    paramInt = 1;
    label236:
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131362338: 
    case 2131362339: 
    case 2131362334: 
    case 2131362340: 
    case 2131362337: 
    case 2131362335: 
    case 2131362343: 
    case 2131362336: 
      for (;;)
      {
        this.jdField_a_of_type_Bkzi.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", bbzy.b(this.jdField_a_of_type_Bbzz.a), 0, "", "", "", "");
        continue;
        ahit.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, bbzy.a(this.jdField_a_of_type_Bbzz.a), bbzy.a(this.jdField_a_of_type_Bbzz.a));
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", bbzy.b(this.jdField_a_of_type_Bbzz.a), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ArrayOfBceh[0].jdField_p_of_type_Int == 2)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689571, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.b[0] != null) {
            break label393;
          }
        }
        for (;;)
        {
          bdla.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfBceh[0].b);
          try
          {
            if ((bjxa.b(this.jdField_a_of_type_ArrayOfBceh[0].jdField_l_of_type_Int)) || (bjxa.c(this.jdField_a_of_type_ArrayOfBceh[0].jdField_l_of_type_Int))) {
              paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfBceh[0].jdField_p_of_type_JavaLangString);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfBceh[0].c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label236;
          paramInt = 3;
        }
        if (this.b[0].jdField_p_of_type_Int == 3)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693403, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ArrayOfBceh[0] != null) {
            break label536;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          bdla.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (this.b[0].jdField_q_of_type_Int == 1)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693402, 0).a();
            break label426;
          }
          paramView = TroopInfoActivity.a(this.b[0].b, this.b[0].jdField_q_of_type_JavaLangString, 105);
          TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label426;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", bbzy.c(this.jdField_a_of_type_Bbzz.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", bbzy.b(this.jdField_a_of_type_Bbzz.a), 0, "", "", "", "");
        continue;
        QQText.showAddContactsDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", bbzy.b(this.jdField_a_of_type_Bbzz.a), 0, "", "", "", "");
        continue;
        MiniAppLauncher.launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, "1110436437", this.c[0].o, null, null, null, 2111);
        if (this.c[0].m.equals("#808080"))
        {
          paramView = "0X800B0C1";
          if (!this.c[0].m.equals("#808080")) {
            break label891;
          }
          localObject = this.c[0].k;
          if (!this.c[0].m.equals("#808080")) {
            break label898;
          }
        }
        for (String str = this.c[0].jdField_l_of_type_JavaLangString;; str = "")
        {
          if (QLog.isColorLevel()) {
            QLog.d("UinSearcher", 2, "clickEvent TValue r4 r5: " + paramView + ", " + (String)localObject + ", " + str);
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, bbzy.a(bbzy.a(this.jdField_a_of_type_Bbzz.a)), 0, "", "", (String)localObject, str);
          break;
          paramView = "0X800B0C2";
          break label734;
          localObject = "";
          break label762;
        }
        bhaa.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), bbzy.d(this.jdField_a_of_type_Bbzz.a), bbzy.a(this.jdField_a_of_type_Bbzz.a), this.jdField_a_of_type_JavaLangString);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", bbzy.b(this.jdField_a_of_type_Bbzz.a), 0, "", "", "", "");
      }
    case 2131362341: 
      label393:
      label426:
      label734:
      label762:
      label891:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileCardActivity.class);
      label536:
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      label898:
      ((ProfileActivity.AllInOne)localObject).h = 124;
      paramView.putExtra("AllInOne", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.b[0] == null) {}
      for (paramInt = j;; paramInt = 3)
      {
        bdla.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ArrayOfBceh[0] == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      bdla.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaa
 * JD-Core Version:    0.7.0.1
 */