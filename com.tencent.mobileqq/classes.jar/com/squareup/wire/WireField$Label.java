package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/WireField$Label;", "", "(Ljava/lang/String;I)V", "isOneOf", "", "()Z", "isPacked", "isRepeated", "REQUIRED", "OPTIONAL", "REPEATED", "ONE_OF", "PACKED", "wire-runtime"}, k=1, mv={1, 1, 16})
public enum WireField$Label
{
  static
  {
    Label localLabel1 = new Label("REQUIRED", 0);
    REQUIRED = localLabel1;
    Label localLabel2 = new Label("OPTIONAL", 1);
    OPTIONAL = localLabel2;
    Label localLabel3 = new Label("REPEATED", 2);
    REPEATED = localLabel3;
    Label localLabel4 = new Label("ONE_OF", 3);
    ONE_OF = localLabel4;
    Label localLabel5 = new Label("PACKED", 4);
    PACKED = localLabel5;
    $VALUES = new Label[] { localLabel1, localLabel2, localLabel3, localLabel4, localLabel5 };
  }
  
  private WireField$Label() {}
  
  @JvmName(name="isOneOf")
  public final boolean isOneOf()
  {
    return (Label)this == ONE_OF;
  }
  
  @JvmName(name="isPacked")
  public final boolean isPacked()
  {
    return (Label)this == PACKED;
  }
  
  @JvmName(name="isRepeated")
  public final boolean isRepeated()
  {
    Label localLabel = (Label)this;
    return (localLabel == REPEATED) || (localLabel == PACKED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.WireField.Label
 * JD-Core Version:    0.7.0.1
 */