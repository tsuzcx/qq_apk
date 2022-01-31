package com.tencent.biz.qqcircle.list;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import tvv;
import tvw;
import tys;
import tyv;
import tyx;
import yhy;
import yib;

public class QCirclePublicListFragment
  extends QCircleBaseFragment
{
  protected tvw a;
  public tys a;
  protected tyx a;
  protected String b;
  
  public int a()
  {
    return 2131560517;
  }
  
  public ComponentPageView a()
  {
    if (this.jdField_a_of_type_Tvw != null) {
      return this.jdField_a_of_type_Tvw.a();
    }
    return null;
  }
  
  public String a()
  {
    return "QCirclePublicListFragment";
  }
  
  public List<tvv> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tyx = new tyx(this.jdField_a_of_type_Tys);
    this.jdField_a_of_type_Tvw = new tvw(2131364910, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Tyx);
    localArrayList.add(this.jdField_a_of_type_Tvw);
    return localArrayList;
  }
  
  public tys a(String paramString)
  {
    if (this.jdField_a_of_type_Tys == null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Tys = ((tys)Class.forName(paramString).getConstructor(new Class[] { Bundle.class }).newInstance(new Object[] { getActivity().getIntent().getExtras() }));
      }
      return this.jdField_a_of_type_Tys;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QCirclePublicListFragment", 1, "initAdapterError" + paramString.getMessage());
        QLog.e("QCirclePublicListFragment", 1, paramString.getMessage());
      }
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    d();
    c();
  }
  
  protected List<yhy> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_Tys);
    return localArrayList;
  }
  
  protected void b()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("qcircle_base_list_adapter_class"))) {
      try
      {
        this.b = localIntent.getStringExtra("qcircle_base_list_adapter_class");
        this.jdField_a_of_type_Tys = a(this.b);
        if (this.jdField_a_of_type_Tys == null)
        {
          QLog.d("QCirclePublicListFragment", 1, "init adapter failed adapterName:" + this.b);
          getActivity().finish();
        }
        if (localIntent.hasExtra("qcircle_base_list_init_data")) {
          this.jdField_a_of_type_Tys.setDatas((ArrayList)localIntent.getSerializableExtra("qcircle_base_list_init_data"));
        }
        if (localIntent.hasExtra("key_bundle_common_init_bean")) {
          this.jdField_a_of_type_Tys.setInitBean((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QCirclePublicListFragment", 1, "initIntentData error" + localException.getMessage());
        getActivity().finish();
        return;
      }
    }
    QLog.e("QCirclePublicListFragment", 1, "intent can't be null");
    getActivity().finish();
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_Tvw.a().setEnableRefresh(true);
    this.jdField_a_of_type_Tvw.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Tvw.a().setParentFragment(this);
    this.jdField_a_of_type_Tvw.a().a().a(3);
    this.jdField_a_of_type_Tvw.a().a().setBackgroundColor(getResources().getColor(2131166178));
    this.jdField_a_of_type_Tvw.a().a().addOnScrollListener(new tyv(this));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.QCirclePublicListFragment
 * JD-Core Version:    0.7.0.1
 */