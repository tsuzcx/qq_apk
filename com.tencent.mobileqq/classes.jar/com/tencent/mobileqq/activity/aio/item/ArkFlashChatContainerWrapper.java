package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import urz;

public class ArkFlashChatContainerWrapper
  extends ArkAppContainer
{
  private static final List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new urz(this);
  public WeakReference a;
  private WeakReference b;
  public int c;
  private WeakReference e;
  
  public ArkFlashChatContainerWrapper()
  {
    jdField_a_of_type_JavaUtilList.add(new WeakReference(this));
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEvent type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 == null) || (((WeakReference)localObject2).get() == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAioContainerWrapper", 4, "doArkAppEvent.(item == null || item.get() == null)");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (ArkFlashChatContainerWrapper)((WeakReference)localObject2).get();
      ((ArkFlashChatContainerWrapper)localObject2).doOnEvent(paramInt);
      if (paramInt == 2)
      {
        WeakReference localWeakReference = ((ArkFlashChatContainerWrapper)localObject2).b;
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((MessageForArkFlashChat)localWeakReference.get()).arkContainer = null;
        }
        localObject2 = ((ArkFlashChatContainerWrapper)localObject2).e;
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
          ((RecommendCommonMessage)((WeakReference)localObject2).get()).mOldAppInfo.mArkContainer = null;
        }
      }
    }
    if (paramInt == 2) {
      jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public String a()
  {
    if (this.b == null) {
      return "";
    }
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)this.b.get();
    if (localMessageForArkFlashChat == null) {
      return "";
    }
    return localMessageForArkFlashChat.ark_app_message.config;
  }
  
  public String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    MessageForArkFlashChat localMessageForArkFlashChat;
    do
    {
      do
      {
        do
        {
          do
          {
            return str;
            str = paramString;
          } while (this.b == null);
          localMessageForArkFlashChat = (MessageForArkFlashChat)this.b.get();
          str = paramString;
        } while (localMessageForArkFlashChat == null);
        str = paramString;
      } while (localMessageForArkFlashChat.ark_app_message == null);
      str = paramString;
      if (localMessageForArkFlashChat.ark_app_message.appDesc != null) {
        str = paramString.replace("%APP_DESC%", localMessageForArkFlashChat.ark_app_message.appDesc).replace("$APP_DESC$", localMessageForArkFlashChat.ark_app_message.appDesc);
      }
      paramString = str;
      if (localMessageForArkFlashChat.ark_app_message.appName != null) {
        paramString = str.replace("%APP_NAME%", localMessageForArkFlashChat.ark_app_message.appName).replace("$APP_NAME$", localMessageForArkFlashChat.ark_app_message.appName);
      }
      str = paramString;
    } while (localMessageForArkFlashChat.ark_app_message.promptText == null);
    return paramString.replace("%PROMPT%", localMessageForArkFlashChat.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkFlashChat.ark_app_message.promptText);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, float paramFloat1, SessionInfo paramSessionInfo, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    this.c = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkFlashChat != null) {
      this.b = new WeakReference(paramMessageForArkFlashChat);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat1, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    setFixSize((int)paramFloat2, (int)paramFloat3);
    setMaxSize((int)paramFloat4, (int)paramFloat5);
    return true;
  }
  
  public String getViewId()
  {
    if (this.b == null) {
      return null;
    }
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)this.b.get();
    if (localMessageForArkFlashChat == null) {
      return null;
    }
    String str = localMessageForArkFlashChat.getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(localMessageForArkFlashChat.uniseq);
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    paramAppInfo = a();
    if (paramAppInfo == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      if (this.mViewImpl != null) {
        this.mViewImpl.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord.jdField_a_of_type_Long = System.currentTimeMillis();
    FlashChatManager localFlashChatManager = (FlashChatManager)paramAppInfo.getManager(216);
    String str = localFlashChatManager.a(this.c, this.mAppInfo.name, this.mAppInfo.appMinVersion);
    if (str != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord.b = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("FlashChat", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
      }
      if (this.mViewImpl != null) {
        this.mViewImpl.onLoading();
      }
      a(str, 0, null);
      return true;
    }
    if (this.mViewImpl != null) {
      this.mViewImpl.onLoading();
    }
    paramAppInfo.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    localFlashChatManager.a(this.c);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mContainer == null) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 1) || (i == 3))
    {
      Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        localObject = (FlashChatManager)((QQAppInterface)localObject).getManager(216);
        ((FlashChatManager)localObject).a(null);
        if (this.b != null)
        {
          MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)this.b.get();
          if (localMessageForArkFlashChat != null) {
            ((FlashChatManager)localObject).b(localMessageForArkFlashChat);
          }
        }
      }
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper
 * JD-Core Version:    0.7.0.1
 */