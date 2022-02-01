package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.LinkedList;
import java.util.Queue;

public class RMWServiceProxy
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private RMWServiceProxy.WidgetServiceConnection jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection;
  private SimpleObservable jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable = new SimpleObservable();
  private Queue<Message> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private int jdField_b_of_type_Int = 5;
  private final Messenger jdField_b_of_type_AndroidOsMessenger = new Messenger(new RMWServiceProxy.CallbackHandler(this));
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 2: 
      return "CONNECTED";
    case 1: 
      return "CONNECTING";
    case 0: 
      return "DISCONNECTED";
    }
    return "DISCONNECTING";
  }
  
  private static void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("should invoke at main thread");
    }
  }
  
  public void a()
  {
    Messenger localMessenger = this.jdField_a_of_type_AndroidOsMessenger;
    if (localMessenger != null) {
      for (;;)
      {
        Message localMessage = (Message)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localMessage == null) {
          break;
        }
        if (localMessage.replyTo == null) {
          localMessage.replyTo = this.jdField_b_of_type_AndroidOsMessenger;
        }
        try
        {
          RMWLog.b("RMWServiceProxy", "client.flush : " + RMWProto.a(localMessage));
          localMessenger.send(localMessage);
        }
        catch (RemoteException localRemoteException)
        {
          RMWLog.a("RMWServiceProxy", "sendMessageToService error", new Object[] { localRemoteException });
        }
      }
    }
    RMWLog.b("RMWServiceProxy", "can not flushMessageQueue, service state invalid : " + a(this.jdField_a_of_type_Int));
  }
  
  protected void a(ComponentName paramComponentName)
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Int = 0;
    RMWLog.b("RMWServiceProxy", "onServiceDisconnected " + a(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new ServiceStateEvent(this.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection = null;
    }
  }
  
  protected void a(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramIBinder.linkToDeath(new RMWServiceProxy.1(this, paramComponentName), 0);
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
      this.jdField_a_of_type_Int = 2;
      RMWLog.b("RMWServiceProxy", "onServiceConnected " + a(this.jdField_a_of_type_Int));
      a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new ServiceStateEvent(this.jdField_a_of_type_Int));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      RMWLog.c("RMWServiceProxy", "linkToDeath failed : " + paramComponentName);
      new Handler(Looper.getMainLooper()).postDelayed(new RMWServiceProxy.2(this), 1000L);
    }
  }
  
  protected void a(Message paramMessage)
  {
    RMWLog.b("RMWServiceProxy", "client.handle : " + RMWProto.a(paramMessage));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new RMWEvent(paramMessage));
    paramMessage.recycle();
  }
  
  protected void a(boolean paramBoolean)
  {
    RMWLog.a("RMWServiceProxy", "setup, current state = " + a(this.jdField_a_of_type_Int) + ", force = " + paramBoolean);
    b();
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      RMWLog.c("RMWServiceProxy", "setup but without context, give up");
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Int = 5;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_b_of_type_Int -= 1;
      RMWLog.c("RMWServiceProxy", "setup again because of remote died, retry count left = " + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int = 1;
      RMWLog.a("RMWServiceProxy", "connecting ... " + a(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection = new RMWServiceProxy.WidgetServiceConnection(this);
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RMWService.class);
      this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy$WidgetServiceConnection, 1);
      return;
    }
    RMWLog.c("RMWServiceProxy", "give up setup again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy
 * JD-Core Version:    0.7.0.1
 */