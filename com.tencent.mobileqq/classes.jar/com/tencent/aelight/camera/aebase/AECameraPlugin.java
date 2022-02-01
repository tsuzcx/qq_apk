package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEPath;
import com.tencent.aelight.camera.ae.AEPath.PLAY.CACHE;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class AECameraPlugin
  extends WebViewPlugin
{
  private String a;
  private int b = -1;
  private AECameraPlugin.DownloadRunnable c;
  private int d;
  private int e;
  private double f;
  private String g;
  
  static
  {
    File localFile = new File(AEPath.PLAY.CACHE.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (b(BaseApplicationImpl.getContext()))
    {
      localFile = new File(AEPath.a());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
  }
  
  public AECameraPlugin()
  {
    this.mPluginNameSpace = "aecamera";
  }
  
  public static int a(int paramInt)
  {
    return paramInt + (WebViewUtil.a("aecamera") << 8);
  }
  
  private JSONObject a(AECameraEntry paramAECameraEntry, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramString2 == null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("succeeded", true);
        localJSONObject.put("message", "");
        continue;
        localJSONObject.put("succeeded", false);
        localJSONObject.put("message", paramString2);
        if (paramAECameraEntry == null) {
          break label100;
        }
        localJSONObject.put("sourceType", paramAECameraEntry.a());
        localJSONObject.put("sourceBusiness", paramAECameraEntry.b());
      }
      catch (JSONException paramAECameraEntry)
      {
        return localJSONObject;
      }
      localJSONObject.put("activityID", paramAECameraEntry);
      return localJSONObject;
      label100:
      paramAECameraEntry = paramString1;
      if (paramString1 == null) {
        paramAECameraEntry = "";
      }
    }
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt)
  {
    i(paramString);
    paramString = b(paramString, paramInt);
    StringBuilder localStringBuilder = j(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    i(paramString);
    paramString = b(paramString, paramInt1, paramInt2);
    StringBuilder localStringBuilder = j(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    if (paramInt != -1)
    {
      paramIntent = h("not get valid image");
      callJs(this.g, new String[] { paramIntent.toString() });
      return;
    }
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    int j = this.d;
    int i = 400;
    paramInt = j;
    if (j == 0) {
      paramInt = 400;
    }
    j = this.e;
    if (j != 0) {
      i = j;
    }
    ThreadManager.excute(new AECameraPlugin.1(this, paramIntent, paramInt, i), 64, null, true);
  }
  
  private void a(AECameraPlugin.TakePhotoParam paramTakePhotoParam, @NonNull String paramString)
  {
    this.d = paramTakePhotoParam.a;
    this.e = paramTakePhotoParam.b;
    this.g = paramString;
    int i = AECameraEntry.N.a();
    AECameraLauncher.a(this.mRuntime.d(), a(1), i, paramTakePhotoParam);
  }
  
  private void a(@NonNull String paramString)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((AECameraPlugin.DownloadRunnable)localObject).b.equals(paramString)) && (this.b == 1))
    {
      localObject = f(paramString, "downloading canceled");
      callJs(this.c.e, new String[] { ((JSONObject)localObject).toString() });
      ThreadManager.removeJobFromThreadPool(this.c, 128);
    }
    this.c = null;
    this.a = null;
    this.b = -1;
    paramString = new File(f(paramString));
    if (paramString.exists()) {
      FileUtil.a(paramString);
    }
  }
  
  private void a(@Nullable String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    AECameraPrefsUtil.a().a(str, paramString1, 0);
  }
  
  private boolean a()
  {
    if ((this.mRuntime != null) && (this.mRuntime.d() != null) && (this.mRuntime.d().getIntent() != null)) {
      return AECameraEntryManager.g(this.mRuntime.d().getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
    }
    return false;
  }
  
  private String b(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    return paramString.l;
  }
  
  private String b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEPath.PLAY.CACHE.d);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("ae_pic_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpeg");
    localObject = ((StringBuilder)localObject).toString();
    this.f = 0.7D;
    ImageUtil.a(paramString, (String)localObject, paramInt1, paramInt2, (int)(this.f * 100.0D));
    return localObject;
  }
  
  private void b()
  {
    if (this.mRuntime == null) {
      return;
    }
    Intent localIntent;
    if ((!AECameraEntryManager.c(this.mRuntime.d())) && (!AECameraEntryManager.d(this.mRuntime.d())))
    {
      localIntent = new Intent(this.mRuntime.d(), SplashActivity.class);
      QLog.i("AECameraPlugin", 1, "toSourceActivity---to splash");
    }
    else
    {
      localIntent = new Intent(this.mRuntime.d(), QzoneFeedsPluginProxyActivity.class);
      QLog.i("AECameraPlugin", 1, "toSourceActivity---to Qzone Feeds");
    }
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    this.mRuntime.d().startActivity(localIntent);
  }
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2, INetEngineListener paramINetEngineListener)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    localHttpNetReq.mCallback = new AECameraPlugin.5(paramINetEngineListener);
    try
    {
      ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        paramAppInterface.printStackTrace();
      }
    }
    localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
  }
  
  private void b(@NonNull String paramString)
  {
    Object localObject2 = f(paramString);
    String str = g(paramString);
    if (!new File((String)localObject2).exists())
    {
      QQToast.makeText(this.mRuntime.d(), 2131916544, 0).show();
      return;
    }
    paramString = this.mRuntime.d().getIntent();
    Object localObject1;
    if (paramString == null)
    {
      localObject1 = AECameraEntry.a;
      paramString = "";
    }
    else
    {
      localObject1 = AECameraEntry.a(paramString.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      paramString = paramString.getStringExtra("url");
    }
    if ((localObject1 == AECameraEntry.e) && (!TextUtils.isEmpty(paramString)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("file_send_path", (String)localObject2);
      ((Intent)localObject1).putExtra("file_send_duration", ShortVideoUtils.getDuration((String)localObject2));
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      ((Intent)localObject1).putExtra("widgetinfo", paramString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleShareVideo---encodeUrl=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i("AECameraPlugin", 1, ((StringBuilder)localObject2).toString());
      label189:
      ShortVideoForwardManager.a(this.mRuntime.d(), (Intent)localObject1);
      this.mRuntime.d().setResult(-1, (Intent)localObject1);
      this.mRuntime.d().finish();
      return;
      localObject1 = c((String)localObject2, 1);
      try
      {
        try
        {
          if (a())
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("h5_key_flag", true);
            localIntent.putExtra("h5_key_video_path", (String)localObject2);
            localIntent.putExtra("h5_key_thumb_path", str);
            localIntent.putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
            if (localObject1 != null) {
              ImageUtil.b((Bitmap)localObject1, 80, new File(str));
            }
            this.mRuntime.d().setResult(-1, localIntent);
            this.mRuntime.d().finish();
            if (localObject1 != null) {
              ((Bitmap)localObject1).recycle();
            }
            return;
          }
          if (localObject1 != null)
          {
            ImageUtil.b((Bitmap)localObject1, 80, new File(str));
            ShortVideoForwardManager.a(this.mRuntime.d(), (String)localObject2, str, AECameraEntryManager.c(this.mRuntime.d()), a(21));
          }
          else
          {
            QQToast.makeText(this.mRuntime.d(), 2131916544, 0).show();
          }
          if (localObject1 == null) {
            break label450;
          }
        }
        finally
        {
          break label451;
        }
      }
      catch (IOException paramString)
      {
        label424:
        break label424;
      }
      QQToast.makeText(this.mRuntime.d(), 2131916544, 0).show();
      if (localObject1 != null) {
        ((Bitmap)localObject1).recycle();
      }
      label450:
      return;
      label451:
      if (localObject1 != null) {
        ((Bitmap)localObject1).recycle();
      }
      throw paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      break label189;
    }
  }
  
  private void b(@NonNull String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    ThreadManager.excute(new AECameraPlugin.2(this, AECameraPrefsUtil.a().b(str, "", 0), paramString1), 64, null, true);
  }
  
  private static boolean b(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return PermissionUtils.isStorePermissionEnable(paramContext);
  }
  
  private static Bitmap c(@NonNull String paramString, int paramInt)
  {
    Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, paramInt);
    paramString = localBitmap;
    if (localBitmap != null)
    {
      int j = localBitmap.getWidth();
      int k = localBitmap.getHeight();
      int i = k;
      paramInt = j;
      if (j > 300)
      {
        i = (int)(300.0F / j * k);
        paramInt = 300;
      }
      paramString = ThumbnailUtils.extractThumbnail(localBitmap, paramInt, i, 2);
    }
    return paramString;
  }
  
  private void c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", true);
      localJSONObject.put("message", "download success");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.a.equals(paramString1)))
    {
      int i = this.b;
      if ((i == 1) || (i == 2)) {
        return;
      }
    }
    a(paramString1);
    this.a = paramString1;
    this.b = 1;
    String str = f(paramString1);
    AECameraPlugin.3 local3 = new AECameraPlugin.3(this, paramString1, paramString2, str);
    this.c = new AECameraPlugin.DownloadRunnable(null);
    this.c.a = this.mRuntime.b();
    AECameraPlugin.DownloadRunnable localDownloadRunnable = this.c;
    localDownloadRunnable.b = paramString1;
    localDownloadRunnable.c = str;
    localDownloadRunnable.d = local3;
    localDownloadRunnable.e = paramString2;
    ThreadManager.excute(localDownloadRunnable, 128, null, true);
  }
  
  /* Error */
  private void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   7: invokevirtual 255	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +14 -> 26
    //   15: getstatic 259	com/tencent/aelight/camera/entry/api/AECameraEntry:a	Lcom/tencent/aelight/camera/entry/api/AECameraEntry;
    //   18: astore 4
    //   20: ldc 101
    //   22: astore_3
    //   23: goto +29 -> 52
    //   26: aload_3
    //   27: ldc_w 257
    //   30: getstatic 259	com/tencent/aelight/camera/entry/api/AECameraEntry:a	Lcom/tencent/aelight/camera/entry/api/AECameraEntry;
    //   33: invokevirtual 111	com/tencent/aelight/camera/entry/api/AECameraEntry:a	()I
    //   36: invokevirtual 263	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   39: invokestatic 452	com/tencent/aelight/camera/entry/api/AECameraEntry:a	(I)Lcom/tencent/aelight/camera/entry/api/AECameraEntry;
    //   42: astore 4
    //   44: aload_3
    //   45: ldc_w 454
    //   48: invokevirtual 158	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload 4
    //   54: getstatic 456	com/tencent/aelight/camera/entry/api/AECameraEntry:e	Lcom/tencent/aelight/camera/entry/api/AECameraEntry;
    //   57: if_acmpne +126 -> 183
    //   60: aload_3
    //   61: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +119 -> 183
    //   67: new 154	android/content/Intent
    //   70: dup
    //   71: invokespecial 457	android/content/Intent:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: ldc_w 459
    //   81: aload_1
    //   82: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   85: pop
    //   86: aload 4
    //   88: ldc_w 584
    //   91: iconst_1
    //   92: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   95: pop
    //   96: aload_3
    //   97: ldc_w 476
    //   100: invokestatic 482	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_1
    //   104: aload 4
    //   106: ldc_w 484
    //   109: aload_1
    //   110: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   113: pop
    //   114: new 290	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   121: astore_3
    //   122: aload_3
    //   123: ldc_w 586
    //   126: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: aload_1
    //   132: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc_w 334
    //   139: iconst_1
    //   140: aload_3
    //   141: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   151: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   154: aload 4
    //   156: invokestatic 491	com/tencent/aelight/camera/aioeditor/takevideo/ShortVideoForwardManager:a	(Landroid/app/Activity;Landroid/content/Intent;)V
    //   159: aload_0
    //   160: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   163: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   166: iconst_m1
    //   167: aload 4
    //   169: invokevirtual 495	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   172: aload_0
    //   173: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   176: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   179: invokevirtual 498	android/app/Activity:finish	()V
    //   182: return
    //   183: aload_0
    //   184: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   187: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   190: invokestatic 325	com/tencent/aelight/camera/ae/entry/AECameraEntryManager:c	(Landroid/app/Activity;)Z
    //   193: istore_2
    //   194: aload_0
    //   195: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   198: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   201: aload_1
    //   202: iload_2
    //   203: iconst_4
    //   204: invokestatic 589	com/tencent/aelight/camera/aioeditor/takevideo/ShortVideoForwardManager:a	(Landroid/app/Activity;Ljava/lang/String;ZI)V
    //   207: return
    //   208: astore_1
    //   209: goto +22 -> 231
    //   212: aload_0
    //   213: getfield 188	com/tencent/aelight/camera/aebase/AECameraPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   216: invokevirtual 193	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   219: ldc_w 439
    //   222: iconst_0
    //   223: invokestatic 445	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   226: invokevirtual 449	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   229: pop
    //   230: return
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: goto -87 -> 147
    //   237: astore_1
    //   238: goto -26 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	AECameraPlugin
    //   0	241	1	paramString	String
    //   193	10	2	bool	boolean
    //   10	131	3	localObject1	Object
    //   18	150	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   183	207	208	finally
    //   212	230	208	finally
    //   96	147	233	java/io/UnsupportedEncodingException
    //   183	207	237	java/lang/Exception
  }
  
  private void d(String paramString1, String paramString2)
  {
    String str = f(paramString1);
    if (!new File(str).exists())
    {
      b(this.mRuntime.b(), paramString1, str, new AECameraPlugin.4(this, str, paramString2));
      return;
    }
    c(paramString2);
    d(str);
  }
  
  private JSONObject e(@NonNull String paramString1, @Nullable String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", true);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("message", paramString2);
      }
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private void e(String paramString)
  {
    Object localObject = this.mRuntime.d().getIntent();
    String str = this.mRuntime.d().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (localObject == null) {
      localObject = a(AECameraEntry.a, str, "intent is null ");
    } else {
      localObject = a(AECameraEntry.a(((Intent)localObject).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a())), str, null);
    }
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
  }
  
  private String f(@NonNull String paramString)
  {
    Object localObject = paramString.split("\\.");
    localObject = localObject[(localObject.length - 1)];
    if (b(this.mRuntime.d()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEPath.a());
      localStringBuilder.append(paramString.hashCode());
      localStringBuilder.append(".");
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.PLAY.CACHE.d);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString.hashCode());
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private JSONObject f(@NonNull String paramString1, @NonNull String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString2);
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private String g(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.PLAY.CACHE.d);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString.hashCode());
    localStringBuilder.append("_thumb.jpg");
    return localStringBuilder.toString();
  }
  
  private JSONObject h(@NonNull String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  private void i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(paramString);
      if ((((File)localObject).exists()) && (((File)localObject).length() >= 3L))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = ((BitmapFactory.Options)localObject).outWidth;
        int j = ((BitmapFactory.Options)localObject).outHeight;
        if ((i >= 0) && (j >= 0)) {
          return;
        }
        throw new IOException();
      }
      throw new IOException();
    }
    throw new IOException();
  }
  
  private StringBuilder j(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    paramString = localOptions.outMimeType;
    if ((!"image/png".equalsIgnoreCase(paramString)) && (!"image/gif".equals(paramString)) && (!"image/bmp".equals(paramString)))
    {
      paramString = new StringBuilder("data:image/jpeg;base64,");
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    }
    else
    {
      paramString = new StringBuilder("data:image/png;base64,");
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    }
    localBitmap.recycle();
    paramString.append(Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
    return paramString;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("aecamera".equals(paramString2))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      if ("takePhoto".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = new AECameraPlugin.TakePhotoParam();
          paramString1.a = paramJsBridgeListener.getInt("outMaxWidth");
          paramString1.b = paramJsBridgeListener.getInt("outMaxHeight");
          paramString1.c = paramJsBridgeListener.optDouble("compression");
          paramString1.d = paramJsBridgeListener.optBoolean("backDevicePosition");
          paramString1.e = paramJsBridgeListener.optString("guideImage");
          paramString1.f = paramJsBridgeListener.optBoolean("enableCountDown");
          paramString1.g = paramJsBridgeListener.optBoolean("sensitiveValidate");
          paramString1.h = paramJsBridgeListener.optBoolean("disableFaceDetect");
          a(paramString1, paramJsBridgeListener.getString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("setLastSelectedPicture".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          a(paramJsBridgeListener.optString("picPath"), paramJsBridgeListener.optString("id"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("getLastSelectedPicture".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("id");
          b(paramJsBridgeListener.optString("callback"), paramString1);
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("downloadVideo".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          c(paramJsBridgeListener.optString("videoUrl"), paramJsBridgeListener.optString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("cancelDownload".equals(paramString3))
      {
        try
        {
          a(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("shareVideo".equals(paramString3))
      {
        try
        {
          b(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("sharePic".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          d(paramJsBridgeListener.optString("picUrl"), paramJsBridgeListener.optString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label600;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("runtimeContext".equals(paramString3))
      {
        try
        {
          e(new JSONObject(paramVarArgs[0]).optString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
      label600:
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 1) {
      a(paramIntent, paramInt);
    } else if ((paramByte == 21) && (paramInt == -1)) {
      b();
    }
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin
 * JD-Core Version:    0.7.0.1
 */