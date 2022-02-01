import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aodq
  extends QIPCModule
{
  private static aodq a;
  
  private aodq()
  {
    super("SignInModule");
  }
  
  public static aodq a()
  {
    if (a == null) {
      a = new aodq();
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = paramBundle.getInt("type", 1);
    int i = paramBundle.getInt("result", 2);
    int j = paramBundle.getInt("day", 1);
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "SignInModule onCall type = " + paramInt + ",result = " + i + ",day = " + j);
    }
    if (i == 0)
    {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramString != null)
      {
        paramString.getPreferences();
        paramString = (anri)paramString.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "get oidb0x922 by web");
        }
        paramString.c(0);
        paramString.l();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodq
 * JD-Core Version:    0.7.0.1
 */