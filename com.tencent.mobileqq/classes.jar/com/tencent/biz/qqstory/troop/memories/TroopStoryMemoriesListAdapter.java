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
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.util.ArrayList;
import oln;
import olo;
import olp;
import olq;
import olr;
import ols;
import olu;
import olv;
import olx;
import olz;
import omb;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131435099, 2131434024 };
  private static final int[] b = { 2131493366, 2131493367 };
  private static final int[] c = { 2131366838, 2131369925 };
  public final float a;
  public Context a;
  public TroopStoryMemoriesListAdapter.OnUIClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  olu jdField_a_of_type_Olu;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970813, paramViewGroup, false);
      paramViewGroup.setTag(new omb(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970809, paramViewGroup, false);
      paramViewGroup.setTag(new olq(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970811, paramViewGroup, false);
      paramViewGroup.setTag(new ols(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970810, paramViewGroup, false);
      paramViewGroup.setTag(new olr(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970812, paramViewGroup, false);
      paramViewGroup = new olz(this, localView);
      localView = this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970812, paramViewGroup, false);
      paramViewGroup = new olx(this, localView);
      localView = this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970812, paramViewGroup, false);
    paramViewGroup = new olv(this, localView);
    localView = this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
    localView.setTag(paramViewGroup);
    return localView;
  }
  
  private void a(int paramInt, View paramView)
  {
    int i = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (i)
    {
    default: 
      return;
    case 0: 
      ((omb)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((olq)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((ols)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((olr)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (olx)paramView.getTag();
      ((olx)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new oln(this, paramInt));
      this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    case 6: 
      localObject = (olv)paramView.getTag();
      ((olv)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new olo(this, paramInt));
      this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
      return;
    }
    Object localObject = (olz)paramView.getTag();
    ((olz)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new olp(this, paramInt));
    this.jdField_a_of_type_Olu.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = ImageUtil.b();
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
    localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
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
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    int i;
    TroopStoryItemInfo localTroopStoryItemInfo;
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
          }
          i = -1;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener == null);
      localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener.a(paramView, localTroopStoryItemInfo, 2);
    return;
    this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$OnUIClickListener.a(paramView, i, localTroopStoryItemInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */