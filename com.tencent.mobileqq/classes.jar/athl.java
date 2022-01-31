import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.media_relation.media_relation.MediaRelationInfo;

public class athl
{
  public static String a = "ListenTogetherAIOStatusHelper";
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "setIsGroupListenTogetherOpen, app = " + paramQQAppInterface + " troopuin:" + paramString + " isOpen:" + paramBoolean);
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.b(paramString);
        if (paramString != null)
        {
          paramString.setIsListenTogether(paramBoolean);
          paramQQAppInterface.b(paramString);
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, "setIsGroupListenTogetherOpen troopinfo saved");
          }
        }
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    media_relation.MediaRelationInfo localMediaRelationInfo;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localMediaRelationInfo = new media_relation.MediaRelationInfo();
    }
    try
    {
      localMediaRelationInfo.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localMediaRelationInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l;
        paramArrayOfByte = null;
        localException.printStackTrace();
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.create_time.has()))
    {
      i = paramArrayOfByte.create_time.get();
      l = NetConnInfoCenter.getServerTime();
    }
    return i >= l - 604800L;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "setIsC2CListenTogetherOpen, app = " + paramQQAppInterface + " frienduin:" + paramString + " isOpen:" + paramBoolean);
    }
    Friends localFriends;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
      if (localaloz != null)
      {
        localFriends = localaloz.e(paramString);
        if ((localFriends == null) || (!localFriends.isFriend())) {
          paramBoolean = false;
        }
        ExtensionInfo localExtensionInfo = localaloz.a(paramString);
        localObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          localObject = new ExtensionInfo();
          ((ExtensionInfo)localObject).uin = paramString;
        }
        boolean bool = ((ExtensionInfo)localObject).isListenTogetherOpen;
        if (bool != paramBoolean)
        {
          ((ExtensionInfo)localObject).isListenTogetherOpen = paramBoolean;
          localaloz.a((ExtensionInfo)localObject);
          ((FriendListHandler)paramQQAppInterface.a(1)).notifyUI(3, true, paramString);
        }
        if (QLog.isColorLevel())
        {
          paramString = a;
          localObject = new StringBuilder().append("setIsC2CListenTogetherOpen extensionInfo saved, old=").append(bool).append(" new:").append(paramBoolean).append(" friend:");
          if (localFriends == null) {
            break label234;
          }
        }
      }
    }
    label234:
    for (paramQQAppInterface = Boolean.valueOf(localFriends.isFriend());; paramQQAppInterface = "null")
    {
      QLog.i(paramString, 2, paramQQAppInterface);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athl
 * JD-Core Version:    0.7.0.1
 */