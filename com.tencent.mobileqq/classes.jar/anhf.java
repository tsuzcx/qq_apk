import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneShareServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

class anhf
  implements Runnable
{
  anhf(anhe paramanhe, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Anhe.a.a.app.getAccount();
    String str = ((TicketManager)this.jdField_a_of_type_Anhe.a.a.app.getManager(2)).getSkey((String)localObject);
    if (new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).equals(QZoneShareManager.a(this.jdField_a_of_type_JavaUtilArrayList, (String)localObject, str, "1"))) {
      QLog.e("QZoneShare", 1, "imageChangeError!");
    }
    try
    {
      l1 = Long.parseLong(QZoneShareActivity.a(this.jdField_a_of_type_Anhe.a.a).f);
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = this.jdField_a_of_type_Anhe.a.a.app.getLongAccountUin();
      }
      localObject = new NewIntent(this.jdField_a_of_type_Anhe.a.a, QzoneShareServlet.class);
      ((NewIntent)localObject).putExtra("reason", this.jdField_a_of_type_JavaLangString);
      ((NewIntent)localObject).putExtra("uin", l2);
      ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.a(this.jdField_a_of_type_Anhe.a.a));
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
      QLog.e("QZoneShare", 1, "startShare()");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */