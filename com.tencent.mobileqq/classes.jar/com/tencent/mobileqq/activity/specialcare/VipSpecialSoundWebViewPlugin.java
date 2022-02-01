package com.tencent.mobileqq.activity.specialcare;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateCallback;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VipSpecialSoundWebViewPlugin
  extends VasWebviewJsPlugin
{
  private IQvipSpecialSoundManager a = null;
  private MediaPlayerHelper b = MediaPlayerHelper.a();
  
  public VipSpecialSoundWebViewPlugin()
  {
    this.mPluginNameSpace = "specialRing";
  }
  
  private String a(int paramInt)
  {
    if (paramInt != -3)
    {
      if (paramInt != -2)
      {
        if (paramInt != -1)
        {
          if (paramInt != 0)
          {
            if (paramInt != 10010)
            {
              if (paramInt != 11001)
              {
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    return "UNKNOWN ERROR";
                  case 20004: 
                    return "E_OIDB_PB_UNPACK_ERR";
                  case 20003: 
                    return "E_OIDB_PB_PACK_ERR";
                  case 20002: 
                    return "ERR_OIDB_PB_SR_ERR";
                  }
                  return "ERR_OIDB_INIT_ERR";
                case 10005: 
                  return "ERR_GET_CLUBINFO_ERROR";
                case 10004: 
                  return "ERR_CLEAR_REMIND_ERROR";
                case 10003: 
                  return "ERR_SET_REMIND_ERROR";
                case 10002: 
                  return "ERR_INVALID_ARGUMENT";
                }
                return "ERR_METHOD_NOT_SUPPORT";
              }
              return "ERR_PROTO_SERIAL_ERR";
            }
            return "ERR_SET_QUOTA_LIMIT";
          }
          return "SUCC";
        }
        return "ERR_NO_NETWORK";
      }
      return "ERR_REQUEST_TIMEOUT";
    }
    return "ERR_ANDROID_ERROR";
  }
  
  /* Error */
  private void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +54 -> 58
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: new 81	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 90	java/lang/String:getBytes	()[B
    //   26: invokevirtual 94	java/io/FileOutputStream:write	([B)V
    //   29: aload_1
    //   30: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   33: return
    //   34: astore_3
    //   35: aload_1
    //   36: astore_2
    //   37: aload_3
    //   38: astore_1
    //   39: goto +9 -> 48
    //   42: goto +12 -> 54
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   52: aload_1
    //   53: athrow
    //   54: aload_1
    //   55: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   58: return
    //   59: astore_1
    //   60: aload 4
    //   62: astore_1
    //   63: goto -9 -> 54
    //   66: astore_2
    //   67: goto -25 -> 42
    //   70: astore_1
    //   71: return
    //   72: astore_2
    //   73: goto -21 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	VipSpecialSoundWebViewPlugin
    //   0	76	1	paramFile	File
    //   0	76	2	paramString	String
    //   11	1	3	localObject1	Object
    //   34	13	3	localObject2	Object
    //   8	53	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	29	34	finally
    //   12	21	45	finally
    //   12	21	59	java/io/IOException
    //   21	29	66	java/io/IOException
    //   29	33	70	java/io/IOException
    //   54	58	70	java/io/IOException
    //   48	52	72	java/io/IOException
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QVipSpecialSoundWebViewPlugin", 2, paramString);
    }
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    a("-->onSetRingForFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", a(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->set ring failed, error:");
      localStringBuilder.append(a(i));
      a(localStringBuilder.toString());
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", a(i));
    }
    else
    {
      a("-->set ring ok!");
      paramBundle.put("code", 0);
    }
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private void a(String paramString, List<QvipSpecialSoundConfig.SpecialSound> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->responseRingsList,callback:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",list:");
    ((StringBuilder)localObject).append(paramList);
    a(((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      if ((paramList != null) && (paramList.size() > 0))
      {
        JSONObject localJSONObject1 = new JSONObject();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramList.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("id", localSpecialSound.a);
          localJSONObject2.put("soundName", localSpecialSound.b);
          localJSONObject2.put("type", localSpecialSound.c);
          localJSONObject2.put("soundVersion", localSpecialSound.d);
          localJSONObject2.put("soundUrl", localSpecialSound.e);
          localJSONObject2.put("whiteList", localSpecialSound.f);
          localJSONObject2.put("isShow", localSpecialSound.g);
          localJSONObject2.put("backgroundUrl", localSpecialSound.h);
          localJSONObject2.put("access", localSpecialSound.i);
          localJSONObject2.put("useNum", localSpecialSound.j);
          localJSONObject2.put("classify", localSpecialSound.k);
          localJSONObject2.put("classifyName", localSpecialSound.l);
          localJSONObject2.put("limitFreeStart", localSpecialSound.m);
          localJSONObject2.put("limitFreeEnd", localSpecialSound.n);
          String str = localSpecialSound.e;
          if ((str != null) && (!TextUtils.isEmpty(localSpecialSound.e)) && (h(localSpecialSound.e))) {
            localJSONObject2.put("isDownload", true);
          } else {
            localJSONObject2.put("isDownload", false);
          }
          localJSONObject1.put(String.valueOf(localSpecialSound.a), localJSONObject2);
        }
        paramList = new JSONObject();
        paramList.put("rings", localJSONObject1);
        ((JSONObject)localObject).put("code", 0);
        ((JSONObject)localObject).put("data", paramList);
        callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      a("-->responseRingsList:list is empety");
      ((JSONObject)localObject).put("code", -1);
      ((JSONObject)localObject).put("errorMessage", "rings not found");
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException paramList)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->json exception:");
      ((StringBuilder)localObject).append(paramList.toString());
      ((StringBuilder)localObject).append(".Reload json...");
      a(((StringBuilder)localObject).toString());
      c(paramString);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleDownloadRing: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    if (RingUpdateCallback.isRingExists(this.mRuntime.d(), paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDownloadRing: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" exists");
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, localStringBuilder.toString());
      ((JSONObject)localObject).put("code", 2);
      ((JSONObject)localObject).put("errorCode", 0);
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    ((JSONObject)localObject).put("code", 0);
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
    QuickUpdateIPCModule.download(37L, RingUpdateCallback.sInstance.getScid(paramInt), new VipSpecialSoundWebViewPlugin.3(this, paramString));
    return true;
  }
  
  private boolean a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleSetRing,id=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",uin=");
    ((StringBuilder)localObject).append(paramString1);
    a(((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(this.mRuntime.d().getApplicationContext()))
    {
      a("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", a(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("id", paramInt);
    ((Bundle)localObject).putString("uin", paramString1);
    sendRemoteReq(DataFactory.a("sepcial_care_delete_ring", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  private boolean a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleSetRing,id=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",uin=");
    ((StringBuilder)localObject).append(paramString1);
    a(((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.mRuntime.d().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_care_id_cache");
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).commit();
      paramString1 = new JSONObject();
      paramString1.put("code", 0);
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    if (!NetworkUtil.isNetSupport(this.mRuntime.d().getApplicationContext()))
    {
      a("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", a(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("id", paramInt);
    ((Bundle)localObject).putString("uin", paramString1);
    sendRemoteReq(DataFactory.a("special_care_set_ring", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->handleCancelDownload,url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",callback:");
    localStringBuilder.append(paramString2);
    a(localStringBuilder.toString());
    paramString1 = new JSONObject();
    paramString1.put("code", 0);
    callJs(paramString2, new String[] { paramString1.toString() });
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleGetRing, uin=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",callback=");
    ((StringBuilder)localObject).append(paramString2);
    a(((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.mRuntime.d().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("special_care_id_cache");
      localStringBuilder.append(paramString1);
      int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 1);
      paramString1 = new JSONObject();
      paramString1.put("id", i);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", 0);
      ((JSONObject)localObject).put("data", paramString1);
      callJs(paramString2, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("uin", paramString1);
    sendRemoteReq(DataFactory.a("special_care_get_ring", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  private boolean a(String paramString, JSONObject paramJSONObject)
  {
    File localFile = new File(this.mRuntime.d().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
    JSONObject localJSONObject = new JSONObject();
    if (localFile.exists())
    {
      a("-->config file already exists!");
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "Config file already exists at local.");
    }
    try
    {
      bool = localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      boolean bool;
      label81:
      break label81;
    }
    bool = false;
    if (!bool)
    {
      a("-->Could not create config file!");
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "Could not create file!");
    }
    else
    {
      a("-->Write config to file.");
      a(localFile, paramJSONObject.toString());
      localJSONObject.put("code", 0);
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
    return true;
  }
  
  private void b(String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleGetRingResponse, callback=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",bundle=");
    ((StringBuilder)localObject).append(paramBundle);
    a(((StringBuilder)localObject).toString());
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("id");
    paramBundle = new JSONObject();
    paramBundle.put("id", i);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("data", paramBundle);
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
  }
  
  private boolean b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePlayRing: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    boolean bool;
    if (this.b.f()) {
      bool = this.b.c();
    } else {
      bool = true;
    }
    this.b.a(new VipSpecialSoundWebViewPlugin.4(this, paramInt, paramString));
    String str = RingUpdateCallback.getWavPath(this.mRuntime.d(), paramInt);
    if (!new File(str).exists())
    {
      ((JSONObject)localObject).put("code", 2);
      ((JSONObject)localObject).put("errorMessage", "audio is missing");
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    this.b.a(this.mRuntime.d().getApplicationContext(), str, new VipSpecialSoundWebViewPlugin.PreparedListener(this, (JSONObject)localObject, paramString, bool));
    return true;
  }
  
  private boolean b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleGetRingsInfo,callback=");
    ((StringBuilder)localObject).append(paramString);
    a(((StringBuilder)localObject).toString());
    if (!this.a.isCacheData())
    {
      this.a.loadSpecialSoundConfig(new VipSpecialSoundWebViewPlugin.1(this, paramString));
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_special_sound_list");
      ((StringBuilder)localObject).append(this.mRuntime.b().getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      a(paramString, (List)QvipSpecialConstants.a.get(localObject));
    }
    return true;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleIsSpecialCareFriend,friendUin:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",callback:");
    ((StringBuilder)localObject).append(paramString2);
    a(((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("friendUin", paramString1);
    sendRemoteReq(DataFactory.a("is_special_friend", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  private void c(String paramString)
  {
    File localFile = new File(this.mRuntime.d().getApplicationContext().getFilesDir(), "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json");
    if ((localFile.exists()) && (!localFile.delete())) {
      a("-->can't delete file!");
    }
    this.a.loadSpecialSoundConfig(new VipSpecialSoundWebViewPlugin.2(this, paramString));
  }
  
  private void c(String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->handleGetFriendCountResponse,callback=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",bundle=");
    ((StringBuilder)localObject).append(paramBundle);
    a(((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    if (paramBundle == null)
    {
      ((JSONObject)localObject).put("code", -1);
      ((JSONObject)localObject).put("errorMessage", "id error");
    }
    else
    {
      int i = paramBundle.getInt("count");
      ((JSONObject)localObject).put("code", 0);
      paramBundle = new JSONObject();
      paramBundle.put("nums", i);
      ((JSONObject)localObject).put("data", paramBundle);
    }
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
  }
  
  private void d(String paramString, Bundle paramBundle)
  {
    a("-->onDeleteSpecialSoundResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", a(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      a("-->delete ring failed");
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", a(i));
    }
    else
    {
      a("-->delete ring ok!");
      paramBundle.put("code", 0);
    }
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private boolean d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->handleGetFriendCount,callback=");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString());
    sendRemoteReq(DataFactory.a("special_care_get_friend_count", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private void e(String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->onSpecialSoundSwitchState,callback=");
    ((StringBuilder)localObject).append(paramString);
    a(((StringBuilder)localObject).toString());
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "get state failed");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("state");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    localObject = new JSONObject();
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    ((JSONObject)localObject).put("canPlay", i);
    paramBundle.put("data", localObject);
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private boolean e(String paramString)
  {
    boolean bool;
    if (!this.b.f()) {
      bool = true;
    } else {
      bool = this.b.c();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleStopRing ");
    ((StringBuilder)localObject).append(bool);
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    if (!bool)
    {
      ((JSONObject)localObject).put("code", -1);
      ((JSONObject)localObject).put("errorMessage", "stop error");
    }
    else
    {
      ((JSONObject)localObject).put("code", 0);
    }
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
    return true;
  }
  
  private void f(String paramString, Bundle paramBundle)
  {
    a("-->isSpecialFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("isSpecialFriend");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("isSpecialFriend", i);
    paramBundle.put("data", localJSONObject);
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private boolean f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->handleGetSpecialSoundSwitchState,callback:");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString());
    sendRemoteReq(DataFactory.a("special_care_get_switch_state", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private boolean g(String paramString)
  {
    File localFile = new File(this.mRuntime.d().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
    JSONObject localJSONObject = new JSONObject();
    if (localFile.exists())
    {
      localJSONObject.put("code", 0);
    }
    else
    {
      localJSONObject.put("code", 1);
      localJSONObject.put("errorMessage", "config file does not exists at local!");
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
    return true;
  }
  
  private boolean h(String paramString)
  {
    return new File(this.mRuntime.d().getApplicationContext().getFilesDir(), paramString).exists();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("specialRing")))
    {
      paramString1 = null;
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramString2 = new StringBuilder();
        paramString2.append("-->failed to parse json str,json=");
        paramString2.append(null);
        a(paramString2.toString());
        paramJsBridgeListener.printStackTrace();
        paramJsBridgeListener = null;
      }
      if (paramJsBridgeListener == null) {
        return false;
      }
      try
      {
        paramString2 = paramJsBridgeListener.getString("callback");
        paramString1 = paramString2;
        paramVarArgs = new StringBuilder();
        paramString1 = paramString2;
        paramVarArgs.append("-->handleJsRequest:method:");
        paramString1 = paramString2;
        paramVarArgs.append(paramString3);
        paramString1 = paramString2;
        paramVarArgs.append(",callback");
        paramString1 = paramString2;
        paramVarArgs.append(paramString2);
        paramString1 = paramString2;
        paramVarArgs.append(", json:");
        paramString1 = paramString2;
        paramVarArgs.append(paramJsBridgeListener.toString());
        paramString1 = paramString2;
        a(paramVarArgs.toString());
        paramString1 = paramString2;
        if (paramString3.equals("getRingsInfo"))
        {
          paramString1 = paramString2;
          return b(paramString2);
        }
        paramString1 = paramString2;
        if (paramString3.equals("cancelDownload"))
        {
          paramString1 = paramString2;
          a(paramJsBridgeListener.getString("url"), paramString2);
          return true;
        }
        paramString1 = paramString2;
        bool = paramString3.equals("downloadRing");
        if (bool)
        {
          paramString1 = paramString2;
          return a(paramJsBridgeListener.optInt("id"), paramString2);
        }
        paramString1 = paramString2;
        bool = paramString3.equals("setDefaultRing");
        if (!bool) {}
      }
      catch (Exception paramJsBridgeListener)
      {
        boolean bool;
        label281:
        label336:
        paramString2 = new StringBuilder();
        paramString2.append("-->handleJsRequest exception:");
        paramString2.append(paramJsBridgeListener.toString());
        a(paramString2.toString());
        try
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("code", -1);
          paramJsBridgeListener.put("errorMessage", "exception");
          callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
    try
    {
      bool = paramJsBridgeListener.getBoolean("lazy");
    }
    catch (Exception paramString1)
    {
      break label281;
    }
    bool = false;
    paramString1 = paramString2;
    return a(paramJsBridgeListener.getInt("id"), paramJsBridgeListener.getString("uin"), bool, paramString2);
    paramString1 = paramString2;
    bool = paramString3.equals("getDefaultRing");
    if (bool) {}
    try
    {
      bool = paramJsBridgeListener.getBoolean("lazy");
    }
    catch (Exception paramString1)
    {
      break label336;
    }
    bool = false;
    paramString1 = paramString2;
    return a(paramJsBridgeListener.getString("uin"), paramString2, bool);
    paramString1 = paramString2;
    if (paramString3.equals("play"))
    {
      paramString1 = paramString2;
      return b(paramJsBridgeListener.optInt("id"), paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("stop"))
    {
      paramString1 = paramString2;
      return e(paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("getSpecialFriendsNum"))
    {
      paramString1 = paramString2;
      return d(paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("deleteSpecialSound"))
    {
      paramString1 = paramString2;
      return a(paramJsBridgeListener.getInt("id"), paramJsBridgeListener.getString("uin"), paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("canPlaySpecialSound"))
    {
      paramString1 = paramString2;
      return f(paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("isSpecialCareFriend"))
    {
      paramString1 = paramString2;
      return b(paramJsBridgeListener.getString("friendUin"), paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("queryRingDataStatus"))
    {
      paramString1 = paramString2;
      return g(paramString2);
    }
    paramString1 = paramString2;
    if (paramString3.equals("pushRingData"))
    {
      paramString1 = paramString2;
      bool = a(paramString2, paramJsBridgeListener.getJSONObject("data"));
      return bool;
    }
    return true;
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("-->handleJsRequest returned, pkgName=");
    paramJsBridgeListener.append(paramString2);
    a(paramJsBridgeListener.toString());
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = VasUtil.a().getSpecialSoundManager();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.e();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
        {
          localObject = paramBundle.getString("cmd");
          String str = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("-->onResponse,callback=");
          localStringBuilder.append(str);
          localStringBuilder.append(",cmd=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",respbundle=");
          localStringBuilder.append(paramBundle);
          a(localStringBuilder.toString());
          if (localObject != null)
          {
            if ("special_care_get_ring".equals(localObject))
            {
              b(str, paramBundle);
              return;
            }
            if ("special_care_get_friend_count".equals(localObject))
            {
              c(str, paramBundle);
              return;
            }
            if ("special_care_set_ring".equals(localObject))
            {
              a(str, paramBundle);
              return;
            }
            if ("sepcial_care_delete_ring".equals(localObject))
            {
              d(str, paramBundle);
              return;
            }
            if ("special_care_get_switch_state".equals(localObject))
            {
              e(str, paramBundle);
              return;
            }
            if ("is_special_friend".equals(localObject))
            {
              f(str, paramBundle);
              return;
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->exception in onResponse,");
        ((StringBuilder)localObject).append(paramBundle.toString());
        a(((StringBuilder)localObject).toString());
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */