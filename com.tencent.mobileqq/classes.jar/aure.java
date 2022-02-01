import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class aure
  implements bkhw
{
  aure(aurd paramaurd) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      aceh.a(paramView, aurd.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), aurd.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), aurd.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), aurd.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), aurd.a(this.a).type + "");
      aceh.a(ampj.a(), "769", "205027", aurd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new awix(auqu.a(aurd.a(this.a)), auqu.a(aurd.a(this.a)));
      paramView.a(aurd.a(this.a).title, aurd.a(this.a).a().gameName, aurd.a(this.a).jumpUrl, aurd.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new aurf(this));
      return;
    }
    paramView = new HashMap();
    aceh.a(paramView, aurd.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), aurd.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), aurd.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), aurd.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), aurd.a(this.a).type + "");
    aceh.a(ampj.a(), "769", "205025", aurd.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (VasExtensionHandler)auqu.a(aurd.a(this.a)).a(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aurd.a(this.a).feedId);
    paramView.a(localArrayList);
    if (aurd.a(this.a) != null) {
      aurd.a(this.a).dismiss();
    }
    aurd.a(this.a).a(aurd.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aure
 * JD-Core Version:    0.7.0.1
 */