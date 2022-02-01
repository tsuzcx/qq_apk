package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Rect;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion.LimitMessage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.TakeVideoUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.SystemBarTintManager;

class DoodleLayout$TextFaceLayerTouchListener
  implements BaseLayer.OnLayerTouchListener<BaseLayer>
{
  private Rect b;
  private boolean c = false;
  private boolean d = false;
  
  private DoodleLayout$TextFaceLayerTouchListener(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(BaseLayer paramBaseLayer, MotionEvent paramMotionEvent)
  {
    boolean bool2 = paramBaseLayer instanceof FaceLayer;
    Rect localRect;
    if (bool2)
    {
      localRect = new Rect();
      localRect = ((FaceLayer)paramBaseLayer).a(localRect);
    }
    else
    {
      localRect = null;
    }
    float f1 = 0.0F;
    if (LiuHaiUtils.b()) {
      f1 = LiuHaiUtils.j;
    }
    float f2 = f1;
    if (SystemBarTintManager.hasNavBar(this.a.getContext())) {
      f2 = f1 + SystemBarTintManager.getNavigationBarHeight(this.a.getContext());
    }
    f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    int i = (int)Math.abs(f3 - DoodleLayout.l(this.a));
    int j = paramMotionEvent.getAction() & 0xFF;
    if (j != 0)
    {
      boolean bool1 = true;
      int k;
      int m;
      if (j != 1)
      {
        if ((j != 2) && (j != 5) && (j != 6)) {
          return false;
        }
        if (i > DoodleLayout.i(this.a))
        {
          if ((DoodleLayout.h(this.a)) && (this.a.q.getVisibility() != 0))
          {
            if (DoodleLayout.h(this.a)) {
              TakeVideoUtils.a(this.a.q, false);
            }
            this.b = new Rect();
            this.a.q.getGlobalVisibleRect(this.b);
            this.a.v.getGlobalVisibleRect(this.a.I);
            if (this.a.C == 2)
            {
              DoodleLayout.m(this.a);
            }
            else if (this.a.C == 9)
            {
              if (DoodleLayout.n(this.a).getVisibility() == 0) {
                DoodleLayout.a(this.a, false, true);
              }
              DoodleLayout.k(this.a);
            }
            DoodleLayout.a(this.a, 4);
          }
          if (this.b != null)
          {
            if ((this.a.p != null) && (!this.a.p.b()))
            {
              if ((paramMotionEvent.getPointerCount() == 1) && (this.b.contains((int)f1, (int)f3)) && (DoodleLayout.h(this.a)))
              {
                DoodleLayout.a(this.a, true);
                this.c = true;
              }
              else
              {
                DoodleLayout.a(this.a, false);
                this.c = false;
              }
            }
            else
            {
              i = (int)f1;
              j = this.a.I.left;
              k = (int)f3;
              m = this.a.I.top;
              if ((!this.b.contains(i + j, k + m)) && (!this.a.a(f1, f3, localRect, f2)))
              {
                DoodleLayout.a(this.a, false);
                this.c = false;
              }
              else
              {
                DoodleLayout.a(this.a, true);
                this.c = true;
              }
            }
            this.d = true;
            return false;
          }
        }
      }
      else
      {
        if ((this.b != null) && ((this.a.p == null) || (this.a.p.b())))
        {
          i = (int)f1;
          j = this.a.I.left;
          k = (int)f3;
          m = this.a.I.top;
          if ((DoodleLayout.j(this.a)) && ((this.b.contains(i + j, k + m)) || (this.a.a(f1, f3, localRect, f2))))
          {
            if (bool2)
            {
              SLog.b("DoodleLayout", "remove face.");
              ((FaceLayer)paramBaseLayer).i();
              this.a.a(false, 0.0F, 0, 0, null, false, 0);
              if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "delete face, disable guideline");
              }
            }
            else if ((paramBaseLayer instanceof TextLayer))
            {
              SLog.b("DoodleLayout", "editpic remove text.");
              ((TextLayer)paramBaseLayer).p();
              paramBaseLayer.d(false);
            }
            else if ((paramBaseLayer instanceof TextFaceEditLayer))
            {
              ((TextFaceEditLayer)paramBaseLayer).i();
            }
            DoodleLayout.a(this.a, false);
            this.a.u();
          }
        }
        else if (paramMotionEvent.getPointerCount() == 1)
        {
          paramMotionEvent = this.b;
          if ((paramMotionEvent != null) && (paramMotionEvent.contains((int)f1, (int)f3)) && (this.c))
          {
            if ((paramBaseLayer instanceof TextLayer))
            {
              SLog.b("DoodleLayout", "remove text.");
              ((TextLayer)paramBaseLayer).p();
              paramBaseLayer.d(false);
            }
            else if (bool2)
            {
              SLog.b("DoodleLayout", "remove face.");
              ((FaceLayer)paramBaseLayer).i();
            }
            else if ((paramBaseLayer instanceof TextFaceEditLayer))
            {
              ((TextFaceEditLayer)paramBaseLayer).i();
            }
            DoodleLayout.a(this.a, false);
            this.a.u();
          }
        }
        paramBaseLayer = this.a;
        paramBaseLayer.setViewsInVisible(new View[] { paramBaseLayer.q });
        if (this.a.C == 2)
        {
          DoodleLayout.o(this.a);
          paramBaseLayer = this.a;
          DoodleLayout.a(paramBaseLayer, paramBaseLayer.C);
        }
        else if (this.a.C == 9)
        {
          DoodleLayout.b(this.a);
          paramBaseLayer = this.a;
          DoodleLayout.a(paramBaseLayer, paramBaseLayer.C);
        }
        else if ((this.a.C != 6) && (this.a.C != 11))
        {
          this.a.n();
          DoodleLayout.a(this.a, 0);
        }
        if ((DoodleLayout.p(this.a) == null) && (DoodleLayout.q(this.a) != null)) {
          this.a.a(false, false, false, false);
        } else {
          DoodleLayout.p(this.a).t.a(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.LimitMessage(false, false, false, false, true)));
        }
        if ((!this.a.k) || (!this.d)) {
          bool1 = false;
        }
        DoodleLayout.d(bool1);
        this.d = false;
        return false;
      }
    }
    else
    {
      DoodleLayout.b(this.a, (int)f3);
      this.c = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.TextFaceLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */