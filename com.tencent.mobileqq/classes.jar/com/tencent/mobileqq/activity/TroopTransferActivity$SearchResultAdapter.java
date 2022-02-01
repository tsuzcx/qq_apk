package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopTransferActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<TroopTransferActivity.TroopMemberItem> jdField_a_of_type_JavaUtilList;
  
  public TroopTransferActivity$SearchResultAdapter(List<TroopTransferActivity.TroopMemberItem> paramList)
  {
    super(paramList, paramList.app, paramList.b, 1, true);
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131563002, paramViewGroup, false);
      paramView = new TroopTransferActivity.ViewHolder(null);
      paramView.c = ((ImageView)localView.findViewById(2131369676));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380475));
      ((TextView)localView.findViewById(2131380612)).setText("");
      localView.setTag(paramView);
      localObject = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(((TroopTransferActivity.TroopMemberItem)localObject).e)) || (((TroopTransferActivity.TroopMemberItem)localObject).e.equals(((TroopTransferActivity.TroopMemberItem)localObject).b))) {
        break label231;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopTransferActivity.TroopMemberItem)localObject).b + "(" + ((TroopTransferActivity.TroopMemberItem)localObject).e + ")");
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = ((TroopTransferActivity.TroopMemberItem)localObject);
      paramView.c.setImageBitmap(a(1, ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TroopTransferActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label231:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopTransferActivity.TroopMemberItem)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */