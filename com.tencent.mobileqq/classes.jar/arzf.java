import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arzf
  implements View.OnClickListener
{
  arzf(arze paramarze, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof arvu))
    {
      localObject = (FileInfo)((arvu)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365376) {
        break label158;
      }
      bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_Arze.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localbjnw.a(amtj.a(2131708731));
      localbjnw.a(amtj.a(2131708727), 3);
      localbjnw.d(amtj.a(2131708728));
      localbjnw.a(new arzg(this, (FileInfo)localObject, localbjnw));
      localbjnw.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof arzq))
      {
        localObject = (FileInfo)((arzq)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367097)
        {
          localObject = aszt.a((FileInfo)localObject);
          ataw.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Arze.a), this.jdField_a_of_type_Arze.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzf
 * JD-Core Version:    0.7.0.1
 */