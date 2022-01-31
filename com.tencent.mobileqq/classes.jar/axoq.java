import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class axoq
  implements baug
{
  public void onResp(bavf parambavf)
  {
    Object localObject = (axot)parambavf.jdField_a_of_type_Bave.a();
    lek.c("CaptureVideoFilterManager", "download file call back. file = " + ((axot)localObject).a);
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("CaptureVideoFilterManager", "download file faild. errcode = " + parambavf.b);
      return;
    }
    if (!((axot)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
    {
      lek.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    lek.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = axom.a();
      bdhb.a(parambavf.jdField_a_of_type_Bave.c, (String)localObject, false);
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    catch (IOException parambavf)
    {
      parambavf.printStackTrace();
      lek.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axoq
 * JD-Core Version:    0.7.0.1
 */