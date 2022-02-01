import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bmif
  implements View.OnClickListener
{
  public bmif(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    this.a.j();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmif
 * JD-Core Version:    0.7.0.1
 */