package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class StoryHomePushYellowBarHandler$1
  extends GetRedPointExObserver
{
  StoryHomePushYellowBarHandler$1(StoryHomePushYellowBarHandler paramStoryHomePushYellowBarHandler) {}
  
  protected void a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof oidb_0x791.RedDotInfo)))
    {
      paramObject = (oidb_0x791.RedDotInfo)paramObject;
      if (paramObject.uint32_appid.get() == 21)
      {
        int i = paramObject.uint32_number.get();
        int j = paramObject.uint32_last_time.get();
        this.a.a.a(i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryHomePushYellowBarHandler.1
 * JD-Core Version:    0.7.0.1
 */