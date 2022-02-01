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
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private AECameraPlugin.DownloadRunnable jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
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
  
  private static int a(int paramInt)
  {
    return paramInt + (WebViewUtil.a("aecamera") << 8);
  }
  
  private static Bitmap a(@NonNull String paramString, int paramInt)
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
  
  private String a(@NonNull String paramString)
  {
    Object localObject = paramString.split("\\.");
    localObject = localObject[(localObject.length - 1)];
    if (b(this.mRuntime.a()))
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
  
  private String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    return paramString.e;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEPath.PLAY.CACHE.d);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("ae_pic_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpeg");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_Double = 0.7D;
    ImageUtil.a(paramString, (String)localObject, paramInt1, paramInt2, (int)(this.jdField_a_of_type_Double * 100.0D));
    return localObject;
  }
  
  private StringBuilder a(String paramString)
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
          break label108;
        }
        localJSONObject.put("sourceType", paramAECameraEntry.a());
        localJSONObject.put("sourceBusiness", paramAECameraEntry.a());
      }
      catch (JSONException paramAECameraEntry)
      {
        return localJSONObject;
      }
      localJSONObject.put("activityID", paramAECameraEntry);
      return localJSONObject;
      label108:
      paramAECameraEntry = paramString1;
      if (paramString1 == null) {
        paramAECameraEntry = "";
      }
    }
  }
  
  private JSONObject a(@NonNull String paramString)
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
  
  private JSONObject a(@Nullable String paramString, int paramInt)
  {
    d(paramString);
    paramString = a(paramString, paramInt);
    StringBuilder localStringBuilder = a(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    d(paramString);
    paramString = a(paramString, paramInt1, paramInt2);
    StringBuilder localStringBuilder = a(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject a(@NonNull String paramString1, @Nullable String paramString2)
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
  
  private void a()
  {
    if (this.mRuntime == null) {
      return;
    }
    Intent localIntent;
    if ((!AECameraEntryManager.c(this.mRuntime.a())) && (!AECameraEntryManager.d(this.mRuntime.a()))) {
      localIntent = new Intent(this.mRuntime.a(), SplashActivity.class);
    } else {
      localIntent = new Intent(this.mRuntime.a(), QzoneFeedsPluginProxyActivity.class);
    }
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    if (paramInt != -1)
    {
      paramIntent = a("not get valid image");
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent.toString() });
      return;
    }
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    int j = this.jdField_b_of_type_Int;
    int i = 400;
    paramInt = j;
    if (j == 0) {
      paramInt = 400;
    }
    j = this.c;
    if (j != 0) {
      i = j;
    }
    ThreadManager.excute(new AECameraPlugin.1(this, paramIntent, paramInt, i), 64, null, true);
  }
  
  private void a(AECameraPlugin.TakePhotoParam paramTakePhotoParam, @NonNull String paramString)
  {
    this.jdField_b_of_type_Int = paramTakePhotoParam.jdField_a_of_type_Int;
    this.c = paramTakePhotoParam.jdField_b_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramString;
    int i = AECameraEntry.L.a();
    AECameraLauncher.a(this.mRuntime.a(), a(1), i, paramTakePhotoParam);
  }
  
  private void a(@NonNull String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable;
    if ((localObject != null) && (((AECameraPlugin.DownloadRunnable)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (this.jdField_a_of_type_Int == 1))
    {
      localObject = b(paramString, "downloading canceled");
      callJs(this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable.c, new String[] { ((JSONObject)localObject).toString() });
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable, 128);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    paramString = new File(a(paramString));
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
    if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getIntent() != null)) {
      return AECameraEntryManager.g(this.mRuntime.a().getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
    }
    return false;
  }
  
  private String b(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.PLAY.CACHE.d);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString.hashCode());
    localStringBuilder.append("_thumb.jpg");
    return localStringBuilder.toString();
  }
  
  private JSONObject b(@NonNull String paramString1, @NonNull String paramString2)
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
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2, INetEngineListener paramINetEngineListener)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    localHttpNetReq.mCallback = new AECameraPlugin.4(paramINetEngineListener);
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
    String str1 = a(paramString);
    String str2 = b(paramString);
    if (!new File(str1).exists())
    {
      QQToast.a(this.mRuntime.a(), 2131719009, 0).a();
      return;
    }
    paramString = this.mRuntime.a().getIntent();
    Object localObject;
    if (paramString == null)
    {
      localObject = AECameraEntry.a;
      paramString = "";
    }
    else
    {
      localObject = AECameraEntry.a(paramString.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      paramString = paramString.getStringExtra("url");
    }
    if ((localObject == AECameraEntry.e) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("file_send_path", str1);
      ((Intent)localObject).putExtra("file_send_duration", ShortVideoUtils.getDuration(str1));
    }
    try
    {
      ((Intent)localObject).putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
      label155:
      this.mRuntime.a().setResult(-1, (Intent)localObject);
      this.mRuntime.a().finish();
      return;
      localObject = a(str1, 1);
      label405:
      label406:
      try
      {
        try
        {
          if (a())
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("h5_key_flag", true);
            localIntent.putExtra("h5_key_video_path", str1);
            localIntent.putExtra("h5_key_thumb_path", str2);
            localIntent.putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
            if (localObject != null) {
              ImageUtil.b((Bitmap)localObject, 80, new File(str2));
            }
            this.mRuntime.a().setResult(-1, localIntent);
            this.mRuntime.a().finish();
            if (localObject != null) {
              ((Bitmap)localObject).recycle();
            }
            return;
          }
          if (localObject != null)
          {
            ImageUtil.b((Bitmap)localObject, 80, new File(str2));
            ShortVideoForwardManager.a(this.mRuntime.a(), str1, str2, AECameraEntryManager.c(this.mRuntime.a()), a(21));
          }
          else
          {
            QQToast.a(this.mRuntime.a(), 2131719009, 0).a();
          }
          if (localObject == null) {
            break label405;
          }
        }
        finally
        {
          break label406;
        }
      }
      catch (IOException paramString)
      {
        label379:
        break label379;
      }
      QQToast.a(this.mRuntime.a(), 2131719009, 0).a();
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      return;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      throw paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      break label155;
    }
  }
  
  private void b(@NonNull String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    ThreadManager.excute(new AECameraPlugin.2(this, AECameraPrefsUtil.a().a(str, "", 0), paramString1), 64, null, true);
  }
  
  private static boolean b(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return PermissionUtils.isStorePermissionEnable(paramContext);
  }
  
  private void c(String paramString)
  {
    Object localObject = this.mRuntime.a().getIntent();
    String str = this.mRuntime.a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (localObject == null) {
      localObject = a(AECameraEntry.a, str, "intent is null ");
    } else {
      localObject = a(AECameraEntry.a(((Intent)localObject).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a())), str, null);
    }
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
  }
  
  private void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      int i = this.jdField_a_of_type_Int;
      if ((i == 1) || (i == 2)) {
        return;
      }
    }
    a(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = 1;
    String str = a(paramString1);
    AECameraPlugin.3 local3 = new AECameraPlugin.3(this, paramString1, paramString2, str);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable = new AECameraPlugin.DownloadRunnable(null);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    AECameraPlugin.DownloadRunnable localDownloadRunnable = this.jdField_a_of_type_ComTencentAelightCameraAebaseAECameraPlugin$DownloadRunnable;
    localDownloadRunnable.jdField_a_of_type_JavaLangString = paramString1;
    localDownloadRunnable.jdField_b_of_type_JavaLangString = str;
    localDownloadRunnable.jdField_a_of_type_ComTencentMobileqqTransfileINetEngineListener = local3;
    localDownloadRunnable.c = paramString2;
    ThreadManager.excute(localDownloadRunnable, 128, null, true);
  }
  
  private void d(String paramString)
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
          paramString1.jdField_a_of_type_Int = paramJsBridgeListener.getInt("outMaxWidth");
          paramString1.jdField_b_of_type_Int = paramJsBridgeListener.getInt("outMaxHeight");
          paramString1.jdField_a_of_type_Double = paramJsBridgeListener.optDouble("compression");
          paramString1.jdField_a_of_type_Boolean = paramJsBridgeListener.optBoolean("backDevicePosition");
          paramString1.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("guideImage");
          paramString1.jdField_b_of_type_Boolean = paramJsBridgeListener.optBoolean("enableCountDown");
          paramString1.c = paramJsBridgeListener.optBoolean("sensitiveValidate");
          paramString1.d = paramJsBridgeListener.optBoolean("disableFaceDetect");
          a(paramString1, paramJsBridgeListener.getString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label536;
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
            break label536;
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
            break label536;
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
            break label536;
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
            break label536;
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
            break label536;
          }
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
      }
      else if ("runtimeContext".equals(paramString3))
      {
        try
        {
          c(new JSONObject(paramVarArgs[0]).optString("callback"));
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
      label536:
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 1) {
      a(paramIntent, paramInt);
    } else if ((paramByte == 21) && (paramInt == -1)) {
      a();
    }
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AECameraPlugin
 * JD-Core Version:    0.7.0.1
 */