package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VideoViewTVKImpl$6
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  VideoViewTVKImpl$6(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void OnDownloadCallback(String paramString)
  {
    SLog.a(this.a.a, "on tvk download callback. %s", paramString);
    try
    {
      StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson localOnDownloadCallBackJson = (StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson)JsonORM.a(new JSONObject(paramString), StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson.class);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      localJsonParseException.printStackTrace();
    }
    Object localObject = null;
    if (localObject == null)
    {
      SLog.d(this.a.a, "OnDownloadCallback fail. %s", new Object[] { paramString });
      return;
    }
    switch (localObject.e)
    {
    default: 
      SLog.d(this.a.a, "OnDownloadCallback. 未知. %s", new Object[] { paramString });
      return;
    case 7: 
      SLog.d(this.a.a, "OnDownloadCallback. 存储文件完整下载完成.");
      if (!TextUtils.isEmpty(this.a.f))
      {
        if (this.a.p != null) {
          this.a.p.a(this.a.e, this.a.g, new File(this.a.f));
        }
      }
      else if (this.a.p != null)
      {
        this.a.p.a(this.a.e, this.a.g, null);
        return;
      }
      break;
    case 4: 
    case 5: 
    case 6: 
      SLog.e(this.a.a, "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localObject.f), Integer.valueOf(localObject.g), localObject.h });
      this.a.p.a(this.a.e, this.a.g, localObject.f);
      return;
    case 3: 
      SLog.d(this.a.a, "OnDownloadCallback. 下载 DONE.");
      return;
    case 2: 
      SLog.d(this.a.a, "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localObject.d), Long.valueOf(localObject.b), Integer.valueOf(localObject.c), Integer.valueOf(localObject.a) });
      VideoViewTVKImpl.a(this.a).d = localObject.b;
      VideoViewTVKImpl.a(this.a).a.add(Integer.valueOf(localObject.c));
      if ((!TextUtils.isEmpty(this.a.f)) && (this.a.p != null))
      {
        this.a.p.a(this.a.g, new File(this.a.f), localObject.d, null);
        return;
      }
      break;
    case 1: 
      SLog.d(this.a.a, "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.6
 * JD-Core Version:    0.7.0.1
 */