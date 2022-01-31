package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.qphone.base.util.BaseApplication;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;

public class RecentUserMsgFactory
{
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    String str;
    switch (paramInt)
    {
    case 15: 
    case 16: 
    case 21: 
    case 24: 
    default: 
      str = null;
    }
    while (localObject != null)
    {
      ((IRecentUserMsg)localObject).a(paramArrayOfByte);
      return localObject;
      localObject = new TroopSpecialAttentionMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopNotificationMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopAtMeMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopAtAllMsg(BaseApplication.getContext());
      str = null;
      continue;
      str = new String(paramArrayOfByte);
      continue;
      localObject = new TroopHomeworkSpecialMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopHasGiftMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopReplyMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopNewFileMsg(BaseApplication.getContext(), 1);
      str = null;
      continue;
      localObject = new TroopNewFileMsg(BaseApplication.getContext(), 0);
      str = null;
      continue;
      localObject = new TroopCalendarMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopPubAccountMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopNotificationMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopHomeworkPraiseMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopStickerNotifyMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopReceiptMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new TroopEffectPicMsg(BaseApplication.getContext());
      str = null;
      continue;
      localObject = new ArkInfoMsg(BaseApplication.getContext(), "");
      str = null;
    }
    return str;
  }
  
  public static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
    } while (!(paramObject instanceof IRecentUserMsg));
    return ((IRecentUserMsg)paramObject).a();
    return ((String)paramObject).getBytes();
    return ((TroopReplyMsg)paramObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory
 * JD-Core Version:    0.7.0.1
 */