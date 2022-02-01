import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.mobileqq.widget.VoteViewV2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhka
  implements View.OnClickListener
{
  public bhka(VoteViewV2.1 param1) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(VoteViewV2.a(this.a.this$0), QQBrowserActivity.class);
    String str = bgev.a(VoteViewV2.a(this.a.this$0), "praise", "");
    VasWebviewUtil.openQQBrowserWithoutAD(VoteViewV2.a(this.a.this$0), str, 536870912L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_click", null, 1, 0, 0, null, "0", null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhka
 * JD-Core Version:    0.7.0.1
 */