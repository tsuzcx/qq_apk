import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ayip
  implements bhuk
{
  ayip(ayio paramayio, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, ayms[] paramArrayOfayms1, ayms[] paramArrayOfayms2, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    paramInt = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131362243: 
    case 2131362244: 
    case 2131362239: 
    case 2131362245: 
    case 2131362242: 
    case 2131362240: 
    case 2131362241: 
      for (;;)
      {
        this.jdField_a_of_type_Bhuf.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", ayin.a(this.jdField_a_of_type_Ayio.a), 0, "", "", "", "");
        continue;
        agda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, ayin.a(this.jdField_a_of_type_Ayio.a), ayin.a(this.jdField_a_of_type_Ayio.a));
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", ayin.a(this.jdField_a_of_type_Ayio.a), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ArrayOfAyms[0].m == 2)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689650, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.b[0] != null) {
            break label389;
          }
        }
        for (;;)
        {
          azqs.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfAyms[0].b);
          try
          {
            if ((bfyh.b(this.jdField_a_of_type_ArrayOfAyms[0].i)) || (bfyh.c(this.jdField_a_of_type_ArrayOfAyms[0].i))) {
              paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfAyms[0].j);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAyms[0].c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label232;
          paramInt = 3;
        }
        if (this.b[0].m == 3)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693809, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ArrayOfAyms[0] != null) {
            break label532;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          azqs.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (this.b[0].n == 1)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693808, 0).a();
            break label422;
          }
          paramView = TroopInfoActivity.a(this.b[0].b, this.b[0].k, 105);
          bcpx.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label422;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", ayin.c(this.jdField_a_of_type_Ayio.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", ayin.a(this.jdField_a_of_type_Ayio.a), 0, "", "", "", "");
        continue;
        bamp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", ayin.a(this.jdField_a_of_type_Ayio.a), 0, "", "", "", "");
        continue;
        bddf.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ayin.d(this.jdField_a_of_type_Ayio.a), ayin.b(this.jdField_a_of_type_Ayio.a), this.jdField_a_of_type_JavaLangString);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", ayin.a(this.jdField_a_of_type_Ayio.a), 0, "", "", "", "");
      }
    case 2131362246: 
      label232:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileCardActivity.class);
      label389:
      label422:
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      label532:
      localAllInOne.h = 124;
      paramView.putExtra("AllInOne", localAllInOne);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.b[0] == null) {}
      for (paramInt = j;; paramInt = 3)
      {
        azqs.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    bcpx.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ArrayOfAyms[0] == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      azqs.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayip
 * JD-Core Version:    0.7.0.1
 */