package com.tencent.mobileqq.app;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

class TroopQZoneUploadAlbumHandler$3
  implements ServiceConnection
{
  TroopQZoneUploadAlbumHandler$3(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TroopQZoneUploadAlbumHandler.a(this.a, 2);
    TroopQZoneUploadAlbumHandler.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceConnected()...");
    }
    this.a.b = new Messenger(paramIBinder);
    paramComponentName = this.a;
    paramComponentName.c = new Messenger(paramComponentName.a);
    TroopQZoneUploadAlbumHandler.e(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    paramComponentName = this.a;
    paramComponentName.b = null;
    TroopQZoneUploadAlbumHandler.a(paramComponentName, 4);
    this.a.d.clear();
    paramComponentName = this.a;
    paramComponentName.c = null;
    TroopQZoneUploadAlbumHandler.a(paramComponentName, true);
    if (TroopQZoneUploadAlbumHandler.d(this.a) != null) {
      TroopQZoneUploadAlbumHandler.d(this.a).interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.3
 * JD-Core Version:    0.7.0.1
 */