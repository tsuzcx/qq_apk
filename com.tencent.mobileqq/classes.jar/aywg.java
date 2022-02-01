import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aywg
  implements View.OnClickListener
{
  aywg(aywc paramaywc, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aywc.a(this.jdField_a_of_type_Aywc) != null) && (aywc.a(this.jdField_a_of_type_Aywc).isShowing())) {
        aywc.a(this.jdField_a_of_type_Aywc).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        bcef.b(aywc.c(this.jdField_a_of_type_Aywc), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        bcef.b(aywc.d(this.jdField_a_of_type_Aywc), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
          PublicFragmentActivity.a(aywc.g(this.jdField_a_of_type_Aywc), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((aywc.a(this.jdField_a_of_type_Aywc) != null) && (aywc.a(this.jdField_a_of_type_Aywc).isShowing())) {
            aywc.a(this.jdField_a_of_type_Aywc).dismiss();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
            break label284;
          }
          bcef.b(aywc.e(this.jdField_a_of_type_Aywc), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(aywc.h(this.jdField_a_of_type_Aywc));
          aywc.i(this.jdField_a_of_type_Aywc).startActivityForResult(localIntent, 1022);
        }
        label284:
        bcef.b(aywc.f(this.jdField_a_of_type_Aywc), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywg
 * JD-Core Version:    0.7.0.1
 */