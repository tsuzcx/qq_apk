package com.tencent.biz.qqstory.shareGroup.infocard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView.UIEventListener;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import java.util.ArrayList;
import java.util.List;

public class QQStoryShareGroupProfileActivity$UIEventListenerImpl
  implements View.OnClickListener, ShareGroupsListView.UIEventListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  private final QQStoryShareGroupProfileActivity a;
  private final long b = 500L;
  private long c = 0L;
  
  public QQStoryShareGroupProfileActivity$UIEventListenerImpl(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    this.a = paramQQStoryShareGroupProfileActivity;
  }
  
  private void a(View paramView, String paramString)
  {
    Object localObject = this.a.t;
    localObject = this.a.d.f.i;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < ((List)localObject).size())
    {
      HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)((List)localObject).get(i);
      localArrayList1.add(localHotSortVideoEntry.feedId);
      localArrayList2.add(localHotSortVideoEntry.storyId);
      if (paramString.equals(localHotSortVideoEntry.storyId)) {
        j = i;
      }
      i += 1;
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(localArrayList1, localArrayList2, (String)localArrayList1.get(j), (String)localArrayList2.get(j)), 88);
      StoryPlayerLauncher.a(this.a, ((OpenPlayerBuilder)localObject).f(), paramView);
    }
    StoryReportor.a("share_story", "clk_video_card", 0, 0, new String[] { this.a.t, paramString });
  }
  
  public void a()
  {
    QQStoryShareGroupProfileActivity.a(this.a, "2", 1003);
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    if (this.a.p != null) {
      this.a.p.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, View paramView, String paramString2)
  {
    if (System.currentTimeMillis() - this.c < 500L) {
      return;
    }
    if (this.a.G)
    {
      a(paramView, paramString2);
      return;
    }
    String str = this.a.t;
    MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = localMemoryManager.a(str, localArrayList1);
    if (localArrayList2 != null)
    {
      if (localArrayList2.size() == 0) {
        return;
      }
      paramInt = localArrayList2.indexOf(paramString1);
      paramString1 = localMemoryManager.c(str);
      boolean bool;
      if ((paramString1 != null) && (paramString1.isEnd == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.a.y == 1)
      {
        paramString1 = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(str, (String)localArrayList1.get(paramInt), paramString2, String.valueOf(this.a.p.hashCode()), localArrayList2, bool, this.a.y), this.a.b());
        paramString1.a(this.a.a());
        StoryPlayerLauncher.a(this.a, paramString1.f(), paramView);
      }
    }
  }
  
  public void a(String paramString1, long paramLong, StoryVideoItem paramStoryVideoItem, int paramInt, String paramString2, List<String> paramList)
  {
    if (UIUtils.d()) {
      return;
    }
    if (this.a.H == null)
    {
      paramString2 = this.a;
      paramString2.H = StoryShare.a(paramString2);
    }
    paramString2 = this.a.H;
    paramList = new StringBuilder();
    paramList.append(HardCodeUtil.a(2131908655));
    paramList.append(QQStoryConstant.a);
    paramList.append(HardCodeUtil.a(2131908628));
    paramString2.a(paramList.toString()).a(ShareGroupOneDayStoryShareMode.a(this.a.u, paramStoryVideoItem, paramString1, paramLong, paramInt)).a(new QQStoryShareGroupProfileActivity.UIEventListenerImpl.1(this)).b();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { this.a.u.getReportUserType() });
  }
  
  public void b()
  {
    QQStoryShareGroupProfileActivity.a(this.a, true);
    this.a.b(false);
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "QQStoryShareGroupProfileActivity onHeaderItemClick!");
    }
  }
  
  public boolean b(String paramString)
  {
    Object localObject = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (localObject != null) {
      return this.a.a((VideoCollectionItem)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadMore: videoCollectionItem is null, collectionId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void c()
  {
    if (this.a.G)
    {
      this.a.c();
      return;
    }
    if (this.a.p != null) {
      this.a.p.a(this.a.d.f.d());
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131436180)
    {
      if (i != 2131436194)
      {
        if (i == 2131442746) {
          QQStoryShareGroupProfileActivity.a(this.a, "5", 1004);
        }
      }
      else {
        QQStoryShareGroupProfileActivity.b(this.a);
      }
    }
    else {
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.o.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.UIEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */