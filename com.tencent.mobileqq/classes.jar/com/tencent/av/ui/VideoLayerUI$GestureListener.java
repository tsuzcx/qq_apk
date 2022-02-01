package com.tencent.av.ui;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport.ShortCut_For_Effect;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VideoLayerUI$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  public VideoLayerUI$GestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean onDoubleTap(MotionEvent arg1)
  {
    int i;
    int j;
    if ((this.a.t == 0) && ((this.a.r == 0) || (this.a.q == 0)) && (2 == this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g()) && (!VideoLayerUIBase.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      i = (int)???.getX();
      j = (int)???.getY();
      float f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      ??? = this.a;
      ???.s += 1;
      if (this.a.s % 2 == 1)
      {
        f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b() / f;
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
        return true;
      }
      f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a() / f;
      i = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b() / 2;
      j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c() / 2;
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
      return true;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3))
    {
      Object localObject1;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        ??? = this.a.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=");
        ((StringBuilder)localObject1).append(this.a.t);
        ((StringBuilder)localObject1).append(",visibility:=");
        localObject3 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        if (this.a.t < 0) {
          i = 0;
        } else {
          i = this.a.t;
        }
        ((StringBuilder)localObject1).append(localObject3[i].a());
        QLog.d(???, 2, ((StringBuilder)localObject1).toString());
      }
      if ((VideoLayerUI.c(this.a)) && (this.a.t != -1) && (this.a.t < this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].a() != 1))
      {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 0) {
          return true;
        }
        if (this.a.t != 0)
        {
          long l = Long.parseLong(this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].c());
          j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].g();
          localObject1 = (VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0);
          i = 0;
          while (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
          {
            localObject3 = (VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i);
            if ((l == ((VideoViewInfo)localObject3).jdField_a_of_type_Long) && (j == ((VideoViewInfo)localObject3).jdField_a_of_type_Int))
            {
              ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean = false;
              ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean = true;
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(0, localObject3);
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(i, localObject1);
              synchronized (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
              {
                this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject3);
                this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(i, localObject1);
                this.a.jdField_a_of_type_ComTencentAvVideoController.a().a();
              }
            }
            i += 1;
          }
          ??? = this.a;
          ???.a("onDoubleTap", 0, ???.t);
        }
        else if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) && (!((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean))
        {
          ((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
        ((AVActivity)this.a.jdField_a_of_type_AndroidContentContext).a(4, false);
      }
      return true;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 4))
    {
      if (!VideoLayerUI.c(this.a)) {
        return true;
      }
      ReportController.b(null, "CliOper", "", "", "0X8009F60", "0X8009F60", 0, 0, "", "", "", "");
      ((AVActivity)this.a.jdField_a_of_type_AndroidContentContext).a(3, false);
    }
    return super.onDoubleTap(???);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      boolean bool4;
      if (this.a.jdField_a_of_type_Long > paramMotionEvent2.getDownTime()) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      Object localObject2;
      if (bool4)
      {
        localObject1 = this.a.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onFling, lastHandledEventTime[");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append("], e1[");
        ((StringBuilder)localObject2).append(paramMotionEvent1);
        ((StringBuilder)localObject2).append("], e2[");
        ((StringBuilder)localObject2).append(paramMotionEvent2);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      Object localObject1 = SessionMgr.a().a();
      if ((localObject1 != null) && (((SessionInfo)localObject1).r())) {
        return true;
      }
      localObject1 = this.a.a();
      if ((localObject1 != null) && (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a() != null) && (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null))
      {
        boolean bool9 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
        boolean bool1 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a() ^ true;
        localObject2 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvVideoController.a();
        int i;
        if (((SessionInfo)localObject2).jdField_d_of_type_Int == 4) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool2 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoMeetingCtrlUI;
        int j;
        if ((!this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b) && (!this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b)) {
          j = 0;
        } else {
          j = 1;
        }
        if ((i != 0) && (bool2) && (j != 0)) {
          i = 1;
        } else {
          i = 0;
        }
        bool2 = ((SessionInfo)localObject2).d();
        if ((!((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2)) && (i == 0) && ((bool2 ^ true))) {
          i = 1;
        } else {
          i = 0;
        }
        long l = AudioHelper.b();
        float f1 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
        float f2 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
        boolean bool3;
        boolean bool5;
        boolean bool6;
        if (f1 < f2)
        {
          if (paramMotionEvent1.getY() - paramMotionEvent2.getY() >= this.a.o) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          if (paramMotionEvent2.getY() - paramMotionEvent1.getY() >= this.a.o) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          bool5 = false;
          bool6 = false;
        }
        else
        {
          if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= this.a.o) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          if (paramMotionEvent2.getX() - paramMotionEvent1.getX() >= this.a.o) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          boolean bool7 = false;
          boolean bool8 = false;
          bool6 = bool2;
          bool5 = bool3;
          bool2 = bool8;
          bool3 = bool7;
        }
        localObject2 = this.a.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFling, e1[");
        localStringBuilder.append(paramMotionEvent1);
        localStringBuilder.append("], e2[");
        localStringBuilder.append(paramMotionEvent2);
        localStringBuilder.append("], velocityX[");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append("], velocityY[");
        localStringBuilder.append(paramFloat2);
        localStringBuilder.append("], xOffset[");
        localStringBuilder.append(f1);
        localStringBuilder.append("], yOffset[");
        localStringBuilder.append(f2);
        localStringBuilder.append("], up[");
        localStringBuilder.append(bool2);
        localStringBuilder.append("], down[");
        localStringBuilder.append(bool3);
        localStringBuilder.append("], left[");
        localStringBuilder.append(bool6);
        localStringBuilder.append("], right[");
        localStringBuilder.append(bool5);
        localStringBuilder.append("], handle[");
        localStringBuilder.append(bool4);
        localStringBuilder.append("], lastHandledEventTime[");
        localStringBuilder.append(this.a.jdField_a_of_type_Long);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
        if ((!bool9) && ((bool2) || (bool3))) {
          return false;
        }
        if ((bool2) && (bool1)) {
          if ((((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(0)) && (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l)))
          {
            DataReport.ShortCut_For_Effect.a(true);
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, (Context)localObject1, 0, 0);
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, -1);
            return true;
          }
        }
        for (;;)
        {
          return false;
          if ((bool3) && (bool1))
          {
            if (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2))
            {
              DataReport.ShortCut_For_Effect.a(false);
              ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, true);
              return true;
            }
          }
          else if ((bool5) && (i != 0))
          {
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(1);
            ChatRoomUtil.a("0X800A8D2");
          }
          else if ((bool6) && (i != 0))
          {
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, false);
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, (Context)localObject1, 0, 1);
            ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(2);
            if (!bool9) {
              ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
            }
            ChatRoomUtil.a("0X800A8D1");
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
        return false;
      }
      try
      {
        long l = AudioHelper.b();
        boolean bool1 = this.a.i();
        boolean bool2 = this.a.h();
        if (QLog.isColorLevel())
        {
          paramMotionEvent = this.a.jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSingleTapConfirmed, mTargetIndex[");
          ((StringBuilder)localObject1).append(this.a.t);
          ((StringBuilder)localObject1).append("], isDoubleScreen[");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append("], canMove[");
          ((StringBuilder)localObject1).append(bool2);
          ((StringBuilder)localObject1).append("], seq[");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append("]");
          QLog.w(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
        }
        paramMotionEvent = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((!VideoLayerUI.b(this.a)) && (this.a.t > 0) && (!bool1))
        {
          if (paramMotionEvent.jdField_d_of_type_Int == 2)
          {
            bool1 = paramMotionEvent.r();
            if ((this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.b()) && (!bool1))
            {
              this.a.a(0, this.a.t);
              return true;
            }
            if (bool1)
            {
              this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
              return true;
            }
          }
          else if (bool2)
          {
            if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) || (this.a.t <= 0)) {
              break label621;
            }
            if (this.a.t >= this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
              return true;
            }
            if (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.b())
            {
              localObject2 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
              paramMotionEvent = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t];
              if (localObject2 == null) {
                break label619;
              }
              if (paramMotionEvent == null) {
                return true;
              }
              localObject1 = ((GLVideoView)localObject2).c();
              int i = ((GLVideoView)localObject2).g();
              localObject2 = paramMotionEvent.c();
              int j = paramMotionEvent.g();
              this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(j) });
              return true;
            }
            if (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3)
            {
              this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
              return true;
            }
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
            return true;
          }
        }
        else {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
        }
        return true;
      }
      catch (Exception paramMotionEvent)
      {
        Object localObject1;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = this.a.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onSingleTapConfirmed --> Exception = ");
          ((StringBuilder)localObject2).append(paramMotionEvent);
          QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
    }
    else
    {
      return false;
    }
    label619:
    return true;
    label621:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.GestureListener
 * JD-Core Version:    0.7.0.1
 */