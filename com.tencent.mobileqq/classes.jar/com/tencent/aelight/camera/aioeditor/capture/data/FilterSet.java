package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterSet
  extends CaptureSet
{
  public FilterSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apply ");
      ((StringBuilder)localObject1).append(toString());
      QLog.i("QCombo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (CaptureComboBase)((Iterator)localObject2).next();
      if ((localObject3 instanceof CaptureComboFilter)) {
        ((List)localObject1).add(((CaptureComboFilter)localObject3).a);
      }
    }
    ((CaptureComboManager)com.tencent.aelight.camera.aioeditor.capture.QIMManager.a(5)).a[paramInt].a(this);
    localObject2 = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().a((QIMFilterCategoryItem)localObject2, paramInt);
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("setApplyedFilterGroup");
      ((StringBuilder)localObject3).append(((QIMFilterCategoryItem)localObject2).b);
      QLog.i("QCombo", 2, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 != null) && ("AIFilter".equals(((QIMFilterCategoryItem)localObject2).a))) {
      return 0;
    }
    CaptureComboFilter.a(paramActivity, (List)localObject1, this, paramInt);
    return 0;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (CaptureComboBase)localIterator.next();
      if ((localObject instanceof CaptureComboFilter))
      {
        localObject = ((CaptureComboFilter)localObject).a;
        if ((localObject != null) && (((FilterDesc)localObject).predownload == 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select ");
      ((StringBuilder)localObject).append(toString());
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().b((QIMFilterCategoryItem)localObject, paramActivity, paramInt);
  }
  
  public int d()
  {
    Iterator localIterator = this.b.iterator();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      j = ((CaptureComboBase)localIterator.next()).a;
      if (j == 2)
      {
        j = 1;
        break;
      }
      if (j == 1) {
        i = 1;
      }
    }
    if (j != 0)
    {
      b(2);
      return 2;
    }
    if (i != 0)
    {
      b(2);
      return 1;
    }
    b(3);
    return 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Filter");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.FilterSet
 * JD-Core Version:    0.7.0.1
 */