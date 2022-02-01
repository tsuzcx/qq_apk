package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.updatesdk.service.b.c;
import com.huawei.updatesdk.service.c.g;

class b$a
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!(paramMessage.obj instanceof a)) {
      return;
    }
    Object localObject = (a)paramMessage.obj;
    Intent localIntent = new Intent();
    com.huawei.updatesdk.a.b.c.b localb = com.huawei.updatesdk.a.b.c.b.a(localIntent);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      localIntent.putExtra("download_apk_size", ((a)localObject).b());
      localIntent.putExtra("download_apk_already", ((a)localObject).a());
      c.a().b(localb);
      return;
    case 4: 
      g.a(b.c() + "/appmarket.apk", "com.huawei.appmarket");
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("download_status_param", paramMessage.what);
    localIntent.putExtras((Bundle)localObject);
    c.a().a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.b.b.a
 * JD-Core Version:    0.7.0.1
 */