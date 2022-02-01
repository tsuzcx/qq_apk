package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import java.util.List;

public class PublicAccountImageCollectionMainActivityImpl$ActionSheetItemAdapter
  extends ArrayAdapter<IPublicAccountBrowser.ActionSheetItem>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<IPublicAccountBrowser.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public PublicAccountImageCollectionMainActivityImpl$ActionSheetItemAdapter(Context paramContext, int paramInt, List<IPublicAccountBrowser.ActionSheetItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public IPublicAccountBrowser.ActionSheetItem a(int paramInt)
  {
    return (IPublicAccountBrowser.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559099, null);
      paramViewGroup = new PublicAccountImageCollectionMainActivityImpl.ActionSheetItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373198));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373199));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (PublicAccountImageCollectionMainActivityImpl.ActionSheetItemViewHolder)paramView.getTag();
    }
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = a(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountBrowser$ActionSheetItem = localActionSheetItem;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localActionSheetItem.jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localActionSheetItem.jdField_a_of_type_Int);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */