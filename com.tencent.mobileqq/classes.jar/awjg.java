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

class awjg
  implements bfph
{
  awjg(awjf paramawjf, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    paramInt = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131362222: 
    case 2131362223: 
    case 2131362218: 
    case 2131362224: 
    case 2131362221: 
    case 2131362219: 
    case 2131362220: 
      for (;;)
      {
        this.jdField_a_of_type_Bfpc.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", awje.a(this.jdField_a_of_type_Awjf.a), 0, "", "", "", "");
        continue;
        aebx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, awje.a(this.jdField_a_of_type_Awjf.a), awje.a(this.jdField_a_of_type_Awjf.a));
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", awje.a(this.jdField_a_of_type_Awjf.a), 0, "", "", "", "");
        continue;
        if (awje.a(this.jdField_a_of_type_Awjf.a).m == 2)
        {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689650, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (awje.b(this.jdField_a_of_type_Awjf.a) != null) {
            break label423;
          }
        }
        for (;;)
        {
          axqy.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.valueOf(awje.a(this.jdField_a_of_type_Awjf.a).b).longValue();
          try
          {
            if ((bduf.b(awje.a(this.jdField_a_of_type_Awjf.a).i)) || (bduf.c(awje.a(this.jdField_a_of_type_Awjf.a).i))) {
              paramView.jdField_a_of_type_Long = Long.valueOf(awje.a(this.jdField_a_of_type_Awjf.a).j).longValue();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = awje.a(this.jdField_a_of_type_Awjf.a).c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label236;
          paramInt = 3;
        }
        if (awje.b(this.jdField_a_of_type_Awjf.a).m == 3)
        {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693691, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (awje.a(this.jdField_a_of_type_Awjf.a) != null) {
            break label586;
          }
        }
        for (paramInt = i;; paramInt = 3)
        {
          axqy.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (awje.b(this.jdField_a_of_type_Awjf.a).n == 1)
          {
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693690, 0).a();
            break label460;
          }
          paramView = TroopInfoActivity.a(awje.b(this.jdField_a_of_type_Awjf.a).b, awje.b(this.jdField_a_of_type_Awjf.a).k, 105);
          banb.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label460;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", awje.c(this.jdField_a_of_type_Awjf.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", awje.a(this.jdField_a_of_type_Awjf.a), 0, "", "", "", "");
        continue;
        aykk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", awje.a(this.jdField_a_of_type_Awjf.a), 0, "", "", "", "");
        continue;
        bbac.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), awje.d(this.jdField_a_of_type_Awjf.a), awje.b(this.jdField_a_of_type_Awjf.a), this.jdField_a_of_type_JavaLangString);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", awje.a(this.jdField_a_of_type_Awjf.a), 0, "", "", "", "");
      }
    case 2131362225: 
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
      if (awje.b(this.jdField_a_of_type_Awjf.a) == null) {}
      for (paramInt = j;; paramInt = 3)
      {
        axqy.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    banb.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (awje.a(this.jdField_a_of_type_Awjf.a) == null) {}
    for (paramInt = k;; paramInt = 3)
    {
      axqy.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjg
 * JD-Core Version:    0.7.0.1
 */