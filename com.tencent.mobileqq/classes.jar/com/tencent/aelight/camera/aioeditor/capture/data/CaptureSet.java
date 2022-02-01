package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class CaptureSet
  extends CaptureComboBase
  implements CaptureComboDownloadListener
{
  float jdField_a_of_type_Float = 1.0F;
  public long a;
  public WeakReference<Activity> a;
  private final CopyOnWriteArraySet<CaptureComboBase> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public boolean a;
  public ArrayList<CaptureComboBase> b = new ArrayList();
  
  public CaptureSet(Object paramObject)
  {
    super(paramObject);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public float a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
        f2 = localCaptureComboBase.a();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getProgress ");
          localStringBuilder.append(localCaptureComboBase.toString());
          localStringBuilder.append(" progress =");
          localStringBuilder.append(f2);
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        f3 = this.jdField_a_of_type_Float;
      }
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public int a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("getState = ");
      localStringBuilder.append(toString());
      localStringBuilder.append("  ");
    }
    else
    {
      localStringBuilder = null;
    }
    Iterator localIterator = this.b.iterator();
    int j;
    do
    {
      boolean bool = localIterator.hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
      i = localCaptureComboBase.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(i);
        localStringBuilder.append("|");
        localStringBuilder.append(localCaptureComboBase.toString());
        localStringBuilder.append("   ");
      }
      if (i == 2)
      {
        i = 0;
        j = 1;
        break label146;
      }
    } while (i != 1);
    int i = 1;
    break label146;
    i = 0;
    label146:
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (j != 0)
    {
      b(2);
      return 2;
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_Int != 1) {
        b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 60000L)
      {
        b(2);
        a(5);
        return 2;
      }
      return 1;
    }
    b(3);
    return 3;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    boolean bool = this instanceof ComboSet;
    Object localObject3;
    if (bool)
    {
      localObject1 = (ComboSet)this;
      if (CaptureComboFilter.a((ComboSet)localObject1, paramInt))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apply already");
          ((StringBuilder)localObject2).append(toString());
          QLog.i("QCombo", 2, ((StringBuilder)localObject2).toString());
        }
        VideoFilterTools.a().a((ComboSet)localObject1, paramActivity, paramInt);
        return 0;
      }
      localObject3 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject;
      if ((localObject3 != null) && (paramInt == 0))
      {
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ("back".equals(((QIMFilterCategoryItem)localObject3).g))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(CameraControl.b, 2);
          ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
        }
        else if (("front".equals(((QIMFilterCategoryItem)localObject3).g)) && (CameraAbility.c()))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(CameraControl.b, 1);
          ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
        }
      }
      localObject2 = VideoFilterTools.a().a[paramInt];
      if (localObject2 != null) {
        ((ComboSet)localObject2).a(paramActivity, paramInt);
      }
      VideoFilterTools.a().a((ComboSet)localObject1, paramActivity, paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apply ");
      ((StringBuilder)localObject1).append(toString());
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("QCombo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (CaptureComboBase)((Iterator)localObject2).next();
      if ((localObject3 instanceof CaptureComboFilter)) {
        ((List)localObject1).add(((CaptureComboFilter)localObject3).a);
      } else {
        ((CaptureComboBase)localObject3).a(paramActivity, paramInt);
      }
    }
    if (bool)
    {
      localObject2 = (CaptureComboManager)QIMManager.a(5);
      if (!localObject2.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[paramInt].a())
      {
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("apply ");
          paramActivity.append(toString());
          paramActivity.append(", ");
          paramActivity.append(paramInt);
          paramActivity.append(" comboApplyFilterAborted");
          QLog.i("QCombo", 2, paramActivity.toString());
        }
        return 0;
      }
      localObject2.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[paramInt].a(null);
      localObject3 = ((CaptureComboManager)localObject2).jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
      if (localObject3 != null)
      {
        localObject2 = ((CaptureComboManager)localObject2).a((ComboSet)this, ((VideoFilterTools.ComboFilterData)localObject3).a(paramInt).c);
        VideoFilterTools.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
        VideoFilterTools.a().a((QIMFilterCategoryItem)localObject2, paramInt);
        CaptureComboFilter.a(paramActivity, (List)localObject1, this, paramInt);
        if (((this.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) && (((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).b()) && (paramInt != 1) && (paramInt != 3)) {
          ((QimMusicPlayer)QIMManager.a().c(8)).a(paramInt);
        }
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unApply ");
      ((StringBuilder)localObject).append(toString());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CaptureComboBase)((Iterator)localObject).next()).a(paramActivity, paramInt);
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase)
  {
    if (QLog.isColorLevel())
    {
      paramCaptureComboBase = new StringBuilder();
      paramCaptureComboBase.append("onDownloadStart ");
      paramCaptureComboBase.append(toString());
      paramCaptureComboBase.append(", count=");
      paramCaptureComboBase.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
      QLog.i("QCombo", 2, paramCaptureComboBase.toString());
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError ");
      localStringBuilder.append(toString());
      localStringBuilder.append(":");
      localStringBuilder.append(paramCaptureComboBase.toString());
      localStringBuilder.append(", count=");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      b(2);
      a(paramInt);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download ");
      localStringBuilder.append(toString());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      a(6);
      return 2;
    }
    ThreadManager.getSubThreadHandler().post(new CaptureSet.1(this));
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return ((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    super.b();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(CaptureComboBase paramCaptureComboBase)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadSuccess= ");
      localStringBuilder.append(toString());
      localStringBuilder.append(":");
      localStringBuilder.append(paramCaptureComboBase.toString());
      localStringBuilder.append(", count=");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
      QLog.i("QCombo", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        b(2);
        a(4);
        return;
      }
      b(3);
      if (QLog.isColorLevel())
      {
        paramCaptureComboBase = new StringBuilder();
        paramCaptureComboBase.append("onDownloadFinish= ");
        paramCaptureComboBase.append(toString());
        paramCaptureComboBase.append(", count=");
        paramCaptureComboBase.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
        QLog.i("QCombo", 2, paramCaptureComboBase.toString());
      }
      b();
    }
  }
  
  public int c()
  {
    Object localObject = this.b.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)((Iterator)localObject).next();
      StringBuilder localStringBuilder;
      if (localCaptureComboBase.a() == 2)
      {
        localCaptureComboBase.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localCaptureComboBase);
        localCaptureComboBase.b();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download ");
          localStringBuilder.append(toString());
          localStringBuilder.append("  ");
          localStringBuilder.append(localCaptureComboBase.toString());
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        j = 1;
      }
      else if (localCaptureComboBase.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localCaptureComboBase);
        localCaptureComboBase.a(this);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloading ");
          localStringBuilder.append(toString());
          localStringBuilder.append(":");
          localStringBuilder.append(localCaptureComboBase.toString());
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        i = 1;
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
    {
      b(1);
      a();
      localObject = (CaptureComboManager)QIMManager.b(5);
      if (localObject != null) {
        ((CaptureComboManager)localObject).b(this);
      }
    }
    if ((j == 0) && (i == 0))
    {
      b(3);
      b();
      return 3;
    }
    b(1);
    return 1;
  }
  
  public void c(CaptureComboBase paramCaptureComboBase)
  {
    this.b.add(paramCaptureComboBase);
    this.jdField_a_of_type_Float = (1.0F / this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet
 * JD-Core Version:    0.7.0.1
 */