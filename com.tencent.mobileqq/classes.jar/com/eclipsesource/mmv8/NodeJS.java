package com.eclipsesource.mmv8;

import java.io.File;
import java.io.PrintWriter;

public class NodeJS
{
  private static final String GLOBAL = "global";
  private static final String NEXT_TICK = "nextTick";
  private static final String NODE = "node";
  private static final String PROCESS = "process";
  private static final String STARTUP_CALLBACK = "__run";
  private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
  private static final String STARTUP_SCRIPT_NAME = "startup";
  private static final String TMP_JS_EXT = ".js.tmp";
  private static final String VERSIONS = "versions";
  private String nodeVersion = null;
  private V8Function require;
  private V8 v8;
  
  private NodeJS(V8 paramV8)
  {
    this.v8 = paramV8;
  }
  
  public static NodeJS createNodeJS()
  {
    return createNodeJS(null);
  }
  
  /* Error */
  public static NodeJS createNodeJS(File paramFile)
  {
    // Byte code:
    //   0: ldc 8
    //   2: invokestatic 72	com/eclipsesource/mmv8/V8:createV8Runtime	(Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8;
    //   5: astore_2
    //   6: new 2	com/eclipsesource/mmv8/NodeJS
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 74	com/eclipsesource/mmv8/NodeJS:<init>	(Lcom/eclipsesource/mmv8/V8;)V
    //   14: astore_3
    //   15: aload_2
    //   16: new 76	com/eclipsesource/mmv8/NodeJS$1
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 79	com/eclipsesource/mmv8/NodeJS$1:<init>	(Lcom/eclipsesource/mmv8/NodeJS;)V
    //   24: ldc 20
    //   26: invokevirtual 83	com/eclipsesource/mmv8/V8:registerJavaMethod	(Lcom/eclipsesource/mmv8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Object;
    //   29: pop
    //   30: ldc 23
    //   32: ldc 26
    //   34: invokestatic 87	com/eclipsesource/mmv8/NodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   37: astore_1
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 93	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 97	com/eclipsesource/mmv8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 101	java/io/File:delete	()Z
    //   50: pop
    //   51: aload_0
    //   52: ifnull +8 -> 60
    //   55: aload_3
    //   56: aload_0
    //   57: invokevirtual 105	com/eclipsesource/mmv8/NodeJS:exec	(Ljava/io/File;)V
    //   60: aload_3
    //   61: areturn
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 101	java/io/File:delete	()Z
    //   67: pop
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: new 107	java/lang/RuntimeException
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 110	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramFile	File
    //   37	27	1	localFile	File
    //   5	34	2	localV8	V8
    //   14	47	3	localNodeJS	NodeJS
    // Exception table:
    //   from	to	target	type
    //   38	46	62	finally
    //   30	38	70	java/io/IOException
    //   46	51	70	java/io/IOException
    //   63	70	70	java/io/IOException
  }
  
  private V8Function createScriptExecutionCallback(File paramFile)
  {
    return new V8Function(this.v8, new NodeJS.2(this, paramFile));
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    File localFile = File.createTempFile(paramString2, ".js.tmp");
    paramString2 = new PrintWriter(localFile, "UTF-8");
    try
    {
      paramString2.print(paramString1);
      return localFile;
    }
    finally
    {
      paramString2.close();
    }
  }
  
  private void init(V8Function paramV8Function)
  {
    this.require = paramV8Function;
  }
  
  private void safeRelease(Releasable paramReleasable)
  {
    if (paramReleasable != null) {
      paramReleasable.release();
    }
  }
  
