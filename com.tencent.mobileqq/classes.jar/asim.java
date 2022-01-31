import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.io.File;
import mqq.manager.Manager;

public class asim
  implements Manager
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = true;
  
  public asim(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (SettingCloneUtil.isContainValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "system_notification_enabled_key")) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "system_notification_enabled_key", true);; bool = b())
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private Bitmap a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "getBitmapFromLocal: invoked. ", " id: ", Integer.valueOf(i), " iconUrl: ", paramString });
      }
      i = aqvd.a(i);
      paramString = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), i);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("NewMsgNotificationManager", 1, "getBitmapFromLocal: failed. ", paramString);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewMsgNotificationManager", 2, "getBitmapFromLocal: failed. ", paramString);
        }
      }
    }
  }
  
  public static asim a(QQAppInterface paramQQAppInterface)
  {
    return (asim)paramQQAppInterface.getManager(349);
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1009) || (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1003) || (paramInt == 1004) || (paramInt == 1005) || (paramInt == 1020) || (paramInt == 1000) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 7220) || (paramInt == 7120) || (paramInt == 7200) || (paramInt == 1008) || (paramInt == 3001) || (paramInt == 7210) || (paramInt == 7230) || (paramInt == 7) || (paramInt == 6000) || (paramInt == 6003) || (paramInt == 7000);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "newMsgNotificationEnabled: invoked. ", " systemNotificationEnabled: ", Boolean.valueOf(bool2) });
    }
    if ((a(paramInt)) || (a(paramString))) {
      bool1 = a();
    }
    return bool1;
  }
  
  private static boolean a(String paramString)
  {
    return ajsd.M.equals(paramString);
  }
  
  private Bitmap b(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QLog.e("NewMsgNotificationManager", 1, new Object[] { "getBitmapFromUrl: failed. can't run in ui thread. ", paramString });
      return null;
    }
    String str = ayoi.d(paramString);
    Object localObject = new File(str);
    long l1 = SystemClock.uptimeMillis();
    localObject = new bbwu(paramString, (File)localObject);
    ((bbwu)localObject).n = true;
    ((bbwu)localObject).b = 2;
    ((bbwu)localObject).a = str;
    ((bbwu)localObject).b(512);
    int i = bbww.a((bbwu)localObject, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("NewMsgNotificationManager", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((bbwu)localObject).a + " iconUrl: " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
    return SafeBitmapFactory.decodeFile(str);
  }
  
  private void b(BaseActivity paramBaseActivity)
  {
    Intent localIntent = bbfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  public Bitmap a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return paramBitmap;
      if ("2".equals(paramString1)) {
        return b(paramString2);
      }
    } while (!"1".equals(paramString1));
    return a(paramString2);
  }
  
  public CompoundButton.OnCheckedChangeListener a(NotifyPushSettingActivity paramNotifyPushSettingActivity, FormSwitchItem paramFormSwitchItem, FormSimpleItem paramFormSimpleItem)
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asin(this, paramNotifyPushSettingActivity, paramFormSwitchItem);
    return this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = null;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    asip localasip = new asip(this);
    asiq localasiq = new asiq(this, paramBaseActivity);
    bbdj.a(paramBaseActivity, 230, null, paramBaseActivity.getString(2131693699), paramBaseActivity.getString(2131690596), paramBaseActivity.getString(2131693698), localasiq, localasip).show();
  }
  
  public void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
    int i = paramTextView.getCurrentTextColor();
    String str = ((Resources)localObject).getString(2131695292);
    localObject = new SpannableString(str + "允许QQ通知" + ((Resources)localObject).getString(2131695293));
    ((SpannableString)localObject).setSpan(new asio(this, paramBaseActivity), str.length(), (str + "允许QQ通知").length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    paramTextView.setClickable(true);
    paramTextView.setTextColor(i);
  }
  
  public void a(FormSwitchItem paramFormSwitchItem1, TextView paramTextView, FormSwitchItem paramFormSwitchItem2)
  {
    int i = 0;
    boolean bool1 = b();
    if (bool1 != this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. ", " curSystemState[系统设置发生了变化]: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      this.jdField_a_of_type_Boolean = bool1;
      SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "system_notification_enabled_key", bool1);
      paramFormSwitchItem1 = paramFormSwitchItem1.a();
      paramFormSwitchItem2 = paramFormSwitchItem2.a();
      if (bool1) {
        break label201;
      }
      paramFormSwitchItem1.setAlpha(0.5F);
      paramFormSwitchItem2.setAlpha(0.5F);
    }
    for (;;)
    {
      if (bool1) {
        i = 8;
      }
      paramTextView.setVisibility(i);
      return;
      boolean bool2 = a();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. [系统设置未变化]", " curSystemState: ", Boolean.valueOf(bool1), " globalSwitchOn: ", Boolean.valueOf(bool2) });
      break;
      label201:
      paramFormSwitchItem1.setAlpha(1.0F);
      paramFormSwitchItem2.setAlpha(1.0F);
    }
  }
  
  public boolean a()
  {
    boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "new_msg_notification_key", true);
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    return a(paramMessage.istroop, paramMessage.frienduin);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return true;
    }
    return a(paramMessageRecord.istroop, paramMessageRecord.frienduin);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "needDecodeIcon: invoked. ", " iconType: ", paramString1, " iconUrl: ", paramString2 });
    }
    return (("1".equals(paramString1)) || ("2".equals(paramString1))) && (!TextUtils.isEmpty(paramString2));
  }
  
  public boolean b()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asim
 * JD-Core Version:    0.7.0.1
 */