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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.2;
import com.tencent.mobileqq.nearby.NearbyVideoUtils.3;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awkl
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
    //   7: getstatic 30	com/tencent/mobileqq/app/AppConstants:DYNAMIC_PROFILE	Ljava/lang/String;
    //   10: invokestatic 36	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 44	java/io/File:mkdirs	()Z
    //   21: pop
    //   22: new 25	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: new 46	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   34: ldc 50
    //   36: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   42: invokevirtual 63	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 70	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 73	java/io/File:exists	()Z
    //   58: ifeq +9 -> 67
    //   61: aload 4
    //   63: invokevirtual 76	java/io/File:delete	()Z
    //   66: pop
    //   67: new 78	java/io/FileOutputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_1
    //   77: new 83	java/io/BufferedOutputStream
    //   80: dup
    //   81: aload_1
    //   82: sipush 4096
    //   85: invokespecial 86	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   88: astore 5
    //   90: aload 5
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_0
    //   96: getstatic 92	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   99: bipush 100
    //   101: aload 5
    //   103: invokevirtual 98	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   106: pop
    //   107: aload 5
    //   109: astore_3
    //   110: aload_1
    //   111: astore_2
    //   112: aload 5
    //   114: invokevirtual 101	java/io/BufferedOutputStream:flush	()V
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: astore_2
    //   122: aload 4
    //   124: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   136: aload_0
    //   137: astore_1
    //   138: aload 5
    //   140: ifnull +10 -> 150
    //   143: aload 5
    //   145: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   148: aload_0
    //   149: astore_1
    //   150: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +28 -> 181
    //   156: ldc 115
    //   158: iconst_2
    //   159: new 46	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   166: ldc 117
    //   168: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 121	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   188: goto -52 -> 136
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   196: aload_0
    //   197: astore_1
    //   198: goto -48 -> 150
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +17 -> 231
    //   217: aload_0
    //   218: astore_3
    //   219: aload_1
    //   220: astore_2
    //   221: ldc 115
    //   223: iconst_2
    //   224: ldc 126
    //   226: aload 4
    //   228: invokestatic 130	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   239: aload 6
    //   241: astore_1
    //   242: aload_0
    //   243: ifnull -93 -> 150
    //   246: aload_0
    //   247: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   250: aload 6
    //   252: astore_1
    //   253: goto -103 -> 150
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   261: aload 6
    //   263: astore_1
    //   264: goto -114 -> 150
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   272: goto -33 -> 239
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_3
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   288: aload_3
    //   289: ifnull +7 -> 296
    //   292: aload_3
    //   293: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   296: aload_0
    //   297: athrow
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   303: goto -15 -> 288
    //   306: astore_1
    //   307: aload_1
    //   308: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   311: goto -15 -> 296
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_3
    //   317: goto -37 -> 280
    //   320: astore_0
    //   321: aload_2
    //   322: astore_1
    //   323: goto -43 -> 280
    //   326: astore 4
    //   328: aconst_null
    //   329: astore_0
    //   330: goto -123 -> 207
    //   333: astore 4
    //   335: aload 5
    //   337: astore_0
    //   338: goto -131 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramBitmap	android.graphics.Bitmap
    //   16	166	1	localObject1	Object
    //   183	2	1	localIOException1	java.io.IOException
    //   191	2	1	localIOException2	java.io.IOException
    //   197	67	1	localObject2	Object
    //   267	2	1	localIOException3	java.io.IOException
    //   279	6	1	localObject3	Object
    //   298	2	1	localIOException4	java.io.IOException
    //   306	2	1	localIOException5	java.io.IOException
    //   322	1	1	localObject4	Object
    //   94	228	2	localObject5	Object
    //   92	225	3	localObject6	Object
    //   51	72	4	localFile	java.io.File
    //   201	26	4	localException1	java.lang.Exception
    //   326	1	4	localException2	java.lang.Exception
    //   333	1	4	localException3	java.lang.Exception
    //   88	248	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1	261	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   132	136	183	java/io/IOException
    //   143	148	191	java/io/IOException
    //   67	77	201	java/lang/Exception
    //   246	250	256	java/io/IOException
    //   235	239	267	java/io/IOException
    //   67	77	275	finally
    //   284	288	298	java/io/IOException
    //   292	296	306	java/io/IOException
    //   77	90	314	finally
    //   95	107	320	finally
    //   112	117	320	finally
    //   122	128	320	finally
    //   211	217	320	finally
    //   221	231	320	finally
    //   77	90	326	java/lang/Exception
    //   95	107	333	java/lang/Exception
    //   112	117	333	java/lang/Exception
    //   122	128	333	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return a(ShortVideoUtils.getVideoThumbnail(null, paramString));
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
    paramQQAppInterface.execute(new NearbyVideoUtils.3(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    paramTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    paramQQAppInterface.getTransFileController().addHandle(paramTransProcessorHandler);
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
    new bcek(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
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
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170807/f2f569d65bc74317bb9a6bfe482dcd2c.png?_t=1502087876532"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(150.0F, paramActivity.getResources()));
    new axhi(paramActivity).a(localImageView, localLayoutParams).b(amtj.a(2131706514)).a(new axhc(amtj.a(2131706516), new awkm(paramActivity, paramQQAppInterface))).show();
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
 * Qualified Name:     awkl
 * JD-Core Version:    0.7.0.1
 */