package com.tencent.av.business.manager.support;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;

public class SupportFace
  extends SupportBase
{
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
  public SupportFace(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int > 15) && (this.jdField_a_of_type_Long > 1200000L) && (this.jdField_b_of_type_Int > 2) && (this.jdField_b_of_type_Long > 1073741824L);
  }
  
  private boolean c()
  {
    return EffectsRenderController.a();
  }
  
  private boolean d()
  {
    return EffectsRenderController.a();
  }
  
  public int a(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.c;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.d;
    }
    if ("SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString)) {
      return this.e;
    }
    return -1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    AVLog.c("SupportFace", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      if (paramString.equals("SUPPORT_TRUE")) {
        if (paramInt == 1) {
          this.c = 1;
        }
      }
      do
      {
        do
        {
          do
          {
            return true;
          } while (paramInt != 3);
          this.c = 1;
          this.d = 1;
          return true;
          if (!paramString.equals("SUPPORT_FALSE")) {
            break;
          }
          if (paramInt == 1)
          {
            this.c = 0;
            this.d = 0;
            return true;
          }
        } while (paramInt != 3);
        this.d = 0;
        return true;
        if (!paramString.equals("SUPPORT_SWITCH_FACE")) {
          break;
        }
      } while (paramInt != 3);
      this.e = 1;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    AVLog.d("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      bool = b();
    }
    do
    {
      return bool;
      if ("interact".equalsIgnoreCase(paramString)) {
        return c();
      }
    } while (!"SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString));
    return d();
  }
  
  public void b()
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    boolean bool = b();
    if (bool)
    {
      if (bool)
      {
        str = "SUPPORT_TRUE";
        localVideoController.a(1, str);
      }
    }
    else
    {
      if (d()) {
        localVideoController.a(3, "SUPPORT_SWITCH_FACE");
      }
      bool = c();
      if (bool) {
        if (!bool) {
          break label76;
        }
      }
    }
    label76:
    for (String str = "SUPPORT_TRUE";; str = "SUPPORT_FALSE")
    {
      localVideoController.a(3, str);
      return;
      str = "SUPPORT_FALSE";
      break;
    }
  }
  
  public void c()
  {
    this.c = -1;
    this.d = -1;
    this.e = -1;
    AVLog.c("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportFace
 * JD-Core Version:    0.7.0.1
 */