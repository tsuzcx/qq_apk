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
  private LoadingMoreWidget.ScrollListener a = new LoadingMoreWidget.ScrollListener(this);
  private boolean f = false;
  
  public LoadingMoreWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public LoadingMoreWidget.ScrollListener a()
  {
    return this.a;
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new LoadingMoreWidget.PlayVideoChangeReceiver(this), "");
  }
  
  public boolean a(@NonNull StoryPlayerVideoData paramStoryPlayerVideoData, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.f;
  }
  
  public int b()
  {
    return 2131561972;
  }
  
  public void d()
  {
    this.f = true;
    i();
    SLog.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.f = false;
    k();
    SLog.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.LoadingMoreWidget
 * JD-Core Version:    0.7.0.1
 */