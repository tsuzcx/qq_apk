package com.tencent.biz.videostory.adapter;

import WEISHI_USER_GROWTH.WEISHI.stMetaFeed;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.widget.view.MineWSPanel.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class MineWSAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<MineWSAdapter.NewFeedItemData> a = new ArrayList();
  private final QBaseActivity b;
  private boolean c;
  private MineWSPanel.OnItemClickListener d;
  
  public MineWSAdapter(QBaseActivity paramQBaseActivity)
  {
    this.b = paramQBaseActivity;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
  {
    paramViewHolder = (MineWSAdapter.FeedItemViewHolder)paramViewHolder;
    paramstMetaFeed = paramstMetaFeed.material_thumburl.get();
    a(paramViewHolder.a, paramstMetaFeed);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = ThumbnailUrlHelper.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      UIUtils.a(paramImageView, paramString, 68, 90, 4, UIUtils.h, "QQStoryMemory");
    }
  }
  
  public void a(MineWSPanel.OnItemClickListener paramOnItemClickListener)
  {
    this.d = paramOnItemClickListener;
  }
  
  public void a(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.a.clear();
    this.c = paramBoolean;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 3;
      MineWSAdapter.NewFeedItemData localNewFeedItemData;
      if (paramBoolean)
      {
        i = 2;
        localNewFeedItemData = new MineWSAdapter.NewFeedItemData(null, 100);
        this.a.add(localNewFeedItemData);
      }
      int j = paramList.size();
      if (j < i) {
        i = j;
      }
      j = 0;
      while (j < i)
      {
        localNewFeedItemData = new MineWSAdapter.NewFeedItemData((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.a.add(localNewFeedItemData);
        j += 1;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0))
    {
      if (this.a.size() > 3) {
        return 3;
      }
      return this.a.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((MineWSAdapter.NewFeedItemData)this.a.get(paramInt)).a;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramViewHolder.getAdapterPosition();
    MineWSAdapter.NewFeedItemData localNewFeedItemData = (MineWSAdapter.NewFeedItemData)this.a.get(i);
    int j = localNewFeedItemData.a;
    WEISHI.stMetaFeed localstMetaFeed = localNewFeedItemData.b;
    if (j != 100)
    {
      if ((j == 101) && (j == 101)) {
        a(paramViewHolder, localstMetaFeed, i);
      }
    }
    else if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      ((MineWSAdapter.FeedItemViewHolder)paramViewHolder).a.setImageResource(2130852443);
    } else {
      ((MineWSAdapter.FeedItemViewHolder)paramViewHolder).a.setImageResource(2130847547);
    }
    paramViewHolder.itemView.setOnClickListener(new MineWSAdapter.1(this, localNewFeedItemData));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if ((paramInt != 100) && (paramInt != 101)) {
      return null;
    }
    return new MineWSAdapter.FeedItemViewHolder(localLayoutInflater.inflate(2131627746, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.adapter.MineWSAdapter
 * JD-Core Version:    0.7.0.1
 */