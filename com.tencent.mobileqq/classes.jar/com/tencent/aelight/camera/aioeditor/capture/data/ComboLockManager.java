package com.tencent.aelight.camera.aioeditor.capture.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ComboLockManager
  implements IEventReceiver
{
  public static final String a;
  int jdField_a_of_type_Int = -1;
  VideoFilterTools.ComboFilterData jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
  ComboLockManager.StoryVideoPublishStatusReceiver jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver;
  LockedCategory jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataLockedCategory;
  public QIMFilterCategoryItem a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ComboLockManager.3(this);
  HashMap<String, LockedCategory> jdField_a_of_type_JavaUtilHashMap;
  volatile boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/tencent/qim/share/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public ComboLockManager()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver = new ComboLockManager.StoryVideoPublishStatusReceiver(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "registerStoryReceiver");
      }
      StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver);
    }
  }
  
  public LockedCategory a(String paramString)
  {
    return (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver = new ComboLockManager.StoryVideoPublishStatusReceiver(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "unregisterStoryReceiver");
      }
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData == paramComboFilterData)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "same data");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateConfigData isfrist ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" sendStory ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateConfigData first card.snedSrory ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.i("ComboLockManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap = paramComboFilterData.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData = paramComboFilterData;
    paramComboFilterData = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (paramComboFilterData.hasNext())
    {
      localObject = (String)paramComboFilterData.next();
      localObject = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      ((LockedCategory)localObject).jdField_a_of_type_Boolean = a(((LockedCategory)localObject).jdField_a_of_type_JavaLangString);
      if ((((LockedCategory)localObject).jdField_a_of_type_Boolean) && (((LockedCategory)localObject).jdField_a_of_type_Int == 2))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataLockedCategory = ((LockedCategory)localObject);
        c();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateConfigData ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" lock ");
        localStringBuilder.append(((LockedCategory)localObject).jdField_a_of_type_Boolean);
        QLog.i("ComboLockManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = (LockedCategory)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 1;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      i = -1;
    }
    else
    {
      localObject1 = (LockedCategory)((HashMap)localObject1).get(paramString);
      if (localObject1 == null) {
        i = 0;
      } else if (((LockedCategory)localObject1).jdField_a_of_type_Boolean) {
        if (((LockedCategory)localObject1).a())
        {
          i = 2;
        }
        else
        {
          if (((LockedCategory)localObject1).jdField_a_of_type_Int == 2)
          {
            if (this.jdField_a_of_type_Boolean)
            {
              localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem;
              bool1 = bool2;
              if (localObject2 != null)
              {
                bool1 = bool2;
                if (!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)) {}
              }
            }
            else
            {
              bool1 = true;
            }
          }
          else
          {
            bool1 = bool2;
            if (((LockedCategory)localObject1).jdField_a_of_type_Int == 1)
            {
              if (!((LockedCategory)localObject1).jdField_b_of_type_Boolean)
              {
                ((LockedCategory)localObject1).jdField_a_of_type_Boolean = SharedPreUtils.t(BaseApplicationImpl.getApplication(), paramString);
                ((LockedCategory)localObject1).jdField_b_of_type_Boolean = true;
              }
              bool1 = ((LockedCategory)localObject1).jdField_a_of_type_Boolean;
            }
          }
          i = 3;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("is locke ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" code");
      ((StringBuilder)localObject2).append(i);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject2).toString());
      if (i == 3)
      {
        paramString = new StringBuilder();
        paramString.append("islock result");
        paramString.append(bool1);
        paramString.append(" type ");
        paramString.append(((LockedCategory)localObject1).jdField_a_of_type_Int);
        paramString.append(" mHaveSendStory ");
        paramString.append(this.jdField_a_of_type_Boolean);
        QLog.i("ComboLockManager", 2, paramString.toString());
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, Context paramContext)
  {
    boolean bool2 = a(paramString);
    boolean bool1 = true;
    if (bool2)
    {
      Object localObject2 = a(paramString).jdField_b_of_type_JavaLangString;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ComboLockManager", 1, "empty jump url");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://ti.qq.com/unlocked/index.html?_wv=536870912&id=");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("k_f_id", paramString);
      paramContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("handleLockItemClick id ");
        paramContext.append(paramString);
        QLog.i("ComboLockManager", 2, paramContext.toString());
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "handleSendStory");
    }
    this.jdField_a_of_type_Boolean = true;
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager$StoryVideoPublishStatusReceiver);
    Object localObject = (CardHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataLockedCategory != null)
    {
      localObject = BaseApplicationImpl.getContext();
      ComboLockManager.1 local1 = new ComboLockManager.1(this, (Context)localObject);
      ThreadManager.getUIHandler().postDelayed(new ComboLockManager.2(this, (Context)localObject, local1), 1000L);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData.a(this.jdField_a_of_type_Int).a;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        Object localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if (((FilterCategory)localObject2).a != null)
        {
          localObject2 = ((FilterCategory)localObject2).a.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!paramString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)) {
              break;
            }
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem = localQIMFilterCategoryItem;
          }
        }
      }
    }
    label101:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLockingItem ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" result ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager
 * JD-Core Version:    0.7.0.1
 */