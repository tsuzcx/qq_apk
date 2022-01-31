import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aplx
  extends apld
{
  public static final String[] a = (String[])new String[] { "libgnustl_shared.so", "libjsc.so" };
  
  public aplx(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_795", paramQQAppInterface);
  }
  
  public static void a()
  {
    if (i()) {}
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (apks)((QQAppInterface)localObject).getManager(77);
        if (localObject != null)
        {
          localObject = (aplx)((apks)localObject).a("android.qq.readinjoy.viola_795");
          if (localObject != null)
          {
            ((aplx)localObject).a(true);
            QLog.i("viola.ViolaLibHandler", 1, "restartDownloadLib");
          }
        }
      }
    } while (aplw.i());
    aplw.a();
  }
  
  public static boolean i()
  {
    String str = oxo.a();
    int i = 0;
    while (i < a.length)
    {
      File localFile = new File(str, a[i]);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int a()
  {
    return 10071;
  }
  
  public Class<? extends XmlData> a()
  {
    return ViolaLibData.class;
  }
  
  public String a()
  {
    return "viola.ViolaLibHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("viola.ViolaLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (oxo.a(paramString)) {
        break label124;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        apkr.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess],unzip readinjoy_viola lib failed!");
    }
    label124:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_795").commit();
      }
    } while (!aplw.i());
    oxi.a("jsc doOnDownloadSuccess");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplx
 * JD-Core Version:    0.7.0.1
 */