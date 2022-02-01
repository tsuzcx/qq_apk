package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoCompInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.List;

public class CaptureTogetherBannerVideoInfoController$GetVideoBasicInfoListEventReceiver
  extends UIBaseEventReceiver<CaptureTogetherBannerVideoInfoController, VidToBasicInfoHandler.GetVideoBasicInfoListEvent>
{
  public CaptureTogetherBannerVideoInfoController$GetVideoBasicInfoListEventReceiver(CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController)
  {
    super(paramCaptureTogetherBannerVideoInfoController);
  }
  
  public void a(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if (CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController) != 1) {}
    label149:
    label209:
    label218:
    for (;;)
    {
      return;
      int i = 0;
      StoryVideoItem localStoryVideoItem;
      if (i < paramGetVideoBasicInfoListEvent.a.size())
      {
        localStoryVideoItem = (StoryVideoItem)paramGetVideoBasicInfoListEvent.a.get(i);
        if (!localStoryVideoItem.mVid.equals(CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController))) {}
      }
      for (paramGetVideoBasicInfoListEvent = localStoryVideoItem;; paramGetVideoBasicInfoListEvent = null)
      {
        if ((paramGetVideoBasicInfoListEvent == null) || (paramGetVideoBasicInfoListEvent.mErrorCode != 0)) {
          break label218;
        }
        localStoryVideoItem = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a();
        i = localStoryVideoItem.comparedLevel;
        int j = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a.jdField_a_of_type_Int;
        String str = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a.jdField_a_of_type_JavaLangString;
        CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController, CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController), str, false, i, j);
        paramCaptureTogetherBannerVideoInfoController = ((UserManager)SuperManager.a(2)).b(paramGetVideoBasicInfoListEvent.mOwnerUid);
        if ((paramCaptureTogetherBannerVideoInfoController != null) && (paramCaptureTogetherBannerVideoInfoController.isVip))
        {
          i = 1;
          if (i == 0) {
            break label209;
          }
        }
        for (paramCaptureTogetherBannerVideoInfoController = "2";; paramCaptureTogetherBannerVideoInfoController = "1")
        {
          StoryReportor.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramCaptureTogetherBannerVideoInfoController, paramGetVideoBasicInfoListEvent.mVid, paramGetVideoBasicInfoListEvent.mOwnerUid, localStoryVideoItem.mVid });
          return;
          i += 1;
          break;
          i = 0;
          break label149;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
  
  public void b(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController.GetVideoBasicInfoListEventReceiver
 * JD-Core Version:    0.7.0.1
 */