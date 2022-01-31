import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class askd
  implements View.OnClickListener
{
  public askd(TextHeaderView paramTextHeaderView, Activity paramActivity, QQGameMsgInfo paramQQGameMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      aact.a(akro.a(), "769", "205019", this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, "76901", "1", "160", new String[] { this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, "", "20" });
      bkeu.a(3, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    try
    {
      asjd.a(102, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo, this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askd
 * JD-Core Version:    0.7.0.1
 */