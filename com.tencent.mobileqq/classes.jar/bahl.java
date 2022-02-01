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

public class bahl
  implements View.OnClickListener
{
  bahl(bahk parambahk) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof azvr)) {}
    switch (((azvr)localObject).a)
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    localObject = new Intent(bahk.a(this.a), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", ((azxr)bahk.a(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard.presentCustourl);
    bahk.b(this.a).startActivity((Intent)localObject);
    ThreadManager.getFileThreadHandler().post(new ProfilePresentWallComponent.1.1(this));
    if (((azxr)bahk.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
      bdll.b(bahk.a(this.a), "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      baew.f(bahk.c(this.a), (azxr)bahk.c(this.a));
      break;
      bdll.b(bahk.b(this.a), "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahl
 * JD-Core Version:    0.7.0.1
 */