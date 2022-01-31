import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class amir
  implements View.OnClickListener
{
  amir(amip paramamip) {}
  
  public void onClick(View paramView)
  {
    try
    {
      azmj.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (amij.a != null) {
        amip.a(this.a).startActivity(amij.a);
      }
      for (;;)
      {
        this.a.dismiss();
        return;
        if (amip.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(amip.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        amij.a(amip.a(this.a));
        amip.a(this.a).startActivity(amij.a);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(amip.a(), 2, "Start Activity Failed");
          amip.a(this.a).startActivity(bddv.c(amip.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(amip.a(), 2, "mAppInterface=null, use default intent");
          }
          amip.a(this.a).startActivity(bddv.a(amip.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amir
 * JD-Core Version:    0.7.0.1
 */