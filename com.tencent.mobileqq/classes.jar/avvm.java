import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class avvm
  implements avvk
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new avvn(this);
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private avvo jdField_a_of_type_Avvo;
  private WeakReference<avvh> jdField_a_of_type_JavaLangRefWeakReference;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean;
  private Messenger jdField_b_of_type_AndroidOsMessenger;
  private WeakReference<avvi> jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference<avvl> c;
  private WeakReference<avvj> d;
  
  public avvm(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      avvh localavvh = (avvh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localavvh != null) {
        localavvh.a(paramInt);
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQMusicPlayService.class);
    localIntent.putExtra("key_message", paramMessage);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.e("QQMusicPlay.QQMusicPlayClient", 1, "sendMessage exception===>", paramMessage);
    }
  }
  
  private void a(ISong paramISong)
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      avvi localavvi = (avvi)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localavvi != null) {
        localavvi.a(paramISong);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.c != null)
    {
      avvl localavvl = (avvl)this.c.get();
      if (localavvl != null) {
        localavvl.a(paramString, paramInt);
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.d != null)
    {
      avvj localavvj = (avvj)this.d.get();
      if (localavvj != null) {
        localavvj.a(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c != null)
    {
      avvl localavvl = (avvl)this.c.get();
      if (localavvl != null) {
        localavvl.a(paramBoolean);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null)
    {
      avvl localavvl = (avvl)this.c.get();
      if (localavvl != null) {
        localavvl.a(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 141	avvm:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 89
    //   22: iconst_2
    //   23: ldc 149
    //   25: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 155	avvm:jdField_a_of_type_Avvo	Lavvo;
    //   32: ifnull +18 -> 50
    //   35: aload_0
    //   36: getfield 155	avvm:jdField_a_of_type_Avvo	Lavvo;
    //   39: invokevirtual 161	avvo:getLooper	()Landroid/os/Looper;
    //   42: invokevirtual 166	android/os/Looper:quit	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 155	avvm:jdField_a_of_type_Avvo	Lavvo;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 49	avvm:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   55: aload_0
    //   56: getfield 43	avvm:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   59: aload_0
    //   60: getfield 41	avvm:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   63: invokevirtual 170	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   66: aload_0
    //   67: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   70: iconst_m1
    //   71: invokevirtual 173	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 52	avvm:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   84: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   87: invokespecial 101	avvm:a	(I)V
    //   90: goto -79 -> 11
    //   93: astore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: astore_2
    //   99: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +12 -> 114
    //   105: ldc 89
    //   107: iconst_2
    //   108: ldc 178
    //   110: aload_2
    //   111: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   118: iconst_m1
    //   119: invokevirtual 173	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 52	avvm:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   132: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   135: invokespecial 101	avvm:a	(I)V
    //   138: goto -127 -> 11
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   146: iconst_m1
    //   147: invokevirtual 173	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 52	avvm:jdField_b_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   160: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   163: invokespecial 101	avvm:a	(I)V
    //   166: aload_2
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	avvm
    //   6	2	1	bool	boolean
    //   93	4	2	localObject1	Object
    //   98	13	2	localException	java.lang.Exception
    //   141	26	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	93	finally
    //   14	28	93	finally
    //   28	50	93	finally
    //   50	55	93	finally
    //   66	90	93	finally
    //   114	138	93	finally
    //   142	168	93	finally
    //   55	66	98	java/lang/Exception
    //   55	66	141	finally
    //   99	114	141	finally
  }
  
  public int a()
  {
    return QQMusicPlayService.d();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 141	avvm:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: istore_1
    //   15: iload_1
    //   16: iflt +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +11 -> 36
    //   28: ldc 89
    //   30: iconst_2
    //   31: ldc 184
    //   33: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: new 186	android/os/HandlerThread
    //   39: dup
    //   40: ldc 188
    //   42: invokespecial 191	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 194	android/os/HandlerThread:start	()V
    //   50: aload_0
    //   51: new 157	avvo
    //   54: dup
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 195	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   60: invokespecial 198	avvo:<init>	(Lavvm;Landroid/os/Looper;)V
    //   63: putfield 155	avvm:jdField_a_of_type_Avvo	Lavvo;
    //   66: aload_0
    //   67: new 200	android/os/Messenger
    //   70: dup
    //   71: aload_0
    //   72: getfield 155	avvm:jdField_a_of_type_Avvo	Lavvo;
    //   75: invokespecial 203	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   78: putfield 49	avvm:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   81: new 70	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: getfield 43	avvm:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   89: ldc 72
    //   91: invokespecial 75	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 43	avvm:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 41	avvm:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   104: iconst_1
    //   105: invokevirtual 207	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   108: pop
    //   109: aload_0
    //   110: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: iconst_0
    //   114: invokevirtual 173	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   122: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   125: invokespecial 101	avvm:a	(I)V
    //   128: goto -109 -> 19
    //   131: astore_2
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   141: ldc 89
    //   143: iconst_1
    //   144: ldc 212
    //   146: aload_2
    //   147: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   155: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   158: invokespecial 101	avvm:a	(I)V
    //   161: goto -142 -> 19
    //   164: astore_2
    //   165: aload_0
    //   166: aload_0
    //   167: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   170: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   173: invokespecial 101	avvm:a	(I)V
    //   176: aload_2
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	avvm
    //   14	2	1	i	int
    //   45	55	2	localObject1	Object
    //   131	4	2	localObject2	Object
    //   136	11	2	localException	java.lang.Exception
    //   164	13	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	131	finally
    //   22	36	131	finally
    //   36	95	131	finally
    //   117	128	131	finally
    //   150	161	131	finally
    //   165	178	131	finally
    //   95	117	136	java/lang/Exception
    //   95	117	164	finally
    //   137	150	164	finally
  }
  
  public void a(avvh paramavvh)
  {
    if (paramavvh != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavvh);
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(avvi paramavvi)
  {
    if (paramavvi != null)
    {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramavvi);
      return;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(avvj paramavvj)
  {
    if (paramavvj != null)
    {
      this.d = new WeakReference(paramavvj);
      return;
    }
    this.d = null;
  }
  
  public void a(avvl paramavvl)
  {
    if (paramavvl != null)
    {
      this.c = new WeakReference(paramavvl);
      return;
    }
    this.c = null;
  }
  
  public boolean a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->pausePlay");
      }
      a(Message.obtain(null, 7));
      return true;
    }
    finally {}
  }
  
  public boolean a(ISong paramISong)
  {
    boolean bool = false;
    try
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_b_of_type_AndroidOsMessenger != null) {
          bool = true;
        }
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->startPlay song=[%s] connected=%b", new Object[] { paramISong, Boolean.valueOf(bool) }));
      }
      Message localMessage = Message.obtain(null, 6);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_song", paramISong);
      localMessage.setData(localBundle);
      a(localMessage);
      return true;
    }
    finally {}
  }
  
  public int b()
  {
    return QQMusicPlayService.b();
  }
  
  public boolean b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->resumePlay");
      }
      a(Message.obtain(null, 8));
      return true;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->stopPlay");
      }
      this.jdField_a_of_type_Boolean = true;
      a(Message.obtain(null, 10));
      return true;
    }
    finally {}
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 34	avvm:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   8: invokevirtual 176	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   11: istore_1
    //   12: iload_1
    //   13: iconst_1
    //   14: if_icmpne +7 -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	avvm
    //   11	4	1	i	int
    //   1	22	2	bool	boolean
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	12	26	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvm
 * JD-Core Version:    0.7.0.1
 */