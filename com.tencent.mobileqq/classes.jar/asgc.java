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

class asgc
  implements View.OnClickListener
{
  asgc(asgb paramasgb) {}
  
  public void onClick(View paramView)
  {
    if ((asgb.a(this.a) == null) || (TextUtils.isEmpty(asgb.a(this.a).jumpUrl))) {
      return;
    }
    paramView = new Intent(asfu.a(asgb.a(this.a)), QQBrowserActivity.class);
    paramView.putExtra("url", asgb.a(this.a).jumpUrl);
    asfu.a(asgb.a(this.a)).startActivity(paramView);
    paramView = new HashMap();
    aact.a(paramView, asgb.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), asgb.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), asgb.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), asgb.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), asgb.a(this.a).type + "");
    aact.a(akro.a(), "769", "205022", asgb.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgc
 * JD-Core Version:    0.7.0.1
 */