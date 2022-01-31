import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class bnku
  implements baug
{
  bnku(bnkr parambnkr) {}
  
  public void onResp(bavf parambavf)
  {
    Object localObject = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int != 0) {
      lek.c("CaptureVideoFilterManager", "download file failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
      {
        lek.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
        return;
      }
      lek.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = bnkr.b;
        bdhb.a(parambavf.jdField_a_of_type_Bave.c, (String)localObject, false);
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
        if ((bnkr.a(this.a).decrementAndGet() == 0) && (bnkr.a(this.a) != null))
        {
          bnkr.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambavf)
      {
        parambavf.printStackTrace();
        lek.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnku
 * JD-Core Version:    0.7.0.1
 */