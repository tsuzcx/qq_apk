package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ArkFlashChatContainerWrapper
  extends ArkAppContainer
{
  private static final List<WeakReference<ArkFlashChatContainerWrapper>> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private static final List<WeakReference<ArkFlashChatContainerWrapper>> jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new ArkFlashChatContainerWrapper.2(this);
  public WeakReference<QQAppInterface> a;
  public boolean a;
  public int b;
  private WeakReference<MessageForArkFlashChat> jdField_b_of_type_JavaLangRefWeakReference;
  
  public ArkFlashChatContainerWrapper()
  {
    this(true);
  }
  
  public ArkFlashChatContainerWrapper(boolean paramBoolean)
  {
    super(false);
    this.jdField_a_of_type_Boolean = false;
    if (paramBoolean) {
      jdField_a_of_type_JavaUtilList.add(new WeakReference(this));
    } else {
      jdField_b_of_type_JavaUtilList.add(new WeakReference(this));
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEventAIO type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    a(paramInt, jdField_a_of_type_JavaUtilList);
  }
  
  public static void a(int paramInt, List<WeakReference<ArkFlashChatContainerWrapper>> paramList)
  {
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
        {
          localObject2 = (ArkFlashChatContainerWrapper)((WeakReference)localObject2).get();
          ((ArkFlashChatContainerWrapper)localObject2).doOnEvent(paramInt);
          if (paramInt == 2)
          {
            localObject2 = ((ArkFlashChatContainerWrapper)localObject2).jdField_b_of_type_JavaLangRefWeakReference;
            if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
              ((MessageForArkFlashChat)((WeakReference)localObject2).get()).arkContainer = null;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAioContainerWrapper", 4, "doArkAppEvent.(item == null || item.get() == null)");
          }
          localIterator.remove();
        }
      }
      if (paramInt == 2) {
        paramList.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public String a()
  {
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return "";
    }
    localObject = (MessageForArkFlashChat)((WeakReference)localObject).get();
    if (localObject == null) {
      return "";
    }
    return ((MessageForArkFlashChat)localObject).ark_app_message.config;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return paramString;
    }
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((WeakReference)localObject).get();
    localObject = paramString;
    if (localMessageForArkFlashChat != null)
    {
      if (localMessageForArkFlashChat.ark_app_message == null) {
        return paramString;
      }
      localObject = paramString;
      if (localMessageForArkFlashChat.ark_app_message.appDesc != null) {
        localObject = paramString.replace("%APP_DESC%", localMessageForArkFlashChat.ark_app_message.appDesc).replace("$APP_DESC$", localMessageForArkFlashChat.ark_app_message.appDesc);
      }
      paramString = (String)localObject;
      if (localMessageForArkFlashChat.ark_app_message.appName != null) {
        paramString = ((String)localObject).replace("%APP_NAME%", localMessageForArkFlashChat.ark_app_message.appName).replace("$APP_NAME$", localMessageForArkFlashChat.ark_app_message.appName);
      }
      localObject = paramString;
      if (localMessageForArkFlashChat.ark_app_message.promptText != null) {
        localObject = paramString.replace("%PROMPT%", localMessageForArkFlashChat.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkFlashChat.ark_app_message.promptText);
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.mInit = false;
    this.mLoadFailed = false;
  }
  
  public boolean a()
  {
    return this.mLoadFailed;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, float paramFloat1, SessionInfo paramSessionInfo, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkFlashChat != null) {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForArkFlashChat);
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
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return null;
    }
    localObject = (MessageForArkFlashChat)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    String str = ((MessageForArkFlashChat)localObject).getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(((MessageForArkFlashChat)localObject).uniseq);
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
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.beginOfGetApp = System.currentTimeMillis();
    FlashChatManager localFlashChatManager = (FlashChatManager)paramAppInfo.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    String str = localFlashChatManager.a(this.jdField_b_of_type_Int, this.mAppInfo.name, this.mAppInfo.appMinVersion);
    if (str != null)
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkFlashChatContainerWrapper.1(this, str));
      return true;
    }
    if (this.mViewImpl != null) {
      this.mViewImpl.onLoading();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, String.format("request from url", new Object[] { this }));
    }
    paramAppInfo.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    localFlashChatManager.a(this.jdField_b_of_type_Int);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.mContainer == null) {
      return false;
    }
    if (this.mContainer == null) {
      return false;
    }
    float f = this.mAppInfo.scale;
    ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkFlashChatContainerWrapper.TouchRunnable(this, paramMotionEvent, this.mContainer, f));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper
 * JD-Core Version:    0.7.0.1
 */