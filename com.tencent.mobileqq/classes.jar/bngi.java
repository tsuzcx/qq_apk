import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class bngi
  implements bapx
{
  bngi(bngf parambngf) {}
  
  public void onResp(baqw parambaqw)
  {
    Object localObject = (FilterDesc)parambaqw.jdField_a_of_type_Baqv.a();
    if (parambaqw.jdField_a_of_type_Int != 0) {
      lek.c("CaptureVideoFilterManager", "download file failed. errorCode: " + parambaqw.b + ", errorMsg: " + parambaqw.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
      {
        lek.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
        return;
      }
      lek.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = bngf.b;
        bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, (String)localObject, false);
        bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
        if ((bngf.a(this.a).decrementAndGet() == 0) && (bngf.a(this.a) != null))
        {
          bngf.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambaqw)
      {
        parambaqw.printStackTrace();
        lek.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngi
 * JD-Core Version:    0.7.0.1
 */