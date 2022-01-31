import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class axki
  implements bapx
{
  axki(axkd paramaxkd) {}
  
  public void onResp(baqw parambaqw)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambaqw.jdField_a_of_type_Baqv.a();
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      lek.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + parambaqw.b + ", errorMsg: " + parambaqw.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((axkd.a(this.a).decrementAndGet() == 0) && (axkd.a(this.a) != null)) {
      axkd.a(this.a).a(true);
    }
    lek.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axki
 * JD-Core Version:    0.7.0.1
 */