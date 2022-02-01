import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atdl
  implements View.OnClickListener
{
  atdl(atdk paramatdk, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ataa))
    {
      localObject = (FileInfo)((ataa)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365469) {
        break label158;
      }
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_Atdk.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localbkzi.a(anvx.a(2131709078));
      localbkzi.a(anvx.a(2131709074), 3);
      localbkzi.d(anvx.a(2131709075));
      localbkzi.a(new atdm(this, (FileInfo)localObject, localbkzi));
      localbkzi.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof atdw))
      {
        localObject = (FileInfo)((atdw)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367216)
        {
          localObject = auea.a((FileInfo)localObject);
          aufd.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Atdk.a), this.jdField_a_of_type_Atdk.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdl
 * JD-Core Version:    0.7.0.1
 */