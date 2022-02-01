package com.tencent.biz.pubaccount.readinjoy.featurecompute;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.Task;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;

public class JSContext
{
  private static final String TAG = "JSContext";
  private Map<String, JSContext.Callback> callbackMap;
  private long ctx;
  private long jsGroup;
  public Task task;
  public Map<Integer, Timer> timerTasks;
  
  /* Error */
  public JSContext()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 28	java/util/HashMap
    //   8: dup
    //   9: invokespecial 29	java/util/HashMap:<init>	()V
    //   12: putfield 31	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:timerTasks	Ljava/util/Map;
    //   15: aload_0
    //   16: new 28	java/util/HashMap
    //   19: dup
    //   20: invokespecial 29	java/util/HashMap:<init>	()V
    //   23: putfield 33	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:callbackMap	Ljava/util/Map;
    //   26: ldc 2
    //   28: monitorenter
    //   29: aload_0
    //   30: aload_0
    //   31: invokespecial 37	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:createGroup	()J
    //   34: putfield 39	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:jsGroup	J
    //   37: aload_0
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 39	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:jsGroup	J
    //   43: invokespecial 43	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:create	(J)J
    //   46: putfield 45	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:ctx	J
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: ldc 8
    //   56: iconst_2
    //   57: new 47	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   64: ldc 50
    //   66: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 58	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: new 47	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   89: ldc 50
    //   91: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 58	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 73	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:reportException	(Ljava/lang/String;)V
    //   107: goto -58 -> 49
    //   110: astore_1
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: ldc 8
    //   119: iconst_2
    //   120: new 47	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   127: ldc 75
    //   129: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokevirtual 76	java/lang/Error:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: new 47	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   152: ldc 75
    //   154: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 76	java/lang/Error:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 73	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:reportException	(Ljava/lang/String;)V
    //   170: goto -121 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	JSContext
    //   53	42	1	localException	java.lang.Exception
    //   110	5	1	localObject	Object
    //   116	42	1	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   29	49	53	java/lang/Exception
    //   29	49	110	finally
    //   49	52	110	finally
    //   54	107	110	finally
    //   111	114	110	finally
    //   117	170	110	finally
    //   29	49	116	java/lang/Error
  }
  
  private native long create(long paramLong);
  
  private native long createGroup();
  
  private native Object evaluteStringWithException(long paramLong, String paramString, StringBuffer paramStringBuffer);
  
  private native void initRIJStrorage(long paramLong);
  
  private native void registerFunction(long paramLong, String paramString);
  
  private native void release(long paramLong1, long paramLong2);
  
  public Object evaluteStringWithException(String paramString, StringBuffer paramStringBuffer)
  {
    return evaluteStringWithException(this.ctx, paramString, paramStringBuffer);
  }
  
  public Object functionCallback(String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    Iterator localIterator = this.callbackMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(((Map.Entry)localObject).getKey()))) {
        try
        {
          localObject = ((JSContext.Callback)((Map.Entry)localObject).getValue()).invoke(this, paramInt, paramArrayOfObject);
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          QLog.d("JSContext", 2, localThrowable.getMessage());
          TaskException.reportException(this.task.id, "functionCallback " + paramString + localThrowable.getMessage());
        }
      }
    }
    return null;
  }
  
  public void initRIJStorage()
  {
    initRIJStrorage(this.ctx);
  }
  
  public void registerFunction(String paramString, JSContext.Callback paramCallback)
  {
    this.callbackMap.put(paramString, paramCallback);
    registerFunction(this.ctx, paramString);
  }
  
  public void release()
  {
    Iterator localIterator = this.timerTasks.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((Timer)this.timerTasks.get(localInteger)).cancel();
    }
    this.timerTasks.clear();
    release(this.jsGroup, this.ctx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext
 * JD-Core Version:    0.7.0.1
 */