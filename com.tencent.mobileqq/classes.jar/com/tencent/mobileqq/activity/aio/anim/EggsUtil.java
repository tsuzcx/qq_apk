package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ListUtils;
import java.util.ArrayList;

public class EggsUtil
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, AioAnimationRule paramAioAnimationRule)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString2, paramString1, paramString1, 0, 0, "", "", b(paramAioAnimationRule), String.valueOf(paramAioAnimationRule.b));
  }
  
  public static boolean a(AioAnimationRule paramAioAnimationRule)
  {
    return paramAioAnimationRule.b == 560;
  }
  
  private static String b(AioAnimationRule paramAioAnimationRule)
  {
    if (paramAioAnimationRule.f < ListUtils.b(paramAioAnimationRule.c)) {
      return ((EggKeyword)paramAioAnimationRule.c.get(paramAioAnimationRule.f)).a();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.EggsUtil
 * JD-Core Version:    0.7.0.1
 */