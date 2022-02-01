package com.tencent.avgame.gamelobby.rv;

import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.common.app.AppInterface;

public class AVGameLobbyOnClickListenerFactory
{
  IAVGameRoomCenterFragment jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment = null;
  private BaseViewHolder.OnClickListener jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener = new AVGameLobbyOnClickListenerFactory.1(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  private BaseViewHolder.OnClickListener b = new AVGameLobbyOnClickListenerFactory.2(this);
  private BaseViewHolder.OnClickListener c = new AVGameLobbyOnClickListenerFactory.3(this);
  private BaseViewHolder.OnClickListener d = new AVGameLobbyOnClickListenerFactory.4(this);
  private BaseViewHolder.OnClickListener e = new AVGameLobbyOnClickListenerFactory.5(this);
  private BaseViewHolder.OnClickListener f = new AVGameLobbyOnClickListenerFactory.6(this);
  private BaseViewHolder.OnClickListener g = new AVGameLobbyOnClickListenerFactory.7(this);
  
  public AVGameLobbyOnClickListenerFactory(IAVGameRoomCenterFragment paramIAVGameRoomCenterFragment)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment = paramIAVGameRoomCenterFragment;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramIAVGameRoomCenterFragment.a();
  }
  
  private String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith("mqqapi://avgame/create_room"))
    {
      if (paramString.contains("startFrom")) {
        return paramString;
      }
      localObject = new StringBuffer(paramString);
      if (paramString.contains("?")) {
        ((StringBuffer)localObject).append("&startFrom=1");
      } else {
        ((StringBuffer)localObject).append("?startFrom=1");
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 2131558686;
    case 7: 
      return 2131558683;
    case 6: 
      return 2131558685;
    case 5: 
      return 2131558681;
    case 4: 
      return 2131558682;
    case 3: 
      return 2131558687;
    case 2: 
      return 2131558684;
    }
    return 2131558680;
  }
  
  public BaseViewHolder.OnClickListener a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 7: 
      return this.g;
    case 6: 
      return this.f;
    case 5: 
      return this.e;
    case 4: 
      return this.d;
    case 3: 
      return this.c;
    case 2: 
      return this.b;
    }
    return this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory
 * JD-Core Version:    0.7.0.1
 */