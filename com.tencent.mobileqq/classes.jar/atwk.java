import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class atwk
  implements bjoe
{
  atwk(atwj paramatwj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      abet.a(paramView, atwj.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), atwj.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), atwj.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), atwj.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), atwj.a(this.a).type + "");
      abet.a(alvx.a(), "769", "205027", atwj.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new avow(atwa.a(atwj.a(this.a)), atwa.a(atwj.a(this.a)));
      paramView.a(atwj.a(this.a).title, atwj.a(this.a).a().gameName, atwj.a(this.a).jumpUrl, atwj.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new atwl(this));
      return;
    }
    paramView = new HashMap();
    abet.a(paramView, atwj.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), atwj.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), atwj.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), atwj.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), atwj.a(this.a).type + "");
    abet.a(alvx.a(), "769", "205025", atwj.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (VasExtensionHandler)atwa.a(atwj.a(this.a)).getBusinessHandler(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(atwj.a(this.a).feedId);
    paramView.a(localArrayList);
    if (atwj.a(this.a) != null) {
      atwj.a(this.a).dismiss();
    }
    atwj.a(this.a).a(atwj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwk
 * JD-Core Version:    0.7.0.1
 */