import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneUiJsPlugin.1;
import cooperation.qzone.webviewplugin.QzoneUiJsPlugin.2;
import cooperation.qzone.webviewplugin.QzoneUiJsPlugin.3;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bhtg
  extends bhsh
  implements bhlf
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bhth(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  private JSONObject a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("param.videoPath");
    int i = paramIntent.getIntExtra("param.videoType", 0);
    Object localObject2 = paramIntent.getStringExtra("param.content");
    long l1 = paramIntent.getLongExtra("param.videoSize", 0L);
    String str1 = paramIntent.getStringExtra("param.thumbnailPath");
    long l2 = paramIntent.getLongExtra("param.duration", 0L);
    long l3 = paramIntent.getLongExtra("param.startTime", 0L);
    long l4 = paramIntent.getLongExtra("param.totalDuration", 0L);
    boolean bool1 = paramIntent.getBooleanExtra("param.needProcess", true);
    boolean bool2 = paramIntent.getBooleanExtra("param.topicSyncQzone", false);
    String str2 = paramIntent.getStringExtra("param.newFakeVid");
    Bundle localBundle = paramIntent.getBundleExtra("param.extras");
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("videoPath", localObject1);
      paramIntent.put("videoType", i);
      paramIntent.put("content", localObject2);
      paramIntent.put("videoSize", l1);
      paramIntent.put("thumbnailPath", str1);
      paramIntent.put("duration", l2);
      paramIntent.put("totalDuration", l4);
      paramIntent.put("needProcess", bool1);
      paramIntent.put("syncQzone", bool2);
      paramIntent.put("fakeVid", str2);
      paramIntent.put("startTime", l3);
      localObject1 = new JSONObject();
      if (localBundle != null)
      {
        localObject2 = localBundle.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(str1, localBundle.getInt(str1));
        }
      }
      paramIntent.put("encodeExtras", localObject1);
    }
    catch (JSONException localJSONException)
    {
      QLog.w("QzoneUiJsPlugin", 1, "convertVideoInfoToJson error", localJSONException);
      return paramIntent;
    }
    return paramIntent;
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneUiJsPlugin", 4, "handleRecordVideo json=" + paramString);
    }
    b();
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("callback");
        if (!TextUtils.isEmpty(str1))
        {
          this.c = str1;
          str1 = paramString.optString("ptv_id");
          String str2 = paramString.optString("confirm_btn_text");
          j = paramString.optInt("need_input_text", 0);
          if (j == 0) {
            break label507;
          }
          i = paramString.optInt("need_sync_qzone", 0);
          k = paramString.optInt("is_original_video", 0);
          m = paramString.optInt("need_edit_video", 0);
          boolean bool6 = paramString.optBoolean("support_local_video", true);
          Object localObject = paramString.optJSONObject("last_video");
          if ((localObject != null) && (((JSONObject)localObject).optInt("videoType") == 0))
          {
            localObject = ((JSONObject)localObject).optString("videoPath");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bhtm.class).post(new QzoneUiJsPlugin.1(this, (String)localObject));
            }
          }
          localObject = new Intent();
          bool1 = paramString.optBoolean("support_beauty", true);
          bool2 = paramString.optBoolean("support_dd", true);
          bool3 = paramString.optBoolean("support_filter", true);
          bool4 = paramString.optBoolean("dd_category_unfold", false);
          String str3 = paramString.optString("dd_category_name");
          String str4 = paramString.optString("dd_item_id");
          bool5 = paramString.optBoolean("filter_category_unfold", false);
          String str5 = paramString.optString("filter_category_name");
          String str6 = paramString.optString("filter_item_id");
          int n = paramString.optInt("force_camera", 0);
          ((Intent)localObject).putExtra("PeakConstants.ARG_BEAUTY", bool1);
          ((Intent)localObject).putExtra("PeakConstants.ARG_SUPPORT_DD", bool2);
          ((Intent)localObject).putExtra("PeakConstants.ARG_SUPPORT_FILTER", bool3);
          ((Intent)localObject).putExtra("PeakConstants.ARG_UNFOLD_DD", bool4);
          ((Intent)localObject).putExtra("PeakConstants.ARG_DD_CATEGORY_NAME", str3);
          ((Intent)localObject).putExtra("PeakConstants.ARG_DD_ITEM_ID", str4);
          ((Intent)localObject).putExtra("PeakConstants.ARG_UNFOLD_FILTER", bool5);
          ((Intent)localObject).putExtra("PeakConstants.ARG_FILTER_CATEGORY_NAME", str5);
          ((Intent)localObject).putExtra("PeakConstants.ARG_FILTER_ITEM_ID", str6);
          ((Intent)localObject).putExtra("PeakConstants.ARG_FORCE_CAMERA", n);
          paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
          if (bgzx.a().a() > 0)
          {
            bool1 = true;
            break label512;
            bgzt.a(paramString, "ref_h5_record_video", bool1, bool2, bool3, bool4, bool5, bool6, str1, str2, (Intent)localObject);
          }
        }
        else
        {
          return;
        }
        boolean bool1 = false;
      }
      catch (JSONException paramString)
      {
        QLog.w("QzoneUiJsPlugin", 1, "handleRecordVideo error", paramString);
        return;
      }
      boolean bool2 = false;
      break label519;
      boolean bool3 = false;
      break label527;
      boolean bool4 = false;
      break label534;
      boolean bool5 = false;
      continue;
      label507:
      int i = 0;
      continue;
      label512:
      if (j > 0)
      {
        bool2 = true;
        label519:
        if (m > 0)
        {
          bool3 = true;
          label527:
          if (i > 0)
          {
            bool4 = true;
            label534:
            if (k > 0) {
              bool5 = true;
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qzone.topic.video.FakeFeed");
    localIntentFilter.addAction("com.qzone.topic.video.HalfFakeFeed");
    localIntentFilter.addAction("com.qzone.h5.video.recordCallback");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneUiJsPlugin", 4, "handlePreviewVideo json=" + paramString);
    }
    int i;
    long l1;
    long l2;
    Bundle localBundle;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).optJSONObject("video_info");
      if (localJSONObject == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "handlePreviewVideo video_info is empty");
        return;
      }
      paramString = localJSONObject.optString("videoPath");
      i = localJSONObject.optInt("videoType");
      l1 = localJSONObject.optLong("startTime");
      l2 = localJSONObject.optLong("duration");
      localJSONObject = localJSONObject.optJSONObject("encodeExtras");
      localBundle = new Bundle();
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putInt(str, localJSONObject.optInt(str));
        }
      }
      if (i != 0) {
        break label201;
      }
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handlePreviewVideo error", paramString);
      return;
    }
    bgzt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), i, paramString, l2, localBundle);
    return;
    label201:
    if (i == 1) {
      bgyp.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), bgyw.a(), i, paramString, l1, l1 + l2);
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneUiJsPlugin", 4, "handleUploadVideo json=" + paramString);
    }
    try
    {
      if (new JSONObject(paramString).optJSONObject("video_info") == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "handleUploadVideo video_info is empty");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bhtm.class).post(new QzoneUiJsPlugin.2(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handleUploadVideo error", paramString);
    }
  }
  
  private void d(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneUiJsPlugin", 4, "handleGetVideoCover json=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("callback");
      if (!TextUtils.isEmpty(str))
      {
        this.b = str;
        paramString = paramString.getString("timestamp");
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(bhtm.class).post(new QzoneUiJsPlugin.3(this, paramString));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneUiJsPlugin", 1, "handleGetVideoCover error", paramString);
    }
  }
  
  private void e(String paramString)
  {
    boolean bool2 = false;
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneUiJsPlugin", 4, "handleTopicUploadVideo json=" + paramString);
    }
    b();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.getString("callback");
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaLangString = str;
        }
        str = paramString.getString("topicId");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if ("ptucamera".equals(paramString.optString("shoot")))
        {
          bool1 = true;
          paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
          if (bgzx.a().a() > 0) {
            bool2 = true;
          }
          bgzt.a(0L, paramString, true, true, "QZonePublishMoodTabActivity", bool2, true, str, bool1, null, null, null);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo error", paramString);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
    bhlc.a().b(this);
    super.a();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"qzui".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null)) {
      return false;
    }
    if (("topicUploadVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      e(paramVarArgs[0]);
      return true;
    }
    if (("getVideoFaceData".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      bhlc.a().a(this);
      d(paramVarArgs[0]);
      return true;
    }
    if (("recordVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if (("previewVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      b(paramVarArgs[0]);
      return true;
    }
    if (("uploadVideo".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      c(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("QzoneUiJsPlugin", 1, "call js function,bundle is empty");
        return;
      }
    } while ((!"cmd.videoGetFakeFeedCover".equals(paramString)) || (TextUtils.isEmpty(this.b)));
    paramString = paramBundle.getString("param.videoCoverPath");
    int i = paramBundle.getInt("param.videoCoverWidth", 0);
    int j = paramBundle.getInt("param.videoCoverHeight", 0);
    paramBundle = paramBundle.getString("param.videoClientKey");
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = bhsc.a(paramString, i, j))
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("code", 0);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("msg", "");
        localJSONObject2.put("base64", "data:image/jpg;base64," + paramString);
        localJSONObject2.put("timestamp", paramBundle);
        localJSONObject2.put("isFakeFeed", true);
        localJSONObject1.put("data", localJSONObject2);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.b, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        QLog.w("QzoneUiJsPlugin", 1, "topicUploadVideo fake feed  callback error", paramString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhtg
 * JD-Core Version:    0.7.0.1
 */