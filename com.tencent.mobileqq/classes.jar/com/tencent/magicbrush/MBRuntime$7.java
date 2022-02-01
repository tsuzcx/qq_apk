package com.tencent.magicbrush;

import com.tencent.luggage.wxa.gi.c.c;

class MBRuntime$7
  implements Runnable
{
  MBRuntime$7(MBRuntime paramMBRuntime, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchToJsThread Runnable taskId: ");
    ((StringBuilder)localObject).append(this.a);
    c.c.b("MicroMsg.MagicBrush.MBRuntime", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.b;
    MBRuntime.a((MBRuntime)localObject, ((MBRuntime)localObject).a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.7
 * JD-Core Version:    0.7.0.1
 */