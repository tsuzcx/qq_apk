import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class ayha
  implements View.OnClickListener
{
  ayha(ayfx paramayfx, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Ayfx.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + ayfx.a(this.jdField_a_of_type_Ayfx).gender);
    String str = anvx.a(2131706719);
    if (this.jdField_a_of_type_Ayfx.a.e != 2) {
      if (ayfx.a(this.jdField_a_of_type_Ayfx).gender == 0)
      {
        str = anvx.a(2131706788);
        ((Intent)localObject).putExtra("title", str + anvx.a(2131706839));
        this.jdField_a_of_type_Ayfx.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_Ayfx.a.app;
        if (this.jdField_a_of_type_Ayfx.a.e != 2) {
          break label276;
        }
      }
    }
    label276:
    for (str = "1";; str = "2")
    {
      bdla.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = anvx.a(2131706822);
        break;
        if (this.jdField_a_of_type_Ayfx.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((axny)this.jdField_a_of_type_Ayfx.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.jdField_a_of_type_Ayfx.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayha
 * JD-Core Version:    0.7.0.1
 */