import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bdvu
{
  String wifiFlow;
  String xgFlow;
  
  public bdvu() {}
  
  public bdvu(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambdvv.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambdvv.c + ",error code=" + parambdvv.jdField_a_of_type_Int + ",uin=" + parambdvv.jdField_a_of_type_Bdvw.jdField_a_of_type_Long);
      }
      bfdq.a().a(parambdvv.c, 100, parambdvv.jdField_a_of_type_Int, String.valueOf(parambdvv.jdField_a_of_type_Bdvw.jdField_a_of_type_Long), parambdvv.jdField_a_of_type_Bdvw.jdField_a_of_type_Int, alpo.a(2131703872), true);
    }
  }
  
  public void onCancel(bdvv parambdvv) {}
  
  public void onDone(bdvv parambdvv)
  {
    parambdvv.h = System.currentTimeMillis();
    if (parambdvv.a((byte)1)) {
      reportErrorToMM(parambdvv);
    }
  }
  
  public void onDoneFile(bdvv parambdvv) {}
  
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
  
  public void onPause(bdvv parambdvv) {}
  
  public void onProgress(bdvv parambdvv) {}
  
  public boolean onStart(bdvv parambdvv)
  {
    parambdvv.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bdee.a(paramAppInterface.getApplication().getApplicationContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvu
 * JD-Core Version:    0.7.0.1
 */