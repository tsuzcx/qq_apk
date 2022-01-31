import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

class anzd
  implements View.OnClickListener
{
  anzd(anzc paramanzc) {}
  
  public void onClick(View paramView)
  {
    if ((anzc.a(this.a) != null) && (anzc.a(this.a).getVisibility() == 0) && (anzc.a(this.a).hasFocus())) {
      return;
    }
    anzc.a(this.a);
    paramView = new Bundle();
    paramView.putInt("start_from", 1);
    ColorNoteSettingFragment.a(anzc.a(this.a), ColorNoteSettingFragment.class, paramView);
    azmj.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzd
 * JD-Core Version:    0.7.0.1
 */