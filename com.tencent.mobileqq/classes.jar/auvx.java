import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager.1;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class auvx
  extends bhzv<auvw>
{
  public static boolean a;
  protected Context a;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public auvx(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public int a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\.");
      localObject1 = localObject2;
      if (arrayOfString.length >= 3) {
        try
        {
          int i = Integer.parseInt(arrayOfString[2]);
          return i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    QLog.e("ColorScreenManager", 1, "getColorScreenId failed from " + paramString, localNumberFormatException);
    return 0;
  }
  
  public auvw a(int paramInt)
  {
    for (;;)
    {
      File localFile3;
      File localFile2;
      try
      {
        File localFile1 = new File(a(paramInt), "unzip");
        if (!localFile1.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorScreenManager", 1, "getLocalConfig unzipDir not exist");
          }
          localFile1 = null;
          return localFile1;
        }
        localFile3 = new File(localFile1, "config.json");
        localFile2 = new File(localFile1, "fullscreen.json");
        if (!localFile3.exists())
        {
          QLog.e("ColorScreenManager", 1, "configFile do not exists.");
          biaa.a(BaseApplicationImpl.getApplication().getRuntime(), "individual_v2_colorscreen_parse_fail", "1", "", Integer.toString(paramInt), null, null, 0.0F, 0.0F);
          bhzz.a("individual_v2_colorscreen_parse_fail", "errCode:1, id:" + paramInt);
          a("colorScreen.android." + paramInt);
          localFile1 = null;
          continue;
        }
        if (!localFile2.exists())
        {
          QLog.e("ColorScreenManager", 1, "animFile do not exists.");
          continue;
        }
        localauvw = new auvw();
      }
      finally {}
      auvw localauvw;
      localauvw.jdField_a_of_type_JavaLangString = localFile2.getAbsolutePath();
      localauvw.jdField_b_of_type_JavaLangString = (localObject1.getAbsolutePath() + File.separator + "images");
      try
      {
        Object localObject2 = new JSONObject(bhmi.a(localFile3));
        localauvw.jdField_a_of_type_Int = (((JSONObject)localObject2).optInt("repeatCount", localauvw.jdField_a_of_type_Int) - 1);
        localauvw.jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("eastInTime", localauvw.jdField_a_of_type_Long);
        localauvw.jdField_b_of_type_Long = ((JSONObject)localObject2).optLong("eastOutTime", localauvw.jdField_b_of_type_Long);
        localObject2 = localauvw;
        if (QLog.isColorLevel())
        {
          long l = IOUtil.getCRC32Value(localFile2);
          QLog.d("ColorScreenManager", 1, "getLocalConfig crc32: " + Long.toHexString(l));
          localObject2 = localauvw;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ColorScreenManager", 1, "failed read config of " + paramInt, localException);
      }
    }
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "color_screen");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(a(), Integer.toString(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void a(int paramInt)
  {
    String str = "colorScreen.android." + paramInt;
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184);
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.downloadItem(22L, str, "ColorScreenManager");
    }
  }
  
  public void a(int paramInt, bhzw<auvw> parambhzw)
  {
    ThreadManager.post(new ColorScreenManager.1(this, paramInt, parambhzw), 5, null, false);
  }
  
  public void a(String paramString)
  {
    VasQuickUpdateEngine.safeDeleteFile(new File(a(), Integer.toString(a(paramString))));
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 258	auvx:a	(Ljava/lang/String;)I
    //   10: istore_3
    //   11: iload_3
    //   12: ifle +65 -> 77
    //   15: iload_2
    //   16: ifeq +64 -> 80
    //   19: ldc_w 271
    //   22: astore 4
    //   24: aload_0
    //   25: iload_3
    //   26: invokevirtual 273	auvx:a	(I)Lauvw;
    //   29: astore 5
    //   31: aload_0
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 276	auvx:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   38: aload 5
    //   40: ifnonnull +37 -> 77
    //   43: aload_0
    //   44: getfield 20	auvx:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   47: ldc_w 278
    //   50: iload_2
    //   51: invokestatic 281	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: aload 4
    //   56: iload_3
    //   57: invokestatic 130	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   60: aconst_null
    //   61: aconst_null
    //   62: fconst_0
    //   63: fconst_0
    //   64: invokestatic 135	biaa:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)V
    //   67: ldc_w 278
    //   70: iload_2
    //   71: invokestatic 281	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: invokestatic 145	bhzz:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: iload_3
    //   82: invokevirtual 85	auvx:a	(I)Ljava/io/File;
    //   85: astore 6
    //   87: new 82	java/io/File
    //   90: dup
    //   91: aload 6
    //   93: ldc_w 283
    //   96: invokespecial 90	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore 5
    //   101: aload 5
    //   103: invokevirtual 94	java/io/File:exists	()Z
    //   106: ifne +32 -> 138
    //   109: new 60	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 285
    //   119: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 5
    //   124: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 4
    //   135: goto -111 -> 24
    //   138: new 60	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   145: aload 6
    //   147: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 164	java/io/File:separator	Ljava/lang/String;
    //   156: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 87
    //   161: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore 6
    //   169: aload 5
    //   171: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   174: aload 6
    //   176: iconst_0
    //   177: invokestatic 288	bhmi:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   180: goto -156 -> 24
    //   183: astore 6
    //   185: new 60	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 290
    //   195: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   203: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 4
    //   211: ldc 58
    //   213: iconst_1
    //   214: new 60	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 292
    //   224: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 5
    //   229: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   243: goto -219 -> 24
    //   246: astore_1
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_1
    //   250: athrow
    //   251: astore 6
    //   253: new 60	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 294
    //   263: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 5
    //   268: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   271: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: astore 4
    //   279: ldc 58
    //   281: iconst_1
    //   282: new 60	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 292
    //   292: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 5
    //   297: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload 6
    //   308: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -287 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	auvx
    //   0	314	1	paramString	String
    //   0	314	2	paramInt	int
    //   10	72	3	i	int
    //   1	277	4	str	String
    //   29	267	5	localObject1	Object
    //   85	90	6	localObject2	Object
    //   183	56	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   251	56	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   169	180	183	java/lang/OutOfMemoryError
    //   5	11	246	finally
    //   24	38	246	finally
    //   43	77	246	finally
    //   80	135	246	finally
    //   138	169	246	finally
    //   169	180	246	finally
    //   185	243	246	finally
    //   253	311	246	finally
    //   169	180	251	java/lang/Throwable
  }
  
  public boolean a(String paramString)
  {
    int i = a(paramString);
    if (i > 0) {
      return new File(a(i), "config.zip").exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvx
 * JD-Core Version:    0.7.0.1
 */