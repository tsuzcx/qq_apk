import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import eipc.EIPCResult;

class bjfj
  extends QIPCModule
{
  bjfj(bjfi parambjfi, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("QIPC_SHOW_TOAST_ACTION".equals(paramString)) {
      QQToast.a(BaseApplicationImpl.context, anvx.a(2131710646), 1).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfj
 * JD-Core Version:    0.7.0.1
 */