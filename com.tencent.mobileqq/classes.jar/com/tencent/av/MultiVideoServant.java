package com.tencent.av;

import android.text.TextUtils;

public class MultiVideoServant
  implements IVideoServant
{
  private static final String[] a = { "QQRTCSvc.chatroom_send_msg", "QQRTCSvc.chatroom_get_msg", "QQRTCSvc.RoomManager-StartAvTogether", "QQRTCSvc.RoomManager-CloseAvTogether", "QQRTCSvc.RoomManager-GetRoomInfo", "QQRTCSvc.RoomManager-ChangeVideoStatus", "QQRTCSvc.RoomManager-ChangeVideoFile", "QQRTCSvc.RoomManager-SyncPlayTime", "QQRTCSvc.RoomManager-UserEnterRoom", "QQRTCSvc.RoomManager-UserQuitRoom" };
  
  public String a()
  {
    return "MultiVideo";
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String b()
  {
    return "MultiVideoMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.MultiVideoServant
 * JD-Core Version:    0.7.0.1
 */