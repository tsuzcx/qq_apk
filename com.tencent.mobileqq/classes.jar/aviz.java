import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aviz
  implements View.OnClickListener
{
  aviz(avhw paramavhw, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Avhw.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + avhw.a(this.jdField_a_of_type_Avhw).gender);
    paramView = alpo.a(2131707627);
    if (this.jdField_a_of_type_Avhw.a.e != 2) {
      if (avhw.a(this.jdField_a_of_type_Avhw).gender == 0)
      {
        paramView = alpo.a(2131707696);
        ((Intent)localObject).putExtra("title", paramView + alpo.a(2131707747));
        this.jdField_a_of_type_Avhw.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Avhw.a.app;
        if (this.jdField_a_of_type_Avhw.a.e != 2) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = "1";; paramView = "2")
    {
      azmj.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = alpo.a(2131707730);
      break;
      if (this.jdField_a_of_type_Avhw.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((auqc)this.jdField_a_of_type_Avhw.a.app.getManager(106)).d.put(this.jdField_a_of_type_Avhw.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aviz
 * JD-Core Version:    0.7.0.1
 */