package com.tencent.biz.subscribe.comment;

import com.tribe.async.dispatch.Dispatcher.Dispatchable;

public class CommentEvent
  implements Dispatcher.Dispatchable
{
  public int a;
  public Object a;
  
  public CommentEvent(int paramInt, Object... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentEvent
 * JD-Core Version:    0.7.0.1
 */