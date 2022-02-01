package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.util.HashMap;

public class StoryPlayerTVKWrapper
{
  @NonNull
  private final Context a;
  private IVideoViewBase b;
  private TVK_IMediaPlayer c;
  private StoryPlayerTVKWrapper.ReportData d = new StoryPlayerTVKWrapper.ReportData();
  private StoryPlayerTVKWrapper.TVKSDKOnLogListener e = new StoryPlayerTVKWrapper.TVKSDKOnLogListener();
  private StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener f = new StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener(this.d);
  
  public StoryPlayerTVKWrapper(@NonNull Context paramContext)
  {
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.a = paramContext.getApplicationContext();
    b();
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "bus_type_qqstory");
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, String paramString3)
  {
    SLog.d("StoryPlayerTVKWrapper", "createPlayerVideoInfo, %s", new Object[] { paramString2 });
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPreLoad(false);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20161223));
    localTVK_PlayerVideoInfo.setConfigMap("downloadflag", "0");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", paramString3);
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_subscribe");
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains(QCircleConstants.k)))
    {
      localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString2);
      paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new File(paramString2);
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
      }
    }
    localTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    localTVK_PlayerVideoInfo.setVid(paramString1);
    return localTVK_PlayerVideoInfo;
  }
  
  private void b()
  {
    TVK_SDKMgr.setOnLogListener(this.e);
    TVK_SDKMgr.initSdk(this.a.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    SLog.d("StoryPlayerTVKWrapper", "TVK version: %s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      this.c = null;
      ThreadManager.executeOnSubThread(new StoryPlayerTVKWrapper.1(this, (TVK_IMediaPlayer)localObject));
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = (View)localObject;
      this.b = null;
      if (((View)localObject).getParent() != null)
      {
        ViewParent localViewParent = ((View)localObject).getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView((View)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper
 * JD-Core Version:    0.7.0.1
 */