import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class avni
  implements View.OnClickListener
{
  avni(avmf paramavmf, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Avmf.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + avmf.a(this.jdField_a_of_type_Avmf).gender);
    paramView = alud.a(2131707639);
    if (this.jdField_a_of_type_Avmf.a.e != 2) {
      if (avmf.a(this.jdField_a_of_type_Avmf).gender == 0)
      {
        paramView = alud.a(2131707708);
        ((Intent)localObject).putExtra("title", paramView + alud.a(2131707759));
        this.jdField_a_of_type_Avmf.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Avmf.a.app;
        if (this.jdField_a_of_type_Avmf.a.e != 2) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = "1";; paramView = "2")
    {
      azqs.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = alud.a(2131707742);
      break;
      if (this.jdField_a_of_type_Avmf.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((auul)this.jdField_a_of_type_Avmf.a.app.getManager(106)).d.put(this.jdField_a_of_type_Avmf.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avni
 * JD-Core Version:    0.7.0.1
 */