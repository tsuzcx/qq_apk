import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asdj
  implements View.OnClickListener
{
  public asdj(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel) {}
  
  public void onClick(View paramView)
  {
    RelatedEmoSlideBottomPanel.a(this.a, 1);
    RelatedEmoSlideBottomPanel.a(this.a, this.a.getMeasuredHeight());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdj
 * JD-Core Version:    0.7.0.1
 */