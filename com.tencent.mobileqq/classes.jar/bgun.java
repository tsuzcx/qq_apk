import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class bgun
  extends bhlx
  implements Handler.Callback, bglt
{
  public static final String TAG = "BaseRuntimeLoader";
  private boolean hasTaskFailed;
  private boolean isSucceed;
  private Map<String, bhlu> mActivatedTasks;
  private final bguj mAppStateManager;
  protected Context mContext;
  private final bgue mEventCenter;
  protected Handler mHandler;
  protected boolean mIsRunning;
  protected MiniAppInfo mMiniAppInfo;
  protected bgls mRuntime;
  protected bgup mRuntimeLoadListener;
  protected boolean runtimeLoadCompleted;
  
  /* Error */
  public bgun(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 41	bhlx:<init>	()V
    //   4: aload_0
    //   5: new 43	bgue
    //   8: dup
    //   9: invokespecial 44	bgue:<init>	()V
    //   12: putfield 46	bgun:mEventCenter	Lbgue;
    //   15: aload_0
    //   16: new 48	bguj
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 51	bguj:<init>	(Lbgun;)V
    //   24: putfield 53	bgun:mAppStateManager	Lbguj;
    //   27: aload_0
    //   28: aload_1
    //   29: putfield 55	bgun:mContext	Landroid/content/Context;
    //   32: aload_0
    //   33: new 57	java/util/HashMap
    //   36: dup
    //   37: invokespecial 58	java/util/HashMap:<init>	()V
    //   40: putfield 60	bgun:mActivatedTasks	Ljava/util/Map;
    //   43: aload_0
    //   44: getfield 46	bgun:mEventCenter	Lbgue;
    //   47: aload_0
    //   48: getfield 53	bgun:mAppStateManager	Lbguj;
    //   51: invokevirtual 64	bgue:addObserver	(Ljava/util/Observer;)V
    //   54: new 66	android/os/HandlerThread
    //   57: dup
    //   58: ldc 68
    //   60: iconst_5
    //   61: invokespecial 71	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 74	android/os/HandlerThread:start	()V
    //   71: aload_2
    //   72: ifnull +31 -> 103
    //   75: aload_2
    //   76: invokevirtual 78	android/os/HandlerThread:isAlive	()Z
    //   79: ifeq +24 -> 103
    //   82: aload_0
    //   83: new 80	android/os/Handler
    //   86: dup
    //   87: aload_2
    //   88: invokevirtual 84	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   91: aload_0
    //   92: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   95: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   98: aload_0
    //   99: invokespecial 92	bgun:initTask	()V
    //   102: return
    //   103: aload_0
    //   104: new 80	android/os/Handler
    //   107: dup
    //   108: invokestatic 97	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   111: aload_0
    //   112: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   115: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   118: goto -20 -> 98
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: ldc 12
    //   128: ldc 99
    //   130: aload_3
    //   131: invokestatic 105	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_2
    //   135: ifnull +29 -> 164
    //   138: aload_2
    //   139: invokevirtual 78	android/os/HandlerThread:isAlive	()Z
    //   142: ifeq +22 -> 164
    //   145: aload_0
    //   146: new 80	android/os/Handler
    //   149: dup
    //   150: aload_2
    //   151: invokevirtual 84	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   154: aload_0
    //   155: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   158: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   161: goto -63 -> 98
    //   164: aload_0
    //   165: new 80	android/os/Handler
    //   168: dup
    //   169: invokestatic 97	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   172: aload_0
    //   173: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   176: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   179: goto -81 -> 98
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +28 -> 214
    //   189: aload_1
    //   190: invokevirtual 78	android/os/HandlerThread:isAlive	()Z
    //   193: ifeq +21 -> 214
    //   196: aload_0
    //   197: new 80	android/os/Handler
    //   200: dup
    //   201: aload_1
    //   202: invokevirtual 84	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   205: aload_0
    //   206: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   209: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   212: aload_2
    //   213: athrow
    //   214: aload_0
    //   215: new 80	android/os/Handler
    //   218: dup
    //   219: invokestatic 97	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   222: aload_0
    //   223: invokespecial 87	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   226: putfield 89	bgun:mHandler	Landroid/os/Handler;
    //   229: goto -17 -> 212
    //   232: astore_2
    //   233: goto -48 -> 185
    //   236: astore_3
    //   237: goto -113 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	bgun
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
    bhlu[] arrayOfbhlu = createTasks();
    initTasks(arrayOfbhlu);
    if (arrayOfbhlu != null)
    {
      int j = arrayOfbhlu.length;
      int i = 0;
      while (i < j)
      {
        registTaskName(arrayOfbhlu[i]);
        i += 1;
      }
    }
  }
  
  private void registTaskName(bhlu parambhlu)
  {
    if (parambhlu == null) {}
    for (;;)
    {
      return;
      addTask(parambhlu);
      parambhlu = parambhlu.a();
      if ((parambhlu != null) && (parambhlu.size() > 0))
      {
        parambhlu = parambhlu.iterator();
        while (parambhlu.hasNext()) {
          registTaskName((bhlu)parambhlu.next());
        }
      }
    }
  }
  
  /* Error */
  private void restartFailTaskIfNeed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	bgun:hasTaskFailed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 149	bgun:hasTaskFailed	Z
    //   19: aload_0
    //   20: getfield 153	bgun:mAllTasks	Ljava/util/List;
    //   23: invokeinterface 137 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 142 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_2
    //   39: invokeinterface 146 1 0
    //   44: checkcast 123	bhlu
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 156	bhlu:d	()Z
    //   52: ifne -23 -> 29
    //   55: aload_3
    //   56: invokevirtual 159	bhlu:b	()V
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 162	bgun:executeTask	(Lbhlu;)V
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	bgun
    //   6	2	1	bool	boolean
    //   28	11	2	localIterator	Iterator
    //   67	4	2	localObject	Object
    //   47	14	3	localbhlu	bhlu
    // Exception table:
    //   from	to	target	type
    //   2	7	67	finally
    //   14	29	67	finally
    //   29	64	67	finally
  }
  
  public void addRuntimeStateObserver(bgug parambgug)
  {
    this.mEventCenter.addObserver(parambgug);
  }
  
  public void addTask(bhlu parambhlu)
  {
    if (parambhlu == null) {
      return;
    }
    String str = parambhlu.getClass().getCanonicalName();
    if (this.mActivatedTasks.containsKey(str))
    {
      QMLog.w("BaseRuntimeLoader", "Failed to add task: duplicated " + str);
      return;
    }
    this.mActivatedTasks.put(str, parambhlu);
  }
  
  public abstract bhlu[] createTasks();
  
  public boolean dismissLoadingAfterLoaded()
  {
    return true;
  }
  
  public bguj getAppStateManager()
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
      return bhcg.a();
    }
    return this.mMiniAppInfo;
  }
  
  public bgls getRuntime()
  {
    return this.mRuntime;
  }
  
  public bhlu getTask(Class paramClass)
  {
    return (bhlu)this.mActivatedTasks.get(paramClass.getCanonicalName());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QMLog.d("BaseRuntimeLoader", "handleMessage " + paramMessage.what);
    return false;
  }
  
  public boolean isLoadSucceed()
  {
    return (this.runtimeLoadCompleted) && (this.isSucceed);
  }
  
  public void loadMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    restartFailTaskIfNeed();
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    bguf localbguf = bguf.a(paramInt, this);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localbguf.a = paramVarArgs[0];
    }
    this.mEventCenter.a(localbguf);
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
  
  public void onTaskDone(bhlu parambhlu)
  {
    super.onTaskDone(parambhlu);
    if (parambhlu == null) {}
    do
    {
      return;
      QMLog.d("BaseRuntimeLoader", "onTaskDone " + parambhlu + " isSucc=" + parambhlu.d());
    } while (parambhlu.d());
    this.hasTaskFailed = true;
  }
  
  public void removeRuntimeStateObserver(bgug parambgug)
  {
    this.mEventCenter.deleteObserver(parambgug);
  }
  
  public void setRuntimeLoadListener(bgup parambgup)
  {
    this.mRuntimeLoadListener = parambgup;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgun
 * JD-Core Version:    0.7.0.1
 */