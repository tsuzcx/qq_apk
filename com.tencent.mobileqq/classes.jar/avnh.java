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
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avnh
  implements View.OnClickListener
{
  public avnh(TextHeaderView paramTextHeaderView, Activity paramActivity, MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 0);
      localObject = avmd.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 0);
      acik.a(anbd.a(), "769", "205019", (String)localObject, "76901", "1", "160", new String[] { avmd.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "", "20" });
      ((VasExtensionHandler)anbd.a().getBusinessHandler(71)).a(3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnh
 * JD-Core Version:    0.7.0.1
 */