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

class axau
  implements View.OnClickListener
{
  axau(awzr paramawzr, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Awzr.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + awzr.a(this.jdField_a_of_type_Awzr).gender);
    String str = amtj.a(2131706367);
    if (this.jdField_a_of_type_Awzr.a.e != 2) {
      if (awzr.a(this.jdField_a_of_type_Awzr).gender == 0)
      {
        str = amtj.a(2131706436);
        ((Intent)localObject).putExtra("title", str + amtj.a(2131706487));
        this.jdField_a_of_type_Awzr.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Awzr.a.app;
        if (this.jdField_a_of_type_Awzr.a.e != 2) {
          break label275;
        }
      }
    }
    label275:
    for (str = "1";; str = "2")
    {
      bcef.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = amtj.a(2131706470);
        break;
        if (this.jdField_a_of_type_Awzr.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((awhw)this.jdField_a_of_type_Awzr.a.app.getManager(106)).d.put(this.jdField_a_of_type_Awzr.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axau
 * JD-Core Version:    0.7.0.1
 */