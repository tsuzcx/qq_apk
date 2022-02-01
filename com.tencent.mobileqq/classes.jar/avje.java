import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class avje
  implements bliz
{
  avje(avjd paramavjd) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      acik.a(paramView, avjd.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), avjd.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), avjd.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), avjd.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), avjd.a(this.a).type + "");
      acik.a(anbd.a(), "769", "205027", avjd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new axbp(aviu.a(avjd.a(this.a)), aviu.a(avjd.a(this.a)));
      paramView.a(avjd.a(this.a).title, avjd.a(this.a).a().gameName, avjd.a(this.a).jumpUrl, avjd.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new avjf(this));
      return;
    }
    paramView = new HashMap();
    acik.a(paramView, avjd.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), avjd.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), avjd.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), avjd.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), avjd.a(this.a).type + "");
    acik.a(anbd.a(), "769", "205025", avjd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (VasExtensionHandler)aviu.a(avjd.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(avjd.a(this.a).feedId);
    paramView.a(localArrayList);
    if (avjd.a(this.a) != null) {
      avjd.a(this.a).dismiss();
    }
    avjd.a(this.a).a(avjd.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avje
 * JD-Core Version:    0.7.0.1
 */