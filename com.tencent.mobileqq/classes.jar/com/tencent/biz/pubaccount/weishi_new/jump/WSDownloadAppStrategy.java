package com.tencent.biz.pubaccount.weishi_new.jump;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;

public class WSDownloadAppStrategy
  extends AbsWSJump
{
  public WSDownloadAppStrategy(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    super(paramIWSStSchemaJumpFactor);
  }
  
  public boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if (((paramIWSStSchemaJumpFactor.a() instanceof Activity)) && (paramIWSStSchemaJumpFactor.a() != null))
    {
      WeishiDownloadUtil.a((Activity)paramIWSStSchemaJumpFactor.a(), paramIWSStSchemaJumpFactor.a(), true);
      if (paramIWSStSchemaJumpFactor.a() != null) {
        paramIWSStSchemaJumpFactor.a().d();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSDownloadAppStrategy
 * JD-Core Version:    0.7.0.1
 */