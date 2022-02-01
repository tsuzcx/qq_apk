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
  ShareGroupsListView.UIEventListener a;
  public ShareGroupItem a;
  public HashMap<String, WeakReference<ShareGroupsListAdapter.DayCollectionViewHolder>> a;
  public List<HotSortVideoEntry> a;
  protected boolean a;
  protected boolean b = false;
  
  public ShareGroupsListAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(List<HotSortVideoEntry> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    VideoCollectionItem localVideoCollectionItem;
    if (this.b)
    {
      localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      if (localVideoCollectionItem.collectionType == 7)
      {
        localVideoCollectionItem.hotSortVideoLIst.set(1, paramList.get(0));
        paramList.remove(0);
        this.b = false;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.shareGroup.ShareGroupsListAdapter", 2, "[hotlist]填了一个坑");
        }
      }
    }
    int m = paramList.size() / 2;
    int i;
    if (paramList.size() % 2 == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 0;
    int k = 0;
    while (j < m)
    {
      localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.collectionType = 7;
      localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(j), "0_xx");
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k));
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k + 1));
      k += 2;
      this.jdField_a_of_type_JavaUtilArrayList.add(localVideoCollectionItem);
      this.b = false;
      j += 1;
    }
    if ((paramList.size() > 0) && (i != 0))
    {
      localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.collectionType = 7;
      localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(k), "0_xx");
      localVideoCollectionItem.hotSortVideoLIst.add(paramList.get(k));
      localVideoCollectionItem.hotSortVideoLIst.add(null);
      this.jdField_a_of_type_JavaUtilArrayList.add(localVideoCollectionItem);
      this.b = true;
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
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    paramInt = getItemViewType(paramInt);
    if (paramInt == 1)
    {
      paramViewGroup = localLayoutInflater.inflate(2131561769, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.DayCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 0)
    {
      paramViewGroup = localLayoutInflater.inflate(2131561708, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.YearCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 2)
    {
      paramViewGroup = localLayoutInflater.inflate(2131561768, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.ProfilePlaceholderViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    if (paramInt == 7)
    {
      paramViewGroup = localLayoutInflater.inflate(2131561765, paramViewGroup, false);
      paramViewGroup.setTag(new ShareGroupsListAdapter.HotSortCollectionViewHolder(paramViewGroup, this));
      return paramViewGroup;
    }
    return null;
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((HotSortVideoEntry)this.jdField_a_of_type_JavaUtilList.get(i)).storyId.equals(paramHotSortVideoEntry.storyId))
      {
        this.jdField_a_of_type_JavaUtilList.set(i, paramHotSortVideoEntry);
        return;
      }
      i += 1;
    }
  }
  
  public void a(ShareGroupsListView.UIEventListener paramUIEventListener)
  {
    super.a(paramUIEventListener, paramUIEventListener);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener = paramUIEventListener;
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      super.notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList)
  {
    paramList = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramList != null) && (paramList.get() != null))
    {
      VideoCollectionItem localVideoCollectionItem = ((MemoryManager)SuperManager.a(19)).a(paramString);
      if (localVideoCollectionItem != null)
      {
        ((ShareGroupsListAdapter.DayCollectionViewHolder)paramList.get()).a.setData(localVideoCollectionItem);
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
    this.jdField_a_of_type_Boolean = false;
    super.a(paramList, paramBoolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void e(List<HotSortVideoEntry> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = false;
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
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter
 * JD-Core Version:    0.7.0.1
 */