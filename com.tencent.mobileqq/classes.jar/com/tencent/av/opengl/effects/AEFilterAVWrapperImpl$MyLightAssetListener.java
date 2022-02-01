package com.tencent.av.opengl.effects;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AEFilterAVWrapperImpl$MyLightAssetListener
  implements LightAssetListener
{
  private static String a(int paramInt)
  {
    if (paramInt != -800)
    {
      if (paramInt != -700)
      {
        if (paramInt != -600)
        {
          if (paramInt != -500)
          {
            if (paramInt != -400)
            {
              if (paramInt != -300)
              {
                if (paramInt != -200)
                {
                  if (paramInt != -100)
                  {
                    if (paramInt != 0) {
                      paramInt = 2131689752;
                    } else {
                      paramInt = 0;
                    }
                  }
                  else {
                    paramInt = 2131689744;
                  }
                }
                else {
                  paramInt = 2131689746;
                }
              }
              else {
                paramInt = 2131689745;
              }
            }
            else {
              paramInt = 2131689751;
            }
          }
          else {
            paramInt = 2131689750;
          }
        }
        else {
          paramInt = 2131689747;
        }
      }
      else {
        paramInt = 2131689749;
      }
    }
    else {
      paramInt = 2131689748;
    }
    if (paramInt != 0) {
      return HardCodeUtil.a(paramInt);
    }
    return null;
  }
  
  private boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    QLog.i("AEFilterAVWrapperImpl", 2, "OnAssetProcessing");
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    if (a(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnLoadAssetError: errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error reason is ");
      localStringBuilder.append(a(paramInt));
      QLog.i("AEFilterAVWrapperImpl", 1, localStringBuilder.toString());
      TipsInfo.a().b(BaseApplication.getContext().getString(2131695460));
      TipsInfo.a().a(1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyLightAssetListener
 * JD-Core Version:    0.7.0.1
 */