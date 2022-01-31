import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bkrd
  implements aysc
{
  bkrd(bkrb parambkrb) {}
  
  public void onResp(aysz paramaysz)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)paramaysz.jdField_a_of_type_Aysy.a();
    if (localFilterDesc != null)
    {
      if (paramaysz.jdField_a_of_type_Int == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramaysz.b + ", errorMsg: " + paramaysz.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.resurl);
      bkrb.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bkrb.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bkuv.b;
          bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bkrb.a(this.a, localFilterDesc, bbdx.a(paramaysz.jdField_a_of_type_Aysy.c), 0);
          bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
          bool = true;
        }
        catch (IOException paramaysz)
        {
          paramaysz.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bkrb.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkrd
 * JD-Core Version:    0.7.0.1
 */