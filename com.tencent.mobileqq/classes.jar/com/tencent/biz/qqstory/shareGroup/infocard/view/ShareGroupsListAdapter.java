package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareGroupsListAdapter
  extends BaseStoryTimeLineAdapter
  implements KeepConstructor
{
  public HashMap<String, WeakReference<ShareGroupsListAdapter.DayCollectionViewHolder>> f = new HashMap();
  public ShareGroupItem g;
  ShareGroupsListView.UIEventListener h;
  public List<HotSortVideoEntry> i = new ArrayList();
  protected boolean j = false;
  protected boolean k = false;
  
  public ShareGroupsListAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.j = paramBoolean;
  }
  
  private void a(List<HotSortVideoEntry> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    VideoCollectionItem localVideoCollectionItem;
    if (this.k)
    {
      localVideoCollectionItem = (VideoCollectionItem)this.a.get(this.a.size() - 1);
      if (localVideoCollectionItem.collectionType == 7)
      {
        localVideoCollectionItem.hotSortVideoLIst.set(1, paramList.get(0));
        paramList.remove(0);
        this.k = false;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "[hotlist]填了一个坑");
        }
      }
    }
    int i2 = paramList.size() / 2;
    int m;
    if (paramList.size() % 2 == 1) {
      m = 1;
    } else {
      m = 0;
    }
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.collectionType = 7;
      localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(n), "0_xx");
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(i1));
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(i1 + 1));
      i1 += 2;
      this.a.add(localVideoCollectionItem);
      this.k = false;
      n += 1;
    }
    if ((paramList.size() > 0) && (m != 0))
    {
      localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.collectionType = 7;
      localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(i1), "0_xx");
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(i1));
      localVideoCollectionItem.hotSortVideoLIst.add(null);
      this.a.add(localVideoCollectionItem);
      this.k = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "[hotlist]又挖了一个坑");
      }
    }
  }
  
  private static void b(ImageView paramImageView, int paramInt, String paramString)
  {
    if (paramImageView == null)
    {
      SLog.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "update imageView error. imageView is null.");
      return;
    }
    paramImageView.setVisibility(paramInt);
    if (paramInt != 0) {
      return;
    }
    UIUtils.b(paramImageView, ThumbnailUrlHelper.a(paramString), 80, 80, null, "StoryDiscoverHeadImage");
  }
  
  protected View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
    paramInt = getItemViewType(paramInt);
    if (paramInt == 1)
    {
      paramViewGroup = localLayoutInflater.inflate(2131628148, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.DayCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 0)
    {
      paramViewGroup = localLayoutInflater.inflate(2131628087, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.YearCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 2)
    {
      paramViewGroup = localLayoutInflater.inflate(2131628147, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.ProfilePlaceholderViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 7)
    {
      paramViewGroup = localLayoutInflater.inflate(2131628144, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.HotSortCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    return null;
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    int m = 0;
    while (m < this.i.size())
    {
      if (((HotSortVideoEntry)this.i.get(m)).storyId.equals(paramHotSortVideoEntry.storyId))
      {
        this.i.set(m, paramHotSortVideoEntry);
        return;
      }
      m += 1;
    }
  }
  
  public void a(ShareGroupsListView.UIEventListener paramUIEventListener)
  {
    super.a(paramUIEventListener, paramUIEventListener);
    this.h = paramUIEventListener;
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.g = paramShareGroupItem;
      super.notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList)
  {
    paramList = (WeakReference)this.f.get(paramString);
    if ((paramList != null) && (paramList.get() != null))
    {
      VideoCollectionItem localVideoCollectionItem = ((MemoryManager)SuperManager.a(19)).a(paramString);
      if (localVideoCollectionItem != null)
      {
        ((ShareGroupsListAdapter.DayCollectionViewHolder)paramList.get()).h.setData(localVideoCollectionItem);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateCollectionData: videoCollectionItem is null, collectionId:");
        paramList.append(paramString);
        QLog.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, paramList.toString());
      }
    }
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    this.j = false;
    super.a(paramList, paramBoolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return false;
  }
  
  public void e(List<HotSortVideoEntry> paramList, boolean paramBoolean)
  {
    this.j = true;
    c();
    this.i = paramList;
    this.k = false;
    a(VideoCollectionItem.getProfilePlaceholderItem("hotsort"));
    a(VideoCollectionItem.getCurrentYearFakeItem("hotsort"));
    a(paramList);
    notifyDataSetChanged();
  }
  
  public void f(List<HotSortVideoEntry> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty()) {
      return;
    }
    this.i.addAll(paramList);
    a(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter
 * JD-Core Version:    0.7.0.1
 */