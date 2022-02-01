package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

public abstract interface IWSStSchemaJumpFactor
{
  public abstract Context a();
  
  public abstract stSchema b();
  
  public abstract WSDownloadParams c();
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract MiniAppLaunchListener f();
  
  public abstract OuterInterceptManager.OnInterceptDialogClickListener g();
  
  public abstract IJumpListener h();
  
  public abstract Object i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.IWSStSchemaJumpFactor
 * JD-Core Version:    0.7.0.1
 */