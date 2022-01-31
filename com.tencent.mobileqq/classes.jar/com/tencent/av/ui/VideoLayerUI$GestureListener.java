package com.tencent.av.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class VideoLayerUI$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  public VideoLayerUI$GestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a.e == 0) && ((this.a.c == 0) || (this.a.b == 0)) && (2 == this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d()))
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      float f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      paramMotionEvent = this.a;
      paramMotionEvent.d += 1;
      if (this.a.d % 2 == 1)
      {
        f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b() / f;
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
        return true;
      }
      f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a() / f;
      i = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g() / 2;
      j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h() / 2;
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    try
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "GestureListener-->mTargetIndex=" + this.a.e);
                      }
                      if ((this.a.e > 0) && (!this.a.d()) && ((this.a.c == 0) || (this.a.b == 0) || (this.a.b == this.a.jdField_a_of_type_Int) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 2))) {
                        break;
                      }
                      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110) });
                      return true;
                    }
                    catch (Exception paramMotionEvent)
                    {
                      bool1 = bool2;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onSingleTapConfirmed --> Exception = " + paramMotionEvent);
                  return true;
                  if ((this.a.c == 0) || (this.a.b == 0) || (this.a.b == this.a.jdField_a_of_type_Int)) {
                    break;
                  }
                  bool1 = bool2;
                } while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2);
                if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) {
                  break;
                }
                bool1 = bool2;
              } while (!this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a());
              this.a.a(0, this.a.e);
              return true;
              bool1 = bool2;
            } while (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null);
            bool1 = bool2;
          } while (this.a.e <= 0);
          bool1 = bool2;
        } while (this.a.e >= this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length);
        localObject = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
        paramMotionEvent = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.e];
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (paramMotionEvent == null);
    String str = ((GLVideoView)localObject).a();
    int i = Integer.valueOf(((GLVideoView)localObject).d()).intValue();
    Object localObject = paramMotionEvent.a();
    int j = Integer.valueOf(paramMotionEvent.d()).intValue();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), localObject, Integer.valueOf(j) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.GestureListener
 * JD-Core Version:    0.7.0.1
 */