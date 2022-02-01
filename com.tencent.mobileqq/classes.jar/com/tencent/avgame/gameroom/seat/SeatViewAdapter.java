package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SeatViewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  protected ArrayList<SeatMemberInfo> a = new ArrayList();
  protected Context b;
  protected LayoutInflater c;
  protected boolean d = false;
  protected SeatViewAdapter.OnItemClickListener e;
  protected UserInfoHandler f;
  protected ISeatPresenter g;
  
  public SeatViewAdapter(Context paramContext, ISeatPresenter paramISeatPresenter)
  {
    this.b = paramContext;
    this.g = paramISeatPresenter;
    this.c = LayoutInflater.from(paramContext);
    this.f = ((UserInfoHandler)((AppInterface)IGameEngine.K()).getBusinessHandler(HandlerFactory.b));
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView instanceof AddMemberItemView)) {}
    }
    else
    {
      paramViewGroup = (AddMemberItemView)this.c.inflate(2131624324, null);
      paramViewGroup.setOnClickListener(this);
      paramViewGroup.a();
    }
    return paramViewGroup;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.a;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.a.size())
      {
        SeatMemberInfo localSeatMemberInfo = (SeatMemberInfo)this.a.get(paramInt);
        View localView;
        if ((paramView != null) && ((paramView instanceof MemberItemView)))
        {
          paramViewGroup = (MemberItemView)paramView;
          localView = paramView;
        }
        else
        {
          paramView = (MemberItemView)this.c.inflate(2131624326, null);
          paramView.a();
          paramView.setOnClickListener(this);
          localView = paramView;
          paramViewGroup = paramView;
        }
        paramViewGroup.a(this.f, localSeatMemberInfo, this.g);
        return localView;
      }
      return paramView;
    }
    finally {}
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof EmptyMemberItemView))
    {
      paramView = (EmptyMemberItemView)this.c.inflate(2131624325, null);
      paramView.a();
    }
    else
    {
      paramView = (EmptyMemberItemView)paramView;
    }
    paramView.a(false);
    return paramView;
  }
  
  public void a(SeatViewAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.e = paramOnItemClickListener;
  }
  
  public void a(List<SeatMemberInfo> paramList, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      this.d = paramBoolean;
      this.a.clear();
      if (paramList != null) {
        this.a.addAll(paramList);
      }
      return;
    }
  }
  
  public int getCount()
  {
    return 8;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if (paramInt >= 0) {}
    try
    {
      Object localObject1;
      if (paramInt < this.a.size())
      {
        localObject1 = this.a.get(paramInt);
        return localObject1;
      }
      if ((this.d) && (paramInt == this.a.size()))
      {
        localObject1 = new Object();
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.a.size()) {
        return 1;
      }
      if ((paramInt == this.a.size()) && (this.d)) {
        return 0;
      }
      return 2;
    }
    finally {}
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i == 1) {
      localView = b(paramInt, paramView, paramViewGroup);
    } else if (i == 0) {
      localView = a(paramInt, paramView, paramViewGroup);
    } else {
      localView = c(paramInt, paramView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView instanceof MemberItemView))
    {
      localObject = (MemberItemView)paramView;
      SeatViewAdapter.OnItemClickListener localOnItemClickListener = this.e;
      if (localOnItemClickListener != null) {
        localOnItemClickListener.a(((MemberItemView)localObject).a);
      }
    }
    else if ((paramView instanceof AddMemberItemView))
    {
      localObject = this.e;
      if (localObject != null) {
        ((SeatViewAdapter.OnItemClickListener)localObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatViewAdapter
 * JD-Core Version:    0.7.0.1
 */