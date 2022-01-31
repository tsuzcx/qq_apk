import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

class bbyt
  extends QIPCModule
{
  bbyt(bbys parambbys, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("QIPC_SHOW_TOAST_ACTION".equals(paramString)) {
      bbmy.a(BaseApplicationImpl.context, ajjy.a(2131645397), 1).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyt
 * JD-Core Version:    0.7.0.1
 */