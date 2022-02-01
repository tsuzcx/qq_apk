package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;

public abstract class BaseFaceListAdapter<PACKAGE extends FacePackage>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected PACKAGE a;
  protected FacePanel.OnFaceSelectedListener a;
  
  public BaseFaceListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramPACKAGE;
  }
  
  public void a(FacePanel.OnFaceSelectedListener paramOnFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener = paramOnFaceSelectedListener;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return 0;
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.b();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter
 * JD-Core Version:    0.7.0.1
 */