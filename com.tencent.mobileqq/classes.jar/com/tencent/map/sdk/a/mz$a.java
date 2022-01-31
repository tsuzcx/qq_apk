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
    return "RequestEntity{service='" + this.a + '\'' + "\n, request='" + this.b + '\'' + "\n, method=" + this.i + "\n, heads=" + this.e + "\n, queryKeys=" + Arrays.toString(this.d) + "\n, constQuery='" + this.f + '\'' + "\n, useAgent='" + this.g + '\'' + "\n, retry=" + this.h + "\nurl='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.mz.a
 * JD-Core Version:    0.7.0.1
 */