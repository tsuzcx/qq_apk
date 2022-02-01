package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager;

public class DoodleSelectModeView
  extends FrameLayout
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2131363997 }, { 2131364044 } };
  private static final int[][] b;
  private int jdField_a_of_type_Int;
  private DoodleSelectModeView.ISelectModeListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleSelectModeView$ISelectModeListener;
  
  static
  {
    int[] arrayOfInt1 = { 2131363879 };
    int[] arrayOfInt2 = { 2131363968 };
    b = new int[][] { { 2131364071 }, arrayOfInt1, { 2131363857 }, arrayOfInt2 };
  }
  
  public DoodleSelectModeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    LayoutInflater.from(getContext()).inflate(2131558519, this);
    if (this.jdField_a_of_type_Int == 1) {
      paramContext = b;
    } else {
      paramContext = jdField_a_of_type_Array2dOfInt;
    }
    new EditButtonManager(this, paramContext).a(new DoodleSelectModeView.1(this));
  }
  
  public void setSelectModeListener(DoodleSelectModeView.ISelectModeListener paramISelectModeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleSelectModeView$ISelectModeListener = paramISelectModeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView
 * JD-Core Version:    0.7.0.1
 */