  /* Error */
  public void exec(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 147	com/eclipsesource/mmv8/NodeJS:createScriptExecutionCallback	(Ljava/io/File;)Lcom/eclipsesource/mmv8/V8Function;
    //   5: astore 4
    //   7: aload_0
    //   8: getfield 46	com/eclipsesource/mmv8/NodeJS:v8	Lcom/eclipsesource/mmv8/V8;
    //   11: ldc 17
    //   13: invokevirtual 151	com/eclipsesource/mmv8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Object;
    //   16: astore_3
    //   17: new 153	com/eclipsesource/mmv8/V8Array
    //   20: dup
    //   21: aload_0
    //   22: getfield 46	com/eclipsesource/mmv8/NodeJS:v8	Lcom/eclipsesource/mmv8/V8;
    //   25: invokespecial 154	com/eclipsesource/mmv8/V8Array:<init>	(Lcom/eclipsesource/mmv8/V8;)V
    //   28: astore_2
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 158	com/eclipsesource/mmv8/V8Array:push	(Lcom/eclipsesource/mmv8/V8Value;)Lcom/eclipsesource/mmv8/V8Array;
    //   35: pop
    //   36: aload_3
    //   37: ldc 11
    //   39: aload_2
    //   40: invokevirtual 164	com/eclipsesource/mmv8/V8Object:executeObjectFunction	(Ljava/lang/String;Lcom/eclipsesource/mmv8/V8Array;)Lcom/eclipsesource/mmv8/V8Object;
    //   43: pop
    //   44: aload_0
    //   45: aload_3
    //   46: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   49: aload_0
    //   50: aload_2
    //   51: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   54: aload_0
    //   55: aload 4
    //   57: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   60: return
    //   61: astore_1
    //   62: goto +14 -> 76
    //   65: astore_1
    //   66: aconst_null
    //   67: astore_2
    //   68: goto +8 -> 76
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_3
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   81: aload_0
    //   82: aload_2
    //   83: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   86: aload_0
    //   87: aload 4
    //   89: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	NodeJS
    //   0	94	1	paramFile	File
    //   28	55	2	localV8Array	V8Array
    //   16	62	3	localObject	Object
    //   5	83	4	localV8Function	V8Function
    // Exception table:
    //   from	to	target	type
    //   29	44	61	finally
    //   17	29	65	finally
    //   7	17	71	finally
  }
  
  /* Error */
  public String getNodeVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/eclipsesource/mmv8/NodeJS:nodeVersion	Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 46	com/eclipsesource/mmv8/NodeJS:v8	Lcom/eclipsesource/mmv8/V8;
    //   19: ldc 17
    //   21: invokevirtual 151	com/eclipsesource/mmv8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Object;
    //   24: astore_2
    //   25: aload_3
    //   26: astore_1
    //   27: aload_2
    //   28: ldc 32
    //   30: invokevirtual 168	com/eclipsesource/mmv8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/mmv8/V8Object;
    //   33: astore_3
    //   34: aload_3
    //   35: astore_1
    //   36: aload_0
    //   37: aload_3
    //   38: ldc 14
    //   40: invokevirtual 172	com/eclipsesource/mmv8/V8Object:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: putfield 44	com/eclipsesource/mmv8/NodeJS:nodeVersion	Ljava/lang/String;
    //   46: aload_0
    //   47: aload_2
    //   48: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   56: aload_0
    //   57: getfield 44	com/eclipsesource/mmv8/NodeJS:nodeVersion	Ljava/lang/String;
    //   60: areturn
    //   61: astore_3
    //   62: goto +6 -> 68
    //   65: astore_3
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_0
    //   69: aload_2
    //   70: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 166	com/eclipsesource/mmv8/NodeJS:safeRelease	(Lcom/eclipsesource/mmv8/Releasable;)V
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	NodeJS
    //   4	71	1	localObject1	Object
    //   24	46	2	localV8Object1	V8Object
    //   14	39	3	localV8Object2	V8Object
    //   61	1	3	localObject2	Object
    //   65	14	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	34	61	finally
    //   36	46	61	finally
    //   15	25	65	finally
  }
  
  public V8 getRuntime()
  {
    return this.v8;
  }
  
  public boolean handleMessage()
  {
    this.v8.checkThread();
    return this.v8.pumpMessageLoop();
  }
  
  public boolean isRunning()
  {
    this.v8.checkThread();
    return this.v8.isRunning();
  }
  
  public void release()
  {
    this.v8.checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    if (!this.v8.isReleased()) {
      this.v8.release();
    }
  }
  
  public V8Object require(File paramFile)
  {
    this.v8.checkThread();
    V8Array localV8Array = new V8Array(this.v8);
    try
    {
      localV8Array.push(paramFile.getAbsolutePath());
      paramFile = (V8Object)this.require.call(null, localV8Array);
      return paramFile;
    }
    finally
    {
      localV8Array.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.NodeJS
 * JD-Core Version:    0.7.0.1
 */