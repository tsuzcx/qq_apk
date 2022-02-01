package com.google.protobuf;

import java.io.Serializable;
import java.lang.reflect.Field;

public final class GeneratedMessageLite$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final byte[] asBytes;
  private final Class<?> messageClass;
  private final String messageClassName;
  
  GeneratedMessageLite$SerializedForm(MessageLite paramMessageLite)
  {
    this.messageClass = paramMessageLite.getClass();
    this.messageClassName = this.messageClass.getName();
    this.asBytes = paramMessageLite.toByteArray();
  }
  
  @Deprecated
  private Object a()
  {
    try
    {
      Object localObject = b().getDeclaredField("defaultInstance");
      ((Field)localObject).setAccessible(true);
      localObject = ((MessageLite)((Field)localObject).get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
      return localObject;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
    }
    catch (SecurityException localSecurityException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to call defaultInstance in ");
      localStringBuilder.append(this.messageClassName);
      throw new RuntimeException(localStringBuilder.toString(), localSecurityException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to find defaultInstance in ");
      localStringBuilder.append(this.messageClassName);
      throw new RuntimeException(localStringBuilder.toString(), localNoSuchFieldException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to find proto buffer class: ");
      localStringBuilder.append(this.messageClassName);
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  private Class<?> b()
  {
    Class localClass = this.messageClass;
    if (localClass != null) {
      return localClass;
    }
    return Class.forName(this.messageClassName);
  }
  
  public static SerializedForm of(MessageLite paramMessageLite)
  {
    return new SerializedForm(paramMessageLite);
  }
  
  protected Object readResolve()
  {
    try
    {
      Object localObject = b().getDeclaredField("DEFAULT_INSTANCE");
      ((Field)localObject).setAccessible(true);
      localObject = ((MessageLite)((Field)localObject).get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
      return localObject;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
    }
    catch (SecurityException localSecurityException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to call DEFAULT_INSTANCE in ");
      localStringBuilder.append(this.messageClassName);
      throw new RuntimeException(localStringBuilder.toString(), localSecurityException);
      return a();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to find proto buffer class: ");
      localStringBuilder.append(this.messageClassName);
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label107:
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite.SerializedForm
 * JD-Core Version:    0.7.0.1
 */