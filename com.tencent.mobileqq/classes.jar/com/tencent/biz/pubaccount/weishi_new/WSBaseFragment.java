package com.tencent.biz.pubaccount.weishi_new;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.weishi_new.drama.part.IWSPartLifeCycle;
import com.tencent.biz.pubaccount.weishi_new.drama.part.IWSPartLifeOwner;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSPartLifeCycleDelegate;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;

public abstract class WSBaseFragment<V extends IWSBaseView, P extends IWSPresenter<V>>
  extends PublicBaseFragment
  implements IWSBaseView, IWSDelegateCallback<V, P>, IWSPartLifeOwner
{
  private IWSFragmentDelegate<V, P> jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSFragmentDelegate;
  protected P a;
  private WSPartLifeCycleDelegate jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate;
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  protected boolean a;
  public boolean b;
  private boolean c;
  
  public V a()
  {
    return this;
  }
  
  @NonNull
  protected IWSFragmentDelegate<V, P> a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSFragmentDelegate == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSFragmentDelegate = new WSFragmentDelegateImpl(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSFragmentDelegate;
  }
  
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
  
  public HashSet<IWSPartLifeCycle> a()
  {
    return null;
  }
  
  protected void a() {}
  
  public void a(P paramP)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter = paramP;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (getBaseActivity() == null) {
      return false;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 9216;
    if ((j >= 23) && (!SystemUtil.d()) && (!SystemUtil.b()))
    {
      if (!paramBoolean) {
        i = 1280;
      }
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      return paramBoolean;
    }
    boolean bool;
    if (ImmersiveUtils.supportStatusBarDarkMode())
    {
      ImmersiveUtils.setStatusBarDarkMode(getBaseActivity().getWindow(), paramBoolean);
      bool = paramBoolean;
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool = paramBoolean;
        if (SystemUtil.b())
        {
          if (!paramBoolean) {
            i = 1280;
          }
          getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(i);
          return paramBoolean;
        }
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public P b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter;
  }
  
  protected boolean h_()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    a().a(paramBundle);
    if (h_())
    {
      paramBundle = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getBaseActivity(), paramBundle);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate = new WSPartLifeCycleDelegate();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.h();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a().b();
    if (h_())
    {
      MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localMiniMsgUser != null) {
        localMiniMsgUser.destroy();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.i();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.F_();
  }
  
  public void onPause()
  {
    super.onPause();
    if (h_())
    {
      MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localMiniMsgUser != null) {
        localMiniMsgUser.onBackground();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.d();
  }
  
  public void onResume()
  {
    super.onResume();
    if (h_())
    {
      MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localMiniMsgUser != null) {
        localMiniMsgUser.onForeground();
      }
    }
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.c();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a().a(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaPartWSPartLifeCycleDelegate.E_();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.c))
    {
      if (h_())
      {
        MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
        if (localMiniMsgUser != null) {
          localMiniMsgUser.showOnFirst();
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseFragment
 * JD-Core Version:    0.7.0.1
 */