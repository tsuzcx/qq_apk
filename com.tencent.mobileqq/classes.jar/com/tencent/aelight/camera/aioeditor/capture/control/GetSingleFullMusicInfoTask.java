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
  private GetMusicInfoCallback jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback;
  protected FlowMusic a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  protected FlowMusic b;
  private String b;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback = paramGetMusicInfoCallback;
    paramFlowMusic = (QIMMusicConfigManager)QIMManager.a(2);
    this.jdField_b_of_type_JavaLangString = paramFlowMusic.a().getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = paramFlowMusic.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback = paramGetMusicInfoCallback;
    paramString = (QIMMusicConfigManager)QIMManager.a(2);
    this.jdField_b_of_type_JavaLangString = paramString.a().getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = paramString.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
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
    String str = MD5.a((String)localObject).toLowerCase();
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
    GetMusicInfoCallback localGetMusicInfoCallback = this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback;
    if (localGetMusicInfoCallback != null)
    {
      localGetMusicInfoCallback.a(paramBoolean, ???);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  protected int doStep()
  {
    ??? = this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowMusic;
    if (??? != null) {
      ??? = ((FlowMusic)???).songMid;
    } else {
      ??? = this.jdField_a_of_type_JavaLangString;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 60000L;
    localHttpNetReq.mCallback = this;
    long l = System.currentTimeMillis() / 1000L;
    Object localObject3 = ((TicketManagerImpl)CaptureContext.a().getManager(2)).getSkey(this.jdField_b_of_type_JavaLangString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000228");
    localHashMap.put("app_key", "TCOHANTCNlddnsTY");
    localHashMap.put("device_id", DeviceInfoUtil.a());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.put("song_mid", ???);
    localHashMap.putAll(a(this.jdField_b_of_type_JavaLangString, (String)localObject3));
    localHttpNetReq.mReqUrl = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("QQMusicReq SingleFullMusicInfoTask songId:");
      ((StringBuilder)localObject3).append((String)???);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject3).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
    if (this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback == null) {}
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
      }
    }
    catch (Exception localException)
    {
      label301:
      label311:
      break label301;
    }
    break label311;
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
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic = new FlowMusic();
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.albumId = paramNetResp.optInt("album_id");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.albumMid = paramNetResp.optString("album_mid");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.albumName = paramNetResp.optString("album_name");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.albumUrl = paramNetResp.optString("album_pic");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.singerId = paramNetResp.optInt("singer_id");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.singerMid = paramNetResp.optString("singer_mid");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.singerName = paramNetResp.optString("singer_name");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.songId = paramNetResp.optInt("song_id");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.songMid = paramNetResp.optString("song_mid");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.songName = paramNetResp.optString("song_name");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.songPlayTime = paramNetResp.optInt("song_play_time");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.userOwnRule = paramNetResp.optInt("user_own_rule");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.url = paramNetResp.optString("song_play_url");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.size = paramNetResp.optLong("song_size");
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.playable = paramNetResp.optInt("playable", 1);
              this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic.storeTimeStamp = System.currentTimeMillis();
              a(true, this.jdField_b_of_type_ComTencentAelightCameraStructEditorFlowMusic);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */