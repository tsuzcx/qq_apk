import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class aqqs
  implements AdapterView.OnItemClickListener
{
  aqqs(aqqr paramaqqr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FeedsItemData.LabelInfo)this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.get(paramInt);
    HashMap localHashMap = new HashMap();
    yod.a(localHashMap, paramAdapterView.msgId);
    localHashMap.put(Integer.valueOf(6), paramAdapterView.reportId);
    localHashMap.put(Integer.valueOf(2), paramAdapterView.msgId);
    if (aqst.a(paramAdapterView.redInfo))
    {
      localHashMap.put(Integer.valueOf(3), "1");
      localHashMap.put(Integer.valueOf(4), "20");
      yod.a(ajae.a(), "769", "205614", paramAdapterView.appId, "76903", "1", "160", localHashMap);
      aqst.a(paramAdapterView.redInfo.redPointId);
      ((aqqn)paramView.getTag()).a.setVisibility(8);
      if (!paramAdapterView.isFriend) {
        break label281;
      }
      new LinearLayout.LayoutParams(-1, -2).gravity = 80;
      new aqtc(this.a.itemView.getContext(), this.a.jdField_a_of_type_Aqqa.a().gameAppId, paramAdapterView.friendType).show();
      yod.a(ajae.a(), "769", "205355", this.a.jdField_a_of_type_Aqqa.a().gameAppId, "76902", "1", "160", new String[] { "", "", "20" });
    }
    label281:
    while (TextUtils.isEmpty(paramAdapterView.jumpUrl))
    {
      return;
      localHashMap.put(Integer.valueOf(3), "0");
      break;
    }
    if (paramAdapterView.jumpUrl.startsWith("mqqapi://miniapp/"))
    {
      MiniAppLauncher.startMiniApp(this.a.jdField_a_of_type_AndroidContentContext, paramAdapterView.jumpUrl, 2016, null);
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", paramAdapterView.jumpUrl);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqs
 * JD-Core Version:    0.7.0.1
 */