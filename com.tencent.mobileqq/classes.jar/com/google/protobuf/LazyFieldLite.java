package com.google.protobuf;

public class LazyFieldLite
{
  private static final ExtensionRegistryLite b = ;
  protected volatile MessageLite a;
  private ByteString c;
  private ExtensionRegistryLite d;
  private volatile ByteString e;
  
  public LazyFieldLite() {}
  
  public LazyFieldLite(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    a(paramExtensionRegistryLite, paramByteString);
    this.d = paramExtensionRegistryLite;
    this.c = paramByteString;
  }
  
  private static void a(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    if (paramExtensionRegistryLite != null)
    {
      if (paramByteString != null) {
        return;
      }
      throw new NullPointerException("found null ByteString");
    }
    throw new NullPointerException("found null ExtensionRegistry");
  }
  
  public MessageLite a(MessageLite paramMessageLite)
  {
    c(paramMessageLite);
    return this.a;
  }
  
  public int b()
  {
    if (this.e != null) {
      return this.e.size();
    }
    ByteString localByteString = this.c;
    if (localByteString != null) {
      return localByteString.size();
    }
    if (this.a != null) {
      return this.a.getSerializedSize();
    }
    return 0;
  }
  
  public MessageLite b(MessageLite paramMessageLite)
  {
    MessageLite localMessageLite = this.a;
    this.c = null;
    this.e = null;
    this.a = paramMessageLite;
    return localMessageLite;
  }
  
  public ByteString c()
  {
    if (this.e != null) {
      return this.e;
    }
    ByteString localByteString = this.c;
    if (localByteString != null) {
      return localByteString;
    }
    try
    {
      if (this.e != null)
      {
        localByteString = this.e;
        return localByteString;
      }
      if (this.a == null) {
        this.e = ByteString.EMPTY;
      } else {
        this.e = this.a.toByteString();
      }
      localByteString = this.e;
      return localByteString;
    }
    finally {}
  }
  
  protected void c(MessageLite paramMessageLite)
  {
    if (this.a != null) {
      return;
    }
    label79:
    try
    {
      if (this.a != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.c != null)
      {
        this.a = ((MessageLite)paramMessageLite.getParserForType().parseFrom(this.c, this.d));
        this.e = this.c;
      }
      else
      {
        this.a = paramMessageLite;
        this.e = ByteString.EMPTY;
      }
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      break label79;
    }
    this.a = paramMessageLite;
    this.e = ByteString.EMPTY;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LazyFieldLite)) {
      return false;
    }
    paramObject = (LazyFieldLite)paramObject;
    MessageLite localMessageLite1 = this.a;
    MessageLite localMessageLite2 = paramObject.a;
    if ((localMessageLite1 == null) && (localMessageLite2 == null)) {
      return c().equals(paramObject.c());
    }
    if ((localMessageLite1 != null) && (localMessageLite2 != null)) {
      return localMessageLite1.equals(localMessageLite2);
    }
    if (localMessageLite1 != null) {
      return localMessageLite1.equals(paramObject.a(localMessageLite1.getDefaultInstanceForType()));
    }
    return a(localMessageLite2.getDefaultInstanceForType()).equals(localMessageLite2);
  }
  
  public int hashCode()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyFieldLite
 * JD-Core Version:    0.7.0.1
 */