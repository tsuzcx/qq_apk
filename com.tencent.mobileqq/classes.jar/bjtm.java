import android.os.Looper;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.BaseHandler;

public class bjtm
  implements Printer
{
  public bjtm(BaseHandler paramBaseHandler) {}
  
  public void println(String paramString)
  {
    if ((!BaseHandler.isBusy) && (!((Boolean)BaseHandler.isRegulated.get()).booleanValue())) {}
    do
    {
      return;
      if (!BaseHandler.access$000())
      {
        Looper.myLooper().setMessageLogging(null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseHandler", 2, paramString);
      }
      if ((paramString != null) && (paramString.contains(">>>>> Dispatching to"))) {
        BaseHandler.access$100(this.a);
      }
    } while ((paramString == null) || (!paramString.contains("<<<<< Finished to")));
    BaseHandler.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtm
 * JD-Core Version:    0.7.0.1
 */