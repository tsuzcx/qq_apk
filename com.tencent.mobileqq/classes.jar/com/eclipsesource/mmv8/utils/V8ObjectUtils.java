package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8TypedArray;
import com.eclipsesource.mmv8.V8Value;
import com.eclipsesource.mmv8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.mmv8.utils.typedarrays.Float32Array;
import com.eclipsesource.mmv8.utils.typedarrays.Float64Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int16Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int32Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int8Array;
import com.eclipsesource.mmv8.utils.typedarrays.TypedArray;
import com.eclipsesource.mmv8.utils.typedarrays.UInt16Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt32Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt8Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt8ClampedArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8ObjectUtils
{
  private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new V8ObjectUtils.DefaultTypeAdapter();
  private static final Object IGNORE = new Object();
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt)
  {
    int i = paramV8Array.length();
    if (paramInt == 1) {
      return paramV8Array.getIntegers(0, i);
    }
    if (paramInt == 2) {
      return paramV8Array.getDoubles(0, i);
    }
    if (paramInt == 3) {
      return paramV8Array.getBooleans(0, i);
    }
    if (paramInt == 4) {
      return paramV8Array.getStrings(0, i);
    }
    paramV8Array = new StringBuilder();
    paramV8Array.append("Unsupported bulk load type: ");
    paramV8Array.append(paramInt);
    throw new RuntimeException(paramV8Array.toString());
  }
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt, Object paramObject)
  {
    int i = paramV8Array.length();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (int[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new int[i];
      }
      paramV8Array.getIntegers(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 2)
    {
      localObject = (double[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new double[i];
      }
      paramV8Array.getDoubles(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 3)
    {
      localObject = (boolean[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new boolean[i];
      }
      paramV8Array.getBooleans(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 4)
    {
      localObject = (String[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new String[i];
      }
      paramV8Array.getStrings(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 9)
    {
      localObject = (byte[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new byte[i];
      }
      paramV8Array.getBytes(0, i, paramObject);
      return paramObject;
    }
    paramV8Array = new StringBuilder();
    paramV8Array.append("Unsupported bulk load type: ");
    paramV8Array.append(paramInt);
    throw new RuntimeException(paramV8Array.toString());
  }
  
  public static Object getV8Result(V8 paramV8, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = getV8Result(paramV8, paramObject, localHashtable);
      if ((paramV8 instanceof V8Object))
      {
        paramV8 = ((V8Object)paramV8).twin();
        paramObject = localHashtable.values().iterator();
        while (paramObject.hasNext()) {
          ((V8Value)paramObject.next()).release();
        }
        return paramV8;
      }
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
      return paramV8;
    }
    finally
    {
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  private static Object getV8Result(V8 paramV8, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramObject)) {
      return paramMap.get(paramObject);
    }
    if ((paramObject instanceof Map)) {
      return toV8Object(paramV8, (Map)paramObject, paramMap);
    }
    if ((paramObject instanceof List)) {
      return toV8Array(paramV8, (List)paramObject, paramMap);
    }
    if ((paramObject instanceof TypedArray)) {
      return toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap);
    }
    if ((paramObject instanceof ArrayBuffer)) {
      return toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap);
    }
    return paramObject;
  }
  
  public static Object getV8Result(V8Context paramV8Context, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = getV8Result(paramV8Context, paramObject, localHashtable);
      if ((paramV8Context instanceof V8Object))
      {
        paramV8Context = ((V8Object)paramV8Context).twin();
        paramObject = localHashtable.values().iterator();
        while (paramObject.hasNext()) {
          ((V8Value)paramObject.next()).release();
        }
        return paramV8Context;
      }
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
      return paramV8Context;
    }
    finally
    {
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static Object getV8Result(V8Context paramV8Context, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramObject)) {
      return paramMap.get(paramObject);
    }
    if ((paramObject instanceof Map)) {
      return toV8Object(paramV8Context, (Map)paramObject, paramMap);
    }
    if ((paramObject instanceof List)) {
      return toV8Array(paramV8Context, (List)paramObject, paramMap);
    }
    if ((paramObject instanceof TypedArray)) {
      return toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap);
    }
    if ((paramObject instanceof ArrayBuffer)) {
      return toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap);
    }
    return paramObject;
  }
  
  /* Error */
  public static Object getValue(V8Array paramV8Array, int paramInt)
  {
    // Byte code:
    //   0: new 188	com/eclipsesource/mmv8/utils/V8Map
    //   3: dup
    //   4: invokespecial 189	com/eclipsesource/mmv8/utils/V8Map:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 192	com/eclipsesource/mmv8/V8Array:get	(I)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: aload_0
    //   17: iload_1
    //   18: invokevirtual 196	com/eclipsesource/mmv8/V8Array:getType	(I)I
    //   21: aload 4
    //   23: getstatic 20	com/eclipsesource/mmv8/utils/V8ObjectUtils:DEFAULT_TYPE_ADAPTER	Lcom/eclipsesource/mmv8/utils/TypeAdapter;
    //   26: invokestatic 199	com/eclipsesource/mmv8/utils/V8ObjectUtils:getValue	(Ljava/lang/Object;ILcom/eclipsesource/mmv8/utils/V8Map;Lcom/eclipsesource/mmv8/utils/TypeAdapter;)Ljava/lang/Object;
    //   29: astore_0
    //   30: aload_2
    //   31: instanceof 201
    //   34: ifeq +12 -> 46
    //   37: aload_2
    //   38: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   41: invokeinterface 202 1 0
    //   46: aload 4
    //   48: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   51: aload_0
    //   52: areturn
    //   53: astore_3
    //   54: aload_2
    //   55: astore_0
    //   56: aload_3
    //   57: astore_2
    //   58: goto +6 -> 64
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: instanceof 201
    //   68: ifeq +12 -> 80
    //   71: aload_0
    //   72: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   75: invokeinterface 202 1 0
    //   80: aload 4
    //   82: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramV8Array	V8Array
    //   0	87	1	paramInt	int
    //   14	44	2	localObject1	Object
    //   61	25	2	localObject2	Object
    //   53	4	3	localObject3	Object
    //   7	74	4	localV8Map	V8Map
    // Exception table:
    //   from	to	target	type
    //   15	30	53	finally
    //   9	15	61	finally
  }
  
  /* Error */
  public static Object getValue(V8Array paramV8Array, int paramInt, TypeAdapter paramTypeAdapter)
  {
    // Byte code:
    //   0: new 188	com/eclipsesource/mmv8/utils/V8Map
    //   3: dup
    //   4: invokespecial 189	com/eclipsesource/mmv8/utils/V8Map:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 192	com/eclipsesource/mmv8/V8Array:get	(I)Ljava/lang/Object;
    //   14: astore_3
    //   15: aload_3
    //   16: aload_0
    //   17: iload_1
    //   18: invokevirtual 196	com/eclipsesource/mmv8/V8Array:getType	(I)I
    //   21: aload 4
    //   23: aload_2
    //   24: invokestatic 199	com/eclipsesource/mmv8/utils/V8ObjectUtils:getValue	(Ljava/lang/Object;ILcom/eclipsesource/mmv8/utils/V8Map;Lcom/eclipsesource/mmv8/utils/TypeAdapter;)Ljava/lang/Object;
    //   27: astore_0
    //   28: aload_3
    //   29: instanceof 201
    //   32: ifeq +12 -> 44
    //   35: aload_3
    //   36: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   39: invokeinterface 202 1 0
    //   44: aload 4
    //   46: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_2
    //   52: aload_3
    //   53: astore_0
    //   54: goto +6 -> 60
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: instanceof 201
    //   64: ifeq +12 -> 76
    //   67: aload_0
    //   68: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   71: invokeinterface 202 1 0
    //   76: aload 4
    //   78: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramV8Array	V8Array
    //   0	83	1	paramInt	int
    //   0	83	2	paramTypeAdapter	TypeAdapter
    //   14	39	3	localObject	Object
    //   7	70	4	localV8Map	V8Map
    // Exception table:
    //   from	to	target	type
    //   15	28	51	finally
    //   9	15	57	finally
  }
  
  public static Object getValue(V8Object paramV8Object, String paramString)
  {
    return getValue(paramV8Object, paramString, DEFAULT_TYPE_ADAPTER);
  }
  
  /* Error */
  public static Object getValue(V8Object paramV8Object, String paramString, TypeAdapter paramTypeAdapter)
  {
    // Byte code:
    //   0: new 188	com/eclipsesource/mmv8/utils/V8Map
    //   3: dup
    //   4: invokespecial 189	com/eclipsesource/mmv8/utils/V8Map:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 211	com/eclipsesource/mmv8/V8Object:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: astore_3
    //   15: aload_3
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 214	com/eclipsesource/mmv8/V8Object:getType	(Ljava/lang/String;)I
    //   21: aload 4
    //   23: aload_2
    //   24: invokestatic 199	com/eclipsesource/mmv8/utils/V8ObjectUtils:getValue	(Ljava/lang/Object;ILcom/eclipsesource/mmv8/utils/V8Map;Lcom/eclipsesource/mmv8/utils/TypeAdapter;)Ljava/lang/Object;
    //   27: astore_0
    //   28: aload_3
    //   29: instanceof 201
    //   32: ifeq +12 -> 44
    //   35: aload_3
    //   36: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   39: invokeinterface 202 1 0
    //   44: aload 4
    //   46: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aload_3
    //   53: astore_0
    //   54: goto +6 -> 60
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: instanceof 201
    //   64: ifeq +12 -> 76
    //   67: aload_0
    //   68: checkcast 201	com/eclipsesource/mmv8/Releasable
    //   71: invokeinterface 202 1 0
    //   76: aload 4
    //   78: invokevirtual 203	com/eclipsesource/mmv8/utils/V8Map:release	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramV8Object	V8Object
    //   0	83	1	paramString	String
    //   0	83	2	paramTypeAdapter	TypeAdapter
    //   14	39	3	localObject	Object
    //   7	70	4	localV8Map	V8Map
    // Exception table:
    //   from	to	target	type
    //   15	28	51	finally
    //   9	15	57	finally
  }
  
  public static Object getValue(Object paramObject)
  {
    return getValue(paramObject, DEFAULT_TYPE_ADAPTER);
  }
  
  private static Object getValue(Object paramObject, int paramInt, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    Object localObject = paramTypeAdapter.adapt(paramInt, paramObject);
    if (TypeAdapter.DEFAULT != localObject) {
      return localObject;
    }
    if (paramInt != 10)
    {
      if (paramInt != 99)
      {
        localObject = paramObject;
        switch (paramInt)
        {
        default: 
          paramObject = new StringBuilder();
          paramObject.append("Cannot convert type ");
          paramObject.append(V8Value.getStringRepresentation(paramInt));
          throw new IllegalStateException(paramObject.toString());
        case 8: 
          return toTypedArray((V8Array)paramObject);
        case 7: 
          return IGNORE;
        case 6: 
          return toMap((V8Object)paramObject, paramV8Map, paramTypeAdapter);
        case 5: 
          localObject = toList((V8Array)paramObject, paramV8Map, paramTypeAdapter);
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          return localObject;
        }
        return null;
      }
      return V8.getUndefined();
    }
    return new ArrayBuffer(((V8ArrayBuffer)paramObject).getBackingStore());
  }
  
  public static Object getValue(Object paramObject, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      if ((paramObject instanceof V8Value))
      {
        paramObject = getValue(paramObject, ((V8Value)paramObject).getV8Type(), localV8Map, paramTypeAdapter);
        return paramObject;
      }
      return paramObject;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  public static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      pushValue(paramV8, paramV8Array, paramObject, localHashtable);
      paramV8 = localHashtable.values().iterator();
      while (paramV8.hasNext()) {
        ((V8Value)paramV8.next()).release();
      }
      return;
    }
    finally
    {
      paramV8Array = localHashtable.values().iterator();
      while (paramV8Array.hasNext()) {
        ((V8Value)paramV8Array.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  private static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8, (List)paramObject, paramMap));
      return;
    }
    paramV8 = new StringBuilder();
    paramV8.append("Unsupported Object of type: ");
    paramV8.append(paramObject.getClass());
    throw new IllegalStateException(paramV8.toString());
  }
  
  public static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      pushValue(paramV8Context, paramV8Array, paramObject, localHashtable);
      paramV8Context = localHashtable.values().iterator();
      while (paramV8Context.hasNext()) {
        ((V8Value)paramV8Context.next()).release();
      }
      return;
    }
    finally
    {
      paramV8Array = localHashtable.values().iterator();
      while (paramV8Array.hasNext()) {
        ((V8Value)paramV8Array.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8Context, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8Context, (List)paramObject, paramMap));
      return;
    }
    paramV8Context = new StringBuilder();
    paramV8Context.append("Unsupported Object of type: ");
    paramV8Context.append(paramObject.getClass());
    throw new IllegalStateException(paramV8Context.toString());
  }
  
  private static void setValue(V8 paramV8, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8, (List)paramObject, paramMap));
      return;
    }
    paramV8 = new StringBuilder();
    paramV8.append("Unsupported Object of type: ");
    paramV8.append(paramObject.getClass());
    throw new IllegalStateException(paramV8.toString());
  }
  
  private static void setValue(V8Context paramV8Context, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8Context, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8Context, (List)paramObject, paramMap));
      return;
    }
    paramV8Context = new StringBuilder();
    paramV8Context.append("Unsupported Object of type: ");
    paramV8Context.append(paramObject.getClass());
    throw new IllegalStateException(paramV8Context.toString());
  }
  
  public static List<? super Object> toList(V8Array paramV8Array)
  {
    return toList(paramV8Array, DEFAULT_TYPE_ADAPTER);
  }
  
  public static List<? super Object> toList(V8Array paramV8Array, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Array = toList(paramV8Array, localV8Map, paramTypeAdapter);
      return paramV8Array;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  private static List<? super Object> toList(V8Array paramV8Array, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    if (paramV8Array == null) {
      return Collections.emptyList();
    }
    if (paramV8Map.containsKey(paramV8Array)) {
      return (List)paramV8Map.get(paramV8Array);
    }
    ArrayList localArrayList = new ArrayList();
    paramV8Map.put(paramV8Array, localArrayList);
    int i = 0;
    while (i < paramV8Array.length())
    {
      Object localObject1 = null;
      try
      {
        Object localObject2 = paramV8Array.get(i);
        localObject1 = localObject2;
        Object localObject3 = getValue(localObject2, paramV8Array.getType(i), paramV8Map, paramTypeAdapter);
        localObject1 = localObject2;
        if (localObject3 != IGNORE)
        {
          localObject1 = localObject2;
          localArrayList.add(localObject3);
        }
        if ((localObject2 instanceof Releasable)) {
          ((Releasable)localObject2).release();
        }
        i += 1;
      }
      finally
      {
        if ((localObject1 instanceof Releasable)) {
          ((Releasable)localObject1).release();
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object)
  {
    return toMap(paramV8Object, DEFAULT_TYPE_ADAPTER);
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Object = toMap(paramV8Object, localV8Map, paramTypeAdapter);
      return paramV8Object;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  private static Map<String, ? super Object> toMap(V8Object paramV8Object, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    if (paramV8Object == null) {
      return Collections.emptyMap();
    }
    if (paramV8Map.containsKey(paramV8Object)) {
      return (Map)paramV8Map.get(paramV8Object);
    }
    V8PropertyMap localV8PropertyMap = new V8PropertyMap();
    paramV8Map.put(paramV8Object, localV8PropertyMap);
    String[] arrayOfString = paramV8Object.getKeys();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject1 = null;
      try
      {
        Object localObject2 = paramV8Object.get(str);
        localObject1 = localObject2;
        Object localObject3 = getValue(localObject2, paramV8Object.getType(str), paramV8Map, paramTypeAdapter);
        localObject1 = localObject2;
        if (localObject3 != IGNORE)
        {
          localObject1 = localObject2;
          localV8PropertyMap.put(str, localObject3);
        }
        if ((localObject2 instanceof Releasable)) {
          ((Releasable)localObject2).release();
        }
        i += 1;
      }
      finally
      {
        if ((localObject1 instanceof Releasable)) {
          ((Releasable)localObject1).release();
        }
      }
    }
    return localV8PropertyMap;
  }
  
  private static Object toTypedArray(V8Array paramV8Array)
  {
    int i = paramV8Array.getType();
    paramV8Array = ((V8TypedArray)paramV8Array).getByteBuffer();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 9)
        {
          switch (i)
          {
          default: 
            paramV8Array = new StringBuilder();
            paramV8Array.append("Known Typed Array type: ");
            paramV8Array.append(V8Value.getStringRepresentation(i));
            throw new IllegalStateException(paramV8Array.toString());
          case 16: 
            return new Float32Array(paramV8Array);
          case 15: 
            return new UInt32Array(paramV8Array);
          case 14: 
            return new UInt16Array(paramV8Array);
          case 13: 
            return new Int16Array(paramV8Array);
          case 12: 
            return new UInt8ClampedArray(paramV8Array);
          }
          return new UInt8Array(paramV8Array);
        }
        return new Int8Array(paramV8Array);
      }
      return new Float64Array(paramV8Array);
    }
    return new Int32Array(paramV8Array);
  }
  
  public static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = toV8Array(paramV8, paramList, localHashtable).twin();
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
      return paramV8;
    }
    finally
    {
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  private static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(new V8ObjectUtils.ListWrapper(paramList))) {
      return (V8Array)paramMap.get(new V8ObjectUtils.ListWrapper(paramList));
    }
    V8Array localV8Array = new V8Array(paramV8);
    paramMap.put(new V8ObjectUtils.ListWrapper(paramList), localV8Array);
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        pushValue(paramV8, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      return localV8Array;
    }
    catch (IllegalStateException paramV8)
    {
      localV8Array.release();
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  public static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = toV8Array(paramV8Context, paramList, localHashtable).twin();
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
      return paramV8Context;
    }
    finally
    {
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(new V8ObjectUtils.ListWrapper(paramList))) {
      return (V8Array)paramMap.get(new V8ObjectUtils.ListWrapper(paramList));
    }
    V8Array localV8Array = paramV8Context.newV8Array();
    paramMap.put(new V8ObjectUtils.ListWrapper(paramList), localV8Array);
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        pushValue(paramV8Context, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      return localV8Array;
    }
    catch (IllegalStateException paramV8Context)
    {
      localV8Array.release();
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8 paramV8, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramArrayBuffer)) {
      return (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
    }
    paramV8 = new V8ArrayBuffer(paramV8, paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8);
    return paramV8;
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8Context paramV8Context, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramArrayBuffer)) {
      return (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
    }
    paramV8Context = paramV8Context.newV8ArrayBuffer(paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8Context);
    return paramV8Context;
  }
  
  public static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = toV8Object(paramV8, paramMap, localHashtable).twin();
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
      return paramV8;
    }
    finally
    {
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  private static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    if (paramMap1.containsKey(paramMap)) {
      return (V8Object)paramMap1.get(paramMap);
    }
    V8Object localV8Object = new V8Object(paramV8);
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      return localV8Object;
    }
    catch (IllegalStateException paramV8)
    {
      localV8Object.release();
    }
    for (;;)
    {
      throw paramV8;
    }
  }
  
  public static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = toV8Object(paramV8Context, paramMap, localHashtable).twin();
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
      return paramV8Context;
    }
    finally
    {
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    if (paramMap1.containsKey(paramMap)) {
      return (V8Object)paramMap1.get(paramMap);
    }
    V8Object localV8Object = paramV8Context.newV8Object();
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8Context, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      return localV8Object;
    }
    catch (IllegalStateException paramV8Context)
    {
      localV8Object.release();
    }
    for (;;)
    {
      throw paramV8Context;
    }
  }
  
  private static V8TypedArray toV8TypedArray(V8 paramV8, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramTypedArray)) {
      return (V8TypedArray)paramMap.get(paramTypedArray);
    }
    V8ArrayBuffer localV8ArrayBuffer = new V8ArrayBuffer(paramV8, paramTypedArray.getByteBuffer());
    try
    {
      paramV8 = new V8TypedArray(paramV8, localV8ArrayBuffer, paramTypedArray.getType(), 0, paramTypedArray.length());
      paramMap.put(paramTypedArray, paramV8);
      return paramV8;
    }
    finally
    {
      localV8ArrayBuffer.release();
    }
  }
  
  private static V8TypedArray toV8TypedArray(V8Context paramV8Context, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramTypedArray)) {
      return (V8TypedArray)paramMap.get(paramTypedArray);
    }
    V8ArrayBuffer localV8ArrayBuffer = paramV8Context.newV8ArrayBuffer(paramTypedArray.getByteBuffer());
    try
    {
      paramV8Context = paramV8Context.newV8TypedArray(localV8ArrayBuffer, paramTypedArray.getType(), 0, paramTypedArray.length());
      paramMap.put(paramTypedArray, paramV8Context);
      return paramV8Context;
    }
    finally
    {
      localV8ArrayBuffer.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8ObjectUtils
 * JD-Core Version:    0.7.0.1
 */