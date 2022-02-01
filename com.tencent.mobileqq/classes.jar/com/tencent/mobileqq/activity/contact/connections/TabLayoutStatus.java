package com.tencent.mobileqq.activity.contact.connections;

public class TabLayoutStatus
{
  public int a = 23;
  public int b = 0;
  public boolean c = false;
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    this.c = true;
  }
  
  public void c()
  {
    this.a = 23;
    this.b = 0;
    this.c = false;
  }
  
  public void d()
  {
    this.a = 23;
    this.b = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TabLayoutStatus{tabId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tabPosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", display='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus
 * JD-Core Version:    0.7.0.1
 */