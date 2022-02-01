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
  private boolean b;
  private long c = -1L;
  
  private VideoLayerUI$MyGestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  private void a(boolean paramBoolean)
  {
    if (!this.b) {
      return;
    }
    this.b = false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    int i = VideoLayerUI.r(this.a);
    if (i == 0) {
      return false;
    }
    VideoLayerUI.n(this.a).a((int)-paramFloat1, 0, i);
    this.a.m();
    VideoLayerUI.b(this.a, -1000L);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    a(true);
    if (VideoLayerUI.s(this.a)) {}
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(false);
    VideoLayerUI.n(this.a).b(Math.round(paramFloat1), 0, VideoLayerUI.r(this.a));
    this.a.m();
    VideoLayerUI.b(this.a, -1001L);
    long l = System.currentTimeMillis();
    if (l - this.c > 100L)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
      this.c = l;
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (this.b) {
      return;
    }
    if (this.a.a(paramMotionEvent.getX()) != -1)
    {
      this.b = true;
      return;
    }
    QLog.d(this.a.U, 1, "error condition print onShowPress");
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    a(false);
    VideoLayerUI.b(this.a, -1002L);
    if (!VideoLayerUI.s(this.a))
    {
      if (!VideoLayerUI.q(this.a)) {
        return true;
      }
      int j = this.a.a(paramMotionEvent.getX());
      Object localObject2;
      int k;
      Object localObject1;
      int i;
      if (VideoLayerUI.t(this.a))
      {
        if (j == -1) {
          return true;
        }
        localObject2 = this.a.ae[0];
        Object localObject3 = ((GLVideoView)localObject2).R();
        k = ((GLVideoView)localObject2).S();
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          QLog.d(this.a.U, 1, "onSingleTapUp with empty UIN");
          return true;
        }
        localObject1 = VideoLayerUI.u(this.a).b();
        if (((ArrayList)localObject1).size() > VideoLayerUI.v(this.a)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((j == VideoLayerUI.v(this.a) - 2) && (i != 0))
        {
          ReportController.b(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
          paramMotionEvent = (AVActivity)this.a.X;
          if ((this.a.Z.k().bg) || (this.a.Z.k().bh)) {
            bool1 = true;
          }
          VideoMsgTools.a(paramMotionEvent, String.valueOf(this.a.Z.k().aN), bool1, true);
          QLog.d(this.a.U, 1, "onSingleTapUp jumpTo lists");
          return true;
        }
        i = j + 1;
        if (i > ((ArrayList)localObject1).size() - 1)
        {
          QLog.d(this.a.U, 1, "onSingleTapUp ArrayOutOfList");
          return true;
        }
        paramMotionEvent = (VideoMemberInfo)((ArrayList)localObject1).get(i);
        if ((paramMotionEvent != null) && (paramMotionEvent.e())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if ((paramMotionEvent != null) && (((String)localObject3).equalsIgnoreCase(String.valueOf(paramMotionEvent.b))) && (paramMotionEvent.c() == k)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (QLog.isColorLevel())
        {
          String str = this.a.U;
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
          bool2 = this.a.aj.d();
          if ((bool2) && (bool1))
          {
            ReportController.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
            localObject3 = ((GLVideoView)localObject2).R();
            i = ((GLVideoView)localObject2).S();
            long l = paramMotionEvent.b;
            k = paramMotionEvent.c();
            this.a.Y.a(new Object[] { Integer.valueOf(115), localObject3, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
            localObject2 = this.a.U;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onSingleTapUp mTargetIndex:=");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(";Numberlist:=");
            ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
            QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = this.a.U;
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
            if (paramMotionEvent.b())
            {
              bool1 = bool3;
              if (paramMotionEvent.g() == this.a.Y.getLongAccountUin()) {
                bool1 = true;
              }
              if (bool1) {
                TipsUtil.a(this.a.Y, 1051);
              } else {
                TipsUtil.a(this.a.Y, 1052);
              }
              paramMotionEvent = this.a.U;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("not open camera isSelfUin:=");
              ((StringBuilder)localObject1).append(bool1);
              QLog.d(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              TipsUtil.a(this.a.Y, 1053);
              QLog.d(this.a.U, 1, "not attend video talking");
            }
            ReportController.b(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
          }
        }
        return true;
      }
      if (j != -1)
      {
        i = j + 1;
        if ((this.a.ae != null) && (i > 0) && (i < this.a.ae.length))
        {
          localObject2 = this.a.ae[0];
          paramMotionEvent = this.a.ae[i];
          if ((localObject2 != null) && (paramMotionEvent != null))
          {
            if (this.a.aj.d())
            {
              ReportController.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
              localObject1 = ((GLVideoView)localObject2).R();
              j = ((GLVideoView)localObject2).S();
              localObject2 = paramMotionEvent.R();
              k = paramMotionEvent.S();
              this.a.Y.a(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(j), localObject2, Integer.valueOf(k) });
            }
            if (VideoLayerUI.w(this.a) != null) {
              VideoLayerUI.w(this.a).a(i);
            }
            paramMotionEvent = this.a.U;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("condition print onSingleTapUp mTargetIndex:=");
            ((StringBuilder)localObject1).append(this.a.ah);
            ((StringBuilder)localObject1).append(",canSwitchView=");
            ((StringBuilder)localObject1).append(this.a.aj.d());
            QLog.d(paramMotionEvent, 1, ((StringBuilder)localObject1).toString());
            return true;
          }
          return true;
        }
        return true;
      }
      QLog.d(this.a.U, 1, "error condition print onSingleTapUp");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */