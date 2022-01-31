import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bifi
  implements Handler.Callback
{
  private bifd jdField_a_of_type_Bifd;
  private final bifk jdField_a_of_type_Bifk;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bifi(bifk parambifk, bifd parambifd, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bifk = parambifk;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bifd = parambifd;
  }
  
  private void b(biem parambiem, int paramInt)
  {
    if (parambiem == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambiem.a();
      str = parambiem.a().a;
    } while (parambiem.d());
    this.jdField_a_of_type_Bifd.a(parambiem.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bifj(this, str, l, parambiem, paramInt));
  }
  
  public void a(biem parambiem, int paramInt)
  {
    if (parambiem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambiem));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((biem)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifi
 * JD-Core Version:    0.7.0.1
 */