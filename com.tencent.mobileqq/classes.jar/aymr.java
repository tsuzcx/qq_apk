import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aymr
  implements ISkinTint
{
  private bbqp jdField_a_of_type_Bbqp = new ayms(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private JSONObject b;
  
  private Integer a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = this.b.optString(paramString);
    } while (TextUtils.isEmpty(paramString));
    try
    {
      int i = Color.parseColor(paramString);
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
    if (paramJSONObject2 == null)
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
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new JSONObject(paramString1);
        this.jdField_a_of_type_OrgJsonJSONObject = paramString1.optJSONObject("mapping");
        this.b = paramString1.optJSONObject("plate");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
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
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
        }
        if (this.b == null) {
          this.b = new JSONObject();
        }
        a(this.jdField_a_of_type_OrgJsonJSONObject, paramString2);
        a(this.b, localJSONObject);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected boolean a(Paint paramPaint, String paramString)
  {
    Object localObject;
    if (this.b != null)
    {
      localObject = a(paramString);
      if ((localObject != null) && (paramPaint != null)) {
        paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
      }
    }
    int i;
    do
    {
      return true;
      localObject = BaseApplication.getContext();
      if ((localObject == null) || (!paramString.contains(".xml"))) {
        break;
      }
      paramString = paramString.replace(".xml", "");
      i = BaseApplication.getContext().getResources().getIdentifier(paramString, "color", ((Context)localObject).getPackageName());
      if (i <= 0) {
        break;
      }
      localObject = Integer.valueOf(SkinEngine.getInstances().getColor(i));
      if ((localObject == null) || (paramPaint == null)) {
        break;
      }
      paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
    } while (!QLog.isColorLevel());
    QLog.i("TintManager", 1, " skin_bar_textcolorName:" + paramString + " colorId:" + i + " rgbColor:" + Integer.toString(16777215 - ((Integer)localObject).intValue(), 16) + " " + Integer.toHexString(16777215 - ((Integer)localObject).intValue()) + " " + localObject);
    return true;
    return false;
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
  public void loadConfig(Resources paramResources, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 254	aymr:clear	()V
    //   4: aload_0
    //   5: aload_2
    //   6: putfield 66	aymr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: getstatic 259	bbtk:a	Lbbtk;
    //   12: invokestatic 262	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc_w 264
    //   18: invokevirtual 268	bbtk:getSavePath	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +17 -> 43
    //   29: new 270	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: invokevirtual 274	java/io/File:exists	()Z
    //   40: ifne +29 -> 69
    //   43: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +12 -> 58
    //   49: ldc 206
    //   51: iconst_2
    //   52: ldc_w 276
    //   55: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: getstatic 281	bbtl:a	Lbbtl;
    //   61: aload_0
    //   62: getfield 30	aymr:jdField_a_of_type_Bbqp	Lbbqp;
    //   65: invokevirtual 284	bbtl:a	(Lbbqp;)V
    //   68: return
    //   69: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +29 -> 101
    //   75: ldc 206
    //   77: iconst_2
    //   78: new 208	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 286
    //   88: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_2
    //   102: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +292 -> 397
    //   108: aload_1
    //   109: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +285 -> 397
    //   115: new 288	java/io/InputStreamReader
    //   118: dup
    //   119: new 290	java/io/FileInputStream
    //   122: dup
    //   123: new 270	java/io/File
    //   126: dup
    //   127: aload_1
    //   128: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: invokespecial 293	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   134: invokespecial 296	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   137: astore 4
    //   139: aload 4
    //   141: astore_1
    //   142: new 298	java/io/BufferedReader
    //   145: dup
    //   146: aload 4
    //   148: invokespecial 301	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   151: astore 5
    //   153: aload 4
    //   155: astore_1
    //   156: new 208	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   163: astore 6
    //   165: aload 4
    //   167: astore_1
    //   168: aload 5
    //   170: invokevirtual 304	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   173: astore 7
    //   175: aload 7
    //   177: ifnull +55 -> 232
    //   180: aload 4
    //   182: astore_1
    //   183: aload 6
    //   185: aload 7
    //   187: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: goto -26 -> 165
    //   194: astore_1
    //   195: aload 4
    //   197: astore_2
    //   198: aload_1
    //   199: astore 4
    //   201: aload_2
    //   202: astore_1
    //   203: ldc 206
    //   205: iconst_1
    //   206: aload 4
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   215: aload_2
    //   216: ifnull +181 -> 397
    //   219: aload_2
    //   220: invokevirtual 311	java/io/InputStreamReader:close	()V
    //   223: return
    //   224: astore_1
    //   225: return
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   231: return
    //   232: ldc 167
    //   234: astore 5
    //   236: aload 4
    //   238: astore_1
    //   239: new 270	java/io/File
    //   242: dup
    //   243: aload_2
    //   244: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore_2
    //   248: aload 4
    //   250: astore_1
    //   251: aload 6
    //   253: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore 6
    //   258: aload 4
    //   260: astore_1
    //   261: aload_2
    //   262: invokevirtual 274	java/io/File:exists	()Z
    //   265: ifeq +57 -> 322
    //   268: aload 4
    //   270: astore_1
    //   271: aload_2
    //   272: invokevirtual 315	java/io/File:isFile	()Z
    //   275: ifeq +47 -> 322
    //   278: aload 4
    //   280: astore_1
    //   281: aload_2
    //   282: invokestatic 320	bbdx:a	(Ljava/io/File;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload 4
    //   288: astore_1
    //   289: aload 6
    //   291: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifeq +63 -> 357
    //   297: aload 4
    //   299: astore_1
    //   300: aload_2
    //   301: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: istore_3
    //   305: iload_3
    //   306: ifeq +51 -> 357
    //   309: aload 4
    //   311: ifnull +86 -> 397
    //   314: aload 4
    //   316: invokevirtual 311	java/io/InputStreamReader:close	()V
    //   319: return
    //   320: astore_1
    //   321: return
    //   322: aload 4
    //   324: astore_1
    //   325: ldc 206
    //   327: iconst_1
    //   328: ldc_w 322
    //   331: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload 5
    //   336: astore_2
    //   337: goto -51 -> 286
    //   340: astore 4
    //   342: aload_1
    //   343: astore_2
    //   344: aload 4
    //   346: astore_1
    //   347: aload_2
    //   348: ifnull +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 311	java/io/InputStreamReader:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: aload 4
    //   359: astore_1
    //   360: aload_0
    //   361: aload 6
    //   363: aload_2
    //   364: invokevirtual 326	aymr:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 4
    //   369: ifnull +28 -> 397
    //   372: aload 4
    //   374: invokevirtual 311	java/io/InputStreamReader:close	()V
    //   377: return
    //   378: astore_1
    //   379: return
    //   380: astore_2
    //   381: goto -26 -> 355
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_2
    //   387: goto -40 -> 347
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_2
    //   394: goto -193 -> 201
    //   397: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	aymr
    //   0	398	1	paramResources	Resources
    //   0	398	2	paramString	String
    //   304	2	3	bool	boolean
    //   137	186	4	localObject1	Object
    //   340	33	4	localObject2	Object
    //   390	1	4	localException	java.lang.Exception
    //   151	184	5	localObject3	Object
    //   163	199	6	localObject4	Object
    //   173	13	7	str	String
    // Exception table:
    //   from	to	target	type
    //   142	153	194	java/lang/Exception
    //   156	165	194	java/lang/Exception
    //   168	175	194	java/lang/Exception
    //   183	191	194	java/lang/Exception
    //   239	248	194	java/lang/Exception
    //   251	258	194	java/lang/Exception
    //   261	268	194	java/lang/Exception
    //   271	278	194	java/lang/Exception
    //   281	286	194	java/lang/Exception
    //   289	297	194	java/lang/Exception
    //   300	305	194	java/lang/Exception
    //   325	334	194	java/lang/Exception
    //   360	367	194	java/lang/Exception
    //   219	223	224	java/io/IOException
    //   9	43	226	java/lang/Exception
    //   43	58	226	java/lang/Exception
    //   58	68	226	java/lang/Exception
    //   69	101	226	java/lang/Exception
    //   314	319	320	java/io/IOException
    //   142	153	340	finally
    //   156	165	340	finally
    //   168	175	340	finally
    //   183	191	340	finally
    //   203	215	340	finally
    //   239	248	340	finally
    //   251	258	340	finally
    //   261	268	340	finally
    //   271	278	340	finally
    //   281	286	340	finally
    //   289	297	340	finally
    //   300	305	340	finally
    //   325	334	340	finally
    //   360	367	340	finally
    //   372	377	378	java/io/IOException
    //   351	355	380	java/io/IOException
    //   115	139	384	finally
    //   115	139	390	java/lang/Exception
  }
  
  public void tint(Paint paramPaint, String paramString)
  {
    int j = 0;
    if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (paramPaint == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    label96:
    String str2;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TintManager", 2, " fileName:" + paramString);
      }
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            break label96;
          }
          if (paramString.equals(this.jdField_a_of_type_OrgJsonJSONArray.optString(i))) {
            break;
          }
          i += 1;
        }
      }
      str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
    } while (TextUtils.isEmpty(str2));
    if (paramString.contains(".")) {}
    for (String str1 = paramString.split("\\.")[0];; str1 = paramString)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null)
      {
        i = BaseApplication.getContext().getResources().getIdentifier(str1, "drawable", localBaseApplication.getPackageName());
        if ((i > 0) && (SkinEngine.getInstances().checkResExist(i)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TintManager", 2, "checkResExist fileName:" + paramString);
          return;
        }
      }
      if (str2.contains(","))
      {
        paramString = str2.split("\\,");
        int k = paramString.length;
        i = j;
        while ((i < k) && (!a(paramPaint, paramString[i]))) {
          i += 1;
        }
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TintManager", 2, "plateName:" + str2 + " fileName:" + paramString);
      }
      a(paramPaint, str2);
      return;
    }
  }
  
  public void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString)
  {
    int i = 0;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramArrayOfInt1 = this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
      if (paramArrayOfInt1.contains(","))
      {
        paramArrayOfInt1 = paramArrayOfInt1.split("\\,");
        while (i < paramArrayOfInt1.length)
        {
          a(paramArrayOfInt, i, a(paramArrayOfInt1[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(paramArrayOfInt1)) {
        a(paramArrayOfInt, 0, a(paramArrayOfInt1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymr
 * JD-Core Version:    0.7.0.1
 */