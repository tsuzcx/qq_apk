import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class bhyn
{
  String wifiFlow;
  String xgFlow;
  
  public bhyn() {}
  
  public bhyn(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (parambhyo.a() != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + parambhyo.c + ",error code=" + parambhyo.jdField_a_of_type_Int + ",uin=" + parambhyo.jdField_a_of_type_Bhyp.jdField_a_of_type_Long);
      }
      bjgx.a().a(parambhyo.c, 100, parambhyo.jdField_a_of_type_Int, String.valueOf(parambhyo.jdField_a_of_type_Bhyp.jdField_a_of_type_Long), parambhyo.jdField_a_of_type_Bhyp.jdField_a_of_type_Int, anvx.a(2131702974), true);
    }
  }
  
  public void onCancel(bhyo parambhyo) {}
  
  public void onDone(bhyo parambhyo)
  {
    parambhyo.h = System.currentTimeMillis();
    if (parambhyo.a((byte)1)) {
      reportErrorToMM(parambhyo);
    }
  }
  
  public void onDoneFile(bhyo parambhyo) {}
  
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
  
  public void onPause(bhyo parambhyo) {}
  
  public void onProgress(bhyo parambhyo) {}
  
  public boolean onStart(bhyo parambhyo)
  {
    parambhyo.g = System.currentTimeMillis();
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
 * Qualified Name:     bhyn
 * JD-Core Version:    0.7.0.1
 */