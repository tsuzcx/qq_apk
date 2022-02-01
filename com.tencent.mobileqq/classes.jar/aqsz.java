import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqsz
  implements View.OnClickListener
{
  aqsz(aqsy paramaqsy) {}
  
  public void onClick(View paramView)
  {
    if ((aqsy.a(this.a) != null) && (aqsy.a(this.a).getVisibility() == 0) && (aqsy.a(this.a).hasFocus())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqsy.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(aqsy.a(this.a), ColorNoteSettingFragment.class, localBundle);
      bdll.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsz
 * JD-Core Version:    0.7.0.1
 */