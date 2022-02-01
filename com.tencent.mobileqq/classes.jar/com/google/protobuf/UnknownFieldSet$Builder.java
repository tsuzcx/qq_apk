package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class UnknownFieldSet$Builder
  implements MessageLite.Builder
{
  private Map<Integer, UnknownFieldSet.Field> a;
  private int b;
  private UnknownFieldSet.Field.Builder c;
  
  private UnknownFieldSet.Field.Builder b(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      int i = this.b;
      if (paramInt == i) {
        return localObject;
      }
      b(i, ((UnknownFieldSet.Field.Builder)localObject).a());
    }
    if (paramInt == 0) {
      return null;
    }
    localObject = (UnknownFieldSet.Field)this.a.get(Integer.valueOf(paramInt));
    this.b = paramInt;
    this.c = UnknownFieldSet.Field.a();
    if (localObject != null) {
      this.c.a((UnknownFieldSet.Field)localObject);
    }
    return this.c;
  }
  
  private static Builder f()
  {
    Builder localBuilder = new Builder();
    localBuilder.g();
    return localBuilder;
  }
  
  private void g()
  {
    this.a = Collections.emptyMap();
    this.b = 0;
    this.c = null;
  }
  
  public Builder a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      b(paramInt1).a(paramInt2);
      return this;
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  public Builder a(int paramInt, UnknownFieldSet.Field paramField)
  {
    if (paramInt != 0)
    {
      if (a(paramInt))
      {
        b(paramInt).a(paramField);
        return this;
      }
      b(paramInt, paramField);
      return this;
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  public Builder a(ByteString paramByteString)
  {
    try
    {
      paramByteString = paramByteString.newCodedInput();
      a(paramByteString);
      paramByteString.a(0);
      return this;
    }
    catch (IOException paramByteString)
    {
      throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", paramByteString);
    }
    catch (InvalidProtocolBufferException paramByteString)
    {
      throw paramByteString;
    }
  }
  
  public Builder a(CodedInputStream paramCodedInputStream)
  {
    int i;
    do
    {
      i = paramCodedInputStream.a();
    } while ((i != 0) && (a(i, paramCodedInputStream)));
    return this;
  }
  
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return a(paramCodedInputStream);
  }
  
  public Builder a(MessageLite paramMessageLite)
  {
    if ((paramMessageLite instanceof UnknownFieldSet)) {
      return a((UnknownFieldSet)paramMessageLite);
    }
    throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
  }
  
  public Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    if (paramUnknownFieldSet != UnknownFieldSet.b())
    {
      paramUnknownFieldSet = UnknownFieldSet.b(paramUnknownFieldSet).entrySet().iterator();
      while (paramUnknownFieldSet.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramUnknownFieldSet.next();
        a(((Integer)localEntry.getKey()).intValue(), (UnknownFieldSet.Field)localEntry.getValue());
      }
    }
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = CodedInputStream.a(paramArrayOfByte);
      a(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramArrayOfByte);
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public UnknownFieldSet a()
  {
    b(0);
    Object localObject;
    if (this.a.isEmpty())
    {
      localObject = UnknownFieldSet.b();
    }
    else
    {
      localObject = Collections.unmodifiableMap(((TreeMap)this.a).descendingMap());
      localObject = new UnknownFieldSet(Collections.unmodifiableMap(this.a), (Map)localObject);
    }
    this.a = null;
    return localObject;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 0) {
      return (paramInt == this.b) || (this.a.containsKey(Integer.valueOf(paramInt)));
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  public boolean a(int paramInt, CodedInputStream paramCodedInputStream)
  {
    int i = WireFormat.b(paramInt);
    paramInt = WireFormat.a(paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5)
              {
                b(i).a(paramCodedInputStream.h());
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          Builder localBuilder = UnknownFieldSet.a();
          paramCodedInputStream.a(i, localBuilder, ExtensionRegistry.a());
          b(i).a(localBuilder.a());
          return true;
        }
        b(i).a(paramCodedInputStream.l());
        return true;
      }
      b(i).b(paramCodedInputStream.g());
      return true;
    }
    b(i).a(paramCodedInputStream.e());
    return true;
  }
  
  public Builder b(int paramInt, UnknownFieldSet.Field paramField)
  {
    if (paramInt != 0)
    {
      if ((this.c != null) && (this.b == paramInt))
      {
        this.c = null;
        this.b = 0;
      }
      if (this.a.isEmpty()) {
        this.a = new TreeMap();
      }
      this.a.put(Integer.valueOf(paramInt), paramField);
      return this;
    }
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  public UnknownFieldSet b()
  {
    return a();
  }
  
  public Builder c()
  {
    b(0);
    Map localMap = Collections.unmodifiableMap(((TreeMap)this.a).descendingMap());
    return UnknownFieldSet.a().a(new UnknownFieldSet(this.a, localMap));
  }
  
  public UnknownFieldSet d()
  {
    return UnknownFieldSet.b();
  }
  
  public boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSet.Builder
 * JD-Core Version:    0.7.0.1
 */