import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfip
  implements View.OnClickListener
{
  public bfip(TroopBarPublishActivity.16 param16) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("path", this.a.a);
    PublicFragmentActivity.a(this.a.this$0, localIntent, TribeVideoPreviewFragment.class);
    this.a.this$0.overridePendingTransition(2130772331, 2130772332);
    if ((this.a.this$0.b != null) && (this.a.this$0.b.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      bdll.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_full_screen", i, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfip
 * JD-Core Version:    0.7.0.1
 */