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

class aynm
  implements View.OnClickListener
{
  aynm(aymj paramaymj, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Aymj.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + aymj.a(this.jdField_a_of_type_Aymj).gender);
    String str = anzj.a(2131706137);
    if (this.jdField_a_of_type_Aymj.a.e != 2) {
      if (aymj.a(this.jdField_a_of_type_Aymj).gender == 0)
      {
        str = anzj.a(2131706206);
        ((Intent)localObject).putExtra("title", str + anzj.a(2131706257));
        this.jdField_a_of_type_Aymj.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Aymj.a.app;
        if (this.jdField_a_of_type_Aymj.a.e != 2) {
          break label275;
        }
      }
    }
    label275:
    for (str = "1";; str = "2")
    {
      bdll.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = anzj.a(2131706240);
        break;
        if (this.jdField_a_of_type_Aymj.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((axup)this.jdField_a_of_type_Aymj.a.app.getManager(106)).d.put(this.jdField_a_of_type_Aymj.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynm
 * JD-Core Version:    0.7.0.1
 */