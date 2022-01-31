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

class aqqk
  implements View.OnClickListener
{
  aqqk(aqqj paramaqqj) {}
  
  public void onClick(View paramView)
  {
    if ((aqqj.a(this.a) == null) || (TextUtils.isEmpty(aqqj.a(this.a).jumpUrl))) {
      return;
    }
    paramView = new Intent(aqqc.a(aqqj.a(this.a)), QQBrowserActivity.class);
    paramView.putExtra("url", aqqj.a(this.a).jumpUrl);
    aqqc.a(aqqj.a(this.a)).startActivity(paramView);
    paramView = new HashMap();
    yoa.a(paramView, aqqj.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), aqqj.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), aqqj.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), aqqj.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), aqqj.a(this.a).type + "");
    yoa.a(ajac.a(), "769", "205022", aqqj.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqk
 * JD-Core Version:    0.7.0.1
 */