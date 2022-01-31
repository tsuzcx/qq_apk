import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class aqqx
  implements View.OnClickListener
{
  aqqx(aqqw paramaqqw) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {}
    do
    {
      return;
      aqsr.a(aqqw.a(this.a), aqqw.b(this.a), "205928", aqqw.a(this.a));
    } while (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.jumpUrl));
    if (this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.jumpUrl.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.jumpUrl, 2016, null);
    }
    for (;;)
    {
      this.a.c();
      return;
      paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.a.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.jumpUrl);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */