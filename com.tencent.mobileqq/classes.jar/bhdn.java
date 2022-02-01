import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.ICommonManager;
import java.io.File;

public class bhdn
  implements ICommonManager
{
  public boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = bgmg.a(paramString1, bgmg.a(paramString2));
      return bool;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public boolean filePatch(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "bsPatch: srcFile = " + paramString1 + " patchFile = " + paramString2);
    }
    return BspatchUtil.a(paramString1, paramString2, paramString1);
  }
  
  public String getAppVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "getAppVersion = 8.4.1");
    }
    return "8.4.1";
  }
  
  public Context getApplicationContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public String getFileMd5(String paramString)
  {
    return bita.a(paramString);
  }
  
  public int getNetType()
  {
    int j = 0;
    int i = j;
    switch (nlw.a())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_CommonManagerImpl", 2, "getNetType netType = " + i + " local = " + nlw.a());
      }
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 4;
      continue;
      i = 3;
    }
  }
  
  public String getReportVersion()
  {
    return "8.4.1.4680";
  }
  
  public String getSeqConfigPath()
  {
    return VasQuickUpdateEngine.ENGINE_CONFIG_PATH;
  }
  
  public long getServiceTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public long getTimerDelay()
  {
    return 500L;
  }
  
  public String unCompressFile(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip: type = " + paramInt + " srcFile = " + paramString);
    }
    if (paramInt != 1) {}
    for (;;)
    {
      return null;
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip file un exist");
        return null;
      }
      paramString = ((File)localObject).getParent() + File.separator;
      try
      {
        localObject = VasQuickUpdateEngine.unZipFile((File)localObject, paramString);
        if (localObject != null)
        {
          paramString = paramString + (String)localObject;
          if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip result = " + paramString);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VasUpdate_CommonManagerImpl", 2, "uncompressZip fail");
          return null;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip error : ", paramString);
        return null;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdn
 * JD-Core Version:    0.7.0.1
 */