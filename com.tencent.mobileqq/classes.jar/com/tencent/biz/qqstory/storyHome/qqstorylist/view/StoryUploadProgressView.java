package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.UpdateProgressListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;
import mqq.os.MqqHandler;

public class StoryUploadProgressView
  implements StoryVideoUploadProgressManager.UpdateProgressListener
{
  public MessageProgressView a;
  private String a;
  
  public StoryUploadProgressView(MessageProgressView paramMessageProgressView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramMessageProgressView;
  }
  
  private void b(String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    paramString.setAnimProgress(paramInt, localStringBuilder.toString());
  }
  
  public void a()
  {
    MessageProgressView localMessageProgressView = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    localMessageProgressView.setRadius(UIUtils.a(localMessageProgressView.getContext(), 8.0F), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(paramInt);
  }
  
  public void a(MessageProgressView.AnimRunnableListener paramAnimRunnableListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(paramAnimRunnableListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
    if (paramInt >= 100) {
      ThreadManager.getUIHandler().postDelayed(new StoryUploadProgressView.1(this), 500L);
    }
  }
  
  public boolean a()
  {
    MessageProgressView localMessageProgressView = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    return localMessageProgressView.a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView
 * JD-Core Version:    0.7.0.1
 */