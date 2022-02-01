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
  Map<String, VideoHolderBase> a;
  
  public VideoHolderContainer(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381560)));
    b(new InteractWidgetVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131369177)));
    b(new SelectVideoVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381487)));
    b(new VideoPauseVideoHolder(this.jdField_a_of_type_AndroidViewView.findViewById(2131381449)));
    b(new VideoForwardVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381561)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561894, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull StoryPlayerVideoData paramStoryPlayerVideoData, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramStoryPlayerVideoData);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramInt1, paramInt2, paramStoryPlayerVideoData, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(StoryPlayerContext paramStoryPlayerContext)
  {
    super.a(paramStoryPlayerContext);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramStoryPlayerContext);
    }
  }
  
  void a(VideoHolderContainer paramVideoHolderContainer)
  {
    super.a(this);
    paramVideoHolderContainer = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramVideoHolderContainer.hasNext()) {
      ((VideoHolderBase)paramVideoHolderContainer.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public VideoHolderBase b(Class<? extends VideoHolderBase> paramClass)
  {
    return (VideoHolderBase)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull VideoHolderBase paramVideoHolderBase)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramVideoHolderBase.getClass().getName(), paramVideoHolderBase);
  }
  
  public void c()
  {
    super.c();
    SLog.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((VideoHolderBase)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderContainer
 * JD-Core Version:    0.7.0.1
 */