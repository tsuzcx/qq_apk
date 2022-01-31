import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.HashMap;
import java.util.Map;

class apwg
  implements View.OnClickListener
{
  apwg(apwf paramapwf) {}
  
  public void onClick(View paramView)
  {
    if ((apwf.a(this.a) == null) || (TextUtils.isEmpty(apwf.a(this.a).jumpUrl))) {
      return;
    }
    paramView = new Intent(apvy.a(apwf.a(this.a)), QQBrowserActivity.class);
    paramView.putExtra("url", apwf.a(this.a).jumpUrl);
    apvy.a(apwf.a(this.a)).startActivity(paramView);
    paramView = new HashMap();
    yez.a(paramView, apwf.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), apwf.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), apwf.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), apwf.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), apwf.a(this.a).type + "");
    yez.a(aing.a(), "769", "205022", apwf.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apwg
 * JD-Core Version:    0.7.0.1
 */