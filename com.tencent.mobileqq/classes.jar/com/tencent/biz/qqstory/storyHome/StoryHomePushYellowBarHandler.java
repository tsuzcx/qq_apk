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
  protected NewMessageYellowBar a;
  protected AppInterface b;
  public MystoryListView c;
  private GetRedPointExObserver d = new StoryHomePushYellowBarHandler.1(this);
  private boolean e;
  
  public void a()
  {
    this.e = false;
    AppInterface localAppInterface = this.b;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.d);
    }
  }
  
  public void a(AppInterface paramAppInterface, View paramView, MystoryListView paramMystoryListView)
  {
    if ((paramView instanceof NewMessageYellowBar))
    {
      this.b = paramAppInterface;
      this.a = ((NewMessageYellowBar)paramView);
      this.c = paramMystoryListView;
      this.a.setOnClickListener(new StoryHomePushYellowBarHandler.2(this));
      this.b.addObserver(this.d);
      this.e = true;
      return;
    }
    throw new IllegalArgumentException("StoryHomePushYellowBarHandler 传入View不对");
  }
  
  public void b()
  {
    NewMessageYellowBar localNewMessageYellowBar = this.a;
    if (localNewMessageYellowBar == null) {
      return;
    }
    localNewMessageYellowBar.a(0, 0);
    ((TroopRedTouchManager)this.b.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).d(21);
  }
  
  public void c()
  {
    AppInterface localAppInterface = this.b;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.d);
    }
    this.b = QQStoryContext.k();
    if (this.e) {
      this.b.addObserver(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryHomePushYellowBarHandler
 * JD-Core Version:    0.7.0.1
 */