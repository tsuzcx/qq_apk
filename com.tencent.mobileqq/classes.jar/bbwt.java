import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bbwt
{
  String wifiFlow;
  String xgFlow;
  
  public bbwt() {}
  
  public bbwt(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambbwu.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambbwu.c + ",error code=" + parambbwu.jdField_a_of_type_Int + ",uin=" + parambbwu.jdField_a_of_type_Bbwv.jdField_a_of_type_Long);
      }
      bdes.a().a(parambbwu.c, 100, parambbwu.jdField_a_of_type_Int, String.valueOf(parambbwu.jdField_a_of_type_Bbwv.jdField_a_of_type_Long), parambbwu.jdField_a_of_type_Bbwv.jdField_a_of_type_Int, ajya.a(2131703500), true);
    }
  }
  
  public void onCancel(bbwu parambbwu) {}
  
  public void onDone(bbwu parambbwu)
  {
    parambbwu.h = System.currentTimeMillis();
    if (parambbwu.a((byte)1)) {
      reportErrorToMM(parambbwu);
    }
  }
  
  public void onDoneFile(bbwu parambbwu) {}
  
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
  
  public void onPause(bbwu parambbwu) {}
  
  public void onProgress(bbwu parambbwu) {}
  
  public boolean onStart(bbwu parambbwu)
  {
    parambbwu.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bbfj.a(paramAppInterface.getApplication().getApplicationContext());
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
 * Qualified Name:     bbwt
 * JD-Core Version:    0.7.0.1
 */