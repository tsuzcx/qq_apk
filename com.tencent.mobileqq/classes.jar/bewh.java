import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteView.1;

public class bewh
  implements View.OnClickListener
{
  public bewh(VoteView.1 param1) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.this$0.getContext(), QQBrowserActivity.class);
    String str = bdtg.a(this.a.this$0.getContext(), "praise", "");
    VasWebviewUtil.openQQBrowserWithoutAD(this.a.this$0.getContext(), str, 536870912L, paramView, false, -1);
    VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_click", null, 1, 0, 0, null, "1", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewh
 * JD-Core Version:    0.7.0.1
 */