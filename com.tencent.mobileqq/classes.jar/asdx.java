import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class asdx
  extends asdn
{
  public asdx(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ptt.so.658", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10007;
  }
  
  public Class<? extends XmlData> a()
  {
    return PttSilkAndChangeVoiceSoData.class;
  }
  
  public String a()
  {
    return "actEarlyPttSilkAndChangeVoiceSo";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "download success: " + paramString);
    }
    for (;;)
    {
      try
      {
        str = bamc.a();
        if ((str != null) && (!str.equals("")))
        {
          bhmi.a(str);
          if (new File(str).mkdir())
          {
            bhmi.a(paramString, str, false);
            if (QLog.isColorLevel()) {
              QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip success: " + paramString);
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip failed: " + localException.getMessage());
        continue;
      }
      try
      {
        if (!bamc.a)
        {
          bhmi.a(bamc.b());
          bhmi.c(str, bamc.b());
        }
        super.a(paramString);
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean h()
  {
    Object localObject = (PttSilkAndChangeVoiceSoData)a();
    if (localObject == null) {
      return false;
    }
    int i = llk.f();
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload cpuArch = " + i + " isUserNeedDownload try match version=" + "8.4.5" + " data.version=" + ((PttSilkAndChangeVoiceSoData)localObject).version);
    }
    localObject = this.a.getPreferences();
    if (!((SharedPreferences)localObject).getBoolean("hasReportedCpuArch", false))
    {
      bewa.a();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hasReportedCpuArch", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (i > 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload return " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdx
 * JD-Core Version:    0.7.0.1
 */