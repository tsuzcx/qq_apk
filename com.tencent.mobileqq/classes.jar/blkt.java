import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class blkt
  implements View.OnClickListener
{
  public blkt(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onClick(View paramView)
  {
    AEEditorAILoadingView.a(this.a).setVisibility(8);
    if (AEEditorAILoadingView.a(this.a) != null) {
      AEEditorAILoadingView.a(this.a).a();
    }
    ((ViewGroup)this.a.getParent()).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkt
 * JD-Core Version:    0.7.0.1
 */