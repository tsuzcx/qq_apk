package com.tencent.avgame.gamelobby.rv;

import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;

public class AVGameLobbyOnClickListenerFactory
{
  private BaseViewHolder.OnClickListener jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener = new AVGameLobbyOnClickListenerFactory.1(this);
  AVGameRoomCenterFragment jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseViewHolder.OnClickListener b = new AVGameLobbyOnClickListenerFactory.2(this);
  private BaseViewHolder.OnClickListener c = new AVGameLobbyOnClickListenerFactory.3(this);
  private BaseViewHolder.OnClickListener d = new AVGameLobbyOnClickListenerFactory.4(this);
  private BaseViewHolder.OnClickListener e = new AVGameLobbyOnClickListenerFactory.5(this);
  private BaseViewHolder.OnClickListener f = new AVGameLobbyOnClickListenerFactory.6(this);
  private BaseViewHolder.OnClickListener g = new AVGameLobbyOnClickListenerFactory.7(this);
  
  public AVGameLobbyOnClickListenerFactory(AVGameRoomCenterFragment paramAVGameRoomCenterFragment)
  {
    this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment = paramAVGameRoomCenterFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.getActivity().app;
  }
  
  public BaseViewHolder.OnClickListener a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener;
    case 2: 
      return this.b;
    case 3: 
      return this.c;
    case 4: 
      return this.d;
    case 5: 
      return this.e;
    case 6: 
      return this.f;
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory
 * JD-Core Version:    0.7.0.1
 */