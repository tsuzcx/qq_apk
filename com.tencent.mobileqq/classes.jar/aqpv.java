import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class aqpv
  implements View.OnClickListener
{
  public aqpv(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (aqqc)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)paramView.jdField_a_of_type_JavaLangObject;
    switch (paramView.c)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ab();
      this.a.a(localFileInfo, paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpv
 * JD-Core Version:    0.7.0.1
 */