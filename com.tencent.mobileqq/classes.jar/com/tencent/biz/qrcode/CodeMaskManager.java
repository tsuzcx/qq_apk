package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CodeMaskManager
{
  private static final String jdField_a_of_type_JavaLangString;
  protected int a;
  protected Activity a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected Handler a;
  protected Thread a;
  protected List<Bundle> a;
  protected boolean a;
  protected int b;
  protected List<Bundle> b;
  
  static
  {
    if (SystemUtil.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("qbiz/qrcode/");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/qbiz/qrcode/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public CodeMaskManager(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaUtilList = new Vector();
    a(paramInt);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    b(a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
    int i = 0;
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
      if (localObject == null) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("tpls");
      if (localJSONArray.length() > 0)
      {
        a(localJSONArray);
        i = ((JSONObject)localObject).getInt("t");
      }
      return i;
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 1)
    {
      int j = 0;
      int i;
      if (paramInt == 1)
      {
        i = j;
      }
      else if (this.jdField_a_of_type_Int == -1)
      {
        int k = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
        i = j;
        if (k >= 0) {
          if (k >= paramInt) {
            i = j;
          } else {
            i = k;
          }
        }
      }
      else
      {
        double d1 = Math.random();
        double d2 = paramInt - 1;
        Double.isNaN(d2);
        paramInt = (int)(d1 * d2);
        i = paramInt;
        if (paramInt >= this.jdField_a_of_type_Int) {
          i = paramInt + 1;
        }
      }
      this.jdField_b_of_type_Int = i;
      return this.jdField_b_of_type_Int;
    }
    throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
  }
  
  /* Error */
  private Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull +324 -> 327
    //   6: aload_1
    //   7: ldc 170
    //   9: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_1
    //   18: astore 6
    //   20: aload_1
    //   21: ldc 178
    //   23: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   26: ifne +42 -> 68
    //   29: aload_1
    //   30: astore 6
    //   32: aload_1
    //   33: ldc 184
    //   35: invokevirtual 182	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   38: ifne +30 -> 68
    //   41: new 24	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc 186
    //   52: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: aload_1
    //   58: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: invokestatic 192	com/tencent/mobileqq/transfile/AbsDownloader:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 7
    //   75: new 24	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic 44	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: aload 7
    //   94: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 194	java/io/FileInputStream
    //   101: dup
    //   102: aload_1
    //   103: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 195	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   109: astore_1
    //   110: new 197	java/io/BufferedInputStream
    //   113: dup
    //   114: aload_1
    //   115: sipush 8192
    //   118: invokespecial 200	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   121: astore 5
    //   123: aload_1
    //   124: astore_2
    //   125: aload 5
    //   127: astore 4
    //   129: aload 5
    //   131: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   134: astore_3
    //   135: aload 5
    //   137: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   140: aload_1
    //   141: invokevirtual 210	java/io/FileInputStream:close	()V
    //   144: aload_3
    //   145: astore_1
    //   146: goto +90 -> 236
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: aload 5
    //   154: astore_1
    //   155: aload_2
    //   156: astore 5
    //   158: goto +30 -> 188
    //   161: astore_3
    //   162: goto +144 -> 306
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_1
    //   170: astore_3
    //   171: aload_2
    //   172: astore_1
    //   173: goto +15 -> 188
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_1
    //   179: goto +127 -> 306
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_3
    //   187: astore_1
    //   188: aload_3
    //   189: astore_2
    //   190: aload_1
    //   191: astore 4
    //   193: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +19 -> 215
    //   199: aload_3
    //   200: astore_2
    //   201: aload_1
    //   202: astore 4
    //   204: ldc 217
    //   206: iconst_2
    //   207: aload 5
    //   209: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_1
    //   216: ifnull +10 -> 226
    //   219: aload_1
    //   220: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   223: goto +3 -> 226
    //   226: aload_3
    //   227: ifnull +7 -> 234
    //   230: aload_3
    //   231: invokevirtual 210	java/io/FileInputStream:close	()V
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +5 -> 242
    //   240: aload_1
    //   241: areturn
    //   242: aload_0
    //   243: getfield 72	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   246: ldc 226
    //   248: aload 6
    //   250: invokestatic 231	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: ldc 233
    //   255: aconst_null
    //   256: aconst_null
    //   257: invokestatic 239	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull +11 -> 273
    //   265: aload_2
    //   266: iconst_0
    //   267: aload_2
    //   268: arraylength
    //   269: invokestatic 243	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +13 -> 287
    //   277: aload_0
    //   278: aload 7
    //   280: aload_2
    //   281: invokespecial 246	com/tencent/biz/qrcode/CodeMaskManager:a	(Ljava/lang/String;[B)Z
    //   284: pop
    //   285: aload_1
    //   286: areturn
    //   287: new 168	java/io/IOException
    //   290: dup
    //   291: ldc 247
    //   293: invokestatic 252	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   296: invokespecial 253	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   299: athrow
    //   300: astore_3
    //   301: aload_2
    //   302: astore_1
    //   303: aload 4
    //   305: astore_2
    //   306: aload_2
    //   307: ifnull +10 -> 317
    //   310: aload_2
    //   311: invokevirtual 209	java/io/BufferedInputStream:close	()V
    //   314: goto +3 -> 317
    //   317: aload_1
    //   318: ifnull +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 210	java/io/FileInputStream:close	()V
    //   325: aload_3
    //   326: athrow
    //   327: aconst_null
    //   328: areturn
    //   329: astore_2
    //   330: goto -190 -> 140
    //   333: astore_1
    //   334: aload_3
    //   335: astore_1
    //   336: goto -100 -> 236
    //   339: astore_1
    //   340: goto -114 -> 226
    //   343: astore_1
    //   344: goto -110 -> 234
    //   347: astore_2
    //   348: goto -31 -> 317
    //   351: astore_1
    //   352: goto -27 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	CodeMaskManager
    //   0	355	1	paramString	String
    //   1	124	2	str1	String
    //   149	7	2	localException1	Exception
    //   168	143	2	localObject1	Object
    //   329	1	2	localIOException1	java.io.IOException
    //   347	1	2	localIOException2	java.io.IOException
    //   48	104	3	localObject2	Object
    //   161	1	3	localObject3	Object
    //   170	1	3	str2	String
    //   176	1	3	localObject4	Object
    //   185	46	3	localObject5	Object
    //   300	35	3	localObject6	Object
    //   127	177	4	localObject7	Object
    //   121	36	5	localObject8	Object
    //   165	1	5	localException2	Exception
    //   182	26	5	localException3	Exception
    //   18	231	6	str3	String
    //   73	206	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   129	135	149	java/lang/Exception
    //   110	123	161	finally
    //   110	123	165	java/lang/Exception
    //   75	110	176	finally
    //   75	110	182	java/lang/Exception
    //   129	135	300	finally
    //   193	199	300	finally
    //   204	215	300	finally
    //   135	140	329	java/io/IOException
    //   140	144	333	java/io/IOException
    //   219	223	339	java/io/IOException
    //   230	234	343	java/io/IOException
    //   310	314	347	java/io/IOException
    //   321	325	351	java/io/IOException
  }
  
  private Bundle a()
  {
    int i = a(this.jdField_b_of_type_JavaUtilList.size());
    return a((Bundle)this.jdField_b_of_type_JavaUtilList.get(i));
  }
  
  private Bundle a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i == 0) {}
    }
    try
    {
      paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
        return (Bundle)paramBundle.clone();
        localOutOfMemoryError1 = localOutOfMemoryError1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label97;
      }
    }
    if (paramBundle.containsKey("qrbkgRes"))
    {
      i = paramBundle.getInt("qrbkgRes");
      paramBundle.remove("qrbkg");
      if (i == 0) {}
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 1)
    {
      localBundle.putInt("qrbkgRes", 2130843388);
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", 0);
      localBundle.putInt("W", -1);
      localBundle.putParcelable("qrloc", new Rect(126, 156, 413, 443));
      localBundle.putInt("head", 0);
      localBundle.putInt("type", 1);
    }
    else
    {
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", -16777216);
      localBundle.putInt("W", 16777215);
      localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      localBundle.putInt("head", 1);
      localBundle.putInt("type", 1);
    }
    this.jdField_b_of_type_JavaUtilList.add(localBundle);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    String str3 = "qrbkg";
    String str2 = "tipsClr";
    String str1 = "nameClr";
    Object localObject1 = "bkg";
    localObject3 = "qrsz";
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new Vector(this.jdField_b_of_type_JavaUtilList);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      for (;;)
      {
        label267:
        label531:
        label799:
        try
        {
          localJSONObject = paramJSONArray.getJSONObject(i);
          localBundle = new Bundle();
          if (localJSONObject.has((String)localObject1)) {
            localBundle.putString("bkgUrl", localJSONObject.getString((String)localObject1));
          }
          localObject4 = localJSONObject.getString(str1);
        }
        catch (JSONException localJSONException3)
        {
          JSONObject localJSONObject;
          Bundle localBundle;
          Object localObject4;
          JSONArray localJSONArray1;
          int k;
          int m;
          int n;
          ArrayList localArrayList;
          JSONArray localJSONArray2;
          int i1;
          label683:
          continue;
        }
        for (;;)
        {
          try
          {
            localBundle.putInt(str1, (int)Long.parseLong((String)localObject4, 16));
            localBundle.putInt(str2, (int)Long.parseLong(localJSONObject.getString(str2), 16));
            if (localJSONObject.has(str3)) {
              localBundle.putString("qrbkgUrl", localJSONObject.getString(str3));
            }
            if (!localJSONObject.has("qrloc")) {
              continue;
            }
            localJSONArray1 = localJSONObject.getJSONArray("qrloc");
          }
          catch (JSONException localJSONException4)
          {
            label659:
            break label772;
            label772:
            Object localObject2;
            break label267;
            Exception localException2 = localException1;
            localObject5 = localObject3;
            break label531;
            j = 0;
            break label683;
          }
          try
          {
            j = localJSONArray1.getInt(0);
          }
          catch (JSONException localJSONException5)
          {
            break label772;
          }
        }
        try
        {
          k = localJSONArray1.getInt(1);
          m = localJSONArray1.getInt(0);
          n = localJSONArray1.getInt(2);
          localObject5 = localObject1;
          localObject4 = localObject3;
        }
        catch (JSONException localJSONException6)
        {
          continue;
        }
        try
        {
          localBundle.putParcelable("qrloc", new Rect(j, k, m + n, localJSONArray1.getInt(1) + localJSONArray1.getInt(3)));
          localObject5 = localObject1;
          localObject4 = localObject3;
          if (localJSONObject.has((String)localObject3))
          {
            localObject5 = localObject1;
            localObject4 = localObject3;
            localBundle.putInt((String)localObject3, localJSONObject.getInt((String)localObject3));
          }
          localObject5 = localObject1;
          localObject4 = localObject3;
          if (!localJSONObject.has("clip")) {
            break label870;
          }
          localObject5 = localObject1;
          localObject4 = localObject3;
          localArrayList = new ArrayList();
          localObject5 = localObject1;
          localObject4 = localObject3;
          localJSONArray1 = localJSONObject.getJSONArray("clip");
          j = 0;
          localObject5 = localObject1;
          localObject4 = localObject3;
          if (j < localJSONArray1.length())
          {
            localObject5 = localObject1;
            localObject4 = localObject3;
            localJSONArray2 = localJSONArray1.getJSONArray(j);
            localObject5 = localObject1;
            localObject4 = localObject3;
            k = localJSONArray2.getInt(0);
            localObject4 = localObject1;
          }
        }
        catch (JSONException localJSONException1)
        {
          localObject2 = localObject5;
          localObject3 = localJSONException6;
          continue;
        }
        try
        {
          m = localJSONArray2.getInt(1);
          n = localJSONArray2.getInt(0);
          i1 = localJSONArray2.getInt(2);
          localObject5 = localObject3;
          localObject3 = localObject4;
          localObject1 = localObject5;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        try
        {
          localArrayList.add(new Rect(k, m, n + i1, localJSONArray2.getInt(1) + localJSONArray2.getInt(3)));
          j += 1;
          localObject1 = localObject4;
          localObject3 = localObject5;
        }
        catch (JSONException localJSONException7) {}
      }
      localObject4 = localObject1;
      localObject5 = localObject3;
      localObject3 = localObject4;
      localObject1 = localObject5;
      localBundle.putParcelableArrayList("clip", localArrayList);
      localObject3 = localObject4;
      localObject1 = localObject5;
      localBundle.putInt("B", (int)Long.parseLong(localJSONObject.getString("B"), 16));
      localObject3 = localObject4;
      localObject1 = localObject5;
      if (localJSONObject.has("W"))
      {
        localObject3 = localObject4;
        localObject1 = localObject5;
        localBundle.putInt("W", (int)Long.parseLong(localJSONObject.getString("W"), 16));
      }
      else
      {
        localObject3 = localObject4;
        localObject1 = localObject5;
        localBundle.putInt("W", 16777215);
      }
      localObject3 = localObject4;
      localObject1 = localObject5;
      try
      {
        localBundle.putInt("head", localJSONObject.getInt("head"));
      }
      catch (Exception localException1)
      {
        break label659;
      }
      localObject3 = localObject4;
      localObject1 = localObject5;
      if (!localJSONObject.getBoolean("head")) {
        break label881;
      }
      j = 1;
      localObject3 = localObject4;
      localObject1 = localObject5;
      localBundle.putInt("head", j);
      localObject3 = localObject4;
      localObject1 = localObject5;
      localBundle.putInt("v", localJSONObject.getInt("v"));
      localObject3 = localObject4;
      localObject1 = localObject5;
      localBundle.putInt("type", 2);
      localObject3 = localObject4;
      localObject1 = localObject5;
      this.jdField_a_of_type_JavaUtilList.add(localBundle);
      localObject3 = localObject4;
      localObject1 = localObject5;
      break label799;
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      break label799;
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  /* Error */
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +122 -> 123
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_3
    //   9: new 58	java/io/File
    //   12: dup
    //   13: getstatic 44	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 393	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 24	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   30: astore 5
    //   32: aload 5
    //   34: getstatic 44	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: aload_1
    //   44: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 58	java/io/File
    //   51: dup
    //   52: aload 5
    //   54: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 396	java/io/File:exists	()Z
    //   65: ifne +8 -> 73
    //   68: aload_1
    //   69: invokevirtual 399	java/io/File:createNewFile	()Z
    //   72: pop
    //   73: new 401	java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 404	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore_1
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 408	java/io/FileOutputStream:write	([B)V
    //   87: aload_1
    //   88: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_2
    //   94: aload_1
    //   95: astore_3
    //   96: aload_2
    //   97: astore_1
    //   98: goto +7 -> 105
    //   101: goto +14 -> 115
    //   104: astore_1
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   113: aload_1
    //   114: athrow
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_1
    //   126: aload 4
    //   128: astore_1
    //   129: goto -14 -> 115
    //   132: astore_2
    //   133: goto -32 -> 101
    //   136: astore_1
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_2
    //   140: goto -27 -> 113
    //   143: astore_1
    //   144: iconst_0
    //   145: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	CodeMaskManager
    //   0	146	1	paramString	String
    //   0	146	2	paramArrayOfByte	byte[]
    //   8	102	3	str	String
    //   5	122	4	localObject	Object
    //   30	23	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   82	87	93	finally
    //   9	73	104	finally
    //   73	82	104	finally
    //   9	73	125	java/io/IOException
    //   73	82	125	java/io/IOException
    //   82	87	132	java/io/IOException
    //   87	91	136	java/io/IOException
    //   109	113	139	java/io/IOException
    //   119	123	143	java/io/IOException
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).edit();
    localEditor.putInt("lastIndex", this.jdField_a_of_type_Int);
    localEditor.commit();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0);
    long l = localSharedPreferences.getLong("updateTemplate2", 0L);
    if (System.currentTimeMillis() - l < 86400000L) {
      return;
    }
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getHeight();
    this.jdField_a_of_type_JavaLangThread = new CodeMaskManager.1(this, "qr_code_mask_update_extenal_thread", localSharedPreferences, localDisplay.getWidth(), i, paramInt);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Bundle)localIterator.next();
      Bitmap localBitmap = (Bitmap)((Bundle)localObject).getParcelable("bkg");
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      localObject = (Bitmap)((Bundle)localObject).getParcelable("qrbkg");
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(CodeMaskManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = 0;
    if (paramBoolean3)
    {
      new Bundle();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("bkgRes", 0);
      ((Bundle)localObject).putInt("nameClr", -16777216);
      ((Bundle)localObject).putInt("tipsClr", -8947849);
      ((Bundle)localObject).putInt("W", 16777215);
      ((Bundle)localObject).putInt("B", -16777216);
      ((Bundle)localObject).putInt("head", 0);
      ((Bundle)localObject).putInt("type", 1);
      paramCallback.a(a((Bundle)localObject));
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.jdField_a_of_type_AndroidOsBundle.putInt("W", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("B", -9947128);
        if (paramInt == 2) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 3);
        } else if (paramInt == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 4);
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("type", 1);
      }
      paramCallback.a(a(this.jdField_a_of_type_AndroidOsBundle));
      return;
    }
    int j = a(this.jdField_a_of_type_JavaUtilList.size());
    paramInt = i;
    if (j >= 0) {
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        paramInt = i;
      } else {
        paramInt = j;
      }
    }
    Object localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      paramCallback.a(a((Bundle)localObject));
      b();
      return;
    }
    localObject = new CodeMaskManager.PrepareBundleTask(this, paramCallback, (Bundle)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CodeMaskManager.2(this, (CodeMaskManager.PrepareBundleTask)localObject, paramCallback), 10000L);
    ((CodeMaskManager.PrepareBundleTask)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager
 * JD-Core Version:    0.7.0.1
 */