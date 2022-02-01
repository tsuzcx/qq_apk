package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.GetMusicInfoCallback;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetSingleFullMusicInfoTask
  extends AsyncStep
  implements INetEngineListener
{
  protected FlowMusic a;
  protected FlowMusic b;
  private String c;
  private String d;
  private IHttpEngineService e;
  private GetMusicInfoCallback f;
  private final Object g = new Object();
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    this.a = paramFlowMusic;
    this.f = paramGetMusicInfoCallback;
    paramFlowMusic = (QIMMusicConfigManager)QIMManager.a(2);
    this.d = paramFlowMusic.g().getCurrentAccountUin();
    this.e = paramFlowMusic.h;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    this.c = paramString;
    this.f = paramGetMusicInfoCallback;
    paramString = (QIMMusicConfigManager)QIMManager.a(2);
    this.d = paramString.g().getCurrentAccountUin();
    this.e = paramString.h;
  }
  
  private static String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("2000000228");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("TCOHANTCNlddnsTY");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("uZliVvhTJzkDPlHX");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = MD5.b((String)localObject).toLowerCase();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate the sign string, pre=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", md5=");
      localStringBuilder.append(str);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  private String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      int i = 1;
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        else
        {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)paramMap.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)paramMap.getValue());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("genQQMusicReqUrl url");
      paramString.append(localStringBuilder.toString());
      QLog.d("QQInitHandler", 2, paramString.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  private void a(boolean paramBoolean, FlowMusic arg2)
  {
    GetMusicInfoCallback localGetMusicInfoCallback = this.f;
    if (localGetMusicInfoCallback != null)
    {
      localGetMusicInfoCallback.a(paramBoolean, ???);
      return;
    }
    synchronized (this.g)
    {
      this.g.notify();
      return;
    }
  }
  
  protected int doStep()
  {
    ??? = this.a;
    if (??? != null) {
      ??? = ((FlowMusic)???).songMid;
    } else {
      ??? = this.c;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    localHttpNetReq.mCallback = this;
    long l = System.currentTimeMillis() / 1000L;
    Object localObject3 = ((TicketManagerImpl)CaptureContext.a().getManager(2)).getSkey(this.d);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000228");
    localHashMap.put("app_key", "TCOHANTCNlddnsTY");
    localHashMap.put("device_id", DeviceInfoUtil.b());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.put("song_mid", ???);
    localHashMap.putAll(a(this.d, (String)localObject3));
    localHttpNetReq.mReqUrl = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("QQMusicReq SingleFullMusicInfoTask songId:");
      ((StringBuilder)localObject3).append((String)???);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject3).toString());
    }
    this.e.sendReq(localHttpNetReq);
    if (this.f == null) {}
    try
    {
      synchronized (this.g)
      {
        this.g.wait(30000L);
      }
    }
    catch (Exception localException)
    {
      label303:
      label313:
      break label303;
    }
    break label313;
    throw localObject2;
    return 7;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    if (paramNetResp.mHttpCode == 200)
    {
      if (paramNetResp.mRespData != null)
      {
        paramNetResp = new String(paramNetResp.mRespData);
        if (!TextUtils.isEmpty(paramNetResp))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetSingleFullMusicInfoTask respJson =");
            localStringBuilder.append(paramNetResp);
            QLog.d("QQInitHandler", 2, localStringBuilder.toString());
          }
          try
          {
            paramNetResp = new JSONObject(paramNetResp);
            if (paramNetResp.optInt("ret", -1) == 0)
            {
              paramNetResp = paramNetResp.optJSONArray("songlist");
              if (paramNetResp == null) {
                return;
              }
              paramNetResp = paramNetResp.optJSONObject(0);
              if (paramNetResp == null) {
                return;
              }
              this.b = new FlowMusic();
              this.b.albumId = paramNetResp.optInt("album_id");
              this.b.albumMid = paramNetResp.optString("album_mid");
              this.b.albumName = paramNetResp.optString("album_name");
              this.b.albumUrl = paramNetResp.optString("album_pic");
              this.b.singerId = paramNetResp.optInt("singer_id");
              this.b.singerMid = paramNetResp.optString("singer_mid");
              this.b.singerName = paramNetResp.optString("singer_name");
              this.b.songId = paramNetResp.optInt("song_id");
              this.b.songMid = paramNetResp.optString("song_mid");
              this.b.songName = paramNetResp.optString("song_name");
              this.b.songPlayTime = paramNetResp.optInt("song_play_time");
              this.b.userOwnRule = paramNetResp.optInt("user_own_rule");
              this.b.url = paramNetResp.optString("song_play_url");
              this.b.size = paramNetResp.optLong("song_size");
              this.b.playable = paramNetResp.optInt("playable", 1);
              this.b.storeTimeStamp = System.currentTimeMillis();
              a(true, this.b);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException paramNetResp)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetSingleFullMusicInfoTask e:");
          localStringBuilder.append(paramNetResp.toString());
          QLog.d("QQInitHandler", 2, localStringBuilder.toString());
        }
      }
      else
      {
        a(false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetSingleFullMusicInfoTask resp.mHttpCode:");
        localStringBuilder.append(paramNetResp.mHttpCode);
        QLog.d("QQInitHandler", 2, localStringBuilder.toString());
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */