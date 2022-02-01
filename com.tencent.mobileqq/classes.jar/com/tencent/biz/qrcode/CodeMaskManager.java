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
import zjn;

public class CodeMaskManager
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
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
    if (SystemUtil.isExistSDCard())
    {
      jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "qbiz/qrcode/";
      return;
    }
  }
  
  public CodeMaskManager(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaUtilList = new Vector();
    a(paramInt);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    b(a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
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
        int i = ((JSONObject)localObject).getInt("t");
        return i;
      }
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    if (paramInt < 1) {
      throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
    }
    if (paramInt == 1) {
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int == -1)
      {
        int j = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
        if (j >= 0)
        {
          i = j;
          if (j < paramInt) {}
        }
        else
        {
          i = 0;
        }
        paramInt = i;
      }
      else
      {
        i = (int)(Math.random() * (paramInt - 1));
        paramInt = i;
        if (i >= this.jdField_a_of_type_Int) {
          paramInt = i + 1;
        }
      }
    }
  }
  
  /* Error */
  private Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: ldc 163
    //   10: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +7 -> 20
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_1
    //   21: astore 6
    //   23: aload_1
    //   24: ldc 171
    //   26: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   29: ifne +36 -> 65
    //   32: aload_1
    //   33: astore 6
    //   35: aload_1
    //   36: ldc 177
    //   38: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   41: ifne +24 -> 65
    //   44: new 25	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   51: ldc 179
    //   53: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 6
    //   65: aload 6
    //   67: invokestatic 185	com/tencent/mobileqq/transfile/AbsDownloader:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 7
    //   72: new 187	java/io/FileInputStream
    //   75: dup
    //   76: new 25	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   83: getstatic 45	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 7
    //   91: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   100: astore_2
    //   101: new 190	java/io/BufferedInputStream
    //   104: dup
    //   105: aload_2
    //   106: sipush 8192
    //   109: invokespecial 193	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   112: astore_1
    //   113: aload_1
    //   114: astore 4
    //   116: aload_2
    //   117: astore_3
    //   118: aload_1
    //   119: invokestatic 199	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   122: astore 5
    //   124: aload 5
    //   126: astore_3
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 202	java/io/BufferedInputStream:close	()V
    //   135: aload_3
    //   136: astore_1
    //   137: aload_2
    //   138: ifnull +9 -> 147
    //   141: aload_2
    //   142: invokevirtual 203	java/io/FileInputStream:close	()V
    //   145: aload_3
    //   146: astore_1
    //   147: aload_1
    //   148: astore_2
    //   149: aload_1
    //   150: ifnonnull -132 -> 18
    //   153: aload_0
    //   154: getfield 71	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   157: ldc 205
    //   159: aload 6
    //   161: invokestatic 210	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: ldc 212
    //   166: aconst_null
    //   167: aconst_null
    //   168: invokestatic 218	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +11 -> 184
    //   176: aload_2
    //   177: iconst_0
    //   178: aload_2
    //   179: arraylength
    //   180: invokestatic 222	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   183: astore_1
    //   184: aload_1
    //   185: ifnonnull +99 -> 284
    //   188: new 161	java/io/IOException
    //   191: dup
    //   192: ldc 223
    //   194: invokestatic 228	anvx:a	(I)Ljava/lang/String;
    //   197: invokespecial 229	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   200: athrow
    //   201: astore 5
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_1
    //   208: astore 4
    //   210: aload_2
    //   211: astore_3
    //   212: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +19 -> 234
    //   218: aload_1
    //   219: astore 4
    //   221: aload_2
    //   222: astore_3
    //   223: ldc 236
    //   225: iconst_2
    //   226: aload 5
    //   228: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 202	java/io/BufferedInputStream:close	()V
    //   242: aload_2
    //   243: ifnull +95 -> 338
    //   246: aload_2
    //   247: invokevirtual 203	java/io/FileInputStream:close	()V
    //   250: aconst_null
    //   251: astore_1
    //   252: goto -105 -> 147
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -111 -> 147
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_2
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 202	java/io/BufferedInputStream:close	()V
    //   274: aload_2
    //   275: ifnull +7 -> 282
    //   278: aload_2
    //   279: invokevirtual 203	java/io/FileInputStream:close	()V
    //   282: aload_1
    //   283: athrow
    //   284: aload_0
    //   285: aload 7
    //   287: aload_2
    //   288: invokespecial 246	com/tencent/biz/qrcode/CodeMaskManager:a	(Ljava/lang/String;[B)Z
    //   291: pop
    //   292: aload_1
    //   293: areturn
    //   294: astore_1
    //   295: goto -160 -> 135
    //   298: astore_1
    //   299: aload_3
    //   300: astore_1
    //   301: goto -154 -> 147
    //   304: astore_1
    //   305: goto -63 -> 242
    //   308: astore_3
    //   309: goto -35 -> 274
    //   312: astore_2
    //   313: goto -31 -> 282
    //   316: astore_1
    //   317: goto -53 -> 264
    //   320: astore_1
    //   321: aload_3
    //   322: astore_2
    //   323: goto -59 -> 264
    //   326: astore 5
    //   328: aconst_null
    //   329: astore_1
    //   330: goto -123 -> 207
    //   333: astore 5
    //   335: goto -128 -> 207
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -193 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	CodeMaskManager
    //   0	343	1	paramString	String
    //   17	271	2	localObject1	Object
    //   312	1	2	localIOException1	java.io.IOException
    //   322	1	2	localObject2	Object
    //   117	183	3	localObject3	Object
    //   308	14	3	localIOException2	java.io.IOException
    //   1	269	4	str1	String
    //   122	3	5	localBitmap	Bitmap
    //   201	26	5	localException1	Exception
    //   326	1	5	localException2	Exception
    //   333	1	5	localException3	Exception
    //   21	139	6	str2	String
    //   70	216	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   72	101	201	java/lang/Exception
    //   246	250	255	java/io/IOException
    //   72	101	261	finally
    //   131	135	294	java/io/IOException
    //   141	145	298	java/io/IOException
    //   238	242	304	java/io/IOException
    //   269	274	308	java/io/IOException
    //   278	282	312	java/io/IOException
    //   101	113	316	finally
    //   118	124	320	finally
    //   212	218	320	finally
    //   223	234	320	finally
    //   101	113	326	java/lang/Exception
    //   118	124	333	java/lang/Exception
  }
  
  private Bundle a()
  {
    int i = a(this.jdField_b_of_type_JavaUtilList.size());
    return a((Bundle)this.jdField_b_of_type_JavaUtilList.get(i));
  }
  
  private Bundle a(Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i == 0) {}
    }
    try
    {
      paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
      label47:
      if (paramBundle.containsKey("qrbkgRes"))
      {
        i = paramBundle.getInt("qrbkgRes");
        paramBundle.remove("qrbkg");
        if (i == 0) {}
      }
      try
      {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
        label94:
        return (Bundle)paramBundle.clone();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        break label94;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label47;
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 1)
    {
      localBundle.putInt("qrbkgRes", 2130843305);
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", 0);
      localBundle.putInt("W", -1);
      localBundle.putParcelable("qrloc", new Rect(126, 156, 413, 443));
      localBundle.putInt("head", 0);
      localBundle.putInt("type", 1);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.add(localBundle);
      return;
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", -16777216);
      localBundle.putInt("W", 16777215);
      localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      localBundle.putInt("head", 1);
      localBundle.putInt("type", 1);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new Vector(this.jdField_b_of_type_JavaUtilList);
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          Bundle localBundle = new Bundle();
          if (localJSONObject.has("bkg")) {
            localBundle.putString("bkgUrl", localJSONObject.getString("bkg"));
          }
          localBundle.putInt("nameClr", (int)Long.parseLong(localJSONObject.getString("nameClr"), 16));
          localBundle.putInt("tipsClr", (int)Long.parseLong(localJSONObject.getString("tipsClr"), 16));
          if (localJSONObject.has("qrbkg")) {
            localBundle.putString("qrbkgUrl", localJSONObject.getString("qrbkg"));
          }
          Object localObject;
          int k;
          int m;
          int n;
          int i1;
          if (localJSONObject.has("qrloc"))
          {
            localObject = localJSONObject.getJSONArray("qrloc");
            j = ((JSONArray)localObject).getInt(0);
            k = ((JSONArray)localObject).getInt(1);
            m = ((JSONArray)localObject).getInt(0);
            n = ((JSONArray)localObject).getInt(2);
            i1 = ((JSONArray)localObject).getInt(1);
            localBundle.putParcelable("qrloc", new Rect(j, k, m + n, ((JSONArray)localObject).getInt(3) + i1));
          }
          if (localJSONObject.has("qrsz")) {
            localBundle.putInt("qrsz", localJSONObject.getInt("qrsz"));
          }
          if (localJSONObject.has("clip"))
          {
            localObject = new ArrayList();
            JSONArray localJSONArray1 = localJSONObject.getJSONArray("clip");
            j = 0;
            while (j < localJSONArray1.length())
            {
              JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
              k = localJSONArray2.getInt(0);
              m = localJSONArray2.getInt(1);
              n = localJSONArray2.getInt(0);
              i1 = localJSONArray2.getInt(2);
              int i2 = localJSONArray2.getInt(1);
              ((ArrayList)localObject).add(new Rect(k, m, n + i1, localJSONArray2.getInt(3) + i2));
              j += 1;
            }
            localBundle.putParcelableArrayList("clip", (ArrayList)localObject);
          }
          localBundle.putInt("B", (int)Long.parseLong(localJSONObject.getString("B"), 16));
          if (localJSONObject.has("W")) {
            localBundle.putInt("W", (int)Long.parseLong(localJSONObject.getString("W"), 16));
          }
          for (;;)
          {
            try
            {
              localBundle.putInt("head", localJSONObject.getInt("head"));
              localBundle.putInt("v", localJSONObject.getInt("v"));
              localBundle.putInt("type", 2);
              this.jdField_a_of_type_JavaUtilList.add(localBundle);
            }
            catch (Exception localException)
            {
              if (!localJSONObject.getBoolean("head")) {
                break;
              }
            }
            localBundle.putInt("W", 16777215);
          }
          for (int j = 1;; j = 0)
          {
            localBundle.putInt("head", j);
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          label560:
          break label560;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_2
    //   9: ifnull +90 -> 99
    //   12: new 59	java/io/File
    //   15: dup
    //   16: getstatic 45	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokespecial 385	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 388	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 59	java/io/File
    //   29: dup
    //   30: new 25	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 45	com/tencent/biz/qrcode/CodeMaskManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 385	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 391	java/io/File:exists	()Z
    //   58: ifne +8 -> 66
    //   61: aload_1
    //   62: invokevirtual 394	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 396	java/io/FileOutputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual 403	java/io/FileOutputStream:write	([B)V
    //   80: iconst_1
    //   81: istore 4
    //   83: iload 4
    //   85: istore_3
    //   86: aload_1
    //   87: ifnull +10 -> 97
    //   90: aload_1
    //   91: invokevirtual 404	java/io/FileOutputStream:close	()V
    //   94: iload 4
    //   96: istore_3
    //   97: iload_3
    //   98: ireturn
    //   99: iconst_0
    //   100: ifeq -3 -> 97
    //   103: new 406	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aload 5
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -22 -> 97
    //   122: aload_1
    //   123: invokevirtual 404	java/io/FileOutputStream:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_1
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: aload 6
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 404	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_2
    //   149: goto -6 -> 143
    //   152: astore 5
    //   154: aload_1
    //   155: astore_2
    //   156: aload 5
    //   158: astore_1
    //   159: goto -24 -> 135
    //   162: astore_2
    //   163: goto -45 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CodeMaskManager
    //   0	166	1	paramString	String
    //   0	166	2	paramArrayOfByte	byte[]
    //   1	97	3	bool1	boolean
    //   81	14	4	bool2	boolean
    //   6	110	5	localObject1	Object
    //   152	5	5	localObject2	Object
    //   3	130	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   12	66	114	java/io/IOException
    //   66	75	114	java/io/IOException
    //   122	126	128	java/io/IOException
    //   12	66	131	finally
    //   66	75	131	finally
    //   90	94	145	java/io/IOException
    //   139	143	148	java/io/IOException
    //   75	80	152	finally
    //   75	80	162	java/io/IOException
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
    if (this.jdField_a_of_type_JavaLangThread != null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0);
      l = localSharedPreferences.getLong("updateTemplate2", 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
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
  
  public void a(zjn paramzjn, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
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
      paramzjn.a(a((Bundle)localObject));
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
        if (paramInt != 2) {
          break label256;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("head", 3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("type", 1);
        paramzjn.a(a(this.jdField_a_of_type_AndroidOsBundle));
        return;
        label256:
        if (paramInt == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 4);
        }
      }
    }
    int i = a(this.jdField_a_of_type_JavaUtilList.size());
    if (i >= 0)
    {
      paramInt = i;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      paramzjn.a(a((Bundle)localObject));
      b();
      return;
    }
    localObject = new CodeMaskManager.PrepareBundleTask(this, paramzjn, (Bundle)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CodeMaskManager.2(this, (CodeMaskManager.PrepareBundleTask)localObject, paramzjn), 10000L);
    ((CodeMaskManager.PrepareBundleTask)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager
 * JD-Core Version:    0.7.0.1
 */