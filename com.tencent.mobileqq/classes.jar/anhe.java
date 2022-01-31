import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneShareServlet;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class anhe
  implements Runnable
{
  anhe(anhd paramanhd, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.b)
    {
      QQToast.a(this.jdField_a_of_type_Anhd.a, 4, 2131432457, 0).a();
      return;
    }
    this.jdField_a_of_type_Anhd.a.g();
    String str1 = QzoneEmotionUtils.b(this.jdField_a_of_type_Anhd.a.a());
    try
    {
      l1 = Long.parseLong(QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a).f);
      l2 = l1;
      if (l1 <= 0L) {
        l2 = this.jdField_a_of_type_Anhd.a.app.getLongAccountUin();
      }
      if (l2 <= 0L)
      {
        l1 = this.jdField_a_of_type_Anhd.a.app.getLongAccountUin();
        Object localObject = QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a).a;
        if (localObject != null)
        {
          Iterator localIterator = ((ArrayList)localObject).iterator();
          String str2;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
          } while ((TextUtils.isEmpty(str2)) || (str2.startsWith("http://")) || (str2.startsWith("https://")));
          i = 0;
          if (i != 0)
          {
            localObject = new NewIntent(this.jdField_a_of_type_Anhd.a, QzoneShareServlet.class);
            ((NewIntent)localObject).putExtra("reason", str1);
            ((NewIntent)localObject).putExtra("uin", l1);
            ((NewIntent)localObject).putExtra("sharedata", QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a));
            BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
            QLog.e("QZoneShare", 1, "startShare()");
            if (QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a).b != 1) {
              break label369;
            }
            QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a, this.jdField_a_of_type_Anhd.a, QZoneShareActivity.a(this.jdField_a_of_type_Anhd.a), true);
            this.jdField_a_of_type_Anhd.a.setResult(-1, null);
            this.jdField_a_of_type_Anhd.a.finish();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
        continue;
        ThreadManager.postImmediately(new anhf(this, localException, str1), null, false);
        continue;
        label369:
        QQToast.a(this.jdField_a_of_type_Anhd.a, 5, "已分享", 0).a();
        continue;
        int i = 1;
        continue;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhe
 * JD-Core Version:    0.7.0.1
 */