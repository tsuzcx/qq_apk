import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.2;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import common.config.service.QzoneConfig;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy=MediaChooseJsProxy.class)
public class bkom
  extends MediaChooseJsProxy
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bkon(this);
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private long b = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(paramString)) {
      localBitmap = ShortVideoUtils.getVideoThumbnail(null, paramString);
    }
    return localBitmap;
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 84	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 74	bkom:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   23: ldc 89
    //   25: invokeinterface 95 2 0
    //   30: checkcast 89	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   33: ldc 97
    //   35: invokeinterface 100 2 0
    //   40: astore 11
    //   42: new 84	java/io/File
    //   45: dup
    //   46: aload 11
    //   48: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 12
    //   53: aconst_null
    //   54: astore 8
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 7
    //   62: aload 8
    //   64: astore 5
    //   66: aload 9
    //   68: astore_3
    //   69: ldc 102
    //   71: iconst_1
    //   72: new 104	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   79: ldc 107
    //   81: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 4
    //   86: invokevirtual 115	java/io/File:length	()J
    //   89: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 8
    //   100: astore 5
    //   102: aload 9
    //   104: astore_3
    //   105: new 130	android/graphics/BitmapFactory$Options
    //   108: dup
    //   109: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   112: astore 4
    //   114: aload 8
    //   116: astore 5
    //   118: aload 9
    //   120: astore_3
    //   121: aload 4
    //   123: iconst_2
    //   124: putfield 134	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   127: aload 8
    //   129: astore 5
    //   131: aload 9
    //   133: astore_3
    //   134: aload_1
    //   135: aload 4
    //   137: invokestatic 140	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   140: astore 10
    //   142: aload 7
    //   144: astore 4
    //   146: aload 10
    //   148: ifnull +127 -> 275
    //   151: aload 8
    //   153: astore 5
    //   155: aload 9
    //   157: astore_3
    //   158: aload_1
    //   159: invokestatic 146	com/tencent/mobileqq/mini/util/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   162: istore_2
    //   163: aload 8
    //   165: astore 5
    //   167: aload 9
    //   169: astore_3
    //   170: ldc 102
    //   172: iconst_1
    //   173: new 104	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   180: ldc 148
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_2
    //   186: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload 10
    //   197: astore 6
    //   199: iload_2
    //   200: ifeq +30 -> 230
    //   203: aload 8
    //   205: astore 5
    //   207: aload 9
    //   209: astore_3
    //   210: iload_2
    //   211: aload 10
    //   213: invokestatic 155	com/tencent/mobileqq/mini/util/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   216: astore 6
    //   218: aload 8
    //   220: astore 5
    //   222: aload 9
    //   224: astore_3
    //   225: aload 10
    //   227: invokevirtual 160	android/graphics/Bitmap:recycle	()V
    //   230: aload 7
    //   232: astore 4
    //   234: aload 6
    //   236: ifnull +39 -> 275
    //   239: aload 8
    //   241: astore 5
    //   243: aload 9
    //   245: astore_3
    //   246: new 162	java/io/FileOutputStream
    //   249: dup
    //   250: aload 12
    //   252: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   255: astore 4
    //   257: aload 6
    //   259: getstatic 171	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   262: bipush 50
    //   264: aload 4
    //   266: invokevirtual 175	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   269: pop
    //   270: aload 4
    //   272: invokevirtual 178	java/io/FileOutputStream:flush	()V
    //   275: aload 4
    //   277: astore 5
    //   279: aload 4
    //   281: astore_3
    //   282: ldc 102
    //   284: iconst_1
    //   285: new 104	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   292: ldc 180
    //   294: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 12
    //   299: invokevirtual 115	java/io/File:length	()J
    //   302: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload 4
    //   313: ifnull +8 -> 321
    //   316: aload 4
    //   318: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   321: aload 11
    //   323: areturn
    //   324: astore 4
    //   326: aload 5
    //   328: astore_3
    //   329: ldc 102
    //   331: iconst_1
    //   332: ldc 185
    //   334: aload 4
    //   336: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload 5
    //   341: ifnull -334 -> 7
    //   344: aload 5
    //   346: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   349: aload_1
    //   350: areturn
    //   351: astore_3
    //   352: aload_1
    //   353: areturn
    //   354: astore_1
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   363: aload_1
    //   364: athrow
    //   365: astore_1
    //   366: goto -45 -> 321
    //   369: astore_3
    //   370: goto -7 -> 363
    //   373: astore_1
    //   374: aload 4
    //   376: astore_3
    //   377: goto -22 -> 355
    //   380: astore_3
    //   381: aload 4
    //   383: astore 5
    //   385: aload_3
    //   386: astore 4
    //   388: goto -62 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	bkom
    //   0	391	1	paramString	String
    //   162	49	2	i	int
    //   68	261	3	localObject1	Object
    //   351	9	3	localException1	Exception
    //   369	1	3	localException2	Exception
    //   376	1	3	localThrowable1	Throwable
    //   380	6	3	localThrowable2	Throwable
    //   17	300	4	localObject2	Object
    //   324	58	4	localThrowable3	Throwable
    //   386	1	4	localObject3	Object
    //   64	320	5	localObject4	Object
    //   197	61	6	localBitmap1	Bitmap
    //   60	171	7	localObject5	Object
    //   54	186	8	localObject6	Object
    //   57	187	9	localObject7	Object
    //   140	86	10	localBitmap2	Bitmap
    //   40	282	11	str	String
    //   51	247	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   69	98	324	java/lang/Throwable
    //   105	114	324	java/lang/Throwable
    //   121	127	324	java/lang/Throwable
    //   134	142	324	java/lang/Throwable
    //   158	163	324	java/lang/Throwable
    //   170	195	324	java/lang/Throwable
    //   210	218	324	java/lang/Throwable
    //   225	230	324	java/lang/Throwable
    //   246	257	324	java/lang/Throwable
    //   282	311	324	java/lang/Throwable
    //   344	349	351	java/lang/Exception
    //   69	98	354	finally
    //   105	114	354	finally
    //   121	127	354	finally
    //   134	142	354	finally
    //   158	163	354	finally
    //   170	195	354	finally
    //   210	218	354	finally
    //   225	230	354	finally
    //   246	257	354	finally
    //   282	311	354	finally
    //   329	339	354	finally
    //   316	321	365	java/lang/Exception
    //   359	363	369	java/lang/Exception
    //   257	275	373	finally
    //   257	275	380	java/lang/Throwable
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaChooseJsProxyImpl", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MediaChooseJsProxyImpl", 1, "unregisterReceiver exception.", localThrowable);
    }
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseOk(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void a(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.mBridge != null) {
      this.mBridge.responseFail(paramInt, paramString1, paramJSONObject, paramString2);
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      b(paramActivity);
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localActivity == null) || (localActivity == paramActivity));
    b(paramActivity);
  }
  
  private void a(Activity paramActivity, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    if (paramInt2 == 0) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_media_info");
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt3);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt3);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.b);
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", false);
      localIntent.putExtra("from_miniapp_enable_bottombar", true);
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      if (paramInt1 == 0) {
        localIntent.putExtra("PhotoConst.original_button", true);
      }
      localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      localIntent.putExtra("from_miniapp_cur_sizetype", paramInt1);
      paramActivity.startActivity(localIntent);
      AlbumUtil.anim(paramActivity, false, true);
      return;
      if (paramInt2 == 1) {
        localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      } else if (paramInt2 == 2) {
        localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
      }
    }
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    ((IActivityResultManager)localObject).addActivityResultListener(new bkoq(this, (IActivityResultManager)localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    ((Bundle)localObject).putBoolean("PeakConstants.ARG_ALBUM", false);
    ((Bundle)localObject).putInt("edit_video_type", 10020);
    ((Bundle)localObject).putInt("key_camera_photo_edit_type", 3);
    ((Bundle)localObject).putInt("key_camera_video_edit_type", 5);
    ((Bundle)localObject).putBoolean("extra_directly_back", true);
    ((Bundle)localObject).putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewPhotoListActivity.class.getName());
    ((Bundle)localObject).putBoolean("enable_edit_video", true);
    ((Bundle)localObject).putBoolean("enable_input_text", false);
    ((Bundle)localObject).putBoolean("enable_priv_list", false);
    ((Bundle)localObject).putInt("entry_source", 5);
    ((Bundle)localObject).putBoolean("support_record", true);
    ((Bundle)localObject).putBoolean("enable_local_video", false);
    ((Bundle)localObject).putBoolean("enable_local_button", false);
    ((Bundle)localObject).putBoolean("go_publish_activity", false);
    ((Bundle)localObject).putBoolean("enterPtu", false);
    ((Bundle)localObject).putBoolean("support_pic", true);
    ((Bundle)localObject).putBoolean("key_disable_face_detect", true);
    ((Bundle)localObject).putBoolean("key_need_check_sensitive", false);
    if (paramInt == 0)
    {
      ((Bundle)localObject).putInt("ability_flag", 1);
      ((Bundle)localObject).putInt("ARG_CAPTURE_MAX_DURATION", (int)paramLong * 1000);
      if (!paramBoolean) {
        break label346;
      }
      ((Bundle)localObject).putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    }
    for (;;)
    {
      ((Bundle)localObject).putBoolean("need_show_banner", false);
      Intent localIntent = new Intent(paramActivity, QIMCameraCaptureActivity.class);
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("need_show_banner", false);
      paramActivity.startActivityForResult(localIntent, 10020);
      return;
      if (paramInt == 1)
      {
        ((Bundle)localObject).putInt("ability_flag", 2);
        break;
      }
      if (paramInt != 2) {
        break;
      }
      ((Bundle)localObject).putInt("ability_flag", 3);
      break;
      label346:
      ((Bundle)localObject).putInt("PeakConstants.ARG_FORCE_CAMERA", 2);
    }
  }
  
  private void a(String paramString)
  {
    QLog.i("MediaChooseJsProxyImpl", 1, "showLoading " + paramString);
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, com.tencent.mobileqq.activity.photo.LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: ifnonnull +18 -> 24
    //   9: ldc 102
    //   11: iconst_2
    //   12: ldc_w 439
    //   15: invokestatic 442	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iload_3
    //   19: istore 4
    //   21: iload 4
    //   23: ireturn
    //   24: aload_2
    //   25: ifnonnull +14 -> 39
    //   28: ldc 102
    //   30: iconst_2
    //   31: ldc_w 444
    //   34: invokestatic 442	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 74	bkom:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   43: ldc 89
    //   45: invokeinterface 95 2 0
    //   50: checkcast 89	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   53: ldc_w 446
    //   56: invokeinterface 100 2 0
    //   61: astore 5
    //   63: new 84	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 10
    //   74: aload 10
    //   76: invokevirtual 449	java/io/File:exists	()Z
    //   79: ifeq +9 -> 88
    //   82: aload 10
    //   84: invokevirtual 452	java/io/File:delete	()Z
    //   87: pop
    //   88: new 162	java/io/FileOutputStream
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   97: astore 6
    //   99: new 454	java/io/BufferedOutputStream
    //   102: dup
    //   103: aload 6
    //   105: sipush 4096
    //   108: invokespecial 457	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   111: astore 9
    //   113: aload 9
    //   115: astore 8
    //   117: aload 6
    //   119: astore 7
    //   121: aload_1
    //   122: getstatic 171	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 100
    //   127: aload 9
    //   129: invokevirtual 175	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: istore_3
    //   133: aload 9
    //   135: astore 8
    //   137: aload 6
    //   139: astore 7
    //   141: aload 9
    //   143: invokevirtual 458	java/io/BufferedOutputStream:flush	()V
    //   146: aload 9
    //   148: astore 8
    //   150: aload 6
    //   152: astore 7
    //   154: aload 10
    //   156: invokevirtual 461	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: astore_1
    //   160: aload 9
    //   162: astore 8
    //   164: aload 6
    //   166: astore 7
    //   168: aload_2
    //   169: aload_0
    //   170: getfield 74	bkom:jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   173: ldc 89
    //   175: invokeinterface 95 2 0
    //   180: checkcast 89	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   183: aload_1
    //   184: invokeinterface 464 2 0
    //   189: putfield 470	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   192: aload 6
    //   194: ifnull +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   202: aload 9
    //   204: ifnull +275 -> 479
    //   207: aload 9
    //   209: invokevirtual 471	java/io/BufferedOutputStream:close	()V
    //   212: aload_1
    //   213: astore_2
    //   214: iload_3
    //   215: istore 4
    //   217: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq -199 -> 21
    //   223: ldc 102
    //   225: iconst_2
    //   226: new 104	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 473
    //   236: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 431	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: iload_3
    //   250: ireturn
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   256: goto -54 -> 202
    //   259: astore_2
    //   260: aload_2
    //   261: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   264: aload_1
    //   265: astore_2
    //   266: goto -52 -> 214
    //   269: astore_2
    //   270: aconst_null
    //   271: astore 7
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 5
    //   278: astore_1
    //   279: aload 7
    //   281: astore 5
    //   283: aload 5
    //   285: astore 8
    //   287: aload 6
    //   289: astore 7
    //   291: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +21 -> 315
    //   297: aload 5
    //   299: astore 8
    //   301: aload 6
    //   303: astore 7
    //   305: ldc 102
    //   307: iconst_2
    //   308: ldc_w 478
    //   311: aload_2
    //   312: invokestatic 480	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload 6
    //   317: ifnull +8 -> 325
    //   320: aload 6
    //   322: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   325: aload_1
    //   326: astore_2
    //   327: iload 4
    //   329: istore_3
    //   330: aload 5
    //   332: ifnull -118 -> 214
    //   335: aload 5
    //   337: invokevirtual 471	java/io/BufferedOutputStream:close	()V
    //   340: aload_1
    //   341: astore_2
    //   342: iload 4
    //   344: istore_3
    //   345: goto -131 -> 214
    //   348: astore_2
    //   349: aload_2
    //   350: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   353: aload_1
    //   354: astore_2
    //   355: iload 4
    //   357: istore_3
    //   358: goto -144 -> 214
    //   361: astore_2
    //   362: aload_2
    //   363: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   366: goto -41 -> 325
    //   369: astore_1
    //   370: aconst_null
    //   371: astore 8
    //   373: aconst_null
    //   374: astore 6
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   386: aload 8
    //   388: ifnull +8 -> 396
    //   391: aload 8
    //   393: invokevirtual 471	java/io/BufferedOutputStream:close	()V
    //   396: aload_1
    //   397: athrow
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   403: goto -17 -> 386
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 476	java/io/IOException:printStackTrace	()V
    //   411: goto -15 -> 396
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 8
    //   418: goto -42 -> 376
    //   421: astore_1
    //   422: aload 7
    //   424: astore 6
    //   426: goto -50 -> 376
    //   429: astore_2
    //   430: aconst_null
    //   431: astore 7
    //   433: aload 5
    //   435: astore_1
    //   436: aload 7
    //   438: astore 5
    //   440: goto -157 -> 283
    //   443: astore_2
    //   444: aload 5
    //   446: astore_1
    //   447: aload 9
    //   449: astore 5
    //   451: goto -168 -> 283
    //   454: astore_2
    //   455: aload 5
    //   457: astore_1
    //   458: iload_3
    //   459: istore 4
    //   461: aload 9
    //   463: astore 5
    //   465: goto -182 -> 283
    //   468: astore_2
    //   469: iload_3
    //   470: istore 4
    //   472: aload 9
    //   474: astore 5
    //   476: goto -193 -> 283
    //   479: aload_1
    //   480: astore_2
    //   481: goto -267 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	bkom
    //   0	484	1	paramBitmap	Bitmap
    //   0	484	2	paramLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   4	466	3	bool1	boolean
    //   1	470	4	bool2	boolean
    //   61	414	5	localObject1	Object
    //   97	328	6	localObject2	Object
    //   119	318	7	localObject3	Object
    //   115	302	8	localObject4	Object
    //   111	362	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   72	83	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   197	202	251	java/io/IOException
    //   207	212	259	java/io/IOException
    //   88	99	269	java/lang/Exception
    //   335	340	348	java/io/IOException
    //   320	325	361	java/io/IOException
    //   88	99	369	finally
    //   381	386	398	java/io/IOException
    //   391	396	406	java/io/IOException
    //   99	113	414	finally
    //   121	133	421	finally
    //   141	146	421	finally
    //   154	160	421	finally
    //   168	192	421	finally
    //   291	297	421	finally
    //   305	315	421	finally
    //   99	113	429	java/lang/Exception
    //   121	133	443	java/lang/Exception
    //   141	146	454	java/lang/Exception
    //   154	160	454	java/lang/Exception
    //   168	192	468	java/lang/Exception
  }
  
  private void b()
  {
    QLog.i("MediaChooseJsProxyImpl", 1, "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
    }
  }
  
  private void b(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseCancel(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void b(Activity paramActivity)
  {
    QLog.d("MediaChooseJsProxyImpl", 2, "registerAvatarReceiver");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("get_media_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void chooseMedia(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        if ("chooseMedia".equals(paramString1))
        {
          paramString2 = localJSONObject.optJSONArray("sourceType");
          Object localObject1 = localJSONObject.optJSONArray("mediaType");
          JSONArray localJSONArray = localJSONObject.optJSONArray("sizeType");
          boolean bool = localJSONObject.optString("camera").equals("front");
          if ((paramString2 != null) && (paramString2.length() != 0)) {
            continue;
          }
          paramString2 = new JSONArray();
          paramString2.put("album");
          paramString2.put("camera");
          j = 0;
          long l1;
          if (localObject1 != null)
          {
            if (((JSONArray)localObject1).length() != 0) {
              break label758;
            }
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("MediaChooseJsProxyImpl", 2, "chooseMedia sourceType: " + paramString2 + " length: " + paramString2.length());
            }
            int k = 0;
            if (localJSONArray == null) {
              continue;
            }
            if (localJSONArray.length() != 0) {
              break label773;
            }
            continue;
            l2 = localJSONObject.optInt("maxDuration", 10);
            j = localJSONObject.optInt("count", 9);
            l1 = l2;
            if (l2 >= 3L) {
              continue;
            }
            l1 = 3L;
            continue;
            if (paramString2.length() == 2)
            {
              AppBrandTask.runTaskOnUiThread(new MediaChooseJsProxyImpl.2(this, paramActivity, l2, bool, i, paramInt, j));
              return;
              if (i < paramString2.length())
              {
                Object localObject2 = paramString2.opt(i);
                if ((localObject2.equals("album")) || (localObject2.equals("camera"))) {
                  break label749;
                }
                QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA sourceType error. " + paramString2.opt(i));
                a(paramInt, paramString1, null, "fail sourceType error");
                return;
                if (i < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).opt(i);
                  if ((localObject2.equals("image")) || (localObject2.equals("video"))) {
                    break label764;
                  }
                  QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA mediaType error. " + localObject2);
                  a(paramInt, paramString1, null, "fail mediaType error");
                  return;
                }
                if (((JSONArray)localObject1).length() == 2)
                {
                  i = 0;
                  continue;
                }
                localObject1 = ((JSONArray)localObject1).opt(0);
                if (localObject1.equals("image"))
                {
                  i = 1;
                  continue;
                }
                i = j;
                if (!localObject1.equals("video")) {
                  continue;
                }
                i = 2;
                continue;
                if (j < localJSONArray.length())
                {
                  localObject1 = localJSONArray.opt(j);
                  if ((localObject1.equals("compressed")) || (localObject1.equals("original"))) {
                    break label779;
                  }
                  QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA sizeType error. " + localObject1);
                  a(paramInt, paramString1, null, "fail sizeType error:" + localObject1);
                  return;
                }
                if (localJSONArray.length() == 2)
                {
                  paramInt = 0;
                  continue;
                }
                paramString1 = localJSONArray.opt(0);
                if (paramString1.equals("compressed"))
                {
                  paramInt = 2;
                  continue;
                }
                paramInt = k;
                if (!paramString1.equals("original")) {
                  continue;
                }
                paramInt = 1;
                continue;
              }
            }
            else
            {
              if ("camera".equals(paramString2.optString(0)))
              {
                a(paramActivity, l2, bool, i);
                return;
              }
              if (!"album".equals(paramString2.optString(0))) {
                continue;
              }
              a(paramActivity);
              a(paramActivity, l2, paramInt, i, j);
              return;
            }
            continue;
          }
          i = 0;
          continue;
          paramInt = 0;
          continue;
          long l2 = l1;
          if (l1 <= 30L) {
            continue;
          }
          l2 = 30L;
          continue;
        }
        return;
        i = 0;
        continue;
        i += 1;
      }
      catch (Exception paramActivity)
      {
        return;
      }
      label749:
      continue;
      label758:
      int i = 0;
      continue;
      label764:
      i += 1;
      continue;
      label773:
      int j = 0;
      continue;
      label779:
      j += 1;
    }
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    a();
    super.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkom
 * JD-Core Version:    0.7.0.1
 */