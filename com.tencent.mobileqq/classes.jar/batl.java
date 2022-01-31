import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class batl
{
  String wifiFlow;
  String xgFlow;
  
  public batl() {}
  
  public batl(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambatm.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambatm.c + ",error code=" + parambatm.jdField_a_of_type_Int + ",uin=" + parambatm.jdField_a_of_type_Batn.jdField_a_of_type_Long);
      }
      bcad.a().a(parambatm.c, 100, parambatm.jdField_a_of_type_Int, String.valueOf(parambatm.jdField_a_of_type_Batn.jdField_a_of_type_Long), parambatm.jdField_a_of_type_Batn.jdField_a_of_type_Int, ajjy.a(2131637704), true);
    }
  }
  
  public void onCancel(batm parambatm) {}
  
  public void onDone(batm parambatm)
  {
    parambatm.h = System.currentTimeMillis();
    if (parambatm.a((byte)1)) {
      reportErrorToMM(parambatm);
    }
  }
  
  public void onDoneFile(batm parambatm) {}
  
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
  
  public void onPause(batm parambatm) {}
  
  public void onProgress(batm parambatm) {}
  
  public boolean onStart(batm parambatm)
  {
    parambatm.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = badq.a(paramAppInterface.getApplication().getApplicationContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batl
 * JD-Core Version:    0.7.0.1
 */