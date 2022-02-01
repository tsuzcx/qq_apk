import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class babz
  implements View.OnClickListener
{
  babz(baby parambaby) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof azpb)) {}
    switch (((azpb)localObject).a)
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    localObject = new Intent(baby.a(this.a), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", ((azrb)baby.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.presentCustourl);
    baby.b(this.a).startActivity((Intent)localObject);
    ThreadManager.getFileThreadHandler().post(new ProfilePresentWallComponent.1.1(this));
    if (((azrb)baby.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
      bdla.b(baby.a(this.a), "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      azyh.f(baby.c(this.a), (azrb)baby.c(this.a));
      break;
      bdla.b(baby.b(this.a), "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babz
 * JD-Core Version:    0.7.0.1
 */