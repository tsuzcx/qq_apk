import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aqul
  extends QIPCModule
{
  private static aqul a;
  
  private aqul(String paramString)
  {
    super(paramString);
  }
  
  public static aqul a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqul("JubaoIPCServer");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JubaoIPCServer", 2, "jubaoIpcServer onCall= " + paramString + ",callbackId = " + paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqul
 * JD-Core Version:    0.7.0.1
 */