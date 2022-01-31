import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class ausz
  implements axrt
{
  ausz(ausu paramausu) {}
  
  public void onResp(axsq paramaxsq)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      krx.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramaxsq.b + ", errorMsg: " + paramaxsq.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((ausu.a(this.a).decrementAndGet() == 0) && (ausu.a(this.a) != null)) {
      ausu.a(this.a).a(true);
    }
    krx.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ausz
 * JD-Core Version:    0.7.0.1
 */