package com.tencent.livesdk.liveengine;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public class FloatRoomManager
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  FloatRoomManager.Room jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room;
  FloatRoomManager.RoomControl jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl;
  Runnable jdField_a_of_type_JavaLangRunnable = new FloatRoomManager.1(this);
  WeakReference<FloatRoomManager.RoomEventInterceptor> jdField_a_of_type_JavaLangRefWeakReference;
  
  public int a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((FloatRoomManager.RoomEventInterceptor)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return -1;
  }
  
  public FloatRoomManager.RelateRoomControl a()
  {
    return new FloatRoomManager.RelateRoomControl(this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl, this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room);
  }
  
  public FloatRoomManager.RoomEventInterceptor a(FloatRoomManager.Room paramRoom)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    if (localWeakReference.get() == null) {
      return null;
    }
    if (((FloatRoomManager.RoomEventInterceptor)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != paramRoom) {
      return null;
    }
    return (FloatRoomManager.RoomEventInterceptor)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    FloatRoomManager.RoomControl localRoomControl = this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl;
    if (localRoomControl != null)
    {
      localRoomControl.exitLiveBizRoom();
      this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl = null;
    }
  }
  
  public void a(FloatRoomManager.Room paramRoom)
  {
    this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room = paramRoom;
  }
  
  public void a(FloatRoomManager.RoomControl paramRoomControl)
  {
    this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl = paramRoomControl;
  }
  
  public void a(FloatRoomManager.RoomEventInterceptor paramRoomEventInterceptor)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRoomEventInterceptor);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room;
    if (localObject != null)
    {
      ((FloatRoomManager.Room)localObject).destroyRoomByHand();
      this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room = null;
    }
    localObject = this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl;
    if (localObject != null)
    {
      ((FloatRoomManager.RoomControl)localObject).exitFloatRoom();
      this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl = null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((FloatRoomManager.RoomEventInterceptor)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.FloatRoomManager
 * JD-Core Version:    0.7.0.1
 */