import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avbu
  implements View.OnClickListener
{
  avbu(avbs paramavbs, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_Avbs.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
    }
    for (;;)
    {
      abuf.a(amwn.a(), "769", "205647", this.jdField_a_of_type_Avbs.jdField_a_of_type_Avbb.a().gameAppId, "76903", "1", "160", new String[] { "", "", "20" });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_Avbs.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Avbs.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbu
 * JD-Core Version:    0.7.0.1
 */