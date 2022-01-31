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
import com.tencent.qphone.base.util.QLog;

class awje
  implements bfoq
{
  awje(awjd paramawjd, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    paramInt = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131362223: 
    case 2131362224: 
    case 2131362219: 
    case 2131362225: 
    case 2131362222: 
    case 2131362220: 
    case 2131362221: 
      for (;;)
      {
        this.jdField_a_of_type_Bfol.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", awjc.a(this.jdField_a_of_type_Awjd.a), 0, "", "", "", "");
        continue;
        aebz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, awjc.a(this.jdField_a_of_type_Awjd.a), awjc.a(this.jdField_a_of_type_Awjd.a));
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", awjc.a(this.jdField_a_of_type_Awjd.a), 0, "", "", "", "");
        continue;
        if (awjc.a(this.jdField_a_of_type_Awjd.a).m == 2)
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689650, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (awjc.b(this.jdField_a_of_type_Awjd.a) != null) {
            break label423;
          }
        }
        for (;;)
        {
          axqw.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.valueOf(awjc.a(this.jdField_a_of_type_Awjd.a).b).longValue();
          try
          {
            if ((bdto.b(awjc.a(this.jdField_a_of_type_Awjd.a).i)) || (bdto.c(awjc.a(this.jdField_a_of_type_Awjd.a).i))) {
              paramView.jdField_a_of_type_Long = Long.valueOf(awjc.a(this.jdField_a_of_type_Awjd.a).j).longValue();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = awjc.a(this.jdField_a_of_type_Awjd.a).c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label236;
          paramInt = 3;
        }
        if (awjc.b(this.jdField_a_of_type_Awjd.a).m == 3)
        {
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693690, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (awjc.a(this.jdField_a_of_type_Awjd.a) != null) {
            break label586;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          axqw.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (awjc.b(this.jdField_a_of_type_Awjd.a).n == 1)
          {
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693689, 0).a();
            break label460;
          }
          paramView = TroopInfoActivity.a(awjc.b(this.jdField_a_of_type_Awjd.a).b, awjc.b(this.jdField_a_of_type_Awjd.a).k, 105);
          bamn.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label460;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", awjc.c(this.jdField_a_of_type_Awjd.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", awjc.a(this.jdField_a_of_type_Awjd.a), 0, "", "", "", "");
        continue;
        ayki.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", awjc.a(this.jdField_a_of_type_Awjd.a), 0, "", "", "", "");
        continue;
        bazo.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), awjc.d(this.jdField_a_of_type_Awjd.a), awjc.b(this.jdField_a_of_type_Awjd.a), this.jdField_a_of_type_JavaLangString);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", awjc.a(this.jdField_a_of_type_Awjd.a), 0, "", "", "", "");
      }
    case 2131362226: 
      label236:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileCardActivity.class);
      label423:
      label460:
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      label586:
      localAllInOne.h = 124;
      paramView.putExtra("AllInOne", localAllInOne);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (awjc.b(this.jdField_a_of_type_Awjd.a) == null) {}
      for (paramInt = j;; paramInt = 3)
      {
        axqw.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    bamn.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (awjc.a(this.jdField_a_of_type_Awjd.a) == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      axqw.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awje
 * JD-Core Version:    0.7.0.1
 */