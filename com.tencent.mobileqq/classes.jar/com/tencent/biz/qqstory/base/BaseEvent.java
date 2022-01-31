package com.tencent.biz.qqstory.base;

import com.tribe.async.dispatch.Dispatcher.Event;

public class BaseEvent
  implements Dispatcher.Event
{
  public ErrorMessage a = new ErrorMessage();
  
  public String a()
  {
    return this.a.getErrorMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{\"_class\":\"BaseEvent\", \"errorInfo\":");
    if (this.a == null) {}
    for (String str = "null";; str = "\"" + this.a + "\"") {
      return str + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.BaseEvent
 * JD-Core Version:    0.7.0.1
 */