import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class avsk
  implements aysc
{
  avsk(avsf paramavsf) {}
  
  public void onResp(aysz paramaysz)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaysz.jdField_a_of_type_Aysy.a();
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      lcg.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramaysz.b + ", errorMsg: " + paramaysz.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((avsf.a(this.a).decrementAndGet() == 0) && (avsf.a(this.a) != null)) {
      avsf.a(this.a).a(true);
    }
    lcg.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsk
 * JD-Core Version:    0.7.0.1
 */