package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TroopMemberListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  public List<TroopMemberListActivity.ATroopMember> a;
  
  public TroopMemberListActivity$SearchResultAdapter(List<TroopMemberListActivity.ATroopMember> paramList)
  {
    super(paramList, paramList.app, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localATroopMember.m)) && (!TextUtils.isEmpty(localATroopMember.p)) && (!TextUtils.isEmpty(localATroopMember.g)) && (!localATroopMember.g.equals(localATroopMember.p))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    Object localObject2;
    label59:
    boolean bool;
    if (paramView == null) {
      if (i == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563152, paramViewGroup, false);
        paramView = new TroopMemberListActivity.TmViewHolder((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((TroopMemberListActivity.TmViewHolder)localObject1).g.setTag(((TroopMemberListActivity.ATroopMember)localObject2).a);
        ((TroopMemberListActivity.TmViewHolder)localObject1).b.setTag(((TroopMemberListActivity.ATroopMember)localObject2).a);
        ((TroopMemberListActivity.TmViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject2).a);
        ((TroopMemberListActivity.TmViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        Bitmap localBitmap = a(1, ((TroopMemberListActivity.ATroopMember)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localTroopMemberListActivity.a((TroopMemberListActivity.TmViewHolder)localObject1, (TroopMemberListActivity.ATroopMember)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((TroopMemberListActivity.TmViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper.a((TroopMemberListActivity.TmViewHolder)localObject1, (TroopMemberListActivity.ATroopMember)localObject2);
        if (((TroopMemberListActivity.TmViewHolder)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((TroopMemberListActivity.TmViewHolder)localObject1).e.setMaxWidth(i);
          TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, ((TroopMemberListActivity.TmViewHolder)localObject1).e, ((TroopMemberListActivity.TmViewHolder)localObject1).d, ((TroopMemberListActivity.ATroopMember)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563156, paramViewGroup, false);
      paramView = new TroopMemberListActivity.TmViewHolder((View)localObject1, true);
      break;
      localObject1 = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((TroopMemberListActivity.TmViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */