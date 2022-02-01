import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avey
  implements AdapterView.OnItemClickListener
{
  avey(avex paramavex) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (avex.a(this.a) != null) {}
    try
    {
      avbx localavbx = (avbx)paramAdapterView.getItemAtPosition(paramInt);
      avex.a(this.a).a(localavbx.a);
      avdu.a(aiah.c, "1", "145", "920", "92005", "207649", localavbx.a, "", "20", "");
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GameMsgQuickReplyView", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avey
 * JD-Core Version:    0.7.0.1
 */