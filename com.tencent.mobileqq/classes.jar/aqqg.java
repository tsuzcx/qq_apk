import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aqqg
  extends QIPCModule
{
  private static volatile aqqg a;
  
  public aqqg(String paramString)
  {
    super(paramString);
  }
  
  public static aqqg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqqg("TogetherBusinessIPCModule");
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
      TogetherBusinessServlet.a("QQAIOMediaSvc.open_identify", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aqqh(this, paramInt));
    }
    for (;;)
    {
      return null;
      if ("action_open_start".equals(paramString)) {
        TogetherBusinessServlet.a("QQAIOMediaSvc.open_start", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new aqqh(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqg
 * JD-Core Version:    0.7.0.1
 */