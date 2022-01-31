package com.tencent.biz.qqstory.takevideo.rmw;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.Nullable;
import vsx;
import vsz;

public class RMWService
  extends Service
{
  private static RMWService jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService;
  private Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new vsz(this));
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    vsx.c("RMWService", "ON-BIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    vsx.c("RMWService", "ON-CREATE : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = this;
    new RMWService.2(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    vsx.c("RMWService", "ON-DESTROY : " + System.identityHashCode(this));
    jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWService = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    vsx.b("RMWService", "onStartCommand : " + paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    vsx.c("RMWService", "ON-UNBIND : " + System.identityHashCode(this) + " : " + paramIntent);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService
 * JD-Core Version:    0.7.0.1
 */