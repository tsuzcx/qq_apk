import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadReport;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class bdnh
  implements SoLoadReport
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  private HashMap<String, String> a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", a.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    localHashMap.put("costTime", paramLong + "");
    localHashMap.put("processName", BaseApplicationImpl.processName);
    return localHashMap;
  }
  
  private void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    azri.a(paramHashMap, paramInt);
    azri localazri = azri.a(BaseApplicationImpl.getContext());
    if (paramBoolean)
    {
      localazri.a("", "loadSoNew", false, 0L, 0L, paramHashMap, "");
      return;
    }
    localazri.a("", "loadSoOld", false, 0L, 0L, paramHashMap, "");
  }
  
  public void report(int paramInt, String paramString, long paramLong)
  {
    HashMap localHashMap1 = a(paramString, paramLong);
    HashMap localHashMap2 = a(paramString, paramLong);
    boolean bool;
    int i;
    if (((paramInt & 0x2) == 2) || ((paramInt & 0x40000) == 262144))
    {
      a(true, 0, localHashMap1);
      bool = true;
      QLog.i("SoLoadUtilNew", 1, "load " + paramString + " result:" + bool + " code " + paramInt);
      if ((paramInt & 0x2) != 2) {
        break label189;
      }
      if (((paramInt & 0x8000) != 32768) || ((paramInt & 0x1000) != 4096) || ((paramInt & 0x800) != 0)) {
        break label149;
      }
      i = 0;
    }
    for (;;)
    {
      a(false, i, localHashMap2);
      return;
      a(true, paramInt, localHashMap1);
      bool = false;
      break;
      label149:
      i = paramInt;
      if ((paramInt & 0x200) == 512)
      {
        i = paramInt;
        if ((paramInt & 0x40) == 0)
        {
          i = paramInt;
          if ((paramInt & 0x8) == 0)
          {
            i = 0;
            continue;
            label189:
            i = paramInt;
            if ((paramInt & 0x40000) == 262144) {
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public void reportThrowable(Throwable paramThrowable, String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while ((paramThrowable == null) || (!(paramThrowable instanceof UnsatisfiedLinkError)));
      paramThrowable = paramThrowable.getMessage();
    } while ((paramThrowable == null) || (paramThrowable.indexOf("too many libraries") < 0));
    azri.a(BaseApplicationImpl.getContext()).a("", "SoCountLimit", false, 0L, 0L, a(paramString, 0L), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdnh
 * JD-Core Version:    0.7.0.1
 */