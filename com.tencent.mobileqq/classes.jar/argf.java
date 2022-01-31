import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

final class argf
  implements View.OnClickListener
{
  argf(String paramString, arhw paramarhw) {}
  
  public void onClick(View paramView)
  {
    paramView = (alqo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!arso.b(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (paramView.jdField_a_of_type_Df.a(arrr.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Arhw.getActivity();
        if (!paramView.jdField_a_of_type_Df.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        while (this.jdField_a_of_type_Arhw.b())
        {
          long l = this.jdField_a_of_type_Arhw.a().b();
          arrr.a(this.jdField_a_of_type_Arhw.a(), l);
          return;
          paramView.jdField_a_of_type_Alyw.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argf
 * JD-Core Version:    0.7.0.1
 */