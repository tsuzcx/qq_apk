package com.tencent.biz.qqstory.base;

import com.tribe.async.dispatch.Dispatcher.Event;

public class BaseEvent
  implements Dispatcher.Event
{
  public ErrorMessage g = new ErrorMessage();
  
  public String a()
  {
    return this.g.getErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"_class\":\"SimpleBaseEvent\", \"errorInfo\":");
    Object localObject;
    if (this.g == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.BaseEvent
 * JD-Core Version:    0.7.0.1
 */