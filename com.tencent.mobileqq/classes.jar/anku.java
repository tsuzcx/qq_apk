import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkTipsManager.4;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class anku
{
  private static volatile anku jdField_a_of_type_Anku;
  private long jdField_a_of_type_Long = -1L;
  private alsi jdField_a_of_type_Alsi = new ankv(this);
  private ankz jdField_a_of_type_Ankz;
  private WeakReference<afds> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<BaseChatPie> b;
  private WeakReference<QQAppInterface> c;
  
  public static anku a()
  {
    if (jdField_a_of_type_Anku == null) {}
    try
    {
      if (jdField_a_of_type_Anku == null) {
        jdField_a_of_type_Anku = new anku();
      }
      return jdField_a_of_type_Anku;
    }
    finally {}
  }
  
  public static String a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.appDesc))) {
      paramMessageForArkApp = "";
    }
    String str;
    do
    {
      return paramMessageForArkApp;
      str = paramMessageForArkApp.ark_app_message.appDesc;
      paramMessageForArkApp = str;
    } while (str.length() <= 4);
    return str.substring(0, 4);
  }
  
  private void a(Bitmap paramBitmap, Context paramContext)
  {
    if ((this.jdField_a_of_type_Ankz != null) && (paramContext != null))
    {
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (TipsBar)this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramContext != null) {
          paramContext.setTipsIcon(paramBitmap);
        }
        azmj.a((QQAppInterface)this.c.get(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 4, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (aguo)this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (paramContext != null) {
          paramContext.a(paramBitmap);
        }
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null) {
        paramMessageForArkApp.arkContainer.a();
      }
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null)) {
            localMessageForArkApp.arkContainer.a();
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has attached:" + paramMessageForArkApp.uniseq + ",c=" + paramMessageForArkApp.arkContainer);
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null)
      {
        paramMessageForArkApp.arkContainer.b();
        if (paramBoolean) {
          paramMessageForArkApp.arkContainer.doOnEvent(2);
        }
      }
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null))
          {
            localMessageForArkApp.arkContainer.b();
            localMessageForArkApp.arkContainer.doOnEvent(2);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has dettached:" + paramMessageForArkApp.uniseq + ",destroy:" + paramBoolean + ",c=" + paramMessageForArkApp.arkContainer);
      }
    }
  }
  
  private void a(String paramString)
  {
    boolean bool2 = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("showMainTip : ref null= :");
      if (this.c != null) {
        break label130;
      }
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", isHide=");
      if (paramString != null) {
        break label135;
      }
    }
    label130:
    label135:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ArkTipsManager", 2, bool1);
      if (this.c != null)
      {
        localObject = (QQAppInterface)this.c.get();
        if (localObject != null)
        {
          localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
          Message localMessage = new Message();
          localMessage.what = 1052;
          localMessage.obj = paramString;
          ((MqqHandler)localObject).sendMessage(localMessage);
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Ankz != null) && (this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.jdField_b_of_type_JavaLangRefWeakReference != null))
    {
      paramString1 = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (paramString1 != null)
      {
        paramString1 = paramString1.a(paramString2, this.jdField_a_of_type_Ankz.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramString1);
      }
    }
  }
  
  private void d()
  {
    a(null);
  }
  
  public afds a()
  {
    if (this.jdField_a_of_type_Ankz == null) {
      return null;
    }
    return this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds;
  }
  
  public MessageForArkApp a()
  {
    if (this.jdField_a_of_type_Ankz != null) {
      return this.jdField_a_of_type_Ankz.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
    }
    return null;
  }
  
  public TipsBar a(Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    ankz localankz = this.jdField_a_of_type_Ankz;
    if ((localankz != null) && (localankz.jdField_b_of_type_JavaLangString != null))
    {
      localankz.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localTipsBar);
      localTipsBar.setTipsText(localankz.jdField_b_of_type_JavaLangString);
    }
    a(paramContext);
    return localTipsBar;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Ankz != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ankz.d)) && (this.c != null))
    {
      anjv.a((QQAppInterface)this.c.get(), this.jdField_a_of_type_Ankz.d, "AIOStatusBarClick", 0, 0, 0L, 0L, 0L, "", "");
      azmj.a((QQAppInterface)this.c.get(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 4, 0, "", "", "", "");
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("useq=").append(paramLong);
      if (this.jdField_a_of_type_Ankz != null) {
        break label66;
      }
    }
    label66:
    for (String str = "";; str = "<>" + this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds + "," + this.jdField_a_of_type_Ankz.jdField_b_of_type_Long)
    {
      QLog.d("ArkTipsManager", 2, str);
      ArkAppCenter.a().postToMainThread(new ArkTipsManager.4(this, paramLong));
      return;
    }
  }
  
  public void a(afds paramafds, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramSessionInfo == null) || (paramMessageForArkApp == null)) {}
    long l1;
    long l2;
    label92:
    String str1;
    Object localObject;
    boolean bool;
    do
    {
      return;
      if ((paramMessageForArkApp.istroop == 1) || (paramMessageForArkApp.istroop == 3000)) {}
      for (l1 = paramMessageForArkApp.shmsgseq;; l1 = paramMessageForArkApp.time)
      {
        l2 = paramMessageForArkApp.uniseq;
        if (l2 != this.jdField_a_of_type_Long) {
          break label92;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ArkTipsManager", 2, "showTip deleting:" + l2);
        return;
      }
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showTip sessUin:").append(str1).append(",first Show ? ");
        if (this.jdField_a_of_type_Ankz != null) {
          break;
        }
        bool = true;
        QLog.i("ArkTipsManager", 2, bool + ", msg=" + paramString);
      }
    } while (str1 == null);
    String str2 = paramSessionInfo.d;
    this.c = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkApp.ark_app_message != null)
    {
      localObject = paramMessageForArkApp.ark_app_message.appName;
      label207:
      if (this.jdField_a_of_type_Ankz != null) {
        break label376;
      }
      this.jdField_a_of_type_Ankz = new ankz(paramafds, str1, l1, l2, str2, paramSessionInfo.jdField_a_of_type_Int, (String)localObject, paramMessageForArkApp);
    }
    label376:
    while ((this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds == paramafds) && (l1 == this.jdField_a_of_type_Ankz.jdField_a_of_type_Long))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "showTip view:" + paramafds + "msgID ? " + l1);
      }
      a(paramMessageForArkApp);
      this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangString = paramString;
      a(paramString);
      a(str1, paramString);
      if (paramMessageForArkApp.ark_app_message != null) {
        anjv.a(paramQQAppInterface, paramMessageForArkApp.ark_app_message.appName, "AIOStatusBarShow", 0, 0, 0L, 0L, 0L, "", "");
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
      localObject = "";
      break label207;
    }
    if ((this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds != paramafds) && (this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds != null))
    {
      if (str1.equals(this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString)) {
        break label474;
      }
      a(this.jdField_a_of_type_Ankz.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ankz.a(paramafds, str1, l1, l2, str2, paramSessionInfo.jdField_a_of_type_Int, (String)localObject, paramMessageForArkApp);
      break;
      label474:
      a(this.jdField_a_of_type_Ankz.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, false);
    }
  }
  
  public void a(afdt paramafdt, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Ankz == null) || (paramString == null) || (paramafdt != this.jdField_a_of_type_Ankz.jdField_a_of_type_Afds)) {
      break label29;
    }
    label29:
    while ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramafdt)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateCurrentTip : sessionInfo:");
      if (paramSessionInfo != null) {
        break label186;
      }
    }
    label186:
    for (String str = "";; str = paramSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.d("ArkTipsManager", 2, str + ",tar:" + this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString + ",c=" + paramafdt);
      this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangString = paramString;
      a(paramString);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString)) || (paramSessionInfo.jdField_a_of_type_Int != this.jdField_a_of_type_Ankz.jdField_a_of_type_Int)) {
        break;
      }
      a(this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString, paramString);
      return;
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Ankz == null) || (paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i = this.jdField_a_of_type_Ankz.jdField_a_of_type_Int;
    String str1 = this.jdField_a_of_type_Ankz.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Ankz.c;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("need_jump_to_msg", true);
    localBundle.putLong("searched_timeorseq", this.jdField_a_of_type_Ankz.jdField_a_of_type_Long);
    ajgm.a(paramActivity, paramQQAppInterface, str1, i, str2, false, localBundle);
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Ankz == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_Ankz.d;
    String str2 = this.jdField_a_of_type_Ankz.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appView;
    if (ArkAppMgr.getInstance().getAppPathByNameFromLocal(str1, str2, null, false) != null)
    {
      ArkAppCacheMgr.getAppIcon(str1, new ankw(this, paramContext));
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str1, str2, "0.0.0.1", null, new ankx(this, str1, paramContext));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    if (this.jdField_a_of_type_Ankz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterAIO");
      }
      a(paramBaseChatPie.a(), this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    while (QQAppInterface.isAppOnForeground(paramQQAppInterface.getApp())) {
      return;
    }
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
    Intent localIntent = new Intent();
    localIntent.putExtra("param_notifyid", 239);
    localBuilder.setSmallIcon(2130841130).setWhen(System.currentTimeMillis()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface.getApp(), 0, localIntent, 0));
    paramQQAppInterface = localBuilder.build();
    paramQQAppInterface.flags = 16;
    localQQNotificationManager.notify("ArkTipsManager", 239, paramQQAppInterface);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Ankz == null) {}
    while (this.jdField_a_of_type_Ankz.jdField_b_of_type_Long != paramLong) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("hideTips : mCurrentTip :");
      if (this.jdField_a_of_type_Ankz != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ArkTipsManager", 2, bool);
      if (this.jdField_a_of_type_Ankz != null)
      {
        if (this.c != null)
        {
          localObject = (QQAppInterface)this.c.get();
          if (localObject != null) {
            ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Alsi);
          }
        }
        this.jdField_a_of_type_Ankz = null;
        if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(null, -1L);
          }
        }
        d();
        this.jdField_a_of_type_Boolean = false;
        this.c = null;
      }
      return;
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() == paramBaseChatPie))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onExitAIO");
      }
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ankz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterConversation");
      }
      a(this.jdField_a_of_type_Ankz.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anku
 * JD-Core Version:    0.7.0.1
 */