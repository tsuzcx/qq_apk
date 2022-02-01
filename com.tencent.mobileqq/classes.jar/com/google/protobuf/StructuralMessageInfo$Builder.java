package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StructuralMessageInfo$Builder
{
  private final List<FieldInfo> a;
  private ProtoSyntax b;
  private boolean c;
  private boolean d;
  private int[] e = null;
  private Object f;
  
  public StructuralMessageInfo$Builder()
  {
    this.a = new ArrayList();
  }
  
  public StructuralMessageInfo$Builder(int paramInt)
  {
    this.a = new ArrayList(paramInt);
  }
  
  public StructuralMessageInfo a()
  {
    if (!this.c)
    {
      if (this.b != null)
      {
        this.c = true;
        Collections.sort(this.a);
        return new StructuralMessageInfo(this.b, this.d, this.e, (FieldInfo[])this.a.toArray(new FieldInfo[0]), this.f);
      }
      throw new IllegalStateException("Must specify a proto syntax");
    }
    throw new IllegalStateException("Builder can only build once");
  }
  
  public void a(FieldInfo paramFieldInfo)
  {
    if (!this.c)
    {
      this.a.add(paramFieldInfo);
      return;
    }
    throw new IllegalStateException("Builder can only build once");
  }
  
  public void a(ProtoSyntax paramProtoSyntax)
  {
    this.b = ((ProtoSyntax)Internal.a(paramProtoSyntax, "syntax"));
  }
  
  public void a(Object paramObject)
  {
    this.f = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.e = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.StructuralMessageInfo.Builder
 * JD-Core Version:    0.7.0.1
 */