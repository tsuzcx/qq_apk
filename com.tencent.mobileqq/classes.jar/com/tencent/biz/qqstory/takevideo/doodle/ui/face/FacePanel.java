package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView;
import xdh;
import xdj;
import xdk;
import xdq;
import xdt;
import xdx;

public class FacePanel
  extends RelativeLayout
  implements xdq
{
  public FacePagerAdapter a;
  public FaceViewPager a;
  public LogoIconListView a;
  public xdt a;
  public xdx a;
  
  public FacePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(super.getContext()).inflate(2131561425, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView = ((LogoIconListView)super.findViewById(2131369842));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setOnItemClickListener(new xdj(this));
    this.jdField_a_of_type_Xdx = new xdx(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setAdapter(this.jdField_a_of_type_Xdx);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)super.findViewById(2131365943));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
    this.jdField_a_of_type_Xdx.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
    this.jdField_a_of_type_Xdx.a();
  }
  
  public void setAdapter(xdt paramxdt)
  {
    if (this.jdField_a_of_type_Xdt != null) {
      this.jdField_a_of_type_Xdt.b(this);
    }
    this.jdField_a_of_type_Xdt = paramxdt;
    if (this.jdField_a_of_type_Xdt != null) {
      this.jdField_a_of_type_Xdt.a(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Xdt);
    this.jdField_a_of_type_Xdx.a(this.jdField_a_of_type_Xdt);
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(xdh paramxdh)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramxdh);
  }
  
  public void setOnFaceSelectedListener(xdk paramxdk)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramxdk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel
 * JD-Core Version:    0.7.0.1
 */