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

class askl
  implements View.OnClickListener
{
  askl(askk paramaskk) {}
  
  public void onClick(View paramView)
  {
    if ((askk.a(this.a) == null) || (TextUtils.isEmpty(askk.a(this.a).jumpUrl))) {
      return;
    }
    paramView = new Intent(askd.a(askk.a(this.a)), QQBrowserActivity.class);
    paramView.putExtra("url", askk.a(this.a).jumpUrl);
    askd.a(askk.a(this.a)).startActivity(paramView);
    paramView = new HashMap();
    aahi.a(paramView, askk.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), askk.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), askk.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), askk.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), askk.a(this.a).type + "");
    aahi.a(akwd.a(), "769", "205022", askk.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askl
 * JD-Core Version:    0.7.0.1
 */