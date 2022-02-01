import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bpyc
  implements bdvw
{
  bpyc(bpya parambpya) {}
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)parambdwt.jdField_a_of_type_Bdws.a();
    if (localFilterDesc != null)
    {
      if (parambdwt.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bpya.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bpya.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bqbq.b;
          bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bpya.a(this.a, localFilterDesc, bgmg.a(parambdwt.jdField_a_of_type_Bdws.c), 0);
          bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
          bool = true;
        }
        catch (IOException parambdwt)
        {
          parambdwt.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bpya.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpyc
 * JD-Core Version:    0.7.0.1
 */