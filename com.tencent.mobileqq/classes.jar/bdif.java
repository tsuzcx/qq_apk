import android.text.TextUtils;
import com.tencent.image.JpegExifReader.JpegExifReaderInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bdif
  implements JpegExifReader.JpegExifReaderInterface
{
  public void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3) {}
  
  public boolean readEnableFromDPC()
  {
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("JpegExifReader", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          int i = Integer.parseInt(localObject[8]);
          if (i != 1) {
            break label81;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label81:
      while (!QLog.isColorLevel()) {}
      QLog.e("JpegExifReader", 2, "read dpc", localException);
    }
    return true;
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdif
 * JD-Core Version:    0.7.0.1
 */