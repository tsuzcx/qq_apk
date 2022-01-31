package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import tat;
import tau;
import tav;
import taw;
import tbf;

public abstract class WSBaseFragment<V extends tat, P extends taw<V>>
  extends PublicBaseFragment
  implements tat, tau<V, P>
{
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  private tav<V, P> jdField_a_of_type_Tav;
  protected P a;
  private boolean jdField_a_of_type_Boolean;
  
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
  protected tav<V, P> a()
  {
    if (this.jdField_a_of_type_Tav == null) {
      this.jdField_a_of_type_Tav = new tbf(this);
    }
    return this.jdField_a_of_type_Tav;
  }
  
  public void a(P paramP)
  {
    this.jdField_a_of_type_Taw = paramP;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public P b()
  {
    return this.jdField_a_of_type_Taw;
  }
  
  protected void b() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
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
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showOnFirst();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseFragment
 * JD-Core Version:    0.7.0.1
 */