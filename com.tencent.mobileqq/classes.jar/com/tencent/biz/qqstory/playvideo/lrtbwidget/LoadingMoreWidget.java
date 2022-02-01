package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class LoadingMoreWidget
  extends AbsVideoInfoWidget
{
  private LoadingMoreWidget.ScrollListener s = new LoadingMoreWidget.ScrollListener(this);
  private boolean t = false;
  
  public LoadingMoreWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected void a(View paramView) {}
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new LoadingMoreWidget.PlayVideoChangeReceiver(this), "");
  }
  
  protected boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.t;
  }
  
  protected void b(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void h()
  {
    this.t = true;
    x();
    SLog.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void p()
  {
    this.t = false;
    A();
    SLog.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  protected void q() {}
  
  protected void r() {}
  
  protected int s()
  {
    return 2131628193;
  }
  
  public String t()
  {
    return "LoadingMoreWidget";
  }
  
  public LoadingMoreWidget.ScrollListener u()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.LoadingMoreWidget
 * JD-Core Version:    0.7.0.1
 */