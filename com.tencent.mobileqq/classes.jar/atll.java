import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atll
  implements View.OnClickListener
{
  atll(String paramString, atmk paramatmk) {}
  
  public void onClick(View paramView)
  {
    anjx localanjx = (anjx)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!atwl.b(this.jdField_a_of_type_JavaLangString)) {}
    label152:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localanjx.jdField_a_of_type_Dk.a(atvo.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Atmk.getActivity();
        if (!localanjx.jdField_a_of_type_Dk.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Atmk.c()) {
            break label152;
          }
          long l = this.jdField_a_of_type_Atmk.a().b();
          atvo.a(this.jdField_a_of_type_Atmk.a(), l);
          break;
          localanjx.jdField_a_of_type_Anrd.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atll
 * JD-Core Version:    0.7.0.1
 */