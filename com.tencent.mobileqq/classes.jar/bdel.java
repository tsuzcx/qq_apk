import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class bdel
  extends WebViewPlugin
{
  public BroadcastReceiver a = new bdem(this);
  
  public bdel()
  {
    this.mPluginNameSpace = "ptv";
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoJsApiPlugin", 2, "onActivityResult, requestCode:" + paramInt1 + "，resultCode：" + paramInt2);
    }
    if ((paramInt1 != 11000) || (paramIntent == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getStringExtra("arg_callback");
      } while (TextUtils.isEmpty(str));
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoJsApiPlugin", 2, "startNewPTVActivity" + " result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent)
    {
      return;
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", -1);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoJsApiPlugin", 2, "startNewPTVActivity" + " result:" + paramIntent);
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      int i = ((Integer)paramMap.get("requestCode")).intValue();
      if (i == 11000)
      {
        int j = ((Integer)paramMap.get("resultCode")).intValue();
        a((Intent)paramMap.get("data"), i, j);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoJsApiPlugin", 2, "Call ShortVideoJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("ptv".equals(paramString2))
    {
      if ("GSBase64Encode".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api GSBaze64Encode, args:" + paramVarArgs);
        }
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
      }
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("need_encode_string");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = axqj.a(paramString1);
            paramString2 = new JSONObject();
            paramString2.put("encoded_string", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        boolean bool1;
        if ("isSupportPTV".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportPTV, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              bool1 = bdej.c(this.mRuntime.a());
              paramString1 = new JSONObject();
              paramString1.put("is_support_ptv", bool1);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else
        {
          if ("startNewPTVActivity".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api startPTVActivity, args:" + paramVarArgs);
            }
            if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
              continue;
            }
            try
            {
              localObject = new JSONObject(paramVarArgs[0]);
              str1 = ((JSONObject)localObject).optString("supportvideo");
              str2 = ((JSONObject)localObject).optString("supportphoto");
              str3 = ((JSONObject)localObject).optString("cameramode");
              str4 = ((JSONObject)localObject).optString("beauty");
              str5 = ((JSONObject)localObject).optString("dealtype");
              str6 = ((JSONObject)localObject).optString("callback");
              str7 = ((JSONObject)localObject).optString("supportDD");
              str8 = ((JSONObject)localObject).optString("unfoldDD");
              str9 = ((JSONObject)localObject).optString("DDCategoryName");
              str10 = ((JSONObject)localObject).optString("DDItemID");
              str11 = ((JSONObject)localObject).optString("supportFilter");
              paramString1 = "";
              paramString3 = "";
              paramVarArgs = "";
              paramJsBridgeListener = paramString3;
            }
            catch (JSONException paramJsBridgeListener)
            {
              Object localObject;
              String str1;
              String str2;
              String str3;
              String str4;
              String str5;
              String str6;
              String str7;
              String str8;
              String str9;
              String str10;
              String str11;
              label543:
              paramJsBridgeListener.printStackTrace();
            }
            try
            {
              paramString2 = ((JSONObject)localObject).getString("topicId");
              paramJsBridgeListener = paramString3;
              paramString1 = paramString2;
              paramString3 = ((JSONObject)localObject).getString("topicName");
              paramJsBridgeListener = paramString3;
              paramString1 = paramString2;
              localObject = ((JSONObject)localObject).getString("adtag");
              paramJsBridgeListener = (JsBridgeListener)localObject;
              paramString1 = paramString3;
              paramString3 = paramJsBridgeListener;
              paramJsBridgeListener = paramString1;
              paramString1 = paramString2;
            }
            catch (JSONException paramString2)
            {
              paramString3 = paramVarArgs;
              break label543;
            }
            if (TextUtils.isEmpty(str6)) {
              continue;
            }
            bdej.a(this.mRuntime.a(), str1, str2, str3, str4, str7, str8, str9, str10, str11, str5, str6, paramString1, paramJsBridgeListener, paramString3, 7);
            continue;
            continue;
          }
          if ("isMobileSupportPTV".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isMobileSupportPTV, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = bdej.e(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_mobile_support_ptv", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportDynamicDecoration".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportDynamicDecoration, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = bdej.f(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_DynamicDecoration", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportGestureDecoration".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportGestureDecoration, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              for (;;)
              {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                  if (TextUtils.isEmpty(paramJsBridgeListener)) {
                    break;
                  }
                  bool1 = bdej.c(this.mRuntime.a());
                  boolean bool2 = bdck.c();
                  boolean bool3 = VideoEnvironment.checkAVCodecLoadIsOK(this.mRuntime.a());
                  boolean bool4 = bnky.b(bnkt.b);
                  QLog.i("ShortVideoJsApiPlugin", 1, "call isSupportGestureDecoration isSupportPTV:" + bool1 + ",isSupportGesture:" + bool2);
                  paramString1 = new JSONObject();
                  if ((!bool2) || (!bool1) || (!bool3) || (!bool4)) {
                    break label1095;
                  }
                  bool1 = true;
                  paramString1.put("is_support_GestureDecoration", bool1);
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                }
                catch (JSONException paramJsBridgeListener)
                {
                  paramJsBridgeListener.printStackTrace();
                }
                break;
                label1095:
                bool1 = false;
              }
            }
          }
          else if ("getGestureRecognitionResult".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api getGestureRecognitionResult, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = bbhm.e();
                QLog.i("ShortVideoJsApiPlugin", 1, "call getGestureRecognitionResult result:" + bool1);
                paramString1 = new JSONObject();
                paramString1.put("is_support_GestureDecoration", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportDanceGame".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportDanceGame, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = bdej.g(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_dance_game", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportFaceDanceGame".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportFaceDanceGame, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = bdej.h(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_facedance_game", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else
          {
            int i;
            if ("onClickShareBattle".equals(paramString3))
            {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                paramString1 = paramJsBridgeListener.optString("shareWebUrl");
                i = paramJsBridgeListener.optInt("rank", 0);
                yql.a().a(paramString1, Integer.valueOf(i).toString());
              }
              catch (JSONException paramJsBridgeListener) {}
              if (QLog.isColorLevel())
              {
                QLog.d("ShortVideoJsApiPlugin", 2, "onClickShareBattle error");
                paramJsBridgeListener.printStackTrace();
              }
            }
            else if ("onClickShareVideo".equals(paramString3))
            {
              yql.a().a();
            }
            else if (("startStoryActivity".equals(paramString3)) && (paramVarArgs != null))
            {
              try
              {
                if (paramVarArgs.length <= 0) {
                  continue;
                }
                i = new JSONObject(paramVarArgs[0]).optInt("dealType", 0);
                bdej.a(this.mRuntime.a(), this.mRuntime.a(), i);
              }
              catch (Exception paramJsBridgeListener) {}
              if (QLog.isColorLevel())
              {
                QLog.e("ShortVideoJsApiPlugin", 2, "startStoryActivity exception:", paramJsBridgeListener);
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
    this.mRuntime.a().registerReceiver(this.a, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdel
 * JD-Core Version:    0.7.0.1
 */