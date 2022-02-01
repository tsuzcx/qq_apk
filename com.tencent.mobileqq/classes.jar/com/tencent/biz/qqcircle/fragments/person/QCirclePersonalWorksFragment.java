package com.tencent.biz.qqcircle.fragments.person;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import uxx;
import uyy;
import vnv;
import vuf;
import zvq;
import zvw;
import zxi;
import zxj;
import zxo;

public class QCirclePersonalWorksFragment
  extends QCirclePersonalBaseBottomFragment
{
  public int a(int paramInt)
  {
    if (paramInt == 2) {}
    while (paramInt != 1) {
      return 1;
    }
    return 3;
  }
  
  protected QCircleFakeAdapter a()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = new uyy(new Bundle(), a(2));
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
  }
  
  public String a()
  {
    return "profile_page";
  }
  
  public List<zxj> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Zxi = new zxi(2131365145, b(), 2, 1);
    localArrayList.add(this.jdField_a_of_type_Zxi);
    return localArrayList;
  }
  
  protected void a()
  {
    this.b = getString(2131697214);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setOwnerPicAndText("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_03.png", getString(2131697216));
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(a());
    this.jdField_a_of_type_Zxi.a().setStatusView((StatusView)localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof uyy))
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 11;
      ((uyy)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).a((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Vuf = ((vuf)a(a(), null, vuf.class));
      this.jdField_a_of_type_Vuf.b().observe(a(), new vnv(this));
    }
    this.jdField_a_of_type_Zxi.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Zxi.a().a().a(5);
    this.jdField_a_of_type_Zxi.a().a().setItemAnimator(null);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vuf != null) {
      this.jdField_a_of_type_Vuf.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Zxi != null) && (this.jdField_a_of_type_Zxi.a() != null) && ((this.jdField_a_of_type_Zxi.a().a() instanceof GridLayoutManager)))
    {
      ((GridLayoutManager)this.jdField_a_of_type_Zxi.a().a()).setSpanCount(a(paramInt));
      Object localObject = new zvq();
      zvw localzvw = new zvw();
      localzvw.a = 2;
      localzvw.b = (ImmersiveUtils.a() - 180);
      localzvw.c = (ImmersiveUtils.b() + 360);
      ((zvq)localObject).a(localzvw);
      ((zvq)localObject).setAddDuration(200L);
      this.jdField_a_of_type_Zxi.a().a().setItemAnimator((RecyclerView.ItemAnimator)localObject);
      if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof uyy))
      {
        localObject = (uyy)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
        ((uyy)localObject).c(a(paramInt));
        ((uyy)localObject).notifyItemRangeChanged(0, this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount());
        if (paramInt == 2) {
          bool = true;
        }
        ((uyy)localObject).b(bool);
      }
    }
  }
  
  public boolean d()
  {
    return uxx.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalWorksFragment
 * JD-Core Version:    0.7.0.1
 */