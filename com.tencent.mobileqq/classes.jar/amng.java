import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class amng
  implements View.OnClickListener
{
  amng(amne paramamne) {}
  
  public void onClick(View paramView)
  {
    try
    {
      azqs.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (ammy.a != null) {
        amne.a(this.a).startActivity(ammy.a);
      }
      for (;;)
      {
        this.a.dismiss();
        return;
        if (amne.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(amne.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        ammy.a(amne.a(this.a));
        amne.a(this.a).startActivity(ammy.a);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(amne.a(), 2, "Start Activity Failed");
          amne.a(this.a).startActivity(bdie.c(amne.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(amne.a(), 2, "mAppInterface=null, use default intent");
          }
          amne.a(this.a).startActivity(bdie.a(amne.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amng
 * JD-Core Version:    0.7.0.1
 */