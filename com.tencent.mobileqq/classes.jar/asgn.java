import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class asgn
  implements View.OnClickListener
{
  asgn(asgl paramasgl, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Asgl.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
    }
    for (;;)
    {
      aact.a(akro.a(), "769", "205647", this.jdField_a_of_type_Asgl.jdField_a_of_type_Asfu.a().gameAppId, "76903", "1", "160", new String[] { "", "", "20" });
      return;
      paramView = new Intent(this.jdField_a_of_type_Asgl.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Asgl.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgn
 * JD-Core Version:    0.7.0.1
 */