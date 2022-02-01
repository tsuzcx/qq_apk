package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public class ReadInJoySearchHistoryAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public ReadInJoySearchHistoryAdapter.OnItemClickObserver a = null;
  WeakReference<Context> b;
  List<ReadInJoySearchHistoryEntity> c;
  
  public ReadInJoySearchHistoryAdapter(Context paramContext, List<ReadInJoySearchHistoryEntity> paramList, ReadInJoySearchHistoryAdapter.OnItemClickObserver paramOnItemClickObserver)
  {
    this.b = new WeakReference(paramContext);
    b(paramList);
    this.a = paramOnItemClickObserver;
  }
  
  private void b(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() < 6)
      {
        this.c = paramList;
        return;
      }
      this.c = paramList.subList(0, 5);
      return;
    }
    this.c = null;
  }
  
  public void a(List<ReadInJoySearchHistoryEntity> paramList)
  {
    b(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() != 0)) {
      return this.c.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.c.size()) {
      return this.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (Context)this.b.get();
    if (localObject1 == null)
    {
      Object localObject2 = null;
      localObject1 = paramView;
      paramView = localObject2;
    }
    else
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from((Context)localObject1).inflate(2131625842, null);
        localObject1 = new ReadInJoySearchHistoryAdapter.ViewHolder(this);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131435060));
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).b = ((LinearLayout)paramView.findViewById(2131436785));
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).c = ((RelativeLayout)paramView.findViewById(2131430760));
        paramView.setTag(localObject1);
        paramView.setOnClickListener(this);
      }
      else
      {
        localObject1 = (ReadInJoySearchHistoryAdapter.ViewHolder)paramView.getTag();
      }
      ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).d = paramInt;
      if (paramInt < this.c.size())
      {
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).c.setVisibility(8);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).b.setVisibility(0);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).a.setText(((ReadInJoySearchHistoryEntity)this.c.get(paramInt)).keyWord);
      }
      else if (paramInt == this.c.size())
      {
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).c.setVisibility(0);
        ((ReadInJoySearchHistoryAdapter.ViewHolder)localObject1).b.setVisibility(8);
      }
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ReadInJoySearchHistoryAdapter.ViewHolder))
    {
      Object localObject = (ReadInJoySearchHistoryAdapter.ViewHolder)paramView.getTag();
      if (((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).d < this.c.size())
      {
        if (this.a != null)
        {
          localObject = (ReadInJoySearchHistoryEntity)this.c.get(((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).d);
          this.a.a((ReadInJoySearchHistoryEntity)localObject);
        }
      }
      else if (((ReadInJoySearchHistoryAdapter.ViewHolder)localObject).d == this.c.size())
      {
        localObject = this.a;
        if (localObject != null) {
          ((ReadInJoySearchHistoryAdapter.OnItemClickObserver)localObject).a();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ReadInJoySearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */