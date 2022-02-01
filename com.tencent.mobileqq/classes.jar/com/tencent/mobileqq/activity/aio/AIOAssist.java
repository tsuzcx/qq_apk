package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;

public class AIOAssist
{
  public static BaseChatPie a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getChatFragment();
      if (localObject != null) {
        return ((ChatFragment)localObject).k();
      }
    }
    return null;
  }
  
  public static boolean b()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null) {
      return ((AIOLongShotHelper)localBaseChatPie.q(15)).c();
    }
    return false;
  }
  
  public static boolean c()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOAssist
 * JD-Core Version:    0.7.0.1
 */