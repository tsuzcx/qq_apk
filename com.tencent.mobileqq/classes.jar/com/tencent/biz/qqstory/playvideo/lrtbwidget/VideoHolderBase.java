package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class VideoHolderBase
  extends StoryPlayerContextWrapper
{
  protected String a;
  @NonNull
  public final View b;
  public StoryPlayerVideoData c;
  public int d;
  public int e;
  public StoryPlayerGroupHolder f;
  protected boolean g;
  protected boolean h;
  protected VideoHolderContainer i;
  private final String j;
  
  public VideoHolderBase(@NonNull ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.");
    localStringBuilder.append(getClass().getSimpleName());
    this.j = localStringBuilder.toString();
    this.c = null;
    this.d = -1;
    this.e = -1;
    this.g = false;
    this.h = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(System.identityHashCode(this));
    this.a = localStringBuilder.toString();
    this.b = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public VideoHolderBase a(Class<? extends VideoHolderBase> paramClass)
  {
    VideoHolderContainer localVideoHolderContainer = this.i;
    if (localVideoHolderContainer != null) {
      return localVideoHolderContainer.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    this.a = localStringBuilder.toString();
    SLog.a(this.a, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    this.a = localStringBuilder.toString();
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = paramStoryPlayerVideoData;
    this.g = true;
    this.f = paramStoryPlayerGroupHolder;
  }
  
  void a(VideoHolderContainer paramVideoHolderContainer)
  {
    this.i = paramVideoHolderContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      b(this.h);
      return;
    }
    SLog.e(this.a, "onSelected donot changed !");
  }
  
  protected void b(boolean paramBoolean)
  {
    SLog.b(this.a, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(paramBoolean));
  }
  
  protected void d() {}
  
  public void e()
  {
    this.d = -1;
    this.e = -1;
    this.c = null;
    this.g = false;
    this.f = null;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoHolderBase{, GroupPos=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", VideoPos=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase
 * JD-Core Version:    0.7.0.1
 */