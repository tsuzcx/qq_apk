import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class berr
  implements View.OnClickListener
{
  public berr(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    if (WriteTogetherEditorFragment.a(this.a).a() == CreatingState.TEMPLATE_SHOW_ENTRANCE)
    {
      bdla.b(null, "dc00898", "", "", "0X800B357", "0X800B357", 0, 0, "", "", "", "");
      WriteTogetherEditorFragment.a(this.a).a(CreatingState.TEMPLATE_SHOW_LAYER);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berr
 * JD-Core Version:    0.7.0.1
 */