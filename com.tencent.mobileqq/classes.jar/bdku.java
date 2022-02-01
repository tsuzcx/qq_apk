import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdku
  implements View.OnClickListener
{
  public bdku(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    WriteTogetherEditorFragment.a(this.a, true);
    WriteTogetherEditorFragment.e(this.a);
    if ((bdgn.a(WriteTogetherEditorFragment.a(this.a).f)) || (!WriteTogetherEditorFragment.a(this.a).a())) {
      WriteTogetherEditorFragment.f(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdku
 * JD-Core Version:    0.7.0.1
 */