package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.medalwall.MedalWallMng;

class MedalNewsItemBuilder$3
  implements Runnable
{
  MedalNewsItemBuilder$3(MedalNewsItemBuilder paramMedalNewsItemBuilder) {}
  
  public void run()
  {
    ((MedalWallMng)this.this$0.a.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */