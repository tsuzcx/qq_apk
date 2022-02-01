import android.app.Activity;
import com.tencent.biz.qrcode.activity.QMiniResult;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView.16.1;
import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;

public class apql
  implements zmi
{
  public apql(QRScanEntryView paramQRScanEntryView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiCancel");
    }
    if ((this.a.jdField_a_of_type_Apog != null) && ((this.a.jdField_a_of_type_Apog instanceof apot)) && (this.a.m)) {
      this.a.postDelayed(new QRScanEntryView.16.1(this), 500L);
    }
  }
  
  public void a(QMiniResult paramQMiniResult, int paramInt, zmh paramzmh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectMini result:" + paramQMiniResult + " " + paramInt);
    }
    QRScanEntryView localQRScanEntryView = this.a;
    String str = paramQMiniResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramzmh != null) {}
    for (paramQMiniResult = paramzmh.a;; paramQMiniResult = null)
    {
      QRScanEntryView.a(localQRScanEntryView, str, localActivity, paramQMiniResult);
      return;
    }
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, zmh paramzmh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectQr result:" + paramQBarResult + " " + paramInt);
    }
    QRScanEntryView localQRScanEntryView = this.a;
    String str1 = paramQBarResult.b;
    String str2 = paramQBarResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramzmh != null) {}
    for (paramQBarResult = paramzmh.a;; paramQBarResult = null)
    {
      QRScanEntryView.a(localQRScanEntryView, str1, str2, localActivity, paramQBarResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apql
 * JD-Core Version:    0.7.0.1
 */