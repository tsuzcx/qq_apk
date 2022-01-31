import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bncn
  implements bapx
{
  bncn(bncl parambncl) {}
  
  public void onResp(baqw parambaqw)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)parambaqw.jdField_a_of_type_Baqv.a();
    if (localFilterDesc != null)
    {
      if (parambaqw.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + parambaqw.b + ", errorMsg: " + parambaqw.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bncl.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bncl.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bngf.b;
          bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bncl.a(this.a, localFilterDesc, bdcs.a(parambaqw.jdField_a_of_type_Baqv.c), 0);
          bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
          bool = true;
        }
        catch (IOException parambaqw)
        {
          parambaqw.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bncl.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncn
 * JD-Core Version:    0.7.0.1
 */