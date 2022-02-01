package com.tencent.ilivesdk.coredataserviceinterface;

public class CoreDataServiceItem
{
  public int a;
  public String b;
  public long c;
  public boolean d;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("CoreDataServiceItem:\n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemType = ");
    localStringBuilder2.append(this.a);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemName = ");
    localStringBuilder2.append(this.b);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("itemValue = ");
    localStringBuilder2.append(this.c);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("isShow = ");
    localStringBuilder2.append(this.d);
    localStringBuilder2.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.coredataserviceinterface.CoreDataServiceItem
 * JD-Core Version:    0.7.0.1
 */