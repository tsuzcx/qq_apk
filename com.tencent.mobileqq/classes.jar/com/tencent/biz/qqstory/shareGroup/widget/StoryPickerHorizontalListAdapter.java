package com.tencent.biz.qqstory.shareGroup.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StoryPickerHorizontalListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  List<VideoCollectionItem.FakeVideoUIItem> a = new ArrayList();
  HashMap<String, VideoCollectionItem.FakeVideoUIItem> b = new HashMap();
  HashMap<String, WeakReference<StoryPickerHorizontalListAdapter.ItemHolder>> c = new HashMap();
  public String d;
  Context e;
  final int f;
  final int g;
  final int h;
  StoryPickerHorizontalListView.OnCheckBoxClickListener i;
  StoryPickerHorizontalListView.OnHorizontalItemClickListener j;
  
  public StoryPickerHorizontalListAdapter(Context paramContext)
  {
    this.e = paramContext;
    this.f = UIUtils.a(paramContext, 90.0F);
    this.g = UIUtils.a(paramContext, 146.0F);
    this.h = UIUtils.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.e).inflate(2131628154, paramViewGroup, false);
    paramViewGroup.setTag(new StoryPickerHorizontalListAdapter.ItemHolder(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (StoryPickerHorizontalListAdapter.ItemHolder)paramView.getTag();
    VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
    paramView.a(localFakeVideoUIItem, paramInt);
    this.c.put(localFakeVideoUIItem.a, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      UIUtils.a(paramImageView, ThumbnailUrlHelper.a(paramString), this.f, this.g, this.h, UIUtils.h, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public VideoCollectionItem.FakeVideoUIItem a(int paramInt)
  {
    return (VideoCollectionItem.FakeVideoUIItem)this.a.get(paramInt);
  }
  
  public void a(StoryPickerHorizontalListView.OnCheckBoxClickListener paramOnCheckBoxClickListener)
  {
    this.i = paramOnCheckBoxClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalItemClickListener paramOnHorizontalItemClickListener)
  {
    this.j = paramOnHorizontalItemClickListener;
  }
  
  public void a(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    this.a = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      this.b.put(localFakeVideoUIItem.a, localFakeVideoUIItem);
    }
    this.d = paramString;
    super.notifyDataSetChanged();
  }
  
  public void b(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    if (!this.d.equals(paramString))
    {
      SLog.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.d, paramString });
      return;
    }
    SLog.a("StoryPickerHorizontalListAdapter", "updateData");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      paramString = (VideoCollectionItem.FakeVideoUIItem)this.b.get(((VideoCollectionItem.FakeVideoUIItem)localObject).a);
      if ((paramString != null) && (((VideoCollectionItem.FakeVideoUIItem)localObject).b != null))
      {
        paramString.b = ((VideoCollectionItem.FakeVideoUIItem)localObject).b;
        localObject = (WeakReference)this.c.get(((VideoCollectionItem.FakeVideoUIItem)localObject).a);
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = ((StoryPickerHorizontalListAdapter.ItemHolder)((WeakReference)localObject).get()).b;
          a(((StoryCoverView)localObject).a, paramString.b.mVideoThumbnailUrl);
          ((StoryCoverView)localObject).setPollLayout(paramString.b.getPollLayout(), -1, null);
          ((StoryCoverView)localObject).setRateLayout(paramString.b.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = a(paramViewGroup);
      localView.setFocusable(true);
    }
    a(localView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.j != null)
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.d, QQStoryContext.a().i());
      this.j.a(str, paramInt, paramView, localFakeVideoUIItem);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter
 * JD-Core Version:    0.7.0.1
 */