package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.List;
import java.util.Map;

class StoryPlayerGlobalHolder$VideoOnPageChangeListener
  implements OnSuperPageChangeListener
{
  private StoryPlayerGlobalHolder$VideoOnPageChangeListener(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, find vertical holder is null");
      return;
    }
    if (StoryPlayerGlobalHolder.b(this.a) == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, mCurrentSelectedGroupId is null");
      return;
    }
    SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, verticalPosition=%d, currentGroup=%s, onSelectedGroup=%s", Integer.valueOf(paramInt1), StoryPlayerGlobalHolder.b(this.a), localStoryPlayerGroupHolder.e);
    if ((StoryPlayerGlobalHolder.b(this.a) == localStoryPlayerGroupHolder.e) || (StoryPlayerGlobalHolder.b(this.a).equals(localStoryPlayerGroupHolder.e)))
    {
      Object localObject = localStoryPlayerGroupHolder.h();
      if ((localObject instanceof VideoHolderContainer))
      {
        localObject = (VideoViewVideoHolder)((VideoHolderContainer)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null) {
          if (paramInt2 == 1)
          {
            SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, pause because of dragging");
            ((VideoViewVideoHolder)localObject).p();
          }
          else if (paramInt2 == 0)
          {
            if ((localStoryPlayerGroupHolder.q()) && (localStoryPlayerGroupHolder.p()))
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, no need start");
            }
            else
            {
              SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrollStateChanged, Video, start because of idle");
              ((VideoViewVideoHolder)localObject).h();
            }
            StoryReportor.a("play_video", "slide_up_down", 0, 0, new String[] { "2", "", "", "" });
          }
        }
      }
      if (StoryPlayerGlobalHolder.c(this.a) != null) {
        StoryPlayerGlobalHolder.c(this.a).a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a.a(paramInt1);
    if (localStoryPlayerGroupHolder == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, find vertical holder is null");
      return;
    }
    if (StoryPlayerGlobalHolder.b(this.a) == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageScrolled, Video, mCurrentSelectedGroupId is null");
      return;
    }
    if (((StoryPlayerGlobalHolder.b(this.a) == localStoryPlayerGroupHolder.e) || (StoryPlayerGlobalHolder.b(this.a).equals(localStoryPlayerGroupHolder.e))) && (StoryPlayerGlobalHolder.c(this.a) != null)) {
      StoryPlayerGlobalHolder.c(this.a).a(paramInt1, paramInt2, paramFloat, paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)StoryPlayerGlobalHolder.d(this.a).a.get(Integer.valueOf(paramInt1));
    if (localStoryPlayerGroupHolder == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, find vertical holder is null");
      return;
    }
    if (StoryPlayerGlobalHolder.b(this.a) == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, mCurrentSelectedGroupId is null");
      return;
    }
    SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, verticalPosition=%d, oldHorizontalPosition=%d, horizontalPosition=%d, currentGroup=%s, onSelectedGroup=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), StoryPlayerGlobalHolder.b(this.a), localStoryPlayerGroupHolder.e });
    if ((StoryPlayerGlobalHolder.b(this.a) == localStoryPlayerGroupHolder.e) || (StoryPlayerGlobalHolder.b(this.a).equals(localStoryPlayerGroupHolder.e)))
    {
      if (localStoryPlayerGroupHolder.b(paramInt3) != null)
      {
        if (StoryPlayerGlobalHolder.c(this.a) != null) {
          StoryPlayerGlobalHolder.c(this.a).a(paramInt1, paramInt2, paramInt3);
        }
      }
      else {
        SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Video, getPageHolderOfPosition return null. onSelected true failed");
      }
      boolean bool1;
      if (localStoryPlayerGroupHolder.l == localStoryPlayerGroupHolder.f.size() - 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (localStoryPlayerGroupHolder.l == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (localStoryPlayerGroupHolder.q()) {
          bool3 = false;
        }
      }
      this.a.b.setEnableScrollDirection(bool3, bool2, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.VideoOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */