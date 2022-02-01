package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoCoverListGroupHolder$2
  implements AbsListView.OnScrollListener
{
  VideoCoverListGroupHolder$2(VideoCoverListGroupHolder paramVideoCoverListGroupHolder) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - VideoCoverListGroupHolder.b(this.a) < 500L) {
      return;
    }
    VideoCoverListGroupHolder.a(this.a, SystemClock.uptimeMillis());
    if ((this.a.e instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      int i = paramInt1 + paramInt2;
      ((MsgTabPlayPageLoader.MsgTabGroupId)this.a.e).f = i;
      if ((paramInt3 > 0) && (paramInt3 - paramInt1 - paramInt2 < 10))
      {
        this.a.c.n();
        SLog.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.e.toString());
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      VideoCoverListGroupHolder.a(this.a, false);
    } else {
      VideoCoverListGroupHolder.a(this.a, true);
    }
    if ((paramInt == 0) && (VideoCoverListGroupHolder.a(this.a))) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder.2
 * JD-Core Version:    0.7.0.1
 */