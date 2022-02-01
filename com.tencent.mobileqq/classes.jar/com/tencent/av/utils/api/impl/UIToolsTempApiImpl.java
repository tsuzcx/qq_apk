package com.tencent.av.utils.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.avcore.util.AVCoreUtil;

public class UIToolsTempApiImpl
  extends AVCoreUtil
  implements IUIToolsTempApi
{
  private static final String TAG = "UIToolsApiImpl";
  
  public float dp2px(Context paramContext, float paramFloat)
  {
    return paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public int uinType2AVRelationType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1011)
        {
          if (paramInt != 3000) {
            return 0;
          }
          return 2;
        }
        return 7;
      }
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.UIToolsTempApiImpl
 * JD-Core Version:    0.7.0.1
 */