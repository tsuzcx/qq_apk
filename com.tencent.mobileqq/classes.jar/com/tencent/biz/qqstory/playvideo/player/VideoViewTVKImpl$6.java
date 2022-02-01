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
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "on tvk download callback. %s", paramString);
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
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback fail. %s", new Object[] { paramString });
      return;
    }
    switch (localObject.d)
    {
    default: 
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 未知. %s", new Object[] { paramString });
      return;
    case 7: 
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 存储文件完整下载完成.");
      if (!TextUtils.isEmpty(this.a.c))
      {
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, new File(this.a.c));
        }
      }
      else if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, null);
        return;
      }
      break;
    case 4: 
    case 5: 
    case 6: 
      SLog.e(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localObject.e), Integer.valueOf(localObject.f), localObject.jdField_a_of_type_JavaLangString });
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, localObject.e);
      return;
    case 3: 
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 DONE.");
      return;
    case 2: 
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localObject.c), Long.valueOf(localObject.jdField_a_of_type_Long), Integer.valueOf(localObject.b), Integer.valueOf(localObject.jdField_a_of_type_Int) });
      VideoViewTVKImpl.a(this.a).jdField_a_of_type_Long = localObject.jdField_a_of_type_Long;
      VideoViewTVKImpl.a(this.a).jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localObject.b));
      if ((!TextUtils.isEmpty(this.a.c)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener != null))
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.d, new File(this.a.c), localObject.c, null);
        return;
      }
      break;
    case 1: 
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.6
 * JD-Core Version:    0.7.0.1
 */