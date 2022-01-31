import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;

class avrj
  extends Handler
{
  final WeakReference<avrg> a;
  
  public avrj(Looper paramLooper, avrg paramavrg)
  {
    super(paramLooper);
    this.a = new WeakReference(paramavrg);
  }
  
  public void handleMessage(Message paramMessage)
  {
    avrf.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    avrg localavrg = (avrg)this.a.get();
    if (localavrg == null) {}
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
        avrf.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      case 1002: 
        avrf.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
        paramMessage = paramMessage.getData();
      }
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localavrg.a().a(paramMessage);
    return;
    AIOLongCaptureCtrl.a(paramMessage.getData());
    return;
    AIOLongCaptureCtrl.b(paramMessage.getData());
    return;
    paramMessage = paramMessage.getData();
    aegp.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrj
 * JD-Core Version:    0.7.0.1
 */