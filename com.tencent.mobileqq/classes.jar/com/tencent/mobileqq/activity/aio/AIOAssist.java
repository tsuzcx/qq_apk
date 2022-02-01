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
        return ((ChatFragment)localObject).a();
      }
    }
    return null;
  }
  
  public static boolean a()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null) {
      return ((AIOLongShotHelper)localBaseChatPie.a(15)).a();
    }
    return false;
  }
  
  public static boolean b()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOAssist
 * JD-Core Version:    0.7.0.1
 */