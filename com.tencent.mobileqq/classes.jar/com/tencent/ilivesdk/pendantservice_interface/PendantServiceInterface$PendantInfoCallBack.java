package com.tencent.ilivesdk.pendantservice_interface;

import com.tencent.ilivesdk.pendantservice_interface.model.PendantServiceBean;
import java.util.ArrayList;

public abstract interface PendantServiceInterface$PendantInfoCallBack
{
  public abstract void onError(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onRecv(ArrayList<PendantServiceBean> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pendantservice_interface.PendantServiceInterface.PendantInfoCallBack
 * JD-Core Version:    0.7.0.1
 */