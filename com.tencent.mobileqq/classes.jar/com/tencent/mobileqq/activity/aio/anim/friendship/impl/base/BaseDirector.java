package com.tencent.mobileqq.activity.aio.anim.friendship.impl.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseDirector
  implements IDirector
{
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FriendShipLayout.OnBackClickListener jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout$OnBackClickListener = new BaseDirector.1(this);
  private FriendShipLayout jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  
  public BaseDirector(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  @Nullable
  public static IDirector a(@IntRange(from=0L, to=3L) int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeDirector type = ");
      localStringBuilder.append(paramInt);
      QLog.d("BaseDirector", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return new LottieAnimDirector(paramActivity);
        }
        return new FriendShipAnimDirector(paramActivity);
      }
      return new BoatAnimDirector(paramActivity);
    }
    return null;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public FriendShipLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector play");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = new FriendShipLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.setBackListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout$OnBackClickListener);
      int i;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 67109888;
      } else {
        i = 1024;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 2, i, -2);
      new FrameLayout.LayoutParams(-1, -1).gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout, localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    FriendShipLayout localFriendShipLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
    if (localFriendShipLayout != null) {
      localFriendShipLayout.setVisibility(paramInt);
    }
  }
  
  public void a(IDirector.OnDirectorPrepared paramOnDirectorPrepared) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector cancel");
    }
    FriendShipLayout localFriendShipLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
    if (localFriendShipLayout != null) {
      localFriendShipLayout.removeAllViews();
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label43:
      break label43;
    }
    QLog.e("BaseDirector", 1, "cancel anim error");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.BaseDirector
 * JD-Core Version:    0.7.0.1
 */