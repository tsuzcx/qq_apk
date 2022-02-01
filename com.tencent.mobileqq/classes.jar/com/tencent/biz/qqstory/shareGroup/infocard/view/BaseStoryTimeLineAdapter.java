package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.OnInnerListRefreshListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseStoryTimeLineAdapter
  extends BaseAdapter
{
  protected ArrayList<VideoCollectionItem> a = new ArrayList();
  protected Context b;
  protected VideoCollectionItem.DataSortedComparator c = new VideoCollectionItem.DataSortedComparator();
  protected MemoriesInnerListView.OnInnerListRefreshListener d = null;
  protected MyMemoriesListView.OnUIClickListener e = null;
  private final int f;
  
  public BaseStoryTimeLineAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.f = (paramContext.getResources().getDisplayMetrics().heightPixels - UIUtils.a(this.b, 60.0F));
    a(true);
  }
  
  private VideoCollectionItem a(int paramInt)
  {
    SLog.c("Q.qqstory.home.BaseStoryTimeLineAdapter", "getSimpleFakeItem");
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionId = String.valueOf(paramInt);
    localVideoCollectionItem.collectionTime = -1L;
    localVideoCollectionItem.key = "local_empty_item";
    localVideoCollectionItem.isEmptyFakeItem = true;
    return localVideoCollectionItem;
  }
  
  protected abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "bindview. postion=%d", Integer.valueOf(paramInt));
    paramViewGroup = (VideoCollectionItem)this.a.get(paramInt);
    ((BaseStoryTimeLineAdapter.BaseViewHolder)paramView.getTag()).a(paramViewGroup, paramView, paramInt);
  }
  
  protected void a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.a.indexOf(paramVideoCollectionItem) > 0)
    {
      SLog.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
      return;
    }
    int i = Collections.binarySearch(this.a, paramVideoCollectionItem, this.c);
    if (i < 0)
    {
      i = -i;
      this.a.add(i - 1, paramVideoCollectionItem);
    }
  }
  
  public void a(MemoriesInnerListView.OnInnerListRefreshListener paramOnInnerListRefreshListener, MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.d = paramOnInnerListRefreshListener;
    this.e = paramOnUIClickListener;
  }
  
  public abstract void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList);
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "setData, dataList size=%d", Integer.valueOf(paramList.size()));
    c();
    b(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    a(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().i()));
    if ((a()) && (paramBoolean))
    {
      a(VideoCollectionItem.getCurrentYearFakeItem(QQStoryContext.a().i()));
      a(VideoCollectionItem.getTodayFakeItem(QQStoryContext.a().i()));
      int i = this.f;
      int j = UIUtils.a(this.b, 100.0F);
      int k = UIUtils.a(this.b, 65.0F);
      int m = UIUtils.a(this.b, 150.0F);
      this.a.add(a(i - j - k - m));
    }
  }
  
  protected abstract boolean a();
  
  public void b()
  {
    c();
    a(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().i()));
  }
  
  protected void b(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0)
    {
      a(true);
      return;
    }
    a(false);
    int k = this.f - UIUtils.a(this.b, 100.0F);
    Iterator localIterator = paramList.iterator();
    int j = k;
    while (localIterator.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
      a(localVideoCollectionItem);
      if (paramList.size() <= 3)
      {
        int i;
        if (localVideoCollectionItem.collectionType == 0) {
          i = UIUtils.a(this.b, 65.0F);
        }
        for (;;)
        {
          j -= i;
          break;
          if (!TextUtils.isEmpty(com.tencent.biz.qqstory.utils.DateUtils.a(localVideoCollectionItem.collectionTime)[0])) {
            i = UIUtils.a(this.b, 190.0F);
          } else {
            i = UIUtils.a(this.b, 150.0F);
          }
        }
      }
    }
    if ((!b(paramBoolean)) && (j != k) && (j > 0)) {
      this.a.add(a(j));
    }
  }
  
  public abstract boolean b(boolean paramBoolean);
  
  protected void c()
  {
    this.a.clear();
  }
  
  public void c(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    d(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  public VideoCollectionItem d()
  {
    if (this.a.size() > 0)
    {
      Object localObject = this.a;
      localObject = (VideoCollectionItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (((VideoCollectionItem)localObject).isEmptyFakeItem)
      {
        if (this.a.size() >= 2)
        {
          localObject = this.a;
          localObject = (VideoCollectionItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject).collectionId)) {
            return localObject;
          }
        }
      }
      else if (!TextUtils.isEmpty(((VideoCollectionItem)localObject).collectionId)) {
        return localObject;
      }
    }
    return null;
  }
  
  protected void d(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (this.a.size() > 0)
    {
      localObject = this.a;
      localObject = (VideoCollectionItem)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (((VideoCollectionItem)localObject).isEmptyFakeItem)
      {
        SLog.d("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, has fake");
        ArrayList localArrayList = this.a;
        localArrayList.remove(localArrayList.size() - 1);
        break label67;
      }
    }
    Object localObject = null;
    label67:
    SLog.a("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, new dataList=%s", paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((VideoCollectionItem)paramList.next());
    }
    if (localObject != null)
    {
      this.a.add(localObject);
      SLog.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "add fake item.");
    }
    b(paramBoolean);
  }
  
  public ArrayList<VideoCollectionItem> e()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((VideoCollectionItem)this.a.get(paramInt)).collectionType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    if (localView != null) {
      a(paramInt, localView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return VideoCollectionItem.TYPE_ORDER.length;
  }
  
  public boolean isEmpty()
  {
    return getCount() <= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.BaseStoryTimeLineAdapter
 * JD-Core Version:    0.7.0.1
 */