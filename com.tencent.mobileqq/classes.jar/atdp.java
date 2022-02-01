import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atdp
  implements View.OnClickListener
{
  public atdp(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    atdw localatdw = (atdw)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)localatdw.jdField_a_of_type_JavaLangObject;
    switch (localatdw.c)
    {
    }
    for (;;)
    {
      this.a.i();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a().Z();
      this.a.a(localFileInfo, localatdw.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdp
 * JD-Core Version:    0.7.0.1
 */