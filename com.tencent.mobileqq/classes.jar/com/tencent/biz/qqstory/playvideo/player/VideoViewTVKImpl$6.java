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
    do
    {
      do
      {
        Object localObject2;
        try
        {
          StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson localOnDownloadCallBackJson = (StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson)JsonORM.a(new JSONObject(paramString), StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.OnDownloadCallBackJson.class);
          if (localOnDownloadCallBackJson == null)
          {
            SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback fail. %s", new Object[] { paramString });
            return;
          }
        }
        catch (JsonORM.JsonParseException localJsonParseException)
        {
          for (;;)
          {
            localJsonParseException.printStackTrace();
            Object localObject1 = null;
          }
        }
        catch (JSONException localJSONException)
        {
          do
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              localObject2 = null;
            }
            switch (localObject2.d)
            {
            default: 
              SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 未知. %s", new Object[] { paramString });
              return;
            case 1: 
              SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
              return;
            case 2: 
              SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localObject2.c), Long.valueOf(localObject2.jdField_a_of_type_Long), Integer.valueOf(localObject2.b), Integer.valueOf(localObject2.jdField_a_of_type_Int) });
              VideoViewTVKImpl.a(this.a).jdField_a_of_type_Long = localObject2.jdField_a_of_type_Long;
              VideoViewTVKImpl.a(this.a).jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localObject2.b));
            }
          } while ((TextUtils.isEmpty(this.a.c)) || (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener == null));
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.d, new File(this.a.c), localObject2.c, null);
          return;
          SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 DONE.");
          return;
        }
        SLog.e(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localObject2.e), Integer.valueOf(localObject2.f), localObject2.jdField_a_of_type_JavaLangString });
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, localObject2.e);
        return;
        SLog.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 存储文件完整下载完成.");
        if (TextUtils.isEmpty(this.a.c)) {
          break;
        }
      } while (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener == null);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, new File(this.a.c));
      return;
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener == null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnDownloadListener.a(this.a.b, this.a.d, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.6
 * JD-Core Version:    0.7.0.1
 */