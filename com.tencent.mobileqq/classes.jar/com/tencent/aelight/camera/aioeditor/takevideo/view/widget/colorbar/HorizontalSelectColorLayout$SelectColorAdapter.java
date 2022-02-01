package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import java.util.ArrayList;

class HorizontalSelectColorLayout$SelectColorAdapter
  extends BaseAdapter
{
  ArrayList<HorizontalStroke> a = new ArrayList();
  int b = -1;
  Context c;
  
  public HorizontalSelectColorLayout$SelectColorAdapter(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.c = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<HorizontalStroke> paramArrayList)
  {
    this.a = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HorizontalStroke localHorizontalStroke = (HorizontalStroke)getItem(paramInt);
    if (paramView == null)
    {
      HorizontalSelectColorLayout.SelectColorAdapter.ItemHold localItemHold = new HorizontalSelectColorLayout.SelectColorAdapter.ItemHold(this);
      if (this.d.g)
      {
        paramView = LayoutInflater.from(this.c).inflate(2131624734, paramViewGroup, false);
        localItemHold.b = ((ImageView)paramView.findViewById(2131436123));
      }
      else
      {
        paramView = LayoutInflater.from(this.c).inflate(2131624733, paramViewGroup, false);
      }
      localItemHold.a = ((ImageView)paramView.findViewById(2131435962));
      localItemHold.c = ((ViewGroup)paramView.findViewById(2131435961));
      paramView.setTag(localItemHold);
      paramViewGroup = localItemHold;
    }
    else
    {
      paramViewGroup = (HorizontalSelectColorLayout.SelectColorAdapter.ItemHold)paramView.getTag();
    }
    if (Build.VERSION.SDK_INT < 21) {
      paramViewGroup.a.setImageDrawable(null);
    }
    paramViewGroup.a.setImageDrawable(localHorizontalStroke.f);
    if (paramInt == this.b)
    {
      if (this.d.g) {
        paramViewGroup.b.setVisibility(0);
      } else {
        paramViewGroup.c.setBackgroundDrawable(this.d.getResources().getDrawable(2130846520));
      }
    }
    else if (this.d.g) {
      paramViewGroup.b.setVisibility(4);
    } else {
      paramViewGroup.c.setBackgroundDrawable(null);
    }
    if (localHorizontalStroke.g != null) {
      paramView.setContentDescription(localHorizontalStroke.g);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.SelectColorAdapter
 * JD-Core Version:    0.7.0.1
 */