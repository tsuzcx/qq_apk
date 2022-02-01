package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GiftPkgSelectDialog$SelectAdatpter
  extends BaseAdapter
{
  GiftPkgSelectDialog$SelectAdatpter(GiftPkgSelectDialog paramGiftPkgSelectDialog) {}
  
  public int getCount()
  {
    return GiftPkgSelectDialog.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return GiftPkgSelectDialog.a(this.a).get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560327, null);
      paramView = new GiftPkgSelectDialog.ViewHolder(this.a);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380639));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369606));
      localView.setTag(paramView);
      localObject = (GiftServiceBean)getItem(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((GiftServiceBean)localObject).t);
      if (GiftPkgSelectDialog.a(this.a) != paramInt) {
        break label143;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843099);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (GiftPkgSelectDialog.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label143:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.SelectAdatpter
 * JD-Core Version:    0.7.0.1
 */