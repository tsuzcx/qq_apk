import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class bbfl
  implements beuq
{
  bbfl(bbfg parambbfg) {}
  
  public void onResp(bevm parambevm)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      lbj.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((bbfg.a(this.a).decrementAndGet() == 0) && (bbfg.a(this.a) != null)) {
      bbfg.a(this.a).a(true);
    }
    lbj.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfl
 * JD-Core Version:    0.7.0.1
 */