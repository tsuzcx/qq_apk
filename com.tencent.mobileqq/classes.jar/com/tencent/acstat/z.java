package com.tencent.acstat;

import android.content.Context;

final class z
  implements Runnable
{
  z(Context paramContext) {}
  
  public final void run()
  {
    StatServiceImpl.flushDataToDB(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.z
 * JD-Core Version:    0.7.0.1
 */