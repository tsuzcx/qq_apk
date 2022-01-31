package com.tencent.biz.qqstory.takevideo.rmw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.Nullable;
import oka;
import okb;

public class RMWService
  extends Service
{
  private static RMWService jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService;
  private Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new oka(this));
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    RMWLog.b("RMWService", "ON-BIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    RMWLog.b("RMWService", "ON-CREATE : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = this;
    new okb(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RMWLog.b("RMWService", "ON-DESTROY : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    RMWLog.a("RMWService", "onStartCommand : " + paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    RMWLog.b("RMWService", "ON-UNBIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService
 * JD-Core Version:    0.7.0.1
 */