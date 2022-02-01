package com.tencent.avgame.gameroom.seat.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
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
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource = new SurvivalMemberDataSource();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter.a(this);
  }
  
  private View a(int paramInt, View paramView)
  {
    if (paramInt < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("SurvivalSeatBgGridAdapter", 4, "getMemberView invalide position " + paramInt);
      }
      return paramView;
    }
    SurvivalMemberInfo localSurvivalMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramInt);
    View localView;
    Object localObject;
    if (!(paramView instanceof SurvivalMemberItemView))
    {
      paramView = (SurvivalMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558812, null);
      paramView.setAlpha(0.5F);
      paramView.a();
      localView = paramView;
      localObject = paramView;
    }
    for (;;)
    {
      ((SurvivalMemberItemView)localObject).a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localSurvivalMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter);
      return localView;
      localObject = (SurvivalMemberItemView)paramView;
      localView = paramView;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource == null) || (paramInt < 0) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.d("SurvivalSeatBgGridAdapter", 4, "invalid params updateItemView at " + paramInt);
      }
    }
    SurvivalMemberItemView localSurvivalMemberItemView;
    SurvivalMemberInfo localSurvivalMemberInfo;
    do
    {
      return;
      localSurvivalMemberItemView = (SurvivalMemberItemView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(paramInt);
      localSurvivalMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramInt);
      if (localSurvivalMemberItemView != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("SurvivalSeatBgGridAdapter", 4, "updateItemView itemView is null or member is null");
    return;
    localSurvivalMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, localSurvivalMemberInfo, this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundISurvivalSeatBgPresenter);
  }
  
  public int getCount()
  {
    return GameRoomViewLayoutParamsDef.C;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource == null) {
      return new SurvivalMemberInfo(0L);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramInt) == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgGridAdapter
 * JD-Core Version:    0.7.0.1
 */