import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class axnb
{
  int jdField_a_of_type_Int = 1800;
  WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  
  public axnb(QQAppInterface paramQQAppInterface)
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
      paramString = localQQAppInterface.getMessageFacade().queryLastMsgForMessageTabFromDB(paramString, 0, str);
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
    anvk localanvk;
    ExtensionInfo localExtensionInfo;
    long l1;
    label94:
    label110:
    int j;
    int i;
    label140:
    label166:
    boolean bool1;
    label177:
    do
    {
      do
      {
        return;
        localanvk = (anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localExtensionInfo = localanvk.a(paramString, true);
      } while ((localanvk.a(false)) || (localExtensionInfo == null));
      axms localaxms1 = axlr.a(localQQAppInterface, paramString, 4L, false);
      axms localaxms2 = axlr.a(localQQAppInterface, paramString, 5L, false);
      if (localaxms1 == null) {
        break;
      }
      l1 = localaxms1.d * 1000L;
      if (localaxms2 == null) {
        break label532;
      }
      l2 = localaxms2.d * 1000L;
      j = axmy.b();
      if ((localaxms2 == null) || (localaxms2.b <= 0L) || (!axmy.a(j, l2))) {
        break label538;
      }
      i = 1;
      if ((localaxms1 == null) || (localaxms1.b <= 0L) || (!axmy.a(j, l1))) {
        break label543;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label548;
      }
      bool1 = true;
      if (!bool1) {
        break label552;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck bRemind=%b frdshipType=%s fire=%s uin=%s", new Object[] { Boolean.valueOf(bool1), localaxms1, localaxms2, paramString }));
      }
      l2 = localExtensionInfo.lastHotReactiveReCheckInTs;
      this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getInt("hotreactive_recheckin_interval", 1800);
      l1 = SystemClock.elapsedRealtime();
    } while (l1 - l2 < this.jdField_a_of_type_Int * 1000);
    long l2 = localExtensionInfo.localChatSendTs;
    long l3 = localExtensionInfo.localChatRecTs;
    label308:
    boolean bool2;
    if (bhid.c(l2) == 2131719421)
    {
      bool1 = true;
      if (bhid.c(l3) != 2131719421) {
        break label560;
      }
      bool2 = true;
      label321:
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck msg bSendToday=%b bRecToday=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool1) {
        break label583;
      }
      l2 = a(paramString, true);
      if (bhid.c(l2) != 2131719421) {
        break label566;
      }
      bool1 = true;
      label384:
      if (!bool1) {
        break label578;
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
        if (bhid.c(l2) != 2131719421) {
          break label572;
        }
      }
      label532:
      label538:
      label543:
      label548:
      label552:
      label560:
      label566:
      label572:
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
              ((FriendListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqRecheckInHotReactive(paramString);
            }
          }
        }
        if (i == 0) {
          break;
        }
        localanvk.a(localExtensionInfo);
        return;
        l1 = 0L;
        break label94;
        l2 = 0L;
        break label110;
        i = 0;
        break label140;
        j = 0;
        break label166;
        bool1 = false;
        break label177;
        break;
        bool1 = false;
        break label308;
        bool2 = false;
        break label321;
        bool1 = false;
        break label384;
      }
      label578:
      i = 0;
      continue;
      label583:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axnb
 * JD-Core Version:    0.7.0.1
 */