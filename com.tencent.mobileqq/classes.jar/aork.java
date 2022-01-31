import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

final class aork
  implements View.OnClickListener
{
  aork(String paramString, aotc paramaotc) {}
  
  public void onClick(View paramView)
  {
    paramView = (ajgm)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(8);
    if (!apdh.b(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (paramView.jdField_a_of_type_Dd.a(apck.a(this.jdField_a_of_type_JavaLangString)))
      {
        Activity localActivity = this.jdField_a_of_type_Aotc.getActivity();
        if (!paramView.jdField_a_of_type_Dd.a()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        while (this.jdField_a_of_type_Aotc.b())
        {
          long l = this.jdField_a_of_type_Aotc.a().b();
          apck.a(this.jdField_a_of_type_Aotc.a(), l);
          return;
          paramView.jdField_a_of_type_Ajoj.a((BaseActivity)localActivity, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aork
 * JD-Core Version:    0.7.0.1
 */