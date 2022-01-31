import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.2;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.3;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class asfn
{
  private static String a = "need_show_auth_video_guide_";
  private static String b = "need_open_auth_video";
  
  /* Error */
  private static String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 25	java/io/File
    //   6: dup
    //   7: getstatic 30	ajed:bX	Ljava/lang/String;
    //   10: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 38	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 25	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: new 40	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   31: ldc 44
    //   33: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   39: invokevirtual 57	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 64	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 67	java/io/File:exists	()Z
    //   55: ifeq +9 -> 64
    //   58: aload 4
    //   60: invokevirtual 70	java/io/File:delete	()Z
    //   63: pop
    //   64: new 72	java/io/FileOutputStream
    //   67: dup
    //   68: aload 4
    //   70: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_1
    //   74: new 77	java/io/BufferedOutputStream
    //   77: dup
    //   78: aload_1
    //   79: sipush 4096
    //   82: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   85: astore 5
    //   87: aload 5
    //   89: astore_3
    //   90: aload_1
    //   91: astore_2
    //   92: aload_0
    //   93: getstatic 86	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   96: bipush 100
    //   98: aload 5
    //   100: invokevirtual 92	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload 5
    //   106: astore_3
    //   107: aload_1
    //   108: astore_2
    //   109: aload 5
    //   111: invokevirtual 95	java/io/BufferedOutputStream:flush	()V
    //   114: aload 5
    //   116: astore_3
    //   117: aload_1
    //   118: astore_2
    //   119: aload 4
    //   121: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: astore_0
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   133: aload_0
    //   134: astore_1
    //   135: aload 5
    //   137: ifnull +10 -> 147
    //   140: aload 5
    //   142: invokevirtual 102	java/io/BufferedOutputStream:close	()V
    //   145: aload_0
    //   146: astore_1
    //   147: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: ldc 109
    //   155: iconst_2
    //   156: new 40	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   163: ldc 111
    //   165: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_1
    //   179: areturn
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   185: goto -52 -> 133
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   193: aload_0
    //   194: astore_1
    //   195: goto -48 -> 147
    //   198: astore 4
    //   200: aconst_null
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_0
    //   205: astore_3
    //   206: aload_1
    //   207: astore_2
    //   208: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +17 -> 228
    //   214: aload_0
    //   215: astore_3
    //   216: aload_1
    //   217: astore_2
    //   218: ldc 109
    //   220: iconst_2
    //   221: ldc 120
    //   223: aload 4
    //   225: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   236: aload 6
    //   238: astore_1
    //   239: aload_0
    //   240: ifnull -93 -> 147
    //   243: aload_0
    //   244: invokevirtual 102	java/io/BufferedOutputStream:close	()V
    //   247: aload 6
    //   249: astore_1
    //   250: goto -103 -> 147
    //   253: astore_0
    //   254: aload_0
    //   255: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   258: aload 6
    //   260: astore_1
    //   261: goto -114 -> 147
    //   264: astore_1
    //   265: aload_1
    //   266: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   269: goto -33 -> 236
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_3
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 102	java/io/BufferedOutputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   300: goto -15 -> 285
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   308: goto -15 -> 293
    //   311: astore_0
    //   312: aconst_null
    //   313: astore_3
    //   314: goto -37 -> 277
    //   317: astore_0
    //   318: aload_2
    //   319: astore_1
    //   320: goto -43 -> 277
    //   323: astore 4
    //   325: aconst_null
    //   326: astore_0
    //   327: goto -123 -> 204
    //   330: astore 4
    //   332: aload 5
    //   334: astore_0
    //   335: goto -131 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramBitmap	android.graphics.Bitmap
    //   13	166	1	localObject1	Object
    //   180	2	1	localIOException1	java.io.IOException
    //   188	2	1	localIOException2	java.io.IOException
    //   194	67	1	localObject2	Object
    //   264	2	1	localIOException3	java.io.IOException
    //   276	6	1	localObject3	Object
    //   295	2	1	localIOException4	java.io.IOException
    //   303	2	1	localIOException5	java.io.IOException
    //   319	1	1	localObject4	Object
    //   91	228	2	localObject5	Object
    //   89	225	3	localObject6	Object
    //   48	72	4	localFile	java.io.File
    //   198	26	4	localException1	java.lang.Exception
    //   323	1	4	localException2	java.lang.Exception
    //   330	1	4	localException3	java.lang.Exception
    //   85	248	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1	258	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   129	133	180	java/io/IOException
    //   140	145	188	java/io/IOException
    //   64	74	198	java/lang/Exception
    //   243	247	253	java/io/IOException
    //   232	236	264	java/io/IOException
    //   64	74	272	finally
    //   281	285	295	java/io/IOException
    //   289	293	303	java/io/IOException
    //   74	87	311	finally
    //   92	104	317	finally
    //   109	114	317	finally
    //   119	125	317	finally
    //   208	214	317	finally
    //   218	228	317	finally
    //   74	87	323	java/lang/Exception
    //   92	104	330	java/lang/Exception
    //   109	114	330	java/lang/Exception
    //   119	125	330	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return a(ShortVideoUtils.a(null, paramString));
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt) {}
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("video_url", paramString2);
    localIntent.putExtra("video_thumb_url", paramString3);
    localIntent.putExtra("mode", paramInt);
    localIntent.putExtra("uin", paramString4);
    localIntent.putExtra("is_authentic", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, NearbyAuthVideoPlayerFragment.class, 11000);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a + paramQQAppInterface.getCurrentAccountUin();
    PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new NearbyVideoUtils.3(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axvs paramaxvs)
  {
    paramaxvs.addFilter(new Class[] { axsm.class });
    paramQQAppInterface.a().a(paramaxvs);
    ThreadManager.post(new NearbyVideoUtils.2(paramQQAppInterface, paramString, (int)(System.currentTimeMillis() / 1000L)), 8, null, true);
  }
  
  public static void a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("VideoAuthEnable");
      String str = b;
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(str, bool).commit();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyVideoUtils", 2, "setAuthVideoConfig=" + paramString + ",error:" + localJSONException.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new awrb(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    a("data_card", paramString, 0, 0, paramVarArgs);
  }
  
  public static boolean a()
  {
    String str = b;
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(str, true);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (!a(paramQQAppInterface)) {}
    do
    {
      return false;
      if (!paramActivity.isFinishing()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NearbyVideoUtils", 2, "showVoteUpdateDialog invoke, but activity is finishing");
    return false;
    ImageView localImageView = new ImageView(paramActivity);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable(URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20170807/f2f569d65bc74317bb9a6bfe482dcd2c.png?_t=1502087876532"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(150.0F, paramActivity.getResources()));
    new atby(paramActivity).a(localImageView, localLayoutParams).b(ajjy.a(2131641606)).a(new atbs(ajjy.a(2131641608), new asfo(paramActivity, paramQQAppInterface))).show();
    a(paramQQAppInterface);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a + paramQQAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(paramQQAppInterface, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asfn
 * JD-Core Version:    0.7.0.1
 */