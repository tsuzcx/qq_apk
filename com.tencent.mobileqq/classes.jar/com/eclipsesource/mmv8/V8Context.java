package com.eclipsesource.mmv8;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract interface V8Context
{
  public abstract V8Object add(String paramString, double paramDouble);
  
  public abstract V8Object add(String paramString, int paramInt);
  
  public abstract V8Object add(String paramString, V8Value paramV8Value);
  
  public abstract V8Object add(String paramString1, String paramString2);
  
  public abstract V8Object add(String paramString, boolean paramBoolean);
  
  public abstract V8Object addNull(String paramString);
  
  public abstract V8Object addUndefined(String paramString);
  
  public abstract boolean contains(String paramString);
  
  public abstract V8Array executeArrayFunction(String paramString, V8Array paramV8Array);
  
  public abstract V8Array executeArrayScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract V8Array executeArrayScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract V8Array executeArrayScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract boolean executeBooleanFunction(String paramString, V8Array paramV8Array);
  
  public abstract boolean executeBooleanScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract boolean executeBooleanScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract boolean executeBooleanScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract String executeDebugScript(String paramString1, String paramString2);
  
  public abstract double executeDoubleFunction(String paramString, V8Array paramV8Array);
  
  public abstract double executeDoubleScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract double executeDoubleScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract double executeDoubleScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeFunction(String paramString, V8Array paramV8Array);
  
  public abstract int executeIntegerFunction(String paramString, V8Array paramV8Array);
  
  public abstract int executeIntegerScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract int executeIntegerScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract int executeIntegerScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeJSFunction(String paramString);
  
  public abstract Object executeJSFunction(String paramString, Object... paramVarArgs);
  
  public abstract V8Object executeObjectFunction(String paramString, V8Array paramV8Array);
  
  public abstract V8Object executeObjectScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract V8Object executeObjectScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract V8Object executeObjectScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract String executeStringFunction(String paramString, V8Array paramV8Array);
  
  public abstract String executeStringScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract String executeStringScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract String executeStringScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract void executeVoidFunction(String paramString, V8Array paramV8Array);
  
  public abstract void executeVoidScript(String paramString, ExecuteDetails paramExecuteDetails);
  
  public abstract void executeVoidScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails);
  
  public abstract void executeVoidScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract Object executeWxaScript(ArrayList<ScriptPartObject> paramArrayList, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  public abstract Object get(String paramString);
  
  public abstract V8Array getArray(String paramString);
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract double getDouble(String paramString);
  
  public abstract V8Object getGlobalObject();
  
  public abstract int getInteger(String paramString);
  
  public abstract String[] getKeys();
  
  public abstract V8Object getObject(String paramString);
  
  public abstract long getPtr();
  
  public abstract String getString(String paramString);
  
  public abstract int getType(String paramString);
  
  public abstract boolean isReleased();
  
  public abstract SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer paramByteBuffer);
  
  public abstract V8Array newV8Array();
  
  public abstract V8ArrayBuffer newV8ArrayBuffer(int paramInt);
  
  public abstract V8ArrayBuffer newV8ArrayBuffer(ByteBuffer paramByteBuffer);
  
  public abstract V8Function newV8Function(JavaCallback paramJavaCallback);
  
  public abstract V8Object newV8Object();
  
  public abstract V8TypedArray newV8TypedArray(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString);
  
  public abstract V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString);
  
  public abstract V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass);
  
  public abstract V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean);
  
  public abstract void release();
  
  public abstract void shareObject(String paramString, V8Context paramV8Context);
  
  public abstract void shareObject(String paramString1, V8Context paramV8Context, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8Context
 * JD-Core Version:    0.7.0.1
 */