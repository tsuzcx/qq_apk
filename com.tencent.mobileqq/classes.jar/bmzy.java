import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bmzy
  implements Handler.Callback
{
  private bmzt jdField_a_of_type_Bmzt;
  private final bnaa jdField_a_of_type_Bnaa;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bmzy(bnaa parambnaa, bmzt parambmzt, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bnaa = parambnaa;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bmzt = parambmzt;
  }
  
  private void b(bmzc parambmzc, int paramInt)
  {
    if (parambmzc == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambmzc.a();
      str = parambmzc.a().a;
    } while (parambmzc.d());
    this.jdField_a_of_type_Bmzt.a(parambmzc.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bmzz(this, str, l, parambmzc, paramInt));
  }
  
  public void a(bmzc parambmzc, int paramInt)
  {
    if (parambmzc == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambmzc));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bmzc)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzy
 * JD-Core Version:    0.7.0.1
 */