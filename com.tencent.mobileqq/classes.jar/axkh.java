import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class axkh
  implements bapx
{
  public void onResp(baqw parambaqw)
  {
    Object localObject = (axkk)parambaqw.jdField_a_of_type_Baqv.a();
    lek.c("CaptureVideoFilterManager", "download file call back. file = " + ((axkk)localObject).a);
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      lek.c("CaptureVideoFilterManager", "download file faild. errcode = " + parambaqw.b);
      return;
    }
    if (!((axkk)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
    {
      lek.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    lek.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = axkd.a();
      bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, (String)localObject, false);
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    catch (IOException parambaqw)
    {
      parambaqw.printStackTrace();
      lek.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkh
 * JD-Core Version:    0.7.0.1
 */