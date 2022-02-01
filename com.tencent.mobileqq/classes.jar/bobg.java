import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class bobg
  implements Handler.Callback
{
  private bobb jdField_a_of_type_Bobb;
  private final bobi jdField_a_of_type_Bobi;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bobg(bobi parambobi, bobb parambobb, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bobi = parambobi;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_Bobb = parambobb;
  }
  
  private void b(boak paramboak, int paramInt)
  {
    if (paramboak == null) {}
    long l;
    String str;
    do
    {
      return;
      l = paramboak.a();
      str = paramboak.a().a;
    } while (paramboak.d());
    this.jdField_a_of_type_Bobb.a(paramboak.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new bobh(this, str, l, paramboak, paramInt));
  }
  
  public void a(boak paramboak, int paramInt)
  {
    if (paramboak == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, paramboak));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((boak)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobg
 * JD-Core Version:    0.7.0.1
 */