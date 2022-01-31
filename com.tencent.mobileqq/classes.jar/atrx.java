import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class atrx
  implements View.OnClickListener
{
  atrx(atqu paramatqu, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Atqu.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + atqu.a(this.jdField_a_of_type_Atqu).gender);
    paramView = ajyc.a(2131707244);
    if (this.jdField_a_of_type_Atqu.a.e != 2) {
      if (atqu.a(this.jdField_a_of_type_Atqu).gender == 0)
      {
        paramView = ajyc.a(2131707313);
        ((Intent)localObject).putExtra("title", paramView + ajyc.a(2131707364));
        this.jdField_a_of_type_Atqu.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Atqu.a.app;
        if (this.jdField_a_of_type_Atqu.a.e != 2) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = "1";; paramView = "2")
    {
      axqw.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = ajyc.a(2131707347);
      break;
      if (this.jdField_a_of_type_Atqu.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((aszd)this.jdField_a_of_type_Atqu.a.app.getManager(106)).d.put(this.jdField_a_of_type_Atqu.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrx
 * JD-Core Version:    0.7.0.1
 */