package com.tencent.biz.pubaccount.weishi_new;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import bgjq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import uch;
import uci;
import ucj;
import uck;
import ucv;

public abstract class WSBaseFragment<V extends uch, P extends uck<V>>
  extends PublicBaseFragment
  implements uch, uci<V, P>
{
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  private ucj<V, P> jdField_a_of_type_Ucj;
  public P a;
  protected boolean a;
  public boolean b;
  private boolean c;
  
  public MiniMsgUser a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    return localMiniMsgUserParam;
  }
  
  public V a()
  {
    return this;
  }
  
  @NonNull
  protected ucj<V, P> a()
  {
    if (this.jdField_a_of_type_Ucj == null) {
      this.jdField_a_of_type_Ucj = new ucv(this);
    }
    return this.jdField_a_of_type_Ucj;
  }
  
  public void a(P paramP)
  {
    this.jdField_a_of_type_Uck = paramP;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = 9216;
    if (getActivity() == null) {
      return false;
    }
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 23) && (!bgjq.d()) && (!bgjq.b())) {
      if (paramBoolean)
      {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
        bool = paramBoolean;
      }
    }
    for (;;)
    {
      return bool;
      i = 1280;
      break;
      if (ImmersiveUtils.a())
      {
        ImmersiveUtils.a(getActivity().getWindow(), paramBoolean);
        bool = paramBoolean;
        if (Build.VERSION.SDK_INT >= 23)
        {
          bool = paramBoolean;
          if (bgjq.b())
          {
            if (paramBoolean) {}
            for (;;)
            {
              getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
              bool = paramBoolean;
              break;
              i = 1280;
            }
          }
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public P b()
  {
    return this.jdField_a_of_type_Uck;
  }
  
  protected void b() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    a().a(paramBundle);
    if (a())
    {
      paramBundle = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a().b();
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    a().a();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a().a(paramView, paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.c))
    {
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showOnFirst();
      }
      this.c = true;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Boolean = getUserVisibleHint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseFragment
 * JD-Core Version:    0.7.0.1
 */