import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class astv
{
  public static String a(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_del_" + paramString1, 4).getString(paramString2, "");
  }
  
  public static Map<String, ?> a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString, 4).getAll();
  }
  
  public static void a(String paramString)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString, 4).edit().clear().apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_del_" + paramString1, 4).edit().remove(paramString2).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_del_" + paramString1, 4).edit().putString(paramString2, paramString3).apply();
  }
  
  public static boolean a(int paramInt, RecentBaseData paramRecentBaseData)
  {
    return (paramInt == 10005) && ((paramRecentBaseData instanceof RecentItemImaxADData)) && (!TextUtils.isEmpty(((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl));
  }
  
  public static boolean a(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getHeight();
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      if (localRect.height() >= i / 2) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.istroop == 10005;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: arraylength
    //   9: ifne +16 -> 25
    //   12: ldc 116
    //   14: iconst_1
    //   15: ldc 118
    //   17: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload 6
    //   22: astore_2
    //   23: aload_2
    //   24: areturn
    //   25: new 126	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: invokespecial 127	java/io/ByteArrayOutputStream:<init>	()V
    //   32: astore_1
    //   33: new 129	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: iconst_0
    //   39: aload_0
    //   40: arraylength
    //   41: invokespecial 132	java/io/ByteArrayInputStream:<init>	([BII)V
    //   44: astore 5
    //   46: aload 5
    //   48: astore_3
    //   49: aload_1
    //   50: astore_2
    //   51: new 134	java/util/zip/GZIPInputStream
    //   54: dup
    //   55: aload 5
    //   57: aload_0
    //   58: arraylength
    //   59: invokespecial 137	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;I)V
    //   62: astore 4
    //   64: aload 5
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_0
    //   70: arraylength
    //   71: iconst_5
    //   72: imul
    //   73: newarray byte
    //   75: astore_0
    //   76: aload 5
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: aload_0
    //   83: iconst_0
    //   84: aload 4
    //   86: aload_0
    //   87: invokevirtual 141	java/util/zip/GZIPInputStream:read	([B)I
    //   90: invokevirtual 144	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: aload 5
    //   95: astore_3
    //   96: aload_1
    //   97: astore_2
    //   98: aload 4
    //   100: invokevirtual 147	java/util/zip/GZIPInputStream:close	()V
    //   103: aload 5
    //   105: astore_3
    //   106: aload_1
    //   107: astore_2
    //   108: aload_1
    //   109: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: astore_0
    //   113: aload 5
    //   115: ifnull +8 -> 123
    //   118: aload 5
    //   120: invokevirtual 152	java/io/ByteArrayInputStream:close	()V
    //   123: aload_0
    //   124: astore_2
    //   125: aload_1
    //   126: ifnull -103 -> 23
    //   129: aload_1
    //   130: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore_1
    //   136: ldc 116
    //   138: iconst_1
    //   139: ldc 155
    //   141: aload_1
    //   142: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_0
    //   146: areturn
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_0
    //   154: astore_3
    //   155: aload_1
    //   156: astore_2
    //   157: ldc 116
    //   159: iconst_1
    //   160: ldc 160
    //   162: aload 4
    //   164: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 152	java/io/ByteArrayInputStream:close	()V
    //   175: aload 6
    //   177: astore_2
    //   178: aload_1
    //   179: ifnull -156 -> 23
    //   182: aload_1
    //   183: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: ldc 116
    //   191: iconst_1
    //   192: ldc 155
    //   194: aload_0
    //   195: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 152	java/io/ByteArrayInputStream:close	()V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   221: aload_0
    //   222: athrow
    //   223: astore_1
    //   224: ldc 116
    //   226: iconst_1
    //   227: ldc 155
    //   229: aload_1
    //   230: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -12 -> 221
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_3
    //   239: goto -34 -> 205
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: goto -40 -> 205
    //   248: astore 4
    //   250: aconst_null
    //   251: astore_0
    //   252: goto -99 -> 153
    //   255: astore 4
    //   257: aload 5
    //   259: astore_0
    //   260: goto -107 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramArrayOfByte	byte[]
    //   32	98	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   135	7	1	localIOException1	java.io.IOException
    //   152	66	1	localObject1	Object
    //   223	7	1	localIOException2	java.io.IOException
    //   244	1	1	localObject2	Object
    //   22	222	2	localObject3	Object
    //   48	191	3	localObject4	Object
    //   62	37	4	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   147	16	4	localException1	java.lang.Exception
    //   248	1	4	localException2	java.lang.Exception
    //   255	1	4	localException3	java.lang.Exception
    //   44	214	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   1	175	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	135	java/io/IOException
    //   129	133	135	java/io/IOException
    //   25	33	147	java/lang/Exception
    //   171	175	188	java/io/IOException
    //   182	186	188	java/io/IOException
    //   25	33	200	finally
    //   209	213	223	java/io/IOException
    //   217	221	223	java/io/IOException
    //   33	46	236	finally
    //   51	64	242	finally
    //   69	76	242	finally
    //   81	93	242	finally
    //   98	103	242	finally
    //   108	113	242	finally
    //   157	167	242	finally
    //   33	46	248	java/lang/Exception
    //   51	64	255	java/lang/Exception
    //   69	76	255	java/lang/Exception
    //   81	93	255	java/lang/Exception
    //   98	103	255	java/lang/Exception
    //   108	113	255	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).getString(paramString2, "");
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).edit().remove(paramString2).apply();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("imax_ad_item_data_" + paramString1, 4).edit().putString(paramString2, paramString3).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astv
 * JD-Core Version:    0.7.0.1
 */