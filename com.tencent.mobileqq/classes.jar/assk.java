import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class assk
  implements View.OnClickListener
{
  public assk(SystemAndEmojiEmoticonPanelWithActionBar paramSystemAndEmojiEmoticonPanelWithActionBar) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assk
 * JD-Core Version:    0.7.0.1
 */