import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import eipc.EIPCResult;

class bjot
  extends QIPCModule
{
  bjot(bjos parambjos, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("QIPC_SHOW_TOAST_ACTION".equals(paramString)) {
      QQToast.a(BaseApplicationImpl.context, anzj.a(2131710067), 1).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjot
 * JD-Core Version:    0.7.0.1
 */