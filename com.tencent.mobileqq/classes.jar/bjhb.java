import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjhb
  implements View.OnClickListener
{
  public bjhb(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhb
 * JD-Core Version:    0.7.0.1
 */