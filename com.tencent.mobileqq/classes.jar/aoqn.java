import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

class aoqn
  implements View.OnClickListener
{
  aoqn(aoqm paramaoqm, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof aopv))
    {
      paramView = (WeiYunFileInfo)((aopv)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((apeh.a(paramView.a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.b, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.b(this.jdField_a_of_type_Aoqm.a).a().a(paramView);
      this.jdField_a_of_type_Aoqm.a.au_();
    }
    do
    {
      return;
      if ((paramView instanceof aorb))
      {
        paramView = (WeiYunFileInfo)((aorb)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileBaseCloudFileTabView.b, 2, "unknow Object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqn
 * JD-Core Version:    0.7.0.1
 */