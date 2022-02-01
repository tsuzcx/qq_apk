package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;
import mqq.util.WeakReference;

class AEFilterAVWrapperImpl$MyTipsListener
  implements LightNode.ILightNodeTipsListener
{
  private final WeakReference<AEFilterAVWrapperImpl> a;
  
  AEFilterAVWrapperImpl$MyTipsListener(AEFilterAVWrapperImpl paramAEFilterAVWrapperImpl)
  {
    this.a = new WeakReference(paramAEFilterAVWrapperImpl);
  }
  
  private void a(String paramString)
  {
    if ((AEFilterAVWrapperImpl)this.a.get() == null) {}
    do
    {
      return;
      TipsInfo.a().e();
    } while (!QLog.isColorLevel());
    QLog.i("AEFilterAVWrapperImpl", 2, "hideGestureTips, from[" + paramString + "]");
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = (AEFilterAVWrapperImpl)this.a.get();
    if (localObject == null) {
      return;
    }
    localObject = AEFilterAVWrapperImpl.a((AEFilterAVWrapperImpl)localObject);
    String str;
    if (localObject != null)
    {
      str = ((PendantItem)localObject).getGestureType();
      if (TextUtils.isEmpty(paramString2)) {
        localObject = ((PendantItem)localObject).getGestureWording();
      }
    }
    for (;;)
    {
      TipsInfo.a().b((String)localObject, str);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 2, "showGestureTips, wording[" + paramString2 + "], gestureType[" + str + "], gestureWording[" + (String)localObject + "], from[" + paramString1 + "]");
      return;
      localObject = paramString2;
      continue;
      str = "";
      localObject = paramString2;
    }
  }
  
  public void onHideNormalTip()
  {
    a("onHideNormalTip");
  }
  
  public void onHidePagTip()
  {
    a("onHidePagTip");
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    a("onShowNormalTip", paramString1);
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    a("onShowPagTip", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyTipsListener
 * JD-Core Version:    0.7.0.1
 */