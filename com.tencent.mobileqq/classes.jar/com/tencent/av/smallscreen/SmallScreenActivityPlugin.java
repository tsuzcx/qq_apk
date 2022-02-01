package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenActivityPlugin
{
  private static volatile SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = true;
  
  private SmallScreenActivityPlugin(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static SmallScreenActivityPlugin a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
        jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(paramVideoAppInterface);
      }
      return jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    }
    finally {}
  }
  
  public void a()
  {
    if (SmallScreenUtils.f()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = VideoController.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if ((QLog.isColorLevel()) || (!bool2) || (paramBoolean)) {
      QLog.w("SmallScreenActivityPlugin", 1, "onPauseRender, isQuit[" + paramBoolean + "], isScreenOn[" + bool2 + "], seq[" + paramLong + "]");
    }
    SessionInfo localSessionInfo;
    if (!paramBoolean)
    {
      if (!SmallScreenUtils.f()) {
        break label170;
      }
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = localSessionInfo.d;
      paramBoolean = bool1;
      if (i != 2) {
        if (i != 4) {
          break label165;
        }
      }
    }
    label165:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ThreadManager.excute(new SmallScreenActivityPlugin.2(this, paramLong, bool2, this.jdField_a_of_type_ComTencentAvVideoController.a().c(), paramBoolean), 16, null, false);
      SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), localSessionInfo);
      return;
    }
    label170:
    SmallScreenUtils.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    SmallScreenUtils.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin
 * JD-Core Version:    0.7.0.1
 */