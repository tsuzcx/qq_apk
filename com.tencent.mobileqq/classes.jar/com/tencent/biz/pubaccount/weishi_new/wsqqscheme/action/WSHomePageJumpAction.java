package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSPublicAccLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import java.util.Map;

public class WSHomePageJumpAction
  extends AbsWSJumpAction
{
  private void a(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("feed_id");
    WeishiActivityHelper.a(paramContext, new WSPublicAccLaunchParams(this.c, 0, false).a(paramMap));
  }
  
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramContext, paramMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSHomePageJumpAction
 * JD-Core Version:    0.7.0.1
 */