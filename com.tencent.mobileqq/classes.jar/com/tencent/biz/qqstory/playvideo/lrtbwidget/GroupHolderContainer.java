package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GroupHolderContainer
  extends GroupHolderBase
{
  protected Map<String, GroupHolderBase> a = new HashMap();
  
  public GroupHolderContainer(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561951, paramViewGroup, false);
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    super.a(paramInt, paramGroupInfo, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((GroupHolderBase)localIterator.next()).a(paramInt, paramGroupInfo, paramArrayList);
    }
  }
  
  public void a(@NonNull GroupHolderBase paramGroupHolderBase)
  {
    this.a.put(paramGroupHolderBase.getClass().getName(), paramGroupHolderBase);
  }
  
  void a(GroupHolderContainer paramGroupHolderContainer)
  {
    super.a(paramGroupHolderContainer);
    paramGroupHolderContainer = this.a.values().iterator();
    while (paramGroupHolderContainer.hasNext()) {
      ((GroupHolderBase)paramGroupHolderContainer.next()).a(this);
    }
  }
  
  public void a(StoryPlayerContext paramStoryPlayerContext)
  {
    super.a(paramStoryPlayerContext);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((GroupHolderBase)localIterator.next()).a(paramStoryPlayerContext);
    }
  }
  
  @Nullable
  public GroupHolderBase b(Class<? extends GroupHolderBase> paramClass)
  {
    return (GroupHolderBase)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((GroupHolderBase)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((GroupHolderBase)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.GroupHolderContainer
 * JD-Core Version:    0.7.0.1
 */