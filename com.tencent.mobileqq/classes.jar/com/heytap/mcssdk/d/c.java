package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.f.a;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c
  implements d
{
  public static List<BaseMode> a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    int i = 4096;
    try
    {
      int j = Integer.parseInt(a.b(paramIntent.getStringExtra("type")));
      i = j;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MessageParser--getMessageByIntent--Exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      com.heytap.mcssdk.f.c.b(((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("MessageParser--getMessageByIntent--type:");
    ((StringBuilder)localObject1).append(i);
    com.heytap.mcssdk.f.c.a(((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList();
    Object localObject2 = com.heytap.mcssdk.d.a().e().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (d)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject3 = ((d)localObject3).a(paramContext, i, paramIntent);
        if (localObject3 != null) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    return localObject1;
  }
  
  protected abstract BaseMode a(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.d.c
 * JD-Core Version:    0.7.0.1
 */