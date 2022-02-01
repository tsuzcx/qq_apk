import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bmte
  implements Handler.Callback
{
  private bmsz jdField_a_of_type_Bmsz;
  private final bmtg jdField_a_of_type_Bmtg;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bmte(bmtg parambmtg, bmsz parambmsz, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bmtg = parambmtg;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bmsz = parambmsz;
  }
  
  private void b(bmsi parambmsi, int paramInt)
  {
    if (parambmsi == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambmsi.a();
      str = parambmsi.a().a;
    } while (parambmsi.d());
    this.jdField_a_of_type_Bmsz.a(parambmsi.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bmtf(this, str, l, parambmsi, paramInt));
  }
  
  public void a(bmsi parambmsi, int paramInt)
  {
    if (parambmsi == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambmsi));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bmsi)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmte
 * JD-Core Version:    0.7.0.1
 */