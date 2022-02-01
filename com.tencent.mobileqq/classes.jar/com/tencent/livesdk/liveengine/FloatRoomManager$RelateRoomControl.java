package com.tencent.livesdk.liveengine;

public class FloatRoomManager$RelateRoomControl
{
  FloatRoomManager.RoomControl a;
  FloatRoomManager.Room b;
  
  public FloatRoomManager$RelateRoomControl(FloatRoomManager.RoomControl paramRoomControl, FloatRoomManager.Room paramRoom)
  {
    this.a = paramRoomControl;
    this.b = paramRoom;
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((FloatRoomManager.Room)localObject).destroyRoomByHand();
      this.b = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((FloatRoomManager.RoomControl)localObject).exitFloatRoom();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.FloatRoomManager.RelateRoomControl
 * JD-Core Version:    0.7.0.1
 */