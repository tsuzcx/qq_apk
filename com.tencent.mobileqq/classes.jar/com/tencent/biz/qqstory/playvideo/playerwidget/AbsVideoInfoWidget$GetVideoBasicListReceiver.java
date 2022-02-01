package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class AbsVideoInfoWidget$GetVideoBasicListReceiver
  extends QQUIEventReceiver<AbsVideoInfoWidget, VidToBasicInfoHandler.GetVideoBasicInfoListEvent>
{
  public AbsVideoInfoWidget$GetVideoBasicListReceiver(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    super(paramAbsVideoInfoWidget);
  }
  
  public void a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if (!paramGetVideoBasicInfoListEvent.g.isFail())
    {
      if (paramGetVideoBasicInfoListEvent.a == null) {
        return;
      }
      if (paramAbsVideoInfoWidget.p != null)
      {
        String str = paramAbsVideoInfoWidget.p.b;
        paramGetVideoBasicInfoListEvent = paramGetVideoBasicInfoListEvent.a.iterator();
        while (paramGetVideoBasicInfoListEvent.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramGetVideoBasicInfoListEvent.next();
          if ((TextUtils.equals(str, localStoryVideoItem.mVid)) && (localStoryVideoItem.isBasicInfoOK())) {
            paramAbsVideoInfoWidget.x();
          }
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.GetVideoBasicListReceiver
 * JD-Core Version:    0.7.0.1
 */