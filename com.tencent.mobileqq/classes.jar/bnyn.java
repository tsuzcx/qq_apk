import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bnyn
  implements View.OnClickListener
{
  public bnyn(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    this.a.j();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyn
 * JD-Core Version:    0.7.0.1
 */