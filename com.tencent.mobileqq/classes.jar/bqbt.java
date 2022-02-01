import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class bqbt
  implements bdvw
{
  bqbt(bqbq parambqbq) {}
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject = (FilterDesc)parambdwt.jdField_a_of_type_Bdws.a();
    if (parambdwt.jdField_a_of_type_Int != 0) {
      lbc.c("CaptureVideoFilterManager", "download file failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
      {
        lbc.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
        return;
      }
      lbc.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = bqbq.b;
        bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, (String)localObject, false);
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
        if ((bqbq.a(this.a).decrementAndGet() == 0) && (bqbq.a(this.a) != null))
        {
          bqbq.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambdwt)
      {
        parambdwt.printStackTrace();
        lbc.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbt
 * JD-Core Version:    0.7.0.1
 */