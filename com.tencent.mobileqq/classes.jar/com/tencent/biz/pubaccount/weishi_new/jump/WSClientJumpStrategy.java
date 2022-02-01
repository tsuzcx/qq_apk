package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;

public class WSClientJumpStrategy
  extends AbsWSJump
{
  public WSClientJumpStrategy(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    super(paramIWSStSchemaJumpFactor);
  }
  
  private void a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if ((paramIWSStSchemaJumpFactor.a() instanceof Activity))
    {
      OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = paramIWSStSchemaJumpFactor.a();
      OuterInterceptManager.a((Activity)paramIWSStSchemaJumpFactor.a(), new WSClientJumpStrategy.1(this, paramIWSStSchemaJumpFactor, localOnInterceptDialogClickListener));
    }
  }
  
  private void b(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    String str;
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.a().schema)) {
      str = paramIWSStSchemaJumpFactor.a().schema;
    } else {
      str = "weishi://main";
    }
    WeishiScehmeUtil.a(paramIWSStSchemaJumpFactor.a(), "biz_src_jc_gzh_weishi", str);
    if (paramIWSStSchemaJumpFactor.a() != null) {
      paramIWSStSchemaJumpFactor.a().a();
    }
  }
  
  public boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if (paramIWSStSchemaJumpFactor.a()) {
      a(paramIWSStSchemaJumpFactor);
    } else {
      b(paramIWSStSchemaJumpFactor);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSClientJumpStrategy
 * JD-Core Version:    0.7.0.1
 */