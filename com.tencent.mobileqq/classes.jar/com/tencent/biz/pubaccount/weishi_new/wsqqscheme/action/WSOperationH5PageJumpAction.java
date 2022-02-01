package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import java.util.Map;

public class WSOperationH5PageJumpAction
  extends AbsWSJumpAction
{
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    return WeishiActivityHelper.a(paramContext, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSOperationH5PageJumpAction
 * JD-Core Version:    0.7.0.1
 */