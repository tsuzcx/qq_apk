package com.tencent.ilivesdk.linkmicavservice_interface;

import android.view.ViewGroup;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LinkMicAvServiceInterface
  extends ServiceBaseInterface
{
  public abstract int getCurrentLinkMicCount();
  
  public abstract void init(LinkMicAvServiceAdapter paramLinkMicAvServiceAdapter);
  
  public abstract void setLinkMicMute(boolean paramBoolean);
  
  public abstract void startLinkMicAv(LinkMicAvInfo paramLinkMicAvInfo, ViewGroup paramViewGroup);
  
  public abstract void startUpload(LinkMicAvInfo paramLinkMicAvInfo, ViewGroup paramViewGroup);
  
  public abstract void stopLinkMicAv(LinkMicAvInfo paramLinkMicAvInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvServiceInterface
 * JD-Core Version:    0.7.0.1
 */