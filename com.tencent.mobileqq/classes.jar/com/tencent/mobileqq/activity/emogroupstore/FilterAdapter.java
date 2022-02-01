package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FilterAdapter
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List<FilterAdapter.FilterItemContent> c;
  
  public FilterAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public void a(List<FilterAdapter.FilterItemContent> paramList)
  {
    this.c = paramList;
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FilterAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new FilterAdapter.ViewHolder(this, null);
      paramView = this.b.inflate(2131628320, null, false);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131435556));
      localViewHolder.b = ((ImageView)paramView.findViewById(2131435555));
      localViewHolder.c = ((TextView)paramView.findViewById(2131448934));
      localViewHolder.d = ((TextView)paramView.findViewById(2131448935));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (FilterAdapter.ViewHolder)paramView.getTag();
    }
    FilterAdapter.FilterItemContent localFilterItemContent = (FilterAdapter.FilterItemContent)this.c.get(paramInt);
    localViewHolder.a.setImageBitmap(localFilterItemContent.b);
    localViewHolder.c.setText(localFilterItemContent.c);
    TextView localTextView = localViewHolder.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFilterItemContent.d);
    localStringBuilder.append(HardCodeUtil.a(2131902607));
    localTextView.setText(localStringBuilder.toString());
    if (localFilterItemContent.e) {
      localViewHolder.b.setImageDrawable(this.a.getResources().getDrawable(2130839362));
    } else {
      localViewHolder.b.setImageDrawable(this.a.getResources().getDrawable(2130839364));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.FilterAdapter
 * JD-Core Version:    0.7.0.1
 */