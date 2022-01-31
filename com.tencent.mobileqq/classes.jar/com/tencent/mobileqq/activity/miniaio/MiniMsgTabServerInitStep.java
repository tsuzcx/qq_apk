package com.tencent.mobileqq.activity.miniaio;

import bhth;
import com.tencent.commonsdk.util.notification.NotificationLimiterUtil;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class MiniMsgTabServerInitStep
  extends AsyncStep
{
  public static boolean a;
  private static String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "MiniMsgTabServerInitStep";
  }
  
  private void b()
  {
    a = true;
    NotificationLimiterUtil.setLimiter(new bhth());
  }
  
  public int a()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      return 7;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep
 * JD-Core Version:    0.7.0.1
 */