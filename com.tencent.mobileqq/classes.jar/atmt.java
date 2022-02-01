import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atmt
  implements View.OnClickListener
{
  public atmt(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    FileInfo localFileInfo = (FileInfo)paramView.getTag();
    if (localFileInfo != null)
    {
      if (this.a.jdField_a_of_type_Atjm != null) {
        this.a.jdField_a_of_type_Atjm.a(null);
      }
      if (!auog.c(localFileInfo.c())) {
        break label108;
      }
      this.a.a(localFileInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Atjm.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.f();
      break;
      label108:
      String str = QfileBaseLocalFileTabView.a(this.a).getString(2131692078);
      auna.a(aunj.d(localFileInfo.d()) + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmt
 * JD-Core Version:    0.7.0.1
 */