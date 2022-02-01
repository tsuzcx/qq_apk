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

class baba
  implements View.OnClickListener
{
  baba(baax parambaax, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (aslo.a(baax.a(this.jdField_a_of_type_Baax).getCurrentAccountUin()))
    {
      localObject = astl.a(baax.a(this.jdField_a_of_type_Baax));
      int j = 1;
      int i = j;
      if ((baax.b(this.jdField_a_of_type_Baax) instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)baax.c(this.jdField_a_of_type_Baax)).e) {
          i = 2;
        }
      }
      bdla.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((baax.d(this.jdField_a_of_type_Baax) != null) && (!baax.e(this.jdField_a_of_type_Baax).isFinishing())) {
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
      PublicFragmentActivity.a(baax.f(this.jdField_a_of_type_Baax), localIntent, ExtendFriendEditFragment.class, 4097);
      bdla.b(baax.b(this.jdField_a_of_type_Baax), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baba
 * JD-Core Version:    0.7.0.1
 */