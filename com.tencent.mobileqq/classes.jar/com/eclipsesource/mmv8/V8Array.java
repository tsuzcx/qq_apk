package com.eclipsesource.mmv8;

public class V8Array
  extends V8Object
{
  protected V8Array() {}
  
  public V8Array(V8 paramV8)
  {
    super(paramV8);
    paramV8.checkThread();
  }
  
  protected V8Array(V8 paramV8, Object paramObject)
  {
    super(paramV8, paramObject);
  }
  
  protected V8Value createTwin()
  {
    return new V8Array(this.v8);
  }
  
  public Object get(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
  }
  
  public V8Array getArray(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramInt);
    if ((localObject != null) && (!(localObject instanceof V8Array))) {
      throw new V8ResultUndefined();
    }
    return (V8Array)localObject;
  }
  
  public boolean getBoolean(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getBooleans(int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 <= paramArrayOfBoolean.length) {
      return this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfBoolean);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public boolean[] getBooleans(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  public byte getByte(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 <= paramArrayOfByte.length) {
      return this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfByte);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  public double getDouble(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getDoubles(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 <= paramArrayOfDouble.length) {
      return this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfDouble);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public double[] getDoubles(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  public int getInteger(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getIntegers(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 <= paramArrayOfInt.length) {
      return this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfInt);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public int[] getIntegers(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  public V8Object getObject(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
    if ((localObject != null) && (!(localObject instanceof V8Object))) {
      throw new V8ResultUndefined();
    }
    return (V8Object)localObject;
  }
  
  public String getString(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getStrings(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 <= paramArrayOfString.length) {
      return this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfString);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String[] getStrings(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  public int getType()
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
  }
  
  public int getType(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    paramLong = this.v8.initNewV8Array(paramLong);
    this.released = false;
    addObjectReference(paramLong);
  }
  
  public int length()
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
  }
  
  public V8Array push(double paramDouble)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), paramDouble);
    return this;
  }
  
  public V8Array push(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    return this;
  }
  
  public V8Array push(V8Value paramV8Value)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Value);
    if (paramV8Value == null)
    {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    if (paramV8Value.equals(V8.getUndefined()))
    {
      this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), paramV8Value.getHandle());
    return this;
  }
  
  public V8Array push(Object paramObject)
  {
    this.v8.checkThread();
    checkReleased();
    boolean bool = paramObject instanceof V8Value;
    if (bool) {
      this.v8.checkRuntime((V8Value)paramObject);
    }
    if (paramObject == null)
    {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    if (paramObject.equals(V8.getUndefined()))
    {
      this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    if ((paramObject instanceof Double))
    {
      this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double)paramObject).doubleValue());
      return this;
    }
    if ((paramObject instanceof Integer))
    {
      this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer)paramObject).intValue());
      return this;
    }
    if ((paramObject instanceof Float))
    {
      this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float)paramObject).doubleValue());
      return this;
    }
    if ((paramObject instanceof Number))
    {
      this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number)paramObject).doubleValue());
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean)paramObject).booleanValue());
      return this;
    }
    if ((paramObject instanceof String))
    {
      this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String)paramObject);
      return this;
    }
    if (bool)
    {
      this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value)paramObject).getHandle());
      return this;
    }
    throw new IllegalArgumentException();
  }
  
  public V8Array push(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramString == null)
    {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    if (paramString.equals(V8.getUndefined()))
    {
      this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      return this;
    }
    this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), paramString);
    return this;
  }
  
  public V8Array push(boolean paramBoolean)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), paramBoolean);
    return this;
  }
  
  public V8Array pushNull()
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    return this;
  }
  
  public V8Array pushUndefined()
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
    return this;
  }
  
  public String toString()
  {
    if ((!this.released) && (!this.v8.isReleased())) {
      return super.toString();
    }
    return "[Array released]";
  }
  
  public V8Array twin()
  {
    return (V8Array)super.twin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8Array
 * JD-Core Version:    0.7.0.1
 */