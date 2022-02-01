package com.tencent.biz.richframework.part.list.base;

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
import zxi;
import zxj;
import zxo;
import zxu;
import zyv;
import zzg;

public class PublicListInnerFragment
  extends BasePartFragment
{
  protected zxi a;
  public zyv a;
  
  public int a()
  {
    if ((this.jdField_a_of_type_Zyv != null) && (this.jdField_a_of_type_Zyv.getContentLayoutId() != 0)) {
      return this.jdField_a_of_type_Zyv.getContentLayoutId();
    }
    return 2131560759;
  }
  
  public BlockContainer a()
  {
    if (this.jdField_a_of_type_Zxi != null) {
      return this.jdField_a_of_type_Zxi.a();
    }
    return null;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Zxi = new zxi(2131365145, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Zxi);
    if (this.jdField_a_of_type_Zyv != null)
    {
      List localList = this.jdField_a_of_type_Zyv.getCustomParts();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Zxi.a().setEnableRefresh(true);
    this.jdField_a_of_type_Zxi.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Zxi.a().setParentFragment(this);
    this.jdField_a_of_type_Zxi.a().a().a(3);
    this.jdField_a_of_type_Zxi.a().a().setBackgroundColor(getResources().getColor(2131166233));
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new zzg(this));
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
  }
  
  protected void a(zyv paramzyv)
  {
    this.jdField_a_of_type_Zyv = paramzyv;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Zyv != null) {
      return this.jdField_a_of_type_Zyv.getStatusBarColor();
    }
    return 0;
  }
  
  protected List<zxu> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_Zyv);
    return localArrayList;
  }
  
  public boolean c()
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