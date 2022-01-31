package com.tencent.hlyyb.downloader.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  int a;
  int b = -1;
  int c = -1;
  int d = -1;
  List<String> e = new ArrayList();
  int f;
  String g = "";
  int h;
  int i;
  List<String> j = new ArrayList();
  int k;
  List<String> l = new ArrayList();
  String m = "";
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a).append(",");
    localStringBuilder.append(this.b).append(",");
    localStringBuilder.append(this.c).append(",");
    localStringBuilder.append(this.d).append(",");
    Iterator localIterator;
    if (this.e.size() > 0)
    {
      localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(",");
    localStringBuilder.append(this.f).append(",");
    localStringBuilder.append(this.g).append(",");
    localStringBuilder.append(this.h).append(",");
    localStringBuilder.append(this.i).append(",");
    if (this.j.size() > 0)
    {
      localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(",");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",");
    if (this.l.size() > 0)
    {
      localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("-");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(",");
    localStringBuilder.append(this.m);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.b.e
 * JD-Core Version:    0.7.0.1
 */