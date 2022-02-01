package com.tencent.mobileqq.apollo.store;

public class DressDescriptionItem
  implements Comparable
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public int compareTo(Object paramObject)
  {
    paramObject = (DressDescriptionItem)paramObject;
    if (this.d < paramObject.d) {
      return 1;
    }
    if (this.d > paramObject.d) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.DressDescriptionItem
 * JD-Core Version:    0.7.0.1
 */