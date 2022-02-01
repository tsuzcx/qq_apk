package com.tencent.av.smallscreen;

import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoLayerUI$MoveListener
  implements MoveGestureDetector.OnMoveGestureListener
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public void a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMoveEnd");
    }
    PointF localPointF = paramMoveGestureDetector.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t == 0) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a[0].a(i, j, true);
    }
    while ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t != 1) || ((SmallScreenVideoLayerUI.e(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0) && (SmallScreenVideoLayerUI.f(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.d(i, j);
    this.c = ((int)paramMoveGestureDetector.a());
    this.d = ((int)paramMoveGestureDetector.b());
    SmallScreenVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d));
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.o(SmallScreenVideoLayerUI.g(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI));
  }
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.a();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t == 0) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a[0].a(i, j, false);
    }
    while ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t != 1) || ((SmallScreenVideoLayerUI.c(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0) && (SmallScreenVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0))) {
      return true;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.d(i, j);
    return true;
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMoveBegin");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.a();
      i = (int)paramMoveGestureDetector.x;
      j = (int)paramMoveGestureDetector.y;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a[0].a(i, j, false);
    }
    while ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.t != 1) || ((SmallScreenVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0) && (SmallScreenVideoLayerUI.b(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI) != 0)))
    {
      int i;
      int j;
      return true;
    }
    this.jdField_a_of_type_Int = ((int)paramMoveGestureDetector.a());
    this.b = ((int)paramMoveGestureDetector.b());
    this.e = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.i();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI.MoveListener
 * JD-Core Version:    0.7.0.1
 */