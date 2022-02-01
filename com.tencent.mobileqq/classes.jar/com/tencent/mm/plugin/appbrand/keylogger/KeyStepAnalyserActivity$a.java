package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.luggage.wxa.nk.c.b;
import com.tencent.luggage.wxa.nk.c.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class KeyStepAnalyserActivity$a
  extends BaseAdapter
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private final LayoutInflater b;
  private List<c.b> c;
  
  KeyStepAnalyserActivity$a(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
  }
  
  public c.b a(int paramInt)
  {
    return (c.b)this.c.get(paramInt);
  }
  
  public void a(List<c.b> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.b.inflate(2131629642, paramViewGroup, false);
      paramView = new KeyStepAnalyserActivity.b();
      paramView.a = ((TextView)localView.findViewById(2131431602));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (KeyStepAnalyserActivity.b)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    boolean bool = a(paramInt).a().isEmpty();
    Object localObject = null;
    if (!bool)
    {
      c.c localc = (c.c)a(paramInt).a().get(0);
      if (localc != null) {
        localObject = a.format(Long.valueOf(localc.a));
      }
    }
    else
    {
      paramView.a.setText(null);
    }
    paramView.a.setText((CharSequence)localObject);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.a
 * JD-Core Version:    0.7.0.1
 */