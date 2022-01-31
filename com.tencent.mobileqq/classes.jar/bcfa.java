import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.base.OpenConfig.1;
import com.tencent.open.business.base.OpenConfig.2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class bcfa
{
  protected static String a;
  protected static HashMap<String, bcfa> a;
  public int a;
  protected long a;
  protected Context a;
  public JSONObject a;
  private boolean a;
  protected String b;
  
  protected bcfa(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramString;
    a();
    b();
  }
  
  public static bcfa a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (paramString != null) {
      jdField_a_of_type_JavaLangString = paramString;
    }
    String str = paramString;
    if (paramString == null) {
      if (jdField_a_of_type_JavaLangString == null) {
        break label78;
      }
    }
    label78:
    for (str = jdField_a_of_type_JavaLangString;; str = "0")
    {
      bcfa localbcfa = (bcfa)jdField_a_of_type_JavaUtilHashMap.get(str);
      paramString = localbcfa;
      if (localbcfa == null)
      {
        paramString = new bcfa(paramContext, str);
        jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      }
      return paramString;
    }
  }
  
  public int a(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optInt(paramString);
  }
  
  public long a(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optLong(paramString);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	bcfa:b	Ljava/lang/String;
    //   4: ifnull +102 -> 106
    //   7: new 73	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 80
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 23	bcfa:b	Ljava/lang/String;
    //   27: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 21	bcfa:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   38: aload_2
    //   39: invokevirtual 90	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: new 92	java/io/BufferedReader
    //   48: dup
    //   49: new 94	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 97	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_2
    //   61: new 102	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 103	java/lang/StringBuffer:<init>	()V
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +58 -> 135
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 109	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   86: pop
    //   87: goto -18 -> 69
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   95: aload_1
    //   96: invokevirtual 117	java/io/InputStream:close	()V
    //   99: aload_2
    //   100: invokevirtual 118	java/io/BufferedReader:close	()V
    //   103: ldc 120
    //   105: areturn
    //   106: aload_1
    //   107: astore_2
    //   108: goto -74 -> 34
    //   111: astore_2
    //   112: aload_0
    //   113: getfield 21	bcfa:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   116: invokevirtual 124	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   119: aload_1
    //   120: invokevirtual 130	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   123: astore_1
    //   124: goto -79 -> 45
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   132: ldc 120
    //   134: areturn
    //   135: aload_3
    //   136: invokevirtual 131	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aload_1
    //   141: invokevirtual 117	java/io/InputStream:close	()V
    //   144: aload_2
    //   145: invokevirtual 118	java/io/BufferedReader:close	()V
    //   148: aload_3
    //   149: areturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: areturn
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   162: ldc 120
    //   164: areturn
    //   165: astore_3
    //   166: aload_1
    //   167: invokevirtual 117	java/io/InputStream:close	()V
    //   170: aload_2
    //   171: invokevirtual 118	java/io/BufferedReader:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	bcfa
    //   0	184	1	paramString	String
    //   33	75	2	localObject1	Object
    //   111	60	2	localFileNotFoundException	java.io.FileNotFoundException
    //   68	13	3	localStringBuffer	java.lang.StringBuffer
    //   90	46	3	localIOException	java.io.IOException
    //   139	17	3	str1	String
    //   165	10	3	localObject2	Object
    //   73	9	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   69	75	90	java/io/IOException
    //   80	87	90	java/io/IOException
    //   135	140	90	java/io/IOException
    //   0	34	111	java/io/FileNotFoundException
    //   34	43	111	java/io/FileNotFoundException
    //   112	124	127	java/io/IOException
    //   140	148	150	java/io/IOException
    //   95	103	157	java/io/IOException
    //   69	75	165	finally
    //   80	87	165	finally
    //   91	95	165	finally
    //   135	140	165	finally
    //   166	174	176	java/io/IOException
  }
  
  protected void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      ThreadManager.executeOnSubThread(new OpenConfig.1(this));
    }
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 23	bcfa:b	Ljava/lang/String;
    //   9: ifnull +30 -> 39
    //   12: new 73	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   19: aload_1
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 80
    //   25: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 23	bcfa:b	Ljava/lang/String;
    //   32: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 21	bcfa:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 148	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   48: astore_1
    //   49: new 150	java/io/OutputStreamWriter
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 153	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 157	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokevirtual 160	java/io/OutputStreamWriter:flush	()V
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 163	java/io/FileOutputStream:close	()V
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 164	java/io/OutputStreamWriter:close	()V
    //   83: return
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: aload_2
    //   91: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   94: goto -27 -> 67
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   102: goto -27 -> 75
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   110: return
    //   111: astore_2
    //   112: aload 4
    //   114: astore_3
    //   115: goto -25 -> 90
    //   118: astore_2
    //   119: goto -29 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	bcfa
    //   0	122	1	paramString1	String
    //   0	122	2	paramString2	String
    //   4	111	3	localObject1	Object
    //   1	112	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	39	84	java/io/IOException
    //   39	49	84	java/io/IOException
    //   71	75	97	java/io/IOException
    //   79	83	105	java/io/IOException
    //   49	58	111	java/io/IOException
    //   58	67	118	java/io/IOException
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    a("com.tencent.open.config.json", paramJSONObject.toString());
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public boolean a(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
  
  public String b(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.b);
    localBundle.putString("appid_for_getting_config", this.b);
    localBundle.putString("status_os", Build.VERSION.RELEASE);
    localBundle.putString("status_machine", Build.MODEL);
    localBundle.putString("status_brand", Build.BRAND);
    localBundle.putString("status_version", Build.VERSION.SDK);
    localBundle.putString("sdkv", "1.5");
    localBundle.putString("sdkp", "a");
    localBundle.putString("blacklist_logic_version", String.valueOf(1));
    localBundle.putString("yyb_version", String.valueOf(bcev.a("com.tencent.android.qqdownloader")));
    localBundle.putString("qq_version", String.valueOf(GlobalUtil.getAppVersionCode(bbtm.a().a())));
    ThreadManager.executeOnNetWorkThread(new OpenConfig.2(this, localBundle));
  }
  
  public boolean b(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {
      return true;
    }
    if ((paramString instanceof Integer))
    {
      if (!paramString.equals(Integer.valueOf(0))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  protected void c()
  {
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("Common_frequency");
    int i = j;
    if (j == 0) {
      i = 1;
    }
    long l = i * 3600000;
    if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long >= l) {
      b();
    }
  }
  
  public boolean c(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcfa
 * JD-Core Version:    0.7.0.1
 */