package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public final class MultiContextNodeJS
{
  private static final String GLOBAL = "global";
  private static final String STARTUP_CALLBACK = "__run";
  private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
  private static final String STARTUP_SCRIPT_NAME = "startup";
  private static final String TMP_JS_EXT = ".js.tmp";
  private static MultiContextNodeJS.IGetTmpFileDirectory sTmpFileDirectoryDelegate = new MultiContextNodeJS.2();
  @NonNull
  private final V8Context mainContext;
  @NonNull
  private final MultiContextV8 mv8;
  private V8Function require;
  
  private MultiContextNodeJS(MultiContextV8 paramMultiContextV8, V8Context paramV8Context)
  {
    this.mv8 = paramMultiContextV8;
    this.mainContext = paramV8Context;
  }
  
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt)
  {
    return createMultiContextNodeJS(paramInt, null, null, false);
  }
  
  /* Error */
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_1
    //   3: aload_2
    //   4: invokestatic 64	com/eclipsesource/mmv8/MultiContextV8:createMultiContextV8	(Ljava/lang/String;Ljava/lang/String;[B)Lcom/eclipsesource/mmv8/MultiContextV8;
    //   7: astore_1
    //   8: aload_1
    //   9: iload_0
    //   10: invokevirtual 68	com/eclipsesource/mmv8/MultiContextV8:createContext	(I)Lcom/eclipsesource/mmv8/V8Context;
    //   13: astore 4
    //   15: new 2	com/eclipsesource/mmv8/MultiContextNodeJS
    //   18: dup
    //   19: aload_1
    //   20: aload 4
    //   22: invokespecial 70	com/eclipsesource/mmv8/MultiContextNodeJS:<init>	(Lcom/eclipsesource/mmv8/MultiContextV8;Lcom/eclipsesource/mmv8/V8Context;)V
    //   25: astore_2
    //   26: iload_3
    //   27: ifeq +10 -> 37
    //   30: aload_1
    //   31: invokevirtual 74	com/eclipsesource/mmv8/MultiContextV8:getV8	()Lcom/eclipsesource/mmv8/V8;
    //   34: invokevirtual 79	com/eclipsesource/mmv8/V8:enableNativeTrans	()V
    //   37: aload 4
    //   39: new 81	com/eclipsesource/mmv8/MultiContextNodeJS$1
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 84	com/eclipsesource/mmv8/MultiContextNodeJS$1:<init>	(Lcom/eclipsesource/mmv8/MultiContextNodeJS;)V
    //   47: ldc 11
    //   49: invokeinterface 90 3 0
    //   54: pop
    //   55: ldc 14
    //   57: ldc 92
    //   59: iconst_3
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: ldc 17
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: invokestatic 98	android/os/Process:myPid	()I
    //   73: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: invokestatic 110	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   82: invokevirtual 114	java/lang/Thread:getId	()J
    //   85: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: aastore
    //   89: invokestatic 125	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokestatic 129	com/eclipsesource/mmv8/MultiContextNodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   95: astore 4
    //   97: aload_1
    //   98: invokevirtual 133	com/eclipsesource/mmv8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   101: invokevirtual 139	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   104: ifne +10 -> 114
    //   107: aload_1
    //   108: invokevirtual 133	com/eclipsesource/mmv8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   111: invokevirtual 142	com/eclipsesource/mmv8/V8Locker:acquire	()V
    //   114: aload_1
    //   115: invokevirtual 74	com/eclipsesource/mmv8/MultiContextV8:getV8	()Lcom/eclipsesource/mmv8/V8;
    //   118: aload 4
    //   120: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: invokevirtual 152	com/eclipsesource/mmv8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 133	com/eclipsesource/mmv8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   130: invokevirtual 155	com/eclipsesource/mmv8/V8Locker:release	()V
    //   133: aload 4
    //   135: invokevirtual 158	java/io/File:delete	()Z
    //   138: pop
    //   139: aload_2
    //   140: areturn
    //   141: astore_1
    //   142: aload 4
    //   144: invokevirtual 158	java/io/File:delete	()Z
    //   147: pop
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: new 160	java/lang/RuntimeException
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 163	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramInt	int
    //   0	160	1	paramString	String
    //   0	160	2	paramArrayOfByte	byte[]
    //   0	160	3	paramBoolean	boolean
    //   13	130	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   97	114	141	finally
    //   114	133	141	finally
    //   55	97	150	java/io/IOException
    //   133	139	150	java/io/IOException
    //   142	150	150	java/io/IOException
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    try
    {
      localObject = File.createTempFile(paramString2, ".js.tmp", sTmpFileDirectoryDelegate.getDirectory());
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      Object localObject;
      label20:
      break label20;
    }
    paramString2 = File.createTempFile(paramString2, ".js.tmp", sTmpFileDirectoryDelegate.getDirectory());
    localObject = new PrintWriter(paramString2, "UTF-8");
    try
    {
      ((PrintWriter)localObject).print(paramString1);
      return paramString2;
    }
    finally
    {
      ((PrintWriter)localObject).close();
    }
  }
  
  private void init(V8Function paramV8Function)
  {
    this.require = paramV8Function;
  }
  
  public static void setGetTmpFileDirectoryDelegate(MultiContextNodeJS.IGetTmpFileDirectory paramIGetTmpFileDirectory)
  {
    if (paramIGetTmpFileDirectory == null) {
      return;
    }
    sTmpFileDirectoryDelegate = paramIGetTmpFileDirectory;
  }
  
  public void closeUVLoop()
  {
    this.mv8.getV8().closeUVLoop();
  }
  
  public void debuggerMessageLoop()
  {
    this.mv8.debuggerMessageLoop();
  }
  
  public V8Context getMainContext()
  {
    return this.mainContext;
  }
  
  public MultiContextV8 getRuntime()
  {
    return this.mv8;
  }
  
  public boolean handleMessage()
  {
    this.mv8.getV8().checkThread();
    return this.mv8.getV8().pumpMessageLoop();
  }
  
  public boolean isRunning()
  {
    this.mv8.getV8().checkThread();
    return this.mv8.getV8().isRunning();
  }
  
  public void nativeDispatch()
  {
    this.mv8.getV8().nativeDispatch();
  }
  
  public void nativeMessageLoop()
  {
    this.mv8.getV8().checkThread();
    this.mv8.getV8().nativeMessageLoop();
  }
  
  public void release()
  {
    this.mv8.getV8().checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    if (!this.mainContext.isReleased()) {
      this.mainContext.release();
    }
    this.mv8.release();
  }
  
  public void waitForDebugger(String paramString)
  {
    this.mv8.waitForDebugger(paramString);
  }
  
  public void wakeUpUVLoop()
  {
    this.mv8.getV8().wakeUpUVLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.MultiContextNodeJS
 * JD-Core Version:    0.7.0.1
 */