import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asws
  implements View.OnClickListener
{
  asws(aswr paramaswr, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof asth))
    {
      localObject = (FileInfo)((asth)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365302) {
        break label158;
      }
      bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_Aswr.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localbkho.a(anni.a(2131708390));
      localbkho.a(anni.a(2131708386), 3);
      localbkho.d(anni.a(2131708387));
      localbkho.a(new aswt(this, (FileInfo)localObject, localbkho));
      localbkho.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof asxd))
      {
        localObject = (FileInfo)((asxd)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367030)
        {
          localObject = atvo.a((FileInfo)localObject);
          atwt.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aswr.a), this.jdField_a_of_type_Aswr.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asws
 * JD-Core Version:    0.7.0.1
 */