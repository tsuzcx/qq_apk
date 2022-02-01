package com.tencent.mobileqq.activity.aio.item;

import ahbl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.medalwall.MedalWallMng;

public class MedalNewsItemBuilder$3
  implements Runnable
{
  public MedalNewsItemBuilder$3(ahbl paramahbl) {}
  
  public void run()
  {
    ((MedalWallMng)this.this$0.a.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */