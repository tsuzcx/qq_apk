package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PlusPanelAdapter
  extends BaseAdapter
{
  ArrayList<PluginData> a;
  View.OnClickListener b;
  
  public int getCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      return localArrayList.size();
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
    Object localObject1 = BaseApplication.getContext();
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131624462, null);
      paramView = new PlusPanelAdapter.ViewHolder();
      paramView.a = ((ImageView)((View)localObject1).findViewById(2131435389));
      paramView.b = ((ImageView)((View)localObject1).findViewById(2131433314));
      paramView.c = ((TextView)((View)localObject1).findViewById(2131447090));
      ((View)localObject1).setTag(paramView);
    }
    else
    {
      localObject2 = (PlusPanelAdapter.ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = (PluginData)this.a.get(paramInt);
    paramView.a.setBackgroundDrawable(((PluginData)localObject2).k);
    paramView.c.setText(((PluginData)localObject2).d);
    if (((PluginData)localObject2).c) {
      paramView.b.setVisibility(0);
    } else {
      paramView.b.setVisibility(8);
    }
    paramView.d = ((PluginData)localObject2).a;
    ((View)localObject1).setContentDescription(((PluginData)localObject2).e);
    ((View)localObject1).setOnClickListener(this.b);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelAdapter
 * JD-Core Version:    0.7.0.1
 */