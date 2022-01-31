import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

class bddi
  extends QIPCModule
{
  bddi(bddh parambddh, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("QIPC_SHOW_TOAST_ACTION".equals(paramString)) {
      bcql.a(BaseApplicationImpl.context, ajya.a(2131711196), 1).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddi
 * JD-Core Version:    0.7.0.1
 */