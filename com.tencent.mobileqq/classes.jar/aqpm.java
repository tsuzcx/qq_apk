import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqpm
  implements View.OnClickListener
{
  aqpm(aqpl paramaqpl) {}
  
  public void onClick(View paramView)
  {
    if ((aqpl.a(this.a) != null) && (aqpl.a(this.a).getVisibility() == 0) && (aqpl.a(this.a).hasFocus())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqpl.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(aqpl.a(this.a), ColorNoteSettingFragment.class, localBundle);
      bdla.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpm
 * JD-Core Version:    0.7.0.1
 */