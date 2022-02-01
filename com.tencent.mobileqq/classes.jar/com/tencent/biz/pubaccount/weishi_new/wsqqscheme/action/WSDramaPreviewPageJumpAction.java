package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import java.util.Map;

public class WSDramaPreviewPageJumpAction
  extends AbsWSJumpAction
{
  private void a(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("drama_id");
    WSDramaPageFragment.a(new WSDramaPageIntentParams(this.c, paramContext).a(paramMap));
  }
  
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramContext, paramMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSDramaPreviewPageJumpAction
 * JD-Core Version:    0.7.0.1
 */