package com.tencent.mobileqq.abtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class ABTestController
{
  private static final ABTestController jdField_a_of_type_ComTencentMobileqqAbtestABTestController = new ABTestController();
  private StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  private String jdField_a_of_type_JavaLangString;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public static Drawable a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = a("exp_qq_msg_marketface_input_icon");
    Map localMap = ((ExpEntityInfo)localObject1).getParams();
    Object localObject2 = RichTextChatManager.a(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getApplicationContext().getResources().getDrawable(2130838189);
    if ((((ExpEntityInfo)localObject1).c()) && (localMap != null))
    {
      localObject1 = a(a((String)localMap.get("aio_input_shan_icon_url1"), 44, 44), a((String)localMap.get("aio_input_shan_icon_url2"), 44, 44));
      if (localObject1 == null) {
        break label130;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    }
    label130:
    for (;;)
    {
      localObject1 = paramQQAppInterface;
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramQQAppInterface;
        } while (localObject2 == null);
        localObject2 = a(a(((RichTextChatManager)localObject2).c(), 44, 44), a(((RichTextChatManager)localObject2).d(), 44, 44));
        localObject1 = paramQQAppInterface;
      } while (localObject2 == null);
      return localObject2;
    }
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable1 == null) || (paramDrawable2 == null)) {
      return null;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int i = -16843518;
    localStateListDrawable.addState(new int[] { 16843518 }, paramDrawable2);
    localStateListDrawable.addState(new int[] { i }, paramDrawable1);
    return localStateListDrawable;
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0) || (paramInt2 <= 0) || (!paramString.startsWith("https")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOUtils", 2, "getUrlDrawable params error, url:" + paramString);
      }
      paramString = null;
    }
    Object localObject;
    do
    {
      return paramString;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = false;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(7);
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      paramString = (String)localObject;
    } while (localObject == null);
    ((URLDrawable)localObject).startDownload();
    return localObject;
  }
  
  @NonNull
  public static ExpEntityInfo a(@NonNull String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqAbtestABTestController.b(paramString);
  }
  
  private GetExperimentListener a()
  {
    try
    {
      ABTestController.1 local1 = new ABTestController.1(this);
      return local1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqAbtestABTestController.b(paramBaseApplicationImpl, paramString);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ABTestController", 2, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  @NonNull
  private ExpEntityInfo b(@NonNull String paramString)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localObject = BaseApplicationImpl.getApplication();
        b((BaseApplicationImpl)localObject, ((BaseApplicationImpl)localObject).getRuntime().getAccount());
      }
      ExpEntityInfo localExpEntityInfo = ABTestConfiguration.a(paramString);
      Object localObject = localExpEntityInfo;
      if (localExpEntityInfo == null)
      {
        localObject = new ExpEntityInfo(paramString, null);
        ABTestConfiguration.a((ExpEntityInfo)localObject);
      }
      if (((ExpEntityInfo)localObject).isDefaultRomaExp()) {
        ABTestApi.getAllExperiments(a(), 3000);
      }
      return localObject;
    }
    finally {}
  }
  
  private void b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    a("ABTestController, only available in debug version.");
    if (TextUtils.isEmpty(paramString)) {}
    for (Object localObject = paramBaseApplicationImpl.getRuntime().getAccount();; localObject = paramString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = StatisticCollector.getInstance(paramBaseApplicationImpl);
      a("start initialize ABTestApi SDK, uinAccount:" + paramString);
      ABTestConfiguration.a();
      localObject = new ABTestConfig();
      ((ABTestConfig)localObject).setAppKey("0c9ebb2ded806d7ffda75cd0b95eb70c");
      ((ABTestConfig)localObject).setGuid(paramString);
      ((ABTestConfig)localObject).setEnv("RELEASE");
      ((ABTestConfig)localObject).setAppId("1505");
      ABTestApi.init(paramBaseApplicationImpl, (ABTestConfig)localObject);
      ABTestLog.setLogAble(false);
      ABTestLog.setUseFuncTag(false);
      if (!AppSetting.c()) {
        UserAction.setLogAble(false, false);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ABTestApi.switchAccountId(paramString, a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.abtest.ABTestController
 * JD-Core Version:    0.7.0.1
 */