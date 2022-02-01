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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class MineWSAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private MineWSPanel.OnItemClickListener jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$OnItemClickListener;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List<MineWSAdapter.NewFeedItemData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public MineWSAdapter(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
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
      UIUtils.a(paramImageView, paramString, 68, 90, 4, UIUtils.b, "QQStoryMemory");
    }
  }
  
  public void a(MineWSPanel.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    MineWSAdapter.NewFeedItemData localNewFeedItemData;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 3;
      if (paramBoolean)
      {
        i = 2;
        localNewFeedItemData = new MineWSAdapter.NewFeedItemData(null, 100);
        this.jdField_a_of_type_JavaUtilList.add(localNewFeedItemData);
      }
      j = paramList.size();
      if (j >= i) {
        break label133;
      }
      i = j;
    }
    label133:
    for (;;)
    {
      j = 0;
      while (j < i)
      {
        localNewFeedItemData = new MineWSAdapter.NewFeedItemData((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.jdField_a_of_type_JavaUtilList.add(localNewFeedItemData);
        j += 1;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
        return 3;
      }
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((MineWSAdapter.NewFeedItemData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramViewHolder.getAdapterPosition();
    MineWSAdapter.NewFeedItemData localNewFeedItemData = (MineWSAdapter.NewFeedItemData)this.jdField_a_of_type_JavaUtilList.get(i);
    int j = localNewFeedItemData.jdField_a_of_type_Int;
    WEISHI.stMetaFeed localstMetaFeed = localNewFeedItemData.jdField_a_of_type_WEISHI_USER_GROWTHWEISHI$stMetaFeed;
    switch (j)
    {
    }
    for (;;)
    {
      paramViewHolder.itemView.setOnClickListener(new MineWSAdapter.1(this, localNewFeedItemData));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (j == 101)
      {
        a(paramViewHolder, localstMetaFeed, i);
        continue;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          ((MineWSAdapter.FeedItemViewHolder)paramViewHolder).a.setImageResource(2130850713);
        } else {
          ((MineWSAdapter.FeedItemViewHolder)paramViewHolder).a.setImageResource(2130846201);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new MineWSAdapter.FeedItemViewHolder(localLayoutInflater.inflate(2131561549, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.adapter.MineWSAdapter
 * JD-Core Version:    0.7.0.1
 */