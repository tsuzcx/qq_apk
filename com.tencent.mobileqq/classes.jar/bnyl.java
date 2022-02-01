import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bnyl
  implements View.OnClickListener
{
  public bnyl(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorVideoEditFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyl
 * JD-Core Version:    0.7.0.1
 */