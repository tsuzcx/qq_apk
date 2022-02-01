package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractProtobufList<String>
  implements LazyStringList, RandomAccess
{
  public static final LazyStringList a = b;
  private static final LazyStringArrayList b = new LazyStringArrayList();
  private final List<Object> c;
  
  static
  {
    b.b();
  }
  
  public LazyStringArrayList()
  {
    this(10);
  }
  
  public LazyStringArrayList(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList)
  {
    this.c = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  private LazyStringArrayList(ArrayList<Object> paramArrayList)
  {
    this.c = paramArrayList;
  }
  
  private void a(int paramInt, ByteString paramByteString)
  {
    c();
    this.c.add(paramInt, paramByteString);
    this.modCount += 1;
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    c();
    this.c.add(paramInt, paramArrayOfByte);
    this.modCount += 1;
  }
  
  private Object b(int paramInt, ByteString paramByteString)
  {
    c();
    return this.c.set(paramInt, paramByteString);
  }
  
  private Object b(int paramInt, byte[] paramArrayOfByte)
  {
    c();
    return this.c.set(paramInt, paramArrayOfByte);
  }
  
  private static String c(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof ByteString)) {
      return ((ByteString)paramObject).toStringUtf8();
    }
    return Internal.b((byte[])paramObject);
  }
  
  private static ByteString d(Object paramObject)
  {
    if ((paramObject instanceof ByteString)) {
      return (ByteString)paramObject;
    }
    if ((paramObject instanceof String)) {
      return ByteString.copyFromUtf8((String)paramObject);
    }
    return ByteString.copyFrom((byte[])paramObject);
  }
  
  private static byte[] e(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return Internal.a((String)paramObject);
    }
    return ((ByteString)paramObject).toByteArray();
  }
  
  public LazyStringArrayList a(int paramInt)
  {
    if (paramInt >= size())
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      localArrayList.addAll(this.c);
      return new LazyStringArrayList(localArrayList);
    }
    throw new IllegalArgumentException();
  }
  
  public String a(int paramInt, String paramString)
  {
    c();
    return c(this.c.set(paramInt, paramString));
  }
  
  public void a(ByteString paramByteString)
  {
    c();
    this.c.add(paramByteString);
    this.modCount += 1;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    c();
    Object localObject = paramCollection;
    if ((paramCollection instanceof LazyStringList)) {
      localObject = ((LazyStringList)paramCollection).d();
    }
    boolean bool = this.c.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public String b(int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if ((localObject instanceof ByteString))
    {
      localObject = (ByteString)localObject;
      str = ((ByteString)localObject).toStringUtf8();
      if (((ByteString)localObject).isValidUtf8()) {
        this.c.set(paramInt, str);
      }
      return str;
    }
    localObject = (byte[])localObject;
    String str = Internal.b((byte[])localObject);
    if (Internal.a((byte[])localObject)) {
      this.c.set(paramInt, str);
    }
    return str;
  }
  
  public void b(int paramInt, String paramString)
  {
    c();
    this.c.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public String c(int paramInt)
  {
    c();
    Object localObject = this.c.remove(paramInt);
    this.modCount += 1;
    return c(localObject);
  }
  
  public void clear()
  {
    c();
    this.c.clear();
    this.modCount += 1;
  }
  
  public Object d(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public List<?> d()
  {
    return Collections.unmodifiableList(this.c);
  }
  
  public LazyStringList e()
  {
    if (a()) {
      return new UnmodifiableLazyStringList(this);
    }
    return this;
  }
  
  public ByteString f(int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    ByteString localByteString = d(localObject);
    if (localByteString != localObject) {
      this.c.set(paramInt, localByteString);
    }
    return localByteString;
  }
  
  public byte[] g(int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    byte[] arrayOfByte = e(localObject);
    if (arrayOfByte != localObject) {
      this.c.set(paramInt, arrayOfByte);
    }
    return arrayOfByte;
  }
  
  public int size()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyStringArrayList
 * JD-Core Version:    0.7.0.1
 */