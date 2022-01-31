import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class beqm
  extends bffl
  implements Handler.Callback, beho
{
  public static final String TAG = "AppRuntimeLoader";
  private boolean isSucceed;
  private Map<String, bffi> mActivatedTasks;
  private final beqi mAppStateManager;
  protected Context mContext;
  private final beqc mEventCenter;
  protected Handler mHandler;
  protected boolean mIsRunning;
  protected MiniAppInfo mMiniAppInfo;
  protected behn mRuntime;
  protected beqo mRuntimeLoadListener;
  protected boolean runtimeLoadCompleted;
  
  /* Error */
  public beqm(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	bffl:<init>	()V
    //   4: aload_0
    //   5: new 42	beqc
    //   8: dup
    //   9: invokespecial 43	beqc:<init>	()V
    //   12: putfield 45	beqm:mEventCenter	Lbeqc;
    //   15: aload_0
    //   16: new 47	beqi
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 50	beqi:<init>	(Lbeqm;)V
    //   24: putfield 52	beqm:mAppStateManager	Lbeqi;
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 54	beqm:mContext	Landroid/content/Context;
    //   32: aload_0
    //   33: new 56	java/util/HashMap
    //   36: dup
    //   37: invokespecial 57	java/util/HashMap:<init>	()V
    //   40: putfield 59	beqm:mActivatedTasks	Ljava/util/Map;
    //   43: aload_0
    //   44: getfield 45	beqm:mEventCenter	Lbeqc;
    //   47: aload_0
    //   48: getfield 52	beqm:mAppStateManager	Lbeqi;
    //   51: invokevirtual 63	beqc:addObserver	(Ljava/util/Observer;)V
    //   54: new 65	android/os/HandlerThread
    //   57: dup
    //   58: ldc 12
    //   60: iconst_5
    //   61: invokespecial 68	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 71	android/os/HandlerThread:start	()V
    //   71: aload_2
    //   72: ifnull +31 -> 103
    //   75: aload_2
    //   76: invokevirtual 75	android/os/HandlerThread:isAlive	()Z
    //   79: ifeq +24 -> 103
    //   82: aload_0
    //   83: new 77	android/os/Handler
    //   86: dup
    //   87: aload_2
    //   88: invokevirtual 81	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   91: aload_0
    //   92: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   95: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   98: aload_0
    //   99: invokespecial 89	beqm:initTask	()V
    //   102: return
    //   103: aload_0
    //   104: new 77	android/os/Handler
    //   107: dup
    //   108: invokestatic 94	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   111: aload_0
    //   112: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   115: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   118: goto -20 -> 98
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: ldc 12
    //   128: ldc 96
    //   130: aload_3
    //   131: invokestatic 102	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_2
    //   135: ifnull +29 -> 164
    //   138: aload_2
    //   139: invokevirtual 75	android/os/HandlerThread:isAlive	()Z
    //   142: ifeq +22 -> 164
    //   145: aload_0
    //   146: new 77	android/os/Handler
    //   149: dup
    //   150: aload_2
    //   151: invokevirtual 81	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   154: aload_0
    //   155: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   158: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   161: goto -63 -> 98
    //   164: aload_0
    //   165: new 77	android/os/Handler
    //   168: dup
    //   169: invokestatic 94	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   172: aload_0
    //   173: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   176: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   179: goto -81 -> 98
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +28 -> 214
    //   189: aload_1
    //   190: invokevirtual 75	android/os/HandlerThread:isAlive	()Z
    //   193: ifeq +21 -> 214
    //   196: aload_0
    //   197: new 77	android/os/Handler
    //   200: dup
    //   201: aload_1
    //   202: invokevirtual 81	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   205: aload_0
    //   206: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   209: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   212: aload_2
    //   213: athrow
    //   214: aload_0
    //   215: new 77	android/os/Handler
    //   218: dup
    //   219: invokestatic 94	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   222: aload_0
    //   223: invokespecial 84	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   226: putfield 86	beqm:mHandler	Landroid/os/Handler;
    //   229: goto -17 -> 212
    //   232: astore_2
    //   233: goto -48 -> 185
    //   236: astore_3
    //   237: goto -113 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	beqm
    //   0	240	1	paramContext	Context
    //   64	87	2	localHandlerThread	android.os.HandlerThread
    //   182	31	2	localObject1	Object
    //   232	1	2	localObject2	Object
    //   121	10	3	localException1	java.lang.Exception
    //   236	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   54	65	121	java/lang/Exception
    //   54	65	182	finally
    //   67	71	232	finally
    //   126	134	232	finally
    //   67	71	236	java/lang/Exception
  }
  
  private final void initTask()
  {
    bffi[] arrayOfbffi = createTasks();
    initTasks(arrayOfbffi);
    if (arrayOfbffi != null)
    {
      int j = arrayOfbffi.length;
      int i = 0;
      while (i < j)
      {
        registTaskName(arrayOfbffi[i]);
        i += 1;
      }
    }
  }
  
  private void registTaskName(bffi parambffi)
  {
    if (parambffi == null) {}
    for (;;)
    {
      return;
      addTask(parambffi);
      parambffi = parambffi.a();
      if ((parambffi != null) && (parambffi.size() > 0))
      {
        parambffi = parambffi.iterator();
        while (parambffi.hasNext()) {
          registTaskName((bffi)parambffi.next());
        }
      }
    }
  }
  
  public void addRuntimeStateObserver(beqe parambeqe)
  {
    this.mEventCenter.addObserver(parambeqe);
  }
  
  public void addTask(bffi parambffi)
  {
    if (parambffi == null) {
      return;
    }
    String str = parambffi.getClass().getCanonicalName();
    if (this.mActivatedTasks.containsKey(str))
    {
      betc.c("AppRuntimeLoader", "Failed to add task: duplicated " + str);
      return;
    }
    this.mActivatedTasks.put(str, parambffi);
  }
  
  public void addTasks(bffi... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        addTask(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public abstract bffi[] createTasks();
  
  public boolean dismissLoadingAfterLoaded()
  {
    return true;
  }
  
  public beqi getAppStateManager()
  {
    return this.mAppStateManager;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public MiniAppInfo getMiniAppInfoForReport()
  {
    if (this.mMiniAppInfo == null) {
      return beze.a();
    }
    return this.mMiniAppInfo;
  }
  
  public behn getRuntime()
  {
    return this.mRuntime;
  }
  
  public bffi getTask(Class paramClass)
  {
    return (bffi)this.mActivatedTasks.get(paramClass.getCanonicalName());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    betc.a("AppRuntimeLoader", "handleMessage " + paramMessage.what);
    return false;
  }
  
  public boolean isLoadSucceed()
  {
    return (this.runtimeLoadCompleted) && (this.isSucceed);
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    beqd localbeqd = beqd.a(paramInt, this);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localbeqd.a = paramVarArgs[0];
    }
    this.mEventCenter.a(localbeqd);
  }
  
  protected void onRuntimeLoadResult(int paramInt, String paramString)
  {
    boolean bool = true;
    this.runtimeLoadCompleted = true;
    if (paramInt == 0) {}
    for (;;)
    {
      this.isSucceed = bool;
      if (this.mRuntimeLoadListener != null) {
        this.mRuntimeLoadListener.a(paramInt, paramString, this);
      }
      return;
      bool = false;
    }
  }
  
  public void onRuntimeMessage(int paramInt, Object paramObject)
  {
    notifyRuntimeEvent(paramInt, new Object[] { paramObject });
    if ((paramInt == 10) && (!this.runtimeLoadCompleted)) {
      onRuntimeLoadResult(0, "");
    }
  }
  
  public void onTaskDone(bffi parambffi)
  {
    super.onTaskDone(parambffi);
  }
  
  public void removeRuntimeStateObserver(beqe parambeqe)
  {
    this.mEventCenter.deleteObserver(parambeqe);
  }
  
  public void setRuntimeLoadListener(beqo parambeqo)
  {
    this.mRuntimeLoadListener = parambeqo;
  }
  
  public void start()
  {
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    this.runtimeLoadCompleted = false;
    this.isSucceed = false;
    super.start();
    notifyRuntimeEvent(2, new Object[0]);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{Runtime:");
    if (this.mRuntime != null)
    {
      str = this.mRuntime.getClass().getSimpleName() + "@" + this.mRuntime.hashCode();
      localStringBuilder = localStringBuilder.append(str).append(" AppInfo=");
      if (this.mMiniAppInfo == null) {
        break label110;
      }
    }
    label110:
    for (String str = this.mMiniAppInfo.toSimpleString();; str = "N/A")
    {
      return str + "}";
      str = "N/A";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqm
 * JD-Core Version:    0.7.0.1
 */