package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;
import java.util.LinkedList;

public class V8Executor
  extends Thread
{
  private Exception exception = null;
  private volatile boolean forceTerminating = false;
  private boolean longRunning;
  private String messageHandler;
  private LinkedList<String[]> messageQueue = new LinkedList();
  private String result;
  private V8 runtime;
  private final String script;
  private volatile boolean shuttingDown = false;
  private volatile boolean terminated = false;
  
  public V8Executor(String paramString)
  {
    this(paramString, false, null);
  }
  
  public V8Executor(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.script = paramString1;
    this.longRunning = paramBoolean;
    this.messageHandler = paramString2;
  }
  
  public void forceTermination()
  {
    try
    {
      this.forceTerminating = true;
      this.shuttingDown = true;
      if (this.runtime != null) {
        this.runtime.terminateExecution();
      }
      notify();
      return;
    }
    finally {}
  }
  
  public Exception getException()
  {
    return this.exception;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public boolean hasException()
  {
    return this.exception != null;
  }
  
  public boolean hasTerminated()
  {
    return this.terminated;
  }
  
  public boolean isShuttingDown()
  {
    return this.shuttingDown;
  }
  
  public boolean isTerminating()
  {
    return this.forceTerminating;
  }
  
  public void postMessage(String... paramVarArgs)
  {
    try
    {
      this.messageQueue.add(paramVarArgs);
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 87	com/eclipsesource/mmv8/V8:createV8Runtime	()Lcom/eclipsesource/mmv8/V8;
    //   6: putfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   9: aload_0
    //   10: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   13: new 89	com/eclipsesource/mmv8/utils/V8Executor$ExecutorTermination
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 92	com/eclipsesource/mmv8/utils/V8Executor$ExecutorTermination:<init>	(Lcom/eclipsesource/mmv8/utils/V8Executor;)V
    //   21: ldc 94
    //   23: invokevirtual 98	com/eclipsesource/mmv8/V8:registerJavaMethod	(Lcom/eclipsesource/mmv8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Object;
    //   26: pop
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   32: invokevirtual 102	com/eclipsesource/mmv8/utils/V8Executor:setup	(Lcom/eclipsesource/mmv8/V8;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 35	com/eclipsesource/mmv8/utils/V8Executor:forceTerminating	Z
    //   41: ifne +94 -> 135
    //   44: aload_0
    //   45: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   48: astore_3
    //   49: new 104	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   56: astore 4
    //   58: aload 4
    //   60: ldc 107
    //   62: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: aload_0
    //   69: getfield 44	com/eclipsesource/mmv8/utils/V8Executor:script	Ljava/lang/String;
    //   72: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: aload 4
    //   79: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: aload_0
    //   83: invokevirtual 117	com/eclipsesource/mmv8/utils/V8Executor:getName	()Ljava/lang/String;
    //   86: iconst_m1
    //   87: invokevirtual 121	com/eclipsesource/mmv8/V8:executeScript	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Object;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +11 -> 103
    //   95: aload_0
    //   96: aload_3
    //   97: invokevirtual 122	java/lang/Object:toString	()Ljava/lang/String;
    //   100: putfield 69	com/eclipsesource/mmv8/utils/V8Executor:result	Ljava/lang/String;
    //   103: aload_3
    //   104: instanceof 124
    //   107: ifeq +12 -> 119
    //   110: aload_3
    //   111: checkcast 124	com/eclipsesource/mmv8/Releasable
    //   114: invokeinterface 127 1 0
    //   119: aload_3
    //   120: instanceof 124
    //   123: ifeq +12 -> 135
    //   126: aload_3
    //   127: checkcast 124	com/eclipsesource/mmv8/Releasable
    //   130: invokeinterface 127 1 0
    //   135: aload_0
    //   136: getfield 35	com/eclipsesource/mmv8/utils/V8Executor:forceTerminating	Z
    //   139: ifne +229 -> 368
    //   142: aload_0
    //   143: getfield 46	com/eclipsesource/mmv8/utils/V8Executor:longRunning	Z
    //   146: ifeq +222 -> 368
    //   149: aload_0
    //   150: monitorenter
    //   151: aload_0
    //   152: getfield 42	com/eclipsesource/mmv8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   155: invokevirtual 130	java/util/LinkedList:isEmpty	()Z
    //   158: ifeq +14 -> 172
    //   161: aload_0
    //   162: getfield 33	com/eclipsesource/mmv8/utils/V8Executor:shuttingDown	Z
    //   165: ifne +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 133	java/lang/Object:wait	()V
    //   172: aload_0
    //   173: getfield 42	com/eclipsesource/mmv8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   176: invokevirtual 130	java/util/LinkedList:isEmpty	()Z
    //   179: ifeq +10 -> 189
    //   182: aload_0
    //   183: getfield 33	com/eclipsesource/mmv8/utils/V8Executor:shuttingDown	Z
    //   186: ifne +10 -> 196
    //   189: aload_0
    //   190: getfield 35	com/eclipsesource/mmv8/utils/V8Executor:forceTerminating	Z
    //   193: ifeq +45 -> 238
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_0
    //   199: monitorenter
    //   200: aload_0
    //   201: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   204: invokevirtual 137	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   207: invokevirtual 142	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   210: ifeq +15 -> 225
    //   213: aload_0
    //   214: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   217: invokevirtual 143	com/eclipsesource/mmv8/V8:release	()V
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   225: aload_0
    //   226: iconst_1
    //   227: putfield 31	com/eclipsesource/mmv8/utils/V8Executor:terminated	Z
    //   230: aload_0
    //   231: monitorexit
    //   232: return
    //   233: astore_3
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_3
    //   237: athrow
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_0
    //   241: getfield 42	com/eclipsesource/mmv8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   244: invokevirtual 130	java/util/LinkedList:isEmpty	()Z
    //   247: ifne -112 -> 135
    //   250: aload_0
    //   251: getfield 42	com/eclipsesource/mmv8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   254: astore_3
    //   255: iconst_0
    //   256: istore_1
    //   257: aload_3
    //   258: iconst_0
    //   259: invokevirtual 147	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   262: checkcast 149	[Ljava/lang/String;
    //   265: astore 5
    //   267: new 151	com/eclipsesource/mmv8/V8Array
    //   270: dup
    //   271: aload_0
    //   272: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   275: invokespecial 153	com/eclipsesource/mmv8/V8Array:<init>	(Lcom/eclipsesource/mmv8/V8;)V
    //   278: astore_3
    //   279: new 151	com/eclipsesource/mmv8/V8Array
    //   282: dup
    //   283: aload_0
    //   284: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   287: invokespecial 153	com/eclipsesource/mmv8/V8Array:<init>	(Lcom/eclipsesource/mmv8/V8;)V
    //   290: astore 4
    //   292: aload 5
    //   294: arraylength
    //   295: istore_2
    //   296: iload_1
    //   297: iload_2
    //   298: if_icmpge +20 -> 318
    //   301: aload 4
    //   303: aload 5
    //   305: iload_1
    //   306: aaload
    //   307: invokevirtual 157	com/eclipsesource/mmv8/V8Array:push	(Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Array;
    //   310: pop
    //   311: iload_1
    //   312: iconst_1
    //   313: iadd
    //   314: istore_1
    //   315: goto -19 -> 296
    //   318: aload_3
    //   319: aload 4
    //   321: invokevirtual 160	com/eclipsesource/mmv8/V8Array:push	(Lcom/eclipsesource/mmv8/V8Value;)Lcom/eclipsesource/mmv8/V8Array;
    //   324: pop
    //   325: aload_0
    //   326: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   329: aload_0
    //   330: getfield 48	com/eclipsesource/mmv8/utils/V8Executor:messageHandler	Ljava/lang/String;
    //   333: aload_3
    //   334: invokevirtual 164	com/eclipsesource/mmv8/V8:executeVoidFunction	(Ljava/lang/String;Lcom/eclipsesource/mmv8/V8Array;)V
    //   337: aload 4
    //   339: invokevirtual 165	com/eclipsesource/mmv8/V8Array:release	()V
    //   342: aload_3
    //   343: invokevirtual 165	com/eclipsesource/mmv8/V8Array:release	()V
    //   346: goto -211 -> 135
    //   349: astore 5
    //   351: aload 4
    //   353: invokevirtual 165	com/eclipsesource/mmv8/V8Array:release	()V
    //   356: aload_3
    //   357: invokevirtual 165	com/eclipsesource/mmv8/V8Array:release	()V
    //   360: aload 5
    //   362: athrow
    //   363: astore_3
    //   364: aload_0
    //   365: monitorexit
    //   366: aload_3
    //   367: athrow
    //   368: aload_0
    //   369: monitorenter
    //   370: aload_0
    //   371: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   374: invokevirtual 137	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   377: invokevirtual 142	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   380: ifeq +15 -> 395
    //   383: aload_0
    //   384: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   387: invokevirtual 143	com/eclipsesource/mmv8/V8:release	()V
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   395: aload_0
    //   396: iconst_1
    //   397: putfield 31	com/eclipsesource/mmv8/utils/V8Executor:terminated	Z
    //   400: aload_0
    //   401: monitorexit
    //   402: return
    //   403: astore_3
    //   404: aload_0
    //   405: monitorexit
    //   406: aload_3
    //   407: athrow
    //   408: astore_3
    //   409: goto +49 -> 458
    //   412: astore_3
    //   413: aload_0
    //   414: aload_3
    //   415: putfield 37	com/eclipsesource/mmv8/utils/V8Executor:exception	Ljava/lang/Exception;
    //   418: aload_0
    //   419: monitorenter
    //   420: aload_0
    //   421: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   424: invokevirtual 137	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   427: invokevirtual 142	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   430: ifeq +15 -> 445
    //   433: aload_0
    //   434: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   437: invokevirtual 143	com/eclipsesource/mmv8/V8:release	()V
    //   440: aload_0
    //   441: aconst_null
    //   442: putfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   445: aload_0
    //   446: iconst_1
    //   447: putfield 31	com/eclipsesource/mmv8/utils/V8Executor:terminated	Z
    //   450: aload_0
    //   451: monitorexit
    //   452: return
    //   453: astore_3
    //   454: aload_0
    //   455: monitorexit
    //   456: aload_3
    //   457: athrow
    //   458: aload_0
    //   459: monitorenter
    //   460: aload_0
    //   461: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   464: invokevirtual 137	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   467: invokevirtual 142	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   470: ifeq +15 -> 485
    //   473: aload_0
    //   474: getfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   477: invokevirtual 143	com/eclipsesource/mmv8/V8:release	()V
    //   480: aload_0
    //   481: aconst_null
    //   482: putfield 53	com/eclipsesource/mmv8/utils/V8Executor:runtime	Lcom/eclipsesource/mmv8/V8;
    //   485: aload_0
    //   486: iconst_1
    //   487: putfield 31	com/eclipsesource/mmv8/utils/V8Executor:terminated	Z
    //   490: aload_0
    //   491: monitorexit
    //   492: aload_3
    //   493: athrow
    //   494: astore_3
    //   495: aload_0
    //   496: monitorexit
    //   497: aload_3
    //   498: athrow
    //   499: astore_3
    //   500: aload_0
    //   501: monitorexit
    //   502: goto +5 -> 507
    //   505: aload_3
    //   506: athrow
    //   507: goto -2 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	V8Executor
    //   256	59	1	i	int
    //   295	4	2	j	int
    //   48	79	3	localObject1	Object
    //   233	4	3	localObject2	Object
    //   254	103	3	localObject3	Object
    //   363	4	3	localObject4	Object
    //   403	4	3	localObject5	Object
    //   408	1	3	localObject6	Object
    //   412	3	3	localException	Exception
    //   453	40	3	localObject7	Object
    //   494	4	3	localObject8	Object
    //   499	7	3	localObject9	Object
    //   56	296	4	localObject10	Object
    //   265	39	5	arrayOfString	String[]
    //   349	12	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   200	225	233	finally
    //   225	232	233	finally
    //   234	236	233	finally
    //   292	296	349	finally
    //   301	311	349	finally
    //   318	337	349	finally
    //   151	172	363	finally
    //   172	189	363	finally
    //   189	196	363	finally
    //   196	198	363	finally
    //   238	240	363	finally
    //   364	366	363	finally
    //   370	395	403	finally
    //   395	402	403	finally
    //   404	406	403	finally
    //   37	91	408	finally
    //   95	103	408	finally
    //   103	119	408	finally
    //   119	135	408	finally
    //   135	151	408	finally
    //   240	255	408	finally
    //   257	292	408	finally
    //   337	346	408	finally
    //   351	363	408	finally
    //   366	368	408	finally
    //   413	418	408	finally
    //   37	91	412	java/lang/Exception
    //   95	103	412	java/lang/Exception
    //   103	119	412	java/lang/Exception
    //   119	135	412	java/lang/Exception
    //   135	151	412	java/lang/Exception
    //   240	255	412	java/lang/Exception
    //   257	292	412	java/lang/Exception
    //   337	346	412	java/lang/Exception
    //   351	363	412	java/lang/Exception
    //   366	368	412	java/lang/Exception
    //   420	445	453	finally
    //   445	452	453	finally
    //   454	456	453	finally
    //   460	485	494	finally
    //   485	492	494	finally
    //   495	497	494	finally
    //   2	37	499	finally
    //   500	502	499	finally
  }
  
  protected void setup(V8 paramV8) {}
  
  public void shutdown()
  {
    try
    {
      this.shuttingDown = true;
      notify();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8Executor
 * JD-Core Version:    0.7.0.1
 */