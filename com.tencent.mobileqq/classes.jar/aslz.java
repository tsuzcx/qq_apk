import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class aslz
  implements View.OnClickListener
{
  aslz(asly paramasly, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/")) {
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Asly.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
      }
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId))
    {
      return;
      paramView = new Intent(this.jdField_a_of_type_Asly.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
      this.jdField_a_of_type_Asly.a.startActivity(paramView);
      return;
    }
    asnl.a(this.jdField_a_of_type_Asly.a, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.groupId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslz
 * JD-Core Version:    0.7.0.1
 */