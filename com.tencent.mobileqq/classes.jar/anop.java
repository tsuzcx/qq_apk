import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anop
  implements View.OnClickListener
{
  anop(anon paramanon) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bcef.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (anoh.a != null) {
        anon.a(this.a).startActivity(anoh.a);
      }
      for (;;)
      {
        this.a.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (anon.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(anon.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        anoh.a(anon.a(this.a));
        anon.a(this.a).startActivity(anoh.a);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(anon.a(), 2, "Start Activity Failed");
          anon.a(this.a).startActivity(bfwj.c(anon.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(anon.a(), 2, "mAppInterface=null, use default intent");
          }
          anon.a(this.a).startActivity(bfwj.a(anon.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anop
 * JD-Core Version:    0.7.0.1
 */