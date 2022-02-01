package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class StoryConfigImplement
{
  public static WeakReference<QQAppInterface> a = new WeakReference(null);
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    if (localQQAppInterface == null) {
      throw new IllegalStateException(HardCodeUtil.a(2131714281));
    }
    return localQQAppInterface.getNowLiveManager().a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.StoryConfigImplement
 * JD-Core Version:    0.7.0.1
 */