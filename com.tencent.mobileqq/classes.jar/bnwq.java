import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;

public class bnwq
  implements View.OnClickListener
{
  public bnwq(AEEditorMvClipMenu paramAEEditorMvClipMenu) {}
  
  public void onClick(View paramView)
  {
    AEEditorMvClipMenu.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwq
 * JD-Core Version:    0.7.0.1
 */