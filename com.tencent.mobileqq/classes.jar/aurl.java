import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aurl
  extends QIPCModule
{
  private static volatile aurl a;
  
  public aurl(String paramString)
  {
    super(paramString);
  }
  
  public static aurl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aurl("TogetherBusinessIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessIPCModule", 2, "call TogetherBusinessIPCModule action=" + paramString);
    }
    if ("action_open_identify".equals(paramString)) {
      TogetherBusinessServlet.a("QQAIOMediaSvc.open_identify", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aurm(this, paramInt));
    }
    do
    {
      boolean bool2;
      do
      {
        do
        {
          return null;
          if ("action_open_start".equals(paramString))
          {
            TogetherBusinessServlet.a("QQAIOMediaSvc.open_start", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aurm(this, paramInt));
            return null;
          }
        } while (!"action_set_floating".equals(paramString));
        boolean bool1 = paramBundle.getBoolean("BUNDLE_SET_STATUS");
        paramString = paramBundle.getString("BUNDLE_SET_KEY_UIN", "");
        paramInt = paramBundle.getInt("BUNDLE_SET_KEY_SESSION_TYPE", -1);
        bool2 = paramBundle.getBoolean("BUNDLE_SET_KEY_REFRESH_UI", true);
        aurn.a(bool1, paramString, paramInt, bool2);
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessIPCModule", 2, "ACTION_SET_FLOATING " + " isShow=" + bool1 + " uin=" + paramString + " sessionType=" + paramInt + " refresh=" + bool2);
        }
      } while (!bool2);
      paramBundle = (bdct)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(339);
      paramString = (WatchTogetherSession)paramBundle.a(2, paramInt, paramString);
    } while (paramString == null);
    paramBundle.a(true, paramString, 1002, "");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurl
 * JD-Core Version:    0.7.0.1
 */