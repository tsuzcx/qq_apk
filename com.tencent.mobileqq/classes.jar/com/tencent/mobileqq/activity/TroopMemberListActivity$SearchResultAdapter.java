package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.List;

public class TroopMemberListActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  protected List a;
  
  public TroopMemberListActivity$SearchResultAdapter(TroopMemberListActivity paramTroopMemberListActivity, List paramList)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    Object localObject;
    label54:
    TroopMemberListActivity localTroopMemberListActivity;
    Bitmap localBitmap;
    if (paramView == null) {
      if (i == 0)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971680, paramViewGroup, false);
        paramView = new TroopMemberListActivity.TmViewHolder(paramViewGroup, false);
        paramViewGroup.setTag(paramView);
        localObject = paramView;
        paramView = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject;
        localObject = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).a);
        paramViewGroup.b.setTag(((TroopMemberListActivity.ATroopMember)localObject).a);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).a);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        localBitmap = a(1, ((TroopMemberListActivity.ATroopMember)localObject).a);
        if (i != 1) {
          break label237;
        }
      }
    }
    label237:
    for (boolean bool = true;; bool = false)
    {
      localTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, localBitmap, true, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 12)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilList.contains(localObject)) {
          break label243;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971682, paramViewGroup, false);
      paramView = new TroopMemberListActivity.TmViewHolder(paramViewGroup, true);
      break;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
      break label54;
    }
    label243:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
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