package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class StoryApiInjector
{
  public static void a(Object paramObject)
  {
    if ((paramObject instanceof QQAppInterface)) {
      StoryConfigImplement.a = new WeakReference((QQAppInterface)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.StoryApiInjector
 * JD-Core Version:    0.7.0.1
 */