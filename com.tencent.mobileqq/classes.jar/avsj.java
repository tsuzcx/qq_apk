import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class avsj
  implements aysc
{
  public void onResp(aysz paramaysz)
  {
    Object localObject = (avsm)paramaysz.jdField_a_of_type_Aysy.a();
    lcg.c("CaptureVideoFilterManager", "download file call back. file = " + ((avsm)localObject).a);
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      lcg.c("CaptureVideoFilterManager", "download file faild. errcode = " + paramaysz.b);
      return;
    }
    if (!((avsm)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
    {
      lcg.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    lcg.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = avsf.a();
      bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, (String)localObject, false);
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    catch (IOException paramaysz)
    {
      paramaysz.printStackTrace();
      lcg.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsj
 * JD-Core Version:    0.7.0.1
 */