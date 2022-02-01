package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.richmedia.capture.data.FilterDesc;>;

public class CaptureComboFilter
  extends CaptureComboBase
{
  public float a;
  CaptureComboFilter.MyDownloaderListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboFilter$MyDownloaderListener = new CaptureComboFilter.MyDownloaderListener(this);
  FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  public boolean a;
  
  public CaptureComboFilter(FilterDesc paramFilterDesc)
  {
    super(paramFilterDesc);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
  }
  
  public static int a(Context paramContext, List<FilterDesc> paramList, CaptureSet paramCaptureSet, int paramInt)
  {
    if (paramInt == 0)
    {
      a(paramContext, paramList);
      return 0;
    }
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramInt != 2) && (paramInt != 4))
    {
      if ((paramInt == 1) || (paramInt == 3))
      {
        if (paramInt != 1) {
          bool1 = false;
        }
        b(paramList, bool1);
        return 0;
      }
    }
    else
    {
      if (paramInt == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      c(paramList, bool1);
    }
    return 0;
  }
  
  public static void a(Context paramContext, List<FilterDesc> paramList)
  {
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.b);
    if ((localQQFilterRenderManager == null) && (((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      paramContext = (Context)localObject;
      if (!paramList.hasNext()) {
        break;
      }
      paramContext = (FilterDesc)paramList.next();
      if (paramContext.name.equals("EMPTY"))
      {
        if (!((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty())
        {
          ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
          ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(null);
        }
        paramContext = null;
        break;
      }
      if (paramContext.id == 9)
      {
        ((List)localObject).clear();
        ((List)localObject).add(paramContext);
        paramContext = (Context)localObject;
        break;
      }
      ((List)localObject).add(paramContext);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("applyFiltersForCapture filters:");
      int i;
      if (paramContext == null) {
        i = 0;
      } else {
        i = paramContext.size();
      }
      paramList.append(i);
      QLog.d("QCombo", 2, paramList.toString());
    }
    localVideoFilterTools.a(null);
    if (localQQFilterRenderManager != null) {
      localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramContext);
    }
    if ((!((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()) && (paramContext != null) && (paramContext.size() > 0))
    {
      paramList = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
      paramContext = (FilterDesc)paramContext.get(0);
      if (!TextUtils.isEmpty(paramContext.resRootPath)) {
        paramContext = paramContext.getResFold(paramContext.resRootPath);
      } else {
        paramContext = paramContext.getResFold(paramList);
      }
      paramList = QQPtColorFilter.getColorFilterInfo(paramContext);
      if (paramList != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(paramList.getColorPng());
        paramContext = ((StringBuilder)localObject).toString();
        if (new File(paramContext).exists())
        {
          ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
          ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(paramContext);
        }
      }
    }
  }
  
  public static void a(List<FilterDesc> paramList, boolean paramBoolean)
  {
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.b);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = (List<FilterDesc>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (FilterDesc)localIterator.next();
      if (paramList.name.equals("EMPTY"))
      {
        paramList = null;
        break;
      }
      if (paramList.id == 9)
      {
        ((List)localObject).clear();
        ((List)localObject).add(paramList);
        paramList = (List<FilterDesc>)localObject;
        break;
      }
      ((List)localObject).add(paramList);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("applyFiltersForCapture filters:");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    localVideoFilterTools.a(null);
    localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList, paramBoolean);
  }
  
  public static boolean a(ComboSet paramComboSet, int paramInt)
  {
    boolean bool2;
    if (paramComboSet != null)
    {
      Object localObject = VideoFilterTools.a().a[paramInt];
      boolean bool1;
      if ((paramComboSet != null) && (localObject != null) && (paramComboSet.b().equals(((ComboSet)localObject).b()))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isApplying :");
        ((StringBuilder)localObject).append(paramComboSet);
        ((StringBuilder)localObject).append(" ");
        QLog.d("QCombo", 2, new Object[] { ((StringBuilder)localObject).toString(), Boolean.valueOf(bool1) });
        return bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public static void b(List<FilterDesc> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      bool2 = paramList.hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
      FilterDesc localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.name.equals("EMPTY"))
      {
        localArrayList.clear();
        bool2 = false;
        break label120;
      }
      if (localFilterDesc.id == 9)
      {
        localArrayList.clear();
        localArrayList.add(localFilterDesc);
        bool1 = true;
        break label112;
      }
      localArrayList.add(localFilterDesc);
    }
    boolean bool1 = false;
    label112:
    boolean bool3 = false;
    boolean bool2 = bool1;
    bool1 = bool3;
    label120:
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("applyFiltersForEditPic filters:");
      paramList.append(localArrayList.size());
      QLog.d("QCombo", 2, paramList.toString());
    }
    new CaptureComboFilter.1(bool1, bool2, localArrayList, paramBoolean).execute(new Void[0]);
  }
  
  public static void c(List<FilterDesc> paramList, boolean paramBoolean)
  {
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditVideo null manager");
      }
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = (List<FilterDesc>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (FilterDesc)localIterator.next();
      if (paramList.name.equals("EMPTY"))
      {
        paramList = null;
        break;
      }
      if (paramList.id == 9)
      {
        ((List)localObject).clear();
        ((List)localObject).add(paramList);
        paramList = (List<FilterDesc>)localObject;
        break;
      }
      ((List)localObject).add(paramList);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("applyFiltersForEditVideo filters:");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    localQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
    localVideoFilterTools.a(null);
  }
  
  public float a()
  {
    return 0.5F;
  }
  
  public int a()
  {
    float f = this.jdField_a_of_type_Float;
    if (f == 1.0F)
    {
      b(3);
      return 3;
    }
    if (f >= 0.0F)
    {
      b(1);
      return 1;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.getResFold(CaptureVideoFilterManager.b);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.resurl)) && (!TextUtils.isEmpty(str)) && (VideoFilterListDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc)))
    {
      b(2);
      return 2;
    }
    b(3);
    return 3;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      paramActivity = new ArrayList();
      paramActivity.add(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      a(paramActivity, false);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.predownload);
      localStringBuilder.append(", iconurl: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.iconurl);
      localStringBuilder.append(", resurl:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.resurl);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    VideoFilterListDownloader.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureComboFilter$MyDownloaderListener);
    a();
    return super.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Filter@");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.name);
    localStringBuilder.append("@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboFilter
 * JD-Core Version:    0.7.0.1
 */