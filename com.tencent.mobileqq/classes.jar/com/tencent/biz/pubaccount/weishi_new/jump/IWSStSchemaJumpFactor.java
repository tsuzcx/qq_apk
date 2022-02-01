package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

public abstract interface IWSStSchemaJumpFactor
{
  public abstract stSchema a();
  
  public abstract Context a();
  
  public abstract WSDownloadParams a();
  
  public abstract IJumpListener a();
  
  public abstract OuterInterceptManager.OnInterceptDialogClickListener a();
  
  public abstract MiniAppLaunchListener a();
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.IWSStSchemaJumpFactor
 * JD-Core Version:    0.7.0.1
 */