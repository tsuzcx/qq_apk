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

class azny
  implements View.OnClickListener
{
  azny(aznv paramaznv, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (asfu.a(aznv.a(this.jdField_a_of_type_Aznv).getCurrentAccountUin()))
    {
      localObject = asmy.a(aznv.a(this.jdField_a_of_type_Aznv));
      int j = 1;
      int i = j;
      if ((aznv.b(this.jdField_a_of_type_Aznv) instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)aznv.c(this.jdField_a_of_type_Aznv)).e) {
          i = 2;
        }
      }
      bcst.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((aznv.d(this.jdField_a_of_type_Aznv) != null) && (!aznv.e(this.jdField_a_of_type_Aznv).isFinishing())) {
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
      PublicFragmentActivity.a(aznv.f(this.jdField_a_of_type_Aznv), localIntent, ExtendFriendEditFragment.class, 4097);
      bcst.b(aznv.b(this.jdField_a_of_type_Aznv), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azny
 * JD-Core Version:    0.7.0.1
 */