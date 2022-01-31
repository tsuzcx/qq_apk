package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class StoryConfigImplement
{
  public static WeakReference a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException("StoryApi 没有注入 QQAppInterface!!");
    }
    return localQQAppInterface.a().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.StoryConfigImplement
 * JD-Core Version:    0.7.0.1
 */