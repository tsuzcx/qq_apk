package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class PokePanelAdapter
  extends BaseAdapter
{
  View.OnClickListener a;
  ArrayList<PokePanel.PokeData> b = new ArrayList();
  private Context c;
  private PokePanel d = null;
  
  public PokePanelAdapter(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private int b()
  {
    ArrayList localArrayList = this.b;
    int j = 3;
    int i = j;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return 3;
      }
      if (this.b.size() <= 3) {
        return 3;
      }
      if ((this.b.size() > 3) && (this.b.size() <= 6)) {
        return 3;
      }
      i = j;
      if (this.b.size() > 6) {
        i = 4;
      }
    }
    return i;
  }
  
  public ArrayList<PokePanel.PokeData> a()
  {
    return this.b;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void a(PokePanel paramPokePanel)
  {
    this.d = paramPokePanel;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      PokePanel.PokeData localPokeData = (PokePanel.PokeData)localIterator.next();
      if (paramString.equals("poke.item.effect."))
      {
        if (localPokeData.c == paramInt)
        {
          localPokeData.i = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
      else if (paramString.equals("poke.item.res."))
      {
        if (localPokeData.c == paramInt)
        {
          localPokeData.h = paramBoolean2;
          localPokeData.i = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<PokePanel.PokeData> paramArrayList)
  {
    this.b.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b != null)
    {
      int i = b();
      return (this.b.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = b();
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.c, null);
      ((LinearLayout)localObject2).setOrientation(0);
      localObject1 = LayoutInflater.from(this.c);
      i = 0;
      while (i < j)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = LayoutInflater.from(this.c);
        }
        localObject1 = LayoutInflater.from(this.c).inflate(2131624463, null);
        ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new PokePanelAdapter.ViewHolder(this);
        ((PokePanelAdapter.ViewHolder)localObject3).a = ((ImageView)((View)localObject1).findViewById(2131435389));
        ((PokePanelAdapter.ViewHolder)localObject3).b = ((ImageView)((View)localObject1).findViewById(2131433314));
        ((PokePanelAdapter.ViewHolder)localObject3).f = ((TextView)((View)localObject1).findViewById(2131447090));
        ((PokePanelAdapter.ViewHolder)localObject3).c = ((ImageView)((View)localObject1).findViewById(2131432834));
        ((PokePanelAdapter.ViewHolder)localObject3).e = ((ProgressBar)((View)localObject1).findViewById(2131437646));
        ((PokePanelAdapter.ViewHolder)localObject3).d = ((ImageView)((View)localObject1).findViewById(2131432101));
        ((View)localObject1).setTag(localObject3);
        i += 1;
        localObject1 = paramView;
      }
      paramView = (View)localObject2;
    }
    Object localObject1 = (ViewGroup)paramView;
    if (paramInt == 0) {
      ((ViewGroup)localObject1).setPadding(AIOUtils.b(15.0F, this.c.getResources()), AIOUtils.b(14.0F, this.c.getResources()), AIOUtils.b(15.0F, this.c.getResources()), AIOUtils.b(8.0F, this.c.getResources()));
    } else {
      ((ViewGroup)localObject1).setPadding(AIOUtils.b(15.0F, this.c.getResources()), AIOUtils.b(7.0F, this.c.getResources()), AIOUtils.b(15.0F, this.c.getResources()), AIOUtils.b(8.0F, this.c.getResources()));
    }
    int i = 0;
    while (i < j)
    {
      int k = j * paramInt + i;
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      localObject3 = (PokePanelAdapter.ViewHolder)((View)localObject2).getTag();
      if (k < this.b.size())
      {
        PokePanel.PokeData localPokeData = (PokePanel.PokeData)this.b.get(k);
        ((PokePanelAdapter.ViewHolder)localObject3).a.setVisibility(0);
        ((PokePanelAdapter.ViewHolder)localObject3).a.setImageDrawable(localPokeData.b);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).a).setCustomDrawable(localPokeData.b);
        Object localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("type", localPokeData.a);
        ((Bundle)localObject4).putInt("id", localPokeData.c);
        ((Bundle)localObject4).putString("name", localPokeData.d);
        ((Bundle)localObject4).putInt("feeType", localPokeData.g);
        ((Bundle)localObject4).putBoolean("isShowDownload", localPokeData.h);
        ((Bundle)localObject4).putBoolean("isShowLoading", localPokeData.i);
        ((Bundle)localObject4).putString("minVersion", localPokeData.j);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).a).setExtraInfo((Bundle)localObject4);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).a).setOnTouchReceive(this.d);
        if ((localPokeData.b instanceof URLDrawable))
        {
          localObject4 = (URLDrawable)localPokeData.b;
          if (((URLDrawable)localObject4).getStatus() == 2) {
            ((URLDrawable)localObject4).restartDownload();
          }
        }
        else if ((localPokeData.b instanceof CustomFrameAnimationDrawable))
        {
          ((PokePanelAdapter.ViewHolder)localObject3).e.setVisibility(8);
          ((CustomFrameAnimationDrawable)localPokeData.b).c();
        }
        ((PokePanelAdapter.ViewHolder)localObject3).f.setText(localPokeData.d);
        if (localPokeData.f) {
          ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(0);
        } else {
          ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(8);
        }
        if (localPokeData.g == 4)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).c.setImageDrawable(this.c.getResources().getDrawable(2130849299));
        }
        else if (localPokeData.g == 5)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).c.setImageDrawable(this.c.getResources().getDrawable(2130849298));
        }
        else
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(8);
        }
        if (localPokeData.h)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).d.setTag(Integer.valueOf(localPokeData.c));
        }
        else
        {
          ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(8);
        }
        if (localPokeData.i) {
          ((PokePanelAdapter.ViewHolder)localObject3).e.setVisibility(0);
        } else {
          ((PokePanelAdapter.ViewHolder)localObject3).e.setVisibility(8);
        }
        ((View)localObject2).setContentDescription(localPokeData.d);
        ((View)localObject2).setEnabled(true);
        AccessibilityUtil.a((View)localObject2, true);
      }
      else
      {
        ((PokePanelAdapter.ViewHolder)localObject3).a.setVisibility(4);
        ((PokePanelAdapter.ViewHolder)localObject3).a.setBackgroundDrawable(null);
        ((PokePanelAdapter.ViewHolder)localObject3).f.setText(null);
        ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).e.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).d.setTag(null);
        ((View)localObject2).setEnabled(false);
        AccessibilityUtil.a((View)localObject2, false);
      }
      AccessibilityUtil.a(((PokePanelAdapter.ViewHolder)localObject3).f, false);
      i += 1;
    }
    paramView.setOnLongClickListener(null);
    AccessibilityUtil.a(paramView, false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanelAdapter
 * JD-Core Version:    0.7.0.1
 */