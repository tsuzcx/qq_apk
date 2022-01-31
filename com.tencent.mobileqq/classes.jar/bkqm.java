import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bkqm
  implements aysa
{
  bkqm(bkqk parambkqk) {}
  
  public void onResp(aysx paramaysx)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)paramaysx.jdField_a_of_type_Aysw.a();
    if (localFilterDesc != null)
    {
      if (paramaysx.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bkqk.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bkqk.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bkue.b;
          bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bkqk.a(this.a, localFilterDesc, bbdj.a(paramaysx.jdField_a_of_type_Aysw.c), 0);
          bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
          bool = true;
        }
        catch (IOException paramaysx)
        {
          paramaysx.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bkqk.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqm
 * JD-Core Version:    0.7.0.1
 */