package com.tencent.av.ui.chatroom;

import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

class VideoChatRoomUIContoller$ChatRoomUIObserver
  implements Observer
{
  private final WeakReference<VideoChatRoomUIContoller> a;
  
  VideoChatRoomUIContoller$ChatRoomUIObserver(VideoChatRoomUIContoller paramVideoChatRoomUIContoller)
  {
    this.a = new WeakReference(paramVideoChatRoomUIContoller);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    }
    do
    {
      return;
      paramObject = (VideoChatRoomUIContoller)this.a.get();
    } while ((paramObject == null) || (paramObservable.length < 2) || (!(paramObservable[1] instanceof Boolean)) || (((Boolean)paramObservable[1]).booleanValue()));
    paramObject.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.ChatRoomUIObserver
 * JD-Core Version:    0.7.0.1
 */