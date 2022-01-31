import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class axor
  implements baug
{
  axor(axom paramaxom) {}
  
  public void onResp(bavf parambavf)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((axom.a(this.a).decrementAndGet() == 0) && (axom.a(this.a) != null)) {
      axom.a(this.a).a(true);
    }
    lek.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axor
 * JD-Core Version:    0.7.0.1
 */