import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;

class bbfv
  extends Handler
{
  final WeakReference<bbfs> a;
  
  public bbfv(Looper paramLooper, bbfs parambbfs)
  {
    super(paramLooper);
    this.a = new WeakReference(parambbfs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbfr.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    bbfs localbbfs = (bbfs)this.a.get();
    if (localbbfs == null) {}
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
        bbfr.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      case 1002: 
        bbfr.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
        paramMessage = paramMessage.getData();
      }
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localbbfs.a().a(paramMessage);
    return;
    AIOLongCaptureCtrl.a(paramMessage.getData());
    return;
    AIOLongCaptureCtrl.b(paramMessage.getData());
    return;
    paramMessage = paramMessage.getData();
    ahrf.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfv
 * JD-Core Version:    0.7.0.1
 */