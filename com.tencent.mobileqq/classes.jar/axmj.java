import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.theme.ISkinTint;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axmj
  implements ISkinTint
{
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private JSONObject b;
  
  private Integer a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = this.b.optString(paramString);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Color.parseColor(paramString);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int[] paramArrayOfInt, int paramInt, Integer paramInteger)
  {
    if ((paramInteger != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > paramInt)) {
      paramArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject;
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = paramJSONObject2.keys();
    for (;;)
    {
      localObject = paramJSONObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      if (paramJSONObject1.optString((String)localObject) != null)
      {
        String str = paramJSONObject2.optString((String)localObject);
        try
        {
          paramJSONObject1.putOpt((String)localObject, str);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      this.jdField_a_of_type_OrgJsonJSONObject = paramString1.optJSONObject("mapping");
      this.b = paramString1.optJSONObject("plate");
      paramString1 = new JSONObject(paramString2);
      paramString2 = paramString1.optJSONObject("mapping");
      JSONObject localJSONObject = paramString1.optJSONObject("plate");
      this.jdField_a_of_type_OrgJsonJSONArray = paramString1.optJSONArray("forbidden");
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_OrgJsonJSONArray.optString(i), Boolean.valueOf(true));
          i += 1;
        }
      }
      a(this.jdField_a_of_type_OrgJsonJSONObject, paramString2);
      a(this.b, localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected boolean a(Paint paramPaint, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.b.optString(paramString)))
      {
        paramString = a(paramString);
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramPaint != null)
          {
            paramPaint.setColorFilter(new LightingColorFilter(0, paramString.intValue()));
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void clear()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.b = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public boolean isTint(String paramString)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    while ((this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) || (this.jdField_a_of_type_OrgJsonJSONObject == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString)))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public void loadConfig(android.content.res.Resources paramResources, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 154	axmj:clear	()V
    //   4: aload_2
    //   5: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 156	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 160	java/io/File:exists	()Z
    //   25: ifeq -14 -> 11
    //   28: aload_3
    //   29: invokevirtual 163	java/io/File:isFile	()Z
    //   32: ifeq -21 -> 11
    //   35: new 165	java/io/InputStreamReader
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual 171	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   43: ldc 173
    //   45: invokevirtual 179	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: invokespecial 182	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: new 184	java/io/BufferedReader
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 187	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore 5
    //   64: aload_2
    //   65: astore_1
    //   66: new 189	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aload_2
    //   76: astore_1
    //   77: aload 5
    //   79: invokevirtual 194	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnull +34 -> 120
    //   89: aload_2
    //   90: astore_1
    //   91: aload 4
    //   93: aload 6
    //   95: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: goto -24 -> 75
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   109: aload_2
    //   110: ifnull -99 -> 11
    //   113: aload_2
    //   114: invokevirtual 202	java/io/InputStreamReader:close	()V
    //   117: return
    //   118: astore_1
    //   119: return
    //   120: aload_2
    //   121: astore_1
    //   122: aload_3
    //   123: invokestatic 207	bace:a	(Ljava/io/File;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +26 -> 154
    //   131: aload_2
    //   132: astore_1
    //   133: aload_0
    //   134: aload 4
    //   136: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_3
    //   140: invokevirtual 212	axmj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_2
    //   144: ifnull -133 -> 11
    //   147: aload_2
    //   148: invokevirtual 202	java/io/InputStreamReader:close	()V
    //   151: return
    //   152: astore_1
    //   153: return
    //   154: aload_2
    //   155: astore_1
    //   156: ldc 214
    //   158: iconst_1
    //   159: ldc 216
    //   161: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto -21 -> 143
    //   167: astore_3
    //   168: aload_1
    //   169: astore_2
    //   170: aload_3
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 202	java/io/InputStreamReader:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: goto -3 -> 180
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_2
    //   189: goto -17 -> 172
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: goto -92 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	axmj
    //   0	198	1	paramResources	android.content.res.Resources
    //   0	198	2	paramString	String
    //   20	9	3	localFile	java.io.File
    //   102	21	3	localException1	java.lang.Exception
    //   126	14	3	str1	String
    //   167	4	3	localObject	Object
    //   192	1	3	localException2	java.lang.Exception
    //   73	62	4	localStringBuilder	java.lang.StringBuilder
    //   62	16	5	localBufferedReader	java.io.BufferedReader
    //   82	12	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   54	64	102	java/lang/Exception
    //   66	75	102	java/lang/Exception
    //   77	84	102	java/lang/Exception
    //   91	99	102	java/lang/Exception
    //   122	127	102	java/lang/Exception
    //   133	143	102	java/lang/Exception
    //   156	164	102	java/lang/Exception
    //   113	117	118	java/io/IOException
    //   147	151	152	java/io/IOException
    //   54	64	167	finally
    //   66	75	167	finally
    //   77	84	167	finally
    //   91	99	167	finally
    //   105	109	167	finally
    //   122	127	167	finally
    //   133	143	167	finally
    //   156	164	167	finally
    //   176	180	182	java/io/IOException
    //   35	52	186	finally
    //   35	52	192	java/lang/Exception
  }
  
  public void tint(Paint paramPaint, String paramString)
  {
    int j = 0;
    if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (paramPaint == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            break label64;
          }
          if (paramString.equals(this.jdField_a_of_type_OrgJsonJSONArray.optString(i))) {
            break;
          }
          i += 1;
        }
      }
      label64:
      paramString = this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        if (!paramString.contains(",")) {
          break;
        }
        paramString = paramString.split(",");
        int k = paramString.length;
        i = j;
        while ((i < k) && (!a(paramPaint, paramString[i]))) {
          i += 1;
        }
      }
    }
    a(paramPaint, paramString);
  }
  
  public void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString)
  {
    int i = 0;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      paramArrayOfInt1 = this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
      if (paramArrayOfInt1.contains(","))
      {
        paramArrayOfInt1 = paramArrayOfInt1.split(",");
        while (i < paramArrayOfInt1.length)
        {
          a(paramArrayOfInt, i, a(paramArrayOfInt1[i]));
          i += 1;
        }
      }
      a(paramArrayOfInt, 0, a(paramArrayOfInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmj
 * JD-Core Version:    0.7.0.1
 */