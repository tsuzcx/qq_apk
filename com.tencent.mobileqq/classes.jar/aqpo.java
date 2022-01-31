import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

public class aqpo
  implements View.OnClickListener
{
  public aqpo(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
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
      if (this.a.jdField_a_of_type_Aqni != null) {
        this.a.jdField_a_of_type_Aqni.a(null);
      }
      if (!arso.c(localFileInfo.c())) {
        break label99;
      }
      this.a.a(localFileInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aqni.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.f();
      return;
      label99:
      String str = QfileBaseLocalFileTabView.a(this.a).getString(2131692489);
      arri.a(arrr.d(localFileInfo.d()) + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpo
 * JD-Core Version:    0.7.0.1
 */