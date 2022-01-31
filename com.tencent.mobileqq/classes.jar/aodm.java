import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

class aodm
  implements View.OnClickListener
{
  aodm(aodl paramaodl) {}
  
  public void onClick(View paramView)
  {
    if ((aodl.a(this.a) != null) && (aodl.a(this.a).getVisibility() == 0) && (aodl.a(this.a).hasFocus())) {
      return;
    }
    aodl.a(this.a);
    paramView = new Bundle();
    paramView.putInt("start_from", 1);
    ColorNoteSettingFragment.a(aodl.a(this.a), ColorNoteSettingFragment.class, paramView);
    azqs.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodm
 * JD-Core Version:    0.7.0.1
 */