package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PictureAdapter
  extends BaseAdapter
{
  private List<String> a = new ArrayList();
  private Context b;
  private boolean c;
  
  public PictureAdapter(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = paramBoolean;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.endsWith("video=1");
  }
  
  public boolean a(List<String> paramList)
  {
    List localList = this.a;
    if (paramList == localList) {
      return true;
    }
    if (paramList != null)
    {
      if (localList == null) {
        return false;
      }
      if (paramList.size() != this.a.size()) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (!((String)paramList.get(i)).equals(this.a.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void b(List<String> paramList)
  {
    this.a.addAll(paramList);
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return Math.min(localList.size(), 4);
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < this.a.size()) && (paramInt < 4)) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt < this.a.size()) && (paramInt < 4)) {
      return paramInt;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PictureAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new PictureAdapter.ViewHolder();
      paramView = LayoutInflater.from(this.b).inflate(2131624452, null);
      localViewHolder.a = ((SquareImageView)paramView.findViewById(2131446049));
      localViewHolder.b = paramView.findViewById(2131435743);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (PictureAdapter.ViewHolder)paramView.getTag();
    }
    String str = (String)this.a.get(paramInt);
    localViewHolder.a.post(new PictureAdapter.1(this, localViewHolder, str));
    if ((!this.c) && (a(str))) {
      localViewHolder.b.setVisibility(0);
    } else {
      localViewHolder.b.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PictureAdapter
 * JD-Core Version:    0.7.0.1
 */