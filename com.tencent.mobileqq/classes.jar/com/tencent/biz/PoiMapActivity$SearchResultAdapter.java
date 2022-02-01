package com.tencent.biz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class PoiMapActivity$SearchResultAdapter
  extends BaseAdapter
{
  protected LayoutInflater a;
  
  public PoiMapActivity$SearchResultAdapter(PoiMapActivity paramPoiMapActivity, Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.b.K == null) {
      return 0;
    }
    if (this.b.G) {
      return this.b.K.size() + 1;
    }
    return this.b.K.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b.K == null) {
      return null;
    }
    return this.b.K.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PoiMapActivity.PoiItemViewHolder localPoiItemViewHolder;
    if (paramView == null)
    {
      localPoiItemViewHolder = new PoiMapActivity.PoiItemViewHolder(this.b);
      paramView = LayoutInflater.from(this.b).inflate(2131626003, null);
      localPoiItemViewHolder.b = ((TextView)paramView.findViewById(2131439135));
      localPoiItemViewHolder.c = ((TextView)paramView.findViewById(2131427833));
      localPoiItemViewHolder.i = paramView.findViewById(2131445527);
      localPoiItemViewHolder.i.setVisibility(4);
      localPoiItemViewHolder.j = paramView.findViewById(2131438871);
      localPoiItemViewHolder.a = paramView.findViewById(2131431787);
      localPoiItemViewHolder.d = paramView.findViewById(2131445751);
      paramView.setTag(localPoiItemViewHolder);
    }
    else
    {
      localPoiItemViewHolder = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    localPoiItemViewHolder.d.setVisibility(8);
    if (paramInt == this.b.K.size())
    {
      localPoiItemViewHolder.j.setVisibility(0);
      localPoiItemViewHolder.a.setVisibility(8);
    }
    else
    {
      localPoiItemViewHolder.j.setVisibility(8);
      localPoiItemViewHolder.a.setVisibility(0);
      PoiMapActivity.POI localPOI = (PoiMapActivity.POI)getItem(paramInt);
      if (localPOI != null)
      {
        localPoiItemViewHolder.b.setText(localPOI.a);
        localPoiItemViewHolder.c.setText(localPOI.b);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */