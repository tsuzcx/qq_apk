package com.tencent.beacon.core.network.volley;

import android.content.Context;
import java.io.File;

final class Volley$1
  implements DiskBasedCache.FileSupplier
{
  private File cacheDir = null;
  
  Volley$1(Context paramContext) {}
  
  public File get()
  {
    if (this.cacheDir == null) {
      this.cacheDir = new File(this.val$appContext.getCacheDir(), "beacon_volley");
    }
    return this.cacheDir;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Volley.1
 * JD-Core Version:    0.7.0.1
 */