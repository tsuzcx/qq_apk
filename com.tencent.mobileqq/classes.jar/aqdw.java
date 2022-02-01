import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqdw
  implements View.OnClickListener
{
  aqdw(aqdv paramaqdv) {}
  
  public void onClick(View paramView)
  {
    if ((aqdv.a(this.a) != null) && (aqdv.a(this.a).getVisibility() == 0) && (aqdv.a(this.a).hasFocus())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqdv.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(aqdv.a(this.a), ColorNoteSettingFragment.class, localBundle);
      bcst.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdw
 * JD-Core Version:    0.7.0.1
 */