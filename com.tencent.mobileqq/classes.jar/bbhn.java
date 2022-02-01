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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bbhn
  implements bkhw
{
  bbhn(bbhm parambbhm, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, bblw[] paramArrayOfbblw1, bblw[] paramArrayOfbblw2, bblw[] paramArrayOfbblw3, bkho parambkho) {}
  
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
    case 2131362318: 
    case 2131362319: 
    case 2131362314: 
    case 2131362320: 
    case 2131362317: 
    case 2131362315: 
    case 2131362323: 
    case 2131362316: 
      for (;;)
      {
        this.jdField_a_of_type_Bkho.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", bbhl.b(this.jdField_a_of_type_Bbhm.a), 0, "", "", "", "");
        continue;
        ahkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, bbhl.a(this.jdField_a_of_type_Bbhm.a), bbhl.a(this.jdField_a_of_type_Bbhm.a));
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", bbhl.b(this.jdField_a_of_type_Bbhm.a), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ArrayOfBblw[0].jdField_n_of_type_Int == 2)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689570, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.b[0] != null) {
            break label393;
          }
        }
        for (;;)
        {
          bcst.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfBblw[0].b);
          try
          {
            if ((bjft.b(this.jdField_a_of_type_ArrayOfBblw[0].jdField_j_of_type_Int)) || (bjft.c(this.jdField_a_of_type_ArrayOfBblw[0].jdField_j_of_type_Int))) {
              paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfBblw[0].jdField_o_of_type_JavaLangString);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfBblw[0].c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label236;
          paramInt = 3;
        }
        if (this.b[0].jdField_n_of_type_Int == 3)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693151, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ArrayOfBblw[0] != null) {
            break label536;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          bcst.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (this.b[0].jdField_o_of_type_Int == 1)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693150, 0).a();
            break label426;
          }
          paramView = TroopInfoActivity.a(this.b[0].b, this.b[0].p, 105);
          bfup.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label426;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", bbhl.c(this.jdField_a_of_type_Bbhm.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", bbhl.b(this.jdField_a_of_type_Bbhm.a), 0, "", "", "", "");
        continue;
        bdnt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", bbhl.b(this.jdField_a_of_type_Bbhm.a), 0, "", "", "", "");
        continue;
        MiniAppLauncher.launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, "1110436437", this.c[0].jdField_n_of_type_JavaLangString, null, null, null, 2111);
        if (this.c[0].l.equals("#808080"))
        {
          paramView = "0X800B0C1";
          if (!this.c[0].l.equals("#808080")) {
            break label891;
          }
          localObject = this.c[0].jdField_j_of_type_JavaLangString;
          if (!this.c[0].l.equals("#808080")) {
            break label898;
          }
        }
        for (String str = this.c[0].k;; str = "")
        {
          if (QLog.isColorLevel()) {
            QLog.d("UinSearcher", 2, "clickEvent TValue r4 r5: " + paramView + ", " + (String)localObject + ", " + str);
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, bbhl.a(bbhl.a(this.jdField_a_of_type_Bbhm.a)), 0, "", "", (String)localObject, str);
          break;
          paramView = "0X800B0C2";
          break label734;
          localObject = "";
          break label762;
        }
        bghy.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), bbhl.d(this.jdField_a_of_type_Bbhm.a), bbhl.a(this.jdField_a_of_type_Bbhm.a), this.jdField_a_of_type_JavaLangString);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", bbhl.b(this.jdField_a_of_type_Bbhm.a), 0, "", "", "", "");
      }
    case 2131362321: 
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
        bcst.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    bfup.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ArrayOfBblw[0] == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      bcst.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhn
 * JD-Core Version:    0.7.0.1
 */