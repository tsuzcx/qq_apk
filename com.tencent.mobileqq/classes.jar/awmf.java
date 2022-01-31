import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class awmf
  extends WebViewPlugin
{
  public BroadcastReceiver a = new awmg(this);
  
  public awmf()
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
            paramString1 = asfj.a(paramString1);
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
              bool1 = awmd.c(this.mRuntime.a());
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
        else if ("startNewPTVActivity".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api startPTVActivity, args:" + paramVarArgs);
          }
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            continue;
          }
          try
          {
            localObject2 = new JSONObject(paramVarArgs[0]);
            str4 = ((JSONObject)localObject2).optString("supportvideo");
            str5 = ((JSONObject)localObject2).optString("supportphoto");
            str6 = ((JSONObject)localObject2).optString("cameramode");
            str7 = ((JSONObject)localObject2).optString("beauty");
            str8 = ((JSONObject)localObject2).optString("dealtype");
            str9 = ((JSONObject)localObject2).optString("callback");
            str10 = ((JSONObject)localObject2).optString("supportDD");
            str11 = ((JSONObject)localObject2).optString("unfoldDD");
            str12 = ((JSONObject)localObject2).optString("DDCategoryName");
            str13 = ((JSONObject)localObject2).optString("DDItemID");
            str14 = ((JSONObject)localObject2).optString("supportFilter");
            str15 = ((JSONObject)localObject2).optString("unfoldFilter");
            str16 = ((JSONObject)localObject2).optString("filterCategoryName");
            str17 = ((JSONObject)localObject2).optString("filterItemID");
            str18 = ((JSONObject)localObject2).optString("supportSubtitle");
            str19 = ((JSONObject)localObject2).optString("activityType");
            paramString3 = "";
          }
          catch (JSONException paramJsBridgeListener)
          {
            Object localObject2;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            label540:
            String str1;
            paramJsBridgeListener.printStackTrace();
          }
        }
        try
        {
          paramJsBridgeListener = ((JSONObject)localObject2).getString("activityId");
          paramString3 = paramJsBridgeListener;
        }
        catch (JSONException paramJsBridgeListener)
        {
          int i;
          break label540;
        }
        paramString1 = "";
        Object localObject1 = "";
        str1 = "";
        String str2 = "";
        paramString2 = str1;
        paramJsBridgeListener = (JsBridgeListener)localObject1;
        try
        {
          paramVarArgs = ((JSONObject)localObject2).getString("callerType");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          localObject1 = ((JSONObject)localObject2).getString("topicId");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          str1 = ((JSONObject)localObject2).getString("topicName");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          str3 = ((JSONObject)localObject2).getString("adtag");
          paramJsBridgeListener = str3;
          paramString2 = str1;
          paramString1 = (String)localObject1;
          localObject1 = paramJsBridgeListener;
          paramJsBridgeListener = paramString1;
          paramString1 = paramVarArgs;
        }
        catch (JSONException paramVarArgs)
        {
          for (;;)
          {
            String str3;
            String str20;
            String str21;
            String str22;
            bhev localbhev;
            localObject1 = str2;
          }
        }
        paramVarArgs = ((JSONObject)localObject2).optString("supportCombo", "1");
        str1 = ((JSONObject)localObject2).optString("unfoldCombo");
        str2 = ((JSONObject)localObject2).optString("comboCategoryName");
        str3 = ((JSONObject)localObject2).optString("comboId");
        str20 = ((JSONObject)localObject2).optString("supportMusic", "1");
        str21 = ((JSONObject)localObject2).optString("unfoldMusic");
        str22 = ((JSONObject)localObject2).optString("musicCategoryName");
        localObject2 = ((JSONObject)localObject2).optString("musicId");
        localbhev = new bhev();
        localbhev.a = paramVarArgs;
        localbhev.b = str1;
        localbhev.c = str2;
        localbhev.d = str3;
        localbhev.e = str20;
        localbhev.f = str21;
        localbhev.g = str22;
        localbhev.h = ((String)localObject2);
        if (!TextUtils.isEmpty(str9))
        {
          awmd.a(this.mRuntime.a(), this.mRuntime.a(), str4, str5, str6, str7, str10, str11, str12, str13, str14, str15, str16, str17, str18, str8, str19, paramString3, str9, paramString1, paramJsBridgeListener, paramString2, (String)localObject1, localbhev);
          continue;
          continue;
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
                bool1 = awmd.e(this.mRuntime.a());
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
                bool1 = awmd.f(this.mRuntime.a());
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
                  bool1 = awmd.c(this.mRuntime.a());
                  boolean bool2 = awjy.c();
                  boolean bool3 = VideoEnvironment.e(this.mRuntime.a());
                  boolean bool4 = awlw.a(BaseApplicationImpl.getContext());
                  QLog.i("ShortVideoJsApiPlugin", 1, "call isSupportGestureDecoration isSupportPTV:" + bool1 + ",isSupportGesture:" + bool2);
                  paramString1 = new JSONObject();
                  if ((!bool2) || (!bool1) || (!bool3) || (!bool4)) {
                    break label1364;
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
                label1364:
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
                bool1 = autt.e();
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
                bool1 = awmd.g(this.mRuntime.a());
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
                bool1 = awmd.h(this.mRuntime.a());
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
          else if ("onClickShareBattle".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("shareWebUrl");
              i = paramJsBridgeListener.optInt("rank", 0);
              uxj.a().a(paramString1, Integer.valueOf(i).toString());
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
            uxj.a().b();
          }
          else if (("startStoryActivity".equals(paramString3)) && (paramVarArgs != null))
          {
            try
            {
              if (paramVarArgs.length <= 0) {
                continue;
              }
              i = new JSONObject(paramVarArgs[0]).optInt("dealType", 0);
              awmd.a(this.mRuntime.a(), this.mRuntime.a(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awmf
 * JD-Core Version:    0.7.0.1
 */