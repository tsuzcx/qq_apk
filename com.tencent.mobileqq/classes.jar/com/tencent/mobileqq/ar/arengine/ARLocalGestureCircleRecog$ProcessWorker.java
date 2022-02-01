package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

class ARLocalGestureCircleRecog$ProcessWorker
  extends Thread
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[ARLocalGestureCircleRecog.a(this.this$0) * ARLocalGestureCircleRecog.b(this.this$0) * 3 / 2];
  private boolean b = true;
  
  public ARLocalGestureCircleRecog$ProcessWorker(ARLocalGestureCircleRecog paramARLocalGestureCircleRecog)
  {
    setDaemon(true);
    start();
  }
  
  public void a()
  {
    this.b = false;
    if (getState() == Thread.State.WAITING) {
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (getState() == Thread.State.WAITING)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  public void run()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        setName("ARLocalGestureCircleRecogProcessWorker");
        if (!this.b) {
          break label60;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = this.b;
          if (bool)
          {
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            continue;
          }
        }
        bool = this.b;
      }
      finally {}
      if (!bool) {
        label60:
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      synchronized (ARLocalGestureCircleRecog.a(this.this$0))
      {
        ARLocalGestureCircleRecog.a(this.this$0, true);
        try
        {
          ARLocalGestureCircleRecogResult localARLocalGestureCircleRecogResult = this.this$0.a(this.jdField_a_of_type_ArrayOfByte, ARLocalGestureCircleRecog.a(this.this$0), ARLocalGestureCircleRecog.b(this.this$0), 17);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. recogResult = " + localARLocalGestureCircleRecogResult + ",mRecogResult.gestureResult.mode = " + ARLocalGestureCircleRecog.a(this.this$0).a.d);
          if ((ARLocalGestureCircleRecog.a(this.this$0)) && (!ARLocalGestureCircleRecog.b(this.this$0)) && (ARLocalGestureCircleRecog.a(this.this$0) != null) && (ARLocalGestureCircleRecog.a(this.this$0).a.d == 0)) {
            ARLocalGestureCircleRecog.a(this.this$0).a(localARLocalGestureCircleRecogResult);
          }
          ARLocalGestureCircleRecog.a(this.this$0, false);
          yield();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalGestureCircleRecog", 2, "Exception", localException);
            }
            ARLocalGestureCircleRecog.a(this.this$0, false);
          }
        }
        finally
        {
          ARLocalGestureCircleRecog.a(this.this$0, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog.ProcessWorker
 * JD-Core Version:    0.7.0.1
 */