import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class attw
  implements View.OnClickListener
{
  attw(String paramString, atuw paramatuw) {}
  
  public void onClick(View paramView)
  {
    ansr localansr = (ansr)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString)) {}
    label153:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localansr.jdField_a_of_type_Dk.a(auea.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Atuw.getActivity();
        if (!localansr.jdField_a_of_type_Dk.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Atuw.c()) {
            break label153;
          }
          long l = this.jdField_a_of_type_Atuw.a().b();
          auea.a(this.jdField_a_of_type_Atuw.a(), l);
          break;
          localansr.jdField_a_of_type_Anzy.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attw
 * JD-Core Version:    0.7.0.1
 */