import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class asge
  implements bhqd
{
  asge(asgd paramasgd) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      aact.a(paramView, asgd.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), asgd.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), asgd.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), asgd.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), asgd.a(this.a).type + "");
      aact.a(akro.a(), "769", "205027", asgd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new atxe(asfu.a(asgd.a(this.a)), asfu.a(asgd.a(this.a)));
      paramView.a(asgd.a(this.a).title, asgd.a(this.a).a().gameName, asgd.a(this.a).jumpUrl, asgd.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new asgf(this));
      return;
    }
    paramView = new HashMap();
    aact.a(paramView, asgd.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), asgd.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), asgd.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), asgd.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), asgd.a(this.a).type + "");
    aact.a(akro.a(), "769", "205025", asgd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (bdpx)asfu.a(asgd.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(asgd.a(this.a).feedId);
    paramView.a(localArrayList);
    if (asgd.a(this.a) != null) {
      asgd.a(this.a).dismiss();
    }
    asgd.a(this.a).a(asgd.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asge
 * JD-Core Version:    0.7.0.1
 */