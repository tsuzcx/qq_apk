import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class beqc
  implements View.OnClickListener
{
  public beqc(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.f(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqc
 * JD-Core Version:    0.7.0.1
 */