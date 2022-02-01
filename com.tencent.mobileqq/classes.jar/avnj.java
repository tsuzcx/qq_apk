import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avnj
  implements View.OnClickListener
{
  public avnj(TextHeaderView paramTextHeaderView, Activity paramActivity, QQGameMsgInfo paramQQGameMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      acik.a(anbd.a(), "769", "205019", this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, "76901", "1", "160", new String[] { this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, "", "20" });
      bnyy.a(3, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    try
    {
      avme.a(118, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnj
 * JD-Core Version:    0.7.0.1
 */