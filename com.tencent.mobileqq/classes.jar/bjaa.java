import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bjaa
  implements axrt
{
  bjaa(bizy parambizy) {}
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)paramaxsq.jdField_a_of_type_Axsp.a();
    if (localFilterDesc != null)
    {
      if (paramaxsq.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramaxsq.b + ", errorMsg: " + paramaxsq.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bizy.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bizy.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bjds.b;
          bace.a(paramaxsq.jdField_a_of_type_Axsp.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bizy.a(this.a, localFilterDesc, bace.a(paramaxsq.jdField_a_of_type_Axsp.c), 0);
          bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
          bool = true;
        }
        catch (IOException paramaxsq)
        {
          paramaxsq.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bizy.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaa
 * JD-Core Version:    0.7.0.1
 */