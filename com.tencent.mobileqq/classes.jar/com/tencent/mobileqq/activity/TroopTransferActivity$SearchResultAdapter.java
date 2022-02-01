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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562824, paramViewGroup, false);
      paramView = new TroopTransferActivity.ViewHolder(null);
      paramView.c = ((ImageView)localView.findViewById(2131369373));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379778));
      ((TextView)localView.findViewById(2131379889)).setText("");
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TroopTransferActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((!TextUtils.isEmpty(((TroopTransferActivity.TroopMemberItem)localObject).e)) && (!((TroopTransferActivity.TroopMemberItem)localObject).e.equals(((TroopTransferActivity.TroopMemberItem)localObject).b)))
    {
      TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TroopTransferActivity.TroopMemberItem)localObject).b);
      localStringBuilder.append("(");
      localStringBuilder.append(((TroopTransferActivity.TroopMemberItem)localObject).e);
      localStringBuilder.append(")");
      localTextView.setText(localStringBuilder.toString());
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopTransferActivity.TroopMemberItem)localObject).b);
    }
    paramView.jdField_a_of_type_JavaLangString = ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString;
    paramView.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = ((TroopTransferActivity.TroopMemberItem)localObject);
    paramView.c.setImageBitmap(a(1, ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */