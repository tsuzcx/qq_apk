import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoib
  implements View.OnClickListener
{
  aoib(aohz paramaohz) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bcst.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (aoht.a != null) {
        aohz.a(this.a).startActivity(aoht.a);
      }
      for (;;)
      {
        this.a.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aohz.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aohz.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        aoht.a(aohz.a(this.a));
        aohz.a(this.a).startActivity(aoht.a);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(aohz.a(), 2, "Start Activity Failed");
          aohz.a(this.a).startActivity(bgnj.c(aohz.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(aohz.a(), 2, "mAppInterface=null, use default intent");
          }
          aohz.a(this.a).startActivity(bgnj.a(aohz.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoib
 * JD-Core Version:    0.7.0.1
 */