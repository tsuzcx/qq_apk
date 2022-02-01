import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqqi
  implements View.OnClickListener
{
  public aqqi(ColorNoteSettingFragment paramColorNoteSettingFragment, aqqr paramaqqr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aqqr.a(paramView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqi
 * JD-Core Version:    0.7.0.1
 */