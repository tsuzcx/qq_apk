package com.tencent.av.business.manager.support;

import android.os.Handler;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class SupportFace
  extends SupportBase
{
  private boolean a;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
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
  
  private boolean c()
  {
    return EffectsRenderController.f();
  }
  
  public int a(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.c;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.d;
    }
    if ("creative".equalsIgnoreCase(paramString)) {
      return this.e;
    }
    return -1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ThreadManager.a().postDelayed(new SupportFace.1(this), 1100L);
    }
    AVLog.printColorLog("SupportFace", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      if (!paramString.equals("SUPPORT_TRUE")) {
        break label122;
      }
      if (paramInt != 1) {
        break label83;
      }
      this.c = 1;
    }
    label83:
    label122:
    do
    {
      return false;
      if (paramInt == 3)
      {
        this.c = 1;
        this.d = 1;
        return false;
      }
      if (paramInt == 14)
      {
        this.e = 1;
        AVLog.printColorLog("SupportFace", "onReceiveSupportMessage  support reason 1:");
        return false;
      }
      return true;
      if (paramString.equals("SUPPORT_FALSE"))
      {
        if (paramInt == 1)
        {
          this.c = 0;
          this.d = 0;
        }
        for (;;)
        {
          return true;
          if (paramInt == 3)
          {
            this.d = 0;
          }
          else if (paramInt == 14)
          {
            this.e = 0;
            AVLog.printColorLog("SupportFace", "onReceiveSupportMessage not support reason 1:");
          }
        }
      }
      if (paramString.equals("SUPPORT_CREATIVECOP_TRUE"))
      {
        if (paramInt == 14)
        {
          this.e = 1;
          AVLog.printColorLog("SupportFace", "onReceiveSupportMessage  support reason 2:");
        }
        return true;
      }
    } while (!paramString.equals("SUPPORT_CREATIVECOP_FALSE"));
    if (paramInt == 14)
    {
      this.e = 0;
      AVLog.printColorLog("SupportFace", "onReceiveSupportMessage  not support reason 2:");
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    AVLog.printAllUserLog("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      bool = a();
    }
    do
    {
      return bool;
      if ("interact".equalsIgnoreCase(paramString)) {
        return b();
      }
    } while (!"creative".equalsIgnoreCase(paramString));
    return c();
  }
  
  public void b()
  {
    boolean bool1 = PtuResChecker.b();
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    boolean bool2 = a();
    if ((bool2) && (bool1)) {
      localVideoController.a(1, "SUPPORT_TRUE");
    }
    boolean bool3 = b();
    if ((bool3) && (bool1)) {
      localVideoController.a(3, "SUPPORT_TRUE");
    }
    boolean bool4 = c();
    if ((bool4) && (bool1))
    {
      AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
      localAVFunChatMessage.uint64_type.set(14L);
      localAVFunChatMessage.enum_operator.set(1);
      localAVFunChatMessage.str_msg.set("SUPPORT_CREATIVECOP_TRUE");
      localVideoController.a(14, localAVFunChatMessage);
    }
    if ((bool2) && (bool3) && (bool4)) {
      return;
    }
    QLog.w("SupportFace", 1, "sendSupportMsg, normal[" + bool2 + "], interact[" + bool3 + "], creativePendant[" + bool4 + "], isAEKitResExist[" + bool1 + "]");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    AVLog.printColorLog("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.support.SupportFace
 * JD-Core Version:    0.7.0.1
 */