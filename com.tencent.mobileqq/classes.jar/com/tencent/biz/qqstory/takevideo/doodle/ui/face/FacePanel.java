package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView;
import yuq;
import yus;
import yut;
import yuz;
import yvc;
import yvg;

public class FacePanel
  extends RelativeLayout
  implements yuz
{
  public FacePagerAdapter a;
  public FaceViewPager a;
  public LogoIconListView a;
  public yvc a;
  public yvg a;
  
  public FacePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(super.getContext()).inflate(2131561666, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView = ((LogoIconListView)super.findViewById(2131370554));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setOnItemClickListener(new yus(this));
    this.jdField_a_of_type_Yvg = new yvg(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setAdapter(this.jdField_a_of_type_Yvg);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)super.findViewById(2131366376));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
    this.jdField_a_of_type_Yvg.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
    this.jdField_a_of_type_Yvg.a();
  }
  
  public void setAdapter(yvc paramyvc)
  {
    if (this.jdField_a_of_type_Yvc != null) {
      this.jdField_a_of_type_Yvc.b(this);
    }
    this.jdField_a_of_type_Yvc = paramyvc;
    if (this.jdField_a_of_type_Yvc != null) {
      this.jdField_a_of_type_Yvc.a(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Yvc);
    this.jdField_a_of_type_Yvg.a(this.jdField_a_of_type_Yvc);
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(yuq paramyuq)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramyuq);
  }
  
  public void setOnFaceSelectedListener(yut paramyut)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramyut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel
 * JD-Core Version:    0.7.0.1
 */