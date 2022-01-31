import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

public class aosd
  implements View.OnClickListener
{
  public aosd(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
      return;
    }
    FileInfo localFileInfo = (FileInfo)paramView.getTag();
    if (localFileInfo != null)
    {
      if (this.a.jdField_a_of_type_Aopw != null) {
        this.a.jdField_a_of_type_Aopw.a(null);
      }
      if (!apvb.c(localFileInfo.c())) {
        break label99;
      }
      this.a.a(localFileInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aopw.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.f();
      return;
      label99:
      String str = QfileBaseLocalFileTabView.a(this.a).getString(2131692412);
      aptv.a(apue.d(localFileInfo.d()) + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosd
 * JD-Core Version:    0.7.0.1
 */