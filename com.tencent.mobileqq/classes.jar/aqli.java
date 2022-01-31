import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

class aqli
  implements View.OnClickListener
{
  aqli(aqlh paramaqlh, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aqiy))
    {
      localObject = (FileInfo)((aqiy)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365063) {
        break label149;
      }
      paramView = (bhpy)bhql.a(this.jdField_a_of_type_Aqlh.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      paramView.a(alpo.a(2131710002));
      paramView.a(alpo.a(2131709998), 3);
      paramView.d(alpo.a(2131709999));
      paramView.a(new aqlj(this, (FileInfo)localObject, paramView));
      paramView.show();
    }
    label149:
    while (paramView.getId() != 2131366752)
    {
      do
      {
        return;
        if ((localObject instanceof aqlt))
        {
          localObject = (FileInfo)((aqlt)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    paramView = arni.a((FileInfo)localObject);
    aroo.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aqlh.a), this.jdField_a_of_type_Aqlh.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqli
 * JD-Core Version:    0.7.0.1
 */