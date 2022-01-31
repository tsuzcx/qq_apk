import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class aqrv
  implements View.OnClickListener
{
  aqrv(aqru paramaqru, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/")) {
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Aqru.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
      }
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId))
    {
      return;
      paramView = new Intent(this.jdField_a_of_type_Aqru.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
      this.jdField_a_of_type_Aqru.a.startActivity(paramView);
      return;
    }
    aqst.a(this.jdField_a_of_type_Aqru.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrv
 * JD-Core Version:    0.7.0.1
 */