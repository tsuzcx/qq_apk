package com.tencent.avgame.gamelobby.rv;

import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.common.app.AppInterface;

public class AVGameLobbyOnClickListenerFactory
{
  IAVGameRoomCenterFragment a = null;
  AppInterface b = null;
  private BaseViewHolder.OnClickListener c = new AVGameLobbyOnClickListenerFactory.1(this);
  private BaseViewHolder.OnClickListener d = new AVGameLobbyOnClickListenerFactory.2(this);
  private BaseViewHolder.OnClickListener e = new AVGameLobbyOnClickListenerFactory.3(this);
  private BaseViewHolder.OnClickListener f = new AVGameLobbyOnClickListenerFactory.4(this);
  private BaseViewHolder.OnClickListener g = new AVGameLobbyOnClickListenerFactory.5(this);
  private BaseViewHolder.OnClickListener h = new AVGameLobbyOnClickListenerFactory.6(this);
  private BaseViewHolder.OnClickListener i = new AVGameLobbyOnClickListenerFactory.7(this);
  
  public AVGameLobbyOnClickListenerFactory(IAVGameRoomCenterFragment paramIAVGameRoomCenterFragment)
  {
    this.a = paramIAVGameRoomCenterFragment;
    this.b = paramIAVGameRoomCenterFragment.a();
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
  
  public BaseViewHolder.OnClickListener a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 7: 
      return this.i;
    case 6: 
      return this.h;
    case 5: 
      return this.g;
    case 4: 
      return this.f;
    case 3: 
      return this.e;
    case 2: 
      return this.d;
    }
    return this.c;
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 2131624303;
    case 7: 
      return 2131624300;
    case 6: 
      return 2131624302;
    case 5: 
      return 2131624298;
    case 4: 
      return 2131624299;
    case 3: 
      return 2131624304;
    case 2: 
      return 2131624301;
    }
    return 2131624297;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory
 * JD-Core Version:    0.7.0.1
 */