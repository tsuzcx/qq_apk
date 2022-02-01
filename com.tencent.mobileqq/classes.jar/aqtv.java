import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqtv
  implements View.OnClickListener
{
  public aqtv(ColorNoteSettingFragment paramColorNoteSettingFragment, aque paramaque, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aque.a(paramView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtv
 * JD-Core Version:    0.7.0.1
 */