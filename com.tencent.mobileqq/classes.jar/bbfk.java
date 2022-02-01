import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class bbfk
  implements beuq
{
  public void onResp(bevm parambevm)
  {
    Object localObject = (bbfn)parambevm.jdField_a_of_type_Bevl.a();
    lbj.c("CaptureVideoFilterManager", "download file call back. file = " + ((bbfn)localObject).a);
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      lbj.c("CaptureVideoFilterManager", "download file faild. errcode = " + parambevm.b);
      return;
    }
    if (!((bbfn)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
    {
      lbj.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    lbj.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = bbfg.a();
      bhmi.a(parambevm.jdField_a_of_type_Bevl.c, (String)localObject, false);
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    catch (IOException parambevm)
    {
      parambevm.printStackTrace();
      lbj.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfk
 * JD-Core Version:    0.7.0.1
 */