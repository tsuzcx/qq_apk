import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.HashMap;

public class bima
{
  private static bima jdField_a_of_type_Bima;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_plugin.apk", "qwallet_plugin.apk", "qqfav.apk", "qqwadl.apk" };
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<String, PluginInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private bima(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public static final bima a(Context paramContext)
  {
    if (jdField_a_of_type_Bima == null) {}
    try
    {
      if (jdField_a_of_type_Bima == null) {
        jdField_a_of_type_Bima = new bima(paramContext);
      }
      return jdField_a_of_type_Bima;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(jdField_a_of_type_ArrayOfJavaLangString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return (PluginInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init. built in plugin size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 105	java/io/BufferedReader
    //   5: dup
    //   6: new 107	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 36	bima:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 115
    //   19: invokevirtual 121	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 127	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +139 -> 174
    //   38: aload_2
    //   39: invokevirtual 133	java/lang/String:trim	()Ljava/lang/String;
    //   42: ldc 135
    //   44: invokevirtual 139	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: iconst_0
    //   52: aaload
    //   53: astore_3
    //   54: ldc 141
    //   56: astore_2
    //   57: aload 4
    //   59: arraylength
    //   60: iconst_1
    //   61: if_icmple +8 -> 69
    //   64: aload 4
    //   66: iconst_1
    //   67: aaload
    //   68: astore_2
    //   69: new 62	cooperation/plugin/PluginInfo
    //   72: dup
    //   73: invokespecial 142	cooperation/plugin/PluginInfo:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_3
    //   81: putfield 146	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   84: aload 4
    //   86: aload_2
    //   87: putfield 149	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   90: aload 4
    //   92: iconst_1
    //   93: putfield 153	cooperation/plugin/PluginInfo:mUpdateType	I
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 156	cooperation/plugin/PluginInfo:mInstallType	I
    //   102: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +45 -> 150
    //   108: ldc 72
    //   110: iconst_2
    //   111: new 74	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   118: ldc 158
    //   120: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: getfield 146	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   128: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 160
    //   133: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 4
    //   138: getfield 149	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   141: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 34	bima:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   154: aload_3
    //   155: aload 4
    //   157: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: goto -132 -> 29
    //   164: astore_2
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 167	java/io/BufferedReader:close	()V
    //   173: return
    //   174: aload_1
    //   175: ifnull -2 -> 173
    //   178: aload_1
    //   179: invokevirtual 167	java/io/BufferedReader:close	()V
    //   182: return
    //   183: astore_1
    //   184: return
    //   185: astore_1
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 167	java/io/BufferedReader:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: return
    //   198: astore_2
    //   199: goto -5 -> 194
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload_3
    //   206: astore_1
    //   207: goto -21 -> 186
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -48 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	bima
    //   28	151	1	localBufferedReader	java.io.BufferedReader
    //   183	1	1	localException1	java.lang.Exception
    //   185	10	1	localObject1	Object
    //   196	8	1	localException2	java.lang.Exception
    //   206	1	1	localObject2	Object
    //   210	1	1	localIOException1	java.io.IOException
    //   212	1	1	localObject3	Object
    //   1	86	2	str	String
    //   164	27	2	localIOException2	java.io.IOException
    //   198	1	2	localException3	java.lang.Exception
    //   204	1	2	localObject4	Object
    //   53	102	3	localObject5	Object
    //   202	4	3	localObject6	Object
    //   47	109	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	164	java/io/IOException
    //   38	49	164	java/io/IOException
    //   57	64	164	java/io/IOException
    //   69	150	164	java/io/IOException
    //   150	161	164	java/io/IOException
    //   178	182	183	java/lang/Exception
    //   2	29	185	finally
    //   169	173	196	java/lang/Exception
    //   190	194	198	java/lang/Exception
    //   29	34	202	finally
    //   38	49	202	finally
    //   57	64	202	finally
    //   69	150	202	finally
    //   150	161	202	finally
    //   2	29	210	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bima
 * JD-Core Version:    0.7.0.1
 */