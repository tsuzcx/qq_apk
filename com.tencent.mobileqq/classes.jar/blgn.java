import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class blgn
  implements Handler.Callback
{
  private blgi jdField_a_of_type_Blgi;
  private final blgp jdField_a_of_type_Blgp;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public blgn(blgp paramblgp, blgi paramblgi, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Blgp = paramblgp;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Blgi = paramblgi;
  }
  
  private void b(blfr paramblfr, int paramInt)
  {
    if (paramblfr == null) {}
    long l;
    String str;
    do
    {
      return;
      l = paramblfr.a();
      str = paramblfr.a().a;
    } while (paramblfr.d());
    this.jdField_a_of_type_Blgi.a(paramblfr.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new blgo(this, str, l, paramblfr, paramInt));
  }
  
  public void a(blfr paramblfr, int paramInt)
  {
    if (paramblfr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, paramblfr));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((blfr)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgn
 * JD-Core Version:    0.7.0.1
 */