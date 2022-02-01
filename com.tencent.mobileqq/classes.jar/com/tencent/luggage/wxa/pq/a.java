package com.tencent.luggage.wxa.pq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pw.a.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

final class a
  extends ArrayAdapter<a.b>
  implements h
{
  private final LayoutInflater a;
  private b b;
  private i c;
  private boolean d = false;
  
  a(@NonNull Context paramContext, @NonNull List<a.b> paramList)
  {
    super(paramContext, 2131624214, paramList);
    this.a = LayoutInflater.from(paramContext);
  }
  
  public void a(@NonNull b paramb)
  {
    this.b = paramb;
    this.b.a(new a.1(this));
  }
  
  void a(i parami)
  {
    this.c = parami;
  }
  
  public void b(@NonNull b paramb)
  {
    this.b.a(null);
    this.b = null;
  }
  
  @NonNull
  public Filter getFilter()
  {
    return super.getFilter();
  }
  
  @NonNull
  public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    int i = 0;
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.inflate(2131624214, paramViewGroup, false);
    }
    a.a locala = (a.a)localView.getTag();
    paramView = locala;
    if (locala == null)
    {
      paramView = new a.a(this, localView);
      localView.setTag(paramView);
    }
    paramView.a((a.b)getItem(paramInt));
    paramView = paramView.e;
    if (paramInt == getCount() - 1) {
      i = 8;
    }
    paramView.setVisibility(i);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.a
 * JD-Core Version:    0.7.0.1
 */