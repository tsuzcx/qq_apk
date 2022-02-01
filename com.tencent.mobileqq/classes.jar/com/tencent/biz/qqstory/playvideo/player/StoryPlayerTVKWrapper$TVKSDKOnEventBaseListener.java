package com.tencent.biz.qqstory.playvideo.player;

import android.util.SparseArray;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener
  extends StoryPlayerTVKWrapper.TVKSDKOnEventListener
{
  public static final SparseArray<String> a;
  public static String[] a;
  public static String[] b = { "UNKNOWN", "SYSTEM", "SELF" };
  private StoryPlayerTVKWrapper.ReportData jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData;
  private StoryPlayerTVKWrapper.TVKSDKOnEventListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.1();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "UNKNOWN", "SOFTWARE_DEC", "OMX_HW_DEC", "STAGEFRIGHT_HW_DEC", "MEDIACODEC_HW_DEC", "MEDIACODEC_GLRENDER_DEC" };
  }
  
  public StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener(StoryPlayerTVKWrapper.ReportData paramReportData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData = paramReportData;
  }
  
  public void OnDownloadCallback(String paramString)
  {
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
    StoryPlayerTVKWrapper.TVKSDKOnEventListener localTVKSDKOnEventListener = null;
    if (localTVKSDKOnEventListener == null) {
      SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. %s", new Object[] { paramString });
    } else {
      switch (localTVKSDKOnEventListener.d)
      {
      default: 
        SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 未知. %s", new Object[] { paramString });
        break;
      case 7: 
        SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 存储文件完整下载完成.");
        break;
      case 4: 
      case 5: 
      case 6: 
        SLog.e("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localTVKSDKOnEventListener.e), Integer.valueOf(localTVKSDKOnEventListener.f), localTVKSDKOnEventListener.jdField_a_of_type_JavaLangString });
        break;
      case 3: 
        SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载 DONE.");
        break;
      case 2: 
        SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localTVKSDKOnEventListener.c), Long.valueOf(localTVKSDKOnEventListener.jdField_a_of_type_Long), Integer.valueOf(localTVKSDKOnEventListener.b), Integer.valueOf(localTVKSDKOnEventListener.jdField_a_of_type_Int) });
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.jdField_a_of_type_Long = localTVKSDKOnEventListener.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localTVKSDKOnEventListener.b));
        break;
      case 1: 
        SLog.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
      }
    }
    localTVKSDKOnEventListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
    if (localTVKSDKOnEventListener != null) {
      localTVKSDKOnEventListener.OnDownloadCallback(paramString);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    SLog.b("StoryPlayerTVKWrapper", "onCompletion");
    StoryPlayerTVKWrapper.TVKSDKOnEventListener localTVKSDKOnEventListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
    if (localTVKSDKOnEventListener != null) {
      localTVKSDKOnEventListener.onCompletion(paramTVK_IMediaPlayer);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    SLog.e("StoryPlayerTVKWrapper", "onError. model=%d, what=%d, position=%d, extra=%s, info=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    StoryPlayerTVKWrapper.TVKSDKOnEventListener localTVKSDKOnEventListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
    if (localTVKSDKOnEventListener != null) {
      return localTVKSDKOnEventListener.onError(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 21)
    {
      if (paramInt != 22)
      {
        int i;
        if (paramInt != 24)
        {
          if (paramInt != 31)
          {
            SLog.d("StoryPlayerTVKWrapper", "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
          }
          else
          {
            i = ((Integer)paramObject).intValue();
            if (i >= 0)
            {
              localObject = b;
              if (i <= localObject.length)
              {
                SLog.d("StoryPlayerTVKWrapper", "onInfo. playerType %s", new Object[] { localObject[i] });
                break label220;
              }
            }
            SLog.d("StoryPlayerTVKWrapper", "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          i = ((Integer)paramObject).intValue();
          if (i >= 0)
          {
            localObject = jdField_a_of_type_ArrayOfJavaLangString;
            if (i < localObject.length)
            {
              SLog.d("StoryPlayerTVKWrapper", "onInfo. set decoder. %s", new Object[] { localObject[i] });
              break label220;
            }
          }
          SLog.d("StoryPlayerTVKWrapper", "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        SLog.d("StoryPlayerTVKWrapper", "onInfo. end buffering");
      }
    }
    else {
      SLog.d("StoryPlayerTVKWrapper", "onInfo. start buffering");
    }
    label220:
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
    if (localObject != null) {
      return ((StoryPlayerTVKWrapper.TVKSDKOnEventListener)localObject).onInfo(paramTVK_IMediaPlayer, paramInt, paramObject);
    }
    return false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    SLog.d("StoryPlayerTVKWrapper", "onVideoPrepared");
    StoryPlayerTVKWrapper.TVKSDKOnEventListener localTVKSDKOnEventListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$TVKSDKOnEventListener;
    if (localTVKSDKOnEventListener != null) {
      localTVKSDKOnEventListener.onVideoPrepared(paramTVK_IMediaPlayer);
    }
    ThreadManager.executeOnSubThread(new StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2(this, paramTVK_IMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener
 * JD-Core Version:    0.7.0.1
 */