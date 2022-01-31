package com.sixgod.pluginsdk.component;

import android.content.Intent;
import com.sixgod.pluginsdk.log.SGLog;

final class d
  implements Runnable
{
  d(c paramc) {}
  
  public final void run()
  {
    SGLog.a("reLaunchActivity ");
    ContainerActivity localContainerActivity = this.a.a;
    Intent localIntent = localContainerActivity.getIntent();
    localContainerActivity.overridePendingTransition(0, 0);
    localIntent.addFlags(65536);
    localContainerActivity.finish();
    localContainerActivity.overridePendingTransition(0, 0);
    localContainerActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.d
 * JD-Core Version:    0.7.0.1
 */