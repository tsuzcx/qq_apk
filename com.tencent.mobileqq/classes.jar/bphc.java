import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bphc
  implements View.OnClickListener
{
  public bphc(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorVideoEditFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphc
 * JD-Core Version:    0.7.0.1
 */