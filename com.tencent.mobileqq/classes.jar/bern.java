import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bern
  implements View.OnClickListener
{
  public bern(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.g(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bern
 * JD-Core Version:    0.7.0.1
 */