import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;

class aobm
  implements View.OnClickListener
{
  aobm(aobl paramaobl, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof anzc))
    {
      localObject = (FileInfo)((anzc)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131299411) {
        break label149;
      }
      paramView = (begr)behe.a(this.jdField_a_of_type_Aobl.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      paramView.a(ajjy.a(2131643834));
      paramView.a(ajjy.a(2131643830), 3);
      paramView.d(ajjy.a(2131643831));
      paramView.a(new aobn(this, (FileInfo)localObject, paramView));
      paramView.show();
    }
    label149:
    while (paramView.getId() != 2131301023)
    {
      do
      {
        return;
        if ((localObject instanceof aobx))
        {
          localObject = (FileInfo)((aobx)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    paramView = apck.a((FileInfo)localObject);
    apdq.a(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Aobl.a), this.jdField_a_of_type_Aobl.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobm
 * JD-Core Version:    0.7.0.1
 */