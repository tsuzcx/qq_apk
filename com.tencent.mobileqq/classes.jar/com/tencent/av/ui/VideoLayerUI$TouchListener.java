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
  private float b = 0.0F;
  private float c = 0.0F;
  private long d = 0L;
  private boolean e = false;
  private boolean f = false;
  
  public VideoLayerUI$TouchListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    boolean bool = b(paramGLView, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1) {
      this.a.R = 0L;
    }
    return bool;
  }
  
  boolean b(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    if ((paramGLView != null) && (paramMotionEvent != null) && (this.a.Y != null))
    {
      if (this.a.Z == null) {
        return false;
      }
      if (this.a.Z.k().ah == 1) {
        return true;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        this.b = 0.0F;
        this.c = 0.0F;
        this.d = System.currentTimeMillis();
        this.b = paramMotionEvent.getX();
        this.c = paramMotionEvent.getY();
        if (QLog.isColorLevel())
        {
          localObject = this.a.U;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[childLock] touch onDown: ");
          localStringBuilder.append(this.b);
          localStringBuilder.append(" x ");
          localStringBuilder.append(this.c);
          localStringBuilder.append(" ==========");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
        if (this.a.Z.k().af) {
          this.a.Q.a();
        } else {
          this.a.Q.a(this.b, this.c);
        }
        this.e = false;
        this.f = false;
      }
      if ((!this.a.Z.k().af) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.b) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.c) > 70.0F)))))
      {
        this.a.Y.a().removeCallbacks(this.a.Q);
        if ((this.a.Q != null) && (this.a.Q.d()))
        {
          if (paramMotionEvent.getAction() == 1) {
            this.a.Q.c();
          }
          if (QLog.isColorLevel()) {
            QLog.e(this.a.U, 2, "[childLock] cancel animation");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.a.U, 2, "[childLock] touch end ==========");
        }
      }
      if (this.a.Z.k().af)
      {
        if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.d < 200L) && (this.a.Q != null)) {
          this.a.Q.b();
        }
        return true;
      }
      Object localObject = this.a;
      ((VideoLayerUI)localObject).ah = -1;
      localObject = ((VideoLayerUI)localObject).ae;
      int k = localObject.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (paramGLView == localObject[i])
        {
          this.a.ah = j;
          break;
        }
        j += 1;
        i += 1;
      }
      if ((VideoLayerUI.k(this.a)) && (VideoLayerUI.l(this.a) != null) && (this.a.Z != null) && (VideoLayerUIBase.c(this.a.Z.k())) && (this.a.Z.k().bi != null) && (this.a.Z.k().bi.size() > 0))
      {
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((paramMotionEvent.getAction() == 0) && (VideoLayerUI.m(this.a).contains(i, j)))
        {
          this.a.R = paramMotionEvent.getEventTime();
          this.e = true;
        }
        if (this.e == true) {
          if (VideoLayerUI.m(this.a).contains(i, j))
          {
            VideoLayerUI.l(this.a).onTouchEvent(paramMotionEvent);
            i = paramMotionEvent.getAction();
            if (i != 0)
            {
              if (i == 1) {
                this.a.m();
              }
            }
            else
            {
              paramGLView = this.a;
              VideoLayerUI.d(paramGLView, VideoLayerUI.n(paramGLView).a() ^ true);
              VideoLayerUI.n(this.a).b();
            }
          }
          else if (!this.f)
          {
            paramGLView = MotionEvent.obtain(paramMotionEvent);
            paramGLView.setAction(3);
            VideoLayerUI.l(this.a).onTouchEvent(paramGLView);
            this.f = true;
            this.a.R = paramMotionEvent.getEventTime();
          }
        }
      }
      if ((this.a.ai != null) && (this.a.ai.getVisibility() == 0)) {
        this.a.ah = 0;
      }
      if ((this.a.I != null) && (!this.e)) {
        this.a.I.onTouchEvent(paramMotionEvent);
      }
      if (VideoLayerUIBase.b(this.a.Z.k()))
      {
        paramGLView = SessionMgr.a().b();
        if ((paramGLView != null) && (paramGLView.r())) {
          return true;
        }
        if ((this.a.ah == 1) && (VideoLayerUI.o(this.a) != null))
        {
          if ((!VideoLayerUI.o(this.a).b()) && (paramMotionEvent.getAction() != 0))
          {
            paramGLView = MotionEvent.obtain(paramMotionEvent);
            paramGLView.setAction(0);
            VideoLayerUI.o(this.a).a(paramGLView);
            paramGLView.recycle();
          }
          VideoLayerUI.o(this.a).a(paramMotionEvent);
          this.a.R = paramMotionEvent.getEventTime();
          return true;
        }
      }
      else if ((this.a.ah == 0) && ((this.a.ac == 0) || (this.a.ab == 0)) && (2 == this.a.ae[0].S()) && (VideoLayerUI.p(this.a) != null))
      {
        this.a.R = paramMotionEvent.getEventTime();
        VideoLayerUI.p(this.a).onTouchEvent(paramMotionEvent);
        if ((!VideoLayerUI.p(this.a).isInProgress()) && (VideoLayerUI.o(this.a) != null)) {
          VideoLayerUI.o(this.a).a(paramMotionEvent);
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