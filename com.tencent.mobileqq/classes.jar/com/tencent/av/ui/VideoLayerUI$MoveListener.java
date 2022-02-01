package com.tencent.av.ui;

import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$MoveListener
  implements MoveGestureDetector.OnMoveGestureListener
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  
  private VideoLayerUI$MoveListener(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 2) {
      return;
    }
    PointF localPointF = paramMoveGestureDetector.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
    }
    else if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
      this.c = ((int)paramMoveGestureDetector.a());
      this.d = ((int)paramMoveGestureDetector.b());
      paramMoveGestureDetector = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      paramMoveGestureDetector.w = paramMoveGestureDetector.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
      paramMoveGestureDetector = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      paramMoveGestureDetector.o(paramMoveGestureDetector.w);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
  }
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.a();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
    {
      if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
        VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
    }
    return true;
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.a();
      int i = (int)paramMoveGestureDetector.x;
      int j = (int)paramMoveGestureDetector.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    else if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
    {
      this.jdField_a_of_type_Int = ((int)paramMoveGestureDetector.a());
      this.b = ((int)paramMoveGestureDetector.b());
      this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
    }
    if (QLog.isColorLevel())
    {
      paramMoveGestureDetector = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMoveBegin, mTargetIndex[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t);
      localStringBuilder.append("], startX[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], startY[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], startPosition[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("], mTopOffset[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q);
      localStringBuilder.append("], mBottomOffset[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r);
      localStringBuilder.append("], mRecordCtrlBottom[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k);
      localStringBuilder.append("]");
      QLog.w(paramMoveGestureDetector, 1, localStringBuilder.toString());
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MoveListener
 * JD-Core Version:    0.7.0.1
 */