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
  protected Context a;
  protected LayoutInflater a;
  protected UserInfoHandler a;
  protected ISeatPresenter a;
  protected SeatViewAdapter.OnItemClickListener a;
  protected ArrayList<SeatMemberInfo> a;
  protected boolean a;
  
  public SeatViewAdapter(Context paramContext, ISeatPresenter paramISeatPresenter)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter = paramISeatPresenter;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)((AppInterface)IGameEngine.a()).getBusinessHandler(HandlerFactory.b));
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
      paramViewGroup = (AddMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558707, null);
      paramViewGroup.setOnClickListener(this);
      paramViewGroup.a();
    }
    return paramViewGroup;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        SeatMemberInfo localSeatMemberInfo = (SeatMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        View localView;
        if ((paramView != null) && ((paramView instanceof MemberItemView)))
        {
          paramViewGroup = (MemberItemView)paramView;
          localView = paramView;
        }
        else
        {
          paramView = (MemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558709, null);
          paramView.a();
          paramView.setOnClickListener(this);
          localView = paramView;
          paramViewGroup = paramView;
        }
        paramViewGroup.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localSeatMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
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
      paramView = (EmptyMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558708, null);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(List<SeatMemberInfo> paramList, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    try
    {
      Object localObject1;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        return localObject1;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()))
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return 1;
      }
      if ((paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) && (this.jdField_a_of_type_Boolean)) {
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
      SeatViewAdapter.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter$OnItemClickListener;
      if (localOnItemClickListener != null) {
        localOnItemClickListener.a(((MemberItemView)localObject).a);
      }
    }
    else if ((paramView instanceof AddMemberItemView))
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter$OnItemClickListener;
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