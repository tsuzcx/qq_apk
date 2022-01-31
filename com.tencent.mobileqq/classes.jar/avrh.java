import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;

class avrh
  extends Handler
{
  final WeakReference<avre> a;
  
  public avrh(Looper paramLooper, avre paramavre)
  {
    super(paramLooper);
    this.a = new WeakReference(paramavre);
  }
  
  public void handleMessage(Message paramMessage)
  {
    avrd.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    avre localavre = (avre)this.a.get();
    if (localavre == null) {}
    do
    {
      return;
      if (paramMessage.getData() != null) {
        paramMessage.getData().getInt("msg_sub_cmd");
      }
      switch (paramMessage.what)
      {
      case 1001: 
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1000: 
        avrd.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      case 1002: 
        avrd.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
        paramMessage = paramMessage.getData();
      }
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localavre.a().a(paramMessage);
    return;
    AIOLongCaptureCtrl.a(paramMessage.getData());
    return;
    AIOLongCaptureCtrl.b(paramMessage.getData());
    return;
    paramMessage = paramMessage.getData();
    aegr.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrh
 * JD-Core Version:    0.7.0.1
 */