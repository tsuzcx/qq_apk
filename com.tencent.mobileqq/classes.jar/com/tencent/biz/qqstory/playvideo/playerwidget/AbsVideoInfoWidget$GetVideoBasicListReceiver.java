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
    if ((paramGetVideoBasicInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList == null)) {}
    String str;
    StoryVideoItem localStoryVideoItem;
    do
    {
      do
      {
        return;
        while (paramAbsVideoInfoWidget.a == null) {}
        str = paramAbsVideoInfoWidget.a.a;
        paramGetVideoBasicInfoListEvent = paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList.iterator();
      } while (!paramGetVideoBasicInfoListEvent.hasNext());
      localStoryVideoItem = (StoryVideoItem)paramGetVideoBasicInfoListEvent.next();
    } while ((!TextUtils.equals(str, localStoryVideoItem.mVid)) || (!localStoryVideoItem.isBasicInfoOK()));
    paramAbsVideoInfoWidget.i();
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.GetVideoBasicListReceiver
 * JD-Core Version:    0.7.0.1
 */