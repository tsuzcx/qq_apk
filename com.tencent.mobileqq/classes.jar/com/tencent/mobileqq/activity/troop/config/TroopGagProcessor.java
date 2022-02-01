package com.tencent.mobileqq.activity.troop.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.api.config.AbsTroopGagProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;

public class TroopGagProcessor
  extends AbsTroopGagProcessor
{
  public void a(AppInterface paramAppInterface, long paramLong)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (TroopGagMgr)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      int i;
      if (paramLong == 0L) {
        i = 2131697322;
      } else {
        i = 2131697409;
      }
      paramAppInterface.a(i, false);
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (TroopGagMgr)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      if (paramBoolean1)
      {
        if (paramLong == 0L) {
          i = 2131697324;
        } else {
          i = 2131697412;
        }
        paramAppInterface.a(i, true);
        return;
      }
      int i = 2131697323;
      if (paramBoolean2)
      {
        if (paramLong != 0L) {
          i = 2131697410;
        }
        paramAppInterface.a(i, false);
        return;
      }
      if (paramLong != 0L) {
        i = 2131697411;
      }
      paramAppInterface.a(i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopGagProcessor
 * JD-Core Version:    0.7.0.1
 */