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
    Object localObject1 = a(this.a, paramInt, paramString);
    int i = ((Integer)((Pair)localObject1).first).intValue();
    int j = ((Integer)((Pair)localObject1).second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == 2147483647) {}
    try
    {
      localObject1 = a(i, paramString);
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable faceDrawable = " + localObject1 + ", uin = " + paramString);
        }
        return localObject1;
        if (i != -2147483648)
        {
          if (paramInt == 1008) {
            localObject1 = a(paramString, 115);
          } else {
            localObject1 = a(paramString, i);
          }
        }
        else
        {
          if ((j == -2147483648) || (!paramBoolean)) {
            break;
          }
          localObject1 = BaseApplication.getContext().getResources().getDrawable(j);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentServiceAccountFaceDecoder
 * JD-Core Version:    0.7.0.1
 */