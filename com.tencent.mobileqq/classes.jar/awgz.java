import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class awgz
{
  int jdField_a_of_type_Int = 1800;
  WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  
  public awgz(QQAppInterface paramQQAppInterface)
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
    amsw localamsw;
    ExtensionInfo localExtensionInfo;
    long l1;
    label93:
    label109:
    int j;
    int i;
    label139:
    label165:
    boolean bool1;
    label176:
    do
    {
      do
      {
        return;
        localamsw = (amsw)localQQAppInterface.getManager(51);
        localExtensionInfo = localamsw.a(paramString, true);
      } while ((localamsw.a(false)) || (localExtensionInfo == null));
      awgq localawgq1 = awfp.a(localQQAppInterface, paramString, 4L, false);
      awgq localawgq2 = awfp.a(localQQAppInterface, paramString, 5L, false);
      if (localawgq1 == null) {
        break;
      }
      l1 = localawgq1.d * 1000L;
      if (localawgq2 == null) {
        break label529;
      }
      l2 = localawgq2.d * 1000L;
      j = awgw.b();
      if ((localawgq2 == null) || (localawgq2.b <= 0L) || (!awgw.a(j, l2))) {
        break label535;
      }
      i = 1;
      if ((localawgq1 == null) || (localawgq1.b <= 0L) || (!awgw.a(j, l1))) {
        break label540;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label545;
      }
      bool1 = true;
      if (!bool1) {
        break label549;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck bRemind=%b frdshipType=%s fire=%s uin=%s", new Object[] { Boolean.valueOf(bool1), localawgq1, localawgq2, paramString }));
      }
      l2 = localExtensionInfo.lastHotReactiveReCheckInTs;
      this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getInt("hotreactive_recheckin_interval", 1800);
      l1 = SystemClock.elapsedRealtime();
    } while (l1 - l2 < this.jdField_a_of_type_Int * 1000);
    long l2 = localExtensionInfo.localChatSendTs;
    long l3 = localExtensionInfo.localChatRecTs;
    label307:
    boolean bool2;
    if (bfzl.c(l2) == 2131719016)
    {
      bool1 = true;
      if (bfzl.c(l3) != 2131719016) {
        break label557;
      }
      bool2 = true;
      label320:
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck msg bSendToday=%b bRecToday=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool1) {
        break label580;
      }
      l2 = a(paramString, true);
      if (bfzl.c(l2) != 2131719016) {
        break label563;
      }
      bool1 = true;
      label383:
      if (!bool1) {
        break label575;
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
        if (bfzl.c(l2) != 2131719016) {
          break label569;
        }
      }
      label529:
      label535:
      label540:
      label545:
      label549:
      label557:
      label563:
      label569:
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
              ((FriendListHandler)localQQAppInterface.getBusinessHandler(1)).reqRecheckInHotReactive(paramString);
            }
          }
        }
        if (i == 0) {
          break;
        }
        localamsw.a(localExtensionInfo);
        return;
        l1 = 0L;
        break label93;
        l2 = 0L;
        break label109;
        i = 0;
        break label139;
        j = 0;
        break label165;
        bool1 = false;
        break label176;
        break;
        bool1 = false;
        break label307;
        bool2 = false;
        break label320;
        bool1 = false;
        break label383;
      }
      label575:
      i = 0;
      continue;
      label580:
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
 * Qualified Name:     awgz
 * JD-Core Version:    0.7.0.1
 */