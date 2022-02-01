package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.open.appmanage.AppManageInfoStorage;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerHelper;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ArkAioContainerWrapper
  extends ArkAppContainer
{
  private static final Set<WeakReference<ArkAioContainerWrapper>> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public WeakReference<MessageForArkApp> a;
  public boolean a;
  protected WeakReference<ArkAioContainerWrapper> b = new WeakReference(this);
  private boolean c = false;
  private WeakReference<ArkBabyqCardInfo> e;
  private WeakReference<RecommendCommonMessage> f;
  private WeakReference<RecommendCommonMessage.ArkMsgAppInfo> g;
  
  public ArkAioContainerWrapper()
  {
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilSet.add(this.b);
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.a(this.b);
  }
  
  public static MessageForArkApp a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (ArkAioContainerWrapper)((WeakReference)localObject).get();
          if (localObject != null)
          {
            localObject = ((ArkAioContainerWrapper)localObject).jdField_a_of_type_JavaLangRefWeakReference;
            if (localObject != null)
            {
              MessageForArkApp localMessageForArkApp = (MessageForArkApp)((WeakReference)localObject).get();
              if (localMessageForArkApp != null) {
                if ((paramString.equals(localMessageForArkApp.getExtInfoFromExtStr("pa_msgId"))) || (paramString.equals(String.valueOf(localMessageForArkApp.uniseq))))
                {
                  paramString = (MessageForArkApp)((WeakReference)localObject).get();
                  return paramString;
                }
              }
            }
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEvent type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 0) {
      ArkSilkAudioPlayerHelper.a();
    }
    if (paramInt == 2)
    {
      ArkAppContainerMRUUpdater.a();
      ArkAppContainerMRUUpdater.a();
    }
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
        {
          localObject2 = (ArkAioContainerWrapper)((WeakReference)localObject2).get();
          ((ArkAioContainerWrapper)localObject2).doOnEvent(paramInt);
          if (paramInt == 2) {
            b((ArkAioContainerWrapper)localObject2);
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
        jdField_a_of_type_JavaUtilSet.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void a(ArkAioContainerWrapper paramArkAioContainerWrapper)
  {
    if (paramArkAioContainerWrapper == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      jdField_a_of_type_JavaUtilSet.remove(paramArkAioContainerWrapper.b);
      return;
    }
  }
  
  public static void b(ArkAioContainerWrapper paramArkAioContainerWrapper)
  {
    WeakReference localWeakReference = paramArkAioContainerWrapper.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((MessageForArkApp)localWeakReference.get()).arkContainer = null;
    }
    localWeakReference = paramArkAioContainerWrapper.f;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((RecommendCommonMessage)localWeakReference.get()).mOldAppInfo.mArkContainer = null;
    }
    localWeakReference = paramArkAioContainerWrapper.g;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((RecommendCommonMessage.ArkMsgAppInfo)localWeakReference.get()).mArkContainer = null;
    }
    paramArkAioContainerWrapper = paramArkAioContainerWrapper.e;
    if ((paramArkAioContainerWrapper != null) && (paramArkAioContainerWrapper.get() != null)) {
      ((ArkBabyqCardInfo)paramArkAioContainerWrapper.get()).mArkBabyqContainer = null;
    }
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return "";
    }
    localObject = (MessageForArkApp)((WeakReference)localObject).get();
    if (localObject == null) {
      return "";
    }
    return ((MessageForArkApp)localObject).ark_app_message.config;
  }
  
  public String a(String paramString)
  {
    Object localObject2 = "";
    if (paramString == null) {
      return "";
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      return paramString;
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)((WeakReference)localObject1).get();
    localObject1 = paramString;
    if (localMessageForArkApp != null)
    {
      if (localMessageForArkApp.ark_app_message == null) {
        return paramString;
      }
      String str = localMessageForArkApp.ark_app_message.appName;
      localObject1 = AppManageInfoStorage.loadAppDesc(str);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (Utility.isValidAppName(str)) {
          localObject2 = str;
        }
      }
      else {
        localObject2 = localObject1;
      }
      localObject1 = paramString;
      if (localMessageForArkApp.ark_app_message.appDesc != null) {
        localObject1 = paramString.replace("%APP_DESC%", (CharSequence)localObject2).replace("$APP_DESC$", (CharSequence)localObject2);
      }
      paramString = (String)localObject1;
      if (localMessageForArkApp.ark_app_message.appName != null) {
        paramString = ((String)localObject1).replace("%APP_NAME%", str).replace("$APP_NAME$", str);
      }
      localObject1 = paramString;
      if (localMessageForArkApp.ark_app_message.promptText != null) {
        localObject1 = paramString.replace("%PROMPT%", localMessageForArkApp.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkApp.ark_app_message.promptText);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, ArkBabyqCardInfo paramArkBabyqCardInfo, SessionInfo paramSessionInfo)
  {
    this.c = false;
    if (paramArkBabyqCardInfo != null) {
      this.e = new WeakReference(paramArkBabyqCardInfo);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.a(this.b);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, MessageForArkApp paramMessageForArkApp, SessionInfo paramSessionInfo)
  {
    this.c = false;
    if (paramMessageForArkApp != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForArkApp);
      a(paramSessionInfo, paramMessageForArkApp.senderuin);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.a(this.b);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, RecommendCommonMessage.ArkMsgAppInfo paramArkMsgAppInfo, SessionInfo paramSessionInfo)
  {
    if (paramArkMsgAppInfo != null) {
      this.g = new WeakReference(paramArkMsgAppInfo);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.a(this.b);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, RecommendCommonMessage paramRecommendCommonMessage, SessionInfo paramSessionInfo)
  {
    if (paramRecommendCommonMessage != null)
    {
      this.f = new WeakReference(paramRecommendCommonMessage);
      a(paramSessionInfo, paramRecommendCommonMessage.senderuin);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.a(this.b);
    return true;
  }
  
  public void activateView(boolean paramBoolean)
  {
    boolean bool = this.mIsActivated;
    super.activateView(paramBoolean);
    if (bool == this.mIsActivated) {
      return;
    }
    if (this.mIsActivated)
    {
      ArkAppContainerMRUUpdater.a();
      ArkAppContainerMRUUpdater.a(this.b);
      return;
    }
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.b(this.b);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.c) {
      super.doOnEvent(2);
    }
  }
  
  protected void destroy()
  {
    super.destroy();
    ArkAppContainerMRUUpdater.a();
    ArkAppContainerMRUUpdater.c(this.b);
  }
  
  public void doOnEvent(int paramInt)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_Boolean))
    {
      this.c = true;
      return;
    }
    super.doOnEvent(paramInt);
  }
  
  public String getViewId()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return null;
    }
    localObject = (MessageForArkApp)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    String str = ((MessageForArkApp)localObject).getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(((MessageForArkApp)localObject).uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper
 * JD-Core Version:    0.7.0.1
 */