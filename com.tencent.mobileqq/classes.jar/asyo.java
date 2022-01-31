import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class asyo
{
  int jdField_a_of_type_Int = 1800;
  WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  
  public asyo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public long a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQAppInterface == null) {
      return 0L;
    }
    String str;
    if (paramBoolean)
    {
      str = "issend<>0";
      paramString = localQQAppInterface.a().b(paramString, 0, str);
      if (paramString != null) {
        break label59;
      }
    }
    label59:
    for (long l = 0L;; l = paramString.time)
    {
      return 1000L * l;
      str = "issend=0";
      break;
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQAppInterface == null) {}
    ajxl localajxl;
    ExtensionInfo localExtensionInfo;
    boolean bool1;
    int i;
    int j;
    long l1;
    boolean bool2;
    label144:
    do
    {
      do
      {
        return;
        localajxl = (ajxl)localQQAppInterface.getManager(51);
        localExtensionInfo = localajxl.a(paramString, true);
        bool1 = localajxl.a(false);
      } while ((bool1) || (localExtensionInfo == null));
      i = asyj.a(6, paramString, localExtensionInfo, bool1);
      j = asyj.a(5, paramString, localExtensionInfo, bool1);
      l1 = localExtensionInfo.lastFriendshipTime;
      l2 = localExtensionInfo.lastChatTime;
      int k = asyj.b();
      bool1 = asyj.a(k, l2 * 1000L);
      bool2 = asyj.a(k, l1 * 1000L);
      if (((i <= 0) || (!bool2)) && ((j <= 0) || (!bool1))) {
        break;
      }
      bool1 = true;
      if (!bool1) {
        break label499;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck bRemind=%b frdshipType=%d fire=%d uin=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), paramString }));
      }
      l2 = localExtensionInfo.lastHotReactiveReCheckInTs;
      this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getInt("hotreactive_recheckin_interval", 1800);
      l1 = SystemClock.elapsedRealtime();
    } while (l1 - l2 < this.jdField_a_of_type_Int * 1000);
    long l2 = localExtensionInfo.localChatSendTs;
    long l3 = localExtensionInfo.localChatRecTs;
    if (bbkp.c(l2) == 2131720346)
    {
      bool1 = true;
      label279:
      if (bbkp.c(l3) != 2131720346) {
        break label507;
      }
      bool2 = true;
      label292:
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck msg bSendToday=%b bRecToday=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool1) {
        break label530;
      }
      l2 = a(paramString, true);
      if (bbkp.c(l2) != 2131720346) {
        break label513;
      }
      bool1 = true;
      label355:
      if (!bool1) {
        break label525;
      }
      localExtensionInfo.localChatSendTs = l2;
      i = 1;
    }
    for (;;)
    {
      j = i;
      boolean bool3 = bool2;
      if (!bool2)
      {
        l2 = a(paramString, false);
        if (bbkp.c(l2) != 2131720346) {
          break label519;
        }
      }
      label513:
      label519:
      for (bool2 = true;; bool2 = false)
      {
        j = i;
        bool3 = bool2;
        if (bool2)
        {
          localExtensionInfo.localChatRecTs = l2;
          j = 1;
          bool3 = bool2;
        }
        i = j;
        if (bool3)
        {
          i = j;
          if (bool1)
          {
            i = j;
            if (AppNetConnInfo.isNetSupport())
            {
              localExtensionInfo.lastHotReactiveReCheckInTs = l1;
              i = 1;
              if (QLog.isColorLevel()) {
                QLog.i("FriendReactive.ReCheckInHelper", 2, "startCheck recheckin");
              }
              ((FriendListHandler)localQQAppInterface.a(1)).g(paramString);
            }
          }
        }
        if (i == 0) {
          break;
        }
        localajxl.a(localExtensionInfo);
        return;
        bool1 = false;
        break label144;
        label499:
        break;
        bool1 = false;
        break label279;
        label507:
        bool2 = false;
        break label292;
        bool1 = false;
        break label355;
      }
      label525:
      i = 0;
      continue;
      label530:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("onRecheckInResp isSuc=%b selfUin=%s frdUin=%s interval=%d", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2, Integer.valueOf(paramInt) }));
      }
    } while ((!paramBoolean) || (paramInt <= 0) || (paramInt == this.jdField_a_of_type_Int));
    BaseApplicationImpl.getContext().getSharedPreferences(paramString1, 0).edit().putInt("hotreactive_recheckin_interval", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyo
 * JD-Core Version:    0.7.0.1
 */