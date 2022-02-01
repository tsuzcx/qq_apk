package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

class AEFilterAVWrapperImpl$MyInnerEffectListener
  implements AEFilterManager.MaterialInnerEffectListener
{
  public void notifyEnableLutType(int paramInt) {}
  
  public void notifyEnableMeshType(int paramInt) {}
  
  public void onDeviceNotSupportMaterial()
  {
    QLog.i("AEFilterAVWrapperImpl", 1, "onDeviceNotSupport called");
    String str2 = HardCodeUtil.a(2131893214);
    TipsInfo localTipsInfo = TipsInfo.a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    localTipsInfo.b(str1);
    TipsInfo.a().a(1500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyInnerEffectListener
 * JD-Core Version:    0.7.0.1
 */