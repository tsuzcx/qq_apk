package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView;
import zew;
import zey;
import zez;
import zff;
import zfi;
import zfm;

public class FacePanel
  extends RelativeLayout
  implements zff
{
  public FacePagerAdapter a;
  public FaceViewPager a;
  public LogoIconListView a;
  public zfi a;
  public zfm a;
  
  public FacePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(super.getContext()).inflate(2131561720, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView = ((LogoIconListView)super.findViewById(2131370403));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setOnItemClickListener(new zey(this));
    this.jdField_a_of_type_Zfm = new zfm(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setAdapter(this.jdField_a_of_type_Zfm);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)super.findViewById(2131366245));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
    this.jdField_a_of_type_Zfm.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
    this.jdField_a_of_type_Zfm.a();
  }
  
  public void setAdapter(zfi paramzfi)
  {
    if (this.jdField_a_of_type_Zfi != null) {
      this.jdField_a_of_type_Zfi.b(this);
    }
    this.jdField_a_of_type_Zfi = paramzfi;
    if (this.jdField_a_of_type_Zfi != null) {
      this.jdField_a_of_type_Zfi.a(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Zfi);
    this.jdField_a_of_type_Zfm.a(this.jdField_a_of_type_Zfi);
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(zew paramzew)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramzew);
  }
  
  public void setOnFaceSelectedListener(zez paramzez)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramzez);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel
 * JD-Core Version:    0.7.0.1
 */