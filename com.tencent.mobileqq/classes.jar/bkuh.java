import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class bkuh
  implements aysa
{
  bkuh(bkue parambkue) {}
  
  public void onResp(aysx paramaysx)
  {
    Object localObject = (FilterDesc)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int != 0) {
      lcl.c("CaptureVideoFilterManager", "download file failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
      {
        lcl.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
        return;
      }
      lcl.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = bkue.b;
        bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, (String)localObject, false);
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
        if ((bkue.a(this.a).decrementAndGet() == 0) && (bkue.a(this.a) != null))
        {
          bkue.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramaysx)
      {
        paramaysx.printStackTrace();
        lcl.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkuh
 * JD-Core Version:    0.7.0.1
 */