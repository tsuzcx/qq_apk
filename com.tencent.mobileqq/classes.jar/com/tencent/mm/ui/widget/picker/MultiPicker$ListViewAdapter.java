package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiPicker$ListViewAdapter
  extends BaseAdapter
{
  private Context b;
  private HashMap<Integer, Boolean> c = new HashMap();
  private ArrayList<Integer> d;
  
  public MultiPicker$ListViewAdapter(MultiPicker paramMultiPicker, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return MultiPicker.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MultiPicker.b(this.a).getItemList().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public ArrayList<Integer> getSelectedItem()
  {
    if (this.c == null) {
      return null;
    }
    this.d = new ArrayList();
    int i = 0;
    while (i < getCount())
    {
      if (((Boolean)this.c.get(Integer.valueOf(i))).booleanValue()) {
        this.d.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return this.d;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    h localh = (h)MultiPicker.b(this.a).getItemList().get(paramInt);
    Object localObject = LayoutInflater.from(this.b);
    if (paramView == null)
    {
      localObject = ((LayoutInflater)localObject).inflate(2131625443, null);
      paramView = new MultiPicker.ListViewAdapter.ViewHolder(this);
      paramView.d = ((LinearLayout)((View)localObject).findViewById(2131436065));
      paramView.c = ((CheckBox)((View)localObject).findViewById(2131435965));
      paramView.a = ((TextView)((View)localObject).findViewById(2131436136));
      paramView.b = ((TextView)((View)localObject).findViewById(2131435976));
      ((View)localObject).setTag(paramView);
    }
    else
    {
      MultiPicker.ListViewAdapter.ViewHolder localViewHolder = (MultiPicker.ListViewAdapter.ViewHolder)paramView.getTag();
      localObject = paramView;
      paramView = localViewHolder;
    }
    paramView.a.setText(localh.getTitle());
    paramView.d.setOnClickListener(new MultiPicker.ListViewAdapter.1(this, paramInt, localh));
    if (paramView.b != null) {
      if ((localh.b() != null) && (localh.b().length() > 0))
      {
        paramView.b.setVisibility(0);
        paramView.b.setText(localh.b());
      }
      else
      {
        paramView.b.setVisibility(8);
      }
    }
    if (localh.f())
    {
      paramView.a.setTextColor(MultiPicker.d(this.a).getResources().getColor(2131165611));
      paramView.b.setTextColor(MultiPicker.d(this.a).getResources().getColor(2131165611));
      paramView.c.setChecked(((Boolean)this.c.get(Integer.valueOf(paramInt))).booleanValue());
      paramView.c.setEnabled(false);
    }
    else
    {
      paramView.a.setTextColor(MultiPicker.d(this.a).getResources().getColor(2131165610));
      paramView.b.setTextColor(MultiPicker.d(this.a).getResources().getColor(2131165612));
      paramView.c.setChecked(((Boolean)this.c.get(Integer.valueOf(paramInt))).booleanValue());
      paramView.c.setEnabled(true);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public void setIsSelected(HashMap<Integer, Boolean> paramHashMap)
  {
    this.c = paramHashMap;
  }
  
  public void setSelectedItem(ArrayList<Integer> paramArrayList)
  {
    if (MultiPicker.e(this.a) == null) {
      return;
    }
    int i = 0;
    while (i < getCount())
    {
      if (MultiPicker.e(this.a).contains(Integer.valueOf(i))) {
        this.c.put(Integer.valueOf(i), Boolean.valueOf(true));
      } else {
        this.c.put(Integer.valueOf(i), Boolean.valueOf(false));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MultiPicker.ListViewAdapter
 * JD-Core Version:    0.7.0.1
 */