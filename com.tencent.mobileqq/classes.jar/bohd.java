import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.QIMAsyncManager.1;

public abstract class bohd
  extends bogb
{
  private static final String TAG = "QIMAsyncManager";
  private volatile boolean inited;
  
  /* Error */
  public void forceInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	bohd:inited	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 25	bohd:initIndeed	()V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 19	bohd:inited	Z
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bohd
    //   6	2	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public abstract void initIndeed();
  
  public void onDestroy() {}
  
  public void onInit()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = this.inited;
        if (bool2) {
          return;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (boha.a(bool1)) {
            continue;
          }
          QIMAsyncManager.1 local1 = new QIMAsyncManager.1(this);
          if (QLog.isDevelopLevel()) {
            QLog.d("QIMAsyncManager", 4, new Object[] { "onInit, async:", Boolean.valueOf(bool1) });
          }
          if (!bool1) {
            break label94;
          }
          ThreadManager.excute(local1, 64, null, false);
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label94:
      localObject.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohd
 * JD-Core Version:    0.7.0.1
 */