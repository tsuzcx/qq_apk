package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager.OnRefreshChangedListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lam;
import lan;
import lao;
import lar;
import mqq.app.AppRuntime;

public class KanDianViewController
  extends ReadInJoyBaseViewController
  implements ReadInJoyRefreshManager.OnRefreshChangedListener, ReadInJoySkinManager.OnSkinChangedListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyRainAnimationController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController;
  protected ReadInJoyObserver a;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private String jdField_a_of_type_JavaLangString;
  public Map a;
  private lar jdField_a_of_type_Lar;
  private boolean jdField_a_of_type_Boolean;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private Map c = new HashMap();
  
  public KanDianViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lao(this);
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
  }
  
  private void p()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).b();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).h();
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    }
  }
  
  public void F_()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KanDianViewController", 1, "onSkinChanged");
      }
      this.jdField_a_of_type_Lar.sendEmptyMessage(1);
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return null;
  }
  
  public Map a(Integer paramInteger)
  {
    Map localMap = (Map)this.c.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.c.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public Set a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_b_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, 0, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new KanDianViewController.PullRefreshCompleteListener(this));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface();
      if (localAppInterface != null)
      {
        ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)localAppInterface.getManager(260);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController = new ReadInJoyRainAnimationController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.jdField_a_of_type_AndroidContentContext);
        localReadInJoySkinManager.a(this);
        ((ReadInJoyRefreshManager)localAppInterface.getManager(269)).a(this);
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngine.a().b();
    b();
    this.jdField_a_of_type_Lar = new lar(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), a(Integer.valueOf(0)));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_a_of_type_JavaUtilMap);
    }
    if (!this.jdField_b_of_type_Boolean) {
      p();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), a(Integer.valueOf(0)));
    }
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), a(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController.a();
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface();
      if (localAppInterface != null)
      {
        ((ReadInJoySkinManager)localAppInterface.getManager(260)).b(this);
        ((ReadInJoyRefreshManager)localAppInterface.getManager(269)).b(this);
      }
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface();
      if ((localAppInterface != null) && (((ReadInJoySkinManager)localAppInterface.getManager(260)).a() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new lam(this), 8, null, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).i();
    }
  }
  
  public void h()
  {
    super.h();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.c();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).j();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      p();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface();
      if ((localAppInterface != null) && (((ReadInJoySkinManager)localAppInterface.getManager(260)).a() == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyRainAnimationController != null)) {
        ThreadManager.post(new lan(this), 8, null, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).i();
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).n();
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).b(a(Integer.valueOf(0)), a(Integer.valueOf(0)));
      a(Integer.valueOf(0)).clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  public void n()
  {
    F_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController
 * JD-Core Version:    0.7.0.1
 */