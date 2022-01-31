import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

class amic
  implements View.OnClickListener
{
  amic(amib paramamib) {}
  
  public void onClick(View paramView)
  {
    if ((amib.a(this.a) != null) && (amib.a(this.a).getVisibility() == 0) && (amib.a(this.a).hasFocus())) {
      return;
    }
    amib.a(this.a);
    paramView = new Bundle();
    paramView.putInt("start_from", 1);
    ColorNoteSettingFragment.a(amib.a(this.a), ColorNoteSettingFragment.class, paramView);
    axqy.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amic
 * JD-Core Version:    0.7.0.1
 */