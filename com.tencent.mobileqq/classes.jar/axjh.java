import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;

class axjh
  extends Handler
{
  final WeakReference<axje> a;
  
  public axjh(Looper paramLooper, axje paramaxje)
  {
    super(paramLooper);
    this.a = new WeakReference(paramaxje);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axjd.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    axje localaxje = (axje)this.a.get();
    if (localaxje == null) {}
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
        axjd.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      case 1002: 
        axjd.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
        paramMessage = paramMessage.getData();
      }
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localaxje.a().a(paramMessage);
    return;
    AIOLongCaptureCtrl.a(paramMessage.getData());
    return;
    AIOLongCaptureCtrl.b(paramMessage.getData());
    return;
    paramMessage = paramMessage.getData();
    agdf.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjh
 * JD-Core Version:    0.7.0.1
 */