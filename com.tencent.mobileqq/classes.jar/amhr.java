import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.onPreShowListener;

public class amhr
  implements Runnable
{
  public amhr(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).a();
    }
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, ActionSheet.a(this.a).getHeight(), 0.0F));
    ActionSheet.a(this.a).setFillEnabled(true);
    ActionSheet.a(this.a).setStartTime(300L);
    ActionSheet.a(this.a).setDuration(ActionSheet.a(this.a));
    ActionSheet.a(this.a, true);
    ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhr
 * JD-Core Version:    0.7.0.1
 */