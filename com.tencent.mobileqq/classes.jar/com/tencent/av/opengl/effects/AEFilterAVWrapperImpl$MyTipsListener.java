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
    if ((AEFilterAVWrapperImpl)this.a.get() == null) {
      return;
    }
    TipsInfo.a().g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideGestureTips, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject1 = (AEFilterAVWrapperImpl)this.a.get();
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = AEFilterAVWrapperImpl.a((AEFilterAVWrapperImpl)localObject1);
    if (localObject3 != null)
    {
      localObject2 = ((PendantItem)localObject3).getGestureType();
      localObject1 = localObject2;
      if (TextUtils.isEmpty(paramString2))
      {
        localObject1 = ((PendantItem)localObject3).getGestureWording();
        break label65;
      }
    }
    else
    {
      localObject1 = "";
    }
    localObject3 = paramString2;
    Object localObject2 = localObject1;
    localObject1 = localObject3;
    label65:
    TipsInfo.a().b((String)localObject1, (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("showGestureTips, wording[");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append("], gestureType[");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("], gestureWording[");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("], from[");
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("]");
      QLog.i("AEFilterAVWrapperImpl", 2, ((StringBuilder)localObject3).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyTipsListener
 * JD-Core Version:    0.7.0.1
 */