import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bngz
  implements baug
{
  bngz(bngx parambngx) {}
  
  public void onResp(bavf parambavf)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (localFilterDesc != null)
    {
      if (parambavf.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bngx.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bngx.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bnkr.b;
          bdhb.a(parambavf.jdField_a_of_type_Bave.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bngx.a(this.a, localFilterDesc, bdhb.a(parambavf.jdField_a_of_type_Bave.c), 0);
          bdhb.d(parambavf.jdField_a_of_type_Bave.c);
          bool = true;
        }
        catch (IOException parambavf)
        {
          parambavf.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bngx.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngz
 * JD-Core Version:    0.7.0.1
 */