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
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
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
      f1 = LiuHaiUtils.e;
    }
    float f2 = f1;
    if (SystemBarTintManager.hasNavBar(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.getContext())) {
      f2 = f1 + SystemBarTintManager.getNavigationBarHeight(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.getContext());
    }
    f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    int i = (int)Math.abs(f3 - DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout));
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
        if (i > DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout))
        {
          if ((DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
          {
            if (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) {
              TakeVideoUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
            }
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 2)
            {
              DoodleLayout.f(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
            }
            else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 9)
            {
              if (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout).getVisibility() == 0) {
                DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false, true);
              }
              DoodleLayout.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
            }
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 4);
          }
          if (this.jdField_a_of_type_AndroidGraphicsRect != null)
          {
            if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a()))
            {
              if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f3)) && (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)))
              {
                DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true);
                this.jdField_a_of_type_Boolean = true;
              }
              else
              {
                DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              i = (int)f1;
              j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
              k = (int)f3;
              m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
              if ((!this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(f1, f3, localRect, f2)))
              {
                DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
                this.jdField_a_of_type_Boolean = false;
              }
              else
              {
                DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true);
                this.jdField_a_of_type_Boolean = true;
              }
            }
            this.b = true;
            return false;
          }
        }
      }
      else
      {
        if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams == null) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())))
        {
          i = (int)f1;
          j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          k = (int)f3;
          m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          if ((DoodleLayout.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(f1, f3, localRect, f2))))
          {
            if (bool2)
            {
              SLog.b("DoodleLayout", "remove face.");
              ((FaceLayer)paramBaseLayer).x_();
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(false, 0.0F, 0, 0, null, false, 0);
              if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "delete face, disable guideline");
              }
            }
            else if ((paramBaseLayer instanceof TextLayer))
            {
              SLog.b("DoodleLayout", "editpic remove text.");
              ((TextLayer)paramBaseLayer).i();
              paramBaseLayer.d(false);
            }
            else if ((paramBaseLayer instanceof TextFaceEditLayer))
            {
              ((TextFaceEditLayer)paramBaseLayer).d();
            }
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.q();
          }
        }
        else if (paramMotionEvent.getPointerCount() == 1)
        {
          paramMotionEvent = this.jdField_a_of_type_AndroidGraphicsRect;
          if ((paramMotionEvent != null) && (paramMotionEvent.contains((int)f1, (int)f3)) && (this.jdField_a_of_type_Boolean))
          {
            if ((paramBaseLayer instanceof TextLayer))
            {
              SLog.b("DoodleLayout", "remove text.");
              ((TextLayer)paramBaseLayer).i();
              paramBaseLayer.d(false);
            }
            else if (bool2)
            {
              SLog.b("DoodleLayout", "remove face.");
              ((FaceLayer)paramBaseLayer).x_();
            }
            else if ((paramBaseLayer instanceof TextFaceEditLayer))
            {
              ((TextFaceEditLayer)paramBaseLayer).d();
            }
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.q();
          }
        }
        paramBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
        paramBaseLayer.a(new View[] { paramBaseLayer.jdField_a_of_type_AndroidWidgetRelativeLayout });
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 2)
        {
          DoodleLayout.g(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
          paramBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
          DoodleLayout.a(paramBaseLayer, paramBaseLayer.h);
        }
        else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 9)
        {
          DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
          paramBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
          DoodleLayout.a(paramBaseLayer, paramBaseLayer.h);
        }
        else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h != 6) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h != 11))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.m();
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 0);
        }
        if ((DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout) == null) && (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout) != null)) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(false, false, false, false);
        } else {
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout).a.a(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.LimitMessage(false, false, false, false, true)));
        }
        if ((!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.b) || (!this.b)) {
          bool1 = false;
        }
        DoodleLayout.d(bool1);
        this.b = false;
        return false;
      }
    }
    else
    {
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, (int)f3);
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.TextFaceLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */