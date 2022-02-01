package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;
import java.util.Map;

public class HiddenChatTroopListProcessor
  extends AbsTroopListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, Map<String, Boolean> paramMap)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      TroopStatusUtil.a((QQAppInterface)paramAppInterface, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.HiddenChatTroopListProcessor
 * JD-Core Version:    0.7.0.1
 */