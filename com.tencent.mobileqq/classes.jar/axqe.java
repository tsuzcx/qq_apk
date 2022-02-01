import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class axqe
  implements axqj
{
  public axqe(OlympicManager paramOlympicManager) {}
  
  public void a(String paramString1, String paramString2, Object paramObject, int paramInt, String paramString3)
  {
    if ((paramObject == null) || (!(paramObject instanceof String[]))) {}
    do
    {
      for (;;)
      {
        return;
        axsb.b("OlympicManager", new Object[] { "onDownloadFinish, url=", paramString1, ", md5=", paramString2, ", errCode=", Integer.valueOf(paramInt) });
        if (paramInt == 0) {
          this.a.a(paramString1, 0, true);
        }
        String[] arrayOfString = (String[])paramObject;
        String str = arrayOfString[0];
        if ("shuayishua".equals(str))
        {
          int i = Integer.valueOf(arrayOfString[1]).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("OlympicManager", 2, "onDownloadFinish.type=shuayishuaurl=" + paramString1 + ",md5=" + paramString2 + ",userData=" + paramObject + ",errCode=" + paramInt + ",filePath=" + paramString3);
          }
          paramString1 = OlympicManager.a(this.a);
          if ((paramInt == 0) && (paramString1 != null) && (paramString1.id == i)) {
            OlympicManager.b(this.a).obtainMessage(5).sendToTarget();
          }
        }
        else if ("shuayishua_anim".equals(str))
        {
          if (paramInt == 0) {
            try
            {
              OlympicManager.a(this.a);
              paramString1 = axqh.a(paramString2);
              FileUtils.uncompressZip(paramString3, paramString1, false);
              if (QLog.isColorLevel()) {
                QLog.d("OlympicManager", 2, "un compressZip shuayishua_anim success.destDir=" + paramString1);
              }
              paramString1 = OlympicManager.a(this.a);
              if ((paramString1 == null) || (paramString1.id != -1)) {
                continue;
              }
              OlympicManager.b(this.a).obtainMessage(5).sendToTarget();
              return;
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("OlympicManager", 2, "un compressZip shuayishua_anim failed: " + paramString1.getMessage());
                }
              }
            }
          }
        }
        else if ("ActConfig".equals(str))
        {
          paramObject = arrayOfString[1];
          axsb.a("OlympicManager", new Object[] { "mDownloadListener.onDownloadFinish, type=", str, ", itemType=", paramObject, ", url=", paramString1, ", md5=", paramString2, ", errCode=", Integer.valueOf(paramInt), ", filePath=", paramString3 });
          if (("TorchAnim".equals(paramObject)) && (paramInt == 0)) {
            try
            {
              OlympicManager.a(this.a);
              paramString1 = axqh.a(paramString2);
              FileUtils.uncompressZip(paramString3, paramString1, false);
              if (QLog.isColorLevel())
              {
                QLog.d("OlympicManager", 2, "un compressZip TorchAnim success.destDir=" + paramString1);
                return;
              }
            }
            catch (Exception paramString1) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("OlympicManager", 2, "un compressZip TorchAnim failed: " + paramString1.getMessage());
  }
  
  public void a(String paramString1, String paramString2, Object paramObject, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqe
 * JD-Core Version:    0.7.0.1
 */