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
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (VideoPauseVideoHolder)((VideoHolderBase)localObject).a(VideoPauseVideoHolder.class);
      if ((localObject != null) && (((VideoPauseVideoHolder)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localObject != null) {
      ((LoadingMoreWidget)localObject).a().a(paramInt);
    }
    c(paramInt);
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, i, paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt1, paramFloat, paramInt2);
    }
    LoadingMoreWidget localLoadingMoreWidget = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localLoadingMoreWidget != null) {
      localLoadingMoreWidget.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((LoadingMoreWidget)this.a.b(LoadingMoreWidget.class)).d();
      SLog.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    LoadingMoreWidget localLoadingMoreWidget = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
    if (localLoadingMoreWidget != null) {
      localLoadingMoreWidget.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    VideoHolderBase localVideoHolderBase = this.a.a();
    if ((localVideoHolderBase != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) && (!localVideoHolderBase.c()))
    {
      SLog.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localVideoHolderBase);
      this.a.a(localVideoHolderBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.3
 * JD-Core Version:    0.7.0.1
 */