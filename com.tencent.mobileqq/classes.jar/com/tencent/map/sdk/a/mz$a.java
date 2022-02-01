package com.tencent.map.sdk.a;

import com.tencent.map.tools.net.NetMethod;
import java.util.Arrays;
import java.util.HashMap;

final class mz$a
{
  String a;
  String b;
  String c;
  String[] d;
  HashMap<String, String> e;
  String f;
  String g;
  int h;
  NetMethod i;
  
  private mz$a(mz parammz) {}
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RequestEntity{service='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, request='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, method=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n, heads=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n, queryKeys=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append("\n, constQuery='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, useAgent='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append("\n, retry=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\nurl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mz.a
 * JD-Core Version:    0.7.0.1
 */