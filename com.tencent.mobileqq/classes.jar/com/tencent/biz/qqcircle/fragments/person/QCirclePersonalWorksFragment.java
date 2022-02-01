package com.tencent.biz.qqcircle.fragments.person;

import aabd;
import aabe;
import aabj;
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
import uzg;
import val;
import vqc;
import vqd;
import vxe;
import zzl;
import zzr;

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
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = new val(new Bundle(), a(2));
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
  }
  
  public String a()
  {
    return "profile_page";
  }
  
  public List<aabe> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aabd = new aabd(2131365189, b(), 2, 1);
    localArrayList.add(this.jdField_a_of_type_Aabd);
    return localArrayList;
  }
  
  protected void a()
  {
    this.b = getString(2131697282);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setOwnerPicAndText("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_03.png", getString(2131697285));
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(a());
    this.jdField_a_of_type_Aabd.a().setStatusView((StatusView)localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof val))
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 11;
      ((val)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).a((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Vxe = ((vxe)a(a(), null, vxe.class));
      this.jdField_a_of_type_Vxe.b().observe(a(), new vqc(this));
      this.jdField_a_of_type_Vxe.d().observe(a(), new vqd(this));
    }
    this.jdField_a_of_type_Aabd.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Aabd.a().a().a(5);
    this.jdField_a_of_type_Aabd.a().a().setItemAnimator(null);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Aabd != null) && (this.jdField_a_of_type_Aabd.a() != null) && ((this.jdField_a_of_type_Aabd.a().a() instanceof GridLayoutManager)))
    {
      ((GridLayoutManager)this.jdField_a_of_type_Aabd.a().a()).setSpanCount(a(paramInt));
      Object localObject = new zzl();
      zzr localzzr = new zzr();
      localzzr.a = 2;
      localzzr.b = (ImmersiveUtils.a() - 180);
      localzzr.c = (ImmersiveUtils.b() + 360);
      ((zzl)localObject).a(localzzr);
      ((zzl)localObject).setAddDuration(200L);
      this.jdField_a_of_type_Aabd.a().a().setItemAnimator((RecyclerView.ItemAnimator)localObject);
      if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof val))
      {
        localObject = (val)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
        ((val)localObject).c(a(paramInt));
        ((val)localObject).notifyItemRangeChanged(0, this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount());
        if (paramInt == 2) {
          bool = true;
        }
        ((val)localObject).b(bool);
      }
    }
  }
  
  public String c()
  {
    return "QCirclePersonalWorksFragment";
  }
  
  public boolean d()
  {
    return uzg.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalWorksFragment
 * JD-Core Version:    0.7.0.1
 */