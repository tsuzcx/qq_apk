package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UnknownFieldSet$Field$Builder
{
  private UnknownFieldSet.Field a;
  
  private static Builder c()
  {
    Builder localBuilder = new Builder();
    localBuilder.a = new UnknownFieldSet.Field(null);
    return localBuilder;
  }
  
  public Builder a(int paramInt)
  {
    if (UnknownFieldSet.Field.b(this.a) == null) {
      UnknownFieldSet.Field.b(this.a, new ArrayList());
    }
    UnknownFieldSet.Field.b(this.a).add(Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder a(long paramLong)
  {
    if (UnknownFieldSet.Field.a(this.a) == null) {
      UnknownFieldSet.Field.a(this.a, new ArrayList());
    }
    UnknownFieldSet.Field.a(this.a).add(Long.valueOf(paramLong));
    return this;
  }
  
  public Builder a(ByteString paramByteString)
  {
    if (UnknownFieldSet.Field.d(this.a) == null) {
      UnknownFieldSet.Field.d(this.a, new ArrayList());
    }
    UnknownFieldSet.Field.d(this.a).add(paramByteString);
    return this;
  }
  
  public Builder a(UnknownFieldSet.Field paramField)
  {
    if (!UnknownFieldSet.Field.a(paramField).isEmpty())
    {
      if (UnknownFieldSet.Field.a(this.a) == null) {
        UnknownFieldSet.Field.a(this.a, new ArrayList());
      }
      UnknownFieldSet.Field.a(this.a).addAll(UnknownFieldSet.Field.a(paramField));
    }
    if (!UnknownFieldSet.Field.b(paramField).isEmpty())
    {
      if (UnknownFieldSet.Field.b(this.a) == null) {
        UnknownFieldSet.Field.b(this.a, new ArrayList());
      }
      UnknownFieldSet.Field.b(this.a).addAll(UnknownFieldSet.Field.b(paramField));
    }
    if (!UnknownFieldSet.Field.c(paramField).isEmpty())
    {
      if (UnknownFieldSet.Field.c(this.a) == null) {
        UnknownFieldSet.Field.c(this.a, new ArrayList());
      }
      UnknownFieldSet.Field.c(this.a).addAll(UnknownFieldSet.Field.c(paramField));
    }
    if (!UnknownFieldSet.Field.d(paramField).isEmpty())
    {
      if (UnknownFieldSet.Field.d(this.a) == null) {
        UnknownFieldSet.Field.d(this.a, new ArrayList());
      }
      UnknownFieldSet.Field.d(this.a).addAll(UnknownFieldSet.Field.d(paramField));
    }
    if (!UnknownFieldSet.Field.e(paramField).isEmpty())
    {
      if (UnknownFieldSet.Field.e(this.a) == null) {
        UnknownFieldSet.Field.e(this.a, new ArrayList());
      }
      UnknownFieldSet.Field.e(this.a).addAll(UnknownFieldSet.Field.e(paramField));
    }
    return this;
  }
  
  public Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    if (UnknownFieldSet.Field.e(this.a) == null) {
      UnknownFieldSet.Field.e(this.a, new ArrayList());
    }
    UnknownFieldSet.Field.e(this.a).add(paramUnknownFieldSet);
    return this;
  }
  
  public UnknownFieldSet.Field a()
  {
    if (UnknownFieldSet.Field.a(this.a) == null)
    {
      UnknownFieldSet.Field.a(this.a, Collections.emptyList());
    }
    else
    {
      localField = this.a;
      UnknownFieldSet.Field.a(localField, Collections.unmodifiableList(UnknownFieldSet.Field.a(localField)));
    }
    if (UnknownFieldSet.Field.b(this.a) == null)
    {
      UnknownFieldSet.Field.b(this.a, Collections.emptyList());
    }
    else
    {
      localField = this.a;
      UnknownFieldSet.Field.b(localField, Collections.unmodifiableList(UnknownFieldSet.Field.b(localField)));
    }
    if (UnknownFieldSet.Field.c(this.a) == null)
    {
      UnknownFieldSet.Field.c(this.a, Collections.emptyList());
    }
    else
    {
      localField = this.a;
      UnknownFieldSet.Field.c(localField, Collections.unmodifiableList(UnknownFieldSet.Field.c(localField)));
    }
    if (UnknownFieldSet.Field.d(this.a) == null)
    {
      UnknownFieldSet.Field.d(this.a, Collections.emptyList());
    }
    else
    {
      localField = this.a;
      UnknownFieldSet.Field.d(localField, Collections.unmodifiableList(UnknownFieldSet.Field.d(localField)));
    }
    if (UnknownFieldSet.Field.e(this.a) == null)
    {
      UnknownFieldSet.Field.e(this.a, Collections.emptyList());
    }
    else
    {
      localField = this.a;
      UnknownFieldSet.Field.e(localField, Collections.unmodifiableList(UnknownFieldSet.Field.e(localField)));
    }
    UnknownFieldSet.Field localField = this.a;
    this.a = null;
    return localField;
  }
  
  public Builder b(long paramLong)
  {
    if (UnknownFieldSet.Field.c(this.a) == null) {
      UnknownFieldSet.Field.c(this.a, new ArrayList());
    }
    UnknownFieldSet.Field.c(this.a).add(Long.valueOf(paramLong));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSet.Field.Builder
 * JD-Core Version:    0.7.0.1
 */