package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.ThreadManager;

public class ArkMessageServerLogic
{
  public static void a(ArkMessageServerLogic.IRequestArkAppListHandler paramIRequestArkAppListHandler)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramIRequestArkAppListHandler), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic
 * JD-Core Version:    0.7.0.1
 */