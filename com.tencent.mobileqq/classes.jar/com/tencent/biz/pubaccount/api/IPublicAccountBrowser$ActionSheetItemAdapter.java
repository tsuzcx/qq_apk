package com.tencent.biz.pubaccount.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class IPublicAccountBrowser$ActionSheetItemAdapter
  extends ArrayAdapter<IPublicAccountBrowser.ActionSheetItem>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<IPublicAccountBrowser.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public IPublicAccountBrowser$ActionSheetItemAdapter(Context paramContext, int paramInt, List<IPublicAccountBrowser.ActionSheetItem> paramList)
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559221, null);
      paramView = new IPublicAccountBrowser.ActionSheetItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373625));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373626));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      paramView.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountBrowser$ActionSheetItem = ((IPublicAccountBrowser.ActionSheetItem)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (IPublicAccountBrowser.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */