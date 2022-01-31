import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bgvp
  implements Handler.Callback
{
  private bgvk jdField_a_of_type_Bgvk;
  private final bgvr jdField_a_of_type_Bgvr;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bgvp(bgvr parambgvr, bgvk parambgvk, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bgvr = parambgvr;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bgvk = parambgvk;
  }
  
  private void b(bgut parambgut, int paramInt)
  {
    if (parambgut == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambgut.a();
      str = parambgut.a().a;
    } while (parambgut.d());
    this.jdField_a_of_type_Bgvk.a(parambgut.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bgvq(this, str, l, parambgut, paramInt));
  }
  
  public void a(bgut parambgut, int paramInt)
  {
    if (parambgut == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambgut));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bgut)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvp
 * JD-Core Version:    0.7.0.1
 */