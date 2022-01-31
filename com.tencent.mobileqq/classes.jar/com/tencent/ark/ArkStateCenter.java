package com.tencent.ark;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArkStateCenter
{
  protected static String TAG = "ArkApp.ArkStateCenter";
  protected static ArkStateCenter mArkStateCenter = new ArkStateCenter();
  protected final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
  protected Set<WeakReference<ArkViewModelBase>> mArkViewModels = new HashSet();
  protected boolean mIsForeground = true;
  protected ArkStateCenter.ArkStateInterface mStateInterface = null;
  
  public static ArkStateCenter getInstance()
  {
    return mArkStateCenter;
  }
  
  public void addArkViewModel(ArkViewModelBase paramArkViewModelBase)
  {
    if (paramArkViewModelBase == null)
    {
      this.ENV.logE(TAG, "addArkView fail:arkViewModel is null");
      return;
    }
    WeakReference localWeakReference = new WeakReference(paramArkViewModelBase);
    synchronized (this.mArkViewModels)
    {
      paramArkViewModelBase.setForeground(this.mIsForeground);
      this.mArkViewModels.add(localWeakReference);
      return;
    }
  }
  
  public boolean isForeground()
  {
    if (!this.mIsForeground) {
      this.ENV.logE(TAG, "state is in backGround");
    }
    return this.mIsForeground;
  }
  
  public void setForeground(boolean paramBoolean)
  {
    Set localSet = this.mArkViewModels;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.ENV.logE(TAG, "ark state change to foreground");
        this.mIsForeground = paramBoolean;
        Iterator localIterator = this.mArkViewModels.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ArkViewModelBase localArkViewModelBase = (ArkViewModelBase)((WeakReference)localIterator.next()).get();
        if (localArkViewModelBase == null) {
          break label98;
        }
        localArkViewModelBase.setForeground(paramBoolean);
        continue;
        this.ENV.logE(TAG, "ark state change to  background");
      }
      finally {}
      continue;
      label98:
      this.ENV.logE(TAG, "arkViewModel has release");
      localObject.remove();
    }
  }
  
  public void setStateInterface(ArkStateCenter.ArkStateInterface paramArkStateInterface)
  {
    this.ENV.logE(TAG, String.format("setStateInterface %h", new Object[] { paramArkStateInterface }));
    this.mStateInterface = paramArkStateInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkStateCenter
 * JD-Core Version:    0.7.0.1
 */