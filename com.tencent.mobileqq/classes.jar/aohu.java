import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aohu
  implements View.OnClickListener
{
  aohu(aoht paramaoht) {}
  
  public void onClick(View paramView)
  {
    if (aoht.a != null) {
      aoht.a(this.a).startActivity(aoht.a);
    }
    bcst.b(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
    bcst.b(null, "dc00898", "", "", "0X8009AC8", "0X8009AC8", 0, 0, "", "", "", "");
    Object localObject = PreferenceManager.getDefaultSharedPreferences(aoht.a(this.a));
    int i = ((SharedPreferences)localObject).getInt("push_msg_notify_open", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("push_msg_notify_open", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohu
 * JD-Core Version:    0.7.0.1
 */