package com.tencent.av.ui;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
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
    if ((this.a.ah == 0) && ((this.a.ac == 0) || (this.a.ab == 0)) && (2 == this.a.ae[0].S()) && (!VideoLayerUIBase.c(this.a.Z.k())))
    {
      i = (int)???.getX();
      j = (int)???.getY();
      float f = this.a.ae[0].G();
      ??? = this.a;
      ???.ag += 1;
      if (this.a.ag % 2 == 1)
      {
        f = this.a.ae[0].F() / f;
        this.a.ae[0].a(f, i, j);
        return true;
      }
      f = this.a.ae[0].E() / f;
      i = this.a.ae[0].g() / 2;
      j = this.a.ae[0].h() / 2;
      this.a.ae[0].a(f, i, j);
      this.a.ae[0].a(i, j, true);
      return true;
    }
    if ((this.a.aj != null) && (this.a.aj.b() == 3))
    {
      Object localObject1;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        ??? = this.a.U;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=");
        ((StringBuilder)localObject1).append(this.a.ah);
        ((StringBuilder)localObject1).append(",visibility:=");
        localObject3 = this.a.ae;
        if (this.a.ah < 0) {
          i = 0;
        } else {
          i = this.a.ah;
        }
        ((StringBuilder)localObject1).append(localObject3[i].b());
        QLog.d(???, 2, ((StringBuilder)localObject1).toString());
      }
      if ((VideoLayerUI.q(this.a)) && (this.a.ah != -1) && (this.a.ah < this.a.ae.length) && (this.a.ae[this.a.ah].b() != 1))
      {
        if (this.a.Z.k().bi.size() <= 0) {
          return true;
        }
        if (this.a.ah != 0)
        {
          long l = Long.parseLong(this.a.ae[this.a.ah].R());
          j = this.a.ae[this.a.ah].S();
          localObject1 = (VideoViewInfo)this.a.Z.k().bi.get(0);
          i = 0;
          while (i < this.a.Z.k().bi.size())
          {
            localObject3 = (VideoViewInfo)this.a.Z.k().bi.get(i);
            if ((l == ((VideoViewInfo)localObject3).a) && (j == ((VideoViewInfo)localObject3).b))
            {
              ((VideoViewInfo)localObject1).c = false;
              ((VideoViewInfo)localObject3).c = true;
              this.a.Z.k().bi.set(0, localObject3);
              this.a.Z.k().bi.set(i, localObject1);
              synchronized (this.a.Z.k().bk)
              {
                this.a.Z.k().bk.set(0, localObject3);
                this.a.Z.k().bk.set(i, localObject1);
                this.a.Z.k().C();
              }
            }
            i += 1;
          }
          ??? = this.a;
          ???.a("onDoubleTap", 0, ???.ah);
        }
        else if ((this.a.Z.k().bi.size() > 0) && (!((VideoViewInfo)this.a.Z.k().bi.get(0)).c))
        {
          ((VideoViewInfo)this.a.Z.k().bi.get(0)).c = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.a.U, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
        ((AVActivity)this.a.X).a(4, false);
      }
      return true;
    }
    if ((this.a.aj != null) && (this.a.aj.b() == 4))
    {
      if (!VideoLayerUI.q(this.a)) {
        return true;
      }
      ReportController.b(null, "CliOper", "", "", "0X8009F60", "0X8009F60", 0, 0, "", "", "", "");
      ((AVActivity)this.a.X).a(3, false);
    }
    return super.onDoubleTap(???);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.Y != null) && (this.a.Z != null) && (paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      boolean bool4;
      if (this.a.R > paramMotionEvent2.getDownTime()) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      Object localObject2;
      if (bool4)
      {
        localObject1 = this.a.U;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onFling, lastHandledEventTime[");
        ((StringBuilder)localObject2).append(this.a.R);
        ((StringBuilder)localObject2).append("], e1[");
        ((StringBuilder)localObject2).append(paramMotionEvent1);
        ((StringBuilder)localObject2).append("], e2[");
        ((StringBuilder)localObject2).append(paramMotionEvent2);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      Object localObject1 = SessionMgr.a().b();
      if ((localObject1 != null) && (((SessionInfo)localObject1).r())) {
        return true;
      }
      localObject1 = this.a.P();
      if ((localObject1 != null) && (((AVActivity)localObject1).K != null) && (((AVActivity)localObject1).K.al() != null) && (((AVActivity)localObject1).ai != null))
      {
        int j;
        if (QavEffectUIABTestUtils.b(this.a.Y.getCurrentAccountUin())) {
          j = 5;
        } else {
          j = 2;
        }
        boolean bool9 = ((AVActivity)localObject1).K.ab();
        boolean bool1 = ((AVActivity)localObject1).ai.b() ^ true;
        localObject2 = ((AVActivity)localObject1).I.k();
        int i;
        if (((SessionInfo)localObject2).g == 4) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool2 = ((AVActivity)localObject1).K instanceof DoubleVideoMeetingCtrlUI;
        int k;
        if ((!this.a.ae[0].N) && (!this.a.ae[1].N)) {
          k = 0;
        } else {
          k = 1;
        }
        if ((i != 0) && (bool2) && (k != 0)) {
          i = 1;
        } else {
          i = 0;
        }
        bool2 = ((SessionInfo)localObject2).d();
        if ((!((AVActivity)localObject1).K.al().i(j)) && (i == 0) && ((bool2 ^ true))) {
          i = 1;
        } else {
          i = 0;
        }
        long l = AudioHelper.c();
        float f1 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
        float f2 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
        boolean bool3;
        boolean bool5;
        boolean bool6;
        if (f1 < f2)
        {
          if (paramMotionEvent1.getY() - paramMotionEvent2.getY() >= this.a.O) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          if (paramMotionEvent2.getY() - paramMotionEvent1.getY() >= this.a.O) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          bool5 = false;
          bool6 = false;
        }
        else
        {
          if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= this.a.O) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          if (paramMotionEvent2.getX() - paramMotionEvent1.getX() >= this.a.O) {
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
        localObject2 = this.a.U;
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
        localStringBuilder.append(this.a.R);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
        if ((!bool9) && ((bool2) || (bool3))) {
          return false;
        }
        if ((bool2) && (bool1)) {
          if ((((AVActivity)localObject1).K.al().i(0)) && (((AVActivity)localObject1).K.o(l)))
          {
            DataReport.ShortCut_For_Effect.a(true);
            ((AVActivity)localObject1).ab.a(l, (Context)localObject1, 0, 0);
            ((AVActivity)localObject1).K.al().a(l, -1);
            return true;
          }
        }
        for (;;)
        {
          return false;
          if ((bool3) && (bool1))
          {
            if (((AVActivity)localObject1).K.al().i(j))
            {
              DataReport.ShortCut_For_Effect.a(false);
              ((AVActivity)localObject1).K.al().a(l, 0, true);
              return true;
            }
          }
          else if ((bool5) && (i != 0))
          {
            ((AVActivity)localObject1).ai.c(1);
            ChatRoomUtil.b("0X800A8D2");
          }
          else if ((bool6) && (i != 0))
          {
            ((AVActivity)localObject1).K.al().a(l, 0, false);
            ((AVActivity)localObject1).ab.a(l, (Context)localObject1, 0, 1);
            ((AVActivity)localObject1).ai.a(2);
            if (!bool9) {
              ((AVActivity)localObject1).K.ao();
            }
            ChatRoomUtil.b("0X800A8D1");
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.Y != null)
    {
      if (this.a.Z == null) {
        return false;
      }
      try
      {
        long l = AudioHelper.c();
        boolean bool1 = this.a.V();
        boolean bool2 = this.a.N();
        if (QLog.isColorLevel())
        {
          paramMotionEvent = this.a.U;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSingleTapConfirmed, mTargetIndex[");
          ((StringBuilder)localObject1).append(this.a.ah);
          ((StringBuilder)localObject1).append("], isDoubleScreen[");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append("], canMove[");
          ((StringBuilder)localObject1).append(bool2);
          ((StringBuilder)localObject1).append("], seq[");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append("]");
          QLog.w(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
        }
        paramMotionEvent = this.a.Z.k();
        if ((!VideoLayerUI.k(this.a)) && (this.a.ah > 0) && (!bool1))
        {
          if ((paramMotionEvent.g != 2) && (!paramMotionEvent.cw))
          {
            if (bool2)
            {
              if ((this.a.ae == null) || (this.a.ah <= 0)) {
                break label631;
              }
              if (this.a.ah >= this.a.ae.length) {
                return true;
              }
              if (this.a.aj.d())
              {
                localObject2 = this.a.ae[0];
                paramMotionEvent = this.a.ae[this.a.ah];
                if (localObject2 == null) {
                  break label629;
                }
                if (paramMotionEvent == null) {
                  return true;
                }
                localObject1 = ((GLVideoView)localObject2).R();
                int i = ((GLVideoView)localObject2).S();
                localObject2 = paramMotionEvent.R();
                int j = paramMotionEvent.S();
                this.a.Y.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(i), localObject2, Integer.valueOf(j) });
                return true;
              }
              if (this.a.aj.b() == 3)
              {
                this.a.Y.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
                return true;
              }
            }
            else
            {
              this.a.Y.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
              return true;
            }
          }
          else
          {
            bool1 = paramMotionEvent.r();
            if ((this.a.aj.d()) && (!bool1))
            {
              this.a.c(0, this.a.ah);
              return true;
            }
            if (bool1)
            {
              this.a.Y.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
              return true;
            }
          }
        }
        else {
          this.a.Y.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
        }
        return true;
      }
      catch (Exception paramMotionEvent)
      {
        Object localObject1;
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = this.a.U;
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
    label629:
    return true;
    label631:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.GestureListener
 * JD-Core Version:    0.7.0.1
 */