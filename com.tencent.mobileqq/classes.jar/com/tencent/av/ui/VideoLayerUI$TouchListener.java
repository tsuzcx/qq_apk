package com.tencent.av.ui;

import android.graphics.Rect;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.ScrollerHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VideoLayerUI$TouchListener
  implements GLView.OnTouchListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = false;
  
  public VideoLayerUI$TouchListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    boolean bool = b(paramGLView, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = 0L;
    }
    return bool;
  }
  
  boolean b(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    if ((paramGLView != null) && (paramMotionEvent != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController == null) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().v == 1) {
        return true;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[childLock] touch onDown: ");
          localStringBuilder.append(this.jdField_a_of_type_Float);
          localStringBuilder.append(" x ");
          localStringBuilder.append(this.jdField_b_of_type_Float);
          localStringBuilder.append(" ==========");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().w) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a();
        } else {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
      }
      if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().w) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float) > 70.0F)))))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger);
        if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a()))
        {
          if (paramMotionEvent.getAction() == 1) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.c();
          }
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] cancel animation");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] touch end ==========");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().w)
      {
        if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 200L) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null)) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.b();
        }
        return true;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      ((VideoLayerUI)localObject).t = -1;
      localObject = ((VideoLayerUI)localObject).jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      int k = localObject.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (paramGLView == localObject[i])
        {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = j;
          break;
        }
        j += 1;
        i += 1;
      }
      if ((VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController != null) && (VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a())) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().c != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0))
      {
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((paramMotionEvent.getAction() == 0) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).contains(i, j)))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
          this.jdField_a_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_Boolean == true) {
          if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).contains(i, j))
          {
            VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramMotionEvent);
            i = paramMotionEvent.getAction();
            if (i != 0)
            {
              if (i == 1) {
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
              }
            }
            else
            {
              paramGLView = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
              VideoLayerUI.c(paramGLView, VideoLayerUI.a(paramGLView).a() ^ true);
              VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a();
            }
          }
          else if (!this.jdField_b_of_type_Boolean)
          {
            paramGLView = MotionEvent.obtain(paramMotionEvent);
            paramGLView.setAction(3);
            VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramGLView);
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = 0;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector != null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      if (VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a()))
      {
        paramGLView = SessionMgr.a().a();
        if ((paramGLView != null) && (paramGLView.r())) {
          return true;
        }
        if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 1) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null))
        {
          if ((!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a()) && (paramMotionEvent.getAction() != 0))
          {
            paramGLView = MotionEvent.obtain(paramMotionEvent);
            paramGLView.setAction(0);
            VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramGLView);
            paramGLView.recycle();
          }
          VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
          return true;
        }
      }
      else if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t == 0) && ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0)) && (2 == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g()) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
        VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramMotionEvent);
        if ((!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).isInProgress()) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null)) {
          VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.TouchListener
 * JD-Core Version:    0.7.0.1
 */