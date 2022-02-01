import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class bams
  implements bdvw
{
  bams(bamn parambamn) {}
  
  public void onResp(bdwt parambdwt)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambdwt.jdField_a_of_type_Bdws.a();
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      lbc.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((bamn.a(this.a).decrementAndGet() == 0) && (bamn.a(this.a) != null)) {
      bamn.a(this.a).a(true);
    }
    lbc.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bams
 * JD-Core Version:    0.7.0.1
 */