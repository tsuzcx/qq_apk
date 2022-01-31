import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class askn
  implements bhuk
{
  askn(askm paramaskm) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      aahi.a(paramView, askm.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), askm.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), askm.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), askm.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), askm.a(this.a).type + "");
      aahi.a(akwd.a(), "769", "205027", askm.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new aubn(askd.a(askm.a(this.a)), askd.a(askm.a(this.a)));
      paramView.a(askm.a(this.a).title, askm.a(this.a).a().gameName, askm.a(this.a).jumpUrl, askm.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new asko(this));
      return;
    }
    paramView = new HashMap();
    aahi.a(paramView, askm.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), askm.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), askm.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), askm.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), askm.a(this.a).type + "");
    aahi.a(akwd.a(), "769", "205025", askm.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (bdug)askd.a(askm.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(askm.a(this.a).feedId);
    paramView.a(localArrayList);
    if (askm.a(this.a) != null) {
      askm.a(this.a).dismiss();
    }
    askm.a(this.a).a(askm.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askn
 * JD-Core Version:    0.7.0.1
 */