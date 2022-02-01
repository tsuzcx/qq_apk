import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class bamr
  implements bdvw
{
  public void onResp(bdwt parambdwt)
  {
    Object localObject = (bamu)parambdwt.jdField_a_of_type_Bdws.a();
    lbc.c("CaptureVideoFilterManager", "download file call back. file = " + ((bamu)localObject).a);
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      lbc.c("CaptureVideoFilterManager", "download file faild. errcode = " + parambdwt.b);
      return;
    }
    if (!((bamu)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
    {
      lbc.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    lbc.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = bamn.a();
      bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, (String)localObject, false);
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    catch (IOException parambdwt)
    {
      parambdwt.printStackTrace();
      lbc.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamr
 * JD-Core Version:    0.7.0.1
 */