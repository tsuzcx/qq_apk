package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.dataprovider.HoriziotalVideoCoverListDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class VideoCoverListGroupHolder
  extends GroupHolderBase
  implements IEventReceiver
{
  private VideoCoverListBar i;
  private volatile boolean j = false;
  private HoriziotalVideoCoverListDataProvider k;
  private long l = 0L;
  private VideoCoverListGroupHolder.GetVideoBasicListReceiver m;
  private boolean n = false;
  private boolean o = false;
  
  public VideoCoverListGroupHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.i = ((VideoCoverListBar)paramViewGroup.findViewById(2131449529));
    return this.i;
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    SLog.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramGroupInfo);
    boolean bool = this.h;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (!bool)
    {
      this.o = true;
      if (this.m == null) {
        this.m = new VideoCoverListGroupHolder.GetVideoBasicListReceiver(this);
      }
      StoryDispatcher.a().registerSubscriber("", this.m);
    }
    if (!paramGroupInfo.c())
    {
      if (paramGroupInfo.b()) {
        return;
      }
      int i1 = this.k.a().size();
      this.k.a(paramInt, paramArrayList, paramGroupInfo.b);
      if (i1 != this.k.a().size()) {
        this.i.a();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.i.a(paramString);
  }
  
  protected void e()
  {
    super.e();
    this.k = new HoriziotalVideoCoverListDataProvider(i().mUIStyle.showVideoCoverList);
    this.i.a(this.k);
    this.i.setOnVideoClickListener(new VideoCoverListGroupHolder.1(this));
    this.i.setOnScrollListener(new VideoCoverListGroupHolder.2(this));
  }
  
  public void f()
  {
    super.f();
    if (this.m != null)
    {
      this.o = false;
      StoryDispatcher.a().unRegisterSubscriber(this.m);
    }
  }
  
  public void h()
  {
    this.i.b();
  }
  
  public boolean isValidate()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder
 * JD-Core Version:    0.7.0.1
 */