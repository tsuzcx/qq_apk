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

class aqqi
  implements View.OnClickListener
{
  aqqi(aqqh paramaqqh) {}
  
  public void onClick(View paramView)
  {
    if ((aqqh.a(this.a) == null) || (TextUtils.isEmpty(aqqh.a(this.a).jumpUrl))) {
      return;
    }
    paramView = new Intent(aqqa.a(aqqh.a(this.a)), QQBrowserActivity.class);
    paramView.putExtra("url", aqqh.a(this.a).jumpUrl);
    aqqa.a(aqqh.a(this.a)).startActivity(paramView);
    paramView = new HashMap();
    yod.a(paramView, aqqh.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), aqqh.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), aqqh.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), aqqh.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), aqqh.a(this.a).type + "");
    yod.a(ajae.a(), "769", "205022", aqqh.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqi
 * JD-Core Version:    0.7.0.1
 */