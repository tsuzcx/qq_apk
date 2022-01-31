import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

class aosg
  implements View.OnClickListener
{
  aosg(aosf paramaosf, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aopv))
    {
      localObject = (FileInfo)((aopv)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131364979) {
        break label149;
      }
      paramView = (bfol)bfoy.a(this.jdField_a_of_type_Aosf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      paramView.a(ajyc.a(2131709619));
      paramView.a(ajyc.a(2131709615), 3);
      paramView.d(ajyc.a(2131709616));
      paramView.a(new aosh(this, (FileInfo)localObject, paramView));
      paramView.show();
    }
    label149:
    while (paramView.getId() != 2131366634)
    {
      do
      {
        return;
        if ((localObject instanceof aosr))
        {
          localObject = (FileInfo)((aosr)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    paramView = apue.a((FileInfo)localObject);
    apvk.a(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aosf.a), this.jdField_a_of_type_Aosf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosg
 * JD-Core Version:    0.7.0.1
 */