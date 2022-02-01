import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aori
  implements View.OnClickListener
{
  aori(aorg paramaorg) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bdla.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (aora.a != null) {
        aorg.a(this.a).startActivity(aora.a);
      }
      for (;;)
      {
        this.a.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aorg.a(this.a) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(aorg.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        aora.a(aorg.a(this.a));
        aorg.a(this.a).startActivity(aora.a);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(aorg.a(), 2, "Start Activity Failed");
          aorg.a(this.a).startActivity(bhfb.c(aorg.a(this.a)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(aorg.a(), 2, "mAppInterface=null, use default intent");
          }
          aorg.a(this.a).startActivity(bhfb.a(aorg.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */