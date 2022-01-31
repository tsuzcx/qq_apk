package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyReportManyApps$AppConfigInfoList
  implements Serializable
{
  public String actionName = ReadInJoyReportManyApps.d;
  public List list = new ArrayList();
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("actionName = ").append(this.actionName).append("\nappConfigInfoList size = ");
    int i;
    if (this.list != null) {
      i = this.list.size();
    }
    for (;;)
    {
      localStringBuilder = new StringBuilder(i + "\n");
      try
      {
        if (this.list != null)
        {
          i = j;
          while (i < this.list.size())
          {
            localStringBuilder.append("appConfigInfo [ ").append(i).append(" ]: \n").append(((ReadInJoyReportManyApps.AppConfigInfo)this.list.get(i)).toString());
            i += 1;
            continue;
            i = 0;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.d(ReadInJoyReportManyApps.c, 1, "AppConfigInfoList toString failed.");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyReportManyApps.AppConfigInfoList
 * JD-Core Version:    0.7.0.1
 */