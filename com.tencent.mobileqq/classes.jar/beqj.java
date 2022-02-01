import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class beqj
  implements View.OnClickListener
{
  public beqj(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.a(this.a, true);
    WriteTogetherEditorFragment.d(this.a);
    if ((bemv.a(WriteTogetherEditorFragment.a(this.a).f)) || (!WriteTogetherEditorFragment.a(this.a).a())) {
      WriteTogetherEditorFragment.e(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqj
 * JD-Core Version:    0.7.0.1
 */