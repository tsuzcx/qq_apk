package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

final class c$1
  implements Runnable
{
  c$1(Context paramContext, Intent paramIntent, IDataMessageCallBackService paramIDataMessageCallBackService) {}
  
  public void run()
  {
    Object localObject = com.heytap.mcssdk.d.c.a(this.a, this.b);
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseMode localBaseMode = (BaseMode)((Iterator)localObject).next();
      if (localBaseMode != null)
      {
        Iterator localIterator = d.a().f().iterator();
        while (localIterator.hasNext())
        {
          com.heytap.mcssdk.e.c localc = (com.heytap.mcssdk.e.c)localIterator.next();
          if (localc != null) {
            localc.a(this.a, localBaseMode, this.c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.c.1
 * JD-Core Version:    0.7.0.1
 */