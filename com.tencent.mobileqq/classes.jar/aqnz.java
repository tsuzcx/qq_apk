import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

class aqnz
  implements View.OnClickListener
{
  aqnz(aqny paramaqny, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof aqnh))
    {
      paramView = (WeiYunFileInfo)((aqnh)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((arbs.a(paramView.a)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.b, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.b(this.jdField_a_of_type_Aqny.a).a().a(paramView);
      this.jdField_a_of_type_Aqny.a.ay_();
    }
    do
    {
      return;
      if ((paramView instanceof aqon))
      {
        paramView = (WeiYunFileInfo)((aqon)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileBaseCloudFileTabView.b, 2, "unknow Object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnz
 * JD-Core Version:    0.7.0.1
 */