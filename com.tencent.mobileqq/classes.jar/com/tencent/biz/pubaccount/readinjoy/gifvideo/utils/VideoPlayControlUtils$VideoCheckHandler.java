package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.widget.AbsListView;

public class VideoPlayControlUtils$VideoCheckHandler
  extends Handler
{
  public VideoPlayControlUtils$VideoCheckHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    VideoPlayControlUtils.b((AbsListView)paramMessage[0], (BaseArticleInfo)paramMessage[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils.VideoCheckHandler
 * JD-Core Version:    0.7.0.1
 */