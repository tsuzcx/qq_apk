package com.tencent.mobileqq.activity.miniaio;

import com.tencent.commonsdk.util.notification.NotificationLimiterUtil;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.util.notification.NotificationLimiterImpl;

public class MiniMsgTabServerInitStep
  extends AsyncStep
{
  public static boolean a = false;
  private static String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "MiniMsgTabServerInitStep";
  }
  
  private void a()
  {
    a = true;
    NotificationLimiterUtil.setLimiter(new NotificationLimiterImpl());
  }
  
  public int a()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      return 7;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep
 * JD-Core Version:    0.7.0.1
 */