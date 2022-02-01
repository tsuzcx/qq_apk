package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.light.listener.LightAssetListener;

class AEFilterAVWrapperImpl$MyLightAssetListener
  implements LightAssetListener
{
  private boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != -200)
    {
      if (paramInt != -100)
      {
        if (paramInt != 0) {
          paramInt = 2131893214;
        } else {
          paramInt = 0;
        }
      }
      else {
        paramInt = 2131893221;
      }
    }
    else {
      paramInt = 2131893213;
    }
    if (paramInt != 0) {
      return HardCodeUtil.a(paramInt);
    }
    return null;
  }
  
  public void OnAssetProcessing(HashMap<String, String> paramHashMap)
  {
    QLog.i("AEFilterAVWrapperImpl", 2, "OnAssetProcessing");
  }
  
  public void OnLoadAssetError(int paramInt)
  {
    if (a(paramInt))
    {
      String str = b(paramInt);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnLoadAssetError: errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" error tips is ");
      ((StringBuilder)localObject).append(str);
      QLog.i("AEFilterAVWrapperImpl", 1, ((StringBuilder)localObject).toString());
      TipsInfo localTipsInfo = TipsInfo.a();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      localTipsInfo.b((String)localObject);
      TipsInfo.a().a(1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyLightAssetListener
 * JD-Core Version:    0.7.0.1
 */