import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class aqrx
  implements View.OnClickListener
{
  aqrx(aqrw paramaqrw, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/")) {
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Aqrw.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
      }
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId))
    {
      return;
      paramView = new Intent(this.jdField_a_of_type_Aqrw.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
      this.jdField_a_of_type_Aqrw.a.startActivity(paramView);
      return;
    }
    aqsv.a(this.jdField_a_of_type_Aqrw.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrx
 * JD-Core Version:    0.7.0.1
 */