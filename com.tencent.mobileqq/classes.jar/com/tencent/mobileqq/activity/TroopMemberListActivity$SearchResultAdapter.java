package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapter;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapterProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TroopMemberListActivity$SearchResultAdapter
  extends BaseAdapter
  implements IFacePreloadBaseAdapter
{
  private IFacePreloadBaseAdapterProxy jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIFacePreloadBaseAdapterProxy;
  public List<TroopMemberListActivity.ATroopMember> a;
  
  public TroopMemberListActivity$SearchResultAdapter(List<TroopMemberListActivity.ATroopMember> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIFacePreloadBaseAdapterProxy = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getFacePreloadBaseAdapterProxy(this, paramList, paramList.app, paramList.searchList, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIFacePreloadBaseAdapterProxy.a(paramInt, paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIFacePreloadBaseAdapterProxy.c();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
    if (TroopMemberListActivity.access$2500(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))
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
    TroopMemberListActivity.TmViewHolder localTmViewHolder;
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mLayoutInflater.inflate(2131562975, paramViewGroup, false);
        localTmViewHolder = new TroopMemberListActivity.TmViewHolder(paramView, false);
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mLayoutInflater.inflate(2131562979, paramViewGroup, false);
        localTmViewHolder = new TroopMemberListActivity.TmViewHolder(paramView, true);
      }
      paramView.setTag(localTmViewHolder);
    }
    else
    {
      localTmViewHolder = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localTmViewHolder.g.setTag(localATroopMember.a);
    localTmViewHolder.b.setTag(localATroopMember.a);
    localTmViewHolder.jdField_a_of_type_AndroidViewView.setTag(localATroopMember.a);
    localTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Bitmap localBitmap = a(1, localATroopMember.a);
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localTroopMemberListActivity.setItemViewValue(localTmViewHolder, localATroopMember, localBitmap, true, bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mFrom == 12) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mAdapter.jdField_a_of_type_JavaUtilList.contains(localATroopMember)) {
        localTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mAddFrdHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mAddFrdHelper.a(localTmViewHolder, localATroopMember);
      if (localTmViewHolder.f.getVisibility() == 0)
      {
        i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
        localTmViewHolder.e.setMaxWidth(i);
        TroopMemberListActivity.access$2600(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, localTmViewHolder.e, localTmViewHolder.d, localATroopMember.a, i);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */