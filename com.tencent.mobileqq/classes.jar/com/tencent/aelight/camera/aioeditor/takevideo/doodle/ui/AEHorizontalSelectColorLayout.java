package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

public class AEHorizontalSelectColorLayout
  extends FrameLayout
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEHorizontalSelectColorLayout.ColorListAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  
  public AEHorizontalSelectColorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEHorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558515, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376868));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter = new AEHorizontalSelectColorLayout.ColorListAdapter(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter);
  }
  
  public void a(List<Integer> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter == null)
    {
      AEQLog.d("AEHorizontalSelectColorLayout", "color adapter null.");
      return;
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter, paramBoolean);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter, paramInt);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter, paramList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter.notifyDataSetChanged();
  }
  
  public void setColorSelectListener(AEHorizontalSelectColorLayout.IColorSelectListener paramIColorSelectListener)
  {
    AEHorizontalSelectColorLayout.ColorListAdapter localColorListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter;
    if (localColorListAdapter != null) {
      AEHorizontalSelectColorLayout.ColorListAdapter.a(localColorListAdapter, paramIColorSelectListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */