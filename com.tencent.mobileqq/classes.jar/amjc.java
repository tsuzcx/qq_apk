import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;

public class amjc
  implements Runnable
{
  public amjc(QZoneShareActivity paramQZoneShareActivity, int paramInt) {}
  
  public void run()
  {
    if (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) == null) {
      QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, new QQProgressDialog(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.getResources().getDimensionPixelSize(2131558448)));
    }
    QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).c(this.jdField_a_of_type_Int);
    try
    {
      QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */