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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class avbt
  implements AdapterView.OnItemClickListener
{
  avbt(avbs paramavbs) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FeedsItemData.LabelInfo localLabelInfo = (FeedsItemData.LabelInfo)this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$TopCardInfo.labelInfos.get(paramInt);
    Object localObject = new HashMap();
    abuf.a((Map)localObject, localLabelInfo.msgId);
    ((Map)localObject).put(Integer.valueOf(6), localLabelInfo.reportId);
    ((Map)localObject).put(Integer.valueOf(2), localLabelInfo.msgId);
    if (aver.a(localLabelInfo.redInfo))
    {
      ((Map)localObject).put(Integer.valueOf(3), "1");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      abuf.a(amwn.a(), "769", "205614", localLabelInfo.appId, "76903", "1", "160", (Map)localObject);
      aver.a(localLabelInfo.redInfo.redPointId);
      ((avbo)paramView.getTag()).a.setVisibility(8);
      if (!localLabelInfo.isFriend) {
        break label301;
      }
      new LinearLayout.LayoutParams(-1, -2).gravity = 80;
      new avfn(this.a.itemView.getContext(), this.a.jdField_a_of_type_Avbb.a().gameAppId, localLabelInfo.friendType).show();
      abuf.a(amwn.a(), "769", "205355", this.a.jdField_a_of_type_Avbb.a().gameAppId, "76902", "1", "160", new String[] { "", "", "20" });
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      ((Map)localObject).put(Integer.valueOf(3), "0");
      break;
      label301:
      if (!TextUtils.isEmpty(localLabelInfo.jumpUrl)) {
        if (localLabelInfo.jumpUrl.startsWith("mqqapi://miniapp/"))
        {
          MiniAppLauncher.startMiniApp(this.a.jdField_a_of_type_AndroidContentContext, localLabelInfo.jumpUrl, 2016, null);
        }
        else
        {
          localObject = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localLabelInfo.jumpUrl);
          this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbt
 * JD-Core Version:    0.7.0.1
 */