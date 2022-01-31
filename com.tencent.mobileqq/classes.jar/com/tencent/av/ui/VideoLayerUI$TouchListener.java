package com.tencent.av.ui;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import kcf;

public class VideoLayerUI$TouchListener
  implements GLView.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  private Runnable jdField_a_of_type_JavaLangRunnable = new kcf(this);
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  public VideoLayerUI$TouchListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramGLView == null) || (paramMotionEvent == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController == null)) {
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
                    do
                    {
                      do
                      {
                        return bool1;
                        if (paramMotionEvent.getAction() == 0)
                        {
                          this.jdField_a_of_type_Float = 0.0F;
                          this.b = 0.0F;
                          this.jdField_a_of_type_Long = System.currentTimeMillis();
                          this.jdField_a_of_type_Boolean = false;
                          this.jdField_a_of_type_Float = paramMotionEvent.getX();
                          this.b = paramMotionEvent.getY();
                          if (QLog.isColorLevel()) {
                            QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] touch onDown: " + this.jdField_a_of_type_Float + " x " + this.b + " ==========");
                          }
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
                        }
                        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.b) > 70.0F))))
                        {
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
                          if (this.jdField_a_of_type_Boolean)
                          {
                            if (paramMotionEvent.getAction() == 1)
                            {
                              this.jdField_a_of_type_Boolean = false;
                              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(0) });
                            }
                            if (QLog.isColorLevel()) {
                              QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] cancel animation");
                            }
                          }
                          if (QLog.isColorLevel()) {
                            QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] touch end ==========");
                          }
                        }
                        if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().u) {
                          break;
                        }
                        bool1 = bool2;
                      } while (paramMotionEvent.getAction() != 1);
                      bool1 = bool2;
                    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L);
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(2) });
                    return true;
                    if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0]) {
                      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 0;
                    }
                    for (;;)
                    {
                      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 0;
                      }
                      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector != null) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
                      }
                      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController != null)) {
                        break;
                      }
                      return false;
                      if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 1;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 2;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 3;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = 4;
                      } else {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e = -1;
                      }
                    }
                    if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a())) {
                      break;
                    }
                    bool1 = bool2;
                  } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e != 1);
                  bool1 = bool2;
                } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null);
                if ((!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a()) && (paramMotionEvent.getAction() != 0))
                {
                  paramGLView = MotionEvent.obtain(paramMotionEvent);
                  paramGLView.setAction(0);
                  VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramGLView);
                  paramGLView.recycle();
                }
                VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
                return true;
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e != 0);
              if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c == 0) {
                break;
              }
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b != 0);
            bool1 = bool2;
          } while (2 != this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d());
          bool1 = bool2;
        } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null);
        VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramMotionEvent);
        bool1 = bool2;
      } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).isInProgress());
      bool1 = bool2;
    } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.TouchListener
 * JD-Core Version:    0.7.0.1
 */