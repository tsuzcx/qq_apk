import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bqzx
  implements beuq
{
  bqzx(bqzv parambqzv) {}
  
  public void onResp(bevm parambevm)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)parambevm.jdField_a_of_type_Bevl.a();
    if (localFilterDesc != null)
    {
      if (parambevm.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bqzv.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bqzv.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = brdl.b;
          bhmi.a(parambevm.jdField_a_of_type_Bevl.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bqzv.a(this.a, localFilterDesc, bhmi.a(parambevm.jdField_a_of_type_Bevl.c), 0);
          bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
          bool = true;
        }
        catch (IOException parambevm)
        {
          parambevm.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bqzv.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqzx
 * JD-Core Version:    0.7.0.1
 */