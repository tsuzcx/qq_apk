import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aspp
  implements View.OnClickListener
{
  aspp(String paramString, asqp paramasqp) {}
  
  public void onClick(View paramView)
  {
    amqd localamqd = (amqd)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8);
    if (!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString)) {}
    label152:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localamqd.jdField_a_of_type_Dk.a(aszt.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Asqp.getActivity();
        if (!localamqd.jdField_a_of_type_Dk.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Asqp.c()) {
            break label152;
          }
          long l = this.jdField_a_of_type_Asqp.a().b();
          aszt.a(this.jdField_a_of_type_Asqp.a(), l);
          break;
          localamqd.jdField_a_of_type_Amxk.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspp
 * JD-Core Version:    0.7.0.1
 */