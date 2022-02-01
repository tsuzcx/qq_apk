package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.qphone.base.util.QLog;

public class ComboSet
  extends CaptureSet
{
  public ComboSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return super.a(paramActivity, paramInt);
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    ComboSet localComboSet = localVideoFilterTools.e[paramInt];
    if ((localComboSet != null) && (localComboSet.h().equals(h()))) {
      localVideoFilterTools.a(null, paramActivity, paramInt);
    }
  }
  
  public void c(Activity paramActivity, int paramInt)
  {
    super.c(paramActivity, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select ");
      ((StringBuilder)localObject).append(toString());
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QIMFilterCategoryItem)this.e;
    VideoFilterTools.a().a((QIMFilterCategoryItem)localObject, paramActivity, paramInt);
    ((CaptureComboManager)com.tencent.aelight.camera.aioeditor.capture.QIMManager.a(5)).o[paramInt].a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject.hashCode() == hashCode();
  }
  
  public int hashCode()
  {
    return ((QIMFilterCategoryItem)this.e).a.hashCode();
  }
  
  public String toString()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQIMFilterCategoryItem.a);
    localStringBuilder.append(localQIMFilterCategoryItem.hashCode());
    localStringBuilder.append(localQIMFilterCategoryItem.i);
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboSet
 * JD-Core Version:    0.7.0.1
 */