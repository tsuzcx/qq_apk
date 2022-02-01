import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avcj
  implements View.OnClickListener
{
  avcj(avci paramavci, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Avci.itemView.getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_Avci.itemView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
      this.jdField_a_of_type_Avci.itemView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcj
 * JD-Core Version:    0.7.0.1
 */