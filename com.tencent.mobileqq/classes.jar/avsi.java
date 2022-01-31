import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.concurrent.atomic.AtomicInteger;

class avsi
  implements aysa
{
  avsi(avsd paramavsd) {}
  
  public void onResp(aysx paramaysx)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      lcl.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((avsd.a(this.a).decrementAndGet() == 0) && (avsd.a(this.a) != null)) {
      avsd.a(this.a).a(true);
    }
    lcl.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsi
 * JD-Core Version:    0.7.0.1
 */