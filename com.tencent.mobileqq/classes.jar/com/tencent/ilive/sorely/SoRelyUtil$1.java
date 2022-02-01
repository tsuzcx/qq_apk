package com.tencent.ilive.sorely;

import android.content.Context;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.soentry.SoEntry;

final class SoRelyUtil$1
  implements DownLoaderInterface.DownLoaderComponentAdapter
{
  SoRelyUtil$1(Context paramContext) {}
  
  public int getAppId()
  {
    return 3128;
  }
  
  public LogInterface getLog()
  {
    return SoEntry.instanse().getLog(this.val$context);
  }
  
  public boolean isLite()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.sorely.SoRelyUtil.1
 * JD-Core Version:    0.7.0.1
 */