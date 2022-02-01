package com.tencent.av.business.manager.support;

import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class SupportFace
  extends SupportBase
{
  private boolean a;
  private int c = -1;
  private int d = -1;
  
  public SupportFace(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    return EffectsRenderController.c();
  }
  
  private boolean b()
  {
    return EffectsRenderController.d();
  }
  
  public int a(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.c;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.d;
    }
    return -1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ThreadManager.a().postDelayed(new SupportFace.1(this), 1100L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveSupportMessage type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("SupportFace", localStringBuilder.toString());
    boolean bool = true;
    if (paramString != null) {
      if (paramString.equals("SUPPORT_TRUE"))
      {
        if (paramInt == 1)
        {
          this.c = 1;
        }
        else
        {
          if (paramInt != 3) {
            return bool;
          }
          this.c = 1;
          this.d = 1;
        }
      }
      else if (paramString.equals("SUPPORT_FALSE"))
      {
        if (paramInt == 1)
        {
          this.c = 0;
          this.d = 0;
          return true;
        }
        if (paramInt != 3) {
          return bool;
        }
        this.d = 0;
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public boolean a(String paramString)
  {
    AVLog.printAllUserLog("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      return a();
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return b();
    }
    return false;
  }
  
  public void b()
  {
    boolean bool1 = PtuResChecker.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    boolean bool2 = a();
    if ((bool2) && (bool1)) {
      ((VideoController)localObject).a(1, "SUPPORT_TRUE");
    }
    boolean bool3 = b();
    if ((bool3) && (bool1)) {
      ((VideoController)localObject).a(3, "SUPPORT_TRUE");
    }
    if ((bool2) && (bool3)) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendSupportMsg, normal[");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("], interact[");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append("], isAEKitResExist[");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("]");
    QLog.w("SupportFace", 1, ((StringBuilder)localObject).toString());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = -1;
    this.d = -1;
    AVLog.printColorLog("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportFace
 * JD-Core Version:    0.7.0.1
 */