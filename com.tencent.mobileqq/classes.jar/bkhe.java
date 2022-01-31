import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bkhe
  implements Handler.Callback
{
  private bkgz jdField_a_of_type_Bkgz;
  private final bkhg jdField_a_of_type_Bkhg;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bkhe(bkhg parambkhg, bkgz parambkgz, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bkhg = parambkhg;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bkgz = parambkgz;
  }
  
  private void b(bkgi parambkgi, int paramInt)
  {
    if (parambkgi == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambkgi.a();
      str = parambkgi.a().a;
    } while (parambkgi.d());
    this.jdField_a_of_type_Bkgz.a(parambkgi.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bkhf(this, str, l, parambkgi, paramInt));
  }
  
  public void a(bkgi parambkgi, int paramInt)
  {
    if (parambkgi == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambkgi));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bkgi)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhe
 * JD-Core Version:    0.7.0.1
 */