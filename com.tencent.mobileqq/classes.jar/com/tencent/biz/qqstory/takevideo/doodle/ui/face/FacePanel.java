package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.AdapterObserver;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LogoIconAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView;
import oiv;

public class FacePanel
  extends RelativeLayout
  implements AdapterObserver
{
  public FacePagerAdapter a;
  public FacePanelBaseAdapter a;
  public LogoIconAdapter a;
  public FaceViewPager a;
  public LogoIconListView a;
  
  public FacePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(super.getContext()).inflate(2130970673, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView = ((LogoIconListView)super.findViewById(2131371559));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setOnItemClickListener(new oiv(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLogoIconAdapter = new LogoIconAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLogoIconAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)super.findViewById(2131369136));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetLogoIconListView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLogoIconAdapter.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLogoIconAdapter.b(paramInt);
  }
  
  public void setAdapter(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.b(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = paramFacePanelBaseAdapter;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLogoIconAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter);
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramFacePackagePageEventListener);
  }
  
  public void setOnFaceSelectedListener(FacePanel.OnFaceSelectedListener paramOnFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramOnFaceSelectedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel
 * JD-Core Version:    0.7.0.1
 */