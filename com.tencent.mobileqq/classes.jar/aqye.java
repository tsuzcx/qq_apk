import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaBizLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqye
  extends aqxl
{
  public static final String[] a = { "libviola.so" };
  
  public aqye(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_biz_810", paramQQAppInterface);
  }
  
  public static void f()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (aqxc)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (aqye)((aqxc)localObject).a("android.qq.readinjoy.viola_biz_810");
        if (localObject != null)
        {
          ((aqye)localObject).a(true);
          QLog.i("viola.ViolaBizLibHandler", 1, "restartDownloadLib");
        }
      }
    }
  }
  
  public static boolean i()
  {
    String str = pld.a();
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
    return 10079;
  }
  
  public Class<? extends XmlData> a()
  {
    return ViolaBizLibData.class;
  }
  
  public String a()
  {
    return "viola.ViolaBizLibHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("viola.ViolaBizLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (pld.a(paramString)) {
        break label124;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        aqxb.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess],unzip android.qq.readinjoy.viola_biz_810 lib failed!");
    }
    label124:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_biz_810").commit();
      }
    } while (!aqyf.i());
    pkx.a("biz doOnDownloadSuccess");
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
 * Qualified Name:     aqye
 * JD-Core Version:    0.7.0.1
 */