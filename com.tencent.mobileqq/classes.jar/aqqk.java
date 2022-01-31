import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class aqqk
  implements bfoq
{
  aqqk(aqqj paramaqqj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      yod.a(paramView, aqqj.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), aqqj.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), aqqj.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), aqqj.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), aqqj.a(this.a).type + "");
      yod.a(ajae.a(), "769", "205027", aqqj.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new asgc(aqqa.a(aqqj.a(this.a)), aqqa.a(aqqj.a(this.a)));
      paramView.a(aqqj.a(this.a).title, aqqj.a(this.a).a().gameName, aqqj.a(this.a).jumpUrl, aqqj.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new aqql(this));
      return;
    }
    paramView = new HashMap();
    yod.a(paramView, aqqj.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), aqqj.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), aqqj.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), aqqj.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), aqqj.a(this.a).type + "");
    yod.a(ajae.a(), "769", "205025", aqqj.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (bbqp)aqqa.a(aqqj.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aqqj.a(this.a).feedId);
    paramView.a(localArrayList);
    if (aqqj.a(this.a) != null) {
      aqqj.a(this.a).dismiss();
    }
    aqqj.a(this.a).a(aqqj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqk
 * JD-Core Version:    0.7.0.1
 */