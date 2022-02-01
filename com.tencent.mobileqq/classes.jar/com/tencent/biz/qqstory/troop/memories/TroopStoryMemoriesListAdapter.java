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
  private static final int[] h = { 2131915698, 2131888438 };
  private static final int[] i = { 2131166161, 2131165945 };
  private static final int[] j = { 2131444659, 2131438111 };
  ArrayList<TroopStoryItemInfo> a;
  Context b;
  TroopStoryMemoriesListAdapter.OnUIClickListener c;
  QQAppInterface d;
  final float e;
  TroopStoryMemoriesListAdapter.StoryListItemBuilder f;
  boolean g;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    View localView;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 6: 
      localView = LayoutInflater.from(this.b).inflate(2131628175, paramViewGroup, false);
      paramViewGroup = new TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder(this, localView);
      localView = this.f.createView(this.b, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.b).inflate(2131628175, paramViewGroup, false);
      paramViewGroup = new TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder(this, localView);
      localView = this.f.createView(this.b, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.b).inflate(2131628173, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.EmptyItemHolder(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.b).inflate(2131628174, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.ShootingItemViewHolder(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.b).inflate(2131628175, paramViewGroup, false);
      paramViewGroup = new TroopStoryMemoriesListAdapter.VideoItemViewHolder(this, localView);
      localView = this.f.createView(this.b, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.b).inflate(2131628172, paramViewGroup, false);
      paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.DayItemViewHolder(this, paramViewGroup));
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.b).inflate(2131628176, paramViewGroup, false);
    paramViewGroup.setTag(new TroopStoryMemoriesListAdapter.YearItemViewHolder(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int k = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.a.get(paramInt);
    Object localObject;
    switch (k)
    {
    default: 
      return;
    case 6: 
      localObject = (TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder)paramView.getTag();
      ((TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.2(this, paramInt));
      this.f.updateRightMenuView(this.b, paramView, paramInt, this.a.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    case 5: 
      localObject = (TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder)paramView.getTag();
      ((TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.1(this, paramInt));
      this.f.updateRightMenuView(this.b, paramView, paramInt, this.a.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    case 4: 
      ((TroopStoryMemoriesListAdapter.EmptyItemHolder)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 3: 
      ((TroopStoryMemoriesListAdapter.ShootingItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 2: 
      localObject = (TroopStoryMemoriesListAdapter.VideoItemViewHolder)paramView.getTag();
      ((TroopStoryMemoriesListAdapter.VideoItemViewHolder)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new TroopStoryMemoriesListAdapter.3(this, paramInt));
      this.f.updateRightMenuView(this.b, paramView, paramInt, this.a.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    case 1: 
      ((TroopStoryMemoriesListAdapter.DayItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    }
    ((TroopStoryMemoriesListAdapter.YearItemViewHolder)paramView.getTag()).a(localTroopStoryItemInfo);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Drawable localDrawable = ImageUtil.j();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject = ((UserManager)SuperManager.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject != null) && (((QQUserUIItem)localObject).isAvailable()))
      {
        if (!((QQUserUIItem)localObject).isFriend())
        {
          PlayModeUtils.a(paramURLImageView, ((QQUserUIItem)localObject).headUrl, true, (int)DisplayUtils.a(this.b, 35.0F));
          paramTextView.setText(PlayModeUtils.a((QQUserUIItem)localObject));
          PlayModeUtils.a(this.b.getResources(), paramTextView, ((QQUserUIItem)localObject).symbolUrl, 13.0F, 2.0F);
        }
      }
      else
      {
        paramURLImageView.setImageDrawable(localDrawable);
        paramTextView.setText(PlayModeUtils.a((QQUserUIItem)localObject));
        PlayModeUtils.a(paramTextView);
        return;
      }
    }
    Object localObject = paramTroopStoryItemInfo.uin;
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.d, 1, (String)localObject, 3, localDrawable, localDrawable);
    localObject = localFaceDrawable;
    if (localFaceDrawable == null) {
      localObject = localDrawable;
    }
    paramURLImageView.setImageDrawable((Drawable)localObject);
    paramTextView.setText(paramTroopStoryItemInfo.nickName);
    PlayModeUtils.a(paramTextView);
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
    return ((TroopStoryItemInfo)this.a.get(paramInt)).itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    int k;
    try
    {
      k = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
      }
      k = -1;
    }
    if ((k != -1) && (this.c != null))
    {
      TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.a.get(k);
      int m = paramView.getId();
      if (m != 2131438111)
      {
        if (m == 2131444659) {
          this.c.a(paramView, localTroopStoryItemInfo, 2);
        }
      }
      else {
        this.c.a(paramView, k, localTroopStoryItemInfo, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */