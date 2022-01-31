import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bier
  implements Handler.Callback
{
  private biem jdField_a_of_type_Biem;
  private final biet jdField_a_of_type_Biet;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bier(biet parambiet, biem parambiem, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Biet = parambiet;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Biem = parambiem;
  }
  
  private void b(bidv parambidv, int paramInt)
  {
    if (parambidv == null) {}
    long l;
    String str;
    do
    {
      return;
      l = parambidv.a();
      str = parambidv.a().a;
    } while (parambidv.d());
    this.jdField_a_of_type_Biem.a(parambidv.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bies(this, str, l, parambidv, paramInt));
  }
  
  public void a(bidv parambidv, int paramInt)
  {
    if (parambidv == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, parambidv));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((bidv)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bier
 * JD-Core Version:    0.7.0.1
 */