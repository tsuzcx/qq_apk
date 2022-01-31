import android.content.ComponentName;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class arti
  implements ServiceConnection
{
  arti(arth paramarth) {}
  
  /* Error */
  public void onServiceConnected(ComponentName arg1, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +22 -> 25
    //   6: ldc 30
    //   8: iconst_2
    //   9: ldc 32
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: invokestatic 38	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokestatic 42	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 12	arti:a	Larth;
    //   29: invokestatic 47	arth:a	(Larth;)Landroid/os/Messenger;
    //   32: ifnull +95 -> 127
    //   35: aload_0
    //   36: getfield 12	arti:a	Larth;
    //   39: new 49	android/os/Messenger
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 52	android/os/Messenger:<init>	(Landroid/os/IBinder;)V
    //   47: invokestatic 55	arth:a	(Larth;Landroid/os/Messenger;)Landroid/os/Messenger;
    //   50: pop
    //   51: aconst_null
    //   52: iconst_1
    //   53: invokestatic 61	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   56: astore_1
    //   57: aload_1
    //   58: new 63	android/os/Bundle
    //   61: dup
    //   62: invokespecial 64	android/os/Bundle:<init>	()V
    //   65: invokevirtual 68	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 12	arti:a	Larth;
    //   73: invokestatic 47	arth:a	(Larth;)Landroid/os/Messenger;
    //   76: putfield 72	android/os/Message:replyTo	Landroid/os/Messenger;
    //   79: aload_0
    //   80: getfield 12	arti:a	Larth;
    //   83: invokestatic 75	arth:b	(Larth;)Landroid/os/Messenger;
    //   86: aload_1
    //   87: invokevirtual 79	android/os/Messenger:send	(Landroid/os/Message;)V
    //   90: aload_0
    //   91: getfield 12	arti:a	Larth;
    //   94: astore_1
    //   95: aload_1
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 12	arti:a	Larth;
    //   101: invokestatic 82	arth:a	(Larth;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   104: iconst_1
    //   105: invokevirtual 88	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 12	arti:a	Larth;
    //   114: aload_0
    //   115: getfield 12	arti:a	Larth;
    //   118: invokestatic 82	arth:a	(Larth;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   121: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   124: invokestatic 95	arth:a	(Larth;I)V
    //   127: return
    //   128: astore_1
    //   129: ldc 30
    //   131: iconst_1
    //   132: ldc 97
    //   134: aload_1
    //   135: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: goto -48 -> 90
    //   141: astore_1
    //   142: ldc 30
    //   144: iconst_1
    //   145: ldc 102
    //   147: aload_1
    //   148: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: goto -61 -> 90
    //   154: astore_2
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	arti
    //   0	159	2	paramIBinder	android.os.IBinder
    // Exception table:
    //   from	to	target	type
    //   79	90	128	android/os/RemoteException
    //   79	90	141	java/lang/Throwable
    //   97	110	154	finally
    //   155	157	154	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (this.a)
    {
      arth.a(this.a).set(-1);
      arth.a(this.a, null);
      arth.a(this.a, arth.a(this.a).get());
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->onServiceDisconnected %s", new Object[] { paramComponentName }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arti
 * JD-Core Version:    0.7.0.1
 */