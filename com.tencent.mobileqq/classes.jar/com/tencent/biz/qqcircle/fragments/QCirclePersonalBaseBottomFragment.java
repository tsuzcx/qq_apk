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
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
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
import trq;
import tvv;
import tvw;
import twy;
import ubq;
import yhy;

public abstract class QCirclePersonalBaseBottomFragment
  extends ComponentBaseFragment
{
  private FeedCloudMeta.StUser a;
  protected trq a;
  protected tvw a;
  protected ubq a;
  protected String b;
  
  private List<yhy> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trq = new trq(new Bundle());
    this.jdField_a_of_type_Trq.a(a());
    if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
    {
      int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
        if ((localView instanceof QCirclePersonalBottomView)) {
          this.jdField_a_of_type_Trq.setInteractor(((QCirclePersonalBottomView)localView).a());
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_Trq.setOnLoadDataDelegate(new twy(this));
    localArrayList.add(this.jdField_a_of_type_Trq);
    return localArrayList;
  }
  
  public int a()
  {
    return 2131560567;
  }
  
  public ComponentBaseFragment a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)) && (getActivity().getSupportFragmentManager().getFragments() != null) && (getActivity().getSupportFragmentManager().getFragments().size() > 0) && ((getActivity().getSupportFragmentManager().getFragments().get(0) instanceof ComponentBaseFragment))) {
      return (ComponentBaseFragment)getActivity().getSupportFragmentManager().getFragments().get(0);
    }
    return null;
  }
  
  public List<tvv> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvw = new tvw(2131364910, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Tvw);
    return localArrayList;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Trq != null) {
      this.jdField_a_of_type_Trq.b(paramInt);
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
    this.jdField_a_of_type_Trq.a();
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
    this.jdField_a_of_type_Tvw.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Tvw.a().setEnableRefresh(false);
    this.jdField_a_of_type_Tvw.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Tvw.a().setParentFragment(this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Trq != null) {
      this.jdField_a_of_type_Trq.b();
    }
  }
  
  protected void f()
  {
    try
    {
      if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
      {
        int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
          if ((localView instanceof QCirclePersonInfoAndStatusWidget)) {
            ThreadManager.getUIHandler().post(new QCirclePersonalBaseBottomFragment.2(this, localView));
          }
          i += 1;
        }
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