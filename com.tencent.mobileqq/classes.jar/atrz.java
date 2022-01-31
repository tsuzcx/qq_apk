import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class atrz
  implements View.OnClickListener
{
  atrz(atqw paramatqw, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Atqw.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + atqw.a(this.jdField_a_of_type_Atqw).gender);
    paramView = ajya.a(2131707255);
    if (this.jdField_a_of_type_Atqw.a.e != 2) {
      if (atqw.a(this.jdField_a_of_type_Atqw).gender == 0)
      {
        paramView = ajya.a(2131707324);
        ((Intent)localObject).putExtra("title", paramView + ajya.a(2131707375));
        this.jdField_a_of_type_Atqw.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Atqw.a.app;
        if (this.jdField_a_of_type_Atqw.a.e != 2) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = "1";; paramView = "2")
    {
      axqy.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = ajya.a(2131707358);
      break;
      if (this.jdField_a_of_type_Atqw.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((aszf)this.jdField_a_of_type_Atqw.a.app.getManager(106)).d.put(this.jdField_a_of_type_Atqw.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrz
 * JD-Core Version:    0.7.0.1
 */