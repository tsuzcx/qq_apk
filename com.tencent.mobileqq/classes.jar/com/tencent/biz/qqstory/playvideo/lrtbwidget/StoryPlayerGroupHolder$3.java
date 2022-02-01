package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryPlayerGroupHolder$3
  implements XViewPager.OnPageChangeListener
{
  StoryPlayerGroupHolder$3(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    SLog.a(this.a.a, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.l;
    Object localObject = this.a;
    ((StoryPlayerGroupHolder)localObject).l = paramInt;
    localObject = ((StoryPlayerGroupHolder)localObject).h();
    if (localObject != null)
    {
      localObject = (VideoPauseVideoHolder)((VideoHolderBase)localObject).a(VideoPauseVideoHolder.class);
      if ((localObject != null) && (((VideoPauseVideoHolder)localObject).j.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localObject != null) {
      ((LoadingMoreWidget)localObject).u().a(paramInt);
    }
    c(paramInt);
    if (StoryPlayerGroupHolder.c(this.a) != null) {
      StoryPlayerGroupHolder.c(this.a).a(this.a.d, i, paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGroupHolder.c(this.a) != null) {
      StoryPlayerGroupHolder.c(this.a).a(this.a.d, paramInt1, paramFloat, paramInt2);
    }
    LoadingMoreWidget localLoadingMoreWidget = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localLoadingMoreWidget != null) {
      localLoadingMoreWidget.u().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.q()) && (this.a.p()))
    {
      ((LoadingMoreWidget)this.a.b(LoadingMoreWidget.class)).h();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.a);
      ((StringBuilder)localObject).append("Q.qqstory.weishi");
      SLog.a(((StringBuilder)localObject).toString(), "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.l));
    }
    Object localObject = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localObject != null) {
      ((LoadingMoreWidget)localObject).u().b(paramInt);
    }
    if (StoryPlayerGroupHolder.c(this.a) != null) {
      StoryPlayerGroupHolder.c(this.a).a(this.a.d, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    SLog.a(this.a.a, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    VideoHolderBase localVideoHolderBase = this.a.h();
    if ((localVideoHolderBase != null) && (TextUtils.equals(StoryPlayerGroupHolder.d(this.a).o().b, this.a.e.b)) && (!localVideoHolderBase.f()))
    {
      SLog.a(this.a.a, "onIdlePageSelected, setSelected => %s", localVideoHolderBase);
      this.a.a(localVideoHolderBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.3
 * JD-Core Version:    0.7.0.1
 */