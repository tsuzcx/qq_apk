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

class bago
  implements View.OnClickListener
{
  bago(bagl parambagl, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (asvi.a(bagl.a(this.jdField_a_of_type_Bagl).getCurrentAccountUin()))
    {
      localObject = atcx.a(bagl.a(this.jdField_a_of_type_Bagl));
      int j = 1;
      int i = j;
      if ((bagl.b(this.jdField_a_of_type_Bagl) instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)bagl.c(this.jdField_a_of_type_Bagl)).e) {
          i = 2;
        }
      }
      bdll.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((bagl.d(this.jdField_a_of_type_Bagl) != null) && (!bagl.e(this.jdField_a_of_type_Bagl).isFinishing())) {
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
      PublicFragmentActivity.a(bagl.f(this.jdField_a_of_type_Bagl), localIntent, ExtendFriendEditFragment.class, 4097);
      bdll.b(bagl.b(this.jdField_a_of_type_Bagl), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bago
 * JD-Core Version:    0.7.0.1
 */