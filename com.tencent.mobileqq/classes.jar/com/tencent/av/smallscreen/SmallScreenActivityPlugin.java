package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import jqb;
import jqc;

public class SmallScreenActivityPlugin
{
  private static volatile SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
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
    if (SmallScreenUtils.b()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenActivityPlugin", 2, "onPauseRender isQuit : " + paramBoolean);
    }
    SessionInfo localSessionInfo;
    if (!paramBoolean)
    {
      if (!SmallScreenUtils.b()) {
        break label98;
      }
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = localSessionInfo.d;
      if ((i != 2) && (i != 4)) {
        break label93;
      }
    }
    label93:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.post(new jqc(this, paramBoolean), 5, null, false);
      SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), localSessionInfo);
      return;
    }
    label98:
    SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.b());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenActivityPlugin", 2, "onResume");
    }
    if (SmallScreenUtils.b())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.post(new jqb(this), 5, null, false);
    }
    SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (SmallScreenUtils.b())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin
 * JD-Core Version:    0.7.0.1
 */