package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VideoHolderContainer
  extends VideoHolderBase
{
  Map<String, VideoHolderBase> j = new HashMap();
  
  public VideoHolderContainer(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    b(new VideoViewVideoHolder((ViewGroup)this.b.findViewById(2131449766)));
    b(new SelectVideoVideoHolder((ViewGroup)this.b.findViewById(2131449706)));
    b(new VideoPauseVideoHolder(this.b.findViewById(2131449666)));
    b(new VideoForwardVideoHolder((ViewGroup)this.b.findViewById(2131449767)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628123, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    SLog.a(this.a, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.d), Integer.valueOf(this.e), paramStoryPlayerVideoData);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(StoryPlayerContext paramStoryPlayerContext)
  {
    super.a(paramStoryPlayerContext);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramStoryPlayerContext);
    }
  }
  
  void a(VideoHolderContainer paramVideoHolderContainer)
  {
    super.a(this);
    paramVideoHolderContainer = this.j.values().iterator();
    while (paramVideoHolderContainer.hasNext()) {
      ((VideoHolderBase)paramVideoHolderContainer.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public VideoHolderBase b(Class<? extends VideoHolderBase> paramClass)
  {
    return (VideoHolderBase)this.j.get(paramClass.getName());
  }
  
  public void b(@NonNull VideoHolderBase paramVideoHolderBase)
  {
    this.j.put(paramVideoHolderBase.getClass().getName(), paramVideoHolderBase);
  }
  
  protected void d()
  {
    super.d();
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    super.e();
    SLog.a(this.a, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.d), Integer.valueOf(this.e), this.c);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).e();
    }
  }
  
  public boolean f()
  {
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderContainer
 * JD-Core Version:    0.7.0.1
 */