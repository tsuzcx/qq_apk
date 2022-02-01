import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class bmkc
{
  private static bmkc jdField_a_of_type_Bmkc;
  private static String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
  private static String b = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bmkc a()
  {
    if (jdField_a_of_type_Bmkc == null) {}
    try
    {
      if (jdField_a_of_type_Bmkc == null) {
        jdField_a_of_type_Bmkc = new bmkc();
      }
      return jdField_a_of_type_Bmkc;
    }
    finally {}
  }
  
  private HashMap<String, Object> a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0) || (!this.jdField_a_of_type_Boolean)) {
      paramString1 = null;
    }
    Object localObject1;
    HashMap localHashMap;
    int j;
    int i;
    do
    {
      do
      {
        return paramString1;
        localObject1 = bmio.a("com.adobe.xmp.XmpUtil", "extractXMPMeta", false, a(new Class[] { String.class }), new Object[] { paramString1 });
        localHashMap = new HashMap();
        paramString1 = localHashMap;
      } while (localObject1 == null);
      j = paramArrayOfString.length;
      i = 0;
      paramString1 = localHashMap;
    } while (i >= j);
    paramString1 = paramArrayOfString[i];
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject2 = bmio.a(localObject1, "getProperty", false, a(new Class[] { String.class, String.class }), new Object[] { paramString2, paramString1 });
      if (localObject2 != null)
      {
        localObject2 = bmio.a(localObject2, "getValue", false, new Class[0], new Object[0]);
        if (localObject2 != null) {
          localHashMap.put(paramString1, localObject2);
        }
      }
    }
  }
  
  private void a()
  {
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule");
    if (b())
    {
      QZLog.i("XMPCoreUtil", 4, new Object[] { "xmpCoreModulePath =", QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar") });
      this.jdField_a_of_type_Boolean = QzoneModuleManager.getInstance().loadModule("xmpcore.jar", getClass().getClassLoader(), false, false);
      if (this.jdField_a_of_type_Boolean) {
        QZLog.i("XMPCoreUtil", "loadXMPCoreModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule fail");
  }
  
  private boolean a()
  {
    String str = LocalMultiProcConfig.getString("xmp_core_file_md5", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(b)) {
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar");
    QZLog.i("XMPCoreUtil", 4, new Object[] { "isXMPCoreJarExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  public void a(bmkf parambmkf)
  {
    if (parambmkf == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      parambmkf.a(this.jdField_a_of_type_Boolean);
      return;
    }
    if ((a()) || (!b())) {}
    for (int i = 1; i == 0; i = 0)
    {
      a();
      parambmkf.a(this.jdField_a_of_type_Boolean);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new bmkd(this, parambmkf));
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).booleanValue();
    }
    Object localObject = a(paramString, "http://ns.google.com/photos/1.0/panorama/", new String[] { "GPano:UsePanoramaViewer" });
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).get("GPano:UsePanoramaViewer");
      if ((localObject != null) && ((localObject instanceof String)))
      {
        boolean bool = ((String)localObject).equalsIgnoreCase("true");
        QZLog.i("XMPCoreUtil", 4, new Object[] { "isPanorama: ", Boolean.valueOf(bool) });
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(bool));
        return bool;
      }
    }
    return false;
  }
  
  public Class[] a(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkc
 * JD-Core Version:    0.7.0.1
 */