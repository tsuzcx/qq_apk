package com.tencent.mobileqq.applets.data;

import java.util.ArrayList;
import java.util.List;

public class AppletsSetting
{
  public String a;
  public List<AppletItem> b = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppletsSetting:[");
    localStringBuilder.append("des = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletsSetting
 * JD-Core Version:    0.7.0.1
 */