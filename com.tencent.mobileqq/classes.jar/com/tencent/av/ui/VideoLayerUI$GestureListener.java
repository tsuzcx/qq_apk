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
import com.tencent.av.utils.DataReport.ShortCut_For_Effect;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
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
      }
      for (;;)
      {
        return true;
        f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a() / f;
        i = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b() / 2;
        j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c() / 2;
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3))
    {
      Object localObject1;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        ??? = this.a.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder().append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=").append(this.a.t).append(",visibility:=");
        localObject3 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        if (this.a.t >= 0) {
          break label420;
        }
      }
      label420:
      for (i = 0;; i = this.a.t)
      {
        QLog.d(???, 2, localObject3[i].a());
        if ((VideoLayerUI.c(this.a)) && (this.a.t != -1) && (this.a.t < this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].a() != 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)) {
          break;
        }
        return true;
      }
      if (this.a.t != 0)
      {
        long l = Long.parseLong(this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].c());
        j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t].g();
        localObject1 = (VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0);
        i = 0;
        if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
        {
          localObject3 = (VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i);
          if ((l != ((VideoViewInfo)localObject3).jdField_a_of_type_Long) || (j != ((VideoViewInfo)localObject3).jdField_a_of_type_Int)) {
            break label759;
          }
          ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean = false;
          ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean = true;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(0, localObject3);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.set(i, localObject1);
        }
      }
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject3);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(i, localObject1);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().c();
          this.a.a("onDoubleTap", 0, this.a.t);
          ReportController.b(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
          ((AVActivity)this.a.jdField_a_of_type_AndroidContentContext).a(4, false);
          return true;
        }
        label759:
        i += 1;
        break;
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) && (!((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean))
        {
          ((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
          }
        }
      }
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
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    if (this.a.jdField_a_of_type_Long > paramMotionEvent2.getDownTime()) {}
    for (boolean bool3 = true; bool3; bool3 = false)
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onFling, lastHandledEventTime[" + this.a.jdField_a_of_type_Long + "], e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "]");
      return false;
    }
    Object localObject = SessionMgr.a().a();
    if ((localObject != null) && (((SessionInfo)localObject).A())) {
      return true;
    }
    localObject = this.a.a();
    if ((localObject == null) || (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a() == null) || (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller == null)) {
      return false;
    }
    boolean bool8 = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
    int i;
    int j;
    label232:
    boolean bool1;
    int k;
    label275:
    label293:
    label304:
    label332:
    long l;
    float f1;
    float f2;
    if (!((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a())
    {
      i = 1;
      SessionInfo localSessionInfo = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo.jdField_d_of_type_Int != 4) {
        break label636;
      }
      j = 1;
      bool1 = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoMeetingCtrlUI;
      if ((!this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b) && (!this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b)) {
        break label642;
      }
      k = 1;
      if ((j == 0) || (!bool1) || (k == 0)) {
        break label648;
      }
      j = 1;
      if (localSessionInfo.d()) {
        break label654;
      }
      k = 1;
      if ((((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2)) || (j != 0) || (k == 0)) {
        break label660;
      }
      j = 1;
      l = AudioHelper.b();
      f1 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
      f2 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
      if (f1 >= f2) {
        break label678;
      }
      if (paramMotionEvent1.getY() - paramMotionEvent2.getY() < this.a.o) {
        break label666;
      }
      bool1 = true;
      label397:
      if (paramMotionEvent2.getY() - paramMotionEvent1.getY() < this.a.o) {
        break label672;
      }
    }
    boolean bool5;
    boolean bool4;
    label642:
    label648:
    label654:
    label660:
    label666:
    label672:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool6 = false;
      boolean bool7 = false;
      bool5 = bool1;
      bool4 = bool2;
      bool2 = bool6;
      bool1 = bool7;
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onFling, e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "], velocityX[" + paramFloat1 + "], velocityY[" + paramFloat2 + "], xOffset[" + f1 + "], yOffset[" + f2 + "], up[" + bool5 + "], down[" + bool4 + "], left[" + bool1 + "], right[" + bool2 + "], handle[" + bool3 + "], lastHandledEventTime[" + this.a.jdField_a_of_type_Long + "], seq[" + l + "]");
      if ((bool8) || ((!bool5) && (!bool4))) {
        break label747;
      }
      return false;
      i = 0;
      break;
      label636:
      j = 0;
      break label232;
      k = 0;
      break label275;
      j = 0;
      break label293;
      k = 0;
      break label304;
      j = 0;
      break label332;
      bool1 = false;
      break label397;
    }
    label678:
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= this.a.o)
    {
      bool1 = true;
      label702:
      if (paramMotionEvent2.getX() - paramMotionEvent1.getX() < this.a.o) {
        break label741;
      }
    }
    label741:
    for (bool2 = true;; bool2 = false)
    {
      bool4 = false;
      bool5 = false;
      break;
      bool1 = false;
      break label702;
    }
    label747:
    if ((bool5) && (i != 0))
    {
      if ((((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(0)) && (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l)))
      {
        DataReport.ShortCut_For_Effect.a(true);
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, (Context)localObject, 0, 0);
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, -1);
        return true;
      }
    }
    else if ((bool4) && (i != 0))
    {
      if (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().b(2))
      {
        DataReport.ShortCut_For_Effect.a(false);
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, true);
        return true;
      }
    }
    else
    {
      if ((!bool2) || (j == 0)) {
        break label892;
      }
      ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(1);
      ChatRoomUtil.a("0X800A8D2");
    }
    for (;;)
    {
      return false;
      label892:
      if ((bool1) && (j != 0))
      {
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(l, 0, false);
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, (Context)localObject, 0, 1);
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(2);
        if (!bool8) {
          ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
        }
        ChatRoomUtil.a("0X800A8D1");
      }
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      bool1 = false;
    }
    long l;
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
                boolean bool3;
                do
                {
                  do
                  {
                    return bool1;
                    try
                    {
                      l = AudioHelper.b();
                      bool1 = this.a.i();
                      bool3 = this.a.h();
                      if (QLog.isColorLevel()) {
                        QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onSingleTapConfirmed, mTargetIndex[" + this.a.t + "], isDoubleScreen[" + bool1 + "], canMove[" + bool3 + "], seq[" + l + "]");
                      }
                      paramMotionEvent = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
                      if ((!VideoLayerUI.b(this.a)) && (this.a.t > 0) && (!bool1)) {
                        break;
                      }
                      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
                      return true;
                    }
                    catch (Exception paramMotionEvent)
                    {
                      bool1 = bool2;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e(this.a.jdField_a_of_type_JavaLangString, 2, "onSingleTapConfirmed --> Exception = " + paramMotionEvent);
                  return true;
                  if (paramMotionEvent.jdField_d_of_type_Int != 2) {
                    break;
                  }
                  bool3 = paramMotionEvent.A();
                  if ((this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.b()) && (!bool3))
                  {
                    this.a.a(0, this.a.t);
                    return true;
                  }
                  bool1 = bool2;
                } while (!bool3);
                this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
                return true;
                if (!bool3) {
                  break;
                }
                bool1 = bool2;
              } while (this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null);
              bool1 = bool2;
            } while (this.a.t <= 0);
            bool1 = bool2;
          } while (this.a.t >= this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length);
          if (!this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.b()) {
            break;
          }
          localObject = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
          paramMotionEvent = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.t];
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (paramMotionEvent == null);
      String str = ((GLVideoView)localObject).c();
      int i = ((GLVideoView)localObject).g();
      Object localObject = paramMotionEvent.c();
      int j = paramMotionEvent.g();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), localObject, Integer.valueOf(j) });
      return true;
      bool1 = bool2;
    } while (this.a.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 3);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
    return true;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.GestureListener
 * JD-Core Version:    0.7.0.1
 */