import android.app.Dialog;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aywf
  implements View.OnClickListener
{
  aywf(aywc paramaywc, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (arhi.a(aywc.a(this.jdField_a_of_type_Aywc).getCurrentAccountUin()))
    {
      localObject = arpf.a(aywc.a(this.jdField_a_of_type_Aywc));
      int j = 1;
      int i = j;
      if ((aywc.b(this.jdField_a_of_type_Aywc) instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)aywc.c(this.jdField_a_of_type_Aywc)).e) {
          i = 2;
        }
      }
      bcef.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((aywc.d(this.jdField_a_of_type_Aywc) != null) && (!aywc.e(this.jdField_a_of_type_Aywc).isFinishing())) {
        ((Dialog)localObject).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
      PublicFragmentActivity.a(aywc.f(this.jdField_a_of_type_Aywc), localIntent, ExtendFriendEditFragment.class, 4097);
      bcef.b(aywc.b(this.jdField_a_of_type_Aywc), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywf
 * JD-Core Version:    0.7.0.1
 */