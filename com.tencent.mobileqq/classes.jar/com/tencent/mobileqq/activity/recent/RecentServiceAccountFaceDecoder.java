package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentServiceAccountFaceDecoder
  extends RecentFaceDecoder
{
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = a(this.a, paramInt, paramString);
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceDrawable uintype = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isGetResFace = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", faceType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", faceResId = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = null;
    if (j == 2147483647) {}
    label304:
    try
    {
      localObject = a(i, paramString);
    }
    catch (Exception localException)
    {
      label235:
      break label235;
    }
    if (i != -2147483648)
    {
      if (paramInt == 1008) {
        localObject = a(paramString, 115);
      } else {
        localObject = a(paramString, i);
      }
    }
    else
    {
      localObject = localStringBuilder;
      if (j != -2147483648)
      {
        localObject = localStringBuilder;
        if (paramBoolean)
        {
          localObject = BaseApplication.getContext().getResources().getDrawable(j);
          break label304;
          ((Exception)localObject).printStackTrace();
          localObject = localStringBuilder;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFaceDrawable faceDrawable = ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", uin = ");
        localStringBuilder.append(paramString);
        QLog.d("RecentFaceDecoder", 2, localStringBuilder.toString());
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentServiceAccountFaceDecoder
 * JD-Core Version:    0.7.0.1
 */