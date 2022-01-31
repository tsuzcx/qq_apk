package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView;
import vbw;
import vby;
import vbz;
import vcf;
import vci;
import vcm;

public class FacePanel
  extends RelativeLayout
  implements vcf
{
  public FacePagerAdapter a;
  public FaceViewPager a;
  public LogoIconListView a;
  public vci a;
  public vcm a;
  
  public FacePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(super.getContext()).inflate(2131495645, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView = ((LogoIconListView)super.findViewById(2131303904));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setOnItemClickListener(new vby(this));
    this.jdField_a_of_type_Vcm = new vcm(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setAdapter(this.jdField_a_of_type_Vcm);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)super.findViewById(2131300258));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
    this.jdField_a_of_type_Vcm.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
    this.jdField_a_of_type_Vcm.a();
  }
  
  public void setAdapter(vci paramvci)
  {
    if (this.jdField_a_of_type_Vci != null) {
      this.jdField_a_of_type_Vci.b(this);
    }
    this.jdField_a_of_type_Vci = paramvci;
    if (this.jdField_a_of_type_Vci != null) {
      this.jdField_a_of_type_Vci.a(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Vci);
    this.jdField_a_of_type_Vcm.a(this.jdField_a_of_type_Vci);
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(vbw paramvbw)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramvbw);
  }
  
  public void setOnFaceSelectedListener(vbz paramvbz)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramvbz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel
 * JD-Core Version:    0.7.0.1
 */