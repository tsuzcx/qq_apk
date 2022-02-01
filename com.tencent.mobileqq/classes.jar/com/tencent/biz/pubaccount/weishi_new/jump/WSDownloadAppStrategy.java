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
    if (((paramIWSStSchemaJumpFactor.a() instanceof Activity)) && (paramIWSStSchemaJumpFactor.c() != null))
    {
      WeishiDownloadUtil.a((Activity)paramIWSStSchemaJumpFactor.a(), paramIWSStSchemaJumpFactor.c(), true);
      if (paramIWSStSchemaJumpFactor.h() != null) {
        paramIWSStSchemaJumpFactor.h().d();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSDownloadAppStrategy
 * JD-Core Version:    0.7.0.1
 */