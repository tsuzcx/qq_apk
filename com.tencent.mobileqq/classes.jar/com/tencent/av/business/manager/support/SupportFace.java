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
  private int g = -1;
  private int h = -1;
  private boolean i = false;
  
  public SupportFace(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private boolean d()
  {
    return EffectsRenderController.d();
  }
  
  private boolean e()
  {
    return EffectsRenderController.e();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (!this.i) {
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
          this.g = 1;
        }
        else
        {
          if (paramInt != 3) {
            return bool;
          }
          this.g = 1;
          this.h = 1;
        }
      }
      else if (paramString.equals("SUPPORT_FALSE"))
      {
        if (paramInt == 1)
        {
          this.g = 0;
          this.h = 0;
          return true;
        }
        if (paramInt != 3) {
          return bool;
        }
        this.h = 0;
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public boolean a(String paramString)
  {
    AVLog.printAllUserLog("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.a, Integer.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.e) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      return d();
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return e();
    }
    return false;
  }
  
  public int b(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.g;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.h;
    }
    return -1;
  }
  
  public void b()
  {
    boolean bool1 = PtuResChecker.c();
    Object localObject = this.f.b();
    boolean bool2 = d();
    if ((bool2) && (bool1)) {
      ((VideoController)localObject).e(1, "SUPPORT_TRUE");
    }
    boolean bool3 = e();
    if ((bool3) && (bool1)) {
      ((VideoController)localObject).e(3, "SUPPORT_TRUE");
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
    this.i = false;
    this.g = -1;
    this.h = -1;
    AVLog.printColorLog("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportFace
 * JD-Core Version:    0.7.0.1
 */