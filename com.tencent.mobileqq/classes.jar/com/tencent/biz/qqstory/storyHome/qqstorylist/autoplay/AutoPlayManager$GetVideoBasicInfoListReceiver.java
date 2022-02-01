package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class AutoPlayManager$GetVideoBasicInfoListReceiver
  extends QQUIEventReceiver<AutoPlayManager, VidToBasicInfoHandler.GetVideoBasicInfoListEvent>
{
  public AutoPlayManager$GetVideoBasicInfoListReceiver(@NonNull AutoPlayManager paramAutoPlayManager)
  {
    super(paramAutoPlayManager);
  }
  
  public void a(@NonNull AutoPlayManager paramAutoPlayManager, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if (!paramGetVideoBasicInfoListEvent.g.isFail())
    {
      if (paramGetVideoBasicInfoListEvent.a == null) {
        return;
      }
      paramAutoPlayManager.b(paramGetVideoBasicInfoListEvent.a);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager.GetVideoBasicInfoListReceiver
 * JD-Core Version:    0.7.0.1
 */