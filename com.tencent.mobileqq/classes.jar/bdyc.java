import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.1;
import com.tencent.qqmini.sdk.task.TaskFlowEngine.2;
import java.util.Iterator;
import java.util.List;

public class bdyc
  implements Handler.Callback, bdya
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  private List<bdxz> mAllTasks;
  protected Handler mEngineHandler;
  private List<bdyd> mFlows;
  private bdxz[] mTasks;
  
  /* Error */
  public bdyc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 34	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 35	java/util/ArrayList:<init>	()V
    //   12: putfield 37	bdyc:mFlows	Ljava/util/List;
    //   15: aload_0
    //   16: new 34	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 35	java/util/ArrayList:<init>	()V
    //   23: putfield 39	bdyc:mAllTasks	Ljava/util/List;
    //   26: new 41	android/os/HandlerThread
    //   29: dup
    //   30: ldc 17
    //   32: iconst_5
    //   33: invokespecial 44	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 47	android/os/HandlerThread:start	()V
    //   43: aload_2
    //   44: ifnull +27 -> 71
    //   47: aload_2
    //   48: invokevirtual 51	android/os/HandlerThread:isAlive	()Z
    //   51: ifeq +20 -> 71
    //   54: aload_0
    //   55: new 53	android/os/Handler
    //   58: dup
    //   59: aload_2
    //   60: invokevirtual 57	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   63: aload_0
    //   64: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   67: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   70: return
    //   71: aload_0
    //   72: new 53	android/os/Handler
    //   75: dup
    //   76: invokestatic 67	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   79: aload_0
    //   80: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   83: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   86: return
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: ldc 17
    //   94: ldc 69
    //   96: aload_3
    //   97: invokestatic 75	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_2
    //   101: ifnull +27 -> 128
    //   104: aload_2
    //   105: invokevirtual 51	android/os/HandlerThread:isAlive	()Z
    //   108: ifeq +20 -> 128
    //   111: aload_0
    //   112: new 53	android/os/Handler
    //   115: dup
    //   116: aload_2
    //   117: invokevirtual 57	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   120: aload_0
    //   121: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   124: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   127: return
    //   128: aload_0
    //   129: new 53	android/os/Handler
    //   132: dup
    //   133: invokestatic 67	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   136: aload_0
    //   137: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   140: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   143: return
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +28 -> 176
    //   151: aload_1
    //   152: invokevirtual 51	android/os/HandlerThread:isAlive	()Z
    //   155: ifeq +21 -> 176
    //   158: aload_0
    //   159: new 53	android/os/Handler
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual 57	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   167: aload_0
    //   168: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   171: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   174: aload_2
    //   175: athrow
    //   176: aload_0
    //   177: new 53	android/os/Handler
    //   180: dup
    //   181: invokestatic 67	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   184: aload_0
    //   185: invokespecial 60	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   188: putfield 62	bdyc:mEngineHandler	Landroid/os/Handler;
    //   191: goto -17 -> 174
    //   194: astore_2
    //   195: goto -48 -> 147
    //   198: astore_3
    //   199: goto -109 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	bdyc
    //   38	126	1	localHandlerThread1	android.os.HandlerThread
    //   36	81	2	localHandlerThread2	android.os.HandlerThread
    //   144	31	2	localObject1	Object
    //   194	1	2	localObject2	Object
    //   87	10	3	localException1	java.lang.Exception
    //   198	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	37	87	java/lang/Exception
    //   26	37	144	finally
    //   39	43	194	finally
    //   92	100	194	finally
    //   39	43	198	java/lang/Exception
  }
  
  private void executeTask(bdxz parambdxz)
  {
    if (parambdxz == null) {
      return;
    }
    List localList = parambdxz.a();
    if ((localList == null) || (localList.size() <= 0))
    {
      parambdxz.e();
      return;
    }
    Iterator localIterator = this.mFlows.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((bdyd)localIterator.next()).a != parambdxz);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        parambdxz = new bdyd(this, parambdxz, localList);
        this.mFlows.add(parambdxz);
      }
      parambdxz = localList.iterator();
      while (parambdxz.hasNext()) {
        executeTask((bdxz)parambdxz.next());
      }
      break;
    }
  }
  
  private void initCallback(bdxz parambdxz)
  {
    if (parambdxz == null) {}
    for (;;)
    {
      return;
      parambdxz.a(this);
      parambdxz.a(this.mEngineHandler.getLooper());
      if (!this.mAllTasks.contains(parambdxz)) {
        this.mAllTasks.add(parambdxz);
      }
      parambdxz = parambdxz.a();
      if ((parambdxz != null) && (parambdxz.size() > 0))
      {
        parambdxz = parambdxz.iterator();
        while (parambdxz.hasNext()) {
          initCallback((bdxz)parambdxz.next());
        }
      }
    }
  }
  
  public Looper getWorkThreadLooper()
  {
    return this.mEngineHandler.getLooper();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(bdxz[] paramArrayOfbdxz)
  {
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfbdxz;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfbdxz = this.mTasks;
      int j = paramArrayOfbdxz.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfbdxz[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(bdxz parambdxz) {}
  
  public void onTaskDone(bdxz parambdxz)
  {
    if (parambdxz == null) {}
    while (!parambdxz.d()) {
      return;
    }
    this.mEngineHandler.post(new TaskFlowEngine.2(this, parambdxz));
  }
  
  protected void resetTaskAndDepends(bdxz parambdxz)
  {
    if (parambdxz == null) {}
    for (;;)
    {
      return;
      parambdxz.b();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        bdxz localbdxz = (bdxz)localIterator.next();
        if (localbdxz.a(parambdxz)) {
          localbdxz.b();
        }
      }
    }
  }
  
  public void start()
  {
    if ((this.mTasks == null) || (this.mTasks.length <= 0)) {
      return;
    }
    this.mEngineHandler.post(new TaskFlowEngine.1(this));
  }
  
  public void updateFlow(bdxz parambdxz)
  {
    Iterator localIterator = this.mFlows.iterator();
    while (localIterator.hasNext())
    {
      bdyd localbdyd = (bdyd)localIterator.next();
      if (localbdyd.a(parambdxz)) {
        localbdyd.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyc
 * JD-Core Version:    0.7.0.1
 */