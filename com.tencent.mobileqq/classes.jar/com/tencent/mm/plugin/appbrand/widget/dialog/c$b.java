package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

final class c$b
  extends BaseAdapter
{
  private final ArrayList<c.c> a;
  
  c$b(ArrayList<c.c> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public c.c a(int paramInt)
  {
    return (c.c)this.a.get(paramInt);
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = this.a;
    c.c localc = null;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localc = a(paramInt);
      if (paramView == null)
      {
        localObject = new c.b.a(null);
        paramView = View.inflate(paramViewGroup.getContext(), 2131624265, null);
        ((c.b.a)localObject).a = ((ImageView)paramView.findViewById(2131428516));
        ((c.b.a)localObject).b = ((TextView)paramView.findViewById(2131428515));
        paramView.setTag(localObject);
      }
      else
      {
        localObject = (c.b.a)paramView.getTag();
      }
      if (localc.b == 1) {
        ((c.b.a)localObject).a.setImageResource(2130841439);
      } else if (localc.b == 3) {
        ((c.b.a)localObject).a.setImageResource(2130841438);
      } else {
        ((c.b.a)localObject).a.setImageResource(2130841437);
      }
      ((c.b.a)localObject).b.setText(localc.c);
      ImageView localImageView = ((c.b.a)localObject).a;
      ((c.b.a)localObject).a.setOnClickListener(new c.b.1(this, localc, localImageView));
      localObject = paramView;
    }
    else
    {
      localObject = paramView;
      paramView = localc;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c.b
 * JD-Core Version:    0.7.0.1
 */