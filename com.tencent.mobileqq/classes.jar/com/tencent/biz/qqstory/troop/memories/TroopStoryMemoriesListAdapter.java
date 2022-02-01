package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.util.ArrayList;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131718548, 2131691558 };
  private static final int[] b = { 2131165707, 2131165619 };
  private static final int[] c = { 2131376948, 2131371177 };
  final float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  TroopStoryMemoriesListAdapter.OnUIClickListener jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener;
  TroopStoryMemoriesListAdapter.StoryListItemBuilder jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<TroopStoryItemInfo> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561950, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.YearItemViewHolder(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561946, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.DayItemViewHolder(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561948, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.ShootingItemViewHolder(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561947, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.EmptyItemHolder(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561949, paramViewGroup, false);
      paramViewGroup = new TroopStoryMemoriesListAdapter.VideoItemViewHolder(this, localView);
      localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561949, paramViewGroup, false);
      paramViewGroup = new TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder(this, localView);
      localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561949, paramViewGroup, false);
    paramViewGroup = new TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder(this, localView);
    localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
    localView.setTag(paramViewGroup);
    return localView;
  }
  
  private void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (i)
    {
    default: 
      return;
    case 0: 
      ((TroopStoryMemoriesListAdapter.YearItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((TroopStoryMemoriesListAdapter.DayItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((TroopStoryMemoriesListAdapter.ShootingItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((TroopStoryMemoriesListAdapter.EmptyItemHolder)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder)paramView.getTag();
      ((TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.1(this, paramInt));
      this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    case 6: 
      localObject = (TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder)paramView.getTag();
      ((TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.2(this, paramInt));
      this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    }
    Object localObject = (TroopStoryMemoriesListAdapter.VideoItemViewHolder)paramView.getTag();
    ((TroopStoryMemoriesListAdapter.VideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.3(this, paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$StoryListItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = ImageUtil.c();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((UserManager)SuperManager.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(PlayModeUtils.a((QQUserUIItem)localObject2));
        PlayModeUtils.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        PlayModeUtils.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(PlayModeUtils.a((QQUserUIItem)localObject2));
        PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      PlayModeUtils.a(paramTextView);
      return;
      localObject1 = localObject2;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
        }
        int i = -1;
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener != null)
        {
          TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131371177: 
            this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener.a(paramView, i, localTroopStoryItemInfo, 2);
            break;
          case 2131376948: 
            this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener.a(paramView, localTroopStoryItemInfo, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */