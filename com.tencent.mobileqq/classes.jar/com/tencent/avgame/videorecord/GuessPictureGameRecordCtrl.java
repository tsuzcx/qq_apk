package com.tencent.avgame.videorecord;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.util.AvGameConfBean.RecordParam;
import com.tencent.avgame.util.RecordUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

@TargetApi(17)
public class GuessPictureGameRecordCtrl
  extends GameVideoRecordBaseCtrl
{
  private long jdField_a_of_type_Long;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
  private GuessPictureGamePaintLogic jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic = new GuessPictureGamePaintLogic();
  private GuessPictureGameRecordCtrl.GameImageDataProvider jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl$GameImageDataProvider;
  private GuessPictureGameResultMgr jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr = new GuessPictureGameResultMgr();
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int f;
  
  public GuessPictureGameRecordCtrl(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 720) {
      this.jdField_b_of_type_Int = paramInt1;
    }
    for (this.jdField_c_of_type_Int = paramInt2;; this.jdField_c_of_type_Int = ((int)(paramInt2 * (720.0F / paramInt1))))
    {
      this.jdField_b_of_type_Int = CaptureUtil.a(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int = CaptureUtil.a(this.jdField_c_of_type_Int);
      return;
      this.jdField_b_of_type_Int = 720;
    }
  }
  
  private void b(GuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl$GameImageDataProvider = paramGameImageDataProvider;
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.a(paramInt1, paramInt2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.a(b(), c(), this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic);
    this.jdField_a_of_type_JavaLangRunnable = new GuessPictureGameRecordCtrl.1(this);
  }
  
  private boolean f()
  {
    return GameEngine.a().a().c() == 2;
  }
  
  private boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl$GameImageDataProvider.b()) || (this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.b()))
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl$GameImageDataProvider.a();
      this.f = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.a(localArrayList);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.a(localArrayList);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.a();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "addNextFrame, dataList size:", Integer.valueOf(localArrayList.size()) });
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) && (this.f > 0) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < this.jdField_e_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(3553, this.f, null, null, SystemClock.elapsedRealtimeNanos());
      return true;
    }
    return false;
  }
  
  protected String a()
  {
    return "GuessPictureGameRecordCtrl";
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_c_of_type_Boolean = true;
    k();
    QLog.e("GuessPictureGameRecordCtrl", 1, paramThrowable, new Object[] { "onEncodeError, errorCode", Integer.valueOf(paramInt) });
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewShow, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.a(paramView, paramInt, paramBoolean);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.a(paramBoolean);
    }
  }
  
  public void a(GuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramGameImageDataProvider, paramInt1, paramInt2);
      l = RecordUtils.b().jdField_b_of_type_Int * 1000;
      paramGameImageDataProvider = GameEngine.a().a().a();
      if ((!f()) || (paramGameImageDataProvider.startGameTimeMills <= 0L)) {
        break label222;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord, gameRecordInfo:", paramGameImageDataProvider });
      }
      if ((paramGameImageDataProvider.videoFilePath == null) || (!new File(paramGameImageDataProvider.videoFilePath).exists())) {
        break label136;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord return, video file exists");
      }
    }
    return;
    label136:
    this.jdField_a_of_type_Long = paramGameImageDataProvider.startGameTimeMills;
    long l = Math.min(Math.max(System.currentTimeMillis() - this.jdField_a_of_type_Long, l), 0L);
    for (;;)
    {
      GameEngine.a().a().a(null, null, this.jdField_a_of_type_Long);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord indeed, delayTime:", Long.valueOf(l) });
      return;
      label222:
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 118
    //   12: iconst_2
    //   13: iconst_2
    //   14: anewarray 120	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 263
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield 78	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_e_of_type_Boolean	Z
    //   29: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 53	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_d_of_type_Boolean	Z
    //   41: aload_0
    //   42: getfield 53	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_d_of_type_Boolean	Z
    //   45: ifeq +31 -> 76
    //   48: aload_0
    //   49: getfield 78	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_e_of_type_Boolean	Z
    //   52: ifeq +24 -> 76
    //   55: aload_0
    //   56: getfield 38	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr	Lcom/tencent/avgame/videorecord/GuessPictureGameResultMgr;
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 161	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_c_of_type_Boolean	Z
    //   64: ifne +15 -> 79
    //   67: aload_1
    //   68: iload_2
    //   69: aload_0
    //   70: getfield 230	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_Long	J
    //   73: invokevirtual 266	com/tencent/avgame/videorecord/GuessPictureGameResultMgr:a	(ZJ)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -14 -> 67
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	GuessPictureGameRecordCtrl
    //   0	89	1	paramString	String
    //   1	80	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	36	84	finally
    //   36	67	84	finally
    //   67	76	84	finally
  }
  
  public void a(ArrayList<GameImageData> paramArrayList)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.a(paramArrayList);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewDismiss, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGamePaintLogic.a(paramView);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onActivityStop, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onGameOver, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public boolean e()
  {
    super.e();
    n();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, this);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "startRecord");
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeStart, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, "onEncodeVideoFrame, mIsRecording false");
      k();
    }
    do
    {
      do
      {
        return;
      } while (g());
      k();
    } while (!QLog.isColorLevel());
    QLog.e("GuessPictureGameRecordCtrl", 2, "onEncodeVideoFrame, stop record");
  }
  
  public void i() {}
  
  public void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.e("GuessPictureGameRecordCtrl", 1, new Object[] { "endRecord, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    do
    {
      return;
      super.k();
    } while (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.b();
  }
  
  /* Error */
  public void m()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 118
    //   12: iconst_2
    //   13: iconst_2
    //   14: anewarray 120	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 321
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield 53	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_d_of_type_Boolean	Z
    //   29: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 78	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_e_of_type_Boolean	Z
    //   41: aload_0
    //   42: getfield 174	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_Boolean	Z
    //   45: ifne +68 -> 113
    //   48: invokestatic 248	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   51: aload_0
    //   52: getfield 76	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   55: invokevirtual 325	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   58: aload_0
    //   59: getfield 53	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_d_of_type_Boolean	Z
    //   62: ifeq +38 -> 100
    //   65: aload_0
    //   66: getfield 78	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_e_of_type_Boolean	Z
    //   69: ifeq +31 -> 100
    //   72: aload_0
    //   73: getfield 192	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_b_of_type_Boolean	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: getfield 38	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr	Lcom/tencent/avgame/videorecord/GuessPictureGameResultMgr;
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 161	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_c_of_type_Boolean	Z
    //   88: ifne +20 -> 108
    //   91: aload_2
    //   92: iload_1
    //   93: aload_0
    //   94: getfield 230	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_a_of_type_Long	J
    //   97: invokevirtual 266	com/tencent/avgame/videorecord/GuessPictureGameResultMgr:a	(ZJ)V
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 192	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:jdField_b_of_type_Boolean	Z
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: iconst_0
    //   109: istore_1
    //   110: goto -19 -> 91
    //   113: aload_0
    //   114: invokevirtual 164	com/tencent/avgame/videorecord/GuessPictureGameRecordCtrl:k	()V
    //   117: goto -17 -> 100
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	GuessPictureGameRecordCtrl
    //   1	109	1	bool	boolean
    //   83	9	2	localGuessPictureGameResultMgr	GuessPictureGameResultMgr
    //   120	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	36	120	finally
    //   36	91	120	finally
    //   91	100	120	finally
    //   100	105	120	finally
    //   113	117	120	finally
  }
  
  public void n()
  {
    this.jdField_d_of_type_Int = 5120000;
    this.jdField_e_of_type_Int = (RecordUtils.b().jdField_c_of_type_Int * 1000);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = new EncodeConfig(this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameResultMgr.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1, false, 0);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "initRecordCodecParams, bitRate:", Integer.valueOf(this.jdField_d_of_type_Int) });
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "onVideoMuxerWaiting");
    }
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      Thread.sleep(300L);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GuessPictureGameRecordCtrl", 2, new Object[] { "onVideoMuxerWaiting", localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */