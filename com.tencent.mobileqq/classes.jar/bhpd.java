import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager.1;
import com.tencent.util.notification.NotifyIdManager.2;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bhpd
  implements Manager
{
  static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private Map<String, Boolean> jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Map<String, Boolean> c;
  
  public bhpd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    e();
  }
  
  private bahs a(String paramString)
  {
    paramString = new bahs(paramString, 16);
    paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.context.getResources().getColor(2131166171)), 0, paramString.length(), 33);
    return paramString;
  }
  
  public static bhpd a()
  {
    return a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static bhpd a(QQAppInterface paramQQAppInterface)
  {
    return (bhpd)paramQQAppInterface.getManager(313);
  }
  
  public static TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramQQAppInterface.a(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (!((QQAppInterface)localAppRuntime).f())) {
      return false;
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1009) || (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1003) || (paramInt == 1004) || (paramInt == 1005) || (paramInt == 1020) || (paramInt == 1000) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 10007) || (paramInt == 10008)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((!a(paramMessage.istroop)) || (!a(paramMessage.frienduin))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("=").append(this.jdField_a_of_type_JavaUtilMap.get(str)).append(",");
    }
    if (localStringBuilder.length() >= 1) {
      localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length());
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "saveUinIdMapToSp: invoked.  mapAsString: " + localStringBuilder);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 4).edit().putString("SP_KEY_CURRENT_NOTIFY_ID_MAP", localStringBuilder.toString()).apply();
  }
  
  private void d()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str, 4).edit().putInt("SP_KEY_CURRENT_NOTIFY_ID", this.jdField_a_of_type_Int).apply();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "saveCurrentIdToSp: invoked. ", " mCurrentMinId: ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  private void e()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 4);
    String str = ((SharedPreferences)localObject).getString("SP_KEY_CURRENT_NOTIFY_ID_MAP", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        String[] arrayOfString1 = str.split(",");
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          localConcurrentHashMap.put(arrayOfString2[0], Integer.valueOf(Integer.parseInt(arrayOfString2[1])));
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label157;
        }
      }
      catch (Exception localException)
      {
        QLog.e("NotifyIdManager", 1, "restoreUinIdMapFromSp: failed. ", localException);
      }
    } else {
      QLog.d("NotifyIdManager", 2, new Object[] { "restoreUinIdMapFromSp: invoked. ", " mapStr: ", str });
    }
    label157:
    this.jdField_a_of_type_JavaUtilMap = localConcurrentHashMap;
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("SP_KEY_CURRENT_NOTIFY_ID", 512);
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "uniqueNotifyIdByUin: invoked. ", " friendUin: ", paramString });
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 522) {
      this.jdField_a_of_type_Int = 512;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(this.jdField_a_of_type_Int));
    c();
    d();
    return this.jdField_a_of_type_Int;
  }
  
  public String a(String paramString, QQMessageFacade.Message paramMessage)
  {
    String str = paramString;
    if (akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramMessage.frienduin)) {
      str = alpo.a(2131708019) + paramString;
    }
    return str;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, "cancelAllNotification: invoked. ");
    }
    ThreadManager.excute(new NotifyIdManager.2(this, QQNotificationManager.getInstance()), 16, null, false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotifyIdManager", 2, new Object[] { "cancelNotificationByMessage: invoked. ", " message: ", paramMessage });
      }
      if (!d(paramMessage)) {
        b(paramMessage.frienduin);
      }
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, Intent paramIntent, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((a(paramMessage.frienduin, paramMessage.senderuin)) && (paramMessage.istroop == 1))
    {
      paramSpannableStringBuilder.clear();
      paramIntent = paramIntent.getStringExtra("uinname");
      paramSpannableStringBuilder.append(new bahs("[" + paramIntent + "]", 16));
      paramSpannableStringBuilder.append(a(alpo.a(2131708018)));
      paramSpannableStringBuilder.append(new bahs(paramMessage.nickName, 16));
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramMessage.senderuin)) && (paramMessage.istroop == 0)) {
      paramSpannableStringBuilder.append(a(alpo.a(2131708020)));
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage, TextView paramTextView)
  {
    paramTextView = paramTextView.getHandler();
    if ((b(paramMessage)) && (paramTextView != null))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      paramTextView.postDelayed(new NotifyIdManager.1(this), 5000L);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramSessionInfo.a;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "onAioResume: invoked. ", " curFriendUin: ", paramSessionInfo });
    }
    b(paramSessionInfo);
    a(paramSessionInfo);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "clearUinNeedShowCareMap: invoked.  friendOrTroopUin: " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      this.c.remove(paramString);
    }
  }
  
  public boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      if ((Looper.myLooper() == Looper.getMainLooper()) && (QLog.isColorLevel())) {
        QLog.i("NotifyIdManager", 2, "troopMemberIsCared: invoked. run on ui thread. ");
      }
      paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("NotifyIdManager", 2, "troopMemberIsCared: invoked. cost: " + (System.currentTimeMillis() - l));
      }
    } while (paramString1 == null);
    return paramString1.isTroopFollowed;
  }
  
  public String b(String paramString, QQMessageFacade.Message paramMessage)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage.frienduin, paramMessage.senderuin);
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "getCareTroopMemberMsgText: invoked.  troopMemberIsCared: " + bool);
    }
    Object localObject = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramMessage.frienduin);
    Boolean localBoolean = (Boolean)this.c.get(paramMessage.frienduin);
    if ((bool) || ((localObject != null) && (((Boolean)localObject).booleanValue())))
    {
      if (localObject == null) {
        this.jdField_b_of_type_JavaUtilMap.put(paramMessage.frienduin, Boolean.valueOf(true));
      }
      localObject = alpo.a(2131708021) + paramString;
    }
    do
    {
      do
      {
        return localObject;
        if (paramMessage.bizType == 16) {
          break;
        }
        localObject = paramString;
      } while (localBoolean == null);
      localObject = paramString;
    } while (!localBoolean.booleanValue());
    if (localBoolean == null) {
      this.c.put(paramMessage.frienduin, Boolean.valueOf(true));
    }
    return localResources.getString(2131699973) + paramString;
  }
  
  public void b()
  {
    ((alkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).j();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NotifyIdManager", 2, "cancelNotificationByUin: call stack: ", new RuntimeException());
    }
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("NotifyIdManager", 2, "cancelNotificationByUin: invoked.  notifyId: " + localInteger + " friendUin: " + paramString);
    }
    if (localInteger != null) {
      QQNotificationManager.getInstance().cancel("NotifyIdManager", localInteger.intValue());
    }
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    c();
  }
  
  public boolean b(QQMessageFacade.Message paramMessage)
  {
    return akaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramMessage.senderuin);
  }
  
  public boolean c(QQMessageFacade.Message paramMessage)
  {
    return (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!b(paramMessage));
  }
  
  public boolean d(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage != null) && (paramMessage.counter > 0);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpd
 * JD-Core Version:    0.7.0.1
 */