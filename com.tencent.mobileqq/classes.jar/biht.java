import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class biht
{
  String wifiFlow;
  String xgFlow;
  
  public biht() {}
  
  public biht(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambihu.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambihu.c + ",error code=" + parambihu.jdField_a_of_type_Int + ",uin=" + parambihu.jdField_a_of_type_Bihv.jdField_a_of_type_Long);
      }
      bjqh.a().a(parambihu.c, 100, parambihu.jdField_a_of_type_Int, String.valueOf(parambihu.jdField_a_of_type_Bihv.jdField_a_of_type_Long), parambihu.jdField_a_of_type_Bihv.jdField_a_of_type_Int, anzj.a(2131702388), true);
    }
  }
  
  public void onCancel(bihu parambihu) {}
  
  public void onDone(bihu parambihu)
  {
    parambihu.h = System.currentTimeMillis();
    if (parambihu.a((byte)1)) {
      reportErrorToMM(parambihu);
    }
  }
  
  public void onDoneFile(bihu parambihu) {}
  
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
  
  public void onPause(bihu parambihu) {}
  
  public void onProgress(bihu parambihu) {}
  
  public boolean onStart(bihu parambihu)
  {
    parambihu.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bhnv.a(paramAppInterface.getApplication().getApplicationContext());
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
 * Qualified Name:     biht
 * JD-Core Version:    0.7.0.1
 */