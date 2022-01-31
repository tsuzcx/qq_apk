import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class asvt
  implements View.OnClickListener
{
  asvt(asuq paramasuq, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Asuq.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + asuq.a(this.jdField_a_of_type_Asuq).gender);
    paramView = ajjy.a(2131641459);
    if (this.jdField_a_of_type_Asuq.a.e != 2) {
      if (asuq.a(this.jdField_a_of_type_Asuq).gender == 0)
      {
        paramView = ajjy.a(2131641528);
        ((Intent)localObject).putExtra("title", paramView + ajjy.a(2131641579));
        this.jdField_a_of_type_Asuq.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Asuq.a.app;
        if (this.jdField_a_of_type_Asuq.a.e != 2) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = "1";; paramView = "2")
    {
      awqx.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = ajjy.a(2131641562);
      break;
      if (this.jdField_a_of_type_Asuq.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((ascz)this.jdField_a_of_type_Asuq.a.app.getManager(106)).d.put(this.jdField_a_of_type_Asuq.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asvt
 * JD-Core Version:    0.7.0.1
 */