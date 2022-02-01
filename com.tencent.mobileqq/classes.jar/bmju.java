import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;

public class bmju
  implements View.OnClickListener
{
  public bmju(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (bmbv.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AEEditorMultiCutEditFragment.a(this.a).a())
      {
        AEEditorMultiCutEditFragment.d(this.a, false);
        AEEditorMultiCutEditFragment.a(this.a).b();
      }
      else
      {
        AEEditorMultiCutEditFragment.d(this.a, true);
        AEEditorMultiCutEditFragment.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmju
 * JD-Core Version:    0.7.0.1
 */