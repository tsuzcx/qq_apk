import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;

class bbek
  extends Handler
{
  final WeakReference<bbeh> a;
  
  public bbek(Looper paramLooper, bbeh parambbeh)
  {
    super(paramLooper);
    this.a = new WeakReference(parambbeh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbeg.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    bbeh localbbeh = (bbeh)this.a.get();
    if (localbbeh == null) {}
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
        bbeg.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      case 1002: 
        bbeg.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
        paramMessage = paramMessage.getData();
      }
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localbbeh.a().a(paramMessage);
    return;
    AIOLongCaptureCtrl.a(paramMessage.getData());
    return;
    AIOLongCaptureCtrl.b(paramMessage.getData());
    return;
    paramMessage = paramMessage.getData();
    aibo.a().a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbek
 * JD-Core Version:    0.7.0.1
 */