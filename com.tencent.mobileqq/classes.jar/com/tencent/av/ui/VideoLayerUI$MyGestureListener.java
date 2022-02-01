package com.tencent.av.ui;

import android.text.TextUtils;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.ui.OnVisiableItemChangeListener;
import com.tencent.av.opengl.ui.ScrollerHelper;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoLayerUI$MyGestureListener
  implements GestureDetector.OnGestureListener
{
  private long jdField_a_of_type_Long = -1L;
  private boolean jdField_a_of_type_Boolean;
  
  private VideoLayerUI$MyGestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    int i = VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI);
    if (i == 0) {
      return false;
    }
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a((int)-paramFloat1, 0, i);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1000L);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    a(true);
    if (VideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) {}
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(Math.round(paramFloat1), 0, VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI));
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1001L);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 100L)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Long = l;
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramMotionEvent.getX()) != -1)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onShowPress");
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    a(false);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1002L);
    if (!VideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
    {
      if (!VideoLayerUI.c(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) {
        return true;
      }
      int j = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramMotionEvent.getX());
      Object localObject2;
      int k;
      Object localObject1;
      int i;
      if (VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
      {
        if (j == -1) {
          return true;
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
        Object localObject3 = ((GLVideoView)localObject2).c();
        k = ((GLVideoView)localObject2).g();
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp with empty UIN");
          return true;
        }
        localObject1 = VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a();
        if (((ArrayList)localObject1).size() > VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((j == VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) - 2) && (i != 0))
        {
          ReportController.b(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
          paramMotionEvent = (AVActivity)this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidContentContext;
          if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().S) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().T)) {
            bool1 = true;
          }
          VideoMsgTools.a(paramMotionEvent, String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().f), bool1, true);
          QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp jumpTo lists");
          return true;
        }
        i = j + 1;
        if (i > ((ArrayList)localObject1).size() - 1)
        {
          QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp ArrayOutOfList");
          return true;
        }
        paramMotionEvent = (VideoMemberInfo)((ArrayList)localObject1).get(i);
        if ((paramMotionEvent != null) && (paramMotionEvent.c())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if ((paramMotionEvent != null) && (((String)localObject3).equalsIgnoreCase(String.valueOf(paramMotionEvent.jdField_a_of_type_Long))) && (paramMotionEvent.b() == k)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (QLog.isColorLevel())
        {
          String str = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSingleTapUp, isVideoIn[");
          localStringBuilder.append(bool1);
          localStringBuilder.append("], isSame[");
          localStringBuilder.append(bool2);
          localStringBuilder.append("], uin[");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("], currentSelect[");
          localStringBuilder.append(paramMotionEvent);
          localStringBuilder.append("], index[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          QLog.i(str, 2, localStringBuilder.toString());
        }
        if ((paramMotionEvent != null) && (!bool2))
        {
          bool2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.b();
          if ((bool2) && (bool1))
          {
            ReportController.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
            localObject3 = ((GLVideoView)localObject2).c();
            i = ((GLVideoView)localObject2).g();
            long l = paramMotionEvent.jdField_a_of_type_Long;
            k = paramMotionEvent.b();
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), localObject3, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
            localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onSingleTapUp mTargetIndex:=");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(";Numberlist:=");
            ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
            QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onSingleTapUp, canSwitchView[");
            ((StringBuilder)localObject2).append(bool2);
            ((StringBuilder)localObject2).append("], isVideoIn[");
            ((StringBuilder)localObject2).append(bool1);
            ((StringBuilder)localObject2).append("]");
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          if (!bool1)
          {
            if (paramMotionEvent.a())
            {
              bool1 = bool3;
              if (paramMotionEvent.a() == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
                bool1 = true;
              }
              if (bool1) {
                TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1051);
              } else {
                TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1052);
              }
              paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("not open camera isSelfUin:=");
              ((StringBuilder)localObject1).append(bool1);
              QLog.d(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1053);
              QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not attend video talking");
            }
            ReportController.b(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
          }
        }
        return true;
      }
      if (j != -1)
      {
        i = j + 1;
        if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (i > 0) && (i < this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
        {
          localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
          paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          if ((localObject2 != null) && (paramMotionEvent != null))
          {
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.b())
            {
              ReportController.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
              localObject1 = ((GLVideoView)localObject2).c();
              j = ((GLVideoView)localObject2).g();
              localObject2 = paramMotionEvent.c();
              k = paramMotionEvent.g();
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(j), localObject2, Integer.valueOf(k) });
            }
            if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null) {
              VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(i);
            }
            paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("condition print onSingleTapUp mTargetIndex:=");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t);
            ((StringBuilder)localObject1).append(",canSwitchView=");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
            QLog.d(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
            return true;
          }
          return true;
        }
        return true;
      }
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onSingleTapUp");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */