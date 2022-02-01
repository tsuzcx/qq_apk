import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bgod
{
  String wifiFlow;
  String xgFlow;
  
  public bgod() {}
  
  public bgod(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambgoe.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambgoe.c + ",error code=" + parambgoe.jdField_a_of_type_Int + ",uin=" + parambgoe.jdField_a_of_type_Bgof.jdField_a_of_type_Long);
      }
      bhvw.a().a(parambgoe.c, 100, parambgoe.jdField_a_of_type_Int, String.valueOf(parambgoe.jdField_a_of_type_Bgof.jdField_a_of_type_Long), parambgoe.jdField_a_of_type_Bgof.jdField_a_of_type_Int, amtj.a(2131702623), true);
    }
  }
  
  public void onCancel(bgoe parambgoe) {}
  
  public void onDone(bgoe parambgoe)
  {
    parambgoe.h = System.currentTimeMillis();
    if (parambgoe.a((byte)1)) {
      reportErrorToMM(parambgoe);
    }
  }
  
  public void onDoneFile(bgoe parambgoe) {}
  
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
  
  public void onPause(bgoe parambgoe) {}
  
  public void onProgress(bgoe parambgoe) {}
  
  public boolean onStart(bgoe parambgoe)
  {
    parambgoe.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = NetworkUtil.getSystemNetwork(paramAppInterface.getApplication().getApplicationContext());
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
 * Qualified Name:     bgod
 * JD-Core Version:    0.7.0.1
 */