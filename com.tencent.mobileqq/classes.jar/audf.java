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

final class audf
  implements View.OnClickListener
{
  audf(String paramString, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    anvu localanvu = (anvu)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!auog.b(this.jdField_a_of_type_JavaLangString)) {}
    label152:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localanvu.jdField_a_of_type_Dk.a(aunj.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Auef.getActivity();
        if (!localanvu.jdField_a_of_type_Dk.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Auef.c()) {
            break label152;
          }
          long l = this.jdField_a_of_type_Auef.a().b();
          aunj.a(this.jdField_a_of_type_Auef.a(), l);
          break;
          localanvu.jdField_a_of_type_Aodj.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audf
 * JD-Core Version:    0.7.0.1
 */