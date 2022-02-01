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
  
  public void a(Activity paramActivity, int paramInt)
  {
    super.a(paramActivity, paramInt);
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    ComboSet localComboSet = localVideoFilterTools.a[paramInt];
    if ((localComboSet != null) && (localComboSet.b().equals(b()))) {
      localVideoFilterTools.a(null, paramActivity, paramInt);
    }
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
    VideoFilterTools.a().a((QIMFilterCategoryItem)localObject, paramActivity, paramInt);
    ((CaptureComboManager)com.tencent.aelight.camera.aioeditor.capture.QIMManager.a(5)).a[paramInt].a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject.hashCode() == hashCode();
  }
  
  public int hashCode()
  {
    return ((QIMFilterCategoryItem)this.a).a.hashCode();
  }
  
  public String toString()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQIMFilterCategoryItem.a);
    localStringBuilder.append(localQIMFilterCategoryItem.hashCode());
    localStringBuilder.append(localQIMFilterCategoryItem.g);
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboSet
 * JD-Core Version:    0.7.0.1
 */