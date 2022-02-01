package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.io.QStorageManager;

public final class ps
  implements md
{
  private Context a;
  private final QStorageManager b;
  private String c;
  
  public ps(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      this.b = QStorageManager.getInstance(this.a);
      this.c = paramString;
      return;
    }
    this.b = null;
  }
  
  public final String a()
  {
    QStorageManager localQStorageManager = this.b;
    if (localQStorageManager != null) {
      return localQStorageManager.getMapPath();
    }
    return null;
  }
  
  public final String b()
  {
    QStorageManager localQStorageManager = this.b;
    if (localQStorageManager != null) {
      return localQStorageManager.getSatPath();
    }
    return null;
  }
  
  public final String c()
  {
    QStorageManager localQStorageManager = this.b;
    if (localQStorageManager != null) {
      return localQStorageManager.getConfigPath(this.c);
    }
    return null;
  }
  
  public final String d()
  {
    QStorageManager localQStorageManager = this.b;
    if (localQStorageManager != null) {
      return localQStorageManager.getAssetsLoadPath(this.c);
    }
    return null;
  }
  
  public final String e()
  {
    QStorageManager localQStorageManager = this.b;
    if (localQStorageManager != null) {
      return localQStorageManager.getRouteBlockPath();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ps
 * JD-Core Version:    0.7.0.1
 */