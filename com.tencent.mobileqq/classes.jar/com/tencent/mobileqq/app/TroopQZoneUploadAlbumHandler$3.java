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
    this.a.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
    this.a.b = new Messenger(this.a.jdField_a_of_type_AndroidOsHandler);
    TroopQZoneUploadAlbumHandler.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = null;
    TroopQZoneUploadAlbumHandler.a(this.a, 4);
    this.a.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.a.b = null;
    TroopQZoneUploadAlbumHandler.a(this.a, true);
    if (TroopQZoneUploadAlbumHandler.a(this.a) != null) {
      TroopQZoneUploadAlbumHandler.a(this.a).interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.3
 * JD-Core Version:    0.7.0.1
 */