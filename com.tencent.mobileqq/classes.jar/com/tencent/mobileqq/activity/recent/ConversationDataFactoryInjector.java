package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

public class ConversationDataFactoryInjector
{
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramInt;
    if (paramQQAppInterface.mAutomator != null)
    {
      i = paramInt;
      if (paramQQAppInterface.mAutomator.b())
      {
        i = paramInt;
        if (paramInt > 90)
        {
          i = paramInt;
          if (System.currentTimeMillis() - paramQQAppInterface.mAutomator.a <= 10000L) {
            i = Math.min(90, paramInt);
          }
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationDataFactoryInjector
 * JD-Core Version:    0.7.0.1
 */