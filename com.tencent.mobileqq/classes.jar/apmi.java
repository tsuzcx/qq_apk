import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apmi
  implements View.OnClickListener
{
  apmi(apmh paramapmh) {}
  
  public void onClick(View paramView)
  {
    if ((apmh.a(this.a) != null) && (apmh.a(this.a).getVisibility() == 0) && (apmh.a(this.a).hasFocus())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      apmh.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(apmh.a(this.a), ColorNoteSettingFragment.class, localBundle);
      bcef.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmi
 * JD-Core Version:    0.7.0.1
 */