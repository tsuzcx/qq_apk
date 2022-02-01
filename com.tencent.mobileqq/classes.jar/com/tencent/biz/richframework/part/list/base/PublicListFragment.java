package com.tencent.biz.richframework.part.list.base;

import aabe;
import aacr;
import aacx;
import aadb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicListFragment
  extends BasePartFragment
{
  protected aacx a;
  protected aadb a;
  protected QCircleFolderTabViewPager a;
  protected ArrayList<aacr> a;
  public List<BasePartFragment> a;
  protected ArrayList<String> b;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager = ((QCircleFolderTabViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381248));
    this.jdField_a_of_type_Aadb = new aadb(this, getActivity().getSupportFragmentManager(), null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setAdapter(this.jdField_a_of_type_Aadb);
  }
  
  public int a()
  {
    return 2131560785;
  }
  
  public aacr a(Intent paramIntent, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = (aacr)Class.forName(paramString).getConstructor(new Class[] { Bundle.class }).newInstance(new Object[] { getActivity().getIntent().getExtras() });
      }
      return null;
    }
    catch (Exception paramString)
    {
      try
      {
        if (paramIntent.hasExtra("public_list_init_data")) {
          paramString.setDatas((ArrayList)paramIntent.getSerializableExtra("public_list_init_data"));
        }
        if (paramIntent.hasExtra("key_bundle_common_init_bean")) {
          paramString.setInitBean(paramIntent.getSerializableExtra("key_bundle_common_init_bean"));
        }
        return paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramIntent = paramString;
          paramString = localException;
        }
      }
      paramString = paramString;
      paramIntent = null;
      QLog.e("PublicListFragment", 1, "initAdapterError" + paramString.getMessage());
      return paramIntent;
    }
  }
  
  public BasePartFragment a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (BasePartFragment)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("PublicListFragment", 1, "initAdapterError" + paramString.getMessage());
    }
    return null;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aacx = new aacx(this.jdField_a_of_type_JavaUtilArrayList);
    localArrayList.add(this.jdField_a_of_type_Aacx);
    return localArrayList;
  }
  
  protected void a()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("public_list_block_class_array"))) {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.b = localIntent.getStringArrayListExtra("public_list_block_class_array");
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          aacr localaacr = a(localIntent, (String)localObject);
          if (localaacr != null)
          {
            PublicListInnerFragment localPublicListInnerFragment = new PublicListInnerFragment();
            localPublicListInnerFragment.a(localaacr);
            this.jdField_a_of_type_JavaUtilArrayList.add(localaacr);
            this.jdField_a_of_type_JavaUtilList.add(localPublicListInnerFragment);
          }
          localObject = a((String)localObject);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("PublicListFragment", 1, "initIntentData error" + localException.getMessage());
        getActivity().finish();
      }
    }
    QLog.e("PublicListFragment", 1, "intent can't be null");
    getActivity().finish();
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b();
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aacr localaacr = (aacr)localIterator.next();
      if (localaacr.getStatusBarColor() != 0) {
        return localaacr.getStatusBarColor();
      }
    }
    return 0;
  }
  
  public String c()
  {
    return "PublicListFragment";
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.list.base.PublicListFragment
 * JD-Core Version:    0.7.0.1
 */