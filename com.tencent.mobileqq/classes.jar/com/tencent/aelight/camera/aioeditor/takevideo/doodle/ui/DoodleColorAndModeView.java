package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class DoodleColorAndModeView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private DoodleColorAndModeView.ColorListAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorListAdapter;
  private DoodleColorAndModeView.IColorSelectListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$IColorSelectListener;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private final List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  
  public DoodleColorAndModeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DoodleColorAndModeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DoodleColorAndModeView);
      this.jdField_a_of_type_Int = paramContext.getInt(2, 0);
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(0, false);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramContext.getBoolean(1, false));
      paramContext.recycle();
    }
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Int += 1;
    }
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_b_of_type_Int += 1;
    }
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558515, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376868));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorListAdapter = new DoodleColorAndModeView.ColorListAdapter(this, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorListAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new DoodleColorAndModeView.1(this));
  }
  
  public void a(List<Integer> paramList, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorListAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean == paramBoolean)
    {
      this.jdField_c_of_type_Boolean = (paramBoolean ^ true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorListAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean ^ true;
  }
  
  public void setColorSelectListener(DoodleColorAndModeView.IColorSelectListener paramIColorSelectListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$IColorSelectListener = paramIColorSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
 * JD-Core Version:    0.7.0.1
 */