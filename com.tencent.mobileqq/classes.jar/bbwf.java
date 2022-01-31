import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bbwf
{
  String wifiFlow;
  String xgFlow;
  
  public bbwf() {}
  
  public bbwf(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambbwg.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambbwg.c + ",error code=" + parambbwg.jdField_a_of_type_Int + ",uin=" + parambbwg.jdField_a_of_type_Bbwh.jdField_a_of_type_Long);
      }
      bded.a().a(parambbwg.c, 100, parambbwg.jdField_a_of_type_Int, String.valueOf(parambbwg.jdField_a_of_type_Bbwh.jdField_a_of_type_Long), parambbwg.jdField_a_of_type_Bbwh.jdField_a_of_type_Int, ajyc.a(2131703489), true);
    }
  }
  
  public void onCancel(bbwg parambbwg) {}
  
  public void onDone(bbwg parambbwg)
  {
    parambbwg.h = System.currentTimeMillis();
    if (parambbwg.a((byte)1)) {
      reportErrorToMM(parambbwg);
    }
  }
  
  public void onDoneFile(bbwg parambbwg) {}
  
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
  
  public void onPause(bbwg parambbwg) {}
  
  public void onProgress(bbwg parambbwg) {}
  
  public boolean onStart(bbwg parambbwg)
  {
    parambbwg.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = bbev.a(paramAppInterface.getApplication().getApplicationContext());
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
 * Qualified Name:     bbwf
 * JD-Core Version:    0.7.0.1
 */