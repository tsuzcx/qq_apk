package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class GroupHolderBase
  extends StoryPlayerContextWrapper
{
  protected String a;
  @NonNull
  public final View b;
  protected GroupHolderContainer c;
  protected int d;
  public IDataProvider.GroupId e;
  public List<StoryPlayerVideoData> f;
  @Deprecated
  protected boolean g;
  protected boolean h;
  private final String i;
  
  public GroupHolderBase(@NonNull View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.");
    localStringBuilder.append(getClass().getSimpleName());
    this.i = localStringBuilder.toString();
    this.d = -1;
    this.e = null;
    this.f = Collections.emptyList();
    this.g = false;
    this.h = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append(System.identityHashCode(this));
    this.a = localStringBuilder.toString();
    if ((paramView instanceof ViewGroup))
    {
      this.b = a((ViewGroup)paramView);
      return;
    }
    this.b = paramView;
  }
  
  public GroupHolderBase(@NonNull ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.");
    localStringBuilder.append(getClass().getSimpleName());
    this.i = localStringBuilder.toString();
    this.d = -1;
    this.e = null;
    this.f = Collections.emptyList();
    this.g = false;
    this.h = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append(System.identityHashCode(this));
    this.a = localStringBuilder.toString();
    this.b = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public GroupHolderBase a(Class<? extends GroupHolderBase> paramClass)
  {
    GroupHolderContainer localGroupHolderContainer = this.c;
    if (localGroupHolderContainer != null) {
      return localGroupHolderContainer.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(System.identityHashCode(this));
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    this.a = ((StringBuilder)localObject).toString();
    this.d = paramInt;
    this.e = paramGroupInfo.b;
    localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)((Iterator)localObject).next();
      if ((paramGroupInfo.b instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
        localStoryPlayerVideoData.a = ((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupInfo.b).a;
      } else {
        localStoryPlayerVideoData.a = null;
      }
    }
    this.f = paramArrayList;
    this.h = true;
  }
  
  void a(GroupHolderContainer paramGroupHolderContainer)
  {
    this.c = paramGroupHolderContainer;
  }
  
  public GroupHolderContainer d()
  {
    return this.c;
  }
  
  protected void e() {}
  
  public void f()
  {
    SLog.a(this.a, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.d), Integer.valueOf(this.f.size()), this.e.b);
    this.h = false;
  }
  
  public int g()
  {
    return this.b.getVisibility();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderBase
 * JD-Core Version:    0.7.0.1
 */