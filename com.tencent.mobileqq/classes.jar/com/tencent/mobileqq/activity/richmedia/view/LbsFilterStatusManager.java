package com.tencent.mobileqq.activity.richmedia.view;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSTemplateListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  public static AppInterface a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<LbsFilterStatusManager.LbsRequestStatus> jdField_a_of_type_AndroidUtilSparseArray;
  private LbsFilterStatusManager.LbsUpdateFilter jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter;
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  private boolean jdField_a_of_type_Boolean;
  private AppInterface jdField_b_of_type_ComTencentCommonAppAppInterface;
  private boolean jdField_b_of_type_Boolean;
  
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
    LbsFilterStatusManager.LbsRequestStatus localLbsRequestStatus = (LbsFilterStatusManager.LbsRequestStatus)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { ((PtvTemplateManager.PtvTemplateInfo)localObject).getLbsActivityType(((PtvTemplateManager.PtvTemplateInfo)localObject).activityType) }), null);
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
          localLbsRequestStatus.b();
          localLbsRequestStatus.a();
          localLbsRequestStatus.jdField_a_of_type_Int = 1;
          localLbsRequestStatus.jdField_a_of_type_Long = System.currentTimeMillis();
          LBSDetetor.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, localObject }), null);
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType == paramInt))
    {
      boolean bool = b(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(bool);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { ((StringBuilder)localObject).toString() }), null);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter != null) && (bool))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshed filterName=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name);
        a("sendLoadingFilterMsg", ((StringBuilder)localObject).toString(), null);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name);
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
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
    if (localPtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { localPtvTemplateInfo.getLbsActivityType(localPtvTemplateInfo.activityType) }), null);
      if (!this.jdField_b_of_type_Boolean) {
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
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
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
      localLbsRequestStatus.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.clear();
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
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
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
    if ((localLbsRequestStatus.jdField_a_of_type_Boolean) && (localLbsRequestStatus.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {
      paramInt = 3;
    } else {
      paramInt = 2;
    }
    a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.jdField_a_of_type_Int) }), null);
    return paramInt != this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */