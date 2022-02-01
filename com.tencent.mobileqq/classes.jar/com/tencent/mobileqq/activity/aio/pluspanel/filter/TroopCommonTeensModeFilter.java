package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopCommonTeensModeFilter
  extends TeensModeFilter
{
  private final int[] a = { 1104651886, 1106658188, 1107930043, 100729587, 1108164955, 101847385, 1104864062, 1104639410, 1106551782, 1106114157, 101761547, 101793773, 101817424, 1108481457, 1104864066, 1104864068, 101850591, 1104536706, 1104788679, 1108961705, 101849720 };
  private final int[] b = { 1104651886, 1106658188, 1107930043, 100729587, 1108164955, 101847385, 1104864062, 1104639410, 1106551782, 1106114157, 101761547, 101793773, 101817424, 1108481457, 1104864066, 1104864068, 101850591, 1104536706, 1104788679, 1108961705, 101849720, 101846357 };
  private int[] c = this.a;
  
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      this.c = this.b;
    } else {
      this.c = this.a;
    }
    super.a(paramPlusPanelAppLoader, paramQQAppInterface, paramInt, paramString);
  }
  
  protected int[] a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.TroopCommonTeensModeFilter
 * JD-Core Version:    0.7.0.1
 */