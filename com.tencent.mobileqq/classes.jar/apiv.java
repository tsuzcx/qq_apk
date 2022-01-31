import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

final class apiv
  implements View.OnClickListener
{
  apiv(String paramString, apkm paramapkm) {}
  
  public void onClick(View paramView)
  {
    paramView = (ajuo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!apvb.b(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (paramView.jdField_a_of_type_Ew.a(apue.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Apkm.getActivity();
        if (!paramView.jdField_a_of_type_Ew.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        while (this.jdField_a_of_type_Apkm.b())
        {
          long l = this.jdField_a_of_type_Apkm.a().b();
          apue.a(this.jdField_a_of_type_Apkm.a(), l);
          return;
          paramView.jdField_a_of_type_Akct.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiv
 * JD-Core Version:    0.7.0.1
 */