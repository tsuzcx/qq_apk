package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.AppInterface;

public class DelayNotifyRunnable
  implements Runnable
{
  int a;
  AppInterface b;
  Object c;
  boolean d = false;
  DelayNotifyRunnable.IOnDelayNotifyDoneListener e;
  
  public DelayNotifyRunnable(AppInterface paramAppInterface, int paramInt, DelayNotifyRunnable.IOnDelayNotifyDoneListener paramIOnDelayNotifyDoneListener, Object paramObject)
  {
    this.b = paramAppInterface;
    this.a = paramInt;
    this.e = paramIOnDelayNotifyDoneListener;
    this.c = paramObject;
  }
  
  public Object a()
  {
    if (this.a == 0) {
      return (String)((Object[])(Object[])this.c)[0];
    }
    return null;
  }
  
  public void a(Object paramObject)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (this.a == 0)
    {
      Object localObject = (Object[])this.c;
      String str = (String)localObject[0];
      int i = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      paramObject = (String)paramObject;
      this.e.a(this.a, new Object[] { paramObject, Integer.valueOf(i), localObject });
    }
  }
  
  public void run()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (this.a == 0)
    {
      Object localObject = (Object[])this.c;
      String str = (String)localObject[0];
      int i = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      str = IGameEngine.I().s().e().getNick(str);
      this.e.a(this.a, new Object[] { str, Integer.valueOf(i), localObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.DelayNotifyRunnable
 * JD-Core Version:    0.7.0.1
 */