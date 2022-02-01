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
  protected final Set<WeakReference<ArkViewModelBase>> mArkViewModels = new HashSet();
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
      Logger.logE(TAG, "addArkView fail:arkViewModel is null");
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
      Logger.logE(TAG, "state is in backGround");
    }
    return this.mIsForeground;
  }
  
  public void setForeground(boolean paramBoolean)
  {
    Set localSet = this.mArkViewModels;
    if (paramBoolean) {}
    try
    {
      Logger.logE(TAG, "ark state change to foreground");
      break label30;
      Logger.logE(TAG, "ark state change to  background");
      label30:
      this.mIsForeground = paramBoolean;
      Iterator localIterator = this.mArkViewModels.iterator();
      while (localIterator.hasNext())
      {
        ArkViewModelBase localArkViewModelBase = (ArkViewModelBase)((WeakReference)localIterator.next()).get();
        if (localArkViewModelBase != null)
        {
          localArkViewModelBase.setForeground(paramBoolean);
        }
        else
        {
          Logger.logE(TAG, "arkViewModel has release");
          localIterator.remove();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setStateInterface(ArkStateCenter.ArkStateInterface paramArkStateInterface)
  {
    Logger.logE(TAG, String.format("setStateInterface %h", new Object[] { paramArkStateInterface }));
    this.mStateInterface = paramArkStateInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkStateCenter
 * JD-Core Version:    0.7.0.1
 */