import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;

public class asok
  implements View.OnClickListener
{
  public asok(TextHeaderView paramTextHeaderView, Activity paramActivity, MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramView, 0);
      paramView = asnl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 0);
      aahi.a(akwd.a(), "769", "205019", paramView, "76901", "1", "160", new String[] { asnl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "", "20" });
      ((bdug)akwd.a().getBusinessHandler(71)).a(3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asok
 * JD-Core Version:    0.7.0.1
 */