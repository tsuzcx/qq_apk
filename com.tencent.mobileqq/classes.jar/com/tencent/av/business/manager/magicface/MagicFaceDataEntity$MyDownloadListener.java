package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.pendant.PendantItem;

class MagicFaceDataEntity$MyDownloadListener
  implements EffectConfigBase.IEffectConfigCallback<PendantItem>
{
  MagicFaceDataEntity$MyDownloadListener(MagicFaceDataEntity paramMagicFaceDataEntity) {}
  
  public void a(long paramLong, PendantItem paramPendantItem) {}
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish: ");
    localStringBuilder.append(paramPendantItem.toString());
    localStringBuilder.append("|");
    localStringBuilder.append(paramBoolean);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    if (paramBoolean) {
      MagicFaceDataEntity.a(this.a, paramLong, paramPendantItem);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.MyDownloadListener
 * JD-Core Version:    0.7.0.1
 */