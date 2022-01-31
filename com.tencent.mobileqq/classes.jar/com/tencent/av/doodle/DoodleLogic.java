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
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class DoodleLogic
{
  private static DoodleLogic jdField_a_of_type_ComTencentAvDoodleDoodleLogic;
  public float a;
  public int a;
  VideoController jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
  private DoodleLogic.DoodleLogicListener jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener;
  public DoodleReportController a;
  ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  boolean jdField_a_of_type_Boolean = false;
  DoodleItem[] jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem = new DoodleItem[2];
  boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[2];
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  
  public DoodleLogic()
  {
    this.jdField_a_of_type_Int = -65536;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_ComTencentAvDoodleDoodleReportController = new DoodleReportController(this);
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
    if (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] != null)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener != null) {
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener.a(paramInt);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext())
      {
        DoodleItem localDoodleItem = (DoodleItem)localIterator.next();
        if (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].jdField_a_of_type_Long - localDoodleItem.jdField_a_of_type_Long <= 1200L) {
          localDoodleItem.jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt].jdField_a_of_type_Long;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt]);
    }
    this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] = null;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[0];
    if (localObject != null)
    {
      float f1 = ((DoodleItem)localObject).jdField_a_of_type_AndroidGraphicsPointF.x;
      float f2 = ((DoodleItem)localObject).jdField_a_of_type_AndroidGraphicsPointF.y;
      AVFunDrawing.PointInfo localPointInfo = new AVFunDrawing.PointInfo();
      localPointInfo.float_x.set(f1);
      localPointInfo.float_y.set(f2);
      localPointInfo.uint32_type.set(paramInt);
      AVFunDrawing.MessageBody localMessageBody = new AVFunDrawing.MessageBody();
      localMessageBody.uint32_msg_type.set(2);
      AVFunDrawing.DrawingInfo localDrawingInfo = new AVFunDrawing.DrawingInfo();
      localDrawingInfo.uint32_pen_type.set(((DoodleItem)localObject).jdField_a_of_type_Int);
      localDrawingInfo.str_pen_name.set(((DoodleItem)localObject).jdField_a_of_type_JavaLangString);
      localDrawingInfo.str_pen_color.set("#" + Integer.toHexString(((DoodleItem)localObject).e));
      localDrawingInfo.uint32_pen_width.set(((DoodleItem)localObject).jdField_b_of_type_Int);
      localDrawingInfo.uint32_screen_width.set(((DoodleItem)localObject).c);
      localDrawingInfo.uint32_screen_height.set(((DoodleItem)localObject).d);
      localDrawingInfo.msg_point_info.add(localPointInfo);
      localMessageBody.drawingInfo.set(localDrawingInfo);
      localObject = localMessageBody.toByteArray();
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    Object localObject = new AVFunDrawing.MessageBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (AVFunDrawing.MessageBody)((AVFunDrawing.MessageBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_msg_type.get();
        switch (i)
        {
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        float f1;
        float f2;
        j = 0;
        continue;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int j = 0;
        continue;
        continue;
        continue;
      }
      return i;
      try
      {
        paramArrayOfByte = paramArrayOfByte.versionInfo;
        this.e = paramArrayOfByte.uint32_version.get();
        if (paramArrayOfByte.uint32_support_drawing.get() != 0) {
          bool = true;
        }
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.e("DoodleLogic", 2, "WL_DEBUG receive mPeerVersion = " + this.e + ", mIsPeerSupport = " + this.jdField_b_of_type_Boolean);
        }
        SmallScreenUtils.a();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        j = i;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DoodleLogic", 2, "WL_DEBUG receive e = " + paramArrayOfByte);
        return j;
        paramArrayOfByte = paramArrayOfByte.drawingInfo;
        if (paramArrayOfByte.msg_point_info.size() <= 0) {
          continue;
        }
        localObject = (AVFunDrawing.PointInfo)paramArrayOfByte.msg_point_info.get(0);
        j = ((AVFunDrawing.PointInfo)localObject).uint32_type.get();
        f1 = ((AVFunDrawing.PointInfo)localObject).float_x.get();
        f2 = ((AVFunDrawing.PointInfo)localObject).float_y.get();
        if ((j != 1) && (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] != null)) {
          continue;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1] = DoodleUtils.a(paramArrayOfByte.uint32_pen_type.get());
        if (j == 1) {
          continue;
        }
        j = 3;
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].jdField_a_of_type_JavaLangString = paramArrayOfByte.str_pen_name.get();
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].e = Color.parseColor(paramArrayOfByte.str_pen_color.get());
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].jdField_b_of_type_Int = paramArrayOfByte.uint32_pen_width.get();
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].c = paramArrayOfByte.uint32_screen_width.get();
        this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[1].d = paramArrayOfByte.uint32_screen_height.get();
        switch (j)
        {
        case 1: 
          this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(161) });
          a(1, f1, f2);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        j = i;
        i = j;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("DoodleLogic", 2, "WL_DEBUG receive e = " + paramArrayOfByte);
        return j;
        b(1, f1, f2);
        continue;
        c(1, f1, f2);
      }
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
    if (QLog.isColorLevel()) {
      QLog.e("DoodleLogic", 2, "WL_DEBUG reset mPeerVersion = " + this.e + ", mIsPeerSupport = " + this.jdField_b_of_type_Boolean);
    }
    SmallScreenUtils.a();
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
  
  public void a(long paramLong)
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
  
  void a(DoodleLogic.DoodleLogicListener paramDoodleLogicListener)
  {
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener = paramDoodleLogicListener;
  }
  
  public boolean a()
  {
    return this.e > 0;
  }
  
  public void b()
  {
    int i = 1;
    boolean bool = DoodleUtils.a();
    Object localObject = new AVFunDrawing.MessageBody();
    ((AVFunDrawing.MessageBody)localObject).uint32_msg_type.set(1);
    AVFunDrawing.VersionInfo localVersionInfo = new AVFunDrawing.VersionInfo();
    localVersionInfo.uint32_version.set(1);
    PBUInt32Field localPBUInt32Field = localVersionInfo.uint32_support_drawing;
    if (bool) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      ((AVFunDrawing.MessageBody)localObject).versionInfo.set(localVersionInfo);
      localObject = ((AVFunDrawing.MessageBody)localObject).toByteArray();
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.e("DoodleLogic", 2, "WL_DEBUG sendSelfIsSupport isSelfSupport = " + bool);
      }
      SmallScreenUtils.a();
      return;
      i = 0;
    }
  }
  
  /* Error */
  void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 333	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 33	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem	[Lcom/tencent/av/doodle/DoodleItem;
    //   11: iload_1
    //   12: aaload
    //   13: ifnull +58 -> 71
    //   16: aload_0
    //   17: getfield 33	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem	[Lcom/tencent/av/doodle/DoodleItem;
    //   20: iload_1
    //   21: aaload
    //   22: fload_2
    //   23: fload_3
    //   24: invokevirtual 359	com/tencent/av/doodle/DoodleItem:a	(FF)Z
    //   27: ifeq +44 -> 71
    //   30: iload_1
    //   31: ifne +48 -> 79
    //   34: iconst_1
    //   35: istore 4
    //   37: aload_0
    //   38: iload 4
    //   40: putfield 35	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_Boolean	Z
    //   43: aload_0
    //   44: getfield 35	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_Boolean	Z
    //   47: ifeq +8 -> 55
    //   50: aload_0
    //   51: iconst_2
    //   52: invokespecial 340	com/tencent/av/doodle/DoodleLogic:b	(I)V
    //   55: aload_0
    //   56: getfield 81	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener	Lcom/tencent/av/doodle/DoodleLogic$DoodleLogicListener;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 81	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener	Lcom/tencent/av/doodle/DoodleLogic$DoodleLogicListener;
    //   66: invokeinterface 343 1 0
    //   71: aload_0
    //   72: getfield 48	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   75: invokevirtual 346	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   78: return
    //   79: iconst_0
    //   80: istore 4
    //   82: goto -45 -> 37
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 48	com/tencent/av/doodle/DoodleLogic:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 346	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
  
  void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvDoodleDoodleItem[paramInt] == null) {
          break label99;
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
      a(paramInt);
      if (this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener != null) {
        this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic$DoodleLogicListener.invalidate();
      }
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = false;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return;
      label99:
      if (paramInt == 0) {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleLogic
 * JD-Core Version:    0.7.0.1
 */