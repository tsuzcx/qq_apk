package com.tencent.av.doodle;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.av.AVFunDrawing.DrawingInfo;
import com.tencent.av.AVFunDrawing.MessageBody;
import com.tencent.av.AVFunDrawing.PointInfo;
import com.tencent.av.AVFunDrawing.VersionInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class DoodleLogic
{
  private static DoodleLogic jdField_a_of_type_ComTencentAvDoodleDoodleLogic = null;
  static int f = 0;
  public float a;
  public int a;
  VideoController jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
  private DoodleLogic.DoodleLogicListener jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener = null;
  public final DoodleReportController a;
  ConcurrentLinkedQueue<DoodleItem> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  boolean jdField_a_of_type_Boolean = false;
  DoodleItem[] jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem = new DoodleItem[2];
  boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[2];
  public int b;
  ConcurrentLinkedQueue<DoodleLogic.SendItemInfo> b;
  public boolean b;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  
  public DoodleLogic()
  {
    this.jdField_a_of_type_Int = -65536;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvDoodleDoodleReportController = new DoodleReportController(this);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  }
  
  public static DoodleLogic a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAvDoodleDoodleLogic == null) {
        jdField_a_of_type_ComTencentAvDoodleDoodleLogic = new DoodleLogic();
      }
      return jdField_a_of_type_ComTencentAvDoodleDoodleLogic;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    DoodleItem localDoodleItem1 = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt];
    if (localDoodleItem1 != null)
    {
      localDoodleItem1.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener != null) {
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener.a(paramInt);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext())
      {
        DoodleItem localDoodleItem2 = (DoodleItem)localIterator.next();
        if (localDoodleItem1.jdField_a_of_type_Long - localDoodleItem2.jdField_a_of_type_Long <= 1200L) {
          localDoodleItem2.jdField_a_of_type_Long = localDoodleItem1.jdField_a_of_type_Long;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localDoodleItem1);
    }
    this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] = null;
    QLog.w("DoodleLogic", 1, "offerDoodle, index[" + paramInt + "], item[" + localDoodleItem1 + "], size[" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + "]");
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    DoodleItem localDoodleItem = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0];
    AVFunDrawing.PointInfo localPointInfo = new AVFunDrawing.PointInfo();
    localPointInfo.uint32_type.set(paramInt);
    AVFunDrawing.MessageBody localMessageBody = new AVFunDrawing.MessageBody();
    localMessageBody.uint32_msg_type.set(2);
    AVFunDrawing.DrawingInfo localDrawingInfo = new AVFunDrawing.DrawingInfo();
    if (localDoodleItem != null) {
      i = 1;
    }
    if (i != 0)
    {
      float f1 = localDoodleItem.jdField_a_of_type_AndroidGraphicsPointF.x;
      float f2 = localDoodleItem.jdField_a_of_type_AndroidGraphicsPointF.y;
      localPointInfo.float_x.set(f1);
      localPointInfo.float_y.set(f2);
      localDrawingInfo.uint32_pen_type.set(localDoodleItem.jdField_a_of_type_Int);
      localDrawingInfo.str_pen_name.set(localDoodleItem.jdField_b_of_type_JavaLangString);
      localDrawingInfo.str_pen_color.set("#" + Integer.toHexString(localDoodleItem.e));
      localDrawingInfo.uint32_pen_width.set(localDoodleItem.jdField_b_of_type_Int);
      localDrawingInfo.uint32_screen_width.set(localDoodleItem.c);
      localDrawingInfo.uint32_screen_height.set(localDoodleItem.d);
      localDrawingInfo.msg_point_info.add(localPointInfo);
      localMessageBody.drawingInfo.set(localDrawingInfo);
      i = a();
      localMessageBody.uint32_seq.set(i);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new DoodleLogic.SendItemInfo(localMessageBody));
      if (paramInt != 3) {
        break label290;
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 1) {
        a(100L);
      }
    }
    label290:
    while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() != 1)
    {
      return;
      SmallScreenUtils.a("没有doodleItem");
      break;
    }
    b();
  }
  
  int a()
  {
    try
    {
      f += 1;
      int i = f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    Object localObject1 = new AVFunDrawing.MessageBody();
    int j = 0;
    int i = 0;
    int n = i;
    int i1 = j;
    try
    {
      paramArrayOfByte = (AVFunDrawing.MessageBody)((AVFunDrawing.MessageBody)localObject1).mergeFrom(paramArrayOfByte);
      n = i;
      i1 = j;
      j = paramArrayOfByte.uint32_msg_type.get();
      switch (j)
      {
      case 1: 
        n = j;
        i1 = j;
        localObject1 = paramArrayOfByte.versionInfo;
        n = j;
        i1 = j;
        this.e = ((AVFunDrawing.VersionInfo)localObject1).uint32_version.get();
        n = j;
        i1 = j;
        if (((AVFunDrawing.VersionInfo)localObject1).uint32_support_drawing.get() == 0) {
          break label245;
        }
        bool = true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.w("DoodleLogic", 1, "receiveDoodle, InvalidProtocolBufferMicroException", paramArrayOfByte);
        return n;
        boolean bool = false;
      }
      n = j;
      i1 = j;
      localObject1 = paramArrayOfByte.drawingInfo;
      n = j;
      i1 = j;
      l1 = paramArrayOfByte.uint64_time.get();
      n = j;
      i1 = j;
      l2 = AudioHelper.a();
      if (l2 <= l1) {
        break label837;
      }
      k = (int)(l2 - l1);
      n = j;
      i1 = j;
      if (((AVFunDrawing.DrawingInfo)localObject1).msg_point_info.size() <= 0) {
        break label977;
      }
      n = j;
      i1 = j;
      localObject2 = (AVFunDrawing.PointInfo)((AVFunDrawing.DrawingInfo)localObject1).msg_point_info.get(0);
      n = j;
      i1 = j;
      m = ((AVFunDrawing.PointInfo)localObject2).uint32_type.get();
      n = j;
      i1 = j;
      f1 = ((AVFunDrawing.PointInfo)localObject2).float_x.get();
      n = j;
      i1 = j;
      f2 = ((AVFunDrawing.PointInfo)localObject2).float_y.get();
      n = j;
      i1 = j;
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1];
      if (m != 1) {
        break label850;
      }
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] = DoodleUtils.a(((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_type.get());
      i = m;
      n = j;
      i1 = j;
      QLog.w("DoodleLogic", 1, "receiveDoodle, point_type[" + m + "->" + i + "], pt[" + f1 + ", " + f2 + "], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "], offset[" + k + " = " + l2 + " - " + l1 + "], old[" + localObject2 + "], new[" + this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] + "]");
      n = j;
      i1 = j;
      if (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] == null) {
        break label1058;
      }
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].jdField_b_of_type_JavaLangString = ((AVFunDrawing.DrawingInfo)localObject1).str_pen_name.get();
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].e = Color.parseColor(((AVFunDrawing.DrawingInfo)localObject1).str_pen_color.get());
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].jdField_b_of_type_Int = ((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_width.get();
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].c = ((AVFunDrawing.DrawingInfo)localObject1).uint32_screen_width.get();
      n = j;
      i1 = j;
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].d = ((AVFunDrawing.DrawingInfo)localObject1).uint32_screen_height.get();
      switch (i)
      {
      case 1: 
        n = j;
        i1 = j;
        QLog.w("DoodleLogic", 1, "receiveDoodle, after[" + this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] + "]");
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("DoodleLogic", 1, "receiveDoodle, Exception", paramArrayOfByte);
      return i1;
    }
    n = j;
    i1 = j;
    this.jdField_b_of_type_Boolean = bool;
    n = j;
    i1 = j;
    QLog.w("DoodleLogic", 1, "receiveDoodle, mPeerVersion[" + this.e + "], mIsPeerSupport[" + this.jdField_b_of_type_Boolean + "], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "]");
    n = j;
    i1 = j;
    SmallScreenUtils.a();
    label1058:
    for (;;)
    {
      label245:
      long l1;
      long l2;
      Object localObject2;
      int m;
      float f1;
      float f2;
      label837:
      int k = 0 - (int)(l1 - l2);
      continue;
      label850:
      if (localObject2 == null)
      {
        n = j;
        i1 = j;
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] = DoodleUtils.a(((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_type.get());
        if (m == 2)
        {
          i = 1;
          continue;
          n = j;
          i1 = j;
          this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(161) });
          n = j;
          i1 = j;
          a(1, f1, f2);
          continue;
          n = j;
          i1 = j;
          b(1, f1, f2);
          continue;
          n = j;
          i1 = j;
          c(1, f1, f2);
          continue;
          n = j;
          i1 = j;
          QLog.w("DoodleLogic", 1, "receiveDoodle, msg_point_info[null], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "], offset[" + k + " = " + l2 + " - " + l1 + "]");
          return j;
          continue;
        }
        if (m != 3) {}
      }
      label977:
      i = m;
    }
  }
  
  public DoodleLogic.DoodleLogicListener a()
  {
    return this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0] = null;
    this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] = null;
    this.jdField_b_of_type_Boolean = false;
    this.e = 0;
    this.jdField_a_of_type_Int = -65536;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_ArrayOfBoolean[0] = false;
    this.jdField_a_of_type_ArrayOfBoolean[1] = false;
    int i = this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    QLog.w("DoodleLogic", 1, "resetDoodle, mSendQuene[" + i + "]", new Throwable("打印调用栈"));
  }
  
  void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0] = DoodleUtils.a(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0].e = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0].jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0].c = this.c;
          this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0].d = this.d;
        }
        QLog.w("DoodleLogic", 1, "touch_start, index[" + paramInt + "], item[" + this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] + "], pt[" + paramFloat1 + ", " + paramFloat2 + "]");
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].a(paramFloat1, paramFloat2);
        if (this.jdField_a_of_type_Boolean) {
          b(1);
        }
        if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener != null) {
          this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener.invalidate();
        }
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      bool = false;
    }
  }
  
  void a(long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w("DoodleLogic", 1, "startSendDoodleHandle, delayMillis[" + paramLong + "]");
    }
    ThreadManager.getUIHandler().postDelayed(new DoodleLogic.1(this), paramLong);
  }
  
  void a(DoodleLogic.DoodleLogicListener paramDoodleLogicListener)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener = paramDoodleLogicListener;
  }
  
  public boolean a()
  {
    return this.e > 0;
  }
  
  void b()
  {
    DoodleLogic.SendItemInfo localSendItemInfo = (DoodleLogic.SendItemInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localSendItemInfo == null) {
      QLog.w("DoodleLogic", 1, "sendDoodle, 结束");
    }
    do
    {
      return;
      AVFunDrawing.MessageBody localMessageBody = localSendItemInfo.jdField_a_of_type_ComTencentAvAVFunDrawing$MessageBody;
      long l = AudioHelper.a();
      localMessageBody.uint64_time.set(l);
      Object localObject = localMessageBody.toByteArray();
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
      localObject = (AVFunDrawing.PointInfo)((AVFunDrawing.DrawingInfo)localMessageBody.drawingInfo.get()).msg_point_info.get(0);
      float f1 = ((AVFunDrawing.PointInfo)localObject).float_x.get();
      float f2 = ((AVFunDrawing.PointInfo)localObject).float_y.get();
      int i = ((AVFunDrawing.PointInfo)localObject).uint32_type.get();
      QLog.w("DoodleLogic", 1, "sendDoodle, sendtime[" + l + "], offset[" + (l - localSendItemInfo.jdField_a_of_type_Long) + "], pt[" + f1 + ", " + f2 + "], uint32_type[" + i + "], uint32_seq[" + localMessageBody.uint32_seq.get() + "], size[" + this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + "]");
    } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() <= 0);
    a(1L);
  }
  
  /* Error */
  void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 419	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 42	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem	[Lcom/tencent/av/doodle/DoodleItem;
    //   11: iload_1
    //   12: aaload
    //   13: ifnull +58 -> 71
    //   16: aload_0
    //   17: getfield 42	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem	[Lcom/tencent/av/doodle/DoodleItem;
    //   20: iload_1
    //   21: aaload
    //   22: fload_2
    //   23: fload_3
    //   24: invokevirtual 480	com/tencent/av/doodle/DoodleItem:a	(FF)Z
    //   27: ifeq +44 -> 71
    //   30: iload_1
    //   31: ifne +48 -> 79
    //   34: iconst_1
    //   35: istore 4
    //   37: aload_0
    //   38: iload 4
    //   40: putfield 44	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_Boolean	Z
    //   43: aload_0
    //   44: getfield 44	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_Boolean	Z
    //   47: ifeq +8 -> 55
    //   50: aload_0
    //   51: iconst_2
    //   52: invokespecial 426	com/tencent/av/doodle/DoodleLogic:b	(I)V
    //   55: aload_0
    //   56: getfield 46	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener	Lcom/tencent/av/doodle/DoodleLogic$DoodleLogicListener;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 46	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener	Lcom/tencent/av/doodle/DoodleLogic$DoodleLogicListener;
    //   66: invokeinterface 429 1 0
    //   71: aload_0
    //   72: getfield 63	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   75: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   78: return
    //   79: iconst_0
    //   80: istore 4
    //   82: goto -45 -> 37
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 63	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload 5
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	DoodleLogic
    //   0	97	1	paramInt	int
    //   0	97	2	paramFloat1	float
    //   0	97	3	paramFloat2	float
    //   35	46	4	bool	boolean
    //   85	10	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	30	85	finally
    //   37	55	85	finally
    //   55	71	85	finally
  }
  
  public void b(long paramLong)
  {
    DoodleItem[] arrayOfDoodleItem = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem;
    int j = arrayOfDoodleItem.length;
    int i = 0;
    while (i < j)
    {
      DoodleItem localDoodleItem = arrayOfDoodleItem[i];
      if (localDoodleItem != null) {
        localDoodleItem.a(paramLong);
      }
      i += 1;
    }
  }
  
  public void c()
  {
    boolean bool = DoodleUtils.a();
    Object localObject = new AVFunDrawing.MessageBody();
    ((AVFunDrawing.MessageBody)localObject).uint32_msg_type.set(1);
    AVFunDrawing.VersionInfo localVersionInfo = new AVFunDrawing.VersionInfo();
    localVersionInfo.uint32_version.set(1);
    PBUInt32Field localPBUInt32Field = localVersionInfo.uint32_support_drawing;
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      ((AVFunDrawing.MessageBody)localObject).versionInfo.set(localVersionInfo);
      i = a();
      ((AVFunDrawing.MessageBody)localObject).uint32_seq.set(i);
      localObject = ((AVFunDrawing.MessageBody)localObject).toByteArray();
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
      QLog.w("DoodleLogic", 1, "sendSelfIsSupport, isSelfSupport[" + bool + "], uint32_seq[" + i + "]");
      SmallScreenUtils.a();
      return;
    }
  }
  
  void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] == null) {
          break label170;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].c(paramFloat1, paramFloat2);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        b(3);
      }
      QLog.w("DoodleLogic", 1, "touch_up, index[" + paramInt + "], item[" + this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] + "], pt[" + paramFloat1 + ", " + paramFloat2 + "]");
      a(paramInt);
      if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener != null) {
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener.invalidate();
      }
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = false;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return;
      bool = false;
      continue;
      label170:
      if (paramInt != 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleLogic
 * JD-Core Version:    0.7.0.1
 */