package com.tencent.mobileqq.activity.richmedia.view;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSTemplateListener;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import yed;
import yee;
import yef;
import yeh;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  public static AppInterface a;
  private static LbsFilterStatusManager jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager;
  private int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private LbsFilterStatusManager.LbsUpdateFilter jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new yef(this);
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  private boolean jdField_a_of_type_Boolean = true;
  private AppInterface jdField_b_of_type_ComTencentCommonAppAppInterface;
  private boolean jdField_b_of_type_Boolean;
  
  private LbsFilterStatusManager(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      throw new RuntimeException("new LbsFilterStatusManager app==null");
    }
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, yeh.a());
    this.jdField_a_of_type_Long = Thread.currentThread().getId();
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static long a()
  {
    return -1L;
  }
  
  public static LbsFilterStatusManager a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager == null)
      {
        AppInterface localAppInterface = paramAppInterface;
        if (paramAppInterface == null) {
          localAppInterface = jdField_a_of_type_ComTencentCommonAppAppInterface;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager = new LbsFilterStatusManager(localAppInterface);
        LBSDetetor.a(localAppInterface).a(jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager);
      }
      paramAppInterface = jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager;
      return paramAppInterface;
    }
    finally {}
  }
  
  public static String a()
  {
    return "打开地理位置，体验更多惊喜";
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "LBS_FILTER_UNINIT_KIND";
    case 1: 
      return "LBS_FILTER_LOADING_KIND";
    case 2: 
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_SPECIAL_KIND";
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    String str2 = "paramsspecial";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (new File(paramString, "paramsspecialback.json").exists()) {
        str1 = "paramsspecialback";
      }
    }
    if (new File(paramString, str1 + ".json").exists())
    {
      a("", "0X8008136");
      this.jdField_a_of_type_Int = 3;
      return str1;
    }
    a("getLbsParamsFileName", String.format("LBS_FILTER_SPECIAL not eixst", new Object[0]), null);
    return null;
  }
  
  private void a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, str }), null);
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType == paramInt))
    {
      boolean bool = b(paramInt);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { "" + bool }), null);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter != null) && (bool))
      {
        a("sendLoadingFilterMsg", "refreshed filterName=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface).a(paramString);
  }
  
  private void a(String paramString)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(i);
    a("reportLbsSendData", String.format("[%s-%s]acitvityName=%s,White[%s]", new Object[] { paramString, str1, str2, "" + this.jdField_a_of_type_Boolean }), null);
    if ((paramString == null) || (str1.equals(paramString)))
    {
      if ((yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null)
      {
        if (this.jdField_a_of_type_Int != 2) {
          break label121;
        }
        a("", "0X8008139");
      }
      label121:
      while (this.jdField_a_of_type_Int != 3) {
        return;
      }
      a("", "0X8008137");
      return;
    }
    a("reportLbsSendData", String.format("filterName=%s,currentName=%s [%s]", new Object[] { paramString, str1, str2 }), null);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      FlowCameraMqqAction.b(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2);
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    yeh localyeh = (yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyeh != null)
    {
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localyeh.jdField_a_of_type_Int == 3) {
        break label99;
      }
      localyeh.jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        localyeh.jdField_a_of_type_Int = 2;
      }
    }
    else
    {
      return;
    }
    localyeh.jdField_a_of_type_Int = 3;
    a(paramInt);
    return;
    label99:
    a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localyeh.a() }), null);
    localyeh.jdField_a_of_type_Boolean = paramBoolean;
    localyeh.jdField_a_of_type_JavaUtilArrayList.clear();
    localyeh.jdField_a_of_type_Yeh.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramInt);
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    yeh localyeh = (yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyeh != null)
    {
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localyeh.jdField_a_of_type_Int != 3)
      {
        if (paramBoolean)
        {
          localyeh.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
          a("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        localyeh.jdField_a_of_type_Int = 3;
        a(paramInt);
      }
    }
    else
    {
      return;
    }
    a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localyeh.a() }), null);
  }
  
  private boolean b(int paramInt)
  {
    yeh localyeh = (yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localyeh.jdField_a_of_type_Boolean) && (localyeh.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {}
    for (paramInt = 3;; paramInt = 2)
    {
      a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.jdField_a_of_type_Int) }), null);
      if (paramInt == this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void c()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager != null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager.e();
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager = null;
      }
      LBSDetetor.a();
      return;
    }
    finally {}
  }
  
  private void d()
  {
    yeh localyeh = (yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
    if ((localyeh == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localyeh.a() }), null);
    } while (localyeh.jdField_a_of_type_Int != 3);
    a("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { "" + localyeh.jdField_a_of_type_Long }), null);
    if (localyeh.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - localyeh.jdField_a_of_type_Long;
      a("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { "" + l }), null);
      if (l >= 30000L) {}
    }
    for (boolean bool = false;; bool = true)
    {
      a("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { "" + bool }), null);
      if (!bool) {
        break;
      }
      localyeh.c();
      localyeh.b();
      localyeh.jdField_a_of_type_Int = 1;
      localyeh.jdField_a_of_type_Long = System.currentTimeMillis();
      LBSDetetor.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_Boolean = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
      if (!this.jdField_b_of_type_Boolean) {
        d();
      }
    }
  }
  
  public String a(String paramString, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int j = 1;
    a("getLbsParamsFileName", "filerPath=" + paramString, null);
    paramArrayOfBoolean[0] = false;
    this.jdField_a_of_type_Int = 0;
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i != -1) {}
    for (Object localObject = paramString.substring(i + 1);; localObject = null)
    {
      a("getLbsParamsFileName", String.format("index=%s,name=%s", new Object[] { "" + i, "" + (String)localObject }), null);
      if ((localObject == null) || ("".equals(localObject))) {
        break;
      }
      if (Thread.currentThread().getId() != this.jdField_a_of_type_Long) {
        throw new RuntimeException("getLbsParamsFileName must called in main thread");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name.equals(localObject)))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {
          throw new RuntimeException(String.format("filterName=%s , usable=false", new Object[] { localObject }));
        }
        i = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType;
        a("getLbsParamsFileName", String.format("[%s]acitvityName=%s,White[%s]", new Object[] { localObject, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(i), "" + this.jdField_a_of_type_Boolean }), null);
        localObject = (yeh)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject == null) {
          break;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          a("getLbsParamsFileName", String.format("mRequestStatus=%s", new Object[] { "" + ((yeh)localObject).jdField_a_of_type_Int }), null);
          a("getLbsParamsFileName", String.format("mHaveLocationPermission=%s", new Object[] { "" + ((yeh)localObject).jdField_a_of_type_Boolean }), null);
          a("getLbsParamsFileName", String.format("mLocateInLbsRegion=%s", new Object[] { "" + ((yeh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id) }), null);
          if (((yeh)localObject).jdField_a_of_type_Int == 3)
          {
            if (!((yeh)localObject).jdField_a_of_type_Boolean) {}
            for (;;)
            {
              paramArrayOfBoolean[0] = j;
              if ((!((yeh)localObject).jdField_a_of_type_Boolean) || (!((yeh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {
                break;
              }
              paramArrayOfBoolean = a(paramString, paramBoolean);
              if (paramArrayOfBoolean == null) {
                break;
              }
              return paramArrayOfBoolean;
              j = 0;
            }
          }
          a("getLbsParamsFileName", String.format("[cache]mRequestStatus=%s", new Object[] { "" + ((yeh)localObject).jdField_a_of_type_Yeh.jdField_a_of_type_Int }), null);
          a("getLbsParamsFileName", String.format("[cache]mHaveLocationPermission=%s", new Object[] { "" + ((yeh)localObject).jdField_a_of_type_Yeh.jdField_a_of_type_Boolean }), null);
          if ((((yeh)localObject).jdField_a_of_type_Yeh.jdField_a_of_type_Int == 3) && (((yeh)localObject).jdField_a_of_type_Yeh.jdField_a_of_type_Boolean))
          {
            a("getLbsParamsFileName", String.format("[cache]mLocateInLbsRegion=%s", new Object[] { "" + ((yeh)localObject).jdField_a_of_type_Yeh.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id) }), null);
            if (((yeh)localObject).jdField_a_of_type_Yeh.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))
            {
              paramArrayOfBoolean = a(paramString, paramBoolean);
              if (paramArrayOfBoolean != null) {
                return paramArrayOfBoolean;
              }
            }
          }
          else
          {
            a("getLbsParamsFileName", String.format("LBS_FILTER_LOADING status...", new Object[0]), null);
            if (new File(paramString, "paramsloading.json").exists())
            {
              this.jdField_a_of_type_Int = 1;
              return "paramsloading";
            }
            a("getLbsParamsFileName", String.format("LBS_FILTER_LOADING not eixst", new Object[0]), null);
          }
        }
        a("getLbsParamsFileName", String.format("LBS_FILTER_NOMAL status...", new Object[0]), null);
        localObject = "params";
        paramArrayOfBoolean = (boolean[])localObject;
        if (paramBoolean)
        {
          paramArrayOfBoolean = (boolean[])localObject;
          if (new File(paramString, "paramsback.json").exists()) {
            paramArrayOfBoolean = "paramsback";
          }
        }
        a("", "0X8008138");
        this.jdField_a_of_type_Int = 2;
        return paramArrayOfBoolean;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) {}
      for (paramString = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;; paramString = "null")
      {
        a("getLbsParamsFileName", String.format("[name error]filterName=%s,mCurrentFilterInfo.name=%s", new Object[] { localObject, paramString }), null);
        return null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)
    {
      a("refreshLocateInfoFromBack", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        d();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new yed(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new yee(this, paramInt, paramBoolean, paramArrayList));
  }
  
  public void a(LbsFilterStatusManager.LbsUpdateFilter paramLbsUpdateFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter = paramLbsUpdateFilter;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    a("startLocation", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
    d();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */