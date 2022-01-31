package com.tencent.biz.qqstory.shareGroup.infocard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView.UIEventListener;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import java.util.ArrayList;
import java.util.List;
import nwx;

public class QQStoryShareGroupProfileActivity$UIEventListenerImpl
  implements View.OnClickListener, ShareGroupsListView.UIEventListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  private final long jdField_a_of_type_Long = 500L;
  private final QQStoryShareGroupProfileActivity jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity;
  private long b;
  
  public QQStoryShareGroupProfileActivity$UIEventListenerImpl(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity = paramQQStoryShareGroupProfileActivity;
  }
  
  private void a(View paramView, String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b;
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.a;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < localList.size())
    {
      HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)localList.get(i);
      localArrayList1.add(localHotSortVideoEntry.feedId);
      localArrayList2.add(localHotSortVideoEntry.storyId);
      if (paramString.equals(localHotSortVideoEntry.storyId)) {
        j = i;
      }
      i += 1;
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0)) {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, str, localArrayList2, localArrayList1, j, paramView);
    }
    StoryReportor.a("share_story", "clk_video_card", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b, paramString });
  }
  
  public void a()
  {
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, "2", 1003);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(View paramView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, View paramView, String paramString2)
  {
    if (System.currentTimeMillis() - this.b < 500L) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.g)
      {
        a(paramView, paramString2);
        return;
      }
      paramString2 = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b;
      MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = localMemoryManager.a(paramString2, localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0))
      {
        int i = localArrayList2.indexOf(paramString1);
        paramString1 = localMemoryManager.a(paramString2);
        if ((paramString1 != null) && (paramString1.isEnd == 1)) {}
        for (boolean bool = true; this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c == 1; bool = false)
        {
          StoryPlayVideoActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, paramString2, localArrayList2, i, paramInt, localArrayList1, paramView, bool, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a());
          return;
        }
      }
    }
  }
  
  public void a(String paramString1, long paramLong, StoryVideoItem paramStoryVideoItem, int paramInt, String paramString2, List paramList)
  {
    if (UIUtils.b()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = StoryShare.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a("分享小视频圈子").a(ShareGroupOneDayStoryShareMode.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramStoryVideoItem, paramString1, paramLong, paramInt)).a(new nwx(this)).a();
    StoryReportor.a("share_story", "share_day", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
  
  public boolean a(String paramString)
  {
    VideoCollectionItem localVideoCollectionItem = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (localVideoCollectionItem != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a(localVideoCollectionItem);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onLoadMore: videoCollectionItem is null, collectionId:" + paramString);
    }
    return false;
  }
  
  public void b()
  {
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, true);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.b(false);
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "QQStoryShareGroupProfileActivity onHeaderItemClick!");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.g) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.a());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371824: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, "5", 1004);
      return;
    case 2131363262: 
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.finish();
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.UIEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */