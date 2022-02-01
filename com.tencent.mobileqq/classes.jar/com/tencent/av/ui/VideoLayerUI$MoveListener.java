package com.tencent.av.ui;

import android.graphics.PointF;
import com.tencent.av.business.manager.zimu.ARZimuTask;
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
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
    }
    for (;;)
    {
      ARZimuTask.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
        this.c = ((int)paramMoveGestureDetector.a());
        this.d = ((int)paramMoveGestureDetector.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w);
      }
    }
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
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
          VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
      }
    }
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
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onMoveBegin, mTargetIndex[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t + "], startX[" + this.jdField_a_of_type_Int + "], startY[" + this.b + "], startPosition[" + this.e + "], mTopOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + "], mBottomOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r + "], mRecordCtrlBottom[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k + "]");
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
      }
      ARZimuTask.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_Int = ((int)paramMoveGestureDetector.a());
        this.b = ((int)paramMoveGestureDetector.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MoveListener
 * JD-Core Version:    0.7.0.1
 */