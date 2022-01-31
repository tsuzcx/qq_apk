import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bead
{
  String wifiFlow;
  String xgFlow;
  
  public bead() {}
  
  public bead(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambeae.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambeae.c + ",error code=" + parambeae.jdField_a_of_type_Int + ",uin=" + parambeae.jdField_a_of_type_Beaf.jdField_a_of_type_Long);
      }
      bfhz.a().a(parambeae.c, 100, parambeae.jdField_a_of_type_Int, String.valueOf(parambeae.jdField_a_of_type_Beaf.jdField_a_of_type_Long), parambeae.jdField_a_of_type_Beaf.jdField_a_of_type_Int, alud.a(2131703884), true);
    }
  }
  
  public void onCancel(beae parambeae) {}
  
  public void onDone(beae parambeae)
  {
    parambeae.h = System.currentTimeMillis();
    if (parambeae.a((byte)1)) {
      reportErrorToMM(parambeae);
    }
  }
  
  public void onDoneFile(beae parambeae) {}
  
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
  
  public void onPause(beae parambeae) {}
  
  public void onProgress(beae parambeae) {}
  
  public boolean onStart(beae parambeae)
  {
    parambeae.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bdin.a(paramAppInterface.getApplication().getApplicationContext());
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
 * Qualified Name:     bead
 * JD-Core Version:    0.7.0.1
 */