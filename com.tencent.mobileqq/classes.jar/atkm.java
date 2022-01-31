import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class atkm
  extends QIPCModule
{
  private static atkm a;
  
  private atkm(String paramString)
  {
    super(paramString);
  }
  
  public static atkm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new atkm("JubaoIPCServer");
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
 * Qualified Name:     atkm
 * JD-Core Version:    0.7.0.1
 */