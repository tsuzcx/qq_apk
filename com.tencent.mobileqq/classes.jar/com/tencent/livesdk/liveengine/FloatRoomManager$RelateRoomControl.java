package com.tencent.livesdk.liveengine;

public class FloatRoomManager$RelateRoomControl
{
  FloatRoomManager.Room jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room;
  FloatRoomManager.RoomControl jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl;
  
  public FloatRoomManager$RelateRoomControl(FloatRoomManager.RoomControl paramRoomControl, FloatRoomManager.Room paramRoom)
  {
    this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$RoomControl = paramRoomControl;
    this.jdField_a_of_type_ComTencentLivesdkLiveengineFloatRoomManager$Room = paramRoom;
  }
  
  public void a()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.FloatRoomManager.RelateRoomControl
 * JD-Core Version:    0.7.0.1
 */