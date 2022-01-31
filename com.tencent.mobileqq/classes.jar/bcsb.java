import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.mobileqq.widget.VoteViewV2.1;

public class bcsb
  implements View.OnClickListener
{
  public bcsb(VoteViewV2.1 param1) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(VoteViewV2.a(this.a.this$0), QQBrowserActivity.class);
    String str = bbpp.a(VoteViewV2.a(this.a.this$0), "praise", "");
    VasWebviewUtil.openQQBrowserWithoutAD(VoteViewV2.a(this.a.this$0), str, 536870912L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_click", null, 1, 0, 0, null, "0", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcsb
 * JD-Core Version:    0.7.0.1
 */