package com.tencent.mobileqq.activity.richmedia.subtitles;

import addi;
import ahyc;
import ahyd;
import ahyg;
import ahyk;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import axqw;
import axrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SubtitleLayout
  extends RelativeLayout
  implements ahyg
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private ahyk jdField_a_of_type_Ahyk;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Random jdField_a_of_type_JavaUtilRandom;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public SubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    setWillNotDraw(false);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "startTranslator, mode:" + this.jdField_b_of_type_Int + " type:" + paramInt + " stropfirst:" + paramBoolean1 + " recordmode:" + paramBoolean2 + " resumecapture:" + paramBoolean3);
    }
    if ((this.jdField_b_of_type_Int != 0) || (paramInt == 0)) {
      return;
    }
    if (paramBoolean1) {
      ahyd.a().a(false, false);
    }
    switch (paramInt)
    {
    default: 
      ahyd.a().a(this, true, paramBoolean2, paramBoolean3);
      return;
    case 1: 
    case 2: 
      ahyd.a().a(this, false, paramBoolean2, paramBoolean3);
      return;
    }
    ahyd.a().a(this, true, paramBoolean2, paramBoolean3);
  }
  
  private void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SubtitleLayout.2(this), paramInt);
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "count timer exist.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "start countdown timer.");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new SubtitleLayout.1(this), 180000L);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "stopDemo begin");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_JavaUtilRandom = null;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "startDemo begin");
    }
    if (this.jdField_a_of_type_Ahyk == null) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilRandom == null) {
      this.jdField_a_of_type_JavaUtilRandom = new Random();
    }
    this.jdField_a_of_type_Boolean = true;
    b(0);
  }
  
  private void k()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilTimer == null) || (this.jdField_a_of_type_JavaUtilTimerTask == null))
      {
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long == -1L)) {
          this.jdField_a_of_type_Long = 0L;
        }
        l();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: ldc 56
    //   2: iconst_2
    //   3: ldc 176
    //   5: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 169	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   14: ifnonnull +15 -> 29
    //   17: aload_0
    //   18: new 178	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout$3
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 179	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout$3:<init>	(Lcom/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout;)V
    //   26: putfield 169	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   29: aload_0
    //   30: getfield 167	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   33: ifnonnull +14 -> 47
    //   36: aload_0
    //   37: new 181	java/util/Timer
    //   40: dup
    //   41: invokespecial 182	java/util/Timer:<init>	()V
    //   44: putfield 167	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   47: aload_0
    //   48: getfield 167	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   51: aload_0
    //   52: getfield 169	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   55: lconst_0
    //   56: ldc2_w 183
    //   59: invokevirtual 188	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   62: invokestatic 191	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   65: invokestatic 123	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   68: if_acmpne +10 -> 78
    //   71: aload_0
    //   72: invokevirtual 194	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:invalidate	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: invokevirtual 197	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:postInvalidate	()V
    //   82: goto -7 -> 75
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	SubtitleLayout
    //   85	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	29	85	finally
    //   29	47	85	finally
    //   47	75	85	finally
    //   75	77	85	finally
    //   78	82	85	finally
    //   86	88	85	finally
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "StopTimer begin");
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "clear begin");
    }
    try
    {
      if (this.jdField_a_of_type_Ahyk != null) {
        this.jdField_a_of_type_Ahyk.e();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "init, mode:" + this.jdField_b_of_type_Int);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("SubtitleLayout", 2, "setAnimText:" + paramString1 + " " + paramString2);
    try
    {
      if ((this.jdField_a_of_type_Ahyk == null) || (this.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_Int == 0)) {
        return;
      }
      if ((this.jdField_a_of_type_Boolean) && ((!this.jdField_c_of_type_Boolean) || (this.d)))
      {
        i();
        a();
        if ((this.d) && (this.jdField_a_of_type_Ahyk != null))
        {
          this.jdField_a_of_type_Ahyk.d();
          this.jdField_a_of_type_Ahyk.a(3);
          this.jdField_b_of_type_Long = 0L;
        }
      }
      if (this.e)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_c_of_type_Long;
        HashMap localHashMap = new HashMap();
        localHashMap.put("pressStartTransCost", String.valueOf(l1 - l2));
        axrl.a(BaseApplicationImpl.getApplication()).a(null, "actSubtitlePressTranslate", true, 0L, 0L, localHashMap, null);
        this.e = false;
      }
      this.jdField_a_of_type_Ahyk.a(paramLong1, paramLong2, paramString1, paramString2, paramBoolean);
      k();
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4)) {
      return;
    }
    int i = paramArrayOfByte.length;
    setAnimType(addi.a(paramArrayOfByte, 0), null, paramArrayOfByte, 4, i - 4);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "start ,mode:" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      axqw.b(null, "dc00898", "", "", "0X8008758", "0X8008758", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        i();
      }
      a();
      j();
      k();
      this.d = true;
      a(this.jdField_a_of_type_Int, true, true, true);
      h();
    }
    for (;;)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.e = true;
      return;
      this.jdField_b_of_type_Boolean = false;
      k();
      try
      {
        if (this.jdField_a_of_type_Ahyk != null)
        {
          this.jdField_a_of_type_Ahyk.d();
          this.jdField_a_of_type_Ahyk.a(3);
          this.jdField_b_of_type_Long = 0L;
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    m();
    try
    {
      if (this.jdField_a_of_type_Ahyk != null) {
        this.jdField_a_of_type_Ahyk.a(true);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        ahyd.a().a(true, false);
        h();
        i();
      }
      this.jdField_b_of_type_Long = 0L;
      return;
    }
    finally {}
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      try
      {
        if (this.jdField_a_of_type_Ahyk != null) {
          this.jdField_a_of_type_Ahyk.a(false);
        }
        k();
        if ((this.jdField_b_of_type_Int != 0) || (this.d)) {
          continue;
        }
        j();
        g();
        a(this.jdField_a_of_type_Int, false, false, true);
        return;
      }
      finally {}
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "Stop, mode:" + this.jdField_b_of_type_Int);
    }
    this.jdField_b_of_type_Boolean = false;
    m();
    this.jdField_b_of_type_Long = 0L;
    if (this.jdField_b_of_type_Int == 0)
    {
      this.d = false;
      ahyd.a().a(false, false);
      i();
      setState(this.jdField_c_of_type_Int);
    }
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_a_of_type_Ahyk != null)
      {
        this.jdField_a_of_type_Ahyk.c();
        this.jdField_a_of_type_Ahyk = null;
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      h();
      this.jdField_a_of_type_JavaUtilRandom = null;
      return;
    }
    finally {}
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (this.jdField_a_of_type_Ahyk != null)
      {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Ahyk.a(paramCanvas, null, -1L);
        int i = 10;
        while ((this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_b_of_type_Long) && (this.jdField_a_of_type_Long != -1L) && (this.jdField_a_of_type_Long != -2L) && (i > 0))
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_Ahyk.a(paramCanvas, null, -1L);
          i -= 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public void setAnimType(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "setAnimTye, type:" + paramInt1 + " font:" + paramString);
    }
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == 0)) {
      if (this.jdField_a_of_type_Int != 0)
      {
        j();
        k();
      }
    }
    do
    {
      return;
      a();
      this.jdField_a_of_type_Int = paramInt1;
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
      {
        ahyd.a().a(true, false);
        h();
      }
      if (this.jdField_a_of_type_Ahyk != null)
      {
        this.jdField_a_of_type_Ahyk.c();
        this.jdField_a_of_type_Ahyk = null;
      }
      this.jdField_a_of_type_Ahyk = ahyc.a(this.jdField_a_of_type_Int);
    } while (this.jdField_a_of_type_Ahyk == null);
    if (this.jdField_b_of_type_Int == 0)
    {
      paramInt1 = getWidth();
      paramInt2 = getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "subtitlelayout width:" + paramInt1 + " height:" + paramInt2);
      }
      this.jdField_a_of_type_Ahyk.a(getContext(), paramInt1, paramInt2, 30, false, paramString);
      this.jdField_a_of_type_Ahyk.a(this.jdField_c_of_type_Int);
      i();
      a();
      j();
      k();
      a(this.jdField_a_of_type_Int, false, false, true);
      g();
      return;
    }
    this.jdField_a_of_type_Ahyk.a(getContext(), -1.0F, -1.0F, -1, paramArrayOfByte, paramInt2, paramInt3, true);
  }
  
  public void setState(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Ahyk != null) {
        this.jdField_a_of_type_Ahyk.a(paramInt);
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    finally {}
  }
  
  public void setTimeStamp(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.jdField_b_of_type_Long = (paramLong / 30L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout
 * JD-Core Version:    0.7.0.1
 */