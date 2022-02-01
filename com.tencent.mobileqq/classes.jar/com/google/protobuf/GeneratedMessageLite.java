package com.google.protobuf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends GeneratedMessageLite.Builder<MessageType, BuilderType>>
  extends AbstractMessageLite<MessageType, BuilderType>
{
  private static Map<Object, GeneratedMessageLite<?, ?>> c = new ConcurrentHashMap();
  protected UnknownFieldSetLite a = UnknownFieldSetLite.a();
  protected int b = -1;
  
  static <T extends GeneratedMessageLite<T, ?>> T a(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramT = (GeneratedMessageLite)paramT.a(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    try
    {
      Protobuf.a().a(paramT).a(paramT, CodedInputStreamReader.a(paramCodedInputStream), paramExtensionRegistryLite);
      paramT.c();
      return paramT;
    }
    catch (RuntimeException paramT)
    {
      if ((paramT.getCause() instanceof InvalidProtocolBufferException)) {
        throw ((InvalidProtocolBufferException)paramT.getCause());
      }
      throw paramT;
    }
    catch (IOException paramCodedInputStream)
    {
      if ((paramCodedInputStream.getCause() instanceof InvalidProtocolBufferException)) {
        throw ((InvalidProtocolBufferException)paramCodedInputStream.getCause());
      }
      throw new InvalidProtocolBufferException(paramCodedInputStream.getMessage()).setUnfinishedMessage(paramT);
    }
  }
  
  static <T extends GeneratedMessageLite<T, ?>> T a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramT = (GeneratedMessageLite)paramT.a(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    try
    {
      Protobuf.a().a(paramT).a(paramT, paramArrayOfByte, paramInt1, paramInt1 + paramInt2, new ArrayDecoders.Registers(paramExtensionRegistryLite));
      paramT.c();
      if (paramT.memoizedHashCode == 0) {
        return paramT;
      }
      throw new RuntimeException();
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(paramArrayOfByte.getCause() instanceof InvalidProtocolBufferException)) {
        break label86;
      }
      throw ((InvalidProtocolBufferException)paramArrayOfByte.getCause());
      throw new InvalidProtocolBufferException(paramArrayOfByte.getMessage()).setUnfinishedMessage(paramT);
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      label59:
      break label59;
    }
    throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(paramT);
  }
  
  static <T extends GeneratedMessageLite<?, ?>> T a(Class<T> paramClass)
  {
    GeneratedMessageLite localGeneratedMessageLite2 = (GeneratedMessageLite)c.get(paramClass);
    GeneratedMessageLite localGeneratedMessageLite1 = localGeneratedMessageLite2;
    if (localGeneratedMessageLite2 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localGeneratedMessageLite1 = (GeneratedMessageLite)c.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    if (localGeneratedMessageLite1 == null)
    {
      localGeneratedMessageLite1 = ((GeneratedMessageLite)UnsafeUtil.a(paramClass)).a();
      if (localGeneratedMessageLite1 != null)
      {
        c.put(paramClass, localGeneratedMessageLite1);
        return localGeneratedMessageLite1;
      }
      throw new IllegalStateException();
    }
    return localGeneratedMessageLite1;
  }
  
  static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  public final MessageType a()
  {
    return (GeneratedMessageLite)a(GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE);
  }
  
  protected Object a(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke)
  {
    return a(paramMethodToInvoke, null, null);
  }
  
  protected abstract Object a(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2);
  
  public final BuilderType b()
  {
    return (GeneratedMessageLite.Builder)a(GeneratedMessageLite.MethodToInvoke.NEW_BUILDER);
  }
  
  protected void c()
  {
    Protobuf.a().a(this).d(this);
  }
  
  Object d()
  {
    return a(GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!a().getClass().isInstance(paramObject)) {
      return false;
    }
    return Protobuf.a().a(this).a(this, (GeneratedMessageLite)paramObject);
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    this.memoizedHashCode = Protobuf.a().a(this).a(this);
    return this.memoizedHashCode;
  }
  
  public String toString()
  {
    return MessageLiteToString.a(this, super.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite
 * JD-Core Version:    0.7.0.1
 */