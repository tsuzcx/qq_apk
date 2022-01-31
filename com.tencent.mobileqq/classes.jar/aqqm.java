import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class aqqm
  implements bfph
{
  aqqm(aqql paramaqql) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      yoa.a(paramView, aqql.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), aqql.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), aqql.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), aqql.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), aqql.a(this.a).type + "");
      yoa.a(ajac.a(), "769", "205027", aqql.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new asge(aqqc.a(aqql.a(this.a)), aqqc.a(aqql.a(this.a)));
      paramView.a(aqql.a(this.a).title, aqql.a(this.a).a().gameName, aqql.a(this.a).jumpUrl, aqql.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new aqqn(this));
      return;
    }
    paramView = new HashMap();
    yoa.a(paramView, aqql.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), aqql.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), aqql.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), aqql.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), aqql.a(this.a).type + "");
    yoa.a(ajac.a(), "769", "205025", aqql.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (bbrd)aqqc.a(aqql.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aqql.a(this.a).feedId);
    paramView.a(localArrayList);
    if (aqql.a(this.a) != null) {
      aqql.a(this.a).dismiss();
    }
    aqql.a(this.a).a(aqql.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqm
 * JD-Core Version:    0.7.0.1
 */