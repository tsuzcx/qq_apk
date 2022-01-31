import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

class aosk
  implements View.OnClickListener
{
  aosk(aosj paramaosj, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aoqa))
    {
      localObject = (FileInfo)((aoqa)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131364978) {
        break label149;
      }
      paramView = (bfpc)bfpp.a(this.jdField_a_of_type_Aosj.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      paramView.a(ajya.a(2131709630));
      paramView.a(ajya.a(2131709626), 3);
      paramView.d(ajya.a(2131709627));
      paramView.a(new aosl(this, (FileInfo)localObject, paramView));
      paramView.show();
    }
    label149:
    while (paramView.getId() != 2131366634)
    {
      do
      {
        return;
        if ((localObject instanceof aosv))
        {
          localObject = (FileInfo)((aosv)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    paramView = apug.a((FileInfo)localObject);
    apvm.a(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aosj.a), this.jdField_a_of_type_Aosj.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */