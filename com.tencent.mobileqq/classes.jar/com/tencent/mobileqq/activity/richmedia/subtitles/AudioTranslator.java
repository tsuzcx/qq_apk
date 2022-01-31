package com.tencent.mobileqq.activity.richmedia.subtitles;

import android.net.NetworkInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.conn.HostInfo;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.richmedia.server.TransObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import mqq.os.MqqHandler;
import xsd;
import xse;
import xsg;
import xso;
import xsp;
import xtl;

public class AudioTranslator
  implements xsp
{
  private static AudioTranslator jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator;
  private static String jdField_a_of_type_JavaLangString = "AudioTranslator";
  private long jdField_a_of_type_Long;
  private TransObserver jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private xtl jdField_a_of_type_Xtl;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static AudioTranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator = new AudioTranslator();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "tryReconnect, start");
    }
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      if (this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference == null) {
        return;
      }
    }
    finally {}
    h();
  }
  
  /* Error */
  private void a(xtl paramxtl, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: iload_2
    //   10: ifeq +58 -> 68
    //   13: iload_3
    //   14: ifgt +11 -> 25
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_1
    //   26: getfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   29: ifnonnull +17 -> 46
    //   32: aload_1
    //   33: new 76	android/os/Handler
    //   36: dup
    //   37: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   40: invokespecial 85	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   43: putfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   46: aload_1
    //   47: getfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: new 87	xsf
    //   53: dup
    //   54: aload_0
    //   55: iload_3
    //   56: invokespecial 89	xsf:<init>	(Lcom/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator;I)V
    //   59: iload_3
    //   60: i2l
    //   61: invokevirtual 93	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: getfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   72: ifnull +16 -> 88
    //   75: aload_1
    //   76: getfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   79: aconst_null
    //   80: invokevirtual 97	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: aconst_null
    //   85: putfield 74	xtl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   88: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq -26 -> 65
    //   94: getstatic 22	com/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: iconst_2
    //   98: ldc 99
    //   100: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: goto -38 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	AudioTranslator
    //   0	106	1	paramxtl	xtl
    //   0	106	2	paramBoolean	boolean
    //   0	106	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   6	8	20	finally
    //   17	19	20	finally
    //   21	23	20	finally
    //   25	46	20	finally
    //   46	65	20	finally
    //   65	67	20	finally
    //   68	88	20	finally
    //   88	103	20	finally
  }
  
  public static boolean a(boolean paramBoolean)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null) {}
    boolean bool;
    do
    {
      return false;
      bool = localNetworkInfo.isConnected();
      if (!paramBoolean) {
        break;
      }
    } while (!AppNetConnInfo.isWifiConn());
    return true;
    return bool;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Xtl == null) {
      return;
    }
    this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new xsd(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool;
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checksession state:" + this.jdField_a_of_type_Xtl.jdField_b_of_type_Int + "  withenglish:" + paramBoolean + " old:" + this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean);
      }
      bool = this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean != bool) {
          this.jdField_a_of_type_Xtl.jdField_b_of_type_Boolean = true;
        }
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean != bool) {
        f();
      }
      return;
    }
    this.jdField_a_of_type_Xtl.jdField_b_of_type_Int = 1;
    ((PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0)).a(null, "TransInfoCreate.CreateSession", null, 0, 0, paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send create session cmd");
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Xtl == null) {}
    while (this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver != null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver = new xse(this);
      QQStoryContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver);
      return;
    }
    finally {}
  }
  
  private void f()
  {
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, " changesession state error:" + this.jdField_a_of_type_Xtl.jdField_b_of_type_Int);
        }
        return;
      }
    }
    finally {}
    boolean bool = this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean;
    String str2;
    if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Long != -1L) {
      str2 = String.valueOf(this.jdField_a_of_type_Xtl.jdField_a_of_type_Long);
    }
    ((PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0)).a(str2, "TransInfo.ChangeSession", null, 0, 0, bool);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "changesession start:" + bool + " sessionid:" + str2);
    }
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Xtl == null) {
          return;
        }
        if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int == 0) {
          break label172;
        }
        i = 1;
        if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Long != -1L)
        {
          l = this.jdField_a_of_type_Xtl.jdField_a_of_type_Long;
          String str1 = String.valueOf(this.jdField_a_of_type_Xtl.jdField_a_of_type_Long);
          this.jdField_a_of_type_Xtl.jdField_b_of_type_Int = 0;
          this.jdField_a_of_type_Xtl.jdField_a_of_type_Long = -1L;
          this.jdField_a_of_type_Xtl.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = null;
          if (i != 0)
          {
            ((PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0)).a(l);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "send stop tcp cmd:" + str1);
            }
          }
          a(this.jdField_a_of_type_Xtl, false, 0);
          return;
        }
      }
      finally {}
      String str2 = "";
      long l = 0L;
      continue;
      label172:
      int i = 0;
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "restart begin");
    }
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      if (this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        AudioTranslator.AudioTranslatorListener localAudioTranslatorListener = (AudioTranslator.AudioTranslatorListener)this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localAudioTranslatorListener != null) {
          a(localAudioTranslatorListener, this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean, this.jdField_a_of_type_Xtl.jdField_c_of_type_Boolean, true);
        }
      }
      return;
    }
    finally {}
  }
  
  private void i()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Xtl == null) {
          return;
        }
        if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso != null) {
          break;
        }
        this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso = new xso(this, this.jdField_a_of_type_Xtl.jdField_c_of_type_Int);
        xso localxso1 = this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso;
        if (!this.jdField_a_of_type_Xtl.jdField_c_of_type_Boolean)
        {
          localxso1.a(bool1);
          if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int == 3) {
            this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso.a(this.jdField_a_of_type_Xtl.jdField_a_of_type_Long, this.jdField_a_of_type_Xtl.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso, "TransAudio", 8);
          this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangThread.start();
          return;
        }
      }
      finally {}
      bool1 = false;
    }
    if ((this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangThread.isAlive()) && (!this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "encode thread is running");
      }
      return;
    }
    this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso.a();
    this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "create new EncodeThread ");
    }
    this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso = new xso(this, this.jdField_a_of_type_Xtl.jdField_c_of_type_Int);
    xso localxso2 = this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso;
    if (!this.jdField_a_of_type_Xtl.jdField_c_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localxso2.a(bool1);
      if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int == 3) {
        this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso.a(this.jdField_a_of_type_Xtl.jdField_a_of_type_Long, this.jdField_a_of_type_Xtl.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso, "TransAudio", 8);
      this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangThread.start();
      return;
    }
  }
  
  public void a()
  {
    try
    {
      d();
      a(false, false);
      if (this.jdField_a_of_type_Xtl != null)
      {
        this.jdField_a_of_type_Xtl.a();
        this.jdField_a_of_type_Xtl = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver != null)
      {
        QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaServerTransObserver = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return;
    }
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Xtl.jdField_b_of_type_Int != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onEncodePackage, state not match:" + this.jdField_a_of_type_Xtl.jdField_b_of_type_Int);
      }
      return;
    }
    if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Long != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onEncodePackage, session not match:" + this.jdField_a_of_type_Xtl.jdField_a_of_type_Long + "-" + paramLong);
      }
      return;
    }
    boolean bool = this.jdField_a_of_type_Xtl.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Xtl.jdField_a_of_type_Long != -1L) {
      str1 = String.valueOf(this.jdField_a_of_type_Xtl.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Xtl.jdField_b_of_type_Long = System.currentTimeMillis();
    PeakAudioTransHandler localPeakAudioTransHandler = (PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0);
    String str2 = "";
    if (this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo != null) {
      str2 = this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString;
    }
    for (int i = this.jdField_a_of_type_Xtl.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int;; i = 0)
    {
      localPeakAudioTransHandler.a(str1, "TransInfo.RawData", str2, i, paramByteBuffer.array(), 0, paramByteBuffer.limit(), bool, 2);
      return;
    }
  }
  
  public void a(AudioTranslator.AudioTranslatorListener paramAudioTranslatorListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAudioTranslatorListener);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start, state:" + this.jdField_a_of_type_Xtl.jdField_b_of_type_Int + " withenglish:" + paramBoolean1 + " rocordmode:" + paramBoolean2 + " resumecapture:" + paramBoolean3);
      }
      this.jdField_a_of_type_Xtl.jdField_c_of_type_Boolean = paramBoolean2;
      c(paramBoolean1);
      this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaUtilHashMap.clear();
      i();
      b(true);
      if ((paramBoolean3) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramAudioTranslatorListener = (AudioCapture)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramAudioTranslatorListener != null) {
          paramAudioTranslatorListener.c();
        }
      }
      this.jdField_a_of_type_Xtl.jdField_c_of_type_Long = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "registAudioRecord :" + paramAudioCapture);
    }
    if (paramAudioCapture == null) {}
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      a(false, this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    finally {}
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAudioCapture);
    if ((this.jdField_a_of_type_Xtl != null) && (this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      h();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop, pausecapture:" + paramBoolean1 + " canrestart:" + paramBoolean2);
    }
    try
    {
      b(false);
      if (this.jdField_a_of_type_Xtl == null) {
        return;
      }
      if ((paramBoolean1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        AudioCapture localAudioCapture = (AudioCapture)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localAudioCapture != null) {
          localAudioCapture.b();
        }
      }
      if (!paramBoolean2) {
        this.jdField_a_of_type_Xtl.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      if ((this.jdField_a_of_type_Xtl != null) && (this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "stop begin:" + this.jdField_a_of_type_Xtl.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso.a();
        this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso = null;
      }
      g();
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!a()) {}
    xso localxso;
    do
    {
      do
      {
        return;
      } while (paramInt2 <= 0);
      try
      {
        if (this.jdField_a_of_type_Xtl == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "transcontext is null");
          }
          return;
        }
      }
      finally {}
      localxso = this.jdField_a_of_type_Xtl.jdField_a_of_type_Xso;
    } while (localxso == null);
    localxso.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "init, samplerate:" + paramInt1 + " channel:" + paramInt2 + " format:" + paramInt3);
    }
    try
    {
      if (this.jdField_a_of_type_Xtl != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "create error, transcontext not null!");
        }
        return false;
      }
      this.jdField_a_of_type_Xtl = new xtl();
      this.jdField_a_of_type_Xtl.jdField_c_of_type_Int = paramInt1;
      this.jdField_a_of_type_Xtl.d = paramInt2;
      this.jdField_a_of_type_Xtl.e = paramInt3;
      e();
      c();
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(new xsg(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator
 * JD-Core Version:    0.7.0.1
 */