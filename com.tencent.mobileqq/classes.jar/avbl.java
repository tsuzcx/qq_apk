import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class avbl
  implements bkzq
{
  avbl(avbk paramavbk) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      abuf.a(paramView, avbk.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), avbk.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), avbk.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), avbk.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), avbk.a(this.a).type + "");
      abuf.a(amwn.a(), "769", "205027", avbk.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new awvb(avbb.a(avbk.a(this.a)), avbb.a(avbk.a(this.a)));
      paramView.a(avbk.a(this.a).title, avbk.a(this.a).a().gameName, avbk.a(this.a).jumpUrl, avbk.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.a(new avbm(this));
      return;
    }
    paramView = new HashMap();
    abuf.a(paramView, avbk.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), avbk.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), avbk.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), avbk.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), avbk.a(this.a).type + "");
    abuf.a(amwn.a(), "769", "205025", avbk.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (VasExtensionHandler)avbb.a(avbk.a(this.a)).getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(avbk.a(this.a).feedId);
    paramView.a(localArrayList);
    if (avbk.a(this.a) != null) {
      avbk.a(this.a).dismiss();
    }
    avbk.a(this.a).a(avbk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbl
 * JD-Core Version:    0.7.0.1
 */