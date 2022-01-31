import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class atgd
  extends QIPCModule
{
  private static atgd a;
  
  private atgd(String paramString)
  {
    super(paramString);
  }
  
  public static atgd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new atgd("JubaoIPCServer");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgd
 * JD-Core Version:    0.7.0.1
 */