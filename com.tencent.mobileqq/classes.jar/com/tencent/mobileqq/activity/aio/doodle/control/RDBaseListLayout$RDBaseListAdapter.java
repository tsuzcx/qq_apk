package com.tencent.mobileqq.activity.aio.doodle.control;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class RDBaseListLayout$RDBaseListAdapter
  extends BaseAdapter
{
  private RDBaseListLayout$RDBaseListAdapter(RDBaseListLayout paramRDBaseListLayout) {}
  
  public void a() {}
  
  public void b() {}
  
  public int getCount()
  {
    return RDBaseListLayout.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return RDBaseListLayout.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = RDBaseListLayout.a(this.a).get(paramInt);
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = this.a.a(paramInt, localObject2);
    }
    else
    {
      localObject1 = (RDBaseListLayout.ViewTagData)paramView.getTag();
      if (localObject1 != null) {
        localObject1 = ((RDBaseListLayout.ViewTagData)localObject1).a;
      } else {
        localObject1 = null;
      }
    }
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = paramView;
      paramView = localObject2;
    }
    else
    {
      this.a.a(paramInt, localObject2, localObject1);
      paramView = ((RDBaseViewHolder)localObject1).a();
      if (paramView != null) {
        paramView.setTag(new RDBaseListLayout.ViewTagData(this.a, paramInt, localObject1));
      }
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout.RDBaseListAdapter
 * JD-Core Version:    0.7.0.1
 */