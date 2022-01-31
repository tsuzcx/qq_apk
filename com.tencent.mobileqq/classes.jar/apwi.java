import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class apwi
  implements begw
{
  apwi(apwh paramapwh) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      yez.a(paramView, apwh.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), apwh.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), apwh.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), apwh.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), apwh.a(this.a).type + "");
      yez.a(aing.a(), "769", "205027", apwh.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new arjz(apvy.a(apwh.a(this.a)), apvy.a(apwh.a(this.a)));
      paramView.a(apwh.a(this.a).title, apwh.a(this.a).a().gameName, apwh.a(this.a).jumpUrl, apwh.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new apwj(this));
      return;
    }
    paramView = new HashMap();
    yez.a(paramView, apwh.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), apwh.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), apwh.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), apwh.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), apwh.a(this.a).type + "");
    yez.a(aing.a(), "769", "205025", apwh.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (baot)apvy.a(apwh.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(apwh.a(this.a).feedId);
    paramView.a(localArrayList);
    if (apwh.a(this.a) != null) {
      apwh.a(this.a).dismiss();
    }
    apwh.a(this.a).a(apwh.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */