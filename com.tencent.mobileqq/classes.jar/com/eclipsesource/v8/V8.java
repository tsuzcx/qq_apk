package com.eclipsesource.v8;

import com.eclipsesource.v8.inspector.V8InspectorDelegate;
import com.eclipsesource.v8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V8
  extends V8Object
{
  private static boolean initialized;
  private static Object invalid = new Object();
  private static Object lock = new Object();
  private static boolean nativeLibraryLoaded;
  private static Error nativeLoadError;
  private static Exception nativeLoadException;
  private static volatile int runtimeCounter = 0;
  private static V8Value undefined;
  private static String v8Flags = null;
  private Map<String, Object> data = null;
  private boolean forceTerminateExecutors = false;
  private Map<Long, V8.MethodDescriptor> functionRegistry = new HashMap();
  private final V8Locker locker = new V8Locker(this);
  private long objectReferences = 0L;
  private LinkedList<ReferenceHandler> referenceHandlers = new LinkedList();
  private LinkedList<V8Runnable> releaseHandlers = new LinkedList();
  private List<Releasable> resources = null;
  private SignatureProvider signatureProvider = null;
  private long v8RuntimePtr = 0L;
  protected Map<Long, V8Value> v8WeakReferences = new HashMap();
  
  static
  {
    initialized = false;
    nativeLibraryLoaded = false;
    nativeLoadError = null;
    nativeLoadException = null;
    undefined = new V8Object.Undefined();
  }
  
  protected V8()
  {
    this(null);
  }
  
  protected V8(String paramString)
  {
    super(null);
    this.released = false;
    checkThread();
    this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
  }
  
  private native void _acquireLock(long paramLong);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, double paramDouble);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, int paramInt);
  
  private native void _add(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean);
  
  private native void _addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void _addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble);
  
  private native void _addArrayIntItem(long paramLong1, long paramLong2, int paramInt);
  
  private native void _addArrayNullItem(long paramLong1, long paramLong2);
  
  private native void _addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _addArrayStringItem(long paramLong1, long paramLong2, String paramString);
  
  private native void _addArrayUndefinedItem(long paramLong1, long paramLong2);
  
  private native void _addNull(long paramLong1, long paramLong2, String paramString);
  
  private native void _addObject(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _addUndefined(long paramLong1, long paramLong2, String paramString);
  
  private native Object _arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  private native boolean _arrayGetBoolean(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean);
  
  private native boolean[] _arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native byte _arrayGetByte(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private native byte[] _arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native double _arrayGetDouble(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble);
  
  private native double[] _arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _arrayGetInteger(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  private native int[] _arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _arrayGetSize(long paramLong1, long paramLong2);
  
  private native String _arrayGetString(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  private native String[] _arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native void _clearWeak(long paramLong1, long paramLong2);
  
  private native boolean _contains(long paramLong1, long paramLong2, String paramString);
  
  private native long _createInspector(long paramLong, V8InspectorDelegate paramV8InspectorDelegate, String paramString);
  
  private native long _createIsolate(String paramString);
  
  private native void _createTwin(long paramLong1, long paramLong2, long paramLong3);
  
  private native ByteBuffer _createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt);
  
  private native void _dispatchProtocolMessage(long paramLong1, long paramLong2, String paramString);
  
  private native boolean _equals(long paramLong1, long paramLong2, long paramLong3);
  
  private native boolean _executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native boolean _executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native double _executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native double _executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3);
  
  private native Object _executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private native int _executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native int _executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  private native String _executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native String _executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native void _executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _get(long paramLong1, int paramInt, long paramLong2, String paramString);
  
  private native int _getArrayType(long paramLong1, long paramLong2);
  
  private native boolean _getBoolean(long paramLong1, long paramLong2, String paramString);
  
  private static native long _getBuildID();
  
  private native String _getConstructorName(long paramLong1, long paramLong2);
  
  private native double _getDouble(long paramLong1, long paramLong2, String paramString);
  
  private native long _getGlobalObject(long paramLong);
  
  private native int _getInteger(long paramLong1, long paramLong2, String paramString);
  
  private native String[] _getKeys(long paramLong1, long paramLong2);
  
  private native String _getString(long paramLong1, long paramLong2, String paramString);
  
  private native int _getType(long paramLong1, long paramLong2);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _getType(long paramLong1, long paramLong2, String paramString);
  
  private static native String _getVersion();
  
  private native int _identityHash(long paramLong1, long paramLong2);
  
  private native long _initEmptyContainer(long paramLong);
  
  private native long _initNewV8Array(long paramLong);
  
  private native long _initNewV8ArrayBuffer(long paramLong, int paramInt);
  
  private native long _initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native long _initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long[] _initNewV8Function(long paramLong);
  
  private native long _initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Object(long paramLong);
  
  private native long _initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native boolean _isNodeCompatible();
  
  private static native boolean _isRunning(long paramLong);
  
  private native boolean _isWeak(long paramLong1, long paramLong2);
  
  private native void _lowMemoryNotification(long paramLong);
  
  private static native boolean _pumpMessageLoop(long paramLong);
  
  private native long _registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean);
  
  private native void _release(long paramLong1, long paramLong2);
  
  private native void _releaseLock(long paramLong);
  
  private native void _releaseMethodDescriptor(long paramLong1, long paramLong2);
  
  private native void _releaseRuntime(long paramLong);
  
  private native boolean _sameValue(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _schedulePauseOnNextStatement(long paramLong1, long paramLong2, String paramString);
  
  private static native void _setFlags(String paramString);
  
  private native void _setPrototype(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _setWeak(long paramLong1, long paramLong2);
  
  private static native void _startNodeJS(long paramLong, String paramString);
  
  private native boolean _strictEquals(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _terminateExecution(long paramLong);
  
  private native String _toString(long paramLong1, long paramLong2);
  
  private void checkArgs(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j) {
      if (paramArrayOfObject[i] != invalid) {
        i += 1;
      } else {
        throw new IllegalArgumentException("argument type mismatch");
      }
    }
  }
  
  private Object checkResult(Object paramObject)
  {
    if (paramObject == null) {
      return paramObject;
    }
    if ((paramObject instanceof Float)) {
      return Double.valueOf(((Float)paramObject).doubleValue());
    }
    if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof Boolean)))
    {
      if ((paramObject instanceof String)) {
        return paramObject;
      }
      if ((paramObject instanceof V8Value))
      {
        if (!((V8Value)paramObject).isReleased()) {
          return paramObject;
        }
        throw new V8RuntimeException("V8Value already released");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown return type: ");
      localStringBuilder.append(paramObject.getClass());
      throw new V8RuntimeException(localStringBuilder.toString());
    }
    return paramObject;
  }
  
  static void checkScript(String paramString)
  {
    if (paramString != null) {
      return;
    }
    throw new NullPointerException("Script is null");
  }
  
  public static V8 createV8Runtime()
  {
    return createV8Runtime(null, null);
  }
  
  public static V8 createV8Runtime(String paramString)
  {
    return createV8Runtime(paramString, null);
  }
  
  public static V8 createV8Runtime(String arg0, String paramString2)
  {
    if (!initialized)
    {
      _setFlags(v8Flags);
      initialized = true;
    }
    paramString2 = new V8(???);
    synchronized (lock)
    {
      runtimeCounter += 1;
      return paramString2;
    }
  }
  
  public static int getActiveRuntimes()
  {
    return runtimeCounter;
  }
  
  private Object[] getArgs(V8Object paramV8Object, V8.MethodDescriptor paramMethodDescriptor, V8Array paramV8Array, boolean paramBoolean)
  {
    int j = paramMethodDescriptor.method.getParameterTypes().length;
    int i;
    if (paramBoolean) {
      i = j - 1;
    } else {
      i = j;
    }
    paramV8Object = setDefaultValues(new Object[j], paramMethodDescriptor.method.getParameterTypes(), paramV8Object, paramMethodDescriptor.includeReceiver);
    ArrayList localArrayList = new ArrayList();
    populateParamters(paramV8Array, i, paramV8Object, localArrayList, paramMethodDescriptor.includeReceiver);
    if (paramBoolean)
    {
      paramMethodDescriptor = getVarArgContainer(paramMethodDescriptor.method.getParameterTypes(), localArrayList.size());
      System.arraycopy(localArrayList.toArray(), 0, paramMethodDescriptor, 0, localArrayList.size());
      paramV8Object[i] = paramMethodDescriptor;
    }
    return paramV8Object;
  }
  
  private Object getArrayItem(V8Array paramV8Array, int paramInt)
  {
    try
    {
      int i = paramV8Array.getType(paramInt);
      if (i != 10) {
        if (i == 99) {}
      }
      switch (i)
      {
      case 7: 
        return paramV8Array.getObject(paramInt);
      case 6: 
        return paramV8Array.getObject(paramInt);
      case 5: 
      case 8: 
        return paramV8Array.getArray(paramInt);
      case 4: 
        return paramV8Array.getString(paramInt);
      case 3: 
        return Boolean.valueOf(paramV8Array.getBoolean(paramInt));
      case 2: 
        return Double.valueOf(paramV8Array.getDouble(paramInt));
      case 1: 
        return Integer.valueOf(paramV8Array.getInteger(paramInt));
        return getUndefined();
        paramV8Array = paramV8Array.get(paramInt);
        return paramV8Array;
      }
    }
    catch (V8ResultUndefined paramV8Array)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static long getBuildID()
  {
    return _getBuildID();
  }
  
  private Object getDefaultValue(Class<?> paramClass)
  {
    if (paramClass.equals(V8Object.class)) {
      return new V8Object.Undefined();
    }
    if (paramClass.equals(V8Array.class)) {
      return new V8Array.Undefined();
    }
    return invalid;
  }
  
  public static String getSCMRevision()
  {
    return "Unknown revision ID";
  }
  
  public static V8Value getUndefined()
  {
    return undefined;
  }
  
  public static String getV8Version()
  {
    return _getVersion();
  }
  
  private Object getVarArgContainer(Class<?>[] paramArrayOfClass, int paramInt)
  {
    Class<?> localClass = paramArrayOfClass[(paramArrayOfClass.length - 1)];
    paramArrayOfClass = localClass;
    if (localClass.isArray()) {
      paramArrayOfClass = localClass.getComponentType();
    }
    return Array.newInstance(paramArrayOfClass, paramInt);
  }
  
  public static boolean isLoaded()
  {
    return nativeLibraryLoaded;
  }
  
  private boolean isVoidMethod(Method paramMethod)
  {
    return paramMethod.getReturnType().equals(Void.TYPE);
  }
  
  private void notifyReferenceCreated(V8Value paramV8Value)
  {
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleCreated(paramV8Value);
    }
  }
  
  private void notifyReferenceDisposed(V8Value paramV8Value)
  {
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleDisposed(paramV8Value);
    }
  }
  
  private void notifyReleaseHandlers(V8 paramV8)
  {
    Iterator localIterator = this.releaseHandlers.iterator();
    while (localIterator.hasNext()) {
      ((V8Runnable)localIterator.next()).run(paramV8);
    }
  }
  
  private void populateParamters(V8Array paramV8Array, int paramInt, Object[] paramArrayOfObject, List<Object> paramList, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void releaseArguments(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    int j = 0;
    Object localObject1;
    if ((paramBoolean) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof Object[])))
    {
      localObject1 = (Object[])paramArrayOfObject[(paramArrayOfObject.length - 1)];
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof V8Value)) {
          ((V8Value)localObject2).close();
        }
        i += 1;
      }
    }
    int k = paramArrayOfObject.length;
    int i = j;
    while (i < k)
    {
      localObject1 = paramArrayOfObject[i];
      if ((localObject1 instanceof V8Value)) {
        ((V8Value)localObject1).close();
      }
      i += 1;
    }
  }
  
  private void releaseNativeMethodDescriptors()
  {
    Iterator localIterator = this.functionRegistry.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      releaseMethodDescriptor(this.v8RuntimePtr, localLong.longValue());
    }
  }
  
  private void releaseResources()
  {
    Object localObject = this.resources;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Releasable)((Iterator)localObject).next()).release();
      }
      this.resources.clear();
      this.resources = null;
    }
  }
  
  private Object[] setDefaultValues(Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, V8Object paramV8Object, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      paramArrayOfObject[0] = paramV8Object;
      i = 1;
    }
    while (i < paramArrayOfObject.length)
    {
      paramArrayOfObject[i] = getDefaultValue(paramArrayOfClass[i]);
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  public static void setFlags(String paramString)
  {
    v8Flags = paramString;
    initialized = false;
  }
  
  protected void acquireLock(long paramLong)
  {
    _acquireLock(paramLong);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, double paramDouble)
  {
    _add(paramLong1, paramLong2, paramString, paramDouble);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    _add(paramLong1, paramLong2, paramString, paramInt);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    _add(paramLong1, paramLong2, paramString1, paramString2);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    _add(paramLong1, paramLong2, paramString, paramBoolean);
  }
  
  protected void addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    _addArrayBooleanItem(paramLong1, paramLong2, paramBoolean);
  }
  
  protected void addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble)
  {
    _addArrayDoubleItem(paramLong1, paramLong2, paramDouble);
  }
  
  protected void addArrayIntItem(long paramLong1, long paramLong2, int paramInt)
  {
    _addArrayIntItem(paramLong1, paramLong2, paramInt);
  }
  
  protected void addArrayNullItem(long paramLong1, long paramLong2)
  {
    _addArrayNullItem(paramLong1, paramLong2);
  }
  
  protected void addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3)
  {
    _addArrayObjectItem(paramLong1, paramLong2, paramLong3);
  }
  
  protected void addArrayStringItem(long paramLong1, long paramLong2, String paramString)
  {
    _addArrayStringItem(paramLong1, paramLong2, paramString);
  }
  
  protected void addArrayUndefinedItem(long paramLong1, long paramLong2)
  {
    _addArrayUndefinedItem(paramLong1, paramLong2);
  }
  
  protected void addNull(long paramLong1, long paramLong2, String paramString)
  {
    _addNull(paramLong1, paramLong2, paramString);
  }
  
  void addObjRef(V8Value paramV8Value)
  {
    this.objectReferences += 1L;
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceCreated(paramV8Value);
    }
  }
  
  protected void addObject(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    _addObject(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  public void addReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    this.referenceHandlers.add(0, paramReferenceHandler);
  }
  
  public void addReleaseHandler(V8Runnable paramV8Runnable)
  {
    this.releaseHandlers.add(paramV8Runnable);
  }
  
  protected void addUndefined(long paramLong1, long paramLong2, String paramString)
  {
    _addUndefined(paramLong1, paramLong2, paramString);
  }
  
  protected Object arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    return _arrayGet(paramLong1, paramInt1, paramLong2, paramInt2);
  }
  
  protected boolean arrayGetBoolean(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetBoolean(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    return _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfBoolean);
  }
  
  protected boolean[] arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected byte arrayGetByte(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetByte(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  protected byte[] arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected double arrayGetDouble(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetDouble(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    return _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfDouble);
  }
  
  protected double[] arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int arrayGetInteger(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetInteger(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  protected int[] arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int arrayGetSize(long paramLong1, long paramLong2)
  {
    return _arrayGetSize(paramLong1, paramLong2);
  }
  
  protected String arrayGetString(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetString(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    return _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfString);
  }
  
  protected String[] arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  /* Error */
  protected Object callObjectJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   4: lload_1
    //   5: invokestatic 679	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: invokeinterface 681 2 0
    //   13: checkcast 353	com/eclipsesource/v8/V8$MethodDescriptor
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 685	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   23: ifnull +21 -> 44
    //   26: aload_0
    //   27: aload 6
    //   29: getfield 685	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   32: aload_3
    //   33: aload 4
    //   35: invokeinterface 691 3 0
    //   40: invokespecial 693	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload 6
    //   46: getfield 357	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   49: invokevirtual 696	java/lang/reflect/Method:isVarArgs	()Z
    //   52: istore 5
    //   54: aload_0
    //   55: aload_3
    //   56: aload 6
    //   58: aload 4
    //   60: iload 5
    //   62: invokespecial 698	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   65: astore_3
    //   66: aload_0
    //   67: aload_3
    //   68: invokespecial 700	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   71: aload_0
    //   72: aload 6
    //   74: getfield 357	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   77: aload 6
    //   79: getfield 703	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   82: aload_3
    //   83: invokevirtual 706	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   86: invokespecial 693	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: astore 4
    //   91: aload_0
    //   92: aload_3
    //   93: iload 5
    //   95: invokespecial 708	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   98: aload 4
    //   100: areturn
    //   101: astore 4
    //   103: goto +21 -> 124
    //   106: astore 4
    //   108: aload 4
    //   110: athrow
    //   111: astore 4
    //   113: aload 4
    //   115: athrow
    //   116: astore 4
    //   118: aload 4
    //   120: invokevirtual 712	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   123: athrow
    //   124: aload_0
    //   125: aload_3
    //   126: iload 5
    //   128: invokespecial 708	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   131: aload 4
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	V8
    //   0	134	1	paramLong	long
    //   0	134	3	paramV8Object	V8Object
    //   0	134	4	paramV8Array	V8Array
    //   52	75	5	bool	boolean
    //   16	62	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   71	91	101	finally
    //   108	111	101	finally
    //   113	116	101	finally
    //   118	124	101	finally
    //   71	91	106	java/lang/IllegalArgumentException
    //   71	91	111	java/lang/IllegalAccessException
    //   71	91	116	java/lang/reflect/InvocationTargetException
  }
  
  /* Error */
  protected void callVoidJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   4: lload_1
    //   5: invokestatic 679	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: invokeinterface 681 2 0
    //   13: checkcast 353	com/eclipsesource/v8/V8$MethodDescriptor
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 718	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   23: ifnull +17 -> 40
    //   26: aload 6
    //   28: getfield 718	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   31: aload_3
    //   32: aload 4
    //   34: invokeinterface 723 3 0
    //   39: return
    //   40: aload 6
    //   42: getfield 357	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   45: invokevirtual 696	java/lang/reflect/Method:isVarArgs	()Z
    //   48: istore 5
    //   50: aload_0
    //   51: aload_3
    //   52: aload 6
    //   54: aload 4
    //   56: iload 5
    //   58: invokespecial 698	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   61: astore_3
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial 700	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   67: aload 6
    //   69: getfield 357	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   72: aload 6
    //   74: getfield 703	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   77: aload_3
    //   78: invokevirtual 706	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: iload 5
    //   86: invokespecial 708	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   89: return
    //   90: astore 4
    //   92: goto +21 -> 113
    //   95: astore 4
    //   97: aload 4
    //   99: athrow
    //   100: astore 4
    //   102: aload 4
    //   104: athrow
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 712	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   112: athrow
    //   113: aload_0
    //   114: aload_3
    //   115: iload 5
    //   117: invokespecial 708	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   120: aload 4
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	V8
    //   0	123	1	paramLong	long
    //   0	123	3	paramV8Object	V8Object
    //   0	123	4	paramV8Array	V8Array
    //   48	68	5	bool	boolean
    //   16	57	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   67	82	90	finally
    //   97	100	90	finally
    //   102	105	90	finally
    //   107	113	90	finally
    //   67	82	95	java/lang/IllegalArgumentException
    //   67	82	100	java/lang/IllegalAccessException
    //   67	82	105	java/lang/reflect/InvocationTargetException
  }
  
  void checkRuntime(V8Value paramV8Value)
  {
    if (paramV8Value != null)
    {
      if (paramV8Value.isUndefined()) {
        return;
      }
      paramV8Value = paramV8Value.getRuntime();
      if ((paramV8Value != null) && (!paramV8Value.isReleased()) && (paramV8Value == this)) {
        return;
      }
      throw new Error("Invalid target runtime");
    }
  }
  
  void checkThread()
  {
    this.locker.checkThread();
    if (!isReleased()) {
      return;
    }
    throw new Error("Runtime disposed error");
  }
  
  protected void clearWeak(long paramLong1, long paramLong2)
  {
    _clearWeak(paramLong1, paramLong2);
  }
  
  public void close()
  {
    release(true);
  }
  
  protected boolean contains(long paramLong1, long paramLong2, String paramString)
  {
    return _contains(paramLong1, paramLong2, paramString);
  }
  
  void createAndRegisterMethodDescriptor(JavaCallback paramJavaCallback, long paramLong)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.callback = paramJavaCallback;
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  public long createInspector(V8InspectorDelegate paramV8InspectorDelegate, String paramString)
  {
    return _createInspector(this.v8RuntimePtr, paramV8InspectorDelegate, paramString);
  }
  
  void createNodeRuntime(String paramString)
  {
    _startNodeJS(this.v8RuntimePtr, paramString);
  }
  
  protected void createTwin(long paramLong1, long paramLong2, long paramLong3)
  {
    _createTwin(paramLong1, paramLong2, paramLong3);
  }
  
  protected void createTwin(V8Value paramV8Value1, V8Value paramV8Value2)
  {
    checkThread();
    createTwin(this.v8RuntimePtr, paramV8Value1.getHandle(), paramV8Value2.getHandle());
  }
  
  protected ByteBuffer createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt)
  {
    return _createV8ArrayBufferBackingStore(paramLong1, paramLong2, paramInt);
  }
  
  public void dispatchProtocolMessage(long paramLong, String paramString)
  {
    checkThread();
    _dispatchProtocolMessage(this.v8RuntimePtr, paramLong, paramString);
  }
  
  protected void disposeMethodID(long paramLong)
  {
    this.functionRegistry.remove(Long.valueOf(paramLong));
  }
  
  protected boolean equals(long paramLong1, long paramLong2, long paramLong3)
  {
    return _equals(paramLong1, paramLong2, paramLong3);
  }
  
  public V8Array executeArrayScript(String paramString)
  {
    return executeArrayScript(paramString, null, 0);
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt);
    if ((paramString1 instanceof V8Array)) {
      return (V8Array)paramString1;
    }
    throw new V8ResultUndefined();
  }
  
  protected boolean executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeBooleanFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected boolean executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeBooleanScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public boolean executeBooleanScript(String paramString)
  {
    return executeBooleanScript(paramString, null, 0);
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeBooleanScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected double executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeDoubleFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected double executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeDoubleScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public double executeDoubleScript(String paramString)
  {
    return executeDoubleScript(paramString, null, 0);
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeDoubleScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected Object executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3)
  {
    return _executeFunction(paramLong1, paramInt, paramLong2, paramString, paramLong3);
  }
  
  protected Object executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return _executeFunction(paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  protected int executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeIntegerFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected int executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeIntegerScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public int executeIntegerScript(String paramString)
  {
    return executeIntegerScript(paramString, null, 0);
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeIntegerScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  public Object executeModule(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    checkThread();
    checkScript(paramString1);
    long l = getV8RuntimePtr();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    return executeScript(l, 0, localStringBuilder.toString(), paramString4, 0);
  }
  
  public V8Object executeObjectScript(String paramString)
  {
    return executeObjectScript(paramString, null, 0);
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt);
    if ((paramString1 instanceof V8Object)) {
      return (V8Object)paramString1;
    }
    throw new V8ResultUndefined();
  }
  
  protected Object executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    return _executeScript(paramLong, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public Object executeScript(String paramString)
  {
    return executeScript(paramString, null, 0);
  }
  
  public Object executeScript(String paramString1, String paramString2)
  {
    checkThread();
    checkScript(paramString1);
    return executeScript(getV8RuntimePtr(), 0, paramString1, paramString2, 0);
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeScript(getV8RuntimePtr(), 0, paramString1, paramString2, paramInt);
  }
  
  protected String executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeStringFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected String executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeStringScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public String executeStringScript(String paramString)
  {
    return executeStringScript(paramString, null, 0);
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeStringScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected void executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    _executeVoidFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected void executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    _executeVoidScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public void executeVoidScript(String paramString)
  {
    executeVoidScript(paramString, null, 0);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    executeVoidScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected Object get(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    return _get(paramLong1, paramInt, paramLong2, paramString);
  }
  
  protected int getArrayType(long paramLong1, long paramLong2)
  {
    return _getArrayType(paramLong1, paramLong2);
  }
  
  protected boolean getBoolean(long paramLong1, long paramLong2, String paramString)
  {
    return _getBoolean(paramLong1, paramLong2, paramString);
  }
  
  protected String getConstructorName(long paramLong1, long paramLong2)
  {
    return _getConstructorName(paramLong1, paramLong2);
  }
  
  public Object getData(String paramString)
  {
    Map localMap = this.data;
    if (localMap == null) {
      return null;
    }
    return localMap.get(paramString);
  }
  
  protected double getDouble(long paramLong1, long paramLong2, String paramString)
  {
    return _getDouble(paramLong1, paramLong2, paramString);
  }
  
  protected int getInteger(long paramLong1, long paramLong2, String paramString)
  {
    return _getInteger(paramLong1, paramLong2, paramString);
  }
  
  protected String[] getKeys(long paramLong1, long paramLong2)
  {
    return _getKeys(paramLong1, paramLong2);
  }
  
  public V8Locker getLocker()
  {
    return this.locker;
  }
  
  public long getObjectReferenceCount()
  {
    return this.objectReferences - this.v8WeakReferences.size();
  }
  
  protected String getString(long paramLong1, long paramLong2, String paramString)
  {
    return _getString(paramLong1, paramLong2, paramString);
  }
  
  protected int getType(long paramLong1, long paramLong2)
  {
    return _getType(paramLong1, paramLong2);
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt)
  {
    return _getType(paramLong1, paramLong2, paramInt);
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _getType(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int getType(long paramLong1, long paramLong2, String paramString)
  {
    return _getType(paramLong1, paramLong2, paramString);
  }
  
  protected long getV8RuntimePtr()
  {
    return this.v8RuntimePtr;
  }
  
  protected int identityHash(long paramLong1, long paramLong2)
  {
    return _identityHash(paramLong1, paramLong2);
  }
  
  protected long initEmptyContainer(long paramLong)
  {
    return _initEmptyContainer(paramLong);
  }
  
  protected long initNewV8Array(long paramLong)
  {
    return _initNewV8Array(paramLong);
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, int paramInt)
  {
    return _initNewV8ArrayBuffer(paramLong, paramInt);
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    return _initNewV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
  }
  
  public long initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Float32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Float64Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected long[] initNewV8Function(long paramLong)
  {
    checkThread();
    return _initNewV8Function(paramLong);
  }
  
  public long initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int16Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int8Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected long initNewV8Object(long paramLong)
  {
    return _initNewV8Object(paramLong);
  }
  
  public long initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt16Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt8Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt8ClampedArray(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  boolean isRunning()
  {
    return _isRunning(this.v8RuntimePtr);
  }
  
  protected boolean isWeak(long paramLong1, long paramLong2)
  {
    return _isWeak(paramLong1, paramLong2);
  }
  
  public void lowMemoryNotification()
  {
    checkThread();
    lowMemoryNotification(getV8RuntimePtr());
  }
  
  protected void lowMemoryNotification(long paramLong)
  {
    _lowMemoryNotification(paramLong);
  }
  
  boolean pumpMessageLoop()
  {
    return _pumpMessageLoop(this.v8RuntimePtr);
  }
  
  void registerCallback(JavaCallback paramJavaCallback, long paramLong, String paramString)
  {
    createAndRegisterMethodDescriptor(paramJavaCallback, registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, false));
  }
  
  void registerCallback(Object paramObject, Method paramMethod, long paramLong, String paramString, boolean paramBoolean)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.object = paramObject;
    localMethodDescriptor.method = paramMethod;
    localMethodDescriptor.includeReceiver = paramBoolean;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, isVoidMethod(paramMethod));
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  protected long registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    return _registerJavaMethod(paramLong1, paramLong2, paramString, paramBoolean);
  }
  
  public void registerResource(Releasable paramReleasable)
  {
    checkThread();
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(paramReleasable);
  }
  
  void registerVoidCallback(JavaVoidCallback paramJavaVoidCallback, long paramLong, String paramString)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.voidCallback = paramJavaVoidCallback;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, true);
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  @Deprecated
  public void release()
  {
    release(true);
  }
  
  protected void release(long paramLong1, long paramLong2)
  {
    _release(paramLong1, paramLong2);
  }
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 731	com/eclipsesource/v8/V8:isReleased	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 119	com/eclipsesource/v8/V8:checkThread	()V
    //   12: aload_0
    //   13: aload_0
    //   14: invokespecial 993	com/eclipsesource/v8/V8:notifyReleaseHandlers	(Lcom/eclipsesource/v8/V8;)V
    //   17: aload_0
    //   18: invokespecial 995	com/eclipsesource/v8/V8:releaseResources	()V
    //   21: aload_0
    //   22: invokespecial 997	com/eclipsesource/v8/V8:releaseNativeMethodDescriptors	()V
    //   25: getstatic 52	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   28: astore_2
    //   29: aload_2
    //   30: monitorenter
    //   31: getstatic 54	com/eclipsesource/v8/V8:runtimeCounter	I
    //   34: iconst_1
    //   35: isub
    //   36: putstatic 54	com/eclipsesource/v8/V8:runtimeCounter	I
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 91	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   46: invokespecial 999	com/eclipsesource/v8/V8:_releaseRuntime	(J)V
    //   49: aload_0
    //   50: lconst_0
    //   51: putfield 91	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 107	com/eclipsesource/v8/V8:released	Z
    //   59: iload_1
    //   60: ifeq +50 -> 110
    //   63: aload_0
    //   64: invokevirtual 1001	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   67: lconst_0
    //   68: lcmp
    //   69: ifgt +4 -> 73
    //   72: return
    //   73: new 316	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: aload_0
    //   83: invokevirtual 1001	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   86: invokevirtual 1004	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: ldc_w 1006
    //   94: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 1008	java/lang/IllegalStateException
    //   101: dup
    //   102: aload_2
    //   103: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 1009	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   109: athrow
    //   110: return
    //   111: astore_3
    //   112: aload_2
    //   113: monitorexit
    //   114: aload_3
    //   115: athrow
    //   116: astore_3
    //   117: aload_0
    //   118: invokespecial 995	com/eclipsesource/v8/V8:releaseResources	()V
    //   121: aload_0
    //   122: invokespecial 997	com/eclipsesource/v8/V8:releaseNativeMethodDescriptors	()V
    //   125: getstatic 52	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   128: astore_2
    //   129: aload_2
    //   130: monitorenter
    //   131: getstatic 54	com/eclipsesource/v8/V8:runtimeCounter	I
    //   134: iconst_1
    //   135: isub
    //   136: putstatic 54	com/eclipsesource/v8/V8:runtimeCounter	I
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 91	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   146: invokespecial 999	com/eclipsesource/v8/V8:_releaseRuntime	(J)V
    //   149: aload_0
    //   150: lconst_0
    //   151: putfield 91	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield 107	com/eclipsesource/v8/V8:released	Z
    //   159: iload_1
    //   160: ifeq +49 -> 209
    //   163: aload_0
    //   164: invokevirtual 1001	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifle +40 -> 209
    //   172: new 316	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: aload_0
    //   182: invokevirtual 1001	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   185: invokevirtual 1004	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_2
    //   190: ldc_w 1006
    //   193: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: new 1008	java/lang/IllegalStateException
    //   200: dup
    //   201: aload_2
    //   202: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 1009	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: aload_3
    //   210: athrow
    //   211: astore_3
    //   212: aload_2
    //   213: monitorexit
    //   214: aload_3
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	V8
    //   0	216	1	paramBoolean	boolean
    //   111	4	3	localObject2	Object
    //   116	94	3	localObject3	Object
    //   211	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   31	41	111	finally
    //   112	114	111	finally
    //   12	17	116	finally
    //   131	141	211	finally
    //   212	214	211	finally
  }
  
  protected void releaseLock(long paramLong)
  {
    _releaseLock(paramLong);
  }
  
  protected void releaseMethodDescriptor(long paramLong1, long paramLong2)
  {
    _releaseMethodDescriptor(paramLong1, paramLong2);
  }
  
  void releaseObjRef(V8Value paramV8Value)
  {
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceDisposed(paramV8Value);
    }
    this.objectReferences -= 1L;
  }
  
  public void removeReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    this.referenceHandlers.remove(paramReferenceHandler);
  }
  
  public void removeReleaseHandler(V8Runnable paramV8Runnable)
  {
    this.releaseHandlers.remove(paramV8Runnable);
  }
  
  protected boolean sameValue(long paramLong1, long paramLong2, long paramLong3)
  {
    return _sameValue(paramLong1, paramLong2, paramLong3);
  }
  
  public void schedulePauseOnNextStatement(long paramLong, String paramString)
  {
    checkThread();
    _schedulePauseOnNextStatement(this.v8RuntimePtr, paramLong, paramString);
  }
  
  public void setData(String paramString, Object paramObject)
  {
    try
    {
      if (this.data == null) {
        this.data = new HashMap();
      }
      this.data.put(paramString, paramObject);
      return;
    }
    finally {}
  }
  
  protected void setPrototype(long paramLong1, long paramLong2, long paramLong3)
  {
    _setPrototype(paramLong1, paramLong2, paramLong3);
  }
  
  public void setSignatureProvider(SignatureProvider paramSignatureProvider)
  {
    this.signatureProvider = paramSignatureProvider;
  }
  
  protected void setWeak(long paramLong1, long paramLong2)
  {
    _setWeak(paramLong1, paramLong2);
  }
  
  protected boolean strictEquals(long paramLong1, long paramLong2, long paramLong3)
  {
    return _strictEquals(paramLong1, paramLong2, paramLong3);
  }
  
  public void terminateExecution()
  {
    this.forceTerminateExecutors = true;
    terminateExecution(this.v8RuntimePtr);
  }
  
  protected void terminateExecution(long paramLong)
  {
    _terminateExecution(paramLong);
  }
  
  protected String toString(long paramLong1, long paramLong2)
  {
    return _toString(paramLong1, paramLong2);
  }
  
  protected void weakReferenceReleased(long paramLong)
  {
    V8Value localV8Value = (V8Value)this.v8WeakReferences.get(Long.valueOf(paramLong));
    if (localV8Value != null) {
      this.v8WeakReferences.remove(Long.valueOf(paramLong));
    }
    try
    {
      localV8Value.close();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8
 * JD-Core Version:    0.7.0.1
 */