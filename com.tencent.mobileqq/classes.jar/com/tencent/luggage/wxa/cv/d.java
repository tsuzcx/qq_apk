package com.tencent.luggage.wxa.cv;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/IlinkGetA8KeyUrlType;", "", "typeName", "", "cmdId", "", "cgiInstanceClazz", "Ljava/lang/Class;", "Lcom/tencent/luggage/jsapi/webview/model/CgiWxaGetA8Key;", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/Class;)V", "getCgiInstanceClazz", "()Ljava/lang/Class;", "getCmdId", "()I", "getTypeName", "()Ljava/lang/String;", "MAIN", "MP", "PAY", "MINOR", "THREE_RD", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public enum d
{
  @NotNull
  private final String g;
  private final int h;
  @NotNull
  private final Class<? extends a> i;
  
  static
  {
    d locald1 = new d("MAIN", 0, "ilinkgeta8key", 5112, a.class);
    a = locald1;
    d locald2 = new d("MP", 1, "ilinkmpgeta8key", 2909, e.class);
    b = locald2;
    d locald3 = new d("PAY", 2, "ilinkpaygeta8key", 4748, g.class);
    c = locald3;
    d locald4 = new d("MINOR", 3, "ilinkminorgeta8key", 5101, f.class);
    d = locald4;
    d locald5 = new d("THREE_RD", 4, "ilink3rdgeta8key", 4615, h.class);
    e = locald5;
    f = new d[] { locald1, locald2, locald3, locald4, locald5 };
  }
  
  private d(String paramString, int paramInt, Class<? extends a> paramClass)
  {
    this.g = paramString;
    this.h = paramInt;
    this.i = paramClass;
  }
  
  @NotNull
  public final String a()
  {
    return this.g;
  }
  
  public final int b()
  {
    return this.h;
  }
  
  @NotNull
  public final Class<? extends a> c()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.d
 * JD-Core Version:    0.7.0.1
 */