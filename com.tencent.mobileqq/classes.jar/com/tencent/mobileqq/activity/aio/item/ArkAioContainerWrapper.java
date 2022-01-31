package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
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
  private static final Set a;
  public WeakReference a;
  public boolean a;
  protected WeakReference b = new WeakReference(this);
  private WeakReference jdField_e_of_type_JavaLangRefWeakReference;
  private boolean jdField_e_of_type_Boolean;
  private WeakReference f;
  private WeakReference g;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  }
  
  public ArkAioContainerWrapper()
  {
    jdField_a_of_type_JavaUtilSet.add(this.b);
  }
  
  public static MessageForArkApp a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      Object localObject;
      label42:
      MessageForArkApp localMessageForArkApp;
      do
      {
        if (localIterator.hasNext())
        {
          localObject = (WeakReference)localIterator.next();
          if (localObject != null) {
            break label42;
          }
        }
        do
        {
          do
          {
            do
            {
              return null;
              localObject = (ArkAioContainerWrapper)((WeakReference)localObject).get();
            } while (localObject == null);
            localObject = ((ArkAioContainerWrapper)localObject).jdField_a_of_type_JavaLangRefWeakReference;
          } while (localObject == null);
          localMessageForArkApp = (MessageForArkApp)((WeakReference)localObject).get();
        } while (localMessageForArkApp == null);
      } while ((!paramString.equals(localMessageForArkApp.getExtInfoFromExtStr("pa_msgId"))) && (!paramString.equals(String.valueOf(localMessageForArkApp.uniseq))));
      paramString = (MessageForArkApp)((WeakReference)localObject).get();
      return paramString;
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEvent type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
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
      Object localObject2 = (ArkAioContainerWrapper)((WeakReference)localObject2).get();
      ((ArkAioContainerWrapper)localObject2).doOnEvent(paramInt);
      if (paramInt == 2)
      {
        WeakReference localWeakReference = ((ArkAioContainerWrapper)localObject2).jdField_a_of_type_JavaLangRefWeakReference;
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((MessageForArkApp)localWeakReference.get()).arkContainer = null;
        }
        localWeakReference = ((ArkAioContainerWrapper)localObject2).f;
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((RecommendCommonMessage)localWeakReference.get()).mOldAppInfo.mArkContainer = null;
        }
        localWeakReference = ((ArkAioContainerWrapper)localObject2).g;
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((RecommendCommonMessage.ArkMsgAppInfo)localWeakReference.get()).mArkContainer = null;
        }
        localObject2 = ((ArkAioContainerWrapper)localObject2).jdField_e_of_type_JavaLangRefWeakReference;
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
          ((ArkBabyqCardInfo)((WeakReference)localObject2).get()).mArkBabyqContainer = null;
        }
      }
    }
    if (paramInt == 2) {
      jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localMessageForArkApp == null) {
      return "";
    }
    return localMessageForArkApp.ark_app_message.config;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      localObject = "";
    }
    MessageForArkApp localMessageForArkApp;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramString;
        } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
        localMessageForArkApp = (MessageForArkApp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject = paramString;
      } while (localMessageForArkApp == null);
      localObject = paramString;
    } while (localMessageForArkApp.ark_app_message == null);
    String str2 = localMessageForArkApp.ark_app_message.appName;
    String str1 = ArkLocalAppMgr.a(str2);
    Object localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      if (!ArkLocalAppMgr.a(str2)) {
        break label180;
      }
    }
    label180:
    for (localObject = str2;; localObject = "")
    {
      str1 = paramString;
      if (localMessageForArkApp.ark_app_message.appDesc != null) {
        str1 = paramString.replace("%APP_DESC%", (CharSequence)localObject).replace("$APP_DESC$", (CharSequence)localObject);
      }
      paramString = str1;
      if (localMessageForArkApp.ark_app_message.appName != null) {
        paramString = str1.replace("%APP_NAME%", str2).replace("$APP_NAME$", str2);
      }
      localObject = paramString;
      if (localMessageForArkApp.ark_app_message.promptText == null) {
        break;
      }
      return paramString.replace("%PROMPT%", localMessageForArkApp.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkApp.ark_app_message.promptText);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, ArkBabyqCardInfo paramArkBabyqCardInfo, SessionInfo paramSessionInfo)
  {
    this.jdField_e_of_type_Boolean = false;
    if (paramArkBabyqCardInfo != null) {
      this.jdField_e_of_type_JavaLangRefWeakReference = new WeakReference(paramArkBabyqCardInfo);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    this.d = true;
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, MessageForArkApp paramMessageForArkApp, SessionInfo paramSessionInfo)
  {
    this.jdField_e_of_type_Boolean = false;
    if (paramMessageForArkApp != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForArkApp);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
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
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, RecommendCommonMessage paramRecommendCommonMessage, SessionInfo paramSessionInfo)
  {
    if (paramRecommendCommonMessage != null) {
      this.f = new WeakReference(paramRecommendCommonMessage);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    jdField_a_of_type_JavaUtilSet.add(this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_e_of_type_Boolean) {
      super.doOnEvent(2);
    }
  }
  
  protected void destroy()
  {
    super.destroy();
  }
  
  public void doOnEvent(int paramInt)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    super.doOnEvent(paramInt);
  }
  
  public String getViewId()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localMessageForArkApp == null) {
      return null;
    }
    String str = localMessageForArkApp.getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(localMessageForArkApp.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper
 * JD-Core Version:    0.7.0.1
 */