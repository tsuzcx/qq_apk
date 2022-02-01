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
    a(false);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1002L);
    if ((VideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) || (!VideoLayerUI.c(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))) {
      return true;
    }
    int j = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramMotionEvent.getX());
    int k;
    Object localObject1;
    int i;
    label270:
    label276:
    Object localObject2;
    if (VideoLayerUI.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
    {
      if (j == -1) {
        return true;
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
      String str = paramMotionEvent.c();
      k = paramMotionEvent.g();
      if (TextUtils.isEmpty(str))
      {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp with empty UIN");
        return true;
      }
      localObject1 = VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a();
      if (((ArrayList)localObject1).size() > VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
      {
        i = 1;
        if ((j != VideoLayerUI.f(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) - 2) || (i == 0)) {
          break label276;
        }
        ReportController.b(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
        paramMotionEvent = (AVActivity)this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidContentContext;
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().ad) && (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().ae)) {
          break label270;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        VideoMsgTools.a(paramMotionEvent, String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().g), bool1, true);
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp jumpTo lists");
        return true;
        i = 0;
        break;
      }
      if (j + 1 > ((ArrayList)localObject1).size() - 1)
      {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp ArrayOutOfList");
        return true;
      }
      localObject2 = (VideoMemberInfo)((ArrayList)localObject1).get(j + 1);
      boolean bool2;
      if ((localObject2 != null) && (((VideoMemberInfo)localObject2).c()))
      {
        bool1 = true;
        if ((localObject2 == null) || (!str.equalsIgnoreCase(String.valueOf(((VideoMemberInfo)localObject2).jdField_a_of_type_Long))) || (((VideoMemberInfo)localObject2).b() != k)) {
          break label746;
        }
        bool2 = true;
        label367:
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSingleTapUp, isVideoIn[" + bool1 + "], isSame[" + bool2 + "], uin[" + str + "], currentSelect[" + localObject2 + "], index[" + j + "]");
        }
        label661:
        label680:
        if ((localObject2 != null) && (!bool2))
        {
          bool2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.b();
          if ((!bool2) || (!bool1)) {
            break label752;
          }
          ReportController.b(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
          str = paramMotionEvent.c();
          i = paramMotionEvent.g();
          long l = ((VideoMemberInfo)localObject2).jdField_a_of_type_Long;
          k = ((VideoMemberInfo)localObject2).b();
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
          QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onSingleTapUp mTargetIndex:=" + j + ";Numberlist:=" + ((ArrayList)localObject1).size());
          label626:
          if (!bool1)
          {
            if (!((VideoMemberInfo)localObject2).a()) {
              break label832;
            }
            if (((VideoMemberInfo)localObject2).a() != this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
              break label809;
            }
            bool1 = true;
            if (!bool1) {
              break label815;
            }
            TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1051);
            QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not open camera isSelfUin:=" + bool1);
          }
        }
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
        return true;
        bool1 = false;
        break;
        label746:
        bool2 = false;
        break label367;
        label752:
        if (!QLog.isColorLevel()) {
          break label626;
        }
        QLog.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSingleTapUp, canSwitchView[" + bool2 + "], isVideoIn[" + bool1 + "]");
        break label626;
        label809:
        bool1 = false;
        break label661;
        label815:
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1052);
        break label680;
        label832:
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1053);
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "not attend video talking");
      }
    }
    if (j != -1)
    {
      i = j + 1;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) || (i <= 0) || (i >= this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)) {
        return true;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      if ((localObject2 == null) || (paramMotionEvent == null)) {
        return true;
      }
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
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "condition print onSingleTapUp mTargetIndex:=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t + ",canSwitchView=" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
    }
    for (;;)
    {
      return true;
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "error condition print onSingleTapUp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */