import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

final class arbw
  implements View.OnClickListener
{
  arbw(String paramString, ardn paramardn) {}
  
  public void onClick(View paramView)
  {
    paramView = (allz)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!arof.b(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (paramView.jdField_a_of_type_Df.a(arni.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Ardn.getActivity();
        if (!paramView.jdField_a_of_type_Df.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        while (this.jdField_a_of_type_Ardn.b())
        {
          long l = this.jdField_a_of_type_Ardn.a().b();
          arni.a(this.jdField_a_of_type_Ardn.a(), l);
          return;
          paramView.jdField_a_of_type_Aluh.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbw
 * JD-Core Version:    0.7.0.1
 */