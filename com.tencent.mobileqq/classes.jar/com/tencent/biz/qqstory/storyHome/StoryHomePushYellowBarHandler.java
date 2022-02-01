package com.tencent.biz.qqstory.storyHome;

import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class StoryHomePushYellowBarHandler
{
  public MystoryListView a;
  protected NewMessageYellowBar a;
  protected AppInterface a;
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new StoryHomePushYellowBarHandler.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
  }
  
  public void a(AppInterface paramAppInterface, View paramView, MystoryListView paramMystoryListView)
  {
    if ((paramView instanceof NewMessageYellowBar))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)paramView);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = paramMystoryListView;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.setOnClickListener(new StoryHomePushYellowBarHandler.2(this));
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("StoryHomePushYellowBarHandler 传入View不对");
  }
  
  public void b()
  {
    NewMessageYellowBar localNewMessageYellowBar = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar;
    if (localNewMessageYellowBar == null) {
      return;
    }
    localNewMessageYellowBar.a(0, 0);
    ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(21);
  }
  
  public void c()
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryHomePushYellowBarHandler
 * JD-Core Version:    0.7.0.1
 */