package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weseevideo.model.data.MusicData;
import com.tencent.tav.coremedia.CMTime;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class AEEditorMusicHelper
{
  @Nullable
  public static VsMusicItemInfo a(@NonNull Intent paramIntent)
  {
    AEQLog.b("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[parseMusicWebData], eventValue=");
    localStringBuilder.append(paramIntent);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if ((!"kTribeSelectMusic".equals(paramIntent)) && (!"kTribeClipsMusic".equals(paramIntent))) {
      return null;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("[parseMusicWebData], dataValue=");
    paramIntent.append(str);
    AEQLog.b("AEEditorMusicHelper", paramIntent.toString());
    try
    {
      paramIntent = a(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      AEQLog.a("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
    }
    return null;
  }
  
  public static VsMusicItemInfo a(JSONObject paramJSONObject)
  {
    VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject("albumInfo");
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("singerInfo");
        JSONObject localJSONObject3 = paramJSONObject.getJSONObject("songInfo");
        JSONObject localJSONObject4 = paramJSONObject.getJSONObject("confInfo");
        paramJSONObject = paramJSONObject.getJSONObject("lyricInfo");
        localVsMusicItemInfo.mType = 5;
        localVsMusicItemInfo.mMusicName = localJSONObject3.optString("name");
        localVsMusicItemInfo.mSingername = localJSONObject2.optString("name");
        localVsMusicItemInfo.mItemId = localJSONObject3.optInt("ID");
        localVsMusicItemInfo.mAlbumUrl = localJSONObject1.optString("thumbURL");
        localVsMusicItemInfo.mSongMid = localJSONObject3.optString("MID");
        int i = localJSONObject3.optInt("Copyright");
        bool = true;
        if (i == 1)
        {
          localVsMusicItemInfo.mHasCopyright = bool;
          localVsMusicItemInfo.c = 2;
          localVsMusicItemInfo.mUrl = localJSONObject3.optString("PlayUrl");
          localVsMusicItemInfo.musicDuration = (localJSONObject3.optInt("IPlayTime") * 1000);
          localVsMusicItemInfo.musicStart = localJSONObject4.optInt("startPos");
          localVsMusicItemInfo.b = paramJSONObject.optString("strLyric");
          localVsMusicItemInfo.musicEnd = 0;
          localVsMusicItemInfo.a = paramJSONObject.optString("strFormat");
          return localVsMusicItemInfo;
        }
      }
      catch (JSONException paramJSONObject)
      {
        AEQLog.a("AEEditorMusicHelper", "[convertJsonToVsMusicInfo], error=", paramJSONObject);
        return localVsMusicItemInfo;
      }
      boolean bool = false;
    }
  }
  
  public static MusicData a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    MusicData localMusicData = new MusicData();
    if ((paramInt1 <= 0) || (paramInt1 >= paramInt2)) {
      paramInt1 = 0;
    }
    localMusicData.setPath(paramString);
    localMusicData.setStartTime(paramInt1);
    localMusicData.setTotalTime(paramInt2);
    localMusicData.setSegDuration(paramInt2 - paramInt1);
    return localMusicData;
  }
  
  @NonNull
  public static String a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getLocalMusicPath], editorMusicInfo=");
    localStringBuilder.append(paramAEEditorMusicInfo);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if ((paramAEEditorMusicInfo != null) && (!paramAEEditorMusicInfo.a()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEEditorPath.EDITOR.CACHE.c);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramAEEditorMusicInfo.c());
      localStringBuilder.append(".m4a");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(String paramString, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qcircle/openwebview?url=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("?");
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    a(localStringBuilder, "videoclipduration", String.valueOf(paramIntent.getIntExtra("videoclipduration", 0)));
    return localStringBuilder.toString();
  }
  
  private static List<Long> a(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    long l1 = paramLong;
    if (paramLong > 60000L) {
      l1 = 60000L;
    }
    long l3 = ((Long)VSConfigManager.a().a("SmartCutPicCount", Long.valueOf(10L))).longValue();
    long l2 = l1 / l3;
    paramLong = l2;
    if (l2 > 1000L) {
      paramLong = (l1 - 1000L) / l3;
    }
    l2 = 0L;
    int i = 0;
    while ((i < l3) && (l2 < l1))
    {
      l2 += paramLong;
      localLinkedList.add(Long.valueOf(l2));
      i += 1;
    }
    return localLinkedList;
  }
  
  @NonNull
  public static List<VsMusicItemInfo> a(@Nullable List<QQCircleSmartMatchMusic.MusicInfo> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[convertToMusicItemList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      QQCircleSmartMatchMusic.MusicInfo localMusicInfo = (QQCircleSmartMatchMusic.MusicInfo)paramList.get(i);
      if (localMusicInfo != null) {
        localLinkedList.add(new VsMusicItemInfo(localMusicInfo));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public static void a(@NonNull Context paramContext)
  {
    AEQLog.b("AEEditorMusicHelper", "[preLoadWebView]");
    Intent localIntent = new Intent(paramContext, PreloadWebService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      AEQLog.a("AEEditorMusicHelper", "[preLoadWebView], error=", paramContext);
    }
  }
  
  public static void a(@NonNull Context paramContext, @NonNull String paramString, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    AEQLog.b("AEEditorMusicHelper", "[startMusicWebView]");
    String str = String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s&sessionId=%s&source=%s", new Object[] { UserAction.getQIMEI(), "", Integer.valueOf(6), paramString, "qcirclePublish" });
    paramString = str;
    if (QzoneConfig.isQQCircleVideoMusicUseWNSUrl()) {
      paramString = QzoneConfig.getAEEditorEditedMusicUrl(str);
    }
    paramIntent.setData(Uri.parse(a(paramString, paramIntent)));
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(@Nullable TAVCutVideoSession paramTAVCutVideoSession, @Nullable FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    long l2 = 0L;
    if (((paramTAVCutVideoSession == null) || (paramTAVCutVideoSession.getDuration() == null) || (paramTAVCutVideoSession.getDuration().getTimeUs() == 0L)) && (paramGetFrameByteArrayListener != null)) {
      paramGetFrameByteArrayListener.a(false, null, -1L);
    }
    long l1 = l2;
    if (paramTAVCutVideoSession != null)
    {
      l1 = l2;
      if (paramTAVCutVideoSession.getDuration() != null) {
        l1 = paramTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
      }
    }
    ThreadManager.executeOnFileThread(new AEEditorMusicHelper.2(paramTAVCutVideoSession, a(l1), ((Long)VSConfigManager.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue(), ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue(), ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue(), paramGetFrameByteArrayListener));
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("&");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("=");
    paramStringBuilder.append(paramString2);
  }
  
  public static void a(@NonNull ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, @Nullable SosoLocation paramSosoLocation, boolean paramBoolean, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp> paramonVSRspCallBack)
  {
    AEQLog.b("AEEditorMusicHelper", "[requestRecommendMusicList]");
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, paramSosoLocation, paramBoolean, paramInt, paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    VSNetworkHelper.getInstance().sendRequest(paramArrayList, new AEEditorMusicHelper.3(paramonVSRspCallBack, l));
  }
  
  public static void a(@NonNull AppRuntime paramAppRuntime, @NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @Nullable AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadMusic], url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", localPath=");
    ((StringBuilder)localObject).append(paramString2);
    AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject).toString());
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mReqUrl = paramString1;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = paramString2;
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject).mExcuteTimeLimit = 30000L;
    ((HttpNetReq)localObject).mCallback = new AEEditorMusicHelper.5(paramMusicDownloadCallback, paramAEEditorMusicInfo, paramString2);
    try
    {
      ((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      paramAEEditorMusicInfo = new StringBuilder();
      paramAEEditorMusicInfo.append("[downloadMusic], error=");
      paramAEEditorMusicInfo.append(paramAppRuntime);
      AEQLog.d("AEEditorMusicHelper", paramAEEditorMusicInfo.toString());
    }
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  public static boolean a(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[localMusicExists], localMusicPath=");
    localStringBuilder.append(paramString);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static List<AEEditorMusicAdapter.AEEditorMusicInfo> b(@Nullable List<VsMusicItemInfo> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)paramList.get(i);
      if (localVsMusicItemInfo != null) {
        localLinkedList.add(new AEEditorMusicAdapter.AEEditorMusicInfo(localVsMusicItemInfo, false, 2, true, i + 1));
      }
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */