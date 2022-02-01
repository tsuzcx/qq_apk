import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bhhe
{
  String wifiFlow;
  String xgFlow;
  
  public bhhe() {}
  
  public bhhe(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambhhf.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambhhf.c + ",error code=" + parambhhf.jdField_a_of_type_Int + ",uin=" + parambhhf.jdField_a_of_type_Bhhg.jdField_a_of_type_Long);
      }
      bipi.a().a(parambhhf.c, 100, parambhhf.jdField_a_of_type_Int, String.valueOf(parambhhf.jdField_a_of_type_Bhhg.jdField_a_of_type_Long), parambhhf.jdField_a_of_type_Bhhg.jdField_a_of_type_Int, anni.a(2131702281), true);
    }
  }
  
  public void onCancel(bhhf parambhhf) {}
  
  public void onDone(bhhf parambhhf)
  {
    parambhhf.h = System.currentTimeMillis();
    if (parambhhf.a((byte)1)) {
      reportErrorToMM(parambhhf);
    }
  }
  
  public void onDoneFile(bhhf parambhhf) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetMobile2None...");
    }
  }
  
  public void onNetWifi2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2Mobile...");
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2None...");
    }
  }
  
  public void onPause(bhhf parambhhf) {}
  
  public void onProgress(bhhf parambhhf) {}
  
  public boolean onStart(bhhf parambhhf)
  {
    parambhhf.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bgnt.a(paramAppInterface.getApplication().getApplicationContext());
      if (i > 0)
      {
        if (i != 1) {
          break label134;
        }
        arrayOfString = new String[3];
        arrayOfString[0] = this.wifiFlow;
        arrayOfString[1] = "param_WIFIFlow";
        arrayOfString[2] = "param_Flow";
      }
    }
    for (;;)
    {
      if ((arrayOfString != null) && (paramLong > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, "report | tags=" + arrayOfString + ",len=" + paramLong);
        }
        paramAppInterface.sendAppDataIncerment(paramAppInterface.getCurrentAccountUin(), arrayOfString, paramLong);
      }
      return;
      label134:
      arrayOfString = new String[3];
      arrayOfString[0] = this.xgFlow;
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhe
 * JD-Core Version:    0.7.0.1
 */