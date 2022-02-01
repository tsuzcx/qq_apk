package com.tencent.biz.qqstory.playvideo.player;

import android.util.SparseArray;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$4
  implements TVK_IMediaPlayer.OnInfoListener
{
  VideoViewTVKImpl$4(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      SLog.d(this.a.a, "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this, paramInt, paramObject));
      return false;
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.b.length))
      {
        SLog.d(this.a.a, "onInfo. playerType %s", new Object[] { StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.b[i] });
      }
      else
      {
        SLog.d(this.a.a, "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        SLog.d(this.a.a, "onInfo. start buffering");
        continue;
        SLog.d(this.a.a, "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          SLog.d(this.a.a, "onInfo. set decoder. %s", new Object[] { StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.jdField_a_of_type_ArrayOfJavaLangString[i] });
          VideoViewTVKImpl.a(this.a).d = StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        else
        {
          SLog.d(this.a.a, "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
          VideoViewTVKImpl.a(this.a).d = ("Unknown " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4
 * JD-Core Version:    0.7.0.1
 */