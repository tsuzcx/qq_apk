package com.tencent.ilive.roomclosecomponent;

import android.view.View;
import android.view.ViewStub;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseComponent;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseListener;
import com.tencent.ilive.uicomponent.UIBaseComponent;

public class RoomCloseComponentImpl
  extends UIBaseComponent
  implements RoomCloseComponent
{
  private RoomCloseListener mCloseListener;
  private View mRootView;
  
  public void onCreate(View paramView)
  {
    super.onCreate(paramView);
    paramView = (ViewStub)paramView;
    paramView.setLayoutResource(2131559242);
    this.mRootView = paramView.inflate();
    this.mRootView.setOnClickListener(new RoomCloseComponentImpl.1(this));
  }
  
  public void setCloseListener(RoomCloseListener paramRoomCloseListener)
  {
    this.mCloseListener = paramRoomCloseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.roomclosecomponent.RoomCloseComponentImpl
 * JD-Core Version:    0.7.0.1
 */