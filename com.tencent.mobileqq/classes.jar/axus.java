import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class axus
  implements View.OnClickListener
{
  axus(axtp paramaxtp, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Axtp.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + axtp.a(this.jdField_a_of_type_Axtp).gender);
    String str = anni.a(2131706030);
    if (this.jdField_a_of_type_Axtp.a.e != 2) {
      if (axtp.a(this.jdField_a_of_type_Axtp).gender == 0)
      {
        str = anni.a(2131706099);
        ((Intent)localObject).putExtra("title", str + anni.a(2131706150));
        this.jdField_a_of_type_Axtp.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Axtp.a.app;
        if (this.jdField_a_of_type_Axtp.a.e != 2) {
          break label275;
        }
      }
    }
    label275:
    for (str = "1";; str = "2")
    {
      bcst.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = anni.a(2131706133);
        break;
        if (this.jdField_a_of_type_Axtp.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((axby)this.jdField_a_of_type_Axtp.a.app.getManager(106)).d.put(this.jdField_a_of_type_Axtp.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axus
 * JD-Core Version:    0.7.0.1
 */