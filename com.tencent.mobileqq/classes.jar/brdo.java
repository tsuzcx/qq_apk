import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class brdo
  implements beuq
{
  brdo(brdl parambrdl) {}
  
  public void onResp(bevm parambevm)
  {
    Object localObject = (FilterDesc)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int != 0) {
      lbj.c("CaptureVideoFilterManager", "download file failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
      {
        lbj.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
        return;
      }
      lbj.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = brdl.b;
        bhmi.a(parambevm.jdField_a_of_type_Bevl.c, (String)localObject, false);
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
        if ((brdl.a(this.a).decrementAndGet() == 0) && (brdl.a(this.a) != null))
        {
          brdl.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambevm)
      {
        parambevm.printStackTrace();
        lbj.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     brdo
 * JD-Core Version:    0.7.0.1
 */