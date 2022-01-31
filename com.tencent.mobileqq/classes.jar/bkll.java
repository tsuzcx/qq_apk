import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bkll
  implements Handler.Callback
{
  private bklg jdField_a_of_type_Bklg;
  private final bkln jdField_a_of_type_Bkln;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bkll(bkln parambkln, bklg parambklg, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bkln = parambkln;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bklg = parambklg;
  }
  
  private void b(bkkp parambkkp, int paramInt)
  {
    if (parambkkp == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambkkp.a();
      str = parambkkp.a().a;
    } while (parambkkp.d());
    this.jdField_a_of_type_Bklg.a(parambkkp.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bklm(this, str, l, parambkkp, paramInt));
  }
  
  public void a(bkkp parambkkp, int paramInt)
  {
    if (parambkkp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambkkp));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bkkp)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkll
 * JD-Core Version:    0.7.0.1
 */