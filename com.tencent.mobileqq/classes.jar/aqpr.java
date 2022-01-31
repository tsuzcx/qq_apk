import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

class aqpr
  implements View.OnClickListener
{
  aqpr(aqpq paramaqpq, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof aqnh))
    {
      localObject = (FileInfo)((aqnh)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365065) {
        break label149;
      }
      paramView = (bhuf)bhus.a(this.jdField_a_of_type_Aqpq.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      paramView.a(alud.a(2131710014));
      paramView.a(alud.a(2131710010), 3);
      paramView.d(alud.a(2131710011));
      paramView.a(new aqps(this, (FileInfo)localObject, paramView));
      paramView.show();
    }
    label149:
    while (paramView.getId() != 2131366762)
    {
      do
      {
        return;
        if ((localObject instanceof aqqc))
        {
          localObject = (FileInfo)((aqqc)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    paramView = arrr.a((FileInfo)localObject);
    arsx.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aqpq.a), this.jdField_a_of_type_Aqpq.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */