package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.LBSDetetor;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.LBSDetetor.LBSTemplateListener;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  private static LbsFilterStatusManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager;
  private int jdField_a_of_type_Int = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<LbsFilterStatusManager.LbsRequestStatus> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private LbsFilterStatusManager.LbsUpdateFilter jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter;
  private PtvTemplateInfo jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new LbsFilterStatusManager.3(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  private LbsFilterStatusManager(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
      this.jdField_a_of_type_AndroidOsHandler = ThreadManager.getUIHandlerV2();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, LbsFilterStatusManager.LbsRequestStatus.a());
      AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
    }
    throw new RuntimeException("new LbsFilterStatusManager app==null");
  }
  
  public static LbsFilterStatusManager a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager == null)
      {
        jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager = new LbsFilterStatusManager(paramAppInterface);
        LBSDetetor.a(paramAppInterface).a(jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager);
      }
      paramAppInterface = jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager;
      return paramAppInterface;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "LBS_FILTER_UNINIT_KIND";
        }
        return "LBS_FILTER_SPECIAL_KIND";
      }
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_LOADING_KIND";
  }
  
  private void a()
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.g);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { ((PtvTemplateInfo)localObject).a(((PtvTemplateInfo)localObject).g) }), null);
    if (localLbsRequestStatus != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localLbsRequestStatus.a() }), null);
      if (localLbsRequestStatus.jdField_a_of_type_Int == 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(localLbsRequestStatus.jdField_a_of_type_Long);
        a("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
        if (localLbsRequestStatus.jdField_a_of_type_Long > 0L)
        {
          long l = System.currentTimeMillis() - localLbsRequestStatus.jdField_a_of_type_Long;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(l);
          a("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
          if (l < 30000L)
          {
            bool = false;
            break label231;
          }
        }
        boolean bool = true;
        label231:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(bool);
        a("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
        if (bool)
        {
          localLbsRequestStatus.c();
          localLbsRequestStatus.b();
          localLbsRequestStatus.jdField_a_of_type_Int = 1;
          localLbsRequestStatus.jdField_a_of_type_Long = System.currentTimeMillis();
          LBSDetetor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.g);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.e, localObject }), null);
    if ((this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.b) && (a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.g)) && (this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.g == paramInt))
    {
      boolean bool = b(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(bool);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter != null) && (bool))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshed filterName=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.e);
        a("sendLoadingFilterMsg", ((StringBuilder)localObject).toString(), null);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter.a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.e);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        QLog.i("LbsFilterStatusManager", 2, localStringBuilder.toString(), paramThrowable);
        return;
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append(paramString1);
      paramThrowable.append("_");
      paramThrowable.append(paramString2);
      QLog.i("LbsFilterStatusManager", 2, paramThrowable.toString());
    }
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null;
  }
  
  private void b()
  {
    PtvTemplateInfo localPtvTemplateInfo = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    if (localPtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { localPtvTemplateInfo.a(localPtvTemplateInfo.g) }), null);
      if (!this.b) {
        a();
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a(paramInt) }), null);
      if (localLbsRequestStatus.jdField_a_of_type_Int != 3)
      {
        localLbsRequestStatus.jdField_a_of_type_Boolean = paramBoolean;
        if (paramBoolean)
        {
          localLbsRequestStatus.jdField_a_of_type_Int = 2;
          return;
        }
        localLbsRequestStatus.jdField_a_of_type_Int = 3;
        a(paramInt);
        return;
      }
      a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localLbsRequestStatus.a() }), null);
      localLbsRequestStatus.jdField_a_of_type_Boolean = paramBoolean;
      localLbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.clear();
      localLbsRequestStatus.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.clear();
      a(paramInt);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLbsRequestStatus != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean);
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a(paramInt) }), null);
      if (localLbsRequestStatus.jdField_a_of_type_Int != 3)
      {
        if (paramBoolean)
        {
          localLbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
          a("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        localLbsRequestStatus.jdField_a_of_type_Int = 3;
        a(paramInt);
        return;
      }
      a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localLbsRequestStatus.a() }), null);
    }
  }
  
  private boolean b(int paramInt)
  {
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localLbsRequestStatus.jdField_a_of_type_Boolean) && (localLbsRequestStatus.a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a))) {
      paramInt = 3;
    } else {
      paramInt = 2;
    }
    a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.jdField_a_of_type_Int) }), null);
    return paramInt != this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */