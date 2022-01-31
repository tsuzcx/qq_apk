import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

final class apiz
  implements View.OnClickListener
{
  apiz(String paramString, apkq paramapkq) {}
  
  public void onClick(View paramView)
  {
    paramView = (ajum)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!apvd.b(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (paramView.jdField_a_of_type_Ew.a(apug.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Apkq.getActivity();
        if (!paramView.jdField_a_of_type_Ew.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        while (this.jdField_a_of_type_Apkq.b())
        {
          long l = this.jdField_a_of_type_Apkq.a().b();
          apug.a(this.jdField_a_of_type_Apkq.a(), l);
          return;
          paramView.jdField_a_of_type_Akcs.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiz
 * JD-Core Version:    0.7.0.1
 */