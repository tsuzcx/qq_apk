package com.tencent.mobileqq.app.automator;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import java.util.Set;

public class AsyncStep
  implements Runnable
{
  private static final int RESULT_EMPTY = 1;
  public static final int RESULT_FAIL = 6;
  public static final int RESULT_INTERRUPTED = 8;
  public static final int RESULT_NET_CONNECT = 4;
  public static final int RESULT_OK = 7;
  public static final int RESULT_TIMEOUT = 5;
  private static final int RESULT_UPDATE_TIMEOUT = 3;
  public static final int RESULT_WAITING = 2;
  protected static final String TAG = "QQInitHandler";
  protected static final long TIMEOUT_DEFAULT = 30000L;
  private long begin = 0L;
  public Automator mAutomator;
  protected int mCountRetry = 0;
  public String mName;
  public Object[] mParams;
  protected volatile int mResult = 1;
  public IResultListener mResultListener;
  private Object mResultLock = new Object();
  public int mStepId = -1;
  protected long mTimeout = 30000L;
  
  private boolean waitResult()
  {
    long l;
    synchronized (this.mResultLock)
    {
      int i;
      Object localObject2;
      for (;;)
      {
        i = this.mResult;
        if (i == 2) {
          try
          {
            this.mResultLock.wait(this.mTimeout);
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.mName);
          ((StringBuilder)localObject2).append(" waitResult ");
          ((StringBuilder)localObject2).append(this.mResult);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(this.mCountRetry);
          QLog.d("QQInitHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.mResult != 3) {
          break;
        }
        this.mResult = 2;
      }
      if (this.mResult == 2)
      {
        this.mResult = 5;
        localObject2 = this.mAutomator;
        ((Automator)localObject2).b += 1;
      }
      if ((this.mResult == 6) || (this.mResult == 5))
      {
        i = this.mCountRetry;
        this.mCountRetry = (i - 1);
        if (i > 0)
        {
          this.mResult = 1;
          return true;
        }
      }
      if ((DeviceOptSwitch.d) && (!DeviceOptSwitch.b.contains(Integer.valueOf(this.mStepId))))
      {
        l = SystemClock.uptimeMillis() - this.begin;
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 2, new Object[] { "asyncstep runtime = ", Long.valueOf(l) });
        }
        if (l >= 1500L) {}
      }
    }
    return false;
  }
  
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mName);
      localStringBuilder.append(" AsyncStep.doStep()");
      QLog.e("QQInitHandler", 2, localStringBuilder.toString());
    }
    return 7;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/app/automator/AsyncStep:mResult	I
    //   4: iconst_1
    //   5: if_icmpne +707 -> 712
    //   8: ldc2_w 167
    //   11: aload_0
    //   12: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   15: invokestatic 173	android/os/Process:myTid	()I
    //   18: invokestatic 179	com/tencent/widget/TraceUtils:asyncTraceBegin	(JLjava/lang/String;I)V
    //   21: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +46 -> 70
    //   27: new 80	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   34: astore_1
    //   35: aload_1
    //   36: aload_0
    //   37: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   40: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: ldc 181
    //   47: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: aload_0
    //   53: getfield 51	com/tencent/mobileqq/app/automator/AsyncStep:mResult	I
    //   56: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 27
    //   62: iconst_1
    //   63: aload_1
    //   64: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   74: putfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   77: aload_0
    //   78: invokevirtual 183	com/tencent/mobileqq/app/automator/AsyncStep:onCreate	()V
    //   81: aload_0
    //   82: aload_0
    //   83: invokevirtual 185	com/tencent/mobileqq/app/automator/AsyncStep:doStep	()I
    //   86: invokevirtual 189	com/tencent/mobileqq/app/automator/AsyncStep:setResult	(I)V
    //   89: aload_0
    //   90: invokespecial 191	com/tencent/mobileqq/app/automator/AsyncStep:waitResult	()Z
    //   93: ifne -12 -> 81
    //   96: aload_0
    //   97: invokevirtual 193	com/tencent/mobileqq/app/automator/AsyncStep:onDestroy	()V
    //   100: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +50 -> 153
    //   106: new 80	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: aload_0
    //   116: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   119: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: ldc 195
    //   126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_1
    //   131: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   134: aload_0
    //   135: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   138: lsub
    //   139: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 27
    //   145: iconst_1
    //   146: aload_1
    //   147: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: instanceof 200
    //   157: ifne +83 -> 240
    //   160: aload_0
    //   161: instanceof 202
    //   164: ifne +76 -> 240
    //   167: aload_0
    //   168: instanceof 204
    //   171: ifne +69 -> 240
    //   174: aload_0
    //   175: instanceof 206
    //   178: ifne +62 -> 240
    //   181: aload_0
    //   182: instanceof 208
    //   185: ifne +55 -> 240
    //   188: aload_0
    //   189: instanceof 210
    //   192: ifne +48 -> 240
    //   195: aload_0
    //   196: instanceof 212
    //   199: ifne +41 -> 240
    //   202: aload_0
    //   203: instanceof 214
    //   206: ifne +34 -> 240
    //   209: aload_0
    //   210: instanceof 216
    //   213: ifne +27 -> 240
    //   216: ldc 218
    //   218: aload_0
    //   219: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   222: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifne +15 -> 240
    //   228: ldc 225
    //   230: aload_0
    //   231: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   234: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +29 -> 266
    //   240: aload_0
    //   241: getfield 104	com/tencent/mobileqq/app/automator/AsyncStep:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   244: getfield 229	com/tencent/mobileqq/app/automator/Automator:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   247: aload_0
    //   248: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   251: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   254: aload_0
    //   255: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   258: lsub
    //   259: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: invokevirtual 235	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: ldc2_w 167
    //   269: aload_0
    //   270: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   273: invokestatic 173	android/os/Process:myTid	()I
    //   276: invokestatic 238	com/tencent/widget/TraceUtils:asyncTraceEnd	(JLjava/lang/String;I)V
    //   279: aload_0
    //   280: getfield 240	com/tencent/mobileqq/app/automator/AsyncStep:mResultListener	Lcom/tencent/mobileqq/app/automator/IResultListener;
    //   283: astore_1
    //   284: aload_1
    //   285: ifnull +427 -> 712
    //   288: goto +211 -> 499
    //   291: astore_1
    //   292: goto +219 -> 511
    //   295: astore_1
    //   296: ldc 27
    //   298: iconst_1
    //   299: ldc 242
    //   301: aload_1
    //   302: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: aload_0
    //   306: bipush 8
    //   308: invokevirtual 189	com/tencent/mobileqq/app/automator/AsyncStep:setResult	(I)V
    //   311: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +50 -> 364
    //   317: new 80	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   324: astore_1
    //   325: aload_1
    //   326: aload_0
    //   327: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   330: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: ldc 195
    //   337: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   345: aload_0
    //   346: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   349: lsub
    //   350: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 27
    //   356: iconst_1
    //   357: aload_1
    //   358: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: instanceof 200
    //   368: ifne +83 -> 451
    //   371: aload_0
    //   372: instanceof 202
    //   375: ifne +76 -> 451
    //   378: aload_0
    //   379: instanceof 204
    //   382: ifne +69 -> 451
    //   385: aload_0
    //   386: instanceof 206
    //   389: ifne +62 -> 451
    //   392: aload_0
    //   393: instanceof 208
    //   396: ifne +55 -> 451
    //   399: aload_0
    //   400: instanceof 210
    //   403: ifne +48 -> 451
    //   406: aload_0
    //   407: instanceof 212
    //   410: ifne +41 -> 451
    //   413: aload_0
    //   414: instanceof 214
    //   417: ifne +34 -> 451
    //   420: aload_0
    //   421: instanceof 216
    //   424: ifne +27 -> 451
    //   427: ldc 218
    //   429: aload_0
    //   430: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   433: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifne +15 -> 451
    //   439: ldc 225
    //   441: aload_0
    //   442: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   445: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   448: ifeq +29 -> 477
    //   451: aload_0
    //   452: getfield 104	com/tencent/mobileqq/app/automator/AsyncStep:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   455: getfield 229	com/tencent/mobileqq/app/automator/Automator:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   458: aload_0
    //   459: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   462: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   465: aload_0
    //   466: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   469: lsub
    //   470: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   473: invokevirtual 235	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: ldc2_w 167
    //   480: aload_0
    //   481: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   484: invokestatic 173	android/os/Process:myTid	()I
    //   487: invokestatic 238	com/tencent/widget/TraceUtils:asyncTraceEnd	(JLjava/lang/String;I)V
    //   490: aload_0
    //   491: getfield 240	com/tencent/mobileqq/app/automator/AsyncStep:mResultListener	Lcom/tencent/mobileqq/app/automator/IResultListener;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +216 -> 712
    //   499: aload_1
    //   500: aload_0
    //   501: aload_0
    //   502: getfield 51	com/tencent/mobileqq/app/automator/AsyncStep:mResult	I
    //   505: invokeinterface 250 3 0
    //   510: return
    //   511: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +50 -> 564
    //   517: new 80	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   524: astore_2
    //   525: aload_2
    //   526: aload_0
    //   527: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   530: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload_2
    //   535: ldc 195
    //   537: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_2
    //   542: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   545: aload_0
    //   546: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   549: lsub
    //   550: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 27
    //   556: iconst_1
    //   557: aload_2
    //   558: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_0
    //   565: instanceof 200
    //   568: ifne +83 -> 651
    //   571: aload_0
    //   572: instanceof 202
    //   575: ifne +76 -> 651
    //   578: aload_0
    //   579: instanceof 204
    //   582: ifne +69 -> 651
    //   585: aload_0
    //   586: instanceof 206
    //   589: ifne +62 -> 651
    //   592: aload_0
    //   593: instanceof 208
    //   596: ifne +55 -> 651
    //   599: aload_0
    //   600: instanceof 210
    //   603: ifne +48 -> 651
    //   606: aload_0
    //   607: instanceof 212
    //   610: ifne +41 -> 651
    //   613: aload_0
    //   614: instanceof 214
    //   617: ifne +34 -> 651
    //   620: aload_0
    //   621: instanceof 216
    //   624: ifne +27 -> 651
    //   627: ldc 218
    //   629: aload_0
    //   630: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   633: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   636: ifne +15 -> 651
    //   639: ldc 225
    //   641: aload_0
    //   642: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   645: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq +29 -> 677
    //   651: aload_0
    //   652: getfield 104	com/tencent/mobileqq/app/automator/AsyncStep:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   655: getfield 229	com/tencent/mobileqq/app/automator/Automator:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   658: aload_0
    //   659: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   662: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   665: aload_0
    //   666: getfield 61	com/tencent/mobileqq/app/automator/AsyncStep:begin	J
    //   669: lsub
    //   670: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   673: invokevirtual 235	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: pop
    //   677: ldc2_w 167
    //   680: aload_0
    //   681: getfield 83	com/tencent/mobileqq/app/automator/AsyncStep:mName	Ljava/lang/String;
    //   684: invokestatic 173	android/os/Process:myTid	()I
    //   687: invokestatic 238	com/tencent/widget/TraceUtils:asyncTraceEnd	(JLjava/lang/String;I)V
    //   690: aload_0
    //   691: getfield 240	com/tencent/mobileqq/app/automator/AsyncStep:mResultListener	Lcom/tencent/mobileqq/app/automator/IResultListener;
    //   694: astore_2
    //   695: aload_2
    //   696: ifnull +14 -> 710
    //   699: aload_2
    //   700: aload_0
    //   701: aload_0
    //   702: getfield 51	com/tencent/mobileqq/app/automator/AsyncStep:mResult	I
    //   705: invokeinterface 250 3 0
    //   710: aload_1
    //   711: athrow
    //   712: return
    //   713: astore_1
    //   714: goto -448 -> 266
    //   717: astore_1
    //   718: goto -241 -> 477
    //   721: astore_2
    //   722: goto -45 -> 677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	AsyncStep
    //   34	251	1	localObject1	Object
    //   291	1	1	localObject2	Object
    //   295	7	1	localThrowable1	java.lang.Throwable
    //   324	387	1	localObject3	Object
    //   713	1	1	localThrowable2	java.lang.Throwable
    //   717	1	1	localThrowable3	java.lang.Throwable
    //   524	176	2	localObject4	Object
    //   721	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   77	81	291	finally
    //   81	100	291	finally
    //   296	311	291	finally
    //   77	81	295	java/lang/Throwable
    //   81	100	295	java/lang/Throwable
    //   153	240	713	java/lang/Throwable
    //   240	266	713	java/lang/Throwable
    //   364	451	717	java/lang/Throwable
    //   451	477	717	java/lang/Throwable
    //   564	651	721	java/lang/Throwable
    //   651	677	721	java/lang/Throwable
  }
  
  public void setResult(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this.mName);
      ((StringBuilder)???).append(" setResult ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.mResult);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    if (paramInt == 6)
    {
      ??? = this.mAutomator;
      ((Automator)???).b += 1;
    }
    synchronized (this.mResultLock)
    {
      if ((paramInt > this.mResult) && (paramInt != 4)) {
        this.mResult = paramInt;
      }
      this.mResultLock.notifyAll();
      return;
    }
  }
  
  public final void updateTimeout(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(64);
      ((StringBuilder)???).append(this.mName);
      ((StringBuilder)???).append(" updateTimeout ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.mResult);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.mResultLock)
    {
      if (this.mResult == 2) {
        this.mResult = 3;
      }
      this.mTimeout = paramLong;
      this.mResultLock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.AsyncStep
 * JD-Core Version:    0.7.0.1
 */