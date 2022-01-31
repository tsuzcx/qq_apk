import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class avsh
  implements aysa
{
  public void onResp(aysx paramaysx)
  {
    Object localObject = (avsk)paramaysx.jdField_a_of_type_Aysw.a();
    lcl.c("CaptureVideoFilterManager", "download file call back. file = " + ((avsk)localObject).a);
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      lcl.c("CaptureVideoFilterManager", "download file faild. errcode = " + paramaysx.b);
      return;
    }
    if (!((avsk)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
    {
      lcl.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    lcl.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = avsd.a();
      bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, (String)localObject, false);
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    catch (IOException paramaysx)
    {
      paramaysx.printStackTrace();
      lcl.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsh
 * JD-Core Version:    0.7.0.1
 */