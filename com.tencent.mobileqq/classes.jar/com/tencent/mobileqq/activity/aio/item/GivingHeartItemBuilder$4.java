package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GivingHeartItemBuilder$4
  extends CallBacker
{
  GivingHeartItemBuilder$4(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramString1.equals("poke.effectList")) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "download vas poke list from GivingHeartItemBuilder, update pokeSvipMap now.");
      }
      ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */