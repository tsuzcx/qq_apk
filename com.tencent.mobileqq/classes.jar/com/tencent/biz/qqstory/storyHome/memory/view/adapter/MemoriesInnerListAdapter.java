package com.tencent.biz.qqstory.storyHome.memory.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.OnUIClickListener;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MemoriesInnerListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  public String a;
  public String b;
  QQUserUIItem c;
  private Context d;
  private List<VideoCollectionItem.FakeVideoUIItem> e = new ArrayList();
  private HashMap<String, VideoCollectionItem.FakeVideoUIItem> f = new HashMap();
  private MyMemoriesListView.OnUIClickListener g = null;
  private MemoriesInnerListAdapter.MemoriesInnerListEventListener h = null;
  private HashMap<String, WeakReference<BaseViewHolder>> i = new HashMap();
  private RoundedTransformation j;
  
  public MemoriesInnerListAdapter(Context paramContext)
  {
    this.d = paramContext;
    this.j = new RoundedTransformation(8, 0, 1.6F, UIUtils.e, null);
    this.c = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.d);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131628079, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131628080, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = ThumbnailUrlHelper.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      UIUtils.a(paramImageView, paramString, 80, 128, 4, UIUtils.h, "QQStoryMemory");
    }
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    SLog.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
      if (localFakeVideoUIItem == null) {
        return;
      }
      localObject = (StoryCoverView)paramBaseViewHolder.a(2131449726);
      if (localFakeVideoUIItem.b == null)
      {
        ((StoryCoverView)localObject).a.setImageDrawable(this.d.getResources().getDrawable(2130848395));
        ((StoryCoverView)localObject).setPollLayout(null, -1, null);
        ((StoryCoverView)localObject).setRateLayout(null, -1, -1L, -1);
      }
      else if (localFakeVideoUIItem.b.mVideoThumbnailUrl != null)
      {
        a(((StoryCoverView)localObject).a, localFakeVideoUIItem.b.mVideoThumbnailUrl);
        ((StoryCoverView)localObject).setPollLayout(localFakeVideoUIItem.b.getPollLayout(), -1, null);
        ((StoryCoverView)localObject).setRateLayout(localFakeVideoUIItem.b.getInteractLayout(), -1, -1L, -1);
      }
      this.i.put(localFakeVideoUIItem.a, new WeakReference(paramBaseViewHolder));
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append(QQStoryConstant.a);
      paramBaseViewHolder.append(" ");
      paramBaseViewHolder.append(paramInt + 1);
      ((StoryCoverView)localObject).setContentDescription(paramBaseViewHolder.toString());
      return;
    }
    Object localObject = (ImageView)paramBaseViewHolder.a(2131440858);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131440845);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.k()))
    {
      paramBaseViewHolder.setBackgroundResource(2130848396);
      ((ImageView)localObject).setImageResource(2130848400);
    }
    else
    {
      paramBaseViewHolder.setBackgroundResource(2130848395);
      ((ImageView)localObject).setImageResource(2130848399);
    }
    ((ImageView)localObject).setContentDescription(HardCodeUtil.a(2131904418));
  }
  
  public VideoCollectionItem.FakeVideoUIItem a(int paramInt)
  {
    if (paramInt < this.e.size()) {
      return (VideoCollectionItem.FakeVideoUIItem)this.e.get(paramInt);
    }
    SLog.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.e.size()));
    return null;
  }
  
  public void a(MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.g = paramOnUIClickListener;
  }
  
  public void a(MemoriesInnerListAdapter.MemoriesInnerListEventListener paramMemoriesInnerListEventListener)
  {
    this.h = paramMemoriesInnerListEventListener;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    this.e = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      this.f.put(localFakeVideoUIItem.a, localFakeVideoUIItem);
    }
    this.a = paramString;
    super.notifyDataSetChanged();
  }
  
  public void b(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    if (!this.a.equals(paramString)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      paramString = (VideoCollectionItem.FakeVideoUIItem)this.f.get(((VideoCollectionItem.FakeVideoUIItem)localObject).a);
      if ((paramString != null) && (((VideoCollectionItem.FakeVideoUIItem)localObject).b != null))
      {
        paramString.b = ((VideoCollectionItem.FakeVideoUIItem)localObject).b;
        localObject = (WeakReference)this.i.get(((VideoCollectionItem.FakeVideoUIItem)localObject).a);
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          a(((StoryCoverView)((BaseViewHolder)((WeakReference)localObject).get()).a(2131449726)).a, paramString.b.mVideoThumbnailUrl);
        }
      }
      else
      {
        SLog.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.e;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      if ((a(paramInt) instanceof MemoriesInnerListAdapter.PublishVideoItem)) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = a(paramInt, paramViewGroup);
      localView.setFocusable(true);
      paramView = new BaseViewHolder(localView);
    }
    else
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localBaseViewHolder;
    }
    a(paramView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    if (localObject != null) {
      if (getItemViewType(paramInt) == 0)
      {
        localObject = this.g;
        if (localObject != null) {
          ((MyMemoriesListView.OnUIClickListener)localObject).a();
        }
      }
      else
      {
        if (this.g != null) {
          if (getItemViewType(0) == 0) {
            this.g.a(this.a, paramInt - 1, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).a);
          } else {
            this.g.a(this.a, paramInt, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).a);
          }
        }
        if (this.h != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.a, this.b);
          this.h.a(str, paramInt, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).a);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter
 * JD-Core Version:    0.7.0.1
 */