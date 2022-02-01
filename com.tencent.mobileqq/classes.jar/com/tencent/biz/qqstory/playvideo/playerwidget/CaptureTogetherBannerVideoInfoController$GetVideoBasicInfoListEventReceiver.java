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
    if (CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController) != 1) {
      return;
    }
    String str = null;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = str;
      if (i >= paramGetVideoBasicInfoListEvent.a.size()) {
        break;
      }
      localObject = (StoryVideoItem)paramGetVideoBasicInfoListEvent.a.get(i);
      if (((StoryVideoItem)localObject).mVid.equals(CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController))) {
        break;
      }
      i += 1;
    }
    if ((localObject != null) && (((StoryVideoItem)localObject).mErrorCode == 0))
    {
      paramGetVideoBasicInfoListEvent = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a();
      i = paramGetVideoBasicInfoListEvent.comparedLevel;
      int j = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a.jdField_a_of_type_Int;
      str = CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController).a.jdField_a_of_type_JavaLangString;
      CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController, CaptureTogetherBannerVideoInfoController.a(paramCaptureTogetherBannerVideoInfoController), str, false, i, j);
      paramCaptureTogetherBannerVideoInfoController = ((UserManager)SuperManager.a(2)).b(((StoryVideoItem)localObject).mOwnerUid);
      if ((paramCaptureTogetherBannerVideoInfoController != null) && (paramCaptureTogetherBannerVideoInfoController.isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramCaptureTogetherBannerVideoInfoController = "2";
      } else {
        paramCaptureTogetherBannerVideoInfoController = "1";
      }
      StoryReportor.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramCaptureTogetherBannerVideoInfoController, ((StoryVideoItem)localObject).mVid, ((StoryVideoItem)localObject).mOwnerUid, paramGetVideoBasicInfoListEvent.mVid });
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
  
  public void b(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController.GetVideoBasicInfoListEventReceiver
 * JD-Core Version:    0.7.0.1
 */