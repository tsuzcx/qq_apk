package com.tencent.ilive.litepages.room.bizmodule;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseComponent;

public class LiteRoomCloseBtnModule
  extends RoomBizModule
{
  private RoomCloseComponent mCloseComponent;
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onInflateComponent()
  {
    super.onInflateComponent();
    this.mCloseComponent = ((RoomCloseComponent)getComponentFactory().getComponent(RoomCloseComponent.class).setRootView(getRootView().findViewById(2131364826)).build());
    this.mCloseComponent.setCloseListener(new LiteRoomCloseBtnModule.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomCloseBtnModule
 * JD-Core Version:    0.7.0.1
 */