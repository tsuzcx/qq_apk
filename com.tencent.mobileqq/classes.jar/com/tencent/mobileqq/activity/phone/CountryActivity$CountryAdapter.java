package com.tencent.mobileqq.activity.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class CountryActivity$CountryAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private CountryActivity$CountryAdapter(CountryActivity paramCountryActivity) {}
  
  public int a()
  {
    return 2131625567;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.c.get(((PhoneCodeUtils.CountryCode)this.a.b.get(paramInt)).a)).intValue();
    ((TextView)paramView).setText(((PhoneCodeUtils.CountryCode)this.a.b.get(paramInt)).a);
  }
  
  public boolean a(int paramInt)
  {
    return ((PhoneCodeUtils.CountryCode)this.a.b.get(paramInt)).b;
  }
  
  public int getCount()
  {
    return this.a.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((PhoneCodeUtils.CountryCode)this.a.b.get(paramInt)).b ^ true;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhoneCodeUtils.CountryCode localCountryCode = (PhoneCodeUtils.CountryCode)this.a.b.get(paramInt);
    View localView;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = this.a.getLayoutInflater().inflate(a(), paramViewGroup, false);
      }
      ((TextView)localView).setText(localCountryCode.a);
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = CountryActivity.a(paramViewGroup, this.a.getLayoutInflater(), false);
        localView.setOnClickListener(this.a);
      }
      CountryActivity.a(localView, localCountryCode);
    }
    localView.setVisibility(0);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity.CountryAdapter
 * JD-Core Version:    0.7.0.1
 */