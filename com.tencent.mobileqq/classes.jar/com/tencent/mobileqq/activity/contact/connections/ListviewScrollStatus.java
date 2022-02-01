package com.tencent.mobileqq.activity.contact.connections;

public class ListviewScrollStatus
{
  public int a;
  public int b;
  public int c;
  
  public ListviewScrollStatus(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TabLayoutStatus{, tabId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", scrollPos=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scrollTop='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus
 * JD-Core Version:    0.7.0.1
 */