package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ChangeVoiceListAdapter
  extends BaseAdapter
{
  public int a = 4;
  Context b;
  public int c;
  public View.OnClickListener d;
  public ArrayList<VoiceChangeData> e;
  public boolean f = false;
  
  public ChangeVoiceListAdapter(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      int j = this.a;
      return (i + j - 1) / j;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return this.e.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = this.a;
    int j = 0;
    Object localObject1 = paramView;
    int i;
    Object localObject3;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.b, null);
      ((LinearLayout)localObject2).setOrientation(0);
      paramView = LayoutInflater.from(this.b);
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= this.a) {
          break;
        }
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = LayoutInflater.from(this.b);
        }
        ((LinearLayout)localObject2).addView(LayoutInflater.from(this.b).inflate(2131627263, null), (ViewGroup.LayoutParams)localObject3);
        i += 1;
        paramView = (View)localObject1;
      }
    }
    Object localObject2 = (ViewGroup)localObject1;
    if (paramInt == 0)
    {
      ((ViewGroup)localObject2).setPadding(AIOUtils.b(15.0F, this.b.getResources()), AIOUtils.b(14.0F, this.b.getResources()), AIOUtils.b(15.0F, this.b.getResources()), AIOUtils.b(8.0F, this.b.getResources()));
      i = j;
    }
    else
    {
      ((ViewGroup)localObject2).setPadding(AIOUtils.b(15.0F, this.b.getResources()), AIOUtils.b(7.0F, this.b.getResources()), AIOUtils.b(15.0F, this.b.getResources()), AIOUtils.b(8.0F, this.b.getResources()));
      i = j;
    }
    while (i < this.a)
    {
      j = k * paramInt + i;
      localObject3 = (ChangeVoiceView)((ViewGroup)localObject2).getChildAt(i);
      if (localObject3 == null)
      {
        paramView = new StringBuilder();
        paramView.append("getView view == null,view=");
        paramView.append(((ViewGroup)localObject2).getChildAt(i));
        QLog.e("ChangeVoiceListAdapter", 1, paramView.toString());
      }
      else
      {
        ((ChangeVoiceView)localObject3).e = this.c;
        paramView = this.e;
        if ((paramView != null) && (j < paramView.size())) {
          paramView = (VoiceChangeData)this.e.get(j);
        } else {
          paramView = null;
        }
        ((ChangeVoiceView)localObject3).a(paramView);
        if (this.f) {
          ((ChangeVoiceView)localObject3).a();
        }
        if (paramView != null) {
          ((ChangeVoiceView)localObject3).setOnClickListener(this.d);
        } else {
          ((ChangeVoiceView)localObject3).setOnClickListener(null);
        }
      }
      i += 1;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceListAdapter
 * JD-Core Version:    0.7.0.1
 */