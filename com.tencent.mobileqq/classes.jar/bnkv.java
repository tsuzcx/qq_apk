import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class bnkv
  implements baug
{
  bnkv(bnkr parambnkr) {}
  
  public void onResp(bavf parambavf)
  {
    FilterDesc localFilterDesc = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((bnkr.a(this.a).decrementAndGet() == 0) && (bnkr.a(this.a) != null)) {
      bnkr.a(this.a).a(true);
    }
    lek.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkv
 * JD-Core Version:    0.7.0.1
 */