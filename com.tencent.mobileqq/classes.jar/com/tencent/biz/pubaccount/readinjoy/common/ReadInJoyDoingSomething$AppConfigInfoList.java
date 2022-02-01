package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDoingSomething$AppConfigInfoList
  implements Serializable
{
  public String actionName = ReadInJoyDoingSomething.d;
  public List<ReadInJoyDoingSomething.AppConfigInfo> list = new ArrayList();
  
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
            localStringBuilder.append("appConfigInfo [ ").append(i).append(" ]: \n").append(((ReadInJoyDoingSomething.AppConfigInfo)this.list.get(i)).toString());
            i += 1;
            continue;
            i = 0;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.d(ReadInJoyDoingSomething.c, 1, "AppConfigInfoList toString failed.");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething.AppConfigInfoList
 * JD-Core Version:    0.7.0.1
 */