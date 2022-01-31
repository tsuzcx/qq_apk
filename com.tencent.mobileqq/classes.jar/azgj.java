import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16;

public class azgj
  implements View.OnClickListener
{
  public azgj(TroopBarPublishActivity.16 param16) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("path", this.a.a);
    PublicFragmentActivity.a(this.a.this$0, paramView, TribeVideoPreviewFragment.class);
    this.a.this$0.overridePendingTransition(2130772305, 2130772306);
    if ((this.a.this$0.b != null) && (this.a.this$0.b.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      axqw.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_full_screen", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azgj
 * JD-Core Version:    0.7.0.1
 */