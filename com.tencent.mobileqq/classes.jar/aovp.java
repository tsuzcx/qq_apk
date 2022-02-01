import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aovp
  implements View.OnClickListener
{
  aovp(aovn paramaovn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bdll.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (aovh.a != null) {
        aovn.a(this.a).startActivity(aovh.a);
      }
      for (;;)
      {
        this.a.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aovn.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aovn.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        aovh.a(aovn.a(this.a));
        aovn.a(this.a).startActivity(aovh.a);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(aovn.a(), 2, "Start Activity Failed");
          aovn.a(this.a).startActivity(bhnl.c(aovn.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(aovn.a(), 2, "mAppInterface=null, use default intent");
          }
          aovn.a(this.a).startActivity(bhnl.a(aovn.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovp
 * JD-Core Version:    0.7.0.1
 */