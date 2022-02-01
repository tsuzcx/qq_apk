package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public abstract class OnlineStatusHelper
  implements ILifeCycleHelper
{
  protected BaseSessionInfo a;
  protected final AIOContext a;
  private final FriendListObserver a;
  protected final QQAppInterface a;
  protected boolean a;
  
  public OnlineStatusHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new OnlineStatusHelper.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  private TextView b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().b();
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
  }
  
  protected TextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, int paramInt)
  {
    a().setTextColor(paramContext.getResources().getColor(paramInt));
    b().setTextColor(paramContext.getResources().getColor(paramInt));
  }
  
  protected void a(String paramString)
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c(paramBoolean);
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a == 1008;
  }
  
  public abstract void b();
  
  protected void c() {}
  
  public int[] interestedIn()
  {
    return new int[] { 6, 4, 1, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6)
        {
          if (paramInt != 15) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      c();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OnlineStatusHelper
 * JD-Core Version:    0.7.0.1
 */