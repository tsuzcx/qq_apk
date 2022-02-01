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
    return GiftPkgSelectDialog.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return GiftPkgSelectDialog.b(this.a).get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626261, null);
      paramView = new GiftPkgSelectDialog.ViewHolder(this.a);
      paramView.a = ((TextView)localView.findViewById(2131448801));
      paramView.b = ((ImageView)localView.findViewById(2131436314));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (GiftPkgSelectDialog.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (GiftServiceBean)getItem(paramInt);
    paramView.a.setText(((GiftServiceBean)localObject).t);
    if (GiftPkgSelectDialog.e(this.a) == paramInt) {
      paramView.b.setBackgroundResource(2130843961);
    } else {
      paramView.b.setBackgroundResource(2130843962);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.SelectAdatpter
 * JD-Core Version:    0.7.0.1
 */