package com.tencent.avgame.gameroom.seat.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SurvivalSeatBgGridAdapter
  extends BaseAdapter
{
  protected Context a;
  protected LayoutInflater a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected UserInfoHandler a;
  protected ISurvivalSeatBgPresenter a;
  private SurvivalMemberDataSource jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource;
  
  public SurvivalSeatBgGridAdapter(Context paramContext, ISurvivalSeatBgPresenter paramISurvivalSeatBgPresenter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter = paramISurvivalSeatBgPresenter;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)((AppInterface)IGameEngine.a()).getBusinessHandler(HandlerFactory.b));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource = new SurvivalMemberDataSource();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this);
  }
  
  private View a(int paramInt, View paramView)
  {
    Object localObject1;
    if (paramInt < 0)
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getMemberView invalide position ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("SurvivalSeatBgGridAdapter", 4, ((StringBuilder)localObject1).toString());
      }
      return paramView;
    }
    SurvivalMemberInfo localSurvivalMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramInt);
    Object localObject2;
    if (!(paramView instanceof SurvivalMemberItemView))
    {
      paramView = (SurvivalMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558712, null);
      paramView.setAlpha(0.5F);
      paramView.a();
      localObject1 = paramView;
      localObject2 = paramView;
    }
    else
    {
      localObject2 = (SurvivalMemberItemView)paramView;
      localObject1 = paramView;
    }
    ((SurvivalMemberItemView)localObject2).a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localSurvivalMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter);
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource != null) && (paramInt >= 0))
    {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject != null)
      {
        localObject = (SurvivalMemberItemView)((ViewGroup)localObject).getChildAt(paramInt);
        SurvivalMemberInfo localSurvivalMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramInt);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SurvivalSeatBgGridAdapter", 4, "updateItemView itemView is null or member is null");
          }
          return;
        }
        ((SurvivalMemberItemView)localObject).a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localSurvivalMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter);
        return;
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid params updateItemView at ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SurvivalSeatBgGridAdapter", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public int getCount()
  {
    return GameRoomViewLayoutParamsDef.N;
  }
  
  public Object getItem(int paramInt)
  {
    SurvivalMemberDataSource localSurvivalMemberDataSource = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource;
    if (localSurvivalMemberDataSource == null) {
      return new SurvivalMemberInfo(0L);
    }
    if (localSurvivalMemberDataSource.a(paramInt) == null) {
      return new Object();
    }
    return new SurvivalMemberInfo(0L);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    View localView = a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgGridAdapter
 * JD-Core Version:    0.7.0.1
 */