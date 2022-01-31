package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.SystemBarCompact;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import trl;
import tvg;
import tvm;
import twh;
import tzf;
import ydp;

public abstract class QCirclePersonalBaseBottomFragment
  extends ComponentBaseFragment
{
  private FeedCloudMeta.StUser a;
  protected trl a;
  protected tvm a;
  protected tzf a;
  protected String b;
  
  private List<ydp> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trl = new trl(new Bundle());
    this.jdField_a_of_type_Trl.a(a());
    if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(1) != null))
    {
      View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(1);
      if ((localView instanceof QCirclePersonalBottomView)) {
        this.jdField_a_of_type_Trl.a(((QCirclePersonalBottomView)localView).a());
      }
    }
    this.jdField_a_of_type_Trl.a(new twh(this));
    localArrayList.add(this.jdField_a_of_type_Trl);
    return localArrayList;
  }
  
  public int a()
  {
    return 2131560554;
  }
  
  public ComponentBaseFragment a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)) && (getActivity().getSupportFragmentManager().getFragments() != null) && (getActivity().getSupportFragmentManager().getFragments().size() > 0) && ((getActivity().getSupportFragmentManager().getFragments().get(0) instanceof ComponentBaseFragment))) {
      return (ComponentBaseFragment)getActivity().getSupportFragmentManager().getFragments().get(0);
    }
    return null;
  }
  
  public List<tvg> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvm = new tvm(2131364908, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Tvm);
    return localArrayList;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Trl != null) {
      this.jdField_a_of_type_Trl.b(paramInt);
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity().mSystemBarComp;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarVisible(2, 0);
    }
    d();
    a();
    this.jdField_a_of_type_Trl.Q_();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public abstract void b();
  
  protected void c()
  {
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((((QCircleInitBean)localObject).getUser() != null) && (!TextUtils.isEmpty(((QCircleInitBean)localObject).getUser().id.get())))
      {
        this.b = ((QCircleInitBean)localObject).getUser().id.get();
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = ((QCircleInitBean)localObject).getUser();
      }
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Tvm.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Tvm.a().setEnableRefresh(false);
    this.jdField_a_of_type_Tvm.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Tvm.a().setParentFragment(this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Trl != null) {
      this.jdField_a_of_type_Trl.b();
    }
  }
  
  protected void f()
  {
    try
    {
      if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(0) != null))
      {
        View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(0);
        ThreadManager.getUIHandler().post(new QCirclePersonalBaseBottomFragment.2(this, localView));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 0, "adjustEmptyViewHeight()  e.getMessage : " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment
 * JD-Core Version:    0.7.0.1
 */