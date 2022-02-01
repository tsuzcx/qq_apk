import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atmw
  implements View.OnClickListener
{
  atmw(atmv paramatmv, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof atjl))
    {
      localObject = (FileInfo)((atjl)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365346) {
        break label158;
      }
      blir localblir = (blir)blji.a(this.jdField_a_of_type_Atmv.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localblir.a(anzj.a(2131708499));
      localblir.a(anzj.a(2131708495), 3);
      localblir.d(anzj.a(2131708496));
      localblir.a(new atmx(this, (FileInfo)localObject, localblir));
      localblir.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof atnh))
      {
        localObject = (FileInfo)((atnh)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367081)
        {
          localObject = aunj.a((FileInfo)localObject);
          auoo.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Atmv.a), this.jdField_a_of_type_Atmv.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmw
 * JD-Core Version:    0.7.0.1
 */