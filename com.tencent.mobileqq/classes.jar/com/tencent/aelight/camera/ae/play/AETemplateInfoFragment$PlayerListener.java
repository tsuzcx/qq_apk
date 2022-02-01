package com.tencent.aelight.camera.ae.play;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import java.lang.ref.WeakReference;

class AETemplateInfoFragment$PlayerListener
  implements IVideoShelfPlayerListener
{
  private WeakReference<AETemplateInfoFragment> mRef;
  
  public AETemplateInfoFragment$PlayerListener(AETemplateInfoFragment paramAETemplateInfoFragment)
  {
    this.mRef = new WeakReference(paramAETemplateInfoFragment);
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onCompletion()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onCompletion");
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AETemplateInfoFragment)this.mRef.get()).onPlayComplete();
    }
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("[player lifecycle]---PlayerListener onError errCode=");
    paramObject.append(paramInt);
    paramObject.append(", msg=");
    paramObject.append(paramString);
    QLog.i("AETemplateInfoFragment", 1, paramObject.toString());
    paramString = this.mRef;
    if ((paramString != null) && (paramString.get() != null)) {
      AETemplateInfoFragment.access$600((AETemplateInfoFragment)this.mRef.get());
    }
    return true;
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer) {}
  
  public void onUpdateRate(long paramLong)
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AETemplateInfoFragment)this.mRef.get()).onUpdateRate(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.PlayerListener
 * JD-Core Version:    0.7.0.1
 */