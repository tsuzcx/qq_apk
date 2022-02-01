package com.eclipsesource.mmv8;

import java.nio.ByteBuffer;
import java.util.ArrayList;

final class V8ContextWrapper$V8ContextImpl
  extends V8Object
  implements V8Context
{
  private final long ptr;
  
  V8ContextWrapper$V8ContextImpl(V8ContextWrapper paramV8ContextWrapper, long paramLong)
  {
    super(V8ContextWrapper.access$000(paramV8ContextWrapper).getV8());
    this.objectHandle = this.v8.getGlobalObject();
    this.ptr = paramLong;
  }
  
  private void shareObjectImpl(String paramString1, V8Context paramV8Context, String paramString2)
  {
    checkReleased();
    this.v8.checkThread();
    if (paramString1 != null)
    {
      if (paramString1.isEmpty()) {
        return;
      }
      if (paramV8Context == null) {
        return;
      }
      V8Object localV8Object = getObject(paramString1);
      String str = paramString1;
      if (paramString2 != null) {
        if (paramString2.isEmpty()) {
          str = paramString1;
        } else {
          str = paramString2;
        }
      }
      paramV8Context.add(str, localV8Object);
      localV8Object.release();
    }
  }
  
  public V8Array executeArrayScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeArrayScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeArrayScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeArrayScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public boolean executeBooleanScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeBooleanScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeBooleanScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeBooleanScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public String executeDebugScript(String paramString1, String paramString2)
  {
    return this.v8.executeDebugScript(paramString1, paramString2);
  }
  
  public double executeDoubleScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeDoubleScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeDoubleScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeDoubleScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public int executeIntegerScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeIntegerScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeIntegerScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeIntegerScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public V8Object executeObjectScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeObjectScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeObjectScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeObjectScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public Object executeScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public String executeStringScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeStringScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeStringScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeStringScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public void executeVoidScript(String paramString, ExecuteDetails paramExecuteDetails)
  {
    this.v8.executeVoidScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
  {
    this.v8.executeVoidScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    this.v8.executeVoidScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
  }
  
  public Object executeWxaScript(ArrayList<ScriptPartObject> paramArrayList, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    return this.v8.executeWxaScript(paramArrayList, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramExecuteDetails);
  }
  
  public V8Object getGlobalObject()
  {
    return this;
  }
  
  public long getPtr()
  {
    return this.ptr;
  }
  
  public SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    return new SharedV8ArrayBuffer(this.v8, paramByteBuffer);
  }
  
  public V8Array newV8Array()
  {
    return new V8Array(this.v8);
  }
  
  public V8ArrayBuffer newV8ArrayBuffer(int paramInt)
  {
    return new V8ArrayBuffer(this.v8, paramInt);
  }
  
  public V8ArrayBuffer newV8ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    return new V8ArrayBuffer(this.v8, paramByteBuffer);
  }
  
  public V8Function newV8Function(JavaCallback paramJavaCallback)
  {
    return new V8Function(this.v8, paramJavaCallback);
  }
  
  public V8Object newV8Object()
  {
    return new V8Object(this.v8);
  }
  
  public V8TypedArray newV8TypedArray(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    return new V8TypedArray(this.v8, paramV8ArrayBuffer, paramInt1, paramInt2, paramInt3);
  }
  
  public void release()
  {
    if (isReleased()) {
      return;
    }
    this.v8.releaseObjRef(this);
    V8ContextWrapper.access$000(this.this$0).releaseContext(this.this$0);
    this.released = true;
  }
  
  public void shareObject(String paramString, V8Context paramV8Context)
  {
    shareObjectImpl(paramString, paramV8Context, null);
  }
  
  public void shareObject(String paramString1, V8Context paramV8Context, String paramString2)
  {
    shareObjectImpl(paramString1, paramV8Context, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8ContextWrapper.V8ContextImpl
 * JD-Core Version:    0.7.0.1
 */