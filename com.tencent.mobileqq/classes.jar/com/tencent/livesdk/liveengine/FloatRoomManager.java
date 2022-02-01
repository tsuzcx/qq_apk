package com.tencent.livesdk.liveengine;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public class FloatRoomManager
{
  FloatRoomManager.Room a;
  WeakReference<FloatRoomManager.RoomEventInterceptor> b;
  FloatRoomManager.RoomControl c;
  Runnable d = new FloatRoomManager.1(this);
  Handler e = new Handler(Looper.getMainLooper());
  
  public int a()
  {
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((FloatRoomManager.RoomEventInterceptor)this.b.get()).a();
    }
    return -1;
  }
  
  public void a(FloatRoomManager.Room paramRoom)
  {
    this.a = paramRoom;
  }
  
  public void a(FloatRoomManager.RoomControl paramRoomControl)
  {
    this.c = paramRoomControl;
  }
  
  public void a(FloatRoomManager.RoomEventInterceptor paramRoomEventInterceptor)
  {
    this.b = new WeakReference(paramRoomEventInterceptor);
  }
  
  public FloatRoomManager.RoomEventInterceptor b(FloatRoomManager.Room paramRoom)
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference == null) {
      return null;
    }
    if (localWeakReference.get() == null) {
      return null;
    }
    if (((FloatRoomManager.RoomEventInterceptor)this.b.get()).c() != paramRoom) {
      return null;
    }
    return (FloatRoomManager.RoomEventInterceptor)this.b.get();
  }
  
  public void b()
  {
    FloatRoomManager.RoomControl localRoomControl = this.c;
    if (localRoomControl != null)
    {
      localRoomControl.exitLiveBizRoom();
      this.c = null;
    }
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((FloatRoomManager.Room)localObject).destroyRoomByHand();
      this.a = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((FloatRoomManager.RoomControl)localObject).exitFloatRoom();
      this.c = null;
    }
  }
  
  public void d()
  {
    this.e.removeCallbacks(this.d);
    this.e.postDelayed(this.d, 3000L);
  }
  
  public void e()
  {
    this.e.removeCallbacks(this.d);
  }
  
  public void f()
  {
    this.e.removeCallbacks(this.d);
  }
  
  public void g()
  {
    this.e.removeCallbacks(this.d);
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((FloatRoomManager.RoomEventInterceptor)this.b.get()).a(this);
    }
  }
  
  public FloatRoomManager.RelateRoomControl h()
  {
    return new FloatRoomManager.RelateRoomControl(this.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.FloatRoomManager
 * JD-Core Version:    0.7.0.1
 */