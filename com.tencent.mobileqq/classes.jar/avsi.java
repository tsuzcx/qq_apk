import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class avsi
  implements aysc
{
  avsi(avsf paramavsf) {}
  
  public void onResp(aysz paramaysz)
  {
    Object localObject = (FilterDesc)paramaysz.jdField_a_of_type_Aysy.a();
    if (paramaysz.jdField_a_of_type_Int != 0) {
      lcg.c("CaptureVideoFilterManager", "download file failed. errorCode: " + paramaysz.b + ", errorMsg: " + paramaysz.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
      {
        lcg.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
        return;
      }
      lcg.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = avsf.b;
        bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, (String)localObject, false);
        bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
        if ((avsf.a(this.a).decrementAndGet() == 0) && (avsf.a(this.a) != null))
        {
          avsf.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramaysz)
      {
        paramaysz.printStackTrace();
        lcg.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsi
 * JD-Core Version:    0.7.0.1
 */