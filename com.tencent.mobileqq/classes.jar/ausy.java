import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ausy
  implements axrt
{
  public void onResp(axsq paramaxsq)
  {
    Object localObject = (autb)paramaxsq.jdField_a_of_type_Axsp.a();
    krx.c("CaptureVideoFilterManager", "download file call back. file = " + ((autb)localObject).a);
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      krx.c("CaptureVideoFilterManager", "download file faild. errcode = " + paramaxsq.b);
      return;
    }
    if (!((autb)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
    {
      krx.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    krx.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = ausu.a();
      bace.a(paramaxsq.jdField_a_of_type_Axsp.c, (String)localObject, false);
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    catch (IOException paramaxsq)
    {
      paramaxsq.printStackTrace();
      krx.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ausy
 * JD-Core Version:    0.7.0.1
 */