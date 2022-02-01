package com.tencent.biz.richframework.part.list.base;

import aabd;
import aabe;
import aabj;
import aabp;
import aacr;
import aadc;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PublicListInnerFragment
  extends BasePartFragment
{
  protected aabd a;
  public aacr a;
  
  public int a()
  {
    if ((this.jdField_a_of_type_Aacr != null) && (this.jdField_a_of_type_Aacr.getContentLayoutId() != 0)) {
      return this.jdField_a_of_type_Aacr.getContentLayoutId();
    }
    return 2131560784;
  }
  
  public BlockContainer a()
  {
    if (this.jdField_a_of_type_Aabd != null) {
      return this.jdField_a_of_type_Aabd.a();
    }
    return null;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aabd = new aabd(2131365189, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Aabd);
    if (this.jdField_a_of_type_Aacr != null)
    {
      List localList = this.jdField_a_of_type_Aacr.getCustomParts();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Aabd.a().setEnableRefresh(true);
    this.jdField_a_of_type_Aabd.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Aabd.a().setParentFragment(this);
    this.jdField_a_of_type_Aabd.a().a().a(3);
    this.jdField_a_of_type_Aabd.a().a().setBackgroundColor(getResources().getColor(2131166234));
    this.jdField_a_of_type_Aabd.a().a().addOnScrollListener(new aadc(this));
  }
  
  protected void a(aacr paramaacr)
  {
    this.jdField_a_of_type_Aacr = paramaacr;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Aacr != null) {
      return this.jdField_a_of_type_Aacr.getStatusBarColor();
    }
    return 0;
  }
  
  protected List<aabp> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_Aacr);
    return localArrayList;
  }
  
  public String c()
  {
    return "PublicListInnerFragment";
  }
  
  public boolean f_()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.list.base.PublicListInnerFragment
 * JD-Core Version:    0.7.0.1
 